package com.xzm.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment {
	
	private int id;
	private String commentUser;
	private String commentContent;
	private Date commentPublishTime;
	private int commentNewsId;

	public Comment() {
		this.commentPublishTime = new Date();
	}
	
	public Comment(int id, String commentUser,
			String commentContent, Date commentPublishTime, int commentNewsId) {
		super();
		this.id = id;
		this.commentUser = commentUser;
		this.commentContent = commentContent;
		this.commentPublishTime =commentPublishTime;
		this.commentNewsId = commentNewsId;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommentUser() {
		return commentUser;
	}

	public void setCommentUser(String commentUser) {
		this.commentUser = commentUser;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentPublishTime() {
		return commentPublishTime;
	}

	public void setCommentPublishTime(Date commentPublishTime) {
		this.commentPublishTime = commentPublishTime;
	}

	public int getCommentNewsId() {
		return commentNewsId;
	}

	public void setCommentNewsId(int commentNewsId) {
		this.commentNewsId = commentNewsId;
	}

}
