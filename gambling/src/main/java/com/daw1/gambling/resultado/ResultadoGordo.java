package com.daw1.gambling.resultado;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultadoGordo extends Resultado {
	
	private int[] combinacion;
	private int numClave;
	private int reintegro;
	
	public ResultadoGordo(
		@JsonProperty("combinacion")
		int[] combinacion, 
		@JsonProperty("numClave")
		int numClave, 
		@JsonProperty("reintegro")
		int reintegro
	) {
		super();
		this.combinacion = combinacion;
		this.numClave = numClave;
		this.reintegro = reintegro;
	}

	@Override
	public String toString() {
		return "Resultado Gordo:\n"
				+ "combinacion {" + Arrays.toString(combinacion) + "}, numClave {" + numClave + "}, "
				+ "reintegro {" + reintegro + "}";
	}
	
	

}
