package com.daw1.gambling.sorteo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.daw1.gambling.enums.TipoSorteo;
import com.daw1.gambling.resultado.Resultado;
import com.daw1.gambling.resultado.ResultadoPrimitiva;

public class SorteoPrimitiva extends Sorteo {
	
	private final static int COMBINACION = 6;
	private final static double PRIMITIVA_PRECIO = 2;
		
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
		this.precio = PRIMITIVA_PRECIO;
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
		this.precio = PRIMITIVA_PRECIO;
	}

	@Override
	protected Resultado generarResultadoApuesta(Scanner teclado) throws IllegalStateException, NoSuchElementException, NumberFormatException {
		int[] combinacion = new int[COMBINACION];
		int reintegro;
		
		ResultadoPrimitiva resultado = null;
		try {
			for(int i = 0; i<COMBINACION; i++) {
				System.out.print("Introduzca el número "+i+" de la combinación (entre 1 y 49): ");
				combinacion[i] = Integer.parseInt(teclado.nextLine());
				
				while(combinacion[i] < 1 || combinacion[i] > 49) {
					System.out.print("Número fuera de rango, introdúzca uno entre 1 y 54: ");
					combinacion[i] = Integer.parseInt(teclado.nextLine());
				}
			}
			System.out.print("Introduzca el reintegro (entre 0 y 9, -1 para no seleccionar): ");
			reintegro = Integer.parseInt(teclado.nextLine());
			
			while(reintegro < -1 || reintegro > 9) {
				System.out.print("Número fuera de rango, introdúzca uno entre -1 y 9: ");
				reintegro = Integer.parseInt(teclado.nextLine());
			}
			
			resultado = new ResultadoPrimitiva(combinacion, reintegro);
			
		} catch (IllegalStateException | NoSuchElementException | NumberFormatException e) {
			e.printStackTrace();
			throw e;
		}
		
		return resultado;
	}

	@Override
	public String toString() {
		return "SorteoPrimitiva {" + super.toString() + "}";
	}

}
