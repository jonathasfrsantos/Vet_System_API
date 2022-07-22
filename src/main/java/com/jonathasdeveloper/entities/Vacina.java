package com.jonathasdeveloper.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_vacina")
public class Vacina implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(nullable = false, unique = true, length = 200)
	private String nome;
	
	@NotBlank
	@Column(nullable = false, unique = true, length = 100)
	private String fabricante;
	
	@NotBlank
	@Column(nullable = false, length = 20)
	private String lote;
	
	@NotBlank
	@Column(nullable = false, length = 20)
	private String dataFabricacao;
	

	private Double valorAquisicao;
	

	private Double valorVenda;
	

	private Integer qtdEstoque;


}
