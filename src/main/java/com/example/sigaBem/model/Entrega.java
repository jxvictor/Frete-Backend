package com.example.sigaBem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "entrega")
public class Entrega implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3709553624997827658L;

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column()
	@ApiModelProperty(value = "Identificador único para a Entrega")
	private long id;
	
	@Column(name = "peso", nullable = false)
	@ApiModelProperty(value = "Digite o peso")
	// peso em kg
	private BigDecimal peso;
	
	@ApiModelProperty(value = "Digite o Cep de origem")
	@ManyToOne
	@JoinColumn(name = "cep_Origem")
	private Endereco cepOrigem;
	
	@ApiModelProperty(value = "Digite o Cep de destino")
	@ManyToOne
	@JoinColumn(name = "cep_Destino")
	private Endereco cepDestino;
	
	@Column(name = "nomeDestinatario", nullable = false)
	@ApiModelProperty(value = "Digite o nome do destinatário")
	private String nomeDestinatario;
	
	@ApiModelProperty(value = "Digite o valor total do frete")
	private BigDecimal vlTotalFrete;
	
	@ApiModelProperty(value = "Digite a data prevista para entrega")
    private LocalDate dataPrevistaEntrega;
    
	@ApiModelProperty(value = "Digite a data da consulta")
    private LocalDate dataConsulta;
	
}
