package com.example.sigaBem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sigaBem.model.Endereco;
import com.example.sigaBem.service.EnderecoService;
import com.example.sigaBem.service.PageEnderecoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@RequestMapping(path = "/endereco", produces = "application/json")
public class EnderecoController {
	
	@Autowired
    private EnderecoService cepService;
	
	@Autowired
    private PageEnderecoService service;

	@ApiOperation(value = "Retorna o cep especificado")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sucesso"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 404, message = "Endpoint não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor")
	})
	@GetMapping("/{cep}")
    public ResponseEntity<Endereco> getCep(@PathVariable String cep) {
		Endereco endereco = cepService.buscarEnderecoPor(cep);
		try
		{
			return new ResponseEntity<Endereco>(endereco, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Endereco>(HttpStatus.BAD_REQUEST);
		} 
    }
	
	@GetMapping()
	public ResponseEntity<Page<Endereco>> obterTodos(Pageable pageable){		
		try
		{
			return new ResponseEntity<Page<Endereco>>(service.findAll(pageable), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Page<Endereco>>(HttpStatus.BAD_REQUEST);
		}
	}

}
