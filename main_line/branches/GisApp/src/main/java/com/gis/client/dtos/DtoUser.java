package com.gis.client.dtos;

import java.io.Serializable;

public class DtoUser implements Serializable{

	private static final long serialVersionUID = 1L;
	public DtoUser() {
		// TODO Auto-generated constructor stub
	}
	private String name;
	private String password;

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
}
