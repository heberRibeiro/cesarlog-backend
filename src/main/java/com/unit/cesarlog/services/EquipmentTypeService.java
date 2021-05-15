package com.unit.cesarlog.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.unit.cesarlog.domain.EquipmentType;
import com.unit.cesarlog.repositories.EquipmentTypeRepository;
import com.unit.cesarlog.services.exceptions.ObjectNotFoundException;

@Service
public class EquipmentTypeService {
	

	@Autowired
	private EquipmentTypeRepository repository;
	
	public List<EquipmentType> findAll() {
		return repository.findAll();
	}
	
	public EquipmentType findById(Integer id) {

		try {
			EquipmentType EquipmentType = repository.findById(id).get();
			return EquipmentType;

		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Tipo de Equipamento não encontrado na base de dados.");
		}
	}
	
	public EquipmentType insert(EquipmentType EquipmentType) {
		return repository.save(EquipmentType);		
	}
	
	public EquipmentType update(EquipmentType equipmentType, Integer id) {

		try {
			EquipmentType obj = repository.getOne(id); // return a reference to the entity
			obj.setId(equipmentType.getId());
			obj.setDescription(equipmentType.getDescription());
			
			return repository.save(obj);

		} catch (EntityNotFoundException e) {
			throw new ObjectNotFoundException("Tipo de Equipamento a ser atualizado não encontrado na base de dados.");
		}

	}
	
	public void delete(Integer id) {
		try {
			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Tipo de Equipamento não encontrado na base de dados.");
		}
	}

}
