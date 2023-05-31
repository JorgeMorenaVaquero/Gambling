package com.daw1.gambling;

import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
	
    public static void main(String[] args) throws Exception {
    	GamblingApp app = new GamblingApp();
    	
    	//app.iniciar();
    	
		ConexionBaseDeDatos.getConexion();
		
		
		JugadorController jugadorController = new JugadorController();
		
		//jugadorController.insertJugador(new Jugador("05123456A", new BigDecimal(300), "correo.pureba@pureba.com", "jugadorPrueba", "+34666777888"));
		
		
		ApuestaController apuestasController = new ApuestaController();
		
		/*
		for (Apuesta apuesta : apuestasController.seleccionarApuestasJugador(1)) {
			System.out.println(apuesta);
		}
		*/
		
		
		SorteoController sorteoController = new SorteoController();
		
		for (Sorteo sorteo : sorteoController.getSorteos()) {
			System.out.println(sorteo);
		}

    }

}
