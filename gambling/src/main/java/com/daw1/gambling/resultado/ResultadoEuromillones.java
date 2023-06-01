package com.daw1.gambling.resultado;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultadoEuromillones extends Resultado {

	@JsonProperty("combinacion")
	private int[] combinacion;
	@JsonProperty("estrellas")
	private int[] estrellas;

	public ResultadoEuromillones(
		@JsonProperty("combinacion")
		int[] combinacion,
		@JsonProperty("estrellas")
		int[] estrellas
	) {
		super();
		this.combinacion = combinacion;
		this.estrellas = estrellas;
	}

	@Override
	public String toString() {
		return "Resultado Euromillones:\n"
				+ "combinacion {" + Arrays.toString(combinacion) + "},"
				+ "estrellas {" + Arrays.toString(estrellas) + "}";
	}

}
