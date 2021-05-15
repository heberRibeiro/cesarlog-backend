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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.unit.cesarlog.domain.EmployeeProject;
import com.unit.cesarlog.services.EmployeeProjectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "EmployeeProject", description = "Acesso aos endpoint da entidade EmployeeProject", tags = {"EmployeeProject"})
@RestController
@RequestMapping(value="/employee-project")
public class EmployeeProjectResource {
	

	@Autowired
	private EmployeeProjectService service;
	
	@ApiOperation(value = "Busca todas os Filiais")
	@GetMapping
	public ResponseEntity<List<EmployeeProject>> findAll() {
		List<EmployeeProject> EmployeeProject = service.findAll();
		return ResponseEntity.ok().body(EmployeeProject);
	}
	
	@ApiOperation(value = "Busca um employeeProject pelo ID", notes = "Este endpoint faz a busca de uma EmployeeProject passando o Id como parâmetro da requisição.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<EmployeeProject> findById(@PathVariable Integer id) {
		EmployeeProject obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Insere uma employeeProject enviando um json no corpo da requisição")
	@PostMapping
	public ResponseEntity<EmployeeProject> insert(@RequestBody EmployeeProject employeeProject) {
		EmployeeProject obj = service.insert(employeeProject);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@ApiOperation(value = "Atualiza uma employeeProject")
	@PutMapping(value = "/{id}")
	public ResponseEntity<EmployeeProject> update(@RequestBody EmployeeProject employeeProject, @PathVariable Integer id) {
		employeeProject = service.update(employeeProject, id);
		return ResponseEntity.ok().body(employeeProject);
	}
	
	/*
	 * @ApiOperation(value =
	 * "Deleta um employeeProject passando o ID como parâmetro da requisição")
	 * 
	 * @DeleteMapping(value = "/{id}") public ResponseEntity<Void>
	 * delete(@PathVariable Integer id) { service.delete(id); return
	 * ResponseEntity.noContent().build(); }
	 */
	

}
