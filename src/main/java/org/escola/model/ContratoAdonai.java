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
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@Entity
@XmlRootElement
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "contratanteCPF"))
public class ContratoAdonai implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 1, max = 250)
    @Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
    private String contratanteNome;
    
    @NotNull
    @Size(min = 1, max = 20)
    private String contratanteCPF;

    @NotNull
    @Size(min = 1, max = 20)
    private String contratanteRG;
    
    @NotNull
    @Size(min = 1, max = 250)
    private String contratanteEndereco;
    
    @NotNull
    @Size(min = 1, max = 550)
    private String serie;
    
    @NotNull
    @Size(min = 1, max = 550)
    private String periodo;
    
    @NotNull
    @Size(min = 1, max = 10)
    private String anuidade;
    
    @NotNull
    @Size(min = 1, max = 10)
    private String numeroParcelas;
    
    @NotNull
    @Size(min = 1, max = 20)
    private String valorMensal;

    @NotNull
    @Size(min = 1, max = 20)
    private String mesesAPagar;
    
    
    @NotNull
    @Size(min = 1, max = 20)
    private String telefon2;
    
    private Date dataCriacao;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContratanteNome() {
		return contratanteNome;
	}

	public void setContratanteNome(String contratanteNome) {
		this.contratanteNome = contratanteNome;
	}

	public String getContratanteCPF() {
		return contratanteCPF;
	}

	public void setContratanteCPF(String contratanteCPF) {
		this.contratanteCPF = contratanteCPF;
	}

	public String getContratanteRG() {
		return contratanteRG;
	}

	public void setContratanteRG(String contratanteRG) {
		this.contratanteRG = contratanteRG;
	}

	public String getContratanteEndereco() {
		return contratanteEndereco;
	}

	public void setContratanteEndereco(String contratanteEndereco) {
		this.contratanteEndereco = contratanteEndereco;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getAnuidade() {
		return anuidade;
	}

	public void setAnuidade(String anuidade) {
		this.anuidade = anuidade;
	}

	public String getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(String numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}

	public String getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(String valorMensal) {
		this.valorMensal = valorMensal;
	}

	public String getMesesAPagar() {
		return mesesAPagar;
	}

	public void setMesesAPagar(String mesesAPagar) {
		this.mesesAPagar = mesesAPagar;
	}

	public String getTelefon2() {
		return telefon2;
	}

	public void setTelefon2(String telefon2) {
		this.telefon2 = telefon2;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
    
    
    
		
}
