package com.daw1.gambling.resultado;

import java.util.Arrays;

public class ResultadoPrimitiva extends Resultado {
	
	private int[] combinacion;
	private int reintegro;
	
	@Override
	public String toString() {
		return "Resultado Euromillones:\n"
				+ "combinacion {" + Arrays.toString(combinacion) + "},"
				+ "reintegro {" + reintegro + "}";
	}

}
