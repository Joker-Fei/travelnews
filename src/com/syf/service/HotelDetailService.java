package com.syf.service;

import java.util.List;

import com.syf.dao.HotelDetailDao;
import com.syf.entity.HotelDetail;

public class HotelDetailService {
	public int save(HotelDetail hotelDetail) {
		return new HotelDetailDao().save(hotelDetail);
	}

	public List<HotelDetail> findAll() {
		return new HotelDetailDao().findAll();
	}

	public HotelDetail findById(String id) {
		return new HotelDetailDao().findById(id);
	}

	public int delete(String id) {
		return new HotelDetailDao().delete(id);
	}

	// public int batchDelete(String[] ids) {
	// return new HotelDetailDao().batchDelete(ids);
	// }

	// public int update(HotelDetail hotelDetail) {
	// return new HotelDetailDao().update(hotelDetail);
	// }

	public List<HotelDetail> findByCondition(HotelDetail hotelDetail) {
		return new HotelDetailDao().findByCondition(hotelDetail);
	}

	public List<HotelDetail> findByTypeId(int typeId) {
		return new HotelDetailDao().findByTypeId(typeId);
	}

	/**
	 * 分页查询
	 * 
	 * @param pageNo
	 *            当前第几页
	 * @param pageSize
	 *            每页大小
	 * @return
	 */
	public List<HotelDetail> findByPage(int pageNo, int pageSize) {
		return new HotelDetailDao().findByPage(pageNo, pageSize);
	}

	// 统计表中的记录数
	public int count() {
		return new HotelDetailDao().count();
	}

}
