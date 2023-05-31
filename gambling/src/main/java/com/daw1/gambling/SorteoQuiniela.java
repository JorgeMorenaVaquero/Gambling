package com.daw1.gambling;

import java.sql.Date;
import java.sql.Timestamp;

public class SorteoQuiniela extends Sorteo {
	
	
	
	/**
	 * Constructor para un sorteo de quiniela con resultado
	 * 
	 * @param id
	 * @param fechaApertura
	 * @param fechaCierre
	 * @param fechaHora
	 * @param resultado
	 */
	public SorteoQuiniela(long id, Date fechaApertura, Date fechaCierre, Timestamp fechaHora, ResultadoQuiniela resultado) {
		super(id, fechaApertura, fechaCierre, fechaHora, resultado);
		this.tipo = TipoSorteo.QUINIELA;
	}
	
	/**
	 * Constructor para un sorteo de quiniela sin resultado
	 * 
	 * @param id
	 * @param fechaApertura
	 * @param fechaCierre
	 * @param fechaHora
	 */
	public SorteoQuiniela(long id, Date fechaApertura, Date fechaCierre, Timestamp fechaHora) {
		super(id, fechaApertura, fechaCierre, fechaHora);
		this.tipo = TipoSorteo.QUINIELA;
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
