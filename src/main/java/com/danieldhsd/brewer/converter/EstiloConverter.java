package com.danieldhsd.brewer.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.danieldhsd.brewer.model.Estilo;

public class EstiloConverter implements Converter<String, Estilo> {

	@Override
	public Estilo convert(String codigo) {
		if(StringUtils.isEmpty(codigo))
			return null;
		
		Estilo estilo = new Estilo();
		estilo.setCodigo(Long.valueOf(codigo));

		return estilo;
	}

}
