package model;

import java.util.Date;

public class Topic {
	
	int id;
	String name;
	String comment;
	String userid;
	Date time;
	
	public Topic(){}
	
	public Topic(int id, String name, String comment, String userid) {
		super();
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.userid = userid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	public String getTimeText(){
		java.text.SimpleDateFormat dateformatYYYYMMDD = new java.text.SimpleDateFormat("dd.MMM.yyyy.hh:mm aaa");
        return dateformatYYYYMMDD.format(time);
	}
		
}
