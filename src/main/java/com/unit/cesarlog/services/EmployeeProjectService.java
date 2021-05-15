package com.unit.cesarlog.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.unit.cesarlog.domain.EmployeeProject;
import com.unit.cesarlog.repositories.EmployeeProjectRepository;
import com.unit.cesarlog.services.exceptions.ObjectNotFoundException;

@Service
public class EmployeeProjectService {
	
	@Autowired
	private EmployeeProjectRepository repository;
	
	public List<EmployeeProject> findAll() {
		return repository.findAll();
	}
	
	public EmployeeProject findById(Integer id) {

		try {
			EmployeeProject employeeProject = repository.findById(id).get();
			return employeeProject;

		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("employeeProject não encontrado na base de dados.");
		}
	}
	
	public EmployeeProject insert(EmployeeProject employeeProject) {
		return repository.save(employeeProject);		
	}
	
	public EmployeeProject update(EmployeeProject employeeProject, Integer id) {

		try {
			EmployeeProject obj = repository.getOne(id); // return a reference to the entity
			obj.setEmployeeId(employeeProject.getEmployeeId());
			obj.setProjectId(employeeProject.getProjectId());
			
			return repository.save(obj);

		} catch (EntityNotFoundException e) {
			throw new ObjectNotFoundException("employeeProject a ser atualizado não encontrado na base de dados.");
		}

	}
	
	public void delete(Integer id) {
		try {
			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("employeeProject não encontrado na base de dados.");
		}
	}

}
