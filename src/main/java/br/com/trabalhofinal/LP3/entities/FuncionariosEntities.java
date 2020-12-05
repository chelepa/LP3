package br.com.trabalhofinal.LP3.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funcionarios")
public class FuncionariosEntities {

	@Id
	@GeneratedValue
	@Column(name = "codigo_func")
	private Integer CodigoFunc;
	
	@Column(name = "nome_func")
	private String NomeFunc;
	
	@Column(name = "endereco_func")
	private String EnderecoFunc;
	
	@Column(name = "codigo_cid")
	private Integer CodigoCid;
	
	@Column(name = "email_func")
	private String EmailFunc;
	
	@Column(name = "data_nasc_func")
	private Date DataNFunc;
	
	@Column(name = "telefone_func")
	private String TelefoneFunc;
	
	@Column(name = "cpf_func")
	private String CPFFunc;
	
	@Column(name = "salario_func")
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
