package com.danieldhsd.brewer.service;

import java.util.Optional;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danieldhsd.brewer.model.Cidade;
import com.danieldhsd.brewer.repository.Cidades;
import com.danieldhsd.brewer.service.exception.ImpossivelExcluirEntidadeException;
import com.danieldhsd.brewer.service.exception.NomeCidadeJaCadastradaException;

@Service
public class CadastroCidadeService {

	@Autowired
	private Cidades cidades;
	
	@Transactional
	public void salvar(Cidade cidade) {
		Optional<Cidade> cidadeExistente = cidades.findByNomeAndEstado(cidade.getNome(), cidade.getEstado());
		
		if(cidadeExistente.isPresent())
			throw new NomeCidadeJaCadastradaException("Nome de cidade já cadastrado");
		
		cidades.save(cidade);
	}
	
	@Transactional
	public void excluir(Cidade cidade) {
		try {
			this.cidades.delete(cidade);
			this.cidades.flush();
		} catch (PersistenceException e) {
			throw new ImpossivelExcluirEntidadeException("Impossível apagar cidade. O registro está sendo usado.");
		}
	}
}
