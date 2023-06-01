package com.daw1.gambling.sorteo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Scanner;

import com.daw1.gambling.Apuesta;
import com.daw1.gambling.enums.TipoSorteo;
import com.daw1.gambling.resultado.ResultadoGordo;

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
	public Apuesta generarApuesta(Scanner teclado, long idJugador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "SorteoGordo [" + super.toString() + "]";
	}

}
