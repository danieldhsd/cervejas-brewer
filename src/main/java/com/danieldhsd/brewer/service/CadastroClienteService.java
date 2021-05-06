package com.danieldhsd.brewer.service;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danieldhsd.brewer.model.Cidade;
import com.danieldhsd.brewer.model.Cliente;
import com.danieldhsd.brewer.repository.Cidades;
import com.danieldhsd.brewer.repository.Clientes;
import com.danieldhsd.brewer.service.exception.CpfCnpjClienteJaCadastradoException;
import com.danieldhsd.brewer.service.exception.ImpossivelExcluirEntidadeException;

@Service
public class CadastroClienteService {

	@Autowired
	private Clientes clientes;
	
	@Autowired
	private Cidades cidades;
	
	@Transactional
	public void salvar(Cliente cliente) {
		if (cliente.isNovo()) {
			this.clientes.findByCpfOuCnpj(cliente.getCpfOuCnpjSemFormatacao())
						 .ifPresent(c -> {
							 throw new CpfCnpjClienteJaCadastradoException("CPF/CNPJ já cadastrado"); 
						 });
		}

		this.clientes.save(cliente);
	}
	
	@Transactional(readOnly = true)
	public void comporDadosEndereco(Cliente cliente) {
		if (cliente.getEndereco() == null 
				|| cliente.getEndereco().getCidade() == null
				|| cliente.getEndereco().getCidade().getCodigo() == null) {
			return;
		}

		Cidade cidade = this.cidades.findByCodigoFetchingEstado(cliente.getEndereco().getCidade().getCodigo());

		cliente.getEndereco().setCidade(cidade);
		cliente.getEndereco().setEstado(cidade.getEstado());
	}

	@Transactional
	public void excluir(Cliente cliente) {
		try {
			this.clientes.delete(cliente);
			this.clientes.flush();
		} catch (PersistenceException e) {
			throw new ImpossivelExcluirEntidadeException("Impossível apagar cliente. Já está atrelado a alguma venda.");
		}
	}
}
