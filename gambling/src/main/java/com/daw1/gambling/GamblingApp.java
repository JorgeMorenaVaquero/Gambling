package com.daw1.gambling;

import java.util.Scanner;

public class GamblingApp {

	private Scanner teclado;
	private Jugador jugador;

	public GamblingApp() {
		super();
		this.teclado = new Scanner(System.in);
	}

	private void mostrarMenuNoRegistrado() {
		System.out.println("1 - Login");
		System.out.println("2 - Registrarse");
	}

	private void mostrarMenuRegistrado() {
		System.out.println("1 - Ver saldo");
	}

	private void mostrarMenu() {
		if (jugador == null) {
			mostrarMenuNoRegistrado();
		} else {
			mostrarMenuRegistrado();
		}
	}
	
	private void seleccionarOpcionNoRegistrado(int opcion) {
		
	}
	
	private void seleccionarOpcionRegistrado(int opcion) {
		
	}

	private void seleccionarOpcion(int opcion) {
		if (jugador == null) {
			seleccionarOpcionNoRegistrado(opcion);
		} else {
			seleccionarOpcionRegistrado(opcion);
		}
	}

	/**
	 * Método para iniciar la aplicación
	 */
	public void iniciar() {
		boolean finalizado = false;

		while (!finalizado) {
			mostrarMenu();
			System.out.println("Introduce -1 para finalizar");
			
			int opcion = Integer.parseInt(teclado.nextLine());
			if (opcion == -1) {
				finalizado = true;
			} else {
				seleccionarOpcion(opcion);
			}
		}
	}

}
