package com.daw1.gambling;

public enum TipoSorteo {
	LOTERIA_NACIONAL("LOTERIA_NACIONAL", ResultadoLoteriaNacional.class, SorteoLoteriaNacional.class),
	QUINIELA("QUINIELA", ResultadoQuiniela.class, SorteoQuiniela.class),
	EUROMILLONES("EUROMILLONES", ResultadoEuromillones.class, SorteoEuromillones.class),
	PRIMITIVA("PRIMITIVA", ResultadoPrimitiva.class, SorteoPrimitiva.class),
	GORDO("GORDO", ResultadoGordo.class, SorteoGordo.class);
	
	private String value;
	private Class<?> claseResultado;
	private Class<?> claseSorteo;

	private TipoSorteo(String value, Class<?> claseResultado, Class<?> claseSorteo) {
		this.value = value;
		this.claseResultado = claseResultado;
		this.claseSorteo = claseSorteo;
	}

	public String getValue() {
		return value;
	}

	public Class<?> getClaseResultado() {
		return claseResultado;
	}

	public Class<?> getClaseSorteo() {
		return claseSorteo;
	}

}
