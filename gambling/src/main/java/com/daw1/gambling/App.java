package com.daw1.gambling;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import com.daw1.gambling.controller.ApuestaController;
import com.daw1.gambling.controller.JugadorController;
import com.daw1.gambling.controller.SorteoController;
import com.daw1.gambling.service.AutentificacionService;
import com.daw1.gambling.sorteo.Sorteo;

public class App {
	
    public static void main(String[] args) throws Exception {
    	GamblingApp app = new GamblingApp();
    	
    	//app.iniciar();
    	
		ConexionBaseDeDatos.getConexion();
		
		
		JugadorController jugadorController = new JugadorController();
		
		Jugador jugador = new Jugador("05123456B", new BigDecimal(300), "correo.prueba@pureba.com", "jugadorPrueba", "+34666777889");
		//jugadorController.insertJugador(jugador);
		
		
		ApuestaController apuestasController = new ApuestaController();
		
		/*
		for (Apuesta apuesta : apuestasController.seleccionarApuestasJugador(1)) {
			System.out.println(apuesta);
		}
		*/
		
		
		SorteoController sorteoController = new SorteoController();
		
		/*
		for (Sorteo sorteo : sorteoController.getSorteos()) {
			System.out.println(sorteo);
		}
		*/

		AutentificacionService autentificacionService = new AutentificacionService();
		
		System.out.println(autentificacionService.introducirLogin("correo.prueba@pureba.com", "jugadorPrueba82"));
		System.out.println(autentificacionService.introducirLogin("correo.prueba@pureba.com", "jugadorPrueba"));
		
		System.out.println(autentificacionService.puedeRegistrarse(jugador));
		System.out.println(autentificacionService.puedeRegistrarse(new Jugador("05123456C", new BigDecimal(300), "correo.prueba2@prueba.com", "jugadorPrueba", "+34666777890")));
    }

}
