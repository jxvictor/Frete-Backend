package com.example.sigaBem.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.sigaBem.model.Endereco;
import com.example.sigaBem.model.Entrega;
import com.example.sigaBem.repository.EnderecoRepository;
import com.example.sigaBem.repository.EntregaRepository;

@Service
public class EntregaService {
	@Autowired
	EntregaRepository entregaRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	EnderecoService enderecoService;

	public Optional<Entrega> findByCepOrigem(String cepOrigem) {
		return Optional.of(entregaRepository.findByCepOrigem(cepOrigem));
	}
	public Optional<Entrega> findByCepDestino(String cepDestino){
		return Optional.of(entregaRepository.findByCepDestino(cepDestino));
	}
	
	public Page<Entrega> findAll(Pageable pageable){
		return entregaRepository.findAll(pageable);
	}
	/*public List<Entrega> findAll(){
		return entregaRepository.findAll();
	}*/
	
	public Optional<Entrega> findById(Long id){
		return entregaRepository.findById(id);
	}
	
	public Entrega calcularValor(Entrega entrega) {
		if(entrega.getCepOrigem().getDdd().equals(entrega.getCepDestino().getDdd())) {
			BigDecimal vlTotalFrete = entrega.getPeso().subtract(entrega.getPeso().multiply(new BigDecimal(0.5)));
			entrega.setVlTotalFrete(vlTotalFrete);
			
			LocalDate dataPrevista = entrega.getDataConsulta().plusDays(1);
			entrega.setDataPrevistaEntrega(dataPrevista);
		}
		else if(entrega.getCepOrigem().getUf().equals(entrega.getCepDestino().getUf())) {
			BigDecimal vlTotalFrete = entrega.getPeso().subtract(entrega.getPeso().multiply(new BigDecimal(0.75)));
			entrega.setVlTotalFrete(vlTotalFrete);
			
			LocalDate dataPrevista = entrega.getDataConsulta().plusDays(3);
			entrega.setDataPrevistaEntrega(dataPrevista);
		}
		else 
		{
			entrega.setVlTotalFrete(entrega.getPeso());
			
			LocalDate dataPrevista = entrega.getDataConsulta().plusDays(10);
			entrega.setDataPrevistaEntrega(dataPrevista);
		}
		
		return entrega;
	}

	public Endereco pesquisarCep(String cep) {
		return enderecoRepository.findById(cep).orElseGet(() -> {
			Endereco novoEndereco = enderecoService.buscarEnderecoPor(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
	}
	
	public Entrega pesquisarEnderecoPorCep(Entrega entrega) {
		String cepOrigem = entrega.getCepOrigem().getCep();
		String cepDestino = entrega.getCepDestino().getCep();
		
		Endereco endOrigem = pesquisarCep(cepOrigem);
		Endereco endDestino = pesquisarCep(cepDestino);
		
		entrega.setCepOrigem(endOrigem);
		entrega.setCepDestino(endDestino);
		
		return entrega;
	}
	
	public void cadastrar(Entrega entrega) {
		LocalDate hoje = LocalDate.now();
		
		entrega = pesquisarEnderecoPorCep(entrega);
		entrega.setDataConsulta(hoje);
		entrega = calcularValor(entrega);
		
		entregaRepository.save(entrega);
	}

}
