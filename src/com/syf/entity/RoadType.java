package com.syf.entity;

public class RoadType {
	private int id;
	private String typeName;

	public RoadType() {
		super();
	}

	public RoadType(String typeName) {
		super();
		this.typeName = typeName;
	}

	public RoadType(int id, String typeName) {
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