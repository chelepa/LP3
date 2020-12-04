package br.com.trabalhofinal.LP3.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UsuariosEntities {
	
	@Id
	@GeneratedValue
	@Column(name = "CodigoUser")
	private Integer codigo;
	
	@Column(name = "NomeUser")
	private String nome;
	
	@Column(name = "SenhaUser")
	private String SenhaUser;
	
	@Column(name = "CodFunc")
	private Integer CodFunc;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenhaUser() {
		return SenhaUser;
	}

	public void setSenhaUser(String senhaUser) {
		SenhaUser = senhaUser;
	}

	public Integer getCodFunc() {
		return CodFunc;
	}

	public void setCodFunc(Integer codFunc) {
		CodFunc = codFunc;
	}
	
}
