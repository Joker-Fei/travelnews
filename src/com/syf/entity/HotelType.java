package com.syf.entity;

public class HotelType {
	private int id;
	private String typeName;

	public HotelType() {
		super();
	}

	public HotelType(String typeName) {
		super();
		this.typeName = typeName;
	}

	public HotelType(int id, String typeName) {
		super();
		this.id = id;
		this.typeName = typeName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}