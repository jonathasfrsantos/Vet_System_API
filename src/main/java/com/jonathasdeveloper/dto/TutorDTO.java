package com.jonathasdeveloper.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TutorDTO {
	
	private Long id;
	
	@NotBlank
	@Size(max = 11)
	private String cpf;
	@NotBlank
	private String nome;
	
	public TutorDTO() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	

}
