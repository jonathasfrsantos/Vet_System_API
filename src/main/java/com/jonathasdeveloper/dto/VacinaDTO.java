package com.jonathasdeveloper.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VacinaDTO {
	
	private Long id;
	
	@NotBlank
	@Size(max = 200)
	private String nome;
	
	
	@NotBlank
	@Size(max = 100)
	private String fabricante;
	
	@NotBlank
	@Size(max = 20)
	private String lote;
	
	@NotBlank
	@Size(max = 20)
	private String dataFabricacao;
	
	@NotBlank
	private Double valorAquisicao;
	
	@NotBlank
	private Double valorVenda;
	
	@NotBlank
	private Integer qtdEstoque;
	


}
