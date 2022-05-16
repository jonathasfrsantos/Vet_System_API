package com.jonathasdeveloper.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.jonathasdeveloper.entities.Pet;
import com.jonathasdeveloper.entities.Vacina;

public class CartaoVacinaDTO {
	
	private Long id;
	@NotBlank
	private Pet pet;
	private Set<Vacina> vacinas = new HashSet<>();
	
	public CartaoVacinaDTO() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Set<Vacina> getVacinas() {
		return vacinas;
	}

	
	
	
	

}
