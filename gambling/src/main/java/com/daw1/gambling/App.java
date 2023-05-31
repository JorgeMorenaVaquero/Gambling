package com.daw1.gambling;

import java.math.BigDecimal;

public class App {
	
    public static void main(String[] args) throws Exception {
    	GamblingApp app = new GamblingApp();
    	
    	//app.iniciar();
    	
		ConexionBaseDeDatos.getConexion();
		
		
		JugadorController jugadorController = new JugadorController();
		
		//jugadorController.insertJugador(new Jugador("05123456A", new BigDecimal(300), "correo.pureba@pureba.com", "jugadorPrueba", "+34666777888"));
		
		
		ApuestaController apuestasController = new ApuestaController();
		
		for (Apuesta apuesta : apuestasController.seleccionarApuestasJugador(1)) {
			System.out.println(apuesta);
		}
    }

}
