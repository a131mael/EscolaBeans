package org.escola.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.aaf.dto.MemberDTO;
import org.escola.enums.TipoMembro;


@Entity
public class Member implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7405946341521019514L;

	@Id
	@GeneratedValue(generator = "GENERATE_member", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "GENERATE_member", sequenceName = "Member_pk_seq", allocationSize = 1)
	private Long id;

	@NotNull
	@Size(min = 1, max = 25)
	@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String name;

	@Column
	private String email;

	@Column
	private TipoMembro tipoMembro;

	@Column
	private String login;

	@Column
	private String senha;

	@OneToOne(mappedBy = "member")
	private Professor professor;
	
	@OneToOne(mappedBy = "member")
	private Aluno aluno;

	@Column(name = "phone_number")
	private String phoneNumber;

    @Column(columnDefinition = "TEXT")
    private String tokenFCM;

    @Column
    private Boolean desabilitado;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public TipoMembro getTipoMembro() {
		return tipoMembro;
	}

	public void setTipoMembro(TipoMembro tipoMembro) {
		this.tipoMembro = tipoMembro;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public MemberDTO getDTO(){
		MemberDTO dto = new MemberDTO();
		dto.setTipoMembro(tipoMembro.ordinal());
		dto.setEmail(email);
		dto.setId(id);
		dto.setLogin(login);
		dto.setName(name);
		dto.setSenha(senha);
		dto.setTokenFCM(tokenFCM);
		
		return dto;
	}

	public String getTokenFCM() {
		return tokenFCM;
	}

	public void setTokenFCM(String tokenFCM) {
		this.tokenFCM = tokenFCM;
	}

	public Boolean getDesabilitado() {
		return desabilitado;
	}

	public void setDesabilitado(Boolean desabilitado) {
		this.desabilitado = desabilitado;
	}
}
