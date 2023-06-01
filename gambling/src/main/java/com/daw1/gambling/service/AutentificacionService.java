package com.daw1.gambling.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.daw1.gambling.ConexionBaseDeDatos;
import com.daw1.gambling.Jugador;
import com.google.common.hash.Hashing;

public class AutentificacionService {

	public long introducirLogin(String correo, String contrasenna) throws ClassNotFoundException, SQLException, IOException {
		long jugadorId = 0;

		final String contrasennaHash = Hashing.sha256().hashString(contrasenna, StandardCharsets.UTF_8).toString();
	
		Connection connection = null;
	
		try {
			connection = ConexionBaseDeDatos.getConexion();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			throw e;
		}

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String sql = "SELECT id FROM jugador WHERE correo_electronico = ? AND contrasenna = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, correo);
			statement.setString(2, contrasennaHash);

			result = statement.executeQuery();

			if (result.next()) {
				jugadorId = result.getLong("id");
			}
		} catch(SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (result == null || !result.isClosed()) {
				result.close();
			}
			if (statement == null || !statement.isClosed()) {
				statement.close();
			}
		}

		return jugadorId;
	}

	public boolean puedeRegistrarse(Jugador jugador) throws ClassNotFoundException, SQLException, IOException {
		boolean puedeRegistrarse = false;

		Connection connection = null;

		try {
			connection = ConexionBaseDeDatos.getConexion();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			throw e;
		}

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String sql = "SELECT COUNT(*) > 0 AS encontrados FROM jugador WHERE dni = ? OR correo_electronico = ? OR telefono = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, jugador.getDni());
			statement.setString(2, jugador.getCorreoElectronico());
			statement.setString(3, jugador.getTelefono());

			result = statement.executeQuery();

			if (result.next() && !result.getBoolean("encontrados")) {
				puedeRegistrarse = true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (result == null || !result.isClosed()) {
				result.close();
			}
			if (statement == null || !statement.isClosed()) {
				statement.close();
			}
		}

		return puedeRegistrarse;
	}

}
