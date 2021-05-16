package com.brunofonseca.SGOS.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.brunofonseca.SGOS.domain.OrdemServico;

public interface EmailService {
	
	void sendOrderConfirmationEmail(OrdemServico obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendOrderConfirmationHtmlEmail(OrdemServico obj);
	
	void sendHtmlEmail(MimeMessage msg);

}
