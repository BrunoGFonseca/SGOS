package com.brunofonseca.SGOS.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.brunofonseca.SGOS.domain.OrdemServico;

public abstract class AbstractEmailService implements EmailService {
	
	@Value("${default.sender}")
	private String sender;
	
	@Override
	public void sendOrderConfirmationEmail(OrdemServico obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromOS(obj);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromOS(OrdemServico obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getCliente().getEmail());
		sm.setFrom(sender);
		sm.setSubject("Ordem de Servico confirmada. Codigo: " + obj.getId());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
	}
}