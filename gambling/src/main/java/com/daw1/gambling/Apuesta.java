package com.daw1.gambling;

import java.math.BigDecimal;
import java.sql.Date;

public class Apuesta {

    private long idJugador;
    private long idSorteo;
    private Date fechaApuesta;
    private EstadoApuesta estado;
    private BigDecimal premio;
    private Resultado resultado;

    /**
     * Constructor de una apuesta ya creada
     * 
     * @param idJugador
     * @param idSorteo
     * @param fechaApuesta
     * @param estado
     * @param premio
     * @param apuesta
     */
	public Apuesta(long idJugador, long idSorteo, Date fechaApuesta, EstadoApuesta estado, BigDecimal premio, Resultado resultado) {
		super();
		this.idJugador = idJugador;
		this.idSorteo = idSorteo;
		this.fechaApuesta = fechaApuesta;
		this.estado = estado;
		this.premio = premio;
		this.resultado = resultado;
	}

	/**
	 * Constructor para una apuesta nueva
	 * 
	 * @param idJugador
	 * @param idSorteo
	 * @param fechaApuesta
	 * @param apuesta
	 */
	public Apuesta(long idJugador, long idSorteo, Date fechaApuesta, Resultado resultado) {
		super();
		this.idJugador = idJugador;
		this.idSorteo = idSorteo;
		this.fechaApuesta = fechaApuesta;
		this.estado = EstadoApuesta.PENDIENTE;
		this.premio = new BigDecimal(0);
		this.resultado = resultado;
	}

}
