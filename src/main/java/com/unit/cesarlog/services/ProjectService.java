package com.unit.cesarlog.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.unit.cesarlog.domain.Project;
import com.unit.cesarlog.repositories.ProjectRepository;
import com.unit.cesarlog.services.exceptions.ObjectNotFoundException;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository repository;
	
	public List<Project> findAll() {
		return repository.findAll();
	}
	
	public Project findById(Integer id) {

		try {
			Project project = repository.findById(id).get();
			return project;

		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Projeto não encontrado na base de dados.");
		}
	}
	
	public Project insert(Project project) {
		return repository.save(project);		
	}
	
	public Project update(Project project, Integer id) {

		try {
			Project obj = repository.getOne(id); // return a reference to the entity
			obj.setId(project.getId());
			obj.setName(project.getName());
			
			return repository.save(obj);

		} catch (EntityNotFoundException e) {
			throw new ObjectNotFoundException("Projeto a ser atualizado não encontrado na base de dados.");
		}

	}
	
	public void delete(Integer id) {
		try {
			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Projeto não encontrado na base de dados.");
		}
	}

}
