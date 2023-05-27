package com.daw1.gambling;

import java.sql.Date;
import java.sql.Timestamp;

public class SorteoPrimitiva extends Sorteo{
	
	private int[] combinacion;
	private int reintegro;
	
	/**
	 * Constructor para un sorteo de primitiva con resultado
	 * 
	 * @param id
	 * @param fechaApertura
	 * @param fechaCierre
	 * @param fechaHora
	 * @param tipo
	 * @param resultado
	 * @param combinacion
	 * @param reintegro
	 */
	public SorteoPrimitiva(long id, Date fechaApertura, Date fechaCierre, Timestamp fechaHora,
			String resultado, int[] combinacion, int reintegro) {
		super(id, fechaApertura, fechaCierre, fechaHora, resultado);
		this.tipo = TipoSorteo.PRIMITIVA;
		this.combinacion = combinacion;
		this.reintegro = reintegro;
	}
	
	/**
	 * Constructor para un sorteo de primitiva sin resultado
	 * 
	 * @param id
	 * @param fechaApertura
	 * @param fechaCierre
	 * @param fechaHora
	 * @param tipo
	 * @param resultado
	 * @param combinacion
	 * @param reintegro
	 */
	public SorteoPrimitiva(long id, Date fechaApertura, Date fechaCierre, Timestamp fechaHora,
			int[] combinacion, int reintegro) {
		super(id, fechaApertura, fechaCierre, fechaHora);
		this.tipo = TipoSorteo.PRIMITIVA;
		this.combinacion = combinacion;
		this.reintegro = reintegro;
	}

	@Override
	public void generarResultado() {
		// TODO Auto-generated method stub
		
	}

}
