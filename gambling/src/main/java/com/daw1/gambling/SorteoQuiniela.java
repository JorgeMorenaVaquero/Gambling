package com.daw1.gambling;

import java.sql.Date;
import java.sql.Timestamp;

public class SorteoQuiniela extends Sorteo {
	
	private String equipo1;
	private String equipo2;
	private int bloque;
	//apuesta sería 1, X (empate) o 2
	private char apuesta;
	
	/**
	 * Constructor para un sorteo de quiniela con resultado
	 * 
	 * @param id
	 * @param fechaApertura
	 * @param fechaCierre
	 * @param fechaHora
	 * @param resultado
	 * @param equipo1
	 * @param equipo2
	 * @param bloque
	 * @param apuesta
	 */
	public SorteoQuiniela(long id, Date fechaApertura, Date fechaCierre, Timestamp fechaHora, ResultadoQuiniela resultado,
			String equipo1, String equipo2, int bloque, char apuesta) {
		super(id, fechaApertura, fechaCierre, fechaHora, resultado);
		this.tipo = TipoSorteo.QUINIELA;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.bloque = bloque;
		this.apuesta = apuesta;
	}
	
	/**
	 * Constructor para un sorteo de quiniela sin resultado
	 * 
	 * @param id
	 * @param fechaApertura
	 * @param fechaCierre
	 * @param fechaHora
	 * @param equipo1
	 * @param equipo2
	 * @param bloque
	 * @param apuesta
	 */
	public SorteoQuiniela(long id, Date fechaApertura, Date fechaCierre, Timestamp fechaHora,
			String equipo1, String equipo2, int bloque, char apuesta) {
		super(id, fechaApertura, fechaCierre, fechaHora);
		this.tipo = TipoSorteo.QUINIELA;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.bloque = bloque;
		this.apuesta = apuesta;
	}

	@Override
	public void generarResultado() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Apuesta generarApuesta() {
		// TODO Auto-generated method stub
		return null;
	}

}
