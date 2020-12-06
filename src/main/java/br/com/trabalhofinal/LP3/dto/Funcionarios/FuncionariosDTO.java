package br.com.trabalhofinal.LP3.dto.Funcionarios;

import java.sql.Date;

public class FuncionariosDTO {

	private Integer CodigoFunc;
	
	private String NomeFunc;
	
	private String EnderecoFunc;
	
	private Integer CodigoCid;
	
	private String EmailFunc;
	
	private Date DataNFunc;
	
	private String TelefoneFunc;
	
	private String CPFFunc;
	
	private String SalarioFunc;

	public Integer getCodigoFunc() {
		return CodigoFunc;
	}

	public void setCodigoFunc(Integer codigoFunc) {
		CodigoFunc = codigoFunc;
	}

	public String getNomeFunc() {
		return NomeFunc;
	}

	public void setNomeFunc(String nomeFunc) {
		NomeFunc = nomeFunc;
	}

	public String getEnderecoFunc() {
		return EnderecoFunc;
	}

	public void setEnderecoFunc(String enderecoFunc) {
		EnderecoFunc = enderecoFunc;
	}

	public Integer getCodigoCid() {
		return CodigoCid;
	}

	public void setCodigoCid(Integer codigoCid) {
		CodigoCid = codigoCid;
	}

	public String getEmailFunc() {
		return EmailFunc;
	}

	public void setEmailFunc(String emailFunc) {
		EmailFunc = emailFunc;
	}

	public Date getDataNFunc() {
		return DataNFunc;
	}

	public void setDataNFunc(Date dataNFunc) {
		DataNFunc = dataNFunc;
	}

	public String getTelefoneFunc() {
		return TelefoneFunc;
	}

	public void setTelefoneFunc(String telefoneFunc) {
		TelefoneFunc = telefoneFunc;
	}

	public String getCPFFunc() {
		return CPFFunc;
	}

	public void setCPFFunc(String cPFFunc) {
		CPFFunc = cPFFunc;
	}

	public String getSalarioFunc() {
		return SalarioFunc;
	}

	public void setSalarioFunc(String salarioFunc) {
		SalarioFunc = salarioFunc;
	}
	
}
