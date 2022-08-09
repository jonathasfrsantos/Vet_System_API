package com.jonathasdeveloper.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jonathasdeveloper.entities.PK.VacinacaoPK;

@Entity
@Table(name = "tb_vacinacao")
public class Vacinacao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private VacinacaoPK id = new VacinacaoPK();
	
	
	private LocalDate data_vacinacao;
	private Double valor_cobrado;
	private String dose;
	
	public Vacinacao() {
		
	}
	
	public Vacinacao(Pet pet, Vacina vacina, LocalDate data_vacinacao, Double valor_cobrado, String dose) {
		id.setPet(pet);
		id.setVacina(vacina);
		this.data_vacinacao = data_vacinacao;
		this.valor_cobrado = valor_cobrado;
		this.dose = dose;
				
	}
	@JsonIgnore
	public Pet getPet() {
		return id.getPet();
	}
	
	public void setPet(Pet pet) {
		id.setPet(pet);
	}

	public Vacina getVacina() {
		return id.getVacina();
	}
	
	public void setVacina(Vacina vacina) {
		id.setVacina(vacina);
	}

	public LocalDate getData_vacinacao() {
		return data_vacinacao;
	}

	public void setData_vacinacao(LocalDate data_vacinacao) {
		this.data_vacinacao = data_vacinacao;
	}

	public Double getValor_cobrado() {
		return valor_cobrado;
	}

	public void setValor_cobrado(Double valor_cobrado) {
		this.valor_cobrado = valor_cobrado;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vacinacao other = (Vacinacao) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	

}
