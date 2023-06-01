package com.daw1.gambling.resultado;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultadoQuiniela extends Resultado {

	private String equipo1;
	private String equipo2;
	private int bloque;
	private char apuesta;

	public ResultadoQuiniela(
		@JsonProperty("equipo1")
		String equipo1, 
		@JsonProperty("equipo2")
		String equipo2,
		@JsonProperty("bloque")
		int bloque,
		@JsonProperty("apuesta")
		char apuesta
	) {
		super();
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.bloque = bloque;
		this.apuesta = apuesta;
	}

	@Override
	public String toString() {
		return "ResultadoQuiniela:\n"
				+ "equipo1 {" + equipo1 + "}, equipo2 {" + equipo2 + "}, bloque {" + bloque + "}, apuesta {"
				+ apuesta + "}";
	}

}
