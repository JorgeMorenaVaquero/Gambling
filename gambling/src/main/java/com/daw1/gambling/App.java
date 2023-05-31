package com.daw1.gambling;

public class App {
	
    public static void main(String[] args) throws Exception {
    	GamblingApp app = new GamblingApp();
    	
    	//app.iniciar();
    	
		ConexionBaseDeDatos.getConexion();
    }

}
