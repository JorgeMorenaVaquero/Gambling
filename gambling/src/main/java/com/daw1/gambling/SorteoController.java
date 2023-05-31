package com.daw1.gambling;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SorteoController {
	public List<Sorteo> getSorteos() throws IOException, SQLException, ClassNotFoundException {
		Connection conn = ConexionBaseDeDatos.getConexion();

		String sql = "SELECT id, fechaApertura, fechaCierre, fechaHora, tipo, resultado FROM sorteo";
		List<Sorteo> sorteos = null;
		Statement statement = null;
		ResultSet result = null;

		try {

			statement = conn.createStatement();

			result = statement.executeQuery(sql);

			while (result.next()) {
				long id = result.getLong("id");
				Date fechaApertura = result.getDate("fechaApertura");
				Date fechaCierre = result.getDate("fechaCierre");
				Timestamp fechaHora = result.getTimestamp("fechaHora");
				TipoSorteo tipo = TipoSorteo.valueOf(result.getString("tipo"));
				String resultadoJson = result.getString("resultado");
				Resultado resultado = (Resultado) new ObjectMapper().readValue(resultadoJson, tipo.getClase());

				Constructor<?> constructor = tipo.getClase().getConstructor(id, fechaApertura, fechaCierre, fechaHora,
						tipo, resultado);

			}

			return sorteos;
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
	}

	public void insertSorteo(Sorteo sorteo) throws IOException, SQLException, ClassNotFoundException {

		Connection conn = ConexionBaseDeDatos.getConexion();
		PreparedStatement statement = null;
		ResultSet generatedKeys = null;

		try {

			String sql = "INSERT INTO sorteo(fechaApertura, fechaCierre, fechaHora, tipo, resultado) VALUES (?,?,?,?,?)";

			statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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

			conn.commit();

		} catch (SQLException e) {
			conn.rollback();

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
