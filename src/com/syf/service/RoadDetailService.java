package com.syf.service;

import java.util.List;

import com.syf.dao.RoadDetailDao;
import com.syf.entity.RoadDetail;

public class RoadDetailService {
	public int save(RoadDetail roadDetail) {
		return new RoadDetailDao().save(roadDetail);
	}

	public List<RoadDetail> findAll() {
		return new RoadDetailDao().findAll();
	}

	public RoadDetail findById(String id) {
		return new RoadDetailDao().findById(id);
	}

	public int delete(String id) {
		return new RoadDetailDao().delete(id);
	}

	public int batchDelete(String[] ids) {
		return new RoadDetailDao().batchDelete(ids);
	}

	public int update(RoadDetail roadDetail) {
		return new RoadDetailDao().update(roadDetail);
	}

	public List<RoadDetail> findByCondition(RoadDetail roadDetail) {
		return new RoadDetailDao().findByCondition(roadDetail);
	}

	public List<RoadDetail> findByTypeId(int typeId) {
		return new RoadDetailDao().findByTypeId(typeId);
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
	public List<RoadDetail> findByPage(int pageNo, int pageSize) {
		return new RoadDetailDao().findByPage(pageNo, pageSize);
	}

	// 统计表中的记录数
	public int count() {
		return new RoadDetailDao().count();
	}

}
