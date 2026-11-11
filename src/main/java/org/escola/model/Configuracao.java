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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

import org.escola.enums.BimestreEnum;

@SuppressWarnings("serial")
@Entity
@XmlRootElement
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Configuracao implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private int anoLetivo;
    
    @Column
    private BimestreEnum bimestre;
    
    @Column
    private Short anoRematricula;
    
    @Column
    private long sequencialArquivoCNAB;
    
    @Transient
    private double valorNotas;

    /** Dados do prestador exigidos pela DPS do sistema nacional de NFS-e --
     * no sistema antigo (Atende.net/Palhoca) nao eram necessarios no XML
     * porque a prefeitura inferia pelo login/senha autenticado. */
    @Column
    private String cnpj;

    @Column
    private String razaoSocial;

    @Column
    private String inscricaoMunicipal;

    /** Codigo IBGE do municipio (Palhoca = 4211900) */
    @Column
    private String codigoMunicipio;

    /** Caminho absoluto do certificado digital A1 (.pfx) usado pra assinar a DPS */
    @Column
    private String certificadoPath;

    @Column
    private String certificadoSenha;

    /** "homologacao" ou "producao" -- sempre comeca em homologacao, so troca
     * depois de testar de verdade no ambiente de testes do governo. */
    @Column
    private String nfseAmbiente;

    /** Client ID da aplicacao cadastrada no Portal Developers do Sicoob (API Cobranca Bancaria) */
    @Column
    private String sicoobClientId;

    /** Numero de cliente (cooperado) no Sicoob, usado na consulta de boletos */
    @Column
    private String sicoobNumeroContrato;

    /** Codigo da modalidade da carteira de cobranca (ex: 1 = Simples com registro) */
    @Column
    private String sicoobCodigoModalidade;

    /** "producao" ou "sandbox" */
    @Column
    private String sicoobAmbiente;

    /** Codigo da agencia (cooperativa) Sicoob -- usado pra calcular o DV do Nosso Numero */
    @Column
    private String sicoobCodigoAgencia;

    /** Client ID do app Sicoob com escopo de Pix (pode ser diferente do client_id de boletos) */
    @Column
    private String sicoobPixClientId;

    /** ISPB da cooperativa/banco Sicoob */
    @Column
    private String sicoobIspb;

    /** Numero da conta corrente da empresa no Sicoob */
    @Column
    private String sicoobContaCorrente;


    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public int getAnoLetivo() {
		return anoLetivo;
	}


	public void setAnoLetivo(int anoLetivo) {
		this.anoLetivo = anoLetivo;
	}

	public BimestreEnum getBimestre() {
		return bimestre;
	}

	public void setBimestre(BimestreEnum bimestre) {
		this.bimestre = bimestre;
	}

	public long getSequencialArquivoCNAB() {
		return sequencialArquivoCNAB;
	}

	public void setSequencialArquivoCNAB(long sequencialArquivoCNAB) {
		this.sequencialArquivoCNAB = sequencialArquivoCNAB;
	}

	public Short getAnoRematricula() {
		return anoRematricula;
	}

	public void setAnoRematricula(Short anoRematricula) {
		this.anoRematricula = anoRematricula;
	}

	public double getValorNotas() {
		return valorNotas;
	}

	public void setValorNotas(double valorNotas) {
		this.valorNotas = valorNotas;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public String getCodigoMunicipio() {
		return codigoMunicipio;
	}

	public void setCodigoMunicipio(String codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}

	public String getCertificadoPath() {
		return certificadoPath;
	}

	public void setCertificadoPath(String certificadoPath) {
		this.certificadoPath = certificadoPath;
	}

	public String getCertificadoSenha() {
		return certificadoSenha;
	}

	public void setCertificadoSenha(String certificadoSenha) {
		this.certificadoSenha = certificadoSenha;
	}

	public String getNfseAmbiente() {
		return nfseAmbiente;
	}

	public void setNfseAmbiente(String nfseAmbiente) {
		this.nfseAmbiente = nfseAmbiente;
	}

	public String getSicoobClientId() {
		return sicoobClientId;
	}

	public void setSicoobClientId(String sicoobClientId) {
		this.sicoobClientId = sicoobClientId;
	}

	public String getSicoobNumeroContrato() {
		return sicoobNumeroContrato;
	}

	public void setSicoobNumeroContrato(String sicoobNumeroContrato) {
		this.sicoobNumeroContrato = sicoobNumeroContrato;
	}

	public String getSicoobCodigoModalidade() {
		return sicoobCodigoModalidade;
	}

	public void setSicoobCodigoModalidade(String sicoobCodigoModalidade) {
		this.sicoobCodigoModalidade = sicoobCodigoModalidade;
	}

	public String getSicoobAmbiente() {
		return sicoobAmbiente;
	}

	public void setSicoobAmbiente(String sicoobAmbiente) {
		this.sicoobAmbiente = sicoobAmbiente;
	}

	public String getSicoobCodigoAgencia() {
		return sicoobCodigoAgencia;
	}

	public void setSicoobCodigoAgencia(String sicoobCodigoAgencia) {
		this.sicoobCodigoAgencia = sicoobCodigoAgencia;
	}

	public String getSicoobPixClientId() {
		return sicoobPixClientId;
	}

	public void setSicoobPixClientId(String sicoobPixClientId) {
		this.sicoobPixClientId = sicoobPixClientId;
	}

	public String getSicoobIspb() {
		return sicoobIspb;
	}

	public void setSicoobIspb(String sicoobIspb) {
		this.sicoobIspb = sicoobIspb;
	}

	public String getSicoobContaCorrente() {
		return sicoobContaCorrente;
	}

	public void setSicoobContaCorrente(String sicoobContaCorrente) {
		this.sicoobContaCorrente = sicoobContaCorrente;
	}

}
