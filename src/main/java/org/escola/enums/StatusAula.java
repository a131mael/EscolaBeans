package org.escola.enums;

public enum StatusAula {

	NAO_ASSISTIU("Masculino"),
	
	ASSISTIU("Feminino");
	
	
	
	private String tipo;
	
	StatusAula(String tipo){
		this.tipo = tipo;
	}

	public String getName() {
		return tipo;
	}

}
