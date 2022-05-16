package com.jonathasdeveloper.entities.enums;

public enum TipoAtendimento {

	CONSULTA_SIMPLES(1),
	EXAME(2),
	CIRURGIA(3),
	VACINACAO(4),
	EMERGENCIA(5),
	BANHO_TOSA(6),
	OUTROS(7);
	
	
	

	private int codigo;

	private TipoAtendimento(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public static TipoAtendimento valueOf(int codigo) {
		for (TipoAtendimento value : TipoAtendimento.values()) {
			if (value.getCodigo() == codigo) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid order status code");

	}

}
