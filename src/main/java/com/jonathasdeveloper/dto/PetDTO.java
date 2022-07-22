package com.jonathasdeveloper.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.jonathasdeveloper.entities.Tutor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO {

	private Long id;
	
	@NotBlank
	@Size(max = 200)
	private String nome;
	
	@NotBlank
	@Size(max = 100)
	private String raca;
	
	@NotBlank
	@Size(max = 20)
	private String especie;

	@NotBlank
	@Size(max = 5)
	private String sexo;
	
	@NotBlank
	@Size(max = 100)
	private String cor;

	private Tutor tutor;

	// private CartaoVacina cartaoVacina;



	/*
	 * public CartaoVacina getCartaoVacina() { return cartaoVacina; }
	 * 
	 * public void setCartaoVacina(CartaoVacina cartaoVacina) { this.cartaoVacina =
	 * cartaoVacina; }
	 * 
	 */
}
