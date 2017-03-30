package com.syf.entity;

import java.util.Date;

public class Comment {
	private int id;
	private int userId;
	private int newsId;
	private String content;
	private Date writeTime;
	private int status;

	public Comment() {
		super();
	}

	public Comment(int userId, int newsId, String content, Date writeTime,
			int status) {
		super();
		this.userId = userId;
		this.newsId = newsId;
		this.content = content;
		this.writeTime = writeTime;
		this.status = status;
	}

	public Comment(int id, int userId, int newsId, String content,
			Date writeTime, int status) {
		super();
		this.id = id;
		this.userId = userId;
		this.newsId = newsId;
		this.content = content;
		this.writeTime = writeTime;
		this.status = status;
	}

	public Comment(int id, int userId, int newsId, String content,
			Date writeTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.newsId = newsId;
		this.content = content;
		this.writeTime = writeTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWriteTime() {
		return writeTime;
	}

	public void setWriteTime(Date writeTime) {
		this.writeTime = writeTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
