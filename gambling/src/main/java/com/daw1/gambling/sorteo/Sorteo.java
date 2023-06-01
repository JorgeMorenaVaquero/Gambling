package com.daw1.gambling.sorteo;

import java.sql.Date;
import java.sql.Timestamp;

import com.daw1.gambling.Apuesta;
import com.daw1.gambling.enums.TipoSorteo;
import com.daw1.gambling.resultado.Resultado;

public abstract class Sorteo {

	protected long id;
	protected Date fechaApertura;
	protected Date fechaCierre;
	protected Timestamp fechaHora;
	protected TipoSorteo tipo;
	protected Resultado resultado;

	/**
	 * Constructor para un sorteo con resultado
	 * 
	 * @param id
	 * @param fechaApertura
	 * @param fechaCierre
	 * @param fechaHora
	 * @param resultado
	 */
	public Sorteo(long id, Date fechaApertura, Date fechaCierre, Timestamp fechaHora, Resultado resultado) {
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

	public long getId() {
		return id;
	}

	public Date getFechaApertura() {
		return fechaApertura;
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public Timestamp getFechaHora() {
		return fechaHora;
	}

	public TipoSorteo getTipo() {
		return tipo;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Metodo para generar el resultado del sorteo
	 */
	public abstract void generarResultado();

	/**
	 * Método para generar una apuesta
	 * 
	 * @return Apuesta generada
	 */
	public abstract Apuesta generarApuesta();

	@Override
	public String toString() {
		return "id=" + id + ", fechaApertura=" + fechaApertura + ", fechaCierre=" + fechaCierre + ", fechaHora="
				+ fechaHora + ", tipo=" + tipo + ", resultado=" + resultado;
	}

}
