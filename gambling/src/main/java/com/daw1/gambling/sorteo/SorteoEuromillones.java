package com.daw1.gambling.sorteo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.daw1.gambling.enums.TipoSorteo;
import com.daw1.gambling.resultado.Resultado;
import com.daw1.gambling.resultado.ResultadoEuromillones;

public class SorteoEuromillones extends Sorteo {

	private static final int COMBINACION = 6;
	private static final int ESTRELLAS = 2;
	
	private static final double EUROMILLONES_PRECIO = 2.5;
	
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
		this.precio = EUROMILLONES_PRECIO;
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
		this.precio = EUROMILLONES_PRECIO;
	}

	@Override
	protected Resultado generarResultadoApuesta(Scanner teclado) throws IllegalStateException, NoSuchElementException, NumberFormatException {
		
		int[] combinacion = new int[COMBINACION];
		int[] estrellas = new int[ESTRELLAS];
		
		ResultadoEuromillones euromillones = null;
		
		try {
			
			for(int i = 0; i<COMBINACION; i++) {
				System.out.print("Introduzca el número "+i+" de la combinación (entre 1 y 50): ");
				combinacion[i] = Integer.parseInt(teclado.nextLine());
				
				while(combinacion[i] < 1 || combinacion[i] > 50) {
					System.out.print("Número fuera de rango, introdúzca uno entre 1 y 50: ");
					combinacion[i] = Integer.parseInt(teclado.nextLine());
				}
			}
			
			for(int i = 0; i<COMBINACION; i++) {
				System.out.print("Introduzca el número "+i+" de las estrellas (entre 1 y 12): ");
				estrellas[i] = Integer.parseInt(teclado.nextLine());
				
				while(estrellas[i] < 1 || estrellas[i] > 12) {
					System.out.print("Número fuera de rango, introdúzca uno entre 1 y 12: ");
					estrellas[i] = Integer.parseInt(teclado.nextLine());
				}
			}
			
			euromillones = new ResultadoEuromillones(combinacion, estrellas);
		} catch (IllegalStateException | NoSuchElementException | NumberFormatException e) {
			e.printStackTrace();
			throw e;
		}
		
		return euromillones;
	}
	
	@Override
	public String toString() {
		return "SorteoEuromillones {" + super.toString() + "}";
	}

}
