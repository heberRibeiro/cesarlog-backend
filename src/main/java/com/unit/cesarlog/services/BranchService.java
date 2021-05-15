package com.unit.cesarlog.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.unit.cesarlog.domain.Branch;
import com.unit.cesarlog.repositories.BranchRepository;
import com.unit.cesarlog.services.exceptions.ObjectNotFoundException;

@Service
public class BranchService {

	@Autowired
	private BranchRepository repository;
	
	public List<Branch> findAll() {
		return repository.findAll();
	}
	
	public Branch findById(Integer id) {

		try {
			Branch branch = repository.findById(id).get();
			return branch;

		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Filial não encontrado na base de dados.");
		}
	}
	
	public Branch insert(Branch branch) {
		return repository.save(branch);		
	}
	
	public Branch update(Branch branch, Integer id) {

		try {
			Branch obj = repository.getOne(id); // return a reference to the entity
			obj.setId(branch.getId());
			obj.setName(branch.getName());
			
			return repository.save(obj);

		} catch (EntityNotFoundException e) {
			throw new ObjectNotFoundException("Filial a ser atualizado não encontrado na base de dados.");
		}

	}
	
	public void delete(Integer id) {
		try {
			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Filial não encontrado na base de dados.");
		}
	}
}
