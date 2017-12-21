package br.com.uol.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Heroe {
	@JsonProperty(value = "codinome")
	private String codeName;

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
}
