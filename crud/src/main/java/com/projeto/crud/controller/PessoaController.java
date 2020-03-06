package com.projeto.crud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.crud.model.Pessoa;
import com.projeto.crud.repository.PessoaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST Pessoa")
@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	//http://localhost:8080/swagger-ui.html     - Conferir controller através do swagger UI
	@Autowired
	private PessoaRepository pr;
	
	@ApiOperation(value = "Retorna uma lista de pessoas")
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Pessoa> listaPessoas() {
		Iterable<Pessoa> listaPessoas = pr.findAll();
		return listaPessoas;
	}
	
	@ApiOperation(value = "Salva uma pessoa")
	@PostMapping()
	public Pessoa cadastraPessoa(@RequestBody @Valid Pessoa pessoa) {
		return pr.save(pessoa);
	}
	
	@ApiOperation(value = "Deleta uma pessoa")
	@DeleteMapping()
	public Pessoa deletaPessoa(@RequestBody @Valid Pessoa pessoa) {
		pr.delete(pessoa);
		return pessoa;
	}
	
	
	
	

}
