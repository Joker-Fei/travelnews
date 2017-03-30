package com.syf.entity;

import java.util.Date;

import com.syf.util.DateUtil;

public class UserDetail {
	private int id;
	private String userName;
	private String userPwd;
	private String phone;
	private int power;
	private int status;
	private Date registerTime;
	// 查询条件
	private Date startTime;
	private Date endTime;

	// 构造方法
	public UserDetail() {
		super();
	}

	public UserDetail(String userName, String userPwd, String phone, int power,
			int status, Date registerTime) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
		this.phone = phone;
		this.power = power;
		this.status = status;
		this.registerTime = registerTime;
	}

	public UserDetail(int id, String userName, String userPwd, String phone,
			int power, int status, Date registerTime) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPwd = userPwd;
		this.phone = phone;
		this.power = power;
		this.status = status;
		this.registerTime = registerTime;
	}

	public UserDetail(String userName, String phone, int power, int status,
			Date startTime, Date endTime) {
		super();
		this.userName = userName;
		this.phone = phone;
		this.power = power;
		this.status = status;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	// get/set方法
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPower() {
		return power;
	}

	public String getDealPower() {
		switch (this.power) {
		case 1:
			return "管理员";
		case 2:
			return "信息发布员";
		case 3:
			return "普通会员";
		}
		return "访客";
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public String getDealStartTime() {
		return DateUtil.date2String(this.startTime);
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public String getDealEndTime() {
		return DateUtil.date2String(this.endTime);
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}