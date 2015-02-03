package com.bean;
public class Role {
	private int id;

	private String roleName;

	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}

	public Role(int id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}

	// Overriding equals and hashCode to make object unique by roleName.
	// To avoid getting two role id with same roleName.
	public boolean equals(Object role) {
		if (role == null)
			return false;
		if (!this.getClass().equals(role.getClass()))
			return false;
		Role role2 = (Role) role;
		if ((this.id == role2.getId())
				&& (roleName.trim()
						.equalsIgnoreCase(role2.getRoleName().trim()))) {
			return true;
		}
		return false;
	}
	public int hashCode() {
		return roleName.trim().toLowerCase().hashCode();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
