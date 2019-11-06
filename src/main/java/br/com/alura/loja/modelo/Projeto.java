package br.com.alura.loja.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Projeto {
	private long id;
	private int anoDeInicio;
	private String nome;
	
	public Projeto() {
		
	}
	
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

	public String toJson() {
		return new Gson().toJson(this);
	}
}
