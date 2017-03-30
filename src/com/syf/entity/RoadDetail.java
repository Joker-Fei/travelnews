package com.syf.entity;

import java.util.Date;

public class RoadDetail {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getGoRoad() {
		return goRoad;
	}

	public void setGoRoad(String goRoad) {
		this.goRoad = goRoad;
	}

	public String getBackRoad() {
		return backRoad;
	}

	public void setBackRoad(String backRoad) {
		this.backRoad = backRoad;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMainInfo() {
		return mainInfo;
	}

	public void setMainInfo(String mainInfo) {
		this.mainInfo = mainInfo;
	}

	public String getTraffic() {
		return traffic;
	}

	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	private Date publishTime;

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public RoadDetail() {
		super();
	}

	// RoadDetail roadDetail = new RoadDetail(id, roadName, typeId,
	// loginUser.getId(), price, goRoad, backRoad, days, agency,
	// phone, traffic, mainInfo, tag, publishTime);
	// 更新
	public RoadDetail(int id, String roadName, int typeId, int userId,
			String price, String goRoad, String backRoad, String days,
			String agency, String phone, String traffic, String mainInfo,
			String tag, Date publishTime) {
		super();
		this.id = id;
		this.roadName = roadName;
		this.typeId = typeId;
		this.userId = userId;
		this.price = price;
		this.goRoad = goRoad;
		this.backRoad = backRoad;
		this.days = days;
		this.agency = agency;
		this.phone = phone;
		this.traffic = traffic;
		this.mainInfo = mainInfo;
		this.tag = tag;
		this.publishTime = publishTime;

	}

	public RoadDetail(String roadName, int typeId, int userId, String price,
			String goRoad, String backRoad, String days, String agency,
			String phone, String traffic, String mainInfo, String tag,
			Date publishTime) {
		super();

		this.roadName = roadName;
		this.userId = userId;
		this.typeId = typeId;
		this.price = price;
		this.goRoad = goRoad;
		this.backRoad = backRoad;
		this.days = days;
		this.agency = agency;
		this.phone = phone;
		this.traffic = traffic;
		this.mainInfo = mainInfo;
		this.tag = tag;
		this.publishTime = publishTime;
	}

	public RoadDetail(int id, String roadName, int typeId, int userId,
			String author, String typeName, String price, String goRoad,
			String backRoad, String days, String agency, String phone,
			String traffic, String mainInfo, String tag, Date publishTime) {
		// TODO uto-generated constructor stub
		super();
		this.id = id;
		this.roadName = roadName;
		this.typeId = typeId;
		this.userId = userId;
		this.author = author;
		this.typeName = typeName;
		this.price = price;
		this.goRoad = goRoad;
		this.backRoad = backRoad;
		this.days = days;
		this.agency = agency;
		this.phone = phone;
		this.traffic = traffic;
		this.mainInfo = mainInfo;
		this.tag = tag;
		this.publishTime = publishTime;
	}

	// 前端查询
	public RoadDetail(String roadName, int typeId, String goRoad,
			String backRoad, String traffic, String tag) {
		super();
		this.roadName = roadName;
		this.typeId = typeId;
		this.goRoad = goRoad;
		this.backRoad = backRoad;
		this.traffic = traffic;
		this.tag = tag;
	}

	// 根据路线类型进入酒店详细分类
	public RoadDetail(int typeId) {
		super();

		this.typeId = typeId;
	}

	private int id;
	private String roadName;
	private int typeId;
	private String typeName;
	private int userId;
	private String author;
	private String price;
	private String goRoad;
	private String backRoad;
	private String days;
	private String agency;
	private String traffic;
	private String phone;
	private String mainInfo;
	private String tag;
}
