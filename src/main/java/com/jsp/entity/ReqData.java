package com.jsp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name = "Reqdata_125")
public class ReqData {
	@Id
	@Column(nullable = false,unique = true)
	@JsonProperty("REFID")
	private String refid;
	@JsonProperty("APPID")
	@Column(nullable = false,unique = true)
	private String appid;
	
	@JsonProperty("CUSTOMER_DTO")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CUST_ID",referencedColumnName = "CUST_ID")
	private Customer_Dto customer_dto;
	
	@JsonProperty("USER_DTO")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_NAME",referencedColumnName = "USER_NAME")
	private User_Dto user_dto;

	public String getRefid() {
		return refid;
	}

	public void setRefid(String refid) {
		this.refid = refid;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public Customer_Dto getCustomer_dto() {
		return customer_dto;
	}

	public void setCustomer_dto(Customer_Dto customer_dto) {
		this.customer_dto = customer_dto;
	}

	public User_Dto getUser_dto() {
		return user_dto;
	}

	public void setUser_dto(User_Dto user_dto) {
		this.user_dto = user_dto;
	}
	
	

}
