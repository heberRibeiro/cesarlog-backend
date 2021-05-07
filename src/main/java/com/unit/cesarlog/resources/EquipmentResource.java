package com.unit.cesarlog.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unit.cesarlog.domain.Equipment;
import com.unit.cesarlog.services.EquipmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Equipment Endpoint", description = "Acesso aos endpoint da entidade Equipmaneto", tags = {"Equipment Enpoints"})
@RestController
@RequestMapping(value="/equipment")
public class EquipmentResource {
	
	@Autowired
	private EquipmentService service;
	
	@ApiOperation(value = "Busca todas os Equipamentos")
	@GetMapping
	public ResponseEntity<List<Equipment>> findAll() {
		List<Equipment> equipment = service.findAll();
		return ResponseEntity.ok().body(equipment);
	}

}
