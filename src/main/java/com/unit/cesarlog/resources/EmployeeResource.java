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

import com.unit.cesarlog.domain.Employee;
import com.unit.cesarlog.services.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Employee", description = "Acesso aos endpoint da entidade Colaborador", tags = {"Employee"})
@RestController
@RequestMapping(value="/employee")
public class EmployeeResource {
	
	@Autowired
	private EmployeeService service;
	
	@ApiOperation(value = "Busca todas os Filiais")
	@GetMapping
	public ResponseEntity<List<Employee>> findAll() {
		List<Employee> Employee = service.findAll();
		return ResponseEntity.ok().body(Employee);
	}
	
	@ApiOperation(value = "Busca um Colaborador pelo ID", notes = "Este endpoint faz a busca de uma Employee passando o Id como parâmetro da requisição.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Employee> findById(@PathVariable Integer id) {
		Employee obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Insere uma Colaborador enviando um json no corpo da requisição")
	@PostMapping
	public ResponseEntity<Employee> insert(@RequestBody Employee employee) {
		Employee obj = service.insert(employee);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@ApiOperation(value = "Atualiza uma Colaborador")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Employee> update(@RequestBody Employee employee, @PathVariable Integer id) {
		employee = service.update(employee, id);
		return ResponseEntity.ok().body(employee);
	}
	
	/*
	 * @ApiOperation(value =
	 * "Deleta um Colaborador passando o ID como parâmetro da requisição")
	 * 
	 * @DeleteMapping(value = "/{id}") public ResponseEntity<Void>
	 * delete(@PathVariable Integer id) { service.delete(id); return
	 * ResponseEntity.noContent().build(); }
	 */

}
