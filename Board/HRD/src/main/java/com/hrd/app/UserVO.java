package com.hrd.app;

public class UserVO {
	private String id;
	private String password;
	private String name;
	private String email;
	private String birth;
	public UserVO(String id, String password, String name, String email, String birth) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.birth = birth;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", birth="
				+ birth + "]";
	}
}