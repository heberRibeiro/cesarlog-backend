package com.unit.cesarlog.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.unit.cesarlog.domain.Employee;
import com.unit.cesarlog.repositories.EmployeeRepository;
import com.unit.cesarlog.services.exceptions.ObjectNotFoundException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	public List<Employee> findAll() {
		return repository.findAll();
	}
	
	public Employee findById(Integer id) {

		try {
			Employee employee = repository.findById(id).get();
			return employee;

		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Colaborador não encontrado na base de dados.");
		}
	}
	
	public Employee insert(Employee employee) {
		return repository.save(employee);		
	}
	
	public Employee update(Employee employee, Integer id) {

		try {
			Employee obj = repository.getOne(id); // return a reference to the entity
			obj.setId(employee.getId());
			obj.setName(employee.getName());
			
			return repository.save(obj);

		} catch (EntityNotFoundException e) {
			throw new ObjectNotFoundException("Colaborador a ser atualizado não encontrado na base de dados.");
		}

	}
	
	public void delete(Integer id) {
		try {
			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Colaborador não encontrado na base de dados.");
		}
	}
	
}
