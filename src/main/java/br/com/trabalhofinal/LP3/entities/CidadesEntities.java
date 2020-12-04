package br.com.trabalhofinal.LP3.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cidades")
public class CidadesEntities {
	
	@Id
	@GeneratedValue
	@Column(name = "codigo_cid")
	private Integer codigo;
	
	@Column(name = "nome_cid")
	private String nome;
	
	@Column(name = "uf_cid")
	private String UF;
	
	@Column(name = "cep_cid")
	private String CEP;
	
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

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}
	
}
