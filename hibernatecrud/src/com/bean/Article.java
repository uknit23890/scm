package com.bean;


/**
 * @author Vinay Singh Rawat
 * This a a simple bean class which will represent 
 * an article entity map with article table in database
 * This class extending Entity, so we can make crud operations
 */
public class Article extends Entity{
	private static final long serialVersionUID = -822312181022679845L;
	private String title;
	private String content;
	public Article() {
		
	}
	public Article(String title, String content) {
		this.title = title;
		this.content = content;
	}
	public Article(long id,String title, String content) {
		super(id);
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

}
