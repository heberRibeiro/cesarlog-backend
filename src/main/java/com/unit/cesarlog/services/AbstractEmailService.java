package com.unit.cesarlog.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.unit.cesarlog.domain.Account;
import com.unit.cesarlog.domain.Employee;
import com.unit.cesarlog.domain.Equipment;

public abstract class AbstractEmailService implements EmailService {
	
	@Value("${default.sender}")
	private String sender;
		
	@Autowired
	private AccountService accountService;

	@Override
	public void sendAlertEmail(Employee obj) {

		SimpleMailMessage sm = prepareSimpleMailMessageFromEquipment(obj);
		sendEmail(sm);

	}

	protected SimpleMailMessage prepareSimpleMailMessageFromEquipment(Employee employee) {

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

}
