package com.bean;

import java.util.Set;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private Set<Role> roles;

	public Employee(String firstName, String lastName, Set<Role> roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
