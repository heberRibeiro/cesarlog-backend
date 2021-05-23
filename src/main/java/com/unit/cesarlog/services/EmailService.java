package com.unit.cesarlog.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.unit.cesarlog.domain.Employee;

public interface EmailService {
	
	void sendAlertEmail(Employee obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendAlertHtmlEmail(Employee obj);
	
	void sendHtmlEmail(MimeMessage msg);

}
