package com.danieldhsd.brewer.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.danieldhsd.brewer.model.Grupo;

public class GrupoConverter implements Converter<String, Grupo> {

	@Override
	public Grupo convert(String codigo) {
		if(StringUtils.isEmpty(codigo))
			return null;
		
		Grupo grupo = new Grupo();
		grupo.setCodigo(Long.valueOf(codigo));
		return grupo;
	}
	
}
