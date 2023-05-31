package com.daw1.gambling.sorteo;

import java.sql.Date;
import java.sql.Timestamp;

import com.daw1.gambling.Apuesta;
import com.daw1.gambling.enums.TipoSorteo;
import com.daw1.gambling.resultado.ResultadoPrimitiva;

public class SorteoPrimitiva extends Sorteo {

	/**
	 * Constructor para un sorteo de primitiva con resultado
	 * 
	 * @param id
	 * @param fechaApertura
	 * @param fechaCierre
	 * @param fechaHora
	 * @param tipo
	 * @param resultado
	 */
	public SorteoPrimitiva(long id, Date fechaApertura, Date fechaCierre, Timestamp fechaHora,
			ResultadoPrimitiva resultado) {
		super(id, fechaApertura, fechaCierre, fechaHora, resultado);
		this.tipo = TipoSorteo.PRIMITIVA;
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
	 */
	public SorteoPrimitiva(long id, Date fechaApertura, Date fechaCierre, Timestamp fechaHora, int[] combinacion,
			int reintegro) {
		super(id, fechaApertura, fechaCierre, fechaHora);
		this.tipo = TipoSorteo.PRIMITIVA;
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

	@Override
	public String toString() {
		return "SorteoPrimitiva [" + super.toString() + "]";
	}

}
