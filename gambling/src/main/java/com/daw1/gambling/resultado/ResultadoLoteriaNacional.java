package com.daw1.gambling.resultado;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultadoLoteriaNacional extends Resultado {
	
	public static final int MAXIMO_NUMERO = 99999;
	public static final int MAXIMO_EUROS = 999999;
	public static final int MAXIMO_SERIE = 999;
	public static final int MAXIMO_FRACCION = 99;

	@JsonProperty("numero")
	private int numero;
	@JsonProperty("euros")
	private int euros;
	@JsonProperty("serie")
	private int serie;
	@JsonProperty("fraccion")
	private int fraccion;

	public ResultadoLoteriaNacional(
		@JsonProperty("numero")
		int numero,
		@JsonProperty("euros")
		int euros,
		@JsonProperty("serie")
		int serie,
		@JsonProperty("fraccion")
		int fraccion
	) {
		super();
		this.numero = numero;
		this.euros = euros;
		this.serie = serie;
		this.fraccion = fraccion;
	}

	@Override
	public String toString() {
		return "Resultado Loteria Nacional:\n"
				+ "numero {" + numero + "}, euros {" + euros + "}, serie {" + serie + "}, fraccion {"
				+ fraccion + "}";
	}

}
