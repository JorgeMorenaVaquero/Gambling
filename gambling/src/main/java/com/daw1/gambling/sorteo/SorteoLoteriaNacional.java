package com.daw1.gambling.sorteo;

import java.sql.Date;
import java.sql.Timestamp;

import com.daw1.gambling.Apuesta;
import com.daw1.gambling.enums.TipoSorteo;
import com.daw1.gambling.resultado.ResultadoLoteriaNacional;

public class SorteoLoteriaNacional extends Sorteo {

	/**
	 * Constructor para un sorteo de loteria nacional con resultado
	 * 
	 * @param id
	 * @param fechaApertura
	 * @param fechaCierre
	 * @param fechaHora
	 * @param resultado
	 */
	public SorteoLoteriaNacional(long id, Date fechaApertura, Date fechaCierre, Timestamp fechaHora,
			ResultadoLoteriaNacional resultado) {
		super(id, fechaApertura, fechaCierre, fechaHora, resultado);
		this.tipo = TipoSorteo.LOTERIA_NACIONAL;
	}

	/**
	 * Constructor para un sorteo de loteria nacional sin resultado
	 * 
	 * @param id
	 * @param fechaApertura
	 * @param fechaCierre
	 * @param fechaHora
	 */
	public SorteoLoteriaNacional(long id, Date fechaApertura, Date fechaCierre, Timestamp fechaHora) {
		super(id, fechaApertura, fechaCierre, fechaHora);
		this.tipo = TipoSorteo.LOTERIA_NACIONAL;
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
		return "SorteoLoteriaNacional [" + super.toString() + "]";
	}

}
