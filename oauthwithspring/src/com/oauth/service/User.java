package com.oauth.service;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "USER")
@XmlType(propOrder = { "email", "password", "firstName", "lastName", "mobile" })
public class User implements Serializable {

	/**
	 * @author www.sourcecodematrix.com
	 * @Description This is a user bean which we will show to authorized user in form of xml data.
	 */
	private static final long serialVersionUID = 2079088013865374663L;

	public User(String email, String password, String firstName, String lastName, String mobile) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
	}

	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String mobile;

	public User() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the email
	 */
	public @XmlElement String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public @XmlElement String getFirstName() {

		return firstName;

	}

	public @XmlElement String getLastName() {

		return lastName;
	}

	public @XmlElement String getMobile() {
		return mobile;
	}

}
