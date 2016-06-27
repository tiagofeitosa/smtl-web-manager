package br.com.fotosensores.util;

public enum Constants {
	DEFAULT("default");
	
	private String value;
	
	private Constants(String value) {
		this.value = value;
	}

	public String getValor() {
		return value;
	}
	
}
