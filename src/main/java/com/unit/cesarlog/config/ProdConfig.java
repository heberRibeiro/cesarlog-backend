package com.unit.cesarlog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.unit.cesarlog.services.EmailService;
import com.unit.cesarlog.services.SmtpEmailService;

@Configuration
@Profile("prod")
public class ProdConfig {
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
	
	@Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
