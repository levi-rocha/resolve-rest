package com.example.myapp;

import java.io.Serializable;

public class UserSimpleDTO implements Serializable {

	private static final long serialVersionUID = 2839156404112207275L;

	private Long id;
	private String username;
	private String email;
	private Permission permission;

	public static UserSimpleDTO fromUser(User user) {
		UserSimpleDTO dto = new UserSimpleDTO();
		dto.setId(user.getId());
		dto.setUsername(user.getUsername());
		dto.setEmail(user.getEmail());
		dto.setPermission(user.getPermission());
		return dto;
	}

	public UserSimpleDTO() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}
}
