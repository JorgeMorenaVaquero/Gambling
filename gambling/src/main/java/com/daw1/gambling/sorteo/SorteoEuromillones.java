package com.daw1.gambling.sorteo;

import java.sql.Date;
import java.sql.Timestamp;
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
	public void generarResultado() {
		// TODO Auto-generated method stub
	}

	@Override
	protected Resultado generarResultadoApuesta(Scanner teclado) {
		
		int[] combinacion = new int[COMBINACION];
		int[] estrellas = new int[ESTRELLAS];
		
		System.out.println("Introduzca una combinacion de seis numeros entre 1 y 50 cada uno: ");
		
		for (int i = 0; i < COMBINACION; i++) {
			System.out.print("Numero "+(i+1)+": ");
			combinacion[i] = numeroCorrectoCombinacion(teclado);
		}
		
		System.out.println("Introduzca una combinacion de dos numeros de estrellas entre 1 y 12 cada uno: ");
		
		for (int i = 0; i < ESTRELLAS; i++) {
			System.out.print("Numero "+(i+1)+": ");
			estrellas[i] = numeroCorrectoEstrellas(teclado);
		}
		
		ResultadoEuromillones euromillones = new ResultadoEuromillones(combinacion, estrellas);
		
		return euromillones;
	}
	
	private int numeroCorrectoCombinacion(Scanner teclado) {
		boolean correcto = false;
		int numero = Integer.parseInt(teclado.nextLine());
		
		while(!correcto) {
			
			if (numero < 1 || numero > 50) {
				numero = Integer.parseInt(teclado.nextLine());
			} else {
				correcto = true;
			}
		}
		
		return numero;
	}
	
	private int numeroCorrectoEstrellas(Scanner teclado) {
		boolean correcto = false;
		int numero = Integer.parseInt(teclado.nextLine());
		
		while(!correcto) {
			
			if (numero < 1 || numero > 12) {
				numero = Integer.parseInt(teclado.nextLine());
			} else {
				correcto = true;
			}
		}
		
		return numero;
	}
	
	@Override
	public String toString() {
		return "SorteoEuromillones [" + super.toString() + "]";
	}

}
