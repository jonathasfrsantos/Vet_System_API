package com.jonathasdeveloper.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import com.jonathasdeveloper.entities.Pet;
import com.jonathasdeveloper.entities.Veterinario;
import com.jonathasdeveloper.entities.enums.StatusAtendimento;
import com.jonathasdeveloper.entities.enums.TipoAtendimento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AtendimentoDTO {
	
	private Long id;
	@NotBlank
	private LocalDateTime data;
	@NotBlank
	private Integer statusAtendimento;
	@NotBlank
	private Integer tipoAtendimento;
	@NotBlank
	private Double valor;
	@NotBlank
	private Pet pet;
	@NotBlank
	private Veterinario veterinario;



}
