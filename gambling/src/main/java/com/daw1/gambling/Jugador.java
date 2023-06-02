package com.daw1.gambling;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;

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
		this.contrasenna = Hashing.sha256().hashString(contrasenna, StandardCharsets.UTF_8).toString();
		this.telefono = telefono;
	}
	
	public Jugador(String dni, BigDecimal dinero, String correoElectronico, String contrasenna,
			String telefono) {
		super();
		this.dni = dni;
		this.dinero = dinero;
		this.correoElectronico = correoElectronico;
		this.contrasenna = Hashing.sha256().hashString(contrasenna, StandardCharsets.UTF_8).toString();
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
	
	public void setDinero(BigDecimal dinero) {
		this.dinero = dinero;
	}

	@Override
	public String toString() {
		return "Jugador {id: " + id + ", DNI: " + dni + ", Saldo en cuenta: " + dinero + ", Correo Electrónico: " + correoElectronico
				+ ", Contraseña: " + contrasenna + ", Teléfono: " + telefono + "}";
	}

}
