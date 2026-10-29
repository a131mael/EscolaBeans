package org.escola.model;

import java.io.Serializable;

// DTO somativo pra aba "Resumo" do evento de arrecadacao -- nao e uma entidade JPA,
// so um agregado calculado em memoria por turma (ou pro evento inteiro).
public class EventoResumoTurma implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nomeTurma;
	private int totalParticipantes;
	private int confirmados;
	private int pagos;
	private double totalEsperado;
	private double totalArrecadado;

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public int getTotalParticipantes() {
		return totalParticipantes;
	}

	public void setTotalParticipantes(int totalParticipantes) {
		this.totalParticipantes = totalParticipantes;
	}

	public int getConfirmados() {
		return confirmados;
	}

	public void setConfirmados(int confirmados) {
		this.confirmados = confirmados;
	}

	public int getNaoConfirmados() {
		return totalParticipantes - confirmados;
	}

	public int getPagos() {
		return pagos;
	}

	public void setPagos(int pagos) {
		this.pagos = pagos;
	}

	public int getNaoPagos() {
		return totalParticipantes - pagos;
	}

	public double getTotalEsperado() {
		return totalEsperado;
	}

	public void setTotalEsperado(double totalEsperado) {
		this.totalEsperado = totalEsperado;
	}

	public double getTotalArrecadado() {
		return totalArrecadado;
	}

	public void setTotalArrecadado(double totalArrecadado) {
		this.totalArrecadado = totalArrecadado;
	}

	public double getPercentualPago() {
		if (totalEsperado == 0) {
			return 0;
		}
		return (totalArrecadado / totalEsperado) * 100;
	}

}
