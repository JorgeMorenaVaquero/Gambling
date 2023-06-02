package com.daw1.gambling.sorteo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.daw1.gambling.enums.TipoSorteo;
import com.daw1.gambling.resultado.Resultado;
import com.daw1.gambling.resultado.ResultadoLoteriaNacional;

public class SorteoLoteriaNacional extends Sorteo {
	
	private static final double LOTERIA_NACIONAL_PRECIO = 3;

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
		this.precio = LOTERIA_NACIONAL_PRECIO;
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
		this.precio = LOTERIA_NACIONAL_PRECIO;
	}
	
	private int pedirNumeroCifras(Scanner teclado, int maximo) throws IllegalStateException, NoSuchElementException, NumberFormatException {
		int numero = 0;
		
		try {
			numero = Integer.parseInt(teclado.nextLine());
			
			if (numero < 0 || numero > maximo) {
				System.out.print("Debes introducir un número entre 0 y " + maximo + ": ");
				numero = pedirNumeroCifras(teclado, maximo);
			}
		} catch (IllegalStateException | NoSuchElementException | NumberFormatException e) {
			e.printStackTrace();
			throw e;
		}
		
		return numero;
	}

	@Override
	protected Resultado generarResultadoApuesta(Scanner teclado) throws IllegalStateException, NoSuchElementException, NumberFormatException {
		ResultadoLoteriaNacional resultadoApuesta = null;
		
		try {
			System.out.print("Número de boleto (0 - " + ResultadoLoteriaNacional.MAXIMO_NUMERO + "): ");
			int numero = pedirNumeroCifras(teclado, ResultadoLoteriaNacional.MAXIMO_NUMERO);

			System.out.print("Número de boleto (0 - " + ResultadoLoteriaNacional.MAXIMO_EUROS + "): ");
			int euros = pedirNumeroCifras(teclado, ResultadoLoteriaNacional.MAXIMO_EUROS);

			System.out.print("Número de boleto (0 - " + ResultadoLoteriaNacional.MAXIMO_SERIE + "): ");
			int serie = pedirNumeroCifras(teclado, ResultadoLoteriaNacional.MAXIMO_SERIE);

			System.out.print("Número de boleto (0 - " + ResultadoLoteriaNacional.MAXIMO_FRACCION + "): ");
			int fraccion = pedirNumeroCifras(teclado, ResultadoLoteriaNacional.MAXIMO_FRACCION);
			
			resultadoApuesta = new ResultadoLoteriaNacional(numero, euros, serie, fraccion);
		} catch (IllegalStateException | NoSuchElementException | NumberFormatException e) {
			e.printStackTrace();
			throw e;
		}

		return resultadoApuesta;
	}

	@Override
	public String toString() {
		return "SorteoLoteriaNacional {" + super.toString() + "}";
	}

}
