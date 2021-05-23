package com.unit.cesarlog.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

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
	
	public List<Equipment> findByEmployeeId(Integer employeeId) {
		return repository.findEquipmentByEmployeeId(employeeId);
	}
	
	public Equipment insert(Equipment equipment) {
		return repository.save(equipment);		
	}
	
	public Equipment update(Equipment equipmento, Integer id) {

		try {
			Equipment obj = repository.getOne(id); // return a reference to the entity
			obj.setId(equipmento.getId());
			obj.setLatitude(equipmento.getLatitude());
			obj.setLongitude(equipmento.getLongitude());
			
			return repository.save(obj);

		} catch (EntityNotFoundException e) {
			throw new ObjectNotFoundException("Equipamento a ser atualizado não encontrado na base de dados.");
		}

	}
	
//	public void delete(Integer id) {
//		try {
//			repository.deleteById(id);
//
//		} catch (EmptyResultDataAccessException e) {
//			throw new ObjectNotFoundException("Equipmaneto não encontrado na base de dados.");
//		}
//	}
}
