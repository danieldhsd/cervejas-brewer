package com.danieldhsd.brewer.repository.helper.usuario;

import java.util.List;
import java.util.Optional;

import com.danieldhsd.brewer.model.Usuario;
import com.danieldhsd.brewer.repository.filter.UsuarioFilter;

public interface UsuariosQueries {
	public Optional<Usuario> porEmailEAtivo(String email);
	
	public List<String> permissoes(Usuario usuario);
	
	public List<Usuario> filtrar(UsuarioFilter filtro);
}
