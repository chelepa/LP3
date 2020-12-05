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
	@Column(name = "codigo_cli")
	private Integer CodigoCli;
	
	@Column(name = "nome_cli")
	private String NomeCli;
	
	@Column(name = "endereco_cli")
	private String EnderecoCli;
	
	@Column(name = "codigo_cid")
	private Integer CodigoCid;
	
	@Column(name = "email_cli")
	private String EmailCli;
	
	@Column(name = "data_nasc_cli")
	private Date DataNCli;
	
	@Column(name = "telefone_cli")
	private String TelefoneCli;
	
	@Column(name = "cpf_cli")
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
