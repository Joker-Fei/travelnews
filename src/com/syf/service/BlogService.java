package com.syf.service;

import java.util.List;

import com.syf.dao.BlogDao;
import com.syf.entity.Blog;

public class BlogService {

	public int save(Blog blog) {
		return new BlogDao().save(blog);
	}

	public List<Blog> findAll() {
		return new BlogDao().findAll();
	}

	public Blog findById(String id) {
		return new BlogDao().findById(id);
	}

	public List<Blog> findAllByUserId(String id) {
		return new BlogDao().findAllByUserId(id);
	}

	/*
	 * public List<Blog> findAll() { return new BlogDao().findAll(); }
	 * 
	 * public Blog findById(String id) { return new BlogDao().findById(id); }
	 * 
	 * public int delete(String id) { return new BlogDao().delete(id); }
	 * 
	 * public int batchDelete(String[] ids) { return new
	 * BlogDao().batchDelete(ids); }
	 * 
	 * public int update(Blog blog) { return new BlogDao().update(blog); }
	 * 
	 * public List<Blog> findByCondition(Blog blog) { return new
	 * BlogDao().findByCondition(blog); }
	 * 
	 * 
	 * public List<Blog> findByTypeId(int typeId) { return new
	 * BlogDao().findByTypeId(typeId); }
	 */

	public int delete(String id) {
		return new BlogDao().delete(id);

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
	public List<Blog> findByPage(int pageNo, int pageSize) {
		return new BlogDao().findByPage(pageNo, pageSize);
	}

	// 统计表中的记录数
	public int count() {
		return new BlogDao().count();
	}
}
