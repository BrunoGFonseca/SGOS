package com.brunofonseca.SGOS.services;

import org.springframework.mail.SimpleMailMessage;

import com.brunofonseca.SGOS.domain.OrdemServico;

public interface EmailService {
	
	void sendOrderConfirmationEmail(OrdemServico obj);
	
	void sendEmail(SimpleMailMessage msg);

}
