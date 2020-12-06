package br.com.trabalhofinal.LP3.dto.Clientes;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class ClientesResponse {

	private Integer CodigoCli;
	
	private String NomeCli;
	
	private String EnderecoCli;
	
	private String CodigoCid;
	
	private String EmailCli;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate DataNCli;
	
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

	public String getCodigoCid() {
		return CodigoCid;
	}

	public void setCodigoCid(String codigoCid) {
		CodigoCid = codigoCid;
	}

	public String getEmailCli() {
		return EmailCli;
	}

	public void setEmailCli(String emailCli) {
		EmailCli = emailCli;
	}

	public LocalDate getDataNCli() {
		return DataNCli;
	}

	public void setDataNCli(LocalDate dataNCli) {
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
