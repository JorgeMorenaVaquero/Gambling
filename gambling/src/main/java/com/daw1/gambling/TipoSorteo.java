package com.daw1.gambling;

public enum TipoSorteo {
	LOTERIA_NACIONAL("LOTERIA_NACIONAL", ResultadoLoteriaNacional.class),
	QUINIELA("QUINIELA", ResultadoQuiniela.class),
	EUROMILLONES("EUROMILLONES", ResultadoEuromillones.class),
	PRIMITIVA("PRIMITIVA", ResultadoPrimitiva.class),
	GORDO("GORDO", ResultadoGordo.class);
	
	private String value;
	private Class<?> clase;

	private TipoSorteo(String value, Class<?> clase) {
		this.value = value;
		this.clase = clase;
	}

	public String getValue() {
		return value;
	}

	public Class<?> getClase() {
		return clase;
	}

}
