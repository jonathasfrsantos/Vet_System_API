package com.jonathasdeveloper.dto;

import javax.validation.constraints.NotBlank;

public class VacinaDTO {
	
	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	private String fabricante;
	@NotBlank
	private String lote;
	@NotBlank
	private String dataFabricacao;
	@NotBlank
	private Double valor;
	
	public VacinaDTO() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(String dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	

}
