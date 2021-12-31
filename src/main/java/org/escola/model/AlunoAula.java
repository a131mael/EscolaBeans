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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

import org.aaf.dto.AlunoAulaDTO;

@SuppressWarnings("serial")
@Entity
@XmlRootElement
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class AlunoAula implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Aula aula;

    @ManyToOne
    private Aluno aluno;
    
    private Boolean assistiu;

	public Boolean getAssistiu() {
		return assistiu;
	}

	public void setAssistiu(Boolean assistiu) {
		this.assistiu = assistiu;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AlunoAulaDTO getDTO() {
		AlunoAulaDTO alunoAulaDTO = new AlunoAulaDTO();
		alunoAulaDTO.setId(id);
		alunoAulaDTO.setAluno(aluno.getDTO());
		alunoAulaDTO.setAssistiu(assistiu);
		alunoAulaDTO.setAula(aula.getDTO());
		return alunoAulaDTO;
	}

}
