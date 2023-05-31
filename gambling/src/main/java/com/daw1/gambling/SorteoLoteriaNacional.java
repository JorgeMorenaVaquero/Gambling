package com.daw1.gambling;

import java.sql.Date;
import java.sql.Timestamp;

public class SorteoLoteriaNacional extends Sorteo {
	
	private int euros;
	private int serie;
	private int fraccion;
	
	/**
	 * Constructor para un sorteo de loteria nacional con resultado
	 * 
	 * @param id
	 * @param fechaApertura
	 * @param fechaCierre
	 * @param fechaHora
	 * @param resultado
	 * @param euros
	 * @param serie
	 * @param fraccion
	 */
	public SorteoLoteriaNacional(long id, Date fechaApertura, Date fechaCierre, Timestamp fechaHora, ResultadoLoteriaNacional resultado,
			int euros, int serie, int fraccion) {
		super(id, fechaApertura, fechaCierre, fechaHora, resultado);
		this.tipo = TipoSorteo.LOTERIA_NACIONAL;
		this.euros = euros;
		this.serie = serie;
		this.fraccion = fraccion;
	}
	
	/**
	 * Constructor para un sorteo de loteria nacional sin resultado
	 * @param id
	 * @param fechaApertura
	 * @param fechaCierre
	 * @param fechaHora
	 * @param euros
	 * @param serie
	 * @param fraccion
	 */
	public SorteoLoteriaNacional(long id, Date fechaApertura, Date fechaCierre, Timestamp fechaHora,
			int euros, int serie, int fraccion) {
		super(id, fechaApertura, fechaCierre, fechaHora);
		this.tipo = TipoSorteo.LOTERIA_NACIONAL;
		this.euros = euros;
		this.serie = serie;
		this.fraccion = fraccion;
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
