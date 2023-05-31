package com.daw1.gambling;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionBaseDeDatos {
	private static Connection conexion = null;
	
	private ConexionBaseDeDatos() {}

	private static void crearConexion() throws ClassNotFoundException, SQLException, IOException {
		Properties env = new Properties();

		try (
			FileReader fr = new FileReader("env/db.properties");
		) {
			env.load(fr);
			
			String driver = env.getProperty("driver");
			String url = env.getProperty("url");
			String usuario = env.getProperty("user");
			String contrasenna = env.getProperty("password");

			Class.forName(driver);
			conexion = DriverManager.getConnection(url, usuario, contrasenna);
			
			conexion.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			 System.out.println("Error. No se ha podido cargar el driver");
			 e.printStackTrace();
			 throw e;
		} catch (SQLException e) {
			 System.out.println("Error. Se ha producido algún error al establecer la conexión");
			 e.printStackTrace();
			 throw e;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static Connection getConexion() throws ClassNotFoundException, SQLException, IOException {
		try {
			if (conexion == null || conexion.isClosed()) {
				crearConexion();
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			throw e;
		}

		return conexion;
	}

}
