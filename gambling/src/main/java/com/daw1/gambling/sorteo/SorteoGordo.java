package com.daw1.gambling.sorteo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.daw1.gambling.enums.TipoSorteo;
import com.daw1.gambling.resultado.Resultado;
import com.daw1.gambling.resultado.ResultadoGordo;

public class SorteoGordo extends Sorteo {
	
	private final static int COMBINACION = 5;
	private final static double GORDO_PRECIO = 1.5;
	
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
		this.precio = GORDO_PRECIO;
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
		this.precio = GORDO_PRECIO;
	}

	@Override
	public void generarResultado() {
		// TODO Auto-generated method stub
	}

	@Override
	protected Resultado generarResultadoApuesta(Scanner teclado) throws IllegalStateException, NoSuchElementException, NumberFormatException {
		int[] combinacion = new int[COMBINACION];
		int numClave;
		
		ResultadoGordo resultado = null;
		try {
			for(int i = 0; i<COMBINACION; i++) {
				System.out.print("Introduzca el número "+i+" de la combinación (entre 1 y 54): ");
				combinacion[i] = Integer.parseInt(teclado.nextLine());
				
				while(combinacion[i] < 1 || combinacion[i] > 54) {
					System.out.print("Número fuera de rango, introdúzca uno entre 1 y 54: ");
					combinacion[i] = Integer.parseInt(teclado.nextLine());
				}
			}
			System.out.print("Introduzca el Nº clave (entre 0 y 9): ");
			numClave = Integer.parseInt(teclado.nextLine());
			
			while(numClave < 0 || numClave > 9) {
				System.out.print("Número fuera de rango, introdúzca uno entre 0 y 9: ");
				numClave = Integer.parseInt(teclado.nextLine());
			}
			
			resultado = new ResultadoGordo(combinacion, numClave, 0);
			
		} catch (IllegalStateException | NoSuchElementException | NumberFormatException e) {
			e.printStackTrace();
			throw e;
		}
		
		return resultado;
	}

	@Override
	public String toString() {
		return "SorteoGordo {" + super.toString() + "}";
	}

}
