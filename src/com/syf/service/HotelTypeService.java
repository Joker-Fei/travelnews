package com.syf.service;

import java.util.List;

import com.syf.dao.HotelTypeDao;
import com.syf.entity.HotelType;

public class HotelTypeService {
	public int save(HotelType hotelType) {

		return new HotelTypeDao().save(hotelType);
	}

	public List<HotelType> findAll() {
		return new HotelTypeDao().findAll();
	}

	public int delete(int id) {
		return new HotelTypeDao().delete(id);
	}

}
