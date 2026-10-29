package org.escola.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@Entity
@XmlRootElement
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class EventoArrecadacao implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Size(min = 1, max = 250)
	private String nome;

	@Column
	private int anoLetivo;

	// true = vale pra todas as turmas (uma aba por turma); false = turma unica (ver campo turma)
	@Column
	private boolean todasTurmas;

	@ManyToOne
	private Turma turma;

	@Column
	private boolean parcelado;

	@Column
	private boolean porQuantidade;

	@Column
	private boolean temConfirmacao;

	@Column
	private double valorUnitario;

	@Column
	private String chavePix;

	@Column
	private String nomeRecebedor;

	@Column
	private String cidadeRecebedor;

	@Column
	private boolean ativo = true;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnoLetivo() {
		return anoLetivo;
	}

	public void setAnoLetivo(int anoLetivo) {
		this.anoLetivo = anoLetivo;
	}

	public boolean isTodasTurmas() {
		return todasTurmas;
	}

	public void setTodasTurmas(boolean todasTurmas) {
		this.todasTurmas = todasTurmas;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public boolean isParcelado() {
		return parcelado;
	}

	public void setParcelado(boolean parcelado) {
		this.parcelado = parcelado;
	}

	public boolean isPorQuantidade() {
		return porQuantidade;
	}

	public void setPorQuantidade(boolean porQuantidade) {
		this.porQuantidade = porQuantidade;
	}

	public boolean isTemConfirmacao() {
		return temConfirmacao;
	}

	public void setTemConfirmacao(boolean temConfirmacao) {
		this.temConfirmacao = temConfirmacao;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getChavePix() {
		return chavePix;
	}

	public void setChavePix(String chavePix) {
		this.chavePix = chavePix;
	}

	public String getNomeRecebedor() {
		return nomeRecebedor;
	}

	public void setNomeRecebedor(String nomeRecebedor) {
		this.nomeRecebedor = nomeRecebedor;
	}

	public String getCidadeRecebedor() {
		return cidadeRecebedor;
	}

	public void setCidadeRecebedor(String cidadeRecebedor) {
		this.cidadeRecebedor = cidadeRecebedor;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
