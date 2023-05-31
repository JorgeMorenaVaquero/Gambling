package com.daw1.gambling.resultado;

import java.util.Arrays;

public class ResultadoGordo extends Resultado {
	
	private int[] combinacion;
	private int numClave;
	private int reintegro;
	
	@Override
	public String toString() {
		return "Resultado Gordo:\n"
				+ "combinacion {" + Arrays.toString(combinacion) + "}, numClave {" + numClave + "}, "
				+ "reintegro {" + reintegro + "}";
	}
	
	

}
