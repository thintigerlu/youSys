package com.lu.model.account;

import java.io.Serializable;
import java.util.List;

public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2388463258698051402L;
	private String id;
	private String name;
	private String status;
	private String password;
	private List<Holding> holdings;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Holding> getHoldings() {
		return holdings;
	}
	public void setHoldings(List<Holding> holdings) {
		this.holdings = holdings;
	}
}
