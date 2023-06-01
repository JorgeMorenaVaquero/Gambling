package com.daw1.gambling.sorteo;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Scanner;

import com.daw1.gambling.Apuesta;
import com.daw1.gambling.Jugador;
import com.daw1.gambling.enums.TipoSorteo;
import com.daw1.gambling.resultado.Resultado;

public abstract class Sorteo {
	
	protected long id;
	protected Date fechaApertura;
	protected Date fechaCierre;
	protected Timestamp fechaHora;
	protected TipoSorteo tipo;
	protected Resultado resultado;
	protected double precio;

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
	
	public double getPrecio() {
		return precio;
	}

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Metodo para generar el resultado del sorteo
	 */
	public abstract void generarResultado();

	/**
	 * Generar resultado de la apuesta del jugador
	 * @param teclado
	 * @return
	 */
	protected abstract Resultado generarResultadoApuesta(Scanner teclado);

	/**
	 * Método para generar una apuesta
	 * 
	 * @return Apuesta generada
	 */
	public Apuesta generarApuesta(Scanner teclado, long idJugador) {
		Resultado resultadoApuesta = generarResultadoApuesta(teclado);
		return (new Apuesta(idJugador, id, new Date(System.currentTimeMillis()), resultadoApuesta));
	}

	public boolean tieneDineroSuficiente(Jugador jugador) {
		return (jugador.getDinero().compareTo(BigDecimal.valueOf(this.precio)) != -1);
	}
	
	@Override
	public String toString() {
		return "id=" + id + ", fechaApertura=" + fechaApertura + ", fechaCierre=" + fechaCierre + ", fechaHora="
				+ fechaHora + ", tipo=" + tipo + ", resultado=" + resultado;
	}
}
