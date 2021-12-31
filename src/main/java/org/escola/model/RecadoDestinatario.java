package org.escola.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

import org.aaf.dto.RecadoDestinatarioDTO;

@SuppressWarnings("serial")
@Entity
@XmlRootElement
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class RecadoDestinatario implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    private Recado recado;
    
    @ManyToOne
    private Member destinatario;
    
    @Column
    private int resposta;
    
    @Column
    private String respostaExtenso;
   
	public RecadoDestinatarioDTO getDTO(){
		RecadoDestinatarioDTO recadoDestinatarioDTO = new RecadoDestinatarioDTO();
		recadoDestinatarioDTO.setId(id);
		recadoDestinatarioDTO.setResposta(resposta);
		recadoDestinatarioDTO.setRespostaExtenso(respostaExtenso);
		
		recadoDestinatarioDTO.setDestinatario(destinatario.getDTO());
		recadoDestinatarioDTO.setRecado(recado.getDTO());
		
		return recadoDestinatarioDTO;
	}

	public Recado getRecado() {
		return recado;
	}

	public void setRecado(Recado recado) {
		this.recado = recado;
	}

	public int getResposta() {
		return resposta;
	}

	public void setResposta(int resposta) {
		this.resposta = resposta;
	}

	public String getRespostaExtenso() {
		return respostaExtenso;
	}

	public void setRespostaExtenso(String respostaExtenso) {
		this.respostaExtenso = respostaExtenso;
	}

	public Member getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Member destinatario) {
		this.destinatario = destinatario;
	}

}
