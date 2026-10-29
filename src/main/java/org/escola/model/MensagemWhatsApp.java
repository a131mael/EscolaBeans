package org.escola.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "mensagem_whatsapp")
public class MensagemWhatsApp implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

	@Column(length = 30)
	private String telefone;

	// WA message ID for deduplication
	@Column(name = "message_id", length = 80)
	private String messageId;

	@Column(columnDefinition = "TEXT")
	private String texto;

	@Column(name = "from_me")
	private boolean fromMe;

	// Unix timestamp from WA
	@Column(name = "wa_timestamp")
	private long waTimestamp;

	@Column(name = "data_criacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao = new Date();

	// bytes reais da mídia (imagem/áudio/vídeo/documento), baixados da Evolution API
	// enquanto o link do WhatsApp ainda está válido, pra nunca mais expirar depois
	@Lob
	@Column(name = "midia")
	private byte[] midia;

	@Column(name = "midia_mimetype", length = 100)
	private String midiaMimetype;

	public MensagemWhatsApp() {}

	public MensagemWhatsApp(Aluno aluno, String telefone, String messageId, String texto, boolean fromMe, long waTimestamp) {
		this.aluno = aluno;
		this.telefone = telefone;
		this.messageId = messageId;
		this.texto = texto;
		this.fromMe = fromMe;
		this.waTimestamp = waTimestamp;
		this.dataCriacao = new Date();
	}

	public Long getId() { return id; }
	public Aluno getAluno() { return aluno; }
	public void setAluno(Aluno aluno) { this.aluno = aluno; }
	public String getTelefone() { return telefone; }
	public void setTelefone(String telefone) { this.telefone = telefone; }
	public String getMessageId() { return messageId; }
	public void setMessageId(String messageId) { this.messageId = messageId; }
	public String getTexto() { return texto; }
	public void setTexto(String texto) { this.texto = texto; }
	public boolean isFromMe() { return fromMe; }
	public void setFromMe(boolean fromMe) { this.fromMe = fromMe; }
	public long getWaTimestamp() { return waTimestamp; }
	public void setWaTimestamp(long waTimestamp) { this.waTimestamp = waTimestamp; }
	public Date getDataCriacao() { return dataCriacao; }
	public void setDataCriacao(Date dataCriacao) { this.dataCriacao = dataCriacao; }
	public byte[] getMidia() { return midia; }
	public void setMidia(byte[] midia) { this.midia = midia; }
	public String getMidiaMimetype() { return midiaMimetype; }
	public void setMidiaMimetype(String midiaMimetype) { this.midiaMimetype = midiaMimetype; }
}
