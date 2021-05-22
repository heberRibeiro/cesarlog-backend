package com.unit.cesarlog.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.unit.cesarlog.domain.Employee;
import com.unit.cesarlog.domain.Equipment;

@Component
public class ScheduledTasks {

	private static final Calendar cal = Calendar.getInstance();

	private static final Integer TOLERANCE = 1;

	@Autowired
	private EquipmentService equipmentService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmailService emailService;

	// 1 hora = 3600 seg
	// 24 horas = 86400 seg
	@Scheduled(fixedRate = 10000) // miliseconds
	public void reportCurrentTime() {

		List<Employee> employees = employeeService.findAll();

		for (Employee employee : employees) {

			Date today = new Date();
			Integer employeeId = employee.getId();

			List<Equipment> equipments = equipmentService.findByEmployeeId(employeeId);
			ArrayList<Equipment> equipmentsFiltered = new ArrayList<>();

			for (Equipment equipment : equipments) {

				Date dateStatus = equipment.getStatusUpdate();
				cal.setTime(dateStatus);
				cal.add(Calendar.DATE, TOLERANCE);
				Date newDateStatus = cal.getTime();

				if (today.after(newDateStatus)) {
					equipmentsFiltered.add(equipment);
				}
			}

			employee.setEquipment(equipmentsFiltered);
			emailService.sendAlertEmail(employee);

		}

	}

}
