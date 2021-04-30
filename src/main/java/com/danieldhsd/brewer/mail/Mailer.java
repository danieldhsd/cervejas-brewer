package com.danieldhsd.brewer.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.danieldhsd.brewer.model.Venda;

@Component
public class Mailer {

	@Autowired
	private JavaMailSender mailSender;
	
	@Async
	public void enviar(Venda venda) {
		SimpleMailMessage mensagem = new SimpleMailMessage();
		mensagem.setFrom("danieldhsd@email.com");
		mensagem.setTo(venda.getCliente().getEmail());
		mensagem.setSubject("Venda Efetuada");
		mensagem.setText("Obrigado, sua venda foi processada!");
		
		mailSender.send(mensagem);
	}
}
