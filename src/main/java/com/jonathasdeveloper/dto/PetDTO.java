package com.jonathasdeveloper.dto;

import javax.validation.constraints.NotBlank;

import com.jonathasdeveloper.entities.CartaoVacina;
import com.jonathasdeveloper.entities.Tutor;

public class PetDTO {
	
	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	private String raca;
	@NotBlank
	private String especie;
	
	private String sexo;
	private String cor;
	@NotBlank
	private Tutor tutor;
	
	private CartaoVacina cartaoVacina;
	
	public PetDTO() {

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

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public CartaoVacina getCartaoVacina() {
		return cartaoVacina;
	}

	public void setCartaoVacina(CartaoVacina cartaoVacina) {
		this.cartaoVacina = cartaoVacina;
	}

	
}
