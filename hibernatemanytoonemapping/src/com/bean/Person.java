package com.bean;

import java.io.Serializable;

/**
 * @author Vinay Singh Rawat
 * 
 */
public class Person implements Serializable {
	private static final long serialVersionUID = -7381619038851660948L;
	private int id;
	private String name;
	private Address address;

	public Person(String name, Address address) {
		this.name = name;
		this.address = address;
	}

	public Person() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
