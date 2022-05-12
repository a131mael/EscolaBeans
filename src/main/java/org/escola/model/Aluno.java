/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.escola.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.aaf.dto.AlunoDTO;
import org.escola.enums.BairroEnum;
import org.escola.enums.PerioddoEnum;
import org.escola.enums.Serie;
import org.escola.enums.Sexo;
import org.escola.enums.StatusBoletoEnum;
import org.escola.model.Boleto;
import org.escola.util.Verificador;

@SuppressWarnings("serial")
@Entity
@XmlRootElement
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Aluno implements Serializable, Comparable<Aluno> {

	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ContratoAluno> contratos;

	@Column
	private String cpf;

	@Column
	private String rg;

	@Column
	private String contatoEmail1;

	@Column
	private String contatoEmail2;

	@Column
	private String contatoTelefone1;

	@Column
	private String contatoNome1;

	@Column
	private String contatoTelefone2;

	@Column
	private String contatoNome2;

	@Column
	private String contatoTelefone3;

	@Column
	private String contatoNome3;

	@Column
	private String contatoTelefone4;

	@Column
	private String contatoNome4;

	@Column
	private String contatoTelefone5;

	@Column
	private String contatoNome5;

	@Column
	private String autorizadoASairCom1;

	@Column
	private String autorizadoASairCom2;

	@Column
	private String autorizadoASairCom3;

	@Column
	private String autorizadoASairCom4;

	@Column
	private String autorizadoASairCom5;

	@Column
	private String autorizadoASairCom6;

	@Column
	private String autorizadoASairCom7;

	@Column
	private BairroEnum bairroAluno;

	@Column
	private String enderecoAluno;

	@ManyToOne
	private Aluno irmao1;

	@ManyToOne
	private Aluno irmao2;

	@ManyToOne
	private Aluno irmao3;

	@ManyToOne
	private Aluno irmao4;

	@Column
	private Boolean verificadoOk;

	@Column
	private int anoLetivo;

	@Column
	private Boolean rematricular;
	
	@Column
	private Boolean gerarNFSe;

	@Column
	private Sexo sexo;

	@Column
	private Boolean removido;

	@Column
	private Boolean restaurada;

	@Column
	private Boolean alergico;

	@Column
	private Boolean doenca;

	@Column
	private String nomeAlergias;

	@Column
	private String nomeDoencas;

	@Column
	private Date dataPrometeuPagar;

	@Column
	private String observacaoAtrasado;

	@Column
	private Boolean contactado;

	@Column
	private Date dataContato;

	@Column
	private Integer quantidadeContatos = 0;

	/** DADOS DO ALUNO */
	@NotNull
	@Size(min = 1, max = 250)
	@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String nomeAluno;

	@OneToMany(fetch = FetchType.LAZY)
	private List<AlunoTurma> alunosTurmas;

	@OneToMany(fetch = FetchType.LAZY)
	private List<AlunoAvaliacao> avaliacoes;

	@Column
	private String login;

	@Column
	private String emergenciaLigarPara;

	@Column
	private String codigo;

	@OneToOne
	private Member member;

	@Column
	private String senha;

	@NotNull
	private Serie serie;

	@NotNull
	private PerioddoEnum periodo;

	private PerioddoEnum periodoProximoAno;

	@Column
	private String telefone;

	@Column
	private Date dataMatricula;

	@Column
	@Deprecated
	private Date dataCancelamento;

	@Column
	private Date dataNascimento;

	@Column
	private String nacionalidade;

	@Column
	private boolean administrarParacetamol;
	@Column
	private Integer faltas1Bimestre;
	@Column
	private Integer faltas2Bimestre;
	@Column
	private Integer faltas3Bimestre;
	@Column
	private Integer faltas4Bimestre;

	/** DADOS DO PAI */
	@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String nomePaiAluno;

	@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String nomeAvoPaternoPai;

	@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String nomeAvoHPaternoPai;

	@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String naturalidadePai;

	@Column
	private String cpfPai;

	@Column
	private String rgPai;

	@Column
	private String telefoneCelularPai;

	@Column
	private String telefoneResidencialPai;

	@Column
	private String emailPai;

	@Column
	private String empresaTrabalhaPai;

	@Column
	private String telefoneEmpresaTrabalhaPai;

	/** DADOS DA MAE */
	@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String nomeMaeAluno;

	@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String nomeAvoPaternoMae;

	@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String nomeAvoHPaternoMae;

	@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String naturalidadeMae;

	@Column
	private String cpfMae;

	@Column
	private String rgMae;

	@Column
	private String telefoneCelularMae;

	@Column
	private String telefoneResidencialMae;

	@Column
	private String emailMae;

	@Column
	private String empresaTrabalhaMae;

	@Column
	private String telefoneEmpresaTrabalhaMae;

	/* DADOS DE CONTATOS PARA SAIDAS */

	@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String nomecontatoSaidaEstabelecimento1;
	@Column
	private String telefonecontatoSaidaEstabelecimento1;
	@Column
	private String telefone2contatoSaidaEstabelecimento1;

	@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String nomecontatoSaidaEstabelecimento2;
	@Column
	private String telefonecontatoSaidaEstabelecimento2;
	@Column
	private String telefone2contatoSaidaEstabelecimento2;

	@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String nomecontatoSaidaEstabelecimento3;
	@Column
	private String telefonecontatoSaidaEstabelecimento3;
	@Column
	private String telefone2contatoSaidaEstabelecimento3;

	@Column
	private boolean ativo;

	@Column
	private String observacaoSecretaria;

	@Column
	private String observacaoProfessores;

	private byte[] foto;

	// DADOS PARA O FINANCEIRO

	@Column
	@Deprecated
	private Boolean enviadoParaCobrancaCDL;

	@Column
	@Deprecated
	private Boolean enviadoSPC;

	@Column
	@Deprecated
	private Boolean contratoTerminado;

	@Transient
	private Double valorTotalDevido;

	@Transient
	private int quantidadeMesAtrasado;

	@Transient
	private String mesesAtrasados;

	@Transient
	private String contatos;

	// TODO remover os atributos daqui para baixo

	@Column
	@Deprecated
	private Boolean cnabEnviado;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Boleto> boletos;

	@Column
	@Deprecated
	private String endereco;

	@Column
	@Deprecated
	private String bairro;

	@Column
	@Deprecated
	private String cep;

	@Column
	@Deprecated
	private String cidade;

	@Column
	@Deprecated
	private Double anuidade;

	@Column
	@Deprecated
	private Integer numeroParcelas;

	@Column
	@Deprecated
	private String nomeResponsavel;

	@Column
	@Deprecated
	private String nomePaiResponsavel;

	@Column
	@Deprecated
	private String nomeMaeResponsavel;

	@Column
	@Deprecated
	private String cpfResponsavel;

	@Column
	private int diaVencimento = 10;

	@Column
	@Deprecated
	private boolean vencimentoUltimoDia;

	@Column
	@Deprecated
	private String rgResponsavel;

	@Column
	@Deprecated
	private double valorMensal;

	@Transient
	private long percentualAulasAssistidas;

	@Transient
	private Date dataUltimaAulaAssistida;

	// TODO remover atributos ATEH aqui

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getTelefone2contatoSaidaEstabelecimento3() {
		return telefone2contatoSaidaEstabelecimento3;
	}

	public void setTelefone2contatoSaidaEstabelecimento3(String telefone2contatoSaidaEstabelecimento3) {
		this.telefone2contatoSaidaEstabelecimento3 = telefone2contatoSaidaEstabelecimento3;
	}

	public String getTelefonecontatoSaidaEstabelecimento3() {
		return telefonecontatoSaidaEstabelecimento3;
	}

	public void setTelefonecontatoSaidaEstabelecimento3(String telefonecontatoSaidaEstabelecimento3) {
		this.telefonecontatoSaidaEstabelecimento3 = telefonecontatoSaidaEstabelecimento3;
	}

	public String getNomecontatoSaidaEstabelecimento3() {
		return nomecontatoSaidaEstabelecimento3;
	}

	public void setNomecontatoSaidaEstabelecimento3(String nomecontatoSaidaEstabelecimento3) {
		this.nomecontatoSaidaEstabelecimento3 = nomecontatoSaidaEstabelecimento3;
	}

	public String getTelefone2contatoSaidaEstabelecimento2() {
		return telefone2contatoSaidaEstabelecimento2;
	}

	public void setTelefone2contatoSaidaEstabelecimento2(String telefone2contatoSaidaEstabelecimento2) {
		this.telefone2contatoSaidaEstabelecimento2 = telefone2contatoSaidaEstabelecimento2;
	}

	public String getTelefonecontatoSaidaEstabelecimento2() {
		return telefonecontatoSaidaEstabelecimento2;
	}

	public void setTelefonecontatoSaidaEstabelecimento2(String telefonecontatoSaidaEstabelecimento2) {
		this.telefonecontatoSaidaEstabelecimento2 = telefonecontatoSaidaEstabelecimento2;
	}

	public String getNomecontatoSaidaEstabelecimento2() {
		return nomecontatoSaidaEstabelecimento2;
	}

	public void setNomecontatoSaidaEstabelecimento2(String nomecontatoSaidaEstabelecimento2) {
		this.nomecontatoSaidaEstabelecimento2 = nomecontatoSaidaEstabelecimento2;
	}

	public String getTelefone2contatoSaidaEstabelecimento1() {
		return telefone2contatoSaidaEstabelecimento1;
	}

	public void setTelefone2contatoSaidaEstabelecimento1(String telefone2contatoSaidaEstabelecimento1) {
		this.telefone2contatoSaidaEstabelecimento1 = telefone2contatoSaidaEstabelecimento1;
	}

	public String getTelefonecontatoSaidaEstabelecimento1() {
		return telefonecontatoSaidaEstabelecimento1;
	}

	public void setTelefonecontatoSaidaEstabelecimento1(String telefonecontatoSaidaEstabelecimento1) {
		this.telefonecontatoSaidaEstabelecimento1 = telefonecontatoSaidaEstabelecimento1;
	}

	public String getNomecontatoSaidaEstabelecimento1() {
		return nomecontatoSaidaEstabelecimento1;
	}

	public void setNomecontatoSaidaEstabelecimento1(String nomecontatoSaidaEstabelecimento1) {
		this.nomecontatoSaidaEstabelecimento1 = nomecontatoSaidaEstabelecimento1;
	}

	public String getTelefoneEmpresaTrabalhaMae() {
		return telefoneEmpresaTrabalhaMae;
	}

	public void setTelefoneEmpresaTrabalhaMae(String telefoneEmpresaTrabalhaMae) {
		this.telefoneEmpresaTrabalhaMae = telefoneEmpresaTrabalhaMae;
	}

	public String getEmpresaTrabalhaMae() {
		return empresaTrabalhaMae;
	}

	public void setEmpresaTrabalhaMae(String empresaTrabalhaMae) {
		this.empresaTrabalhaMae = empresaTrabalhaMae;
	}

	public String getEmailMae() {
		return emailMae;
	}

	public void setEmailMae(String emailMae) {
		this.emailMae = emailMae;
	}

	public String getTelefoneResidencialMae() {
		return telefoneResidencialMae;
	}

	public void setTelefoneResidencialMae(String telefoneResidencialMae) {
		this.telefoneResidencialMae = telefoneResidencialMae;
	}

	public String getTelefoneCelularMae() {
		return telefoneCelularMae;
	}

	public void setTelefoneCelularMae(String telefoneCelularMae) {
		this.telefoneCelularMae = telefoneCelularMae;
	}

	public String getRgMae() {
		return rgMae;
	}

	public void setRgMae(String rgMae) {
		this.rgMae = rgMae;
	}

	public String getCpfMae() {
		return cpfMae;
	}

	public void setCpfMae(String cpfMae) {
		this.cpfMae = cpfMae;
	}

	public String getNaturalidadeMae() {
		return naturalidadeMae;
	}

	public void setNaturalidadeMae(String naturalidadeMae) {
		this.naturalidadeMae = naturalidadeMae;
	}

	public String getNomeAvoHPaternoMae() {
		return nomeAvoHPaternoMae;
	}

	public void setNomeAvoHPaternoMae(String nomeAvoHPaternoMae) {
		this.nomeAvoHPaternoMae = nomeAvoHPaternoMae;
	}

	public String getNomeAvoPaternoMae() {
		return nomeAvoPaternoMae;
	}

	public void setNomeAvoPaternoMae(String nomeAvoPaternoMae) {
		this.nomeAvoPaternoMae = nomeAvoPaternoMae;
	}

	public String getNomeMaeAluno() {
		return nomeMaeAluno;
	}

	public void setNomeMaeAluno(String nomeMaeAluno) {
		this.nomeMaeAluno = nomeMaeAluno;
	}

	public String getTelefoneEmpresaTrabalhaPai() {
		return telefoneEmpresaTrabalhaPai;
	}

	public void setTelefoneEmpresaTrabalhaPai(String telefoneEmpresaTrabalhaPai) {
		this.telefoneEmpresaTrabalhaPai = telefoneEmpresaTrabalhaPai;
	}

	public String getEmpresaTrabalhaPai() {
		return empresaTrabalhaPai;
	}

	public void setEmpresaTrabalhaPai(String empresaTrabalhaPai) {
		this.empresaTrabalhaPai = empresaTrabalhaPai;
	}

	public String getEmailPai() {
		return emailPai;
	}

	public void setEmailPai(String emailPai) {
		this.emailPai = emailPai;
	}

	public String getTelefoneResidencialPai() {
		return telefoneResidencialPai;
	}

	public void setTelefoneResidencialPai(String telefoneResidencialPai) {
		this.telefoneResidencialPai = telefoneResidencialPai;
	}

	public String getTelefoneCelularPai() {
		return telefoneCelularPai;
	}

	public void setTelefoneCelularPai(String telefoneCelularPai) {
		this.telefoneCelularPai = telefoneCelularPai;
	}

	public String getRgPai() {
		return rgPai;
	}

	public void setRgPai(String rgPai) {
		this.rgPai = rgPai;
	}

	public String getCpfPai() {
		return cpfPai;
	}

	public void setCpfPai(String cpfPai) {
		this.cpfPai = cpfPai;
	}

	public String getNaturalidadePai() {
		return naturalidadePai;
	}

	public void setNaturalidadePai(String naturalidadePai) {
		this.naturalidadePai = naturalidadePai;
	}

	public String getNomeAvoHPaternoPai() {
		return nomeAvoHPaternoPai;
	}

	public void setNomeAvoHPaternoPai(String nomeAvoHPaternoPai) {
		this.nomeAvoHPaternoPai = nomeAvoHPaternoPai;
	}

	public String getNomeAvoPaternoPai() {
		return nomeAvoPaternoPai;
	}

	public void setNomeAvoPaternoPai(String nomeAvoPaternoPai) {
		this.nomeAvoPaternoPai = nomeAvoPaternoPai;
	}

	public String getNomePaiAluno() {
		return nomePaiAluno;
	}

	public void setNomePaiAluno(String nomePaiAluno) {
		this.nomePaiAluno = nomePaiAluno;
	}

	public boolean isAdministrarParacetamol() {
		return administrarParacetamol;
	}

	public void setAdministrarParacetamol(boolean administrarParacetamol) {
		this.administrarParacetamol = administrarParacetamol;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public PerioddoEnum getPeriodo() {
		return periodo;
	}

	public void setPeriodo(PerioddoEnum periodo) {
		this.periodo = periodo;
	}

	public List<AlunoTurma> getAlunosTurmas() {
		return alunosTurmas;
	}

	public void setAlunosTurmas(List<AlunoTurma> alunosTurmas) {
		this.alunosTurmas = alunosTurmas;
	}

	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public List<AlunoAvaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<AlunoAvaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public AlunoDTO getDTO() {
		AlunoDTO alunoDTO = new AlunoDTO();
		alunoDTO.setCodigo(codigo);
		alunoDTO.setId(id);
		alunoDTO.setNomeAluno(nomeAluno);
		alunoDTO.setPeriodo(periodo.getName());
		alunoDTO.setSerie(serie.getName());
		alunoDTO.setAutorizadoASairCom1(autorizadoASairCom1);
		alunoDTO.setAutorizadoASairCom2(autorizadoASairCom2);
		alunoDTO.setAutorizadoASairCom3(autorizadoASairCom3);
		alunoDTO.setAutorizadoASairCom4(autorizadoASairCom4);
		alunoDTO.setAutorizadoASairCom5(autorizadoASairCom5);
		alunoDTO.setAutorizadoASairCom6(autorizadoASairCom6);
		alunoDTO.setAutorizadoASairCom7(autorizadoASairCom7);
		alunoDTO.setContatoEmail1(contatoEmail1);
		alunoDTO.setContatoEmail2(contatoEmail2);
		alunoDTO.setContatoNome1(contatoNome1);
		alunoDTO.setContatoNome2(contatoNome2);
		alunoDTO.setContatoNome3(contatoNome3);
		alunoDTO.setContatoNome4(contatoNome4);
		alunoDTO.setContatoNome5(contatoNome5);
		alunoDTO.setContatoTelefone1(contatoTelefone1);
		alunoDTO.setContatoTelefone2(contatoTelefone2);
		alunoDTO.setContatoTelefone3(contatoTelefone3);
		alunoDTO.setContatoTelefone4(contatoTelefone4);
		alunoDTO.setContatoTelefone5(contatoTelefone5);
		alunoDTO.setFoto(foto);

		return alunoDTO;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Aluno other = (Aluno) obj;
		if (nomeAluno == null) {
			if (other.nomeAluno != null)
				return false;
		}
		if (serie == null) {
			if (other.serie != null)
				return false;
		} else if (!periodo.equals(other.periodo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		return true;

	}

	@Deprecated
	public List<org.aaf.financeiro.model.Boleto> getBoletosFinanceiro() {
		List<org.aaf.financeiro.model.Boleto> boletosFinanceiro = new ArrayList<>();
		/*
		 * if(boletos!= null){ for(Boleto boleto : boletos){
		 * org.aaf.financeiro.model.Boleto boletoFinanceiro = new
		 * org.aaf.financeiro.model.Boleto();
		 * boletoFinanceiro.setEmissao(boleto.getEmissao());
		 * boletoFinanceiro.setId(boleto.getId());
		 * boletoFinanceiro.setValorNominal(boleto.getValorNominal());
		 * boletoFinanceiro.setVencimento(boleto.getVencimento());
		 * boletoFinanceiro.setNossoNumero(String.valueOf(boleto.getNossoNumero(
		 * ))); boletoFinanceiro.setDataPagamento(OfficeUtil.
		 * retornaDataSomenteNumeros(boleto.getDataPagamento()));
		 * boletoFinanceiro.setValorPago(boleto.getValorPago());
		 * boletosFinanceiro.add(boletoFinanceiro); } }
		 */
		return boletosFinanceiro;
	}

	public String getObservacaoProfessores() {
		return observacaoProfessores;
	}

	public void setObservacaoProfessores(String observacaoProfessores) {
		this.observacaoProfessores = observacaoProfessores;
	}

	public String getObservacaoSecretaria() {
		return observacaoSecretaria;
	}

	public void setObservacaoSecretaria(String observacaoSecretaria) {
		this.observacaoSecretaria = observacaoSecretaria;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getAnoLetivo() {
		return anoLetivo;
	}

	public void setAnoLetivo(int anoLetivo) {
		this.anoLetivo = anoLetivo;
	}

	public Boolean getRemovido() {
		return removido;
	}

	public void setRemovido(Boolean removido) {
		this.removido = removido;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Integer getFaltas1Bimestre() {
		return faltas1Bimestre;
	}

	public void setFaltas1Bimestre(Integer faltas1Bimestre) {
		this.faltas1Bimestre = faltas1Bimestre;
	}

	public Integer getFaltas4Bimestre() {
		return faltas4Bimestre;
	}

	public void setFaltas4Bimestre(Integer faltas4Bimestre) {
		this.faltas4Bimestre = faltas4Bimestre;
	}

	public Integer getFaltas3Bimestre() {
		return faltas3Bimestre;
	}

	public void setFaltas3Bimestre(Integer faltas3Bimestre) {
		this.faltas3Bimestre = faltas3Bimestre;
	}

	public Integer getFaltas2Bimestre() {
		return faltas2Bimestre;
	}

	public void setFaltas2Bimestre(Integer faltas2Bimestre) {
		this.faltas2Bimestre = faltas2Bimestre;
	}

	public Boolean getRematricular() {
		return rematricular;
	}

	public void setRematricular(Boolean rematricular) {
		this.rematricular = rematricular;
	}

	public String getEmergenciaLigarPara() {
		return emergenciaLigarPara;
	}

	public void setEmergenciaLigarPara(String emergenciaLigarPara) {
		this.emergenciaLigarPara = emergenciaLigarPara;
	}

	public Boolean getAlergico() {
		return alergico;
	}

	public void setAlergico(Boolean alergico) {
		this.alergico = alergico;
	}

	public Boolean getDoenca() {
		return doenca;
	}

	public void setDoenca(Boolean doenca) {
		this.doenca = doenca;
	}

	public String getNomeDoencas() {
		return nomeDoencas;
	}

	public void setNomeDoencas(String nomeDoencas) {
		this.nomeDoencas = nomeDoencas;
	}

	public String getNomeAlergias() {
		return nomeAlergias;
	}

	public void setNomeAlergias(String nomeAlergias) {
		this.nomeAlergias = nomeAlergias;
	}

	public Aluno getIrmao1() {
		return irmao1;
	}

	public void setIrmao1(Aluno irmao1) {
		this.irmao1 = irmao1;
	}

	public Aluno getIrmao2() {
		return irmao2;
	}

	public void setIrmao2(Aluno irmao2) {
		this.irmao2 = irmao2;
	}

	public Aluno getIrmao3() {
		return irmao3;
	}

	public void setIrmao3(Aluno irmao3) {
		this.irmao3 = irmao3;
	}

	public Aluno getIrmao4() {
		return irmao4;
	}

	public void setIrmao4(Aluno irmao4) {
		this.irmao4 = irmao4;
	}

	public PerioddoEnum getPeriodoProximoAno() {
		return periodoProximoAno;
	}

	public void setPeriodoProximoAno(PerioddoEnum periodoProximoAno) {
		this.periodoProximoAno = periodoProximoAno;
	}

	public Boolean getEnviadoParaCobrancaCDL() {
		return enviadoParaCobrancaCDL;
	}

	public void setEnviadoParaCobrancaCDL(Boolean enviadoParaCobrancaCDL) {
		this.enviadoParaCobrancaCDL = enviadoParaCobrancaCDL;
	}

	public Boolean getEnviadoSPC() {
		return enviadoSPC;
	}

	public void setEnviadoSPC(Boolean enviadoSPC) {
		this.enviadoSPC = enviadoSPC;
	}

	public Boolean getContratoTerminado() {
		return contratoTerminado;
	}

	public void setContratoTerminado(Boolean contratoTerminado) {
		this.contratoTerminado = contratoTerminado;
	}

	public Double getValorTotalDevido() {
		return valorTotalDevido;
	}

	public void setValorTotalDevido(Double valorTotalDevido) {
		this.valorTotalDevido = valorTotalDevido;
	}

	public Date getDataCancelamento() {
		return dataCancelamento;
	}

	public void setDataCancelamento(Date dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}

	public Boolean getRestaurada() {
		return restaurada;
	}

	public void setRestaurada(Boolean restaurada) {
		this.restaurada = restaurada;
	}

	public Boolean getVerificadoOk() {
		return verificadoOk;
	}

	public void setVerificadoOk(Boolean verificadoOk) {
		this.verificadoOk = verificadoOk;
	}

	public List<ContratoAluno> getContratos() {
		if (contratos != null) {
			Collections.sort(contratos);
		}
		return contratos;
	}

	public List<ContratoAluno> getContratosSux() {
		return contratos;
	}

	public void setContratos(List<ContratoAluno> contratos) {
		this.contratos = contratos;
	}

	public List<Boleto> getBoletos(int ano) {
		List<Boleto> boletos = new ArrayList<>();
		for (ContratoAluno contrato : contratos) {
			if (contrato.getAno() == ano) {
				boletos.addAll(contrato.getBoletos());
			}
		}
		return boletos;
	}

	public List<Boleto> getBoletos2() {
		List<Boleto> boletos = new ArrayList<>();
		for (ContratoAluno contrato : contratos) {
			boletos.addAll(contrato.getBoletos());
		}
		return boletos;
	}

	public ContratoAluno getContratoVigente() {
		ContratoAluno contratoAtivo = null;
		if (contratos != null) {
			try {
				for (ContratoAluno contrato : contratos) {
					if (contrato != null) {
						if (contrato.getCancelado() == null || !contrato.getCancelado()) {
							if(contratoAtivo != null 
									&& contrato.getDataCriacaoContrato().after(contratoAtivo.getDataCriacaoContrato())
									&& contrato.getAno() == anoLetivo){
								contratoAtivo = contrato;
							}else if(contratoAtivo == null && contrato.getAno() == anoLetivo ){
								contratoAtivo = contrato;
							}
						}
					}
				}
			} catch (Exception e) {

			}
		}
		
		if(contratoAtivo == null){
			if(contratos != null){
				try{
					return contratos.get(0);
					
				}catch(Exception e){
					return null;
				}
			}
		}

		return contratoAtivo;
	}
	
	public ContratoAluno getContratoVigente(int anoLetivo) {
		ContratoAluno contratoAtivo = null;
		if (contratos != null) {
			for (ContratoAluno contrato : contratos) {
				if ((contrato.getCancelado() == null || !contrato.getCancelado() )) {
					
					if(contratoAtivo != null 
							&& contrato.getDataCriacaoContrato().after(contratoAtivo.getDataCriacaoContrato())
							&& contrato.getAno() == anoLetivo){
						contratoAtivo = contrato;
					}else if(contratoAtivo == null && contrato.getAno() == anoLetivo){
						contratoAtivo = contrato;
					}
				}
			}
		}
		
		if(contratoAtivo == null){
			if(contratos != null && contratos.size() > 0 ){
				return contratos.get(0);
			}
		}

		return contratoAtivo;
	}

	public boolean isContratoAtivo() {
		for (Boleto boleto : boletos) {
			if (boleto.getCancelado() != null && boleto.getValorPago() != null) {
				if (!boleto.getCancelado() && boleto.getValorPago() > boleto.getValorNominal() - 40) {
					return true;
				}
			}
		}
		return true;
	}

	public List<ContratoAluno> getContratosVigentes() {
		List<ContratoAluno> contratosAtivo = new ArrayList<>();
		for (ContratoAluno contrato : contratos) {
			if (contrato.isContratoAtivo()) {
				contratosAtivo.add(0, contrato);
			}
		}

		return contratosAtivo;
	}

	public ContratoAluno getUltimoContrato() {
		if (contratos == null) {
			return null;
		}
		ContratoAluno conts = new ContratoAluno();
		for (ContratoAluno contrato : contratos) {
			if (conts == null || conts.getNumero() == null || contrato.getNumero().equalsIgnoreCase("")
					|| Integer.parseInt(contrato.getNumero()) > Integer.parseInt(conts.getNumero())) {
				conts = contrato;
			}
		}

		return conts;
	}

	// TODO IMPORTANTE REMOVER TUDO DAQUI PARA BAIO
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Double getAnuidade() {
		return anuidade;
	}

	public void setAnuidade(double anuidade) {
		this.anuidade = anuidade;
	}

	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}

	public double getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(double valorMensal) {
		this.valorMensal = valorMensal;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getCpfResponsavel() {
		return cpfResponsavel;
	}

	public void setCpfResponsavel(String cpfResponsavel) {
		this.cpfResponsavel = cpfResponsavel;
	}

	public String getRgResponsavel() {
		return rgResponsavel;
	}

	public void setRgResponsavel(String rgResponsavel) {
		this.rgResponsavel = rgResponsavel;
	}

	public List<Boleto> getBoletos() {
		return boletos;
	}

	public void setBoletos(List<Boleto> boletos) {
		this.boletos = boletos;
	}

	public int getDiaVencimento() {
		return diaVencimento;
	}

	public void setDiaVencimento(int diaVencimento) {
		this.diaVencimento = diaVencimento;
	}

	public boolean isVencimentoUltimoDia() {
		return vencimentoUltimoDia;
	}

	public void setVencimentoUltimoDia(boolean vencimentoUltimoDia) {
		this.vencimentoUltimoDia = vencimentoUltimoDia;
	}

	public Boolean getCnabEnviado() {
		return cnabEnviado;
	}

	public void setCnabEnviado(Boolean cnabEnviado) {
		this.cnabEnviado = cnabEnviado;
	}

	public String getNomePaiResponsavel() {
		return nomePaiResponsavel;
	}

	public void setNomePaiResponsavel(String nomePaiResponsavel) {
		this.nomePaiResponsavel = nomePaiResponsavel;
	}

	public String getNomeMaeResponsavel() {
		return nomeMaeResponsavel;
	}

	public void setNomeMaeResponsavel(String nomeMaeResponsavel) {
		this.nomeMaeResponsavel = nomeMaeResponsavel;
	}

	public int getQuantidadeMesAtrasado() {
		return quantidadeMesAtrasado;
	}

	public void setQuantidadeMesAtrasado(int quantidadeMesAtrasado) {
		this.quantidadeMesAtrasado = quantidadeMesAtrasado;
	}

	public String getMesesAtrasados() {
		return mesesAtrasados;
	}

	public void setMesesAtrasados(String mesesAtrasados) {
		this.mesesAtrasados = mesesAtrasados;
	}

	public String getContatos() {
		return contatos;
	}

	public void setContatos(String contatos) {
		this.contatos = contatos;
	}

	public Date getDataPrometeuPagar() {
		return dataPrometeuPagar;
	}

	public void setDataPrometeuPagar(Date dataPrometeuPagar) {
		this.dataPrometeuPagar = dataPrometeuPagar;
	}

	public String getObservacaoAtrasado() {
		return observacaoAtrasado;
	}

	public void setObservacaoAtrasado(String observacaoAtrasado) {
		this.observacaoAtrasado = observacaoAtrasado;
	}

	public Boolean getContactado() {
		return contactado;
	}

	public void setContactado(Boolean contactado) {
		this.contactado = contactado;
	}

	public Date getDataContato() {
		return dataContato;
	}

	public void setDataContato(Date dataContato) {
		this.dataContato = dataContato;
	}

	public Integer getQuantidadeContatos() {
		if (quantidadeContatos == null) {
			return 0;
		}
		return quantidadeContatos;
	}

	public void setQuantidadeContatos(Integer quantidadeContatos) {
		this.quantidadeContatos = quantidadeContatos;
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

	public String getContatoNome1() {
		return contatoNome1;
	}

	public void setContatoNome1(String contatoNome1) {
		this.contatoNome1 = contatoNome1;
	}

	public String getContatoTelefone2() {
		return contatoTelefone2;
	}

	public void setContatoTelefone2(String contatoTelefone2) {
		this.contatoTelefone2 = contatoTelefone2;
	}

	public String getContatoNome2() {
		return contatoNome2;
	}

	public void setContatoNome2(String contatoNome2) {
		this.contatoNome2 = contatoNome2;
	}

	public String getContatoTelefone3() {
		return contatoTelefone3;
	}

	public void setContatoTelefone3(String contatoTelefone3) {
		this.contatoTelefone3 = contatoTelefone3;
	}

	public String getContatoNome3() {
		return contatoNome3;
	}

	public void setContatoNome3(String contatoNome3) {
		this.contatoNome3 = contatoNome3;
	}

	public String getContatoTelefone4() {
		return contatoTelefone4;
	}

	public void setContatoTelefone4(String contatoTelefone4) {
		this.contatoTelefone4 = contatoTelefone4;
	}

	public String getContatoNome4() {
		return contatoNome4;
	}

	public void setContatoNome4(String contatoNome4) {
		this.contatoNome4 = contatoNome4;
	}

	public String getContatoTelefone5() {
		return contatoTelefone5;
	}

	public void setContatoTelefone5(String contatoTelefone5) {
		this.contatoTelefone5 = contatoTelefone5;
	}

	public String getContatoNome5() {
		return contatoNome5;
	}

	public void setContatoNome5(String contatoNome5) {
		this.contatoNome5 = contatoNome5;
	}

	public String getAutorizadoASairCom1() {
		return autorizadoASairCom1;
	}

	public void setAutorizadoASairCom1(String autorizadoASairCom1) {
		this.autorizadoASairCom1 = autorizadoASairCom1;
	}

	public String getAutorizadoASairCom2() {
		return autorizadoASairCom2;
	}

	public void setAutorizadoASairCom2(String autorizadoASairCom2) {
		this.autorizadoASairCom2 = autorizadoASairCom2;
	}

	public String getAutorizadoASairCom3() {
		return autorizadoASairCom3;
	}

	public void setAutorizadoASairCom3(String autorizadoASairCom3) {
		this.autorizadoASairCom3 = autorizadoASairCom3;
	}

	public String getAutorizadoASairCom4() {
		return autorizadoASairCom4;
	}

	public void setAutorizadoASairCom4(String autorizadoASairCom4) {
		this.autorizadoASairCom4 = autorizadoASairCom4;
	}

	public String getAutorizadoASairCom5() {
		return autorizadoASairCom5;
	}

	public void setAutorizadoASairCom5(String autorizadoASairCom5) {
		this.autorizadoASairCom5 = autorizadoASairCom5;
	}

	public String getAutorizadoASairCom6() {
		return autorizadoASairCom6;
	}

	public void setAutorizadoASairCom6(String autorizadoASairCom6) {
		this.autorizadoASairCom6 = autorizadoASairCom6;
	}

	public String getAutorizadoASairCom7() {
		return autorizadoASairCom7;
	}

	public void setAutorizadoASairCom7(String autorizadoASairCom7) {
		this.autorizadoASairCom7 = autorizadoASairCom7;
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

	public String getEnderecoAluno() {
		return enderecoAluno;
	}

	public void setEnderecoAluno(String enderecoAluno) {
		this.enderecoAluno = enderecoAluno;
	}

	public BairroEnum getBairroAluno() {
		return bairroAluno;
	}

	public void setBairroAluno(BairroEnum bairroAluno) {
		this.bairroAluno = bairroAluno;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public long getPercentualAulasAssistidas() {
		return percentualAulasAssistidas;
	}

	public void setPercentualAulasAssistidas(long percentualAulasAssistidas) {
		this.percentualAulasAssistidas = percentualAulasAssistidas;
	}

	public Date getDataUltimaAulaAssistida() {
		return dataUltimaAulaAssistida;
	}

	public void setDataUltimaAulaAssistida(Date dataUltimaAulaAssistida) {
		this.dataUltimaAulaAssistida = dataUltimaAulaAssistida;
	}

	@Override
	public int compareTo(Aluno o) {
		if (this.percentualAulasAssistidas < o.getPercentualAulasAssistidas()) {
			return -1;
		} else if (this.percentualAulasAssistidas > o.getPercentualAulasAssistidas()) {
			return 1;
		} else {
			return 0;
		}
	}

	public Boolean getGerarNFSe() {
		return gerarNFSe;
	}

	public void setGerarNFSe(Boolean gerarNFSe) {
		this.gerarNFSe = gerarNFSe;
	}
	
	public double getTotalABerto(){
		Calendar c = Calendar.getInstance();
		c.set(2021, 1, 1);
		if(id == 95949){
			System.out.println("a");
		}
		Double total = 0D;
		List<Boleto> boletos = getBoletos2();
		for(Boleto b : boletos){
			if(b.getVencimento().after(c.getTime()) ){
				StatusBoletoEnum status = Verificador.getStatusEnum(b); 
				if(status.equals(StatusBoletoEnum.ATRASADO)){
					total += Verificador.getValorFinal(b);
				}
			}
		}
		
		return total;
	}
}
