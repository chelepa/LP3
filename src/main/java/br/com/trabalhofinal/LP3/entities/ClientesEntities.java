package br.com.trabalhofinal.LP3.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class ClientesEntities {

	@Id
	@GeneratedValue
	@Column(name = "CodigoCli")
	private Integer CodigoCli;
	
	@Column(name = "NomeCli")
	private String NomeCli;
	
	@Column(name = "EnderecoCli")
	private String EnderecoCli;
	
	@Column(name = "CodigoCid")
	private Integer CodigoCid;
	
	@Column(name = "EmailCli")
	private String EmailCli;
	
	@Column(name = "DataNCli")
	private Date DataNCli;
	
	@Column(name = "TelefoneCli")
	private String TelefoneCli;
	
	@Column(name = "CPFCli")
	private String CPFCli;

	public Integer getCodigoCli() {
		return CodigoCli;
	}

	public void setCodigoCli(Integer codigoCli) {
		CodigoCli = codigoCli;
	}

	public String getNomeCli() {
		return NomeCli;
	}

	public void setNomeCli(String nomeCli) {
		NomeCli = nomeCli;
	}

	public String getEnderecoCli() {
		return EnderecoCli;
	}

	public void setEnderecoCli(String enderecoCli) {
		EnderecoCli = enderecoCli;
	}

	public Integer getCodigoCid() {
		return CodigoCid;
	}

	public void setCodigoCid(Integer codigoCid) {
		CodigoCid = codigoCid;
	}

	public String getEmailCli() {
		return EmailCli;
	}

	public void setEmailCli(String emailCli) {
		EmailCli = emailCli;
	}

	public Date getDataNCli() {
		return DataNCli;
	}

	public void setDataNCli(Date dataNCli) {
		DataNCli = dataNCli;
	}

	public String getTelefoneCli() {
		return TelefoneCli;
	}

	public void setTelefoneCli(String telefoneCli) {
		TelefoneCli = telefoneCli;
	}

	public String getCPFCli() {
		return CPFCli;
	}

	public void setCPFCli(String cPFCli) {
		CPFCli = cPFCli;
	}
	
}
