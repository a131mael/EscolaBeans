package org.escola.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@Entity
@XmlRootElement
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class EventoParticipante implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@ManyToOne
	private EventoArrecadacao evento;

	@NotNull
	@ManyToOne
	private Aluno aluno;

	@Column
	private Boolean confirmado;

	// so relevante quando evento.porQuantidade == true
	@Column
	private Integer quantidadeConfirmada;

	@Column
	private int numeroParcelas = 1;

	@OneToMany(mappedBy = "participante", cascade = javax.persistence.CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EventoParcela> parcelas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EventoArrecadacao getEvento() {
		return evento;
	}

	public void setEvento(EventoArrecadacao evento) {
		this.evento = evento;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Boolean getConfirmado() {
		return confirmado;
	}

	public void setConfirmado(Boolean confirmado) {
		this.confirmado = confirmado;
	}

	public Integer getQuantidadeConfirmada() {
		return quantidadeConfirmada;
	}

	public void setQuantidadeConfirmada(Integer quantidadeConfirmada) {
		this.quantidadeConfirmada = quantidadeConfirmada;
	}

	public int getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(int numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}

	public List<EventoParcela> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<EventoParcela> parcelas) {
		this.parcelas = parcelas;
	}

}
