package com.jonathasdeveloper.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_vacina")
public class Vacina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String fabricante;
	private String lote;
	private String dataFabricacao;
	private Double valor;

	public Vacina() {

	}

	public Vacina(Long id, String nome, String fabricante, String lote, String dataFabricacao, Double valor) {
		this.id = id;
		this.nome = nome;
		this.fabricante = fabricante;
		this.lote = lote;
		this.dataFabricacao = dataFabricacao;
		this.valor = valor;
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

	@Override
	public int hashCode() {
		return Objects.hash(dataFabricacao, fabricante, id, lote, nome, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vacina other = (Vacina) obj;
		return Objects.equals(dataFabricacao, other.dataFabricacao) && Objects.equals(fabricante, other.fabricante)
				&& Objects.equals(id, other.id) && Objects.equals(lote, other.lote) && Objects.equals(nome, other.nome)
				&& Objects.equals(valor, other.valor);
	}

}
