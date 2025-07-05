package com.jsp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name="User_125")
public class User_Dto {
	@Id
	@JsonProperty("USER_NAME")
	@Column(nullable = false,unique = true)
	private String user_name;
	
	@JsonProperty("NAME")
	private String name;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
