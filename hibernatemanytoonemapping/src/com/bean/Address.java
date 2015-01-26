package com.bean;

import java.io.Serializable;

public class Address implements Serializable{
	private static final long serialVersionUID = -1760182359637828669L;
	private int id;
	private String city;
	private String street;
	private String zipCode;

	public Address(String city, String street, String zipCode) {
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getstreet() {
		return street;
	}

	public void setstreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
