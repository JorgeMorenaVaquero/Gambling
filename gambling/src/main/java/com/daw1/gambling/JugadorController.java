package com.daw1.gambling;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JugadorController {

	public Jugador getJugador(String correoElectronico, String contrasenna)
			throws IOException, SQLException, ClassNotFoundException {
		Connection conn = ConexionBaseDeDatos.getConexion();

		String sql = "SELECT id, dni, dinero, correo_electronico, contrasenna, telefono FROM jugador WHERE correo_electronico = ? AND contrasenna = ? LIMIT 1";
		Jugador jugador = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {

			statement = conn.prepareStatement(sql);
			statement.setString(1, correoElectronico);
			statement.setString(2, contrasenna);

			result = statement.executeQuery();

			while (result.next()) {
				long id = result.getLong("id");
				String dni = result.getString("dni");
				BigDecimal dinero = result.getBigDecimal("dinero");
				String correoElectronicoRecuperado = result.getString("correo_electronico");
				String contrasennaRecuperada = result.getString("contrasenna");
				String telefono = result.getString("telefono");

				jugador = new Jugador(id, dni, dinero, correoElectronicoRecuperado, contrasennaRecuperada, telefono);
			}

			return jugador;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (result == null || result.isClosed()) {
				result.close();
			}
			if (statement == null || statement.isClosed()) {
				statement.close();
			}
		}
	}

	public void insertJugador(Jugador jugador) throws IOException, SQLException, ClassNotFoundException {

		Connection conn = ConexionBaseDeDatos.getConexion();
		PreparedStatement statement = null;
		ResultSet generatedKeys = null;

		try {

			String sql = "INSERT INTO jugador(dni, dinero, correo_electronico, contrasenna, telefono) VALUES (?,?,?,?,?)";

			statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, jugador.getDni());
			statement.setBigDecimal(2, jugador.getDinero());
			statement.setString(3, jugador.getCorreoElectronico());
			statement.setString(4, jugador.getContrasenna());
			statement.setString(5, jugador.getTelefono());

			if (statement.executeUpdate() > 0) {
				generatedKeys = statement.getGeneratedKeys();

				if (generatedKeys.next()) {
					jugador.setId(generatedKeys.getLong(1));
				}
			}

			conn.commit();

		} catch (SQLException e) {
			conn.rollback();

			e.printStackTrace();
			throw e;
		} finally {
			if (generatedKeys == null || generatedKeys.isClosed()) {
				generatedKeys.close();
			}
			if (statement == null || statement.isClosed()) {
				statement.close();
			}
		}
	}
}
