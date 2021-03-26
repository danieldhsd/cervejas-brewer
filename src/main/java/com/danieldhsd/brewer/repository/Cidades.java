package com.danieldhsd.brewer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danieldhsd.brewer.model.Cidade;
import com.danieldhsd.brewer.model.Estado;

public interface Cidades extends JpaRepository<Cidade, Long> {
	
	public List<Cidade> findByEstadoCodigo(Long codigoEstado);
	
	public Optional<Cidade> findByNomeAndEstado(String nome, Estado estado);
}
