package com.isagiongo.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.isagiongo.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
