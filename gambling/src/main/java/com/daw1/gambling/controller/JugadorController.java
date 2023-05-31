package com.daw1.gambling.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.daw1.gambling.ConexionBaseDeDatos;
import com.daw1.gambling.Jugador;

public class JugadorController {

	public Jugador getJugador(String correoElectronico, String contrasenna)
			throws IOException, SQLException, ClassNotFoundException {
		Connection connection = null;

		try {
			connection = ConexionBaseDeDatos.getConexion();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			throw e;
		}

		Jugador jugador = null;

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String sql = "SELECT id, dni, dinero, correo_electronico, contrasenna, telefono FROM jugador WHERE correo_electronico = ? AND contrasenna = ? LIMIT 1";
			statement = connection.prepareStatement(sql);
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
		} catch (SQLException e) {
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

		return jugador;
	}

	public void insertJugador(Jugador jugador) throws IOException, SQLException, ClassNotFoundException {
		Connection connection = null;

		try {
			connection = ConexionBaseDeDatos.getConexion();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			throw e;
		}

		PreparedStatement statement = null;
		ResultSet generatedKeys = null;

		try {
			String sql = "INSERT INTO jugador(dni, dinero, correo_electronico, contrasenna, telefono) VALUES (?,?,?,?,?)";
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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

			connection.commit();
		} catch (SQLException e) {
			connection.rollback();

			e.printStackTrace();
			throw e;
		} finally {
			if (generatedKeys == null || !generatedKeys.isClosed()) {
				generatedKeys.close();
			}
			if (statement == null || !statement.isClosed()) {
				statement.close();
			}
		}
	}

	public void retirarSaldo(Jugador jugador, BigDecimal saldo) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = null;
		
		try {
			connection = ConexionBaseDeDatos.getConexion();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			throw e;
		}

		PreparedStatement statement = null;
		
		try {
			String sql = "UPDATE jugador SET saldo=? WHERE id=?";
			statement = connection.prepareStatement(sql);
			
			statement.setBigDecimal(1, jugador.getDinero().subtract(saldo));
			statement.setLong(2, jugador.getId());
			
			statement.executeUpdate();

			connection.commit();
		} catch (SQLException e) {
			connection.rollback();

			e.printStackTrace();
			throw e;
		} finally {
			if (statement == null || !statement.isClosed()) {
				statement.close();
			}
		}
	}
}
