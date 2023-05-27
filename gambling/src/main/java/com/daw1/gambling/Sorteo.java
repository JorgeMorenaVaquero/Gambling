package com.daw1.gambling;

import java.sql.Date;
import java.sql.Timestamp;

public abstract class Sorteo {

    protected long id;
    protected Date fechaApertura;
    protected Date fechaCierre;
    protected Timestamp fechaHora;
    protected TipoSorteo tipo;
    protected String resultado;
    

    /**
     * Constructor para un sorteo con resultado
     * 
     * @param id
     * @param fechaApertura
     * @param fechaCierre
     * @param fechaHora
     * @param resultado
     */
	public Sorteo(long id, Date fechaApertura, Date fechaCierre, Timestamp fechaHora, String resultado) {
		super();
		this.id = id;
		this.fechaApertura = fechaApertura;
		this.fechaCierre = fechaCierre;
		this.fechaHora = fechaHora;
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
	public Sorteo(long id, Date fechaApertura, Date fechaCierre, Timestamp fechaHora) {
		super();
		this.id = id;
		this.fechaApertura = fechaApertura;
		this.fechaCierre = fechaCierre;
		this.fechaHora = fechaHora;
	}
	
	/**
	 * Metodo abstracto para generar el resultado del sorteo
	 * 
	 * 
	 */
	public abstract void generarResultado();
}
