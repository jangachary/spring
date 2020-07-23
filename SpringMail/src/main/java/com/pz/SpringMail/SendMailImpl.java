package com.pz.SpringMail;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SendMailImpl implements SendMail {

	private MailSender mailSender;

	private SimpleMailMessage templateMessage;

	public void setTemplateMessage(SimpleMailMessage templateMessage) {
		this.templateMessage = templateMessage;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public String sendMail(String to) {
		SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
		msg.setTo(to);
		msg.setText("spring mail test");
		try {
			this.mailSender.send(msg);
			return "mail sent";
		} catch (MailException ex) {
			return ex.getMessage();
		}

	}
}
