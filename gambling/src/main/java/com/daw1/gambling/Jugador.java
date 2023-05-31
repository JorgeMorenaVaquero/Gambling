package com.daw1.gambling;

import java.math.BigDecimal;

public class Jugador {

    private long id;
    private String dni;
    private BigDecimal dinero;
    private String correoElectronico;
    private String contrasenna;
    private String telefono;

	public Jugador(long id, String dni, BigDecimal dinero, String correoElectronico, String contrasenna,
			String telefono) {
		super();
		this.id = id;
		this.dni = dni;
		this.dinero = dinero;
		this.correoElectronico = correoElectronico;
		this.contrasenna = contrasenna;
		this.telefono = telefono;
	}
	
	public Jugador(String dni, BigDecimal dinero, String correoElectronico, String contrasenna,
			String telefono) {
		super();
		this.dni = dni;
		this.dinero = dinero;
		this.correoElectronico = correoElectronico;
		this.contrasenna = contrasenna;
		this.telefono = telefono;
	}

	public long getId() {
		return id;
	}

	public String getDni() {
		return dni;
	}

	public BigDecimal getDinero() {
		return dinero;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public String getContrasenna() {
		return contrasenna;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	

}
