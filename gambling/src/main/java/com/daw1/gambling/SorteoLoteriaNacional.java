package com.daw1.gambling;

import java.sql.Date;
import java.sql.Timestamp;

public class SorteoLoteriaNacional extends Sorteo {
	
	private long numero;
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
	 * @param numero
	 * @param euros
	 * @param serie
	 * @param fraccion
	 */
	public SorteoLoteriaNacional(long id, Date fechaApertura, Date fechaCierre, Timestamp fechaHora, String resultado,
			long numero, int euros, int serie, int fraccion) {
		super(id, fechaApertura, fechaCierre, fechaHora, resultado);
		this.tipo = TipoSorteo.LOTERIA_NACIONAL;
		this.numero = numero;
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
	 * @param numero
	 * @param euros
	 * @param serie
	 * @param fraccion
	 */
	public SorteoLoteriaNacional(long id, Date fechaApertura, Date fechaCierre, Timestamp fechaHora,
			long numero, int euros, int serie, int fraccion) {
		super(id, fechaApertura, fechaCierre, fechaHora);
		this.tipo = TipoSorteo.LOTERIA_NACIONAL;
		this.numero = numero;
		this.euros = euros;
		this.serie = serie;
		this.fraccion = fraccion;
	}

	@Override
	public void generarResultado() {
		// TODO Auto-generated method stub
		
	}
	
}
