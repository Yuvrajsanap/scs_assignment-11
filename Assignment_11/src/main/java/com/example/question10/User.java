package com.example.question10;

public class User {
	private String name;
	private String email;

	// Default constructor
	public User() {
	}

	// Parameterized constructor
	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}

	// Getter and Setter methods
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
}
