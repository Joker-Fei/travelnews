package com.syf.service;

import java.util.List;

import com.syf.dao.RoadTypeDao;
import com.syf.entity.RoadType;

public class RoadTypeService {
	public int save(RoadType roadType) {

		return new RoadTypeDao().save(roadType);
	}

	public List<RoadType> findAll() {
		return new RoadTypeDao().findAll();
	}

	public int delete(int id) {
		return new RoadTypeDao().delete(id);
	}

}
