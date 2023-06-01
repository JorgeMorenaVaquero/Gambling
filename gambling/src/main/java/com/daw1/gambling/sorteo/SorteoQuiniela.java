package com.daw1.gambling.sorteo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.daw1.gambling.enums.TipoSorteo;
import com.daw1.gambling.resultado.Resultado;
import com.daw1.gambling.resultado.ResultadoQuiniela;

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
	public SorteoQuiniela(long id, Date fechaApertura, Date fechaCierre, Timestamp fechaHora,
			ResultadoQuiniela resultado) {
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
	protected Resultado generarResultadoApuesta(Scanner teclado) throws IllegalStateException, NoSuchElementException, NumberFormatException {
		String equipo1, equipo2;
		char apuesta;
		
		ResultadoQuiniela resultado = null;
		try {
			System.out.print("Introduzca el nombre del primer equipo: ");
			equipo1 = teclado.nextLine().trim();
			
			System.out.print("Introduzca el nombre del segundo equipo: ");
			equipo2 = teclado.nextLine().trim();
			
			System.out.print("Introduzca la apuesta (1, X o 2): ");
			apuesta = teclado.nextLine().charAt(0);
			
			while(apuesta != '1' || apuesta != 'X' || apuesta != '2') {
				System.out.print("Apuesta inválida, introduzca una dentro del rango (1, X o 2): ");
				apuesta = teclado.nextLine().charAt(0);
			}
			
			resultado = new ResultadoQuiniela(equipo1, equipo2, apuesta);
			
		} catch (IllegalStateException | NoSuchElementException | NumberFormatException e) {
			e.printStackTrace();
			throw e;
		}
		
		return resultado;
	}

	@Override
	public String toString() {
		return "SorteoQuiniela [" + super.toString() + "]";
	}

}
