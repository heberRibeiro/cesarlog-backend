package com.unit.cesarlog.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.unit.cesarlog.domain.Equipment;
import com.unit.cesarlog.services.EquipmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Equipment", description = "Acesso aos endpoint da entidade Equipmaneto", tags = {"Equipment"})
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
	
	@ApiOperation(value = "Busca um Equipamento pelo ID", notes = "Este endpoint faz a busca de uma Equipmento passando o Id como parâmetro da requisição.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Equipment> findById(@PathVariable Integer id) {
		Equipment obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Busca um Equipamento pelo ID do Colaborador", notes = "Este endpoint faz a busca de uma Equipmento passando o Id do Colaborador como parâmetro da requisição.")
	@GetMapping(value = "/employee")
	public ResponseEntity<List<Equipment>> findByEmployeeId(@RequestParam Integer employeeId) {
		List<Equipment> obj = service.findByEmployeeId(employeeId);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Busca um Equipamento pelo ID do Colaborador", notes = "Este endpoint faz a busca de uma Equipmento passando o Id do Colaborador como parâmetro da requisição.")
	@GetMapping(value = "/filter")
	public ResponseEntity<List<Equipment>> findByBranchIdOrProjectIdEmployeeId(@RequestParam(required = false) Integer branchId, 
			@RequestParam(required = false) Integer projectId) {
		
		List<Equipment> obj = service.findByBranchIdOrProjectIdEmployeeId(branchId, projectId);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Insere uma Equipamento enviando um json no corpo da requisição")
	@PostMapping
	public ResponseEntity<Equipment> insert(@RequestBody Equipment equipment) {
		Equipment obj = service.insert(equipment);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@ApiOperation(value = "Atualiza um Equipamento")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Equipment> update(@RequestBody Equipment equipment, @PathVariable Integer id) {
		equipment = service.update(equipment, id);
		return ResponseEntity.ok().body(equipment);
	}
	
	/*
	 * @ApiOperation(value =
	 * "Deleta um Equipamento passando o ID como parâmetro da requisição")
	 * 
	 * @DeleteMapping(value = "/{id}") public ResponseEntity<Void>
	 * delete(@PathVariable Integer id) { service.delete(id); return
	 * ResponseEntity.noContent().build(); }
	 */

}
