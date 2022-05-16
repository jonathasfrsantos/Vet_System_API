package com.jonathasdeveloper.dto;

import javax.validation.constraints.NotBlank;

public class VeterinarioDTO {
	
	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	private String CRMV;
	
	public VeterinarioDTO() {

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

	public String getCRMV() {
		return CRMV;
	}

	public void setCRMV(String cRMV) {
		CRMV = cRMV;
	}
	
	
	

}
