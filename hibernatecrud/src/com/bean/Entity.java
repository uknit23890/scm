package com.bean;

import java.io.Serializable;
/**
 * @author Vinay Singh Rawat
 * extend this class to make your class entity object to make crud operation over it 
 * on it respective table.
 */
public abstract class Entity implements Serializable{
	
	private static final long serialVersionUID = 4233709998278181734L;
	//id is map with primary key of article table
	private long id;
	public Entity(long id) {
		super();
		this.id = id;
	}
	public Entity() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

}
