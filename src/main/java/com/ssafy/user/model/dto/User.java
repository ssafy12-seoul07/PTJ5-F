package com.ssafy.user.model.dto;

public class User {
	private String id;
	private String nickname;
	private String password;
	
	public User() {
	}
	
	public User(String id, String nickname, String password) {
		this.id = id;
		this.nickname = nickname;
		this.password = password;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nickname=" + nickname + ", password=" + password + "]";
	}
	
	
}
