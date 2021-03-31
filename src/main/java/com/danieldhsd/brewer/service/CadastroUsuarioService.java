package com.danieldhsd.brewer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danieldhsd.brewer.model.Usuario;
import com.danieldhsd.brewer.repository.Usuarios;
import com.danieldhsd.brewer.service.exception.EmailJaCadastradoException;

@Service
public class CadastroUsuarioService {

	@Autowired
	private Usuarios usuarios;
	
	@Transactional
	public void salvar(Usuario usuario) {
		Optional<Usuario> usuarioExistente = usuarios.findByEmail(usuario.getEmail());
		
		if(usuarioExistente.isPresent())
			throw new EmailJaCadastradoException("E-mail já cadastrado");
		
		usuarios.save(usuario);
	}
}
