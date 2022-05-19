package com.example.sigaBem.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sigaBem.model.Entrega;
import com.example.sigaBem.service.EntregaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@RequestMapping(path = "/entrega", produces = "application/json")
public class EntregaController {
	
	@Autowired
    private EntregaService entregaService;
	
	@ApiOperation(value = "Retorna todas as entregas cadastradas")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sucesso"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 404, message = "Endpoint não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor")
	})
	@GetMapping()
	public ResponseEntity<Page<Entrega>> obterTodos(Pageable pageable){		
		try
		{
			return new ResponseEntity<Page<Entrega>>(entregaService.findAll(pageable), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Page<Entrega>>(HttpStatus.BAD_REQUEST);
		}
	}
	/*public ResponseEntity<List<Entrega>> obterTodos(){		
		try
		{
			return new ResponseEntity<List<Entrega>>(entregaService.findAll(), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<List<Entrega>>(HttpStatus.BAD_REQUEST);
		}
	}*/
	
	@ApiOperation(value = "Retorna a entrega especificada por id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sucesso"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 404, message = "Endpoint não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor")
	})
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Entrega>> obterPorId(@PathVariable Long id){		
			return new ResponseEntity<Optional<Entrega>>(entregaService.findById(id), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Cadastra uma entrega nova")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sucesso"),
			@ApiResponse(code = 201, message = "Criado"),
			@ApiResponse(code = 401, message = "Não autorizado"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 404, message = "Endpoint não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor")
	})
	@PostMapping()
	public ResponseEntity<String> cadastrar(@RequestBody @Valid Entrega entrega)
	{
		try
		{
			entregaService.cadastrar(entrega);
			return new ResponseEntity<String>("Entrega cadastrada com sucesso", HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
}
