package com.xzm.model;


public class TopLineNews {
	private int newsId;
	private String newsTitle;
	private String newsSumary;

	public TopLineNews() {
	}

	public TopLineNews(int newsId, String newsTitle, StringBuffer newsContent) {
		this.newsId = newsId;
		this.newsTitle = newsTitle;
		if(newsContent.length()>80){
			this.newsSumary = newsContent.substring(0, 80);
		}else if(newsContent.length()>1 && newsContent.length()<=80){
			this.newsSumary = newsContent.substring(0, newsContent.length()-1);
		}else{
			this.newsSumary="暂无内容";
		}
		System.out.println("newsSumary="+newsSumary);
		
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsSumary() {
		return newsSumary;
	}

	public void setNewsSumary(String newsSumary) {
		this.newsSumary = newsSumary;
	}

	@Override
	public String toString() {
		return "TopLineNews [newsId=" + newsId + ", newsTitle=" + newsTitle
				+ ", newsSumary=" + newsSumary + "]";
	}

}
