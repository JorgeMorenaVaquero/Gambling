package com.daw1.gambling.controller;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.daw1.gambling.ConexionBaseDeDatos;
import com.daw1.gambling.enums.TipoSorteo;
import com.daw1.gambling.resultado.Resultado;
import com.daw1.gambling.sorteo.Sorteo;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SorteoController {
	public List<Sorteo> getSorteos() throws IOException, SQLException, ClassNotFoundException, Exception {
		List<Sorteo> sorteos = new ArrayList<>();

		Connection connection = null;
		
		try {
			connection = ConexionBaseDeDatos.getConexion();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			throw e;
		}

		Statement statement = null;
		ResultSet result = null;

		try {
			statement = connection.createStatement();
			String sql = "SELECT id, fecha_apertura, fecha_cierre, fecha_hora, tipo, resultado FROM sorteo";
			result = statement.executeQuery(sql);

			while (result.next()) {
				long id = result.getLong("id");
				Date fechaApertura = result.getDate("fecha_apertura");
				Date fechaCierre = result.getDate("fecha_cierre");
				Timestamp fechaHora = result.getTimestamp("fecha_hora");
				TipoSorteo tipo = TipoSorteo.valueOf(result.getString("tipo"));
				String resultadoJson = result.getString("resultado");
				Resultado resultado = null;
				if (resultadoJson != null) {
					resultado = (Resultado) new ObjectMapper().readValue(resultadoJson, tipo.getClaseResultado());
				} 

				Constructor<?> constructor = tipo.getClaseSorteo().getConstructor(long.class, Date.class, Date.class, Timestamp.class, tipo.getClaseResultado());
				Sorteo sorteo = (Sorteo) constructor.newInstance(id, fechaApertura, fechaCierre, fechaHora, resultado);
				
				sorteos.add(sorteo);
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
		
		return sorteos;
	}

	public void insertSorteo(Sorteo sorteo) throws IOException, SQLException, ClassNotFoundException {
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
			String sql = "INSERT INTO sorteo(fechaApertura, fechaCierre, fechaHora, tipo, resultado) VALUES (?,?,?,?,?)";
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setDate(1, sorteo.getFechaApertura());
			statement.setDate(2, sorteo.getFechaCierre());
			statement.setTimestamp(3, sorteo.getFechaHora());
			statement.setString(4, sorteo.getTipo().getValue());
			statement.setString(5, new ObjectMapper().writeValueAsString(sorteo.getResultado()));

			if (statement.executeUpdate() > 0) {
				generatedKeys = statement.getGeneratedKeys();

				if (generatedKeys.next()) {
					sorteo.setId(generatedKeys.getLong(1));
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
}
