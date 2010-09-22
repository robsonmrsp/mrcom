package br.com.mrcom.domain.bean;

public class Usuario {
	private String name="";
	
	public String getName() {
		return name;
	}
	public Usuario() {
	
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String alteraUsuario() {
		this.name = name + " Teste";
		return "sucess";
	}
}