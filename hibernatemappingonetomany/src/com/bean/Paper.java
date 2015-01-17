package com.bean;

import java.util.Set;

/**
 * @author Vinay Singh Rawat
 * 
 */
public class Paper extends Entity {
	private static final long serialVersionUID = -7381619038851660948L;
	private String paperName;
	private String description;
	private Set<Question> questions;

	/**
	 * @param paperName
	 */
	public Paper(String paperName) {
		super();
		this.paperName = paperName;

	}
	/**
	 * @param paperName
	 * @param description
	 */
	public Paper(String paperName, String description) {
		super();
		this.paperName = paperName;
		this.description = description;
	}

	public Paper() {

	}

	/**
	 * @return paperName
	 */
	public String getPaperName() {
		return paperName;
	}

	/**
	 * @param paperName
	 */
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return questions
	 */
	public Set<Question> getQuestions() {
		return questions;
	}

	/**
	 * @param questions
	 */
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
}
