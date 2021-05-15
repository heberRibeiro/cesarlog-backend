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

import com.unit.cesarlog.domain.Account;
import com.unit.cesarlog.services.AccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Account", description = "Acesso aos endpoint da entidade Conta", tags = {"Account"})
@RestController
@RequestMapping(value="/account")
public class AccountResource {
	
	@Autowired
	private AccountService service;
	
	@ApiOperation(value = "Busca todas os Contas")
	@GetMapping
	public ResponseEntity<List<Account>> findAll() {
		List<Account> account = service.findAll();
		return ResponseEntity.ok().body(account);
	}
	
	@ApiOperation(value = "Busca um Conta pelo ID", notes = "Este endpoint faz a busca de uma Conta passando o Id como parâmetro da requisição.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Account> findById(@PathVariable Integer id) {
		Account obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Insere uma Conta enviando um json no corpo da requisição")
	@PostMapping
	public ResponseEntity<Account> insert(@RequestBody Account account) {
		Account obj = service.insert(account);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@ApiOperation(value = "Atualiza um Conta")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Account> update(@RequestBody Account account, @PathVariable Integer id) {
		account = service.update(account, id);
		return ResponseEntity.ok().body(account);
	}
	
	/*
	 * @ApiOperation(value =
	 * "Deleta um Conta passando o ID como parâmetro da requisição")
	 * 
	 * @DeleteMapping(value = "/{id}") public ResponseEntity<Void>
	 * delete(@PathVariable Integer id) { service.delete(id); return
	 * ResponseEntity.noContent().build(); }
	 */

}
