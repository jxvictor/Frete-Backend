package com.example.sigaBem.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.sigaBem.model.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long>{

	//Optional<Entrega> findByCepOrigem(String cepOrigem);
	
	//@Query("SELECT e FROM Entrega e WHERE cep_origem = ?1")
	Entrega findByCepOrigem(String cepOrigem);
	
	//@Query("SELECT e FROM Entrega e WHERE cep_destino = ?1")
	Entrega findByCepDestino(String cepDestino);
	
}
