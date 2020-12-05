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
	@Column(name = "codigo_user")
	private Integer codigo;
	
	@Column(name = "nome_user")
	private String nome;
	
	@Column(name = "senha_user")
	private String SenhaUser;
	
	@Column(name = "codigo_func")
	private Integer CodFunc;
	
	@Column(name = "nivel_acesso_user")
	private String NivelAcessoUser;

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
	
	public String getNivelAcessoUser() {
		return NivelAcessoUser;
	}

	public void setNivelAcessoUser(String nivelAcessoUser) {
		NivelAcessoUser = nivelAcessoUser;
	}
	
}
