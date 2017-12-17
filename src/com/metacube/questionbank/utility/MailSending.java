package com.metacube.questionbank.utility;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class MailSending {
	private MailSender mailSender;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendMail(String to, String subject, String msg) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(mailSender.toString());
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		mailSender.send(message);
	}
}
