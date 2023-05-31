package com.daw1.gambling;

import java.sql.Date;
import java.sql.Timestamp;

public class SorteoEuromillones extends Sorteo {

	private int[] combinacion;
	private int[] estrellas;

	/**
	 * Constructor de un sorteo de euromillones con resultado
	 * 
	 * @param id
	 * @param fechaApertura
	 * @param fechaCierre
	 * @param fechaHora
	 * @param resultado
	 * @param combinacion
	 * @param estrellas
	 */
	public SorteoEuromillones(long id, Date fechaApertura, Date fechaCierre, Timestamp fechaHora, ResultadoEuromillones resultado,
			int[] combinacion, int[] estrellas) {
		super(id, fechaApertura, fechaCierre, fechaHora, resultado);
		this.tipo = TipoSorteo.EUROMILLONES;
		this.combinacion = combinacion;
		this.estrellas = estrellas;
	}

	/**
	 * Constructor de un sorteo de euromillones sin resultado
	 * 
	 * @param id
	 * @param fechaApertura
	 * @param fechaCierre
	 * @param fechaHora
	 * @param resultado
	 * @param combinacion
	 * @param estrellas
	 */
	public SorteoEuromillones(long id, Date fechaApertura, Date fechaCierre, Timestamp fechaHora, int[] combinacion,
			int[] estrellas) {
		super(id, fechaApertura, fechaCierre, fechaHora);
		this.tipo = TipoSorteo.EUROMILLONES;
		this.combinacion = combinacion;
		this.estrellas = estrellas;
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
