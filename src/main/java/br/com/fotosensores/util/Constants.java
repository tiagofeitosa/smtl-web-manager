package br.com.fotosensores.util;

public enum Constants {
	DEFAULT("default"), ALL("all");
	
	private String value;
	
	private Constants(String value) {
		this.value = value;
	}

	public String getValor() {
		return value;
	}
	
}
