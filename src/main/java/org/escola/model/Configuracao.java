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


}
