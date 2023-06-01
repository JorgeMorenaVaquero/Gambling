package com.daw1.gambling.sorteo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Scanner;

import com.daw1.gambling.enums.TipoSorteo;
import com.daw1.gambling.resultado.Resultado;
import com.daw1.gambling.resultado.ResultadoEuromillones;

public class SorteoEuromillones extends Sorteo {

	/**
	 * Constructor de un sorteo de euromillones con resultado
	 * 
	 * @param id
	 * @param fechaApertura
	 * @param fechaCierre
	 * @param fechaHora
	 * @param resultado
	 */
	public SorteoEuromillones(long id, Date fechaApertura, Date fechaCierre, Timestamp fechaHora,
			ResultadoEuromillones resultado) {
		super(id, fechaApertura, fechaCierre, fechaHora, resultado);
		this.tipo = TipoSorteo.EUROMILLONES;
	}

	/**
	 * Constructor de un sorteo de euromillones sin resultado
	 * 
	 * @param id
	 * @param fechaApertura
	 * @param fechaCierre
	 * @param fechaHora
	 * @param resultado
	 */
	public SorteoEuromillones(long id, Date fechaApertura, Date fechaCierre, Timestamp fechaHora) {
		super(id, fechaApertura, fechaCierre, fechaHora);
		this.tipo = TipoSorteo.EUROMILLONES;
	}
	
	@Override
	public void generarResultado() {
		// TODO Auto-generated method stub
	}

	@Override
	protected Resultado generarResultadoApuesta(Scanner teclado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "SorteoEuromillones [" + super.toString() + "]";
	}

}
