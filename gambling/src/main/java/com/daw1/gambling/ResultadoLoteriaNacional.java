package com.daw1.gambling;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultadoLoteriaNacional extends Resultado {
	
	private int numero;
	private int euros;
	private int serie;
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
		return "ResultadoLoteriaNacional [numero=" + numero + ", euros=" + euros + ", serie=" + serie + ", fraccion="
				+ fraccion + "]";
	}

}
