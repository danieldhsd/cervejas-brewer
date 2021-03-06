package com.danieldhsd.brewer.repository.helper.estilo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.danieldhsd.brewer.model.Estilo;
import com.danieldhsd.brewer.repository.filter.EstiloFilter;

public interface EstilosQueries {
	
	public Page<Estilo> filtrar(EstiloFilter filtro, Pageable pageable);
}
