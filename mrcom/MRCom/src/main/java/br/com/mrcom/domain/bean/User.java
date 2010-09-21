package br.com.mrcom.domain.bean;

public class User {
	private String name="";
	
	public String getName() {
		return name;
	}
	public User() {
	
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String alteraUsuario() {
		this.name = name + " Teste";
		return "sucess";
	}
}