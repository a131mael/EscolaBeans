package org.escola.enums;

public enum TipoBoleto {

	MENSALIDADE("Mensalidade"),
	
	ACORDO_DIVIDA("Acordo divida"),
	
	APOSTILA("Apostila"),
	
	CANTINA("Cantina"),
	
	PASSEIO("Passeio"),
	
	OUTRO("Outro");
	
	private String tipo;
	
	TipoBoleto(String tipo){
		this.tipo = tipo;
	}

	public String getName() {
		return tipo;
	}

}
