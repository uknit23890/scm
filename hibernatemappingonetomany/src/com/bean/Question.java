package com.bean;



/**
 * @author Vinay Singh Rawat
 * 
 */
public class Question extends Entity {
	private static final long serialVersionUID = -6034665023447471690L;
	private String question;
	private String answer;
	

	public Question() {

	}

	/**
	 * @param id
	 * @param question
	 * @param answer
	 */
	public Question(long id, String question,String answer) {
		super(id);
		this.question = question;
		this.answer = answer;
	}

	/**
	 * @param question
	 * @param answer
	 */
	public Question(String question,String answer) {
		this.question = question;
		this.answer = answer;
	}

	/**
	 * @return question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question
	 */

	public void setQuestion(String question) {
		this.question = question;
	}

		/**
	 * @return answer
	 */
	public String getanswer() {
		return answer;
	}

	/**
	 * @param answer
	 */
	public void setanswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "qid:" + getId();
	}


}
