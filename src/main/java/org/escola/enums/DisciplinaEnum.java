package org.escola.enums;

public enum DisciplinaEnum {

	PORTUGUES("Português"),
	
	MATEMATICA("Matemática"),
	
	HISTORIA("História"),
	
	INGLES("Inglês"),
	
	EDUCACAO_FISICA("Educação Física"),
	
	GEOGRAFIA("Geografia"),
	
	CIENCIAS("Ciências"),
	
	FORMACAO_CRISTA("Formação cristã"),
	
	ARTES("Artes"),
	
	ESPANHOL("Filosofia"),
	
	CULINARIA("Culinária"),
	
	LIVRO_EXPERIENCIAS("Livro de Experiência"),
	
	BRINCADEIRAS_E_ARTE("Brincadeiras das Artes"),//12
	
	LETRAR("Letrar"),//13
	
	NUMERAR("Numerar"),//14
	
	INVESTIGAR("Investigar"),//15
	
	DESENHAR("Desenhar"), //16
	
	HISTORIA_EM_CENA("História em cena"); //17
	
	
	
	
	private String name;
	
	DisciplinaEnum(String name){
		this.name = name;
		
	}

	public String getName() {
		return name;
	}

}
