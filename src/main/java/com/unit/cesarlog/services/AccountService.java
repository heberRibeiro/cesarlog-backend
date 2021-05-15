package com.unit.cesarlog.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.unit.cesarlog.domain.Account;
import com.unit.cesarlog.repositories.AccountRepository;
import com.unit.cesarlog.services.exceptions.ObjectNotFoundException;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository repository;
	
	public List<Account> findAll() {
		return repository.findAll();
	}
	
	public Account findById(Integer id) {

		try {
			Account account = repository.findById(id).get();
			return account;

		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Conta não encontrado na base de dados.");
		}
	}
	
	public Account insert(Account account) {
		return repository.save(account);		
	}
	
	public Account update(Account account, Integer id) {

		try {
			Account obj = repository.getOne(id); // return a reference to the entity
			obj.setRole(account.getRole());
			obj.setEmail(account.getEmail());
			
			return repository.save(obj);

		} catch (EntityNotFoundException e) {
			throw new ObjectNotFoundException("Conta a ser atualizado não encontrado na base de dados.");
		}

	}
	
	public void delete(Integer id) {
		try {
			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Conta não encontrado na base de dados.");
		}
	}

}
