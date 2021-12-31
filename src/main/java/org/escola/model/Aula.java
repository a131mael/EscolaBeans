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
import java.time.LocalDate;
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

import org.aaf.dto.AulaDTO;
import org.escola.enums.DisciplinaEnum;
import org.escola.enums.Serie;

@SuppressWarnings("serial")
@Entity
@XmlRootElement
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Aula implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 1, max = 250)
    private String titulo;
    
    @Column
    private Date dataAula;
    
    @Column
    private String descricao;
    
    @Column
    private DisciplinaEnum disciplina;

    @Column
    private String linkYoutube;
    
    private Serie serie;
    
    @NotNull
    private Integer ordem;

    private Boolean visible = false;
    
    public Aula(String titulo){
    	this.titulo = titulo;	
    }
    
    public Aula(){
    	
    }
    
	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public String getLinkYoutube() {
		return linkYoutube;
	}
	
	public String getLinkYoutubeEmbed() {
		String aux = linkYoutube;
		if(linkYoutube != null){
			aux = linkYoutube.replace("https://youtu.be", "https://www.youtube.com/embed");
			aux = aux.replace("https://www.youtube.com/watch?v=", "https://www.youtube.com/embed/");
			aux = aux.replace("https://studio.youtube.com/video", "https://www.youtube.com/embed/");
			aux = aux.replace("https://www.youtube.com/channel/", "https://www.youtube.com/embed/");
			aux = aux.replace("https://studio.youtube.com/video/", "https://www.youtube.com/embed/");
			
		}
		int position = aux.indexOf("&t=");
		if(position>0){
			aux = aux.substring(0, position);
		}
		
		return aux;
	}
	
	public AulaDTO getDTO(){
		AulaDTO dto = new AulaDTO();
		dto.setDataAula(dataAula);
		dto.setDescricao(descricao);
		dto.setDisciplina(disciplina.ordinal());
		dto.setLinkYoutube(linkYoutube);
		dto.setOrdem(ordem);
		dto.setSerie(serie.ordinal());
		dto.setTitulo(titulo);
		dto.setVisible(visible);
		
		return dto;
	}
	
	public String getIdVideoYouTube() {
		String aux = linkYoutube;
		if(linkYoutube != null){
			aux = linkYoutube.replace("https://youtu.be/", "");
			aux = aux.replace("https://www.youtube.com/embed/", "");
		}
		return aux;
	}

	public void setLinkYoutube(String linkYoutube) {
		this.linkYoutube = linkYoutube;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataAula() {
		return dataAula;
	}

	public void setDataAula(Date dataAula) {
		this.dataAula = dataAula;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DisciplinaEnum getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(DisciplinaEnum disciplina) {
		this.disciplina = disciplina;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
    
	
}
