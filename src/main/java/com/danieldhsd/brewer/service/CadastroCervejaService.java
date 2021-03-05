package com.danieldhsd.brewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danieldhsd.brewer.model.Cerveja;
import com.danieldhsd.brewer.repository.Cervejas;
import com.danieldhsd.brewer.service.event.cerveja.CervejaSalvaEvent;

@Service
public class CadastroCervejaService {

	@Autowired
	private Cervejas cervejas;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Transactional
	public void salvar(Cerveja cerveja) {
		cervejas.save(cerveja);
		
		publisher.publishEvent(new CervejaSalvaEvent(cerveja));
	}
}
