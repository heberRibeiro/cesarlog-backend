package com.unit.cesarlog.services;

import org.springframework.mail.SimpleMailMessage;

import com.unit.cesarlog.domain.Employee;

public interface EmailService {
	
	void sendAlertEmail(Employee obj);
	
	void sendEmail(SimpleMailMessage msg);

}
