package com.daw1.gambling.enums;

import com.daw1.gambling.resultado.ResultadoEuromillones;
import com.daw1.gambling.resultado.ResultadoGordo;
import com.daw1.gambling.resultado.ResultadoLoteriaNacional;
import com.daw1.gambling.resultado.ResultadoPrimitiva;
import com.daw1.gambling.resultado.ResultadoQuiniela;
import com.daw1.gambling.sorteo.SorteoEuromillones;
import com.daw1.gambling.sorteo.SorteoGordo;
import com.daw1.gambling.sorteo.SorteoLoteriaNacional;
import com.daw1.gambling.sorteo.SorteoPrimitiva;
import com.daw1.gambling.sorteo.SorteoQuiniela;

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
