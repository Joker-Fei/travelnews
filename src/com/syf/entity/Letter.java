package com.syf.entity;

import java.util.Date;

public class Letter {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	private int id;
	private int messageId;
	private String content;
	private Date writeTime;
	private int userId;

	public Letter() {
		super();
	}

	public Letter(int id, int userId, int messageId, String content,
			Date writeTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.messageId = messageId;
		this.content = content;
		this.writeTime = writeTime;
	}

	public Letter(int userId, int messageId, String content, Date writeTime) {
		super();

		this.userId = userId;
		this.messageId = messageId;
		this.content = content;
		this.writeTime = writeTime;
	}
}
