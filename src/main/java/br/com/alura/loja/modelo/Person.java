package br.com.alura.loja.modelo;

import com.google.gson.Gson;

public class Person {
    String name;
    String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Person(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	public String toJson() {
		return new Gson().toJson(this);
	}

}
