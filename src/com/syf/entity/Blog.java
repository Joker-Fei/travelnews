package com.syf.entity;

import java.util.Date;

public class Blog {

	private int id;
	private String title;
	private String imgUrl;

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	private String content;
	private int userId;
	// 发布者名字
	private String author;

	private Date publishTime;
	private String topper;
	private String bold;
	private String color;

	public Blog() {
		super();
	}

	public Blog(int id, String title, String content, int userId,
			Date publishTime, String topper, String bold, String color) {
		super();
		this.id = id;
		this.title = title;
		// this.imgUrl = imgUrl;
		this.content = content;
		this.userId = userId;
		this.publishTime = publishTime;
		this.topper = topper;
		this.bold = bold;
		this.color = color;
	}

	public Blog(String title, String content, String author, String topper,
			String bold, String color) {
		super();
		this.title = title;
		this.content = content;
		this.author = author;
		this.topper = topper;
		this.bold = bold;
		this.color = color;
	}

	// 添加
	public Blog(String title, String imgUrl, String content, int userId,
			Date publishTime, String topper, String bold, String color) {
		super();
		this.title = title;
		this.imgUrl = imgUrl;
		this.content = content;
		this.userId = userId;
		this.publishTime = publishTime;
		this.topper = topper;
		this.bold = bold;
		this.color = color;
	}

	// 查找
	public Blog(int id, String title, String imgUrl, String content,
			int userId, String author, Date publishTime, String topper,
			String bold, String color) {
		super();
		this.id = id;
		this.title = title;
		this.imgUrl = imgUrl;
		this.content = content;
		this.userId = userId;
		this.author = author;
		this.publishTime = publishTime;
		this.topper = topper;
		this.bold = bold;
		this.color = color;
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

}