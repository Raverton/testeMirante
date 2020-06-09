package br.com.raverton.crud.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Pessoa {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id;
	
	private String nome;
	
	private String cpf;
	
	private Date dtNacimento;
	
	private String nomePai;
	
	private String nomeMae;
	
	private String login;
	
	//private TipoPessoa tipoPessoa;
	
	private String tipoPessoa;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDtNacimento() {
		return dtNacimento;
	}

	public void setDtNacimento(Date dtNacimento) {
		this.dtNacimento = dtNacimento;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}


	
}
