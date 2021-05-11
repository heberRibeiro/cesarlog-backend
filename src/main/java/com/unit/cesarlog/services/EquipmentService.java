package com.unit.cesarlog.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unit.cesarlog.domain.Equipment;
import com.unit.cesarlog.repositories.EquipmentRepository;
import com.unit.cesarlog.services.exceptions.ObjectNotFoundException;

@Service
public class EquipmentService {

	@Autowired
	private EquipmentRepository repository;
	
	public List<Equipment> findAll() {
		return repository.findAll();
	}
	
	public Equipment findById(Integer id) {

		try {
			Equipment equipment = repository.findById(id).get();
			return equipment;

		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Equipamento não encontrado na base de dados.");
		}
	}
	
	public Equipment insert(Equipment equipment) {
		
		try {
			return repository.save(equipment);
		} catch (Exception e) {
			throw new ObjectNotFoundException("Não foi possivel");
		}
		
	}
}
