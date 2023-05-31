package com.daw1.gambling;

import java.sql.Date;
import java.sql.Timestamp;

public class SorteoGordo extends Sorteo {

	/**
	 * Constructor para un sorteo de el Gordo con resultado
	 * 
	 * @param id
	 * @param fechaApertura
	 * @param fechaCierre
	 * @param fechaHora
	 * @param resultado
	 */
	public SorteoGordo(long id, Date fechaApertura, Date fechaCierre, Timestamp fechaHora, ResultadoGordo resultado) {
		super(id, fechaApertura, fechaCierre, fechaHora, resultado);
		this.tipo = TipoSorteo.GORDO;
	}

	/**
	 * Constructor para un sorteo de el Gordo sin resultado
	 * 
	 * @param id
	 * @param fechaApertura
	 * @param fechaCierre
	 * @param fechaHora
	 */
	public SorteoGordo(long id, Date fechaApertura, Date fechaCierre, Timestamp fechaHora) {
		super(id, fechaApertura, fechaCierre, fechaHora);
		this.tipo = TipoSorteo.GORDO;
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
