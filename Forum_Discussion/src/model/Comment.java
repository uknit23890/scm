package model;

import java.util.Date;

public class Comment {
	int id;
	int topicid;
	String userid;
	String comment;
	Date time;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTopicid() {
		return topicid;
	}
	public void setTopicid(int topicid) {
		this.topicid = topicid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
