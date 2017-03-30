package com.syf.service;

import java.util.List;

import com.syf.dao.NewsTypeDao;
import com.syf.entity.NewsType;

public class NewsTypeService {

	public int save(NewsType newsType) {

		return new NewsTypeDao().save(newsType);
	}

	public int batchDelete(String[] ids) {
		return new NewsTypeDao().batchDelete(ids);
	}

	public List<NewsType> findAll() {
		return new NewsTypeDao().findAll();
	}

	public int delete(int id) {
		return new NewsTypeDao().delete(id);
	}

}
