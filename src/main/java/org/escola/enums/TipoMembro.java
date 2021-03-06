	package org.escola.enums;

public enum TipoMembro {

	SECRETARIA("Secretaria"),
	
	PROFESSOR("Professor"),
	
	ADMIM("Administrador"),
	
	TESTER("Tester"),
	
	ALUNO("Aluno"),
	
	FINANCEIRO("Financeiro"),
	
	COMUM("Comum"),
	
	MESTRE("Mestre");
	
	private String tipo;
	
	TipoMembro(String tipo){
		this.tipo = tipo;
	}

	public String getName() {
		
		return tipo;
	}

}
