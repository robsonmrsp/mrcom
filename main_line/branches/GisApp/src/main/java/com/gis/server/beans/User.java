package com.gis.server.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_user")
public class User {

	@Id
	@SequenceGenerator(name = "sq_user_id", sequenceName = "sq_user_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sq_user_id")
	private Integer id;
	
	@Column(unique=true)
	private String name;
	
	@Column
	private String password;

	public User() {	}
	
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
}
