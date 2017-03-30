package com.syf.entity;

import java.util.Date;

public class HotelDetail {

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

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	private int id;
	private String name;// 酒店名
	private String imgUrl;// 图片地址
	private int typeId;// 类型ID
	private String typeName;// 类型名称
	private int userId;
	private String author;// 发布者名字
	private String price;// 价格
	private String city;// 城市
	private String address;// 地址
	private String phone;// 电话
	private Date publishTime;// 发布时间

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	private String web;

	public HotelDetail() {
		super();
	}

	public HotelDetail(int id, String name, String imgUrl, int typeId,
			String typeName, int userId, String author, String price,
			String city, String web, String address, String phone,
			Date publishTime) {
		super();
		this.id = id;
		this.name = name;
		this.imgUrl = imgUrl;
		this.typeId = typeId;
		this.typeName = typeName;
		this.userId = userId;
		this.author = author;
		this.price = price;
		this.city = city;
		this.web = web;
		this.address = address;
		this.phone = phone;
		this.publishTime = publishTime;

	}

	public HotelDetail(String name, String imgUrl, int userId, int typeId,
			String price, String city, String web, String address,
			String phone, Date publishTime) {
		super();

		this.name = name;
		this.imgUrl = imgUrl;
		this.typeId = typeId;

		this.userId = userId;

		this.price = price;
		this.city = city;
		this.web = web;
		this.address = address;
		this.phone = phone;
		this.publishTime = publishTime;

	}

	public HotelDetail(String name, String imgUrl, int typeId, String price,
			String city, String web, String address, String phone,
			Date publishTime) {
		super();

		this.name = name;
		this.imgUrl = imgUrl;
		this.typeId = typeId;

		this.price = price;
		this.city = city;
		this.web = web;
		this.address = address;
		this.phone = phone;
		this.publishTime = publishTime;

	}

	// 更新
	public HotelDetail(int id, String imgUrl, String name, int typeId,
			int userId, String price, String city, String web, String address,
			String phone, Date publishTime) {

		super();
		this.id = id;
		this.imgUrl = imgUrl;
		this.name = name;
		this.typeId = typeId;
		this.userId = userId;
		this.price = price;
		this.city = city;
		this.web = web;
		this.address = address;
		this.phone = phone;
		this.publishTime = publishTime;

	}

	// 酒店信息用户前端模糊查询
	public HotelDetail(String name, int typeId, String city, String address) {
		super();

		this.name = name;
		this.typeId = typeId;
		// this.price = price;
		this.city = city;
		this.address = address;

	}

	// 前端：根据类型进行快速查询酒店信息分类
	public HotelDetail(int typeId) {
		super();
		this.typeId = typeId;
	}
}
