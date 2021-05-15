package com.unit.cesarlog.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.unit.cesarlog.domain.Role;
import com.unit.cesarlog.repositories.RoleRepository;
import com.unit.cesarlog.services.exceptions.ObjectNotFoundException;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository repository;
	
	public List<Role> findAll() {
		return repository.findAll();
	}
	
	public Role findById(Integer id) {

		try {
			Role role = repository.findById(id).get();
			return role;

		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Papel não encontrado na base de dados.");
		}
	}
	
	public Role insert(Role Role) {
		return repository.save(Role);		
	}
	
	public Role update(Role role, Integer id) {

		try {
			Role obj = repository.getOne(id); // return a reference to the entity
			obj.setId(role.getId());
			obj.setName(role.getName());
			
			return repository.save(obj);

		} catch (EntityNotFoundException e) {
			throw new ObjectNotFoundException("Papel a ser atualizado não encontrado na base de dados.");
		}

	}
	
	public void delete(Integer id) {
		try {
			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Papel não encontrado na base de dados.");
		}
	}

}
