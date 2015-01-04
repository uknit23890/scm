package com.bean;

import java.io.Serializable;


/**
 * @author Vinay Singh Rawat
 * @Description This a a simple bean class which will represent an article
 */
public class Article implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1966698094651956923L;
	private int id;
	private String title;
	private String content;
	public Article() {
		
	}
	public Article(String title, String content) {
		this.title = title;
		this.content = content;
	}
	public Article(int id,String title, String content) {
		this.setId(id);
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
