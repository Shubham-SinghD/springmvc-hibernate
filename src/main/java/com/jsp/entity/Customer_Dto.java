package com.jsp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="customer_125")
public class Customer_Dto {
	
	@Id
	@JsonProperty("CUST_ID")
	@Column(nullable = false,unique = true)
	private String cust_id;
	@JsonProperty("CUST_ADD")
	private String cust_add;
	@JsonProperty("CUST_SAL")
	private String cust_sal;
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_add() {
		return cust_add;
	}
	public void setCust_add(String cust_add) {
		this.cust_add = cust_add;
	}
	public String getCust_sal() {
		return cust_sal;
	}
	public void setCust_sal(String cust_sal) {
		this.cust_sal = cust_sal;
	}

}
