package com.simplenotes.user;

public enum UserState {
	not_active("未激活"),
	activated("已激活");

	private String description;

	private UserState(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
