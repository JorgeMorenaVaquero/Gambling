package com.daw1.gambling;

import java.sql.Date;
import java.sql.Timestamp;

public class SorteoGordo extends Sorteo {
	
	private int[] combinacion;
	private int numClave;
	private int reintegro;
	
	/**
	 * Constructor para un sorteo de el Gordo con resultado
	 * 
	 * @param id
	 * @param fechaApertura
	 * @param fechaCierre
	 * @param fechaHora
	 * @param resultado
	 * @param combinacion
	 * @param numClave
	 * @param reintegro
	 */
	public SorteoGordo(long id, Date fechaApertura, Date fechaCierre, Timestamp fechaHora, String resultado,
			int[] combinacion, int numClave, int reintegro) {
		super(id, fechaApertura, fechaCierre, fechaHora, resultado);
		this.tipo = TipoSorteo.GORDO;
		this.combinacion = combinacion;
		this.numClave = numClave;
		this.reintegro = reintegro;
	}
	
	/**
	 * Constructor para un sorteo de el Gordo sin resultado
	 * @param id
	 * @param fechaApertura
	 * @param fechaCierre
	 * @param fechaHora
	 * @param combinacion
	 * @param numClave
	 * @param reintegro
	 */
	public SorteoGordo(long id, Date fechaApertura, Date fechaCierre, Timestamp fechaHora,
			int[] combinacion, int numClave, int reintegro) {
		super(id, fechaApertura, fechaCierre, fechaHora);
		this.tipo = TipoSorteo.GORDO;
		this.combinacion = combinacion;
		this.numClave = numClave;
		this.reintegro = reintegro;
	}
	
	@Override
	public void generarResultado() {
		// TODO Auto-generated method stub
		
	}
	
	

}
