package com.syf.entity;

import java.util.Date;

public class MessageDetail {

	public MessageDetail() {
		super();
	}

	public MessageDetail(String tag, String content, int userId,
			Date publishTime) {
		super();
		// this.id = id;
		this.tag = tag;
		this.content = content;
		this.userId = userId;
		this.publishTime = publishTime;
	}

	public MessageDetail(int id, String tag, String content, int userId,
			String author, Date publishTime) {
		super();
		this.id = id;
		this.tag = tag;
		this.content = content;
		this.userId = userId;
		this.author = author;
		this.publishTime = publishTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	private int id;
	private String tag;
	private String content;
	private int userId;
	private Date publishTime;
	private String author;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
