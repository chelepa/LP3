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
	@Column(name = "codigo_for")
	private Integer CodigoFor;
	
	@Column(name = "nome_for")
	private String NomeFor;
	
	@Column(name = "endereco_for")
	private String EnderecoFor;

	@Column(name = "codigo_cid")
	private Integer CodigoCid;
	
	@Column(name = "email_for")
	private String EmailFor;
	
	@Column(name = "cnpj_for")
	private String CNPJFor;
	
	@Column(name = "telefone_for")
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
