package com.gis.client.dtos;

import com.extjs.gxt.ui.client.data.BaseModelData;

@SuppressWarnings("unused")
public class DtoUser extends BaseModelData{

	public static final String USER_ID = "id";
	public static final String USER_ID_DISPLAY = "id";

	public static final String USER_NAME = "name";
	public static final String USER_NAME_DISPLAY = "name";
	
	public static final String USER_PASSWORD = "password";
	public static final String USER_PASSWORD_DISPLAY = "password";
	
	private static final long serialVersionUID = 1L;
	public DtoUser() {	}
	
	private Integer id;
	private String name;
	private String password;

	public DtoUser(String name, String password) {
		super();
		setName(name);
		setPassword(password);
	}
	public void setName(String name) {
		set(USER_NAME, name);
	}
	public String getName() {
		return get(USER_NAME);
	}
	public void setPassword(String password) {
		set(USER_PASSWORD,password );
	}
	public String getPassword() {
		return get(USER_PASSWORD);
	}

	public void setId(Integer id) {
		set(USER_ID,id);
	}
	
	public Integer getId() {
		return get(USER_ID);
	}
	
}
