package com.syf.entity;

import java.util.Date;

public class NewsDetail {

	private int id;
	private String title;
	private String content;
	private int userId;
	// 发布者名字
	private String author;
	private int typeId;
	// 新闻类型名称
	private String typeName;
	private Date publishTime;
	private String topper;
	private String bold;
	private String color;

	public NewsDetail() {
		super();
	}

	public NewsDetail(int id, String title, String content, int userId,
			int typeId, Date publishTime, String topper, String bold,
			String color) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.typeId = typeId;
		this.publishTime = publishTime;
		this.topper = topper;
		this.bold = bold;
		this.color = color;
	}

	public NewsDetail(String title, String content, String author, int typeId,
			String topper, String bold, String color) {
		super();
		this.title = title;
		this.content = content;
		this.author = author;
		this.typeId = typeId;
		this.topper = topper;
		this.bold = bold;
		this.color = color;
	}

	public NewsDetail(String title, String content, int userId, int typeId,
			Date publishTime, String topper, String bold, String color) {
		super();
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.typeId = typeId;
		this.publishTime = publishTime;
		this.topper = topper;
		this.bold = bold;
		this.color = color;
	}

	public NewsDetail(int id, String title, String content, int userId,
			String author, int typeId, String typeName, Date publishTime,
			String topper, String bold, String color) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.author = author;
		this.typeId = typeId;
		this.typeName = typeName;
		this.publishTime = publishTime;
		this.topper = topper;
		this.bold = bold;
		this.color = color;
	}

	// 根据新闻类型进行查询
	public NewsDetail(int typeId) {

		super();
		this.typeId = typeId;

	}

	public NewsDetail(String title) {
		super();
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public String getDealTitle() {
		String titleStr = this.title;
		if ("1".equals(this.bold)) {
			titleStr = "<b>" + titleStr + "</b>";
		}
		String color = "";
		switch (this.color) {
		case "1":
			color = "red";
			break;
		case "2":
			color = "blue";
			break;
		case "3":
			color = "yellow";
			break;
		default:
			color = "black";
		}
		titleStr = "<font color='" + color + "'>" + titleStr + "</font>";
		return titleStr;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getTopper() {
		return topper;
	}

	public void setTopper(String topper) {
		this.topper = topper;
	}

	public String getBold() {
		return bold;
	}

	public void setBold(String bold) {
		this.bold = bold;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}
