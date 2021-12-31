package org.escola.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "GENERATE_member", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "GENERATE_member", sequenceName = "Member_pk_seq", allocationSize = 1)
	private Long id;

	@NotNull
	@Size(min = 1, max = 60)
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

	@Column
	private Boolean infantil;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(columnDefinition = "TEXT")
	private String tokenFCM;

	@Column
	private String idCrianca1;

	@Column
	private String idCrianca2;
	@Column

	private String idCrianca3;
	@Column

	private String idCrianca4;

	@Column
	private String idCrianca5;

	@Column
	private Boolean desabilitado;

	@Column
	private String cpf;

	@Column
	private String rg;

	@Column
	private String cep;

	@Column
	private String endereco;

	@Column
	private String bairro;

	@Column
	private String cidade;

	private String contatoEmail1;

	private String contatoEmail2;

	private String contatoTelefone1;

	private String contatoTelefone2;

	private String contatoTelefone3;

	private String contatoTelefone4;

	private String contatoTelefone5;

	@Column
	private byte[] foto;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<RecadoCurtido> curtidas;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<RecadoCurtido> descurtidas;

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

	public MemberDTO getDTO() {
		MemberDTO dto = new MemberDTO();
		dto.setTipoMembro(tipoMembro.ordinal());
		dto.setEmail(email);
		dto.setId(id);
		dto.setLogin(login);
		dto.setName(name);
		dto.setSenha(senha);
		dto.setTokenFCM(tokenFCM);
		dto.setTelefone(phoneNumber);
		dto.setIdCrianca1(idCrianca1);
		dto.setIdCrianca2(idCrianca2);
		dto.setIdCrianca3(idCrianca3);
		dto.setIdCrianca4(idCrianca4);
		dto.setIdCrianca5(idCrianca5);
		/*
		 * if(idCrianca1 != null){ ContratoAluno contrato =
		 * aluno.getUltimoContrato(); if(contrato != null){
		 */
		dto.setBairro(getBairro());
		dto.setCep(getCep());
		dto.setCidade(getCidade());
		dto.setCpf(cpf);
		dto.setEndereco(getEndereco());
		dto.setRg(rg);
		dto.setContatoEmail1(contatoEmail1);
		dto.setContatoEmail2(contatoEmail2);
		dto.setContatoTelefone1(contatoTelefone1);
		dto.setContatoTelefone2(contatoTelefone2);
		dto.setContatoTelefone3(contatoTelefone3);
		dto.setContatoTelefone4(contatoTelefone4);
		dto.setContatoTelefone5(contatoTelefone5);

		dto.setFoto(foto);
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

	public String getIdCrianca1() {
		return idCrianca1;
	}

	public void setIdCrianca1(String idCrianca1) {
		this.idCrianca1 = idCrianca1;
	}

	public String getIdCrianca2() {
		return idCrianca2;
	}

	public void setIdCrianca2(String idCrianca2) {
		this.idCrianca2 = idCrianca2;
	}

	public String getIdCrianca3() {
		return idCrianca3;
	}

	public void setIdCrianca3(String idCrianca3) {
		this.idCrianca3 = idCrianca3;
	}

	public String getIdCrianca4() {
		return idCrianca4;
	}

	public void setIdCrianca4(String idCrianca4) {
		this.idCrianca4 = idCrianca4;
	}

	public String getIdCrianca5() {
		return idCrianca5;
	}

	public void setIdCrianca5(String idCrianca5) {
		this.idCrianca5 = idCrianca5;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getContatoEmail1() {
		return contatoEmail1;
	}

	public void setContatoEmail1(String contatoEmail1) {
		this.contatoEmail1 = contatoEmail1;
	}

	public String getContatoEmail2() {
		return contatoEmail2;
	}

	public void setContatoEmail2(String contatoEmail2) {
		this.contatoEmail2 = contatoEmail2;
	}

	public String getContatoTelefone1() {
		return contatoTelefone1;
	}

	public void setContatoTelefone1(String contatoTelefone1) {
		this.contatoTelefone1 = contatoTelefone1;
	}

	public String getContatoTelefone2() {
		return contatoTelefone2;
	}

	public void setContatoTelefone2(String contatoTelefone2) {
		this.contatoTelefone2 = contatoTelefone2;
	}

	public String getContatoTelefone3() {
		return contatoTelefone3;
	}

	public void setContatoTelefone3(String contatoTelefone3) {
		this.contatoTelefone3 = contatoTelefone3;
	}

	public String getContatoTelefone4() {
		return contatoTelefone4;
	}

	public void setContatoTelefone4(String contatoTelefone4) {
		this.contatoTelefone4 = contatoTelefone4;
	}

	public String getContatoTelefone5() {
		return contatoTelefone5;
	}

	public void setContatoTelefone5(String contatoTelefone5) {
		this.contatoTelefone5 = contatoTelefone5;
	}

	public List<RecadoCurtido> getCurtidas() {
		return curtidas;
	}

	public void setCurtidas(List<RecadoCurtido> curtidas) {
		this.curtidas = curtidas;
	}

	public List<RecadoCurtido> getDescurtidas() {
		return descurtidas;
	}

	public void setDescurtidas(List<RecadoCurtido> descurtidas) {
		this.descurtidas = descurtidas;
	}

	public Boolean getInfantil() {
		return infantil;
	}

	public void setInfantil(Boolean infantil) {
		this.infantil = infantil;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

}
