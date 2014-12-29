package com.backend.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Admin class is an Serialized user bean <br>
 * which implement Serializable and IUser
 * 
 * @author Vinay Singh Rawat
 * 
 * 
 */

public class Admin extends UserEntity implements Serializable{
	
	private static final long serialVersionUID = -4008243158314606117L;
	private String userName;
	
	
	private String password;
	private String emailID;

	/**
	 * Default constructor
	 */
	public Admin() {

	}

	/**
	 * Constructor
	 * 
	 * @param userName
	 */
	public Admin(String userName) {
		super();
		this.userName = userName;
	}

	/**
	 * Constructor
	 * 
	 * @param userName
	 * @param password
	 */
	public Admin(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	

	/* (non-Javadoc)
	 * @see com.backend.bean.IUser#getUserName()
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/* (non-Javadoc)
	 * @see com.backend.bean.IUser#getPassword()
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Admin username:"+userName;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

}
