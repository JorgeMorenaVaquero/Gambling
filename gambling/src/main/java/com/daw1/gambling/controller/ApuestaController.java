package com.daw1.gambling.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.daw1.gambling.Apuesta;
import com.daw1.gambling.ConexionBaseDeDatos;
import com.daw1.gambling.enums.EstadoApuesta;
import com.daw1.gambling.enums.TipoSorteo;
import com.daw1.gambling.resultado.Resultado;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ApuestaController {
	
	public List<Apuesta> getApuestasJugador(long idJugador) throws SQLException, ClassNotFoundException, IOException {
		List<Apuesta> apuestas = new ArrayList<>();

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
			String sql = "SELECT a.id_sorteo, a.fecha_apuesta, a.estado, a.premio, a.apuesta, s.tipo FROM apuesta a INNER JOIN sorteo s ON (a.id_sorteo = s.id) WHERE id_jugador = ?";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, idJugador);

			result = statement.executeQuery();
		    
			while (result.next()) {
				long idSorteo = result.getLong("id_sorteo");
				Date fechaApuesta = result.getDate("fecha_apuesta");
				EstadoApuesta estado = EstadoApuesta.valueOf(result.getString("estado"));
				BigDecimal premio = result.getBigDecimal("premio");
				TipoSorteo tipo = TipoSorteo.valueOf(result.getString("tipo"));
				String resultadoJson = result.getString("apuesta");
				Resultado resultado = (Resultado) new ObjectMapper().readValue(resultadoJson, tipo.getClaseResultado());

				Apuesta apuesta = new Apuesta(idJugador, idSorteo, fechaApuesta, estado, premio, resultado);

				apuestas.add(apuesta);
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
		
		return apuestas;
	}
	
	public void insertApuesta(Apuesta apuesta) throws SQLException, ClassNotFoundException, IOException {
		Connection connection = null;
		
		try {
			connection = ConexionBaseDeDatos.getConexion();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			throw e;
		}
		
		PreparedStatement statement = null;

		try {
			String sql = "INSERT INTO apuesta (id_jugador, id_sorteo, fecha_apuesta, estado, premio, apuesta) VALUES (?, ?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, apuesta.getIdJugador());
			statement.setLong(2, apuesta.getIdSorteo());
			statement.setDate(3, apuesta.getFechaApuesta());
			statement.setString(4, apuesta.getEstado().toString());
			statement.setBigDecimal(5, apuesta.getPremio());
			statement.setString(6, new ObjectMapper().writeValueAsString(apuesta.getResultado()));

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
