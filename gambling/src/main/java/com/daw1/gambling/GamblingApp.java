package com.daw1.gambling;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.daw1.gambling.controller.ApuestaController;
import com.daw1.gambling.controller.JugadorController;
import com.daw1.gambling.controller.SorteoController;
import com.daw1.gambling.service.AutentificacionService;
import com.daw1.gambling.sorteo.Sorteo;

public class GamblingApp {

	private Scanner teclado;

	private JugadorController jugadorController;
	private SorteoController sorteoController;
	private ApuestaController apuestaController;

	private AutentificacionService autService;

	private Jugador jugador;

	public GamblingApp() {
		super();
		this.teclado = new Scanner(System.in);
		this.jugadorController = new JugadorController();
		this.sorteoController = new SorteoController();
		this.apuestaController = new ApuestaController();
		this.autService = new AutentificacionService();
	}

	private void mostrarMenuNoRegistrado() {
		System.out.println("1 - Login");
		System.out.println("2 - Registrarse");
	}

	private void mostrarMenuRegistrado() {
		System.out.println("1 - Ver saldo");
		System.out.println("2 - Ver apuestas realizadas");
		System.out.println("3 - Ver sorteos activos");
		System.out.println("4 - Cerrar sesión");
	}

	private void mostrarMenu() {
		if (jugador == null) {
			mostrarMenuNoRegistrado();
		} else {
			mostrarMenuRegistrado();
		}
	}

	private void seleccionarOpcionNoRegistrado(int opcion) throws Exception {
		switch (opcion) {
			case 1:
				login();
				break;

			case 2:
				registrarse();
				break;
		}
	}

	private void seleccionarOpcionRegistrado(int opcion) throws Exception {
		switch (opcion) {
			case 1:
				mostrarSaldo();
				break;
				
			case 2:
				mostrarApuestasRealizadas();
				break;
				
			case 3:
				mostrarSorteosActivos();
				break;
				
			case 4:
				cerrarSesion();
				break;
		}
	}

	private void seleccionarOpcion(int opcion) throws Exception {
		if (jugador == null) {
			try {
				seleccionarOpcionNoRegistrado(opcion);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		} else {
			seleccionarOpcionRegistrado(opcion);
		}
	}
	
	private void login() throws Exception {
		String correoElectronico = null;
		String contrasenna = null;

		try {
			System.out.println("Introduzca los siguientes datos para iniciar sesión");
	
			System.out.print("Correo electronico: ");
			correoElectronico = teclado.nextLine().trim();
	
			System.out.print("Contraseña: ");
			contrasenna = teclado.nextLine().trim();
		} catch(IllegalStateException | NoSuchElementException e) {
			e.printStackTrace();
			throw e;
		}

		long idJugador;
		try {
			idJugador = autService.introducirLogin(correoElectronico, contrasenna);

			if (idJugador > 0) {
				jugador = jugadorController.getJugador(idJugador);
				System.out.println("Bienvenido de vuelta");
			} else {
				System.out.println("Correo electrónico y/o contraseña incorrecto");
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private void registrarse() throws Exception {
		Jugador nuevoJugador = null;

		try {
			System.out.println("Introduzca los siguientes datos para registrarse");

			System.out.print("DNI: ");
			String dni = teclado.nextLine().trim();

			System.out.print("Telefono: ");
			String telefono = teclado.nextLine().trim();

			System.out.print("Correo electronico: ");
			String correoElectronico = teclado.nextLine().trim();

			System.out.print("Contraseña: ");
			String contrasenna = teclado.nextLine().trim();

			System.out.print("Saldo inicial: ");
			BigDecimal dinero = new BigDecimal(Integer.parseInt(teclado.nextLine()));

			nuevoJugador = new Jugador(dni, dinero, correoElectronico, contrasenna, telefono);
		} catch (IllegalStateException | NoSuchElementException | NumberFormatException e) {
			e.printStackTrace();
			throw e;
		}

		try {
			if (autService.puedeRegistrarse(nuevoJugador)) {
				jugadorController.insertJugador(nuevoJugador);
				jugador = nuevoJugador;
			} else {
				System.out.println("Ya existe una cuenta con esos datos.");
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void cerrarSesion() {
		jugador = null;
		System.out.println("Has cerrado sesión");
	}

	private void mostrarSaldo() {
		System.out.print("Saldo actual: ");
		System.out.println(jugador.getDinero());
	}

	private void mostrarApuestasRealizadas() throws Exception {
		List<Apuesta> apuestas = null;

		try {
			apuestas = apuestaController.getApuestasJugador(jugador.getId());
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			throw e;
		}

		if (apuestas.isEmpty()) {
			System.out.println("No has realizado ninguna apuesta.");
		} else {
			System.out.println("Apuestas realizadas:");
			for (Apuesta apuesta : apuestas) {
				System.out.println(apuesta);
				System.out.println();
			}
		}
	}
	
	private void mostrarSorteosActivos() throws Exception {
		List<Sorteo> sorteos = null;

		try {
			sorteos = sorteoController.getSorteosAbiertos();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			throw e;
		}

		if (sorteos.isEmpty()) {
			System.out.println("No hay ningún sorteo activo.");
		} else {
			System.out.println("Sorteos activos:");
			for (Sorteo sorteo : sorteos) {
				System.out.println(sorteo);
				System.out.println();
			}
		}
	}

	/**
	 * Método para iniciar la aplicación
	 * 
	 * @throws Exception 
	 */
	public void iniciar() throws Exception {
		boolean finalizado = false;

		while (!finalizado) {
			mostrarMenu();
			System.out.println("Introduce -1 para finalizar");

			System.out.print("Opción: ");
			int opcion = Integer.parseInt(teclado.nextLine());

			if (opcion == -1) {
				finalizado = true;
			} else {
				seleccionarOpcion(opcion);
			}
			
			System.out.println();
		}
	}

}
