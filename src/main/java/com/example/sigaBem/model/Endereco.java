package com.example.sigaBem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "endereco")
public class Endereco implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -599946202349410272L;
	
	@Id
	@ApiModelProperty(value = "Digite o Cep")
	private String cep;
	@ApiModelProperty(value = "Digite o Logradouro")
    private String logradouro;
	@ApiModelProperty(value = "Digite o Complemento")
    private String complemento;
	@ApiModelProperty(value = "Digite o Bairro")
    private String bairro;
	@ApiModelProperty(value = "Digite a localidade")
    private String localidade;
	@ApiModelProperty(value = "Digite o uf")
    private String uf;
	@ApiModelProperty(value = "Digite o ibge")
    private String ibge;
	@ApiModelProperty(value = "Digite o gia")
    private String gia;
	@ApiModelProperty(value = "Digite o ddd")
    private String ddd;
	@ApiModelProperty(value = "Digite o siafi")
    private String siafi;

}