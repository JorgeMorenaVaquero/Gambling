package com.daw1.gambling;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ApuestaController {
	
	public List<Apuesta> seleccionarApuestasJugador(long idJugador) throws SQLException, ClassNotFoundException, IOException {
		List<Apuesta> apuestas = new ArrayList<>();

		Connection connection = ConexionBaseDeDatos.getConexion();

		PreparedStatement sentencia = null;
		ResultSet resultado = null;

		try {
			String sql = "SELECT a.id_sorteo, a.fecha_apuesta, a.estado, a.premio, a.apuesta, s.tipo FROM apuesta a INNER JOIN sorteo s ON (a.id_sorteo = s.id) WHERE id_jugador = ?";
			sentencia = connection.prepareStatement(sql);
			sentencia.setLong(1, idJugador);

			resultado = sentencia.executeQuery();
		    
			while (resultado.next()) {
				long idSorteo = resultado.getLong("id_sorteo");
				Date fechaApuesta = resultado.getDate("fecha_apuesta");
				EstadoApuesta estado = EstadoApuesta.valueOf(resultado.getString("estado"));
				BigDecimal premio = resultado.getBigDecimal("apuesta");
				TipoSorteo tipo = TipoSorteo.valueOf(resultado.getString("tipo"));

				Apuesta apuesta = new Apuesta(idJugador, idSorteo, fechaApuesta, estado, premio, (Resultado) new ObjectMapper().readValue(resultado.getString("resultado"), tipo.getClase()));

				apuestas.add(apuesta);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (resultado == null || resultado.isClosed()) {
				resultado.close();
			}
			if (sentencia == null || sentencia.isClosed()) {
				sentencia.close();
			}
		}
		
		return apuestas;
	}

}
