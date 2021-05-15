package com.unit.cesarlog.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.unit.cesarlog.domain.EquipmentStatus;
import com.unit.cesarlog.repositories.EquipmentStatusRepository;
import com.unit.cesarlog.services.exceptions.ObjectNotFoundException;

@Service
public class EquipmentStatusService {
	
	@Autowired
	private EquipmentStatusRepository repository;
	
	public List<EquipmentStatus> findAll() {
		return repository.findAll();
	}
	
	public EquipmentStatus findById(Integer id) {

		try {
			EquipmentStatus equipmentStatus = repository.findById(id).get();
			return equipmentStatus;

		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Status de Equipamento não encontrado na base de dados.");
		}
	}
	
	public EquipmentStatus insert(EquipmentStatus equipmentStatus) {
		return repository.save(equipmentStatus);		
	}
	
	public EquipmentStatus update(EquipmentStatus equipmentStatus, Integer id) {

		try {
			EquipmentStatus obj = repository.getOne(id); // return a reference to the entity
			obj.setId(equipmentStatus.getId());
			obj.setName(equipmentStatus.getName());
			
			return repository.save(obj);

		} catch (EntityNotFoundException e) {
			throw new ObjectNotFoundException("Status de Equipamento a ser atualizado não encontrado na base de dados.");
		}

	}
	
	public void delete(Integer id) {
		try {
			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Status de Equipamento não encontrado na base de dados.");
		}
	}

}
