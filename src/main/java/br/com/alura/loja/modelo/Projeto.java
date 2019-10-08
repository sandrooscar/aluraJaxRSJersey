package br.com.alura.loja.modelo;

import com.thoughtworks.xstream.XStream;

public class Projeto {
	private long id;
	private int anoDeInicio;
	private String nome;
	
	public Projeto(long id, String nome, int anoDeInicio) {
		super();
		this.id = id;
		this.anoDeInicio = anoDeInicio;
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public int getAnoDeInicio() {
		return anoDeInicio;
	}
	public String getNome() {
		return nome;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setAnoDeInicio(Integer anoDeInicio) {
		this.anoDeInicio = anoDeInicio;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toXML() {
		return new XStream().toXML(this);
	}
}
