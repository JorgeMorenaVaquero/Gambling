package com.daw1.gambling.resultado;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultadoPrimitiva extends Resultado {
	
	private int[] combinacion;
	private int reintegro;
	
	public ResultadoPrimitiva(
		@JsonProperty("combinacion")
		int[] combinacion, 
		@JsonProperty("reintegro")
		int reintegro
	) {
		super();
		this.combinacion = combinacion;
		this.reintegro = reintegro;
	}



	@Override
	public String toString() {
		return "Resultado Euromillones:\n"
				+ "combinacion {" + Arrays.toString(combinacion) + "},"
				+ "reintegro {" + reintegro + "}";
	}

}
