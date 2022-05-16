package com.jonathasdeveloper.entities.enums;

public enum StatusAtendimento {

	AGENDADO(1), 
	CANCELADO(2), 
	REALIZADO(3);

	private int codigo;

	private StatusAtendimento(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public static StatusAtendimento valueOf(int codigo) {
		for (StatusAtendimento value : StatusAtendimento.values()) {
			if (value.getCodigo() == codigo) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid order status code");

	}

}
