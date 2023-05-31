package com.daw1.gambling.resultado;

import java.util.Arrays;

public class ResultadoEuromillones extends Resultado {
	
	private int[] combinacion;
	private int[] estrellas;
	
	@Override
	public String toString() {
		return "Resultado Euromillones:\n"
				+ "combinacion {" + Arrays.toString(combinacion) + "},"
				+ "estrellas {" + Arrays.toString(estrellas) + "}";
	}
	
	

}
