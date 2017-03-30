package com.syf.service;

import java.util.List;

import com.syf.dao.NewsDetailDao;
import com.syf.entity.NewsDetail;

public class NewsDetailService {
	public int save(NewsDetail newsDetail) {
		return new NewsDetailDao().save(newsDetail);
	}

	public List<NewsDetail> findAll() {
		return new NewsDetailDao().findAll();
	}

	public NewsDetail findById(String id) {
		return new NewsDetailDao().findById(id);
	}

	public int delete(String id) {
		return new NewsDetailDao().delete(id);
	}

	public int batchDelete(String[] ids) {
		return new NewsDetailDao().batchDelete(ids);
	}

	public int update(NewsDetail newsDetail) {
		return new NewsDetailDao().update(newsDetail);
	}

	public List<NewsDetail> findByCondition(NewsDetail newsDetail) {
		return new NewsDetailDao().findByCondition(newsDetail);
	}

	public List<NewsDetail> findByTypeId(int typeId) {
		return new NewsDetailDao().findByTypeId(typeId);
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
	public List<NewsDetail> findByPage(int pageNo, int pageSize) {
		return new NewsDetailDao().findByPage(pageNo, pageSize);
	}

	// 统计表中的记录数
	public int count() {
		return new NewsDetailDao().count();
	}

	public List<NewsDetail> findByCondition2(NewsDetail newsDetail) {
		return new NewsDetailDao().findByCondition2(newsDetail);
	}

}
