package br.com.trabalhofinal.LP3.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fornecedores")
public class FornecedoresEntities {
	
	@Id
	@GeneratedValue
	@Column(name = "CodigoFor")
	private Integer CodigoFor;
	
	@Column(name = "NomeFor")
	private String NomeFor;
	
	@Column(name = "EnderecoFor")
	private String EnderecoFor;

	@Column(name = "CodigoCid")
	private Integer CodigoCid;
	
	@Column(name = "EmailFor")
	private String EmailFor;
	
	@Column(name = "CNPJFor")
	private String CNPJFor;
	
	@Column(name = "TelefoneFor")
	private String TelefoneFor;

	public Integer getCodigoFor() {
		return CodigoFor;
	}

	public void setCodigoFor(Integer codigoFor) {
		CodigoFor = codigoFor;
	}

	public String getNomeFor() {
		return NomeFor;
	}

	public void setNomeFor(String nomeFor) {
		NomeFor = nomeFor;
	}

	public String getEnderecoFor() {
		return EnderecoFor;
	}

	public void setEnderecoFor(String enderecoFor) {
		EnderecoFor = enderecoFor;
	}

	public Integer getCodigoCid() {
		return CodigoCid;
	}

	public void setCodigoCid(Integer codigoCid) {
		CodigoCid = codigoCid;
	}

	public String getEmailFor() {
		return EmailFor;
	}

	public void setEmailFor(String emailFor) {
		EmailFor = emailFor;
	}

	public String getCNPJFor() {
		return CNPJFor;
	}

	public void setCNPJFor(String cNPJFor) {
		CNPJFor = cNPJFor;
	}

	public String getTelefoneFor() {
		return TelefoneFor;
	}

	public void setTelefoneFor(String telefoneFor) {
		TelefoneFor = telefoneFor;
	}

}
