package com.daw1.gambling;

import java.sql.Date;
import java.sql.Timestamp;

public abstract class Sorteo {

    private long id;
    private Date fechaApertura;
    private Date fechaCierre;
    private Timestamp fechaHora;
    private TipoSorteo tipo;
    private String resultado;
    

    /**
     * Constructor para un sorteo con resultado
     * 
     * @param id
     * @param fechaApertura
     * @param fechaCierre
     * @param fechaHora
     * @param resultado
     */
	public Sorteo(long id, Date fechaApertura, Date fechaCierre, Timestamp fechaHora, TipoSorteo tipo, String resultado) {
		super();
		this.id = id;
		this.fechaApertura = fechaApertura;
		this.fechaCierre = fechaCierre;
		this.fechaHora = fechaHora;
		this.tipo = tipo;
		this.resultado = resultado;
	}
	
	/**
	 * Constructor para un sorteo sin resultado
	 * 
	 * @param id
	 * @param fechaApertura
	 * @param fechaCierre
	 * @param fechaHora
	 */
	public Sorteo(long id, Date fechaApertura, Date fechaCierre, Timestamp fechaHora, TipoSorteo tipo) {
		super();
		this.id = id;
		this.fechaApertura = fechaApertura;
		this.fechaCierre = fechaCierre;
		this.fechaHora = fechaHora;
		this.tipo = tipo;
	}
	
	/**
	 * Metodo abstracto para generar una apuesta
	 * 
	 * @return Apuesta
	 */
	public abstract Apuesta generarApuesta();
}
