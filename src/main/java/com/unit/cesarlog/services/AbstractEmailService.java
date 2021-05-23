package com.unit.cesarlog.services;

import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.unit.cesarlog.domain.Account;
import com.unit.cesarlog.domain.Employee;
import com.unit.cesarlog.domain.Equipment;

public abstract class AbstractEmailService implements EmailService {
	
	@Value("${default.sender}")
	private String sender;
		
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendAlertEmail(Employee obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromEmployee(obj);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromEmployee(Employee employee) {

		Integer accountId = employee.getAccountId();
		Account account = accountService.findById(accountId);
		String email = account.getEmail();
		List<Equipment> equipments = employee.getEquipment();
		
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(email);
		sm.setFrom(sender);
		sm.setSubject("Alerta de alocação de equipamento");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Olá" + employee.getName() + "Essa é uma mensagem padrão de alerta de alocação de equipamento\n" + equipments);

		return sm;
	}
	
	protected String htmlFromTemplateEmployee(Employee obj) {
		Context context = new Context();
		context.setVariable("employee", obj);
		return templateEngine.process("email/alertEmail", context);
	}
	
	@Override
	public void sendAlertHtmlEmail(Employee obj) {
		try {
			MimeMessage mm = prepareMimeMessageFromEmployee(obj);
			sendHtmlEmail(mm);
		} catch (MessagingException e) {
			sendAlertEmail(obj);
		}
	}

	protected MimeMessage prepareMimeMessageFromEmployee(Employee employee) throws MessagingException {
		
		Integer accountId = employee.getAccountId();
		Account account = accountService.findById(accountId);
		String email = account.getEmail();
	
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);

		mmh.setTo(email);
		mmh.setFrom(sender);
		mmh.setSubject("Alerta de alocação de equipamento");
		mmh.setSentDate(new Date(System.currentTimeMillis()));
		mmh.setText(htmlFromTemplateEmployee(employee), true);

		return mimeMessage;
	}

}
