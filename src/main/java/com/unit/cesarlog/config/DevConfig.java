package com.unit.cesarlog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.unit.cesarlog.services.EmailService;
import com.unit.cesarlog.services.SmtpEmailService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Bean
	public EmailService emailService() {
		//return new MockEmailService();
		return new SmtpEmailService();
	}
		
}
