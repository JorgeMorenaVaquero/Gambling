package com.daw1.gambling;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

import com.daw1.gambling.controller.ApuestaController;
import com.daw1.gambling.controller.JugadorController;
import com.daw1.gambling.controller.SorteoController;
import com.daw1.gambling.service.AutentificacionService;

public class GamblingApp {

	private Scanner teclado;

	private JugadorController jugadorController;
	private SorteoController sorteoController;
	private ApuestaController apuestaController;

	private AutentificacionService outService;

	private Jugador jugador;

	public GamblingApp() {
		super();
		this.teclado = new Scanner(System.in);
		this.jugadorController = new JugadorController();
		this.sorteoController = new SorteoController();
		this.apuestaController = new ApuestaController();
		this.outService = new AutentificacionService();
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
		System.out.println("Introduzca los siguientes datos para registrarse:");

		System.out.println("DNI\n");
		String dni = teclado.nextLine();

		System.out.println("Telefono\n");
		String telefono = teclado.nextLine();

		System.out.println("Correo electronico\n");
		String correoElectronico = teclado.nextLine();

		System.out.println("Contraseña\n");
		String contrasenna = teclado.nextLine();

		System.out.println("Saldo inicial\n");
		BigDecimal dinero = new BigDecimal(Integer.parseInt(teclado.nextLine()));

		jugador = new Jugador(dni, dinero, correoElectronico, contrasenna, telefono);

		try {
			if (outService.puedeRegistrarse(jugador)) {
				jugadorController.insertJugador(jugador);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}

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
