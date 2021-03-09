package com.danieldhsd.brewer.repository.helper.cerveja;

import java.util.List;

import com.danieldhsd.brewer.model.Cerveja;
import com.danieldhsd.brewer.repository.filter.CervejaFilter;

public interface CervejasQueries {
	
	public List<Cerveja> filtrar(CervejaFilter filtro);
}
