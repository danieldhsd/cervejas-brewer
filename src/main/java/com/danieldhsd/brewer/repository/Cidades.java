package com.danieldhsd.brewer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.danieldhsd.brewer.model.Cidade;
import com.danieldhsd.brewer.model.Estado;
import com.danieldhsd.brewer.repository.helper.cidade.CidadesQueries;

public interface Cidades extends JpaRepository<Cidade, Long>, CidadesQueries {
	
	public List<Cidade> findByEstadoCodigo(Long codigoEstado);
	
	public Optional<Cidade> findByNomeAndEstado(String nome, Estado estado);
	
	@Query("select c from Cidade c join fetch c.estado where c.codigo = :codigo")
	public Cidade findByCodigoFetchingEstado(@Param("codigo") Long codigo);
}
