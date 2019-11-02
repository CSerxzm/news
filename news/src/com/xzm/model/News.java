package com.xzm.model;

import java.util.Date;

public class News {
	
	private int id;
	private String newsTitle;
	private Date newsPublishTime;
	private String newsContent;
	private boolean newsIsPicture;
	private String newsPictureSite;
	private boolean newsIsTopLine;
	private boolean newsIsHot;
	private int newsCategoryId;
	private int newsHitCount;
	private int newsCommentCount;

	public News() {
	}

	public News(int newsHitCount, int newsCommentCount, Date newsPublishTime,
			boolean newsIsPicture, boolean newsIsTopLine, boolean newsIsHot) {
		this.newsHitCount = newsHitCount;
		this.newsCommentCount = newsCommentCount;
		this.newsPublishTime = newsPublishTime;
		this.newsIsPicture = newsIsPicture;
		this.newsIsTopLine = newsIsTopLine;
		this.newsIsHot = newsIsHot;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public Date getNewsPublishTime() {
		return newsPublishTime;
	}

	public void setNewsPublishTime(Date newsPublishTime) {
		this.newsPublishTime = newsPublishTime;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public boolean isNewsIsPicture() {
		return newsIsPicture;
	}

	public void setNewsIsPicture(boolean newsIsPicture) {
		this.newsIsPicture = newsIsPicture;
	}

	public String getNewsPictureSite() {
		return newsPictureSite;
	}

	public void setNewsPictureSite(String newsPictureSite) {
		this.newsPictureSite = newsPictureSite;
	}

	public boolean isNewsIsTopLine() {
		return newsIsTopLine;
	}

	public void setNewsIsTopLine(boolean newsIsTopLine) {
		this.newsIsTopLine = newsIsTopLine;
	}

	public boolean isNewsIsHot() {
		return newsIsHot;
	}

	public void setNewsIsHot(boolean newsIsHot) {
		this.newsIsHot = newsIsHot;
	}

	public int getNewsCategoryId() {
		return newsCategoryId;
	}

	public void setNewsCategoryId(int newsCategoryId) {
		this.newsCategoryId = newsCategoryId;
	}

	public int getNewsHitCount() {
		return newsHitCount;
	}

	public void setNewsHitCount(int newsHitCount) {
		this.newsHitCount = newsHitCount;
	}

	public int getNewsCommentCount() {
		return newsCommentCount;
	}

	public void setNewsCommentCount(int newsCommentCount) {
		this.newsCommentCount = newsCommentCount;
	}

	@Override
	public String toString() {
		return "News \n[id=" + id + ", newsTitle=" + newsTitle
				+", newsPublishTime=" + newsPublishTime
				+ ", newsContent=" + newsContent + ", newsIsPicture="
				+ newsIsPicture + ", newsPictureSite=" + newsPictureSite
				+ ", newsIsTopLine=" + newsIsTopLine + ", newsIsHot="
				+ newsIsHot + ", newsCategoryId=" + newsCategoryId
				+ ", newsHitCount=" + newsHitCount + ", newsCommentCount="
				+ newsCommentCount + "]";
	}
}
