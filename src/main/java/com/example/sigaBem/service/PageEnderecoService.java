package com.example.sigaBem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.sigaBem.repository.EnderecoRepository;
import com.example.sigaBem.model.Endereco;

@Service
public class PageEnderecoService {
	@Autowired
	EnderecoRepository enderecoRepository;
	
	public Page<Endereco> findAll(Pageable pageable){
		return enderecoRepository.findAll(pageable);
	}
}
