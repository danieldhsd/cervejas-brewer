package com.danieldhsd.brewer.repository.helper.cerveja;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.danieldhsd.brewer.model.Cerveja;
import com.danieldhsd.brewer.repository.filter.CervejaFilter;

public interface CervejasQueries {
	
	public Page<Cerveja> filtrar(CervejaFilter filtro, Pageable pageable);
}
