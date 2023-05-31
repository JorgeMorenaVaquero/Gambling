package com.daw1.gambling.resultado;

public class ResultadoQuiniela extends Resultado {
	
	private String equipo1;
	private String equipo2;
	private int bloque;
	//apuesta sería 1, X (empate) o 2
	private char apuesta;
	
	@Override
	public String toString() {
		return "ResultadoQuiniela:\n"
				+ "equipo1 {" + equipo1 + "}, equipo2 {" + equipo2 + "}, bloque {" + bloque + "}, apuesta {"
				+ apuesta + "}";
	}
	
	

}
