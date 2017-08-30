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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.aaf.dto.RecadoDTO;

@SuppressWarnings("serial")
@Entity
@XmlRootElement
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Recado implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 1, max = 250)
    private String nome;
    
    @Column                
    private Date dataInicio;
    
    @Column
    private Date dataFim;
    
    @Column
    private String descricao;

    @Column
    private String codigo;
    
    @Column
    private boolean questionario;
    
    @Column
    private boolean removido;
    
    @Column
    private String opcao1;
    
    @Column
    private String opcao2;
    
    @Column
    private String opcao3;
    
    @Column
    private String opcao4;
    
    @Column
    private String opcao5;
    
    @Column
    private String opcao6;
    
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Date getDataInicio() {
		return dataInicio;
	}


	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}


	public Date getDataFim() {
		return dataFim;
	}


	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public boolean isQuestionario() {
		return questionario;
	}


	public void setQuestionario(boolean questionario) {
		this.questionario = questionario;
	}


	public String getOpcao1() {
		return opcao1;
	}


	public void setOpcao1(String opcao1) {
		this.opcao1 = opcao1;
	}


	public String getOpcao2() {
		return opcao2;
	}


	public void setOpcao2(String opcao2) {
		this.opcao2 = opcao2;
	}


	public String getOpcao3() {
		return opcao3;
	}


	public void setOpcao3(String opcao3) {
		this.opcao3 = opcao3;
	}


	public String getOpcao4() {
		return opcao4;
	}


	public void setOpcao4(String opcao4) {
		this.opcao4 = opcao4;
	}


	public String getOpcao5() {
		return opcao5;
	}


	public void setOpcao5(String opcao5) {
		this.opcao5 = opcao5;
	}


	public String getOpcao6() {
		return opcao6;
	}


	public void setOpcao6(String opcao6) {
		this.opcao6 = opcao6;
	}


	public boolean isRemovido() {
		return removido;
	}


	public void setRemovido(boolean removido) {
		this.removido = removido;
	}
	
	public RecadoDTO getDTO(){
		RecadoDTO recadoDTO = new RecadoDTO();
		recadoDTO.setCodigo(codigo);
		recadoDTO.setDataFim(dataFim);
		recadoDTO.setDataInicio(dataInicio);
		recadoDTO.setDescricao(descricao);
		recadoDTO.setId(id);
		recadoDTO.setNome(nome);
		recadoDTO.setOpcao1(opcao1);
		recadoDTO.setOpcao2(opcao2);
		recadoDTO.setOpcao3(opcao3);
		recadoDTO.setOpcao4(opcao4);
		recadoDTO.setOpcao5(opcao5);
		recadoDTO.setOpcao6(opcao6);
		recadoDTO.setQuestionario(questionario);
		recadoDTO.setRemovido(removido);
		return recadoDTO;
	}

}
