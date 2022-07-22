package com.jonathasdeveloper.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.jonathasdeveloper.entities.Tutor;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TutorDTO {
	
	private Long id;
	
	@NotBlank
	@Size(max = 11)
	private String cpf;
	
	@NotBlank
	@Size(max = 200)
	private String nome;
	

}
