package com.danieldhsd.brewer.repository.helper.usuario;

import java.util.Optional;

import com.danieldhsd.brewer.model.Usuario;

public interface UsuariosQueries {
	public Optional<Usuario> porEmailEAtivo(String email);
}
