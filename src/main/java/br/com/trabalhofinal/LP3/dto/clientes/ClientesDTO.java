package br.com.trabalhofinal.LP3.dto.clientes;

import java.sql.Date;

public class ClientesDTO {

	private Integer CodigoCli;
	
	private String NomeCli;
	
	private String EnderecoCli;
	
	private Integer CodigoCid;
	
	private String EmailCli;
	
	private Date DataNCli;
	
	private String TelefoneCli;
	
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
