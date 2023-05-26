package com.daw1.gambling;

import java.math.BigDecimal;
import java.sql.Date;

public class Apuesta {

    private long idJugador;
    private long idSorteo;
    private Date fechaApuesta;
    private EstadoApuesta estado;
    private BigDecimal premio;
    private String apuesta;

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
	public Apuesta(long idJugador, long idSorteo, Date fechaApuesta, EstadoApuesta estado, BigDecimal premio, String apuesta) {
		super();
		this.idJugador = idJugador;
		this.idSorteo = idSorteo;
		this.fechaApuesta = fechaApuesta;
		this.estado = estado;
		this.premio = premio;
		this.apuesta = apuesta;
	}

	/**
	 * Constructor para una apuesta nueva
	 * 
	 * @param idJugador
	 * @param idSorteo
	 * @param fechaApuesta
	 * @param apuesta
	 */
	public Apuesta(long idJugador, long idSorteo, Date fechaApuesta, String apuesta) {
		super();
		this.idJugador = idJugador;
		this.idSorteo = idSorteo;
		this.fechaApuesta = fechaApuesta;
		this.estado = EstadoApuesta.PENDIENTE;
		this.premio = new BigDecimal(0);
		this.apuesta = apuesta;
	}

}
