package com.example.daegam.vo;

import java.io.Serializable;

public class Member1 implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id = null;
	private String password = null;
	private int age = 0;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}