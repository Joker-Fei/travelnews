package com.syf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.syf.entity.Blog;
import com.syf.util.DBUtil;

public class BlogDao {

	DBUtil dbUtil = new DBUtil();

	public int save(Blog blog) {
		String sql = "insert into blog (title,imgUrl,content,userId,publishTime,topper,bold,color) values(?,?,?,?,?,?,?,?)";
		Object[] params = { blog.getTitle(), blog.getImgUrl(),
				blog.getContent(), blog.getUserId(), blog.getPublishTime(),
				blog.getTopper(), blog.getBold(), blog.getColor() };
		return dbUtil.executeUpdate(sql, params);
	}

	// 查找所有博客列表
	public List<Blog> findAll() {
		String sql = " select n.id,n.title,n.imgUrl,n.content,n.userId,"
				+ " u.userName author,n.publishTime,n.topper,"
				+ " n.bold,n.color" + " from blog n,userdetail u"
				+ " where n.userId=u.id "
				+ " order by topper desc,n.publishTime desc";
		return findBySQL(sql, null);
	}

	// 通用查找方法
	private List<Blog> findBySQL(String sql, Object[] params) {
		List<Blog> list = new ArrayList<Blog>();
		ResultSet rs = dbUtil.executeQuery(sql, params);
		try {
			while (rs.next()) {
				Blog blog = new Blog(rs.getInt("id"), rs.getString("title"),
						rs.getString("imgUrl"), rs.getString("content"),
						rs.getInt("userId"), rs.getString("author"),
						rs.getDate("publishTime"), rs.getString("topper"),
						rs.getString("bold"), rs.getString("color"));
				list.add(blog);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeAll();
		}
		return list;
	}

	// 根据博客id具体显示博客详情
	public Blog findById(String id) {

		String sql = " select n.id,n.title,n.imgUrl,n.content,n.userId,"
				+ " u.userName author,n.publishTime,n.topper,"
				+ " n.bold,n.color" + " from blog n,userdetail u"
				+ " where n.userId=u.id and n.id=?"
				+ " order by topper desc,n.publishTime desc";
		Object[] params = { id };
		List<Blog> blogList = findBySQL(sql, params);
		if (blogList != null && blogList.size() > 0) {
			return blogList.get(0);
		}
		return null;

	}

	// 根据用户Id来查找用户的博客
	public List<Blog> findAllByUserId(String id) {
		String sql = " select b.id,b.title,b.imgUrl,b.content,b.userId,"
				+ " u.userName author,b.publishTime,b.topper,"
				+ " b.bold,b.color" + " from blog b,userdetail u"
				+ " where b.userId=u.id and u.id=?"
				+ " order by topper desc,b.publishTime desc";
		Object[] params = { id };
		return findBySQL(sql, params);
	}

	public int delete(String id) {
		String sql = "delete from blog where id=?";
		Object[] params = { id };
		return dbUtil.executeUpdate(sql, params);
	}

	// 根据条件统计数据
	public int count(String sql, Object[] params) {
		ResultSet rs = dbUtil.executeQuery(sql, params);
		try {
			if (rs.next()) {
				// 使用下标访问列，从1开始
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeAll();
		}
		return 0;
	}

	// 分页显示
	public List<Blog> findByPage(int pageNo, int pageSize) {
		String sql = " select n.id,n.title,n.imgUrl,n.content,n.userId,"
				+ " u.userName author,n.publishTime,n.topper,"
				+ " n.bold,n.color" + " from blog n,userdetail u"
				+ " where n.userId=u.id "
				+ " order by topper desc,n.publishTime desc limit ?,?";
		Object[] params = { (pageNo - 1) * pageSize, pageSize };
		return findBySQL(sql, params);
	}

	// 统计表中的记录数
	public int count() {
		String sql = "select count(*) from blog";
		return count(sql, null);
	}

}
