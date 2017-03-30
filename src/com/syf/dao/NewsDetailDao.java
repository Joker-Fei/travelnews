package com.syf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.syf.entity.NewsDetail;
import com.syf.util.ArrayUtil;
import com.syf.util.DBUtil;

public class NewsDetailDao {

	DBUtil dbUtil = new DBUtil();

	public int save(NewsDetail newsDetail) {
		String sql = "insert into news (title,content,userId,typeId,publishTime,topper,bold,color) values(?,?,?,?,?,?,?,?)";
		Object[] params = { newsDetail.getTitle(), newsDetail.getContent(),
				newsDetail.getUserId(), newsDetail.getTypeId(),
				newsDetail.getPublishTime(), newsDetail.getTopper(),
				newsDetail.getBold(), newsDetail.getColor() };
		return dbUtil.executeUpdate(sql, params);
	}

	public List<NewsDetail> findAll() {
		// String sql = "select * from news";
		String sql = " select n.id,n.title,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime,n.topper,"
				+ " n.bold,n.color" + " from news n,userdetail u,newstype t"
				+ " where n.userId=u.id and n.typeId=t.id "
				+ " order by topper desc,n.publishTime desc";
		return findBySQL(sql, null);
	}

	public NewsDetail findById(String id) {
		String sql = " select n.id,n.title,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime,n.topper,"
				+ " n.bold,n.color" + " from news n,userdetail u,newstype t"
				+ " where n.userId=u.id and n.typeId=t.id and n.id=?"
				+ " order by topper desc,n.publishTime desc";
		Object[] params = { id };
		List<NewsDetail> newsDetailList = findBySQL(sql, params);
		if (newsDetailList != null && newsDetailList.size() > 0) {
			return newsDetailList.get(0);
		}
		return null;
	}

	public List<NewsDetail> findByTypeId(int typeId) {
		String sql = " select n.id,n.title,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime,n.topper,"
				+ " n.bold,n.color" + " from news n,userdetail u,newstype t"
				+ " where n.userId=u.id and n.typeId=t.id  and n.typeId=?"
				+ " order by topper desc,n.publishTime desc";
		Object[] params = { typeId };
		return findBySQL(sql, params);
	}

	public List<NewsDetail> findByCondition(NewsDetail newsDetail) {
		StringBuffer buffer = new StringBuffer(
				"select n.id,n.title,n.content,n.userId,n.typeId,"
						+ " u.userName author,t.typeName,n.publishTime,n.topper,"
						+ " n.bold,n.color"
						+ " from news n,userdetail u,newstype t"
						+ " where n.userId=u.id and n.typeId=t.id ");
		List<Object> params = new ArrayList<Object>();
		if (newsDetail != null) {
			if (newsDetail.getTitle() != null
					&& !"".equals(newsDetail.getTitle())) {
				buffer.append(" and title like ?");
				params.add("%" + newsDetail.getTitle() + "%");
			}
			if (newsDetail.getContent() != null
					&& !"".equals(newsDetail.getContent())) {
				buffer.append(" and content like ?");
				params.add("%" + newsDetail.getContent() + "%");
			}
			if (newsDetail.getTypeId() != -1) {
				buffer.append(" and typeId= ?");
				params.add(newsDetail.getTypeId());
			}
			if (!"-1".equals(newsDetail.getTopper())) {
				buffer.append(" and topper= ?");
				params.add(newsDetail.getTopper());
			}
			if (!"-1".equals(newsDetail.getBold())) {
				buffer.append(" and bold= ?");
				params.add(newsDetail.getBold());
			}
			if (!"-1".equals(newsDetail.getColor())) {
				buffer.append(" and color= ?");
				params.add(newsDetail.getColor());
			}
		}
		return findBySQL(new String(buffer), params.toArray());
	}

	// 查找的通用方法（返回一个集合）
	public List<NewsDetail> findBySQL(String sql, Object[] params) {
		List<NewsDetail> list = new ArrayList<NewsDetail>();
		ResultSet rs = dbUtil.executeQuery(sql, params);
		try {
			while (rs.next()) {
				NewsDetail newsDetail = new NewsDetail(rs.getInt("id"),
						rs.getString("title"), rs.getString("content"),
						rs.getInt("userId"), rs.getString("author"),
						rs.getInt("typeId"), rs.getString("typeName"),
						rs.getDate("publishTime"), rs.getString("topper"),
						rs.getString("bold"), rs.getString("color"));
				list.add(newsDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeAll();
		}
		return list;
	}

	public int delete(String id) {
		String sql = "delete from news where id=?";
		Object[] params = { id };
		return dbUtil.executeUpdate(sql, params);
	}

	public int batchDelete(String[] ids) {
		String sql = "delete from news where id in(?)";
		Object[] params = { ArrayUtil.array2String(ids, ",") };
		return dbUtil.executeUpdate(sql, params);
	}

	public int update(NewsDetail newsDetail) {
		String sql = "update news set title=?,content=?,userId=?,"
				+ "typeId=?,publishTime=?,topper=?,bold=?,color=? where id=?";
		Object[] params = { newsDetail.getTitle(), newsDetail.getContent(),
				newsDetail.getUserId(), newsDetail.getTypeId(),
				newsDetail.getPublishTime(), newsDetail.getTopper(),
				newsDetail.getBold(), newsDetail.getColor(), newsDetail.getId() };
		return dbUtil.executeUpdate(sql, params);
	}

	// 分页显示
	public List<NewsDetail> findByPage(int pageNo, int pageSize) {
		// String sql = "select * from news limit ?,?";
		String sql = " select n.id,n.title,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime,n.topper,"
				+ " n.bold,n.color"
				+ " from news n,userdetail u,newstype t "
				+ " where n.userId=u.id and n.typeId=t.id order by topper desc,n.publishTime desc limit ?,?";

		/*
		 * + " where n.userId=u.id and n.typeId=t.id " +
		 * " order by topper desc,n.publishTime desc";
		 */

		Object[] params = { (pageNo - 1) * pageSize, pageSize };
		return findBySQL(sql, params);
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

	// 统计表中的记录数
	public int count() {
		String sql = "select count(*) from news";
		return count(sql, null);
	}

	public List<NewsDetail> findByCondition2(NewsDetail newsDetail) {
		StringBuffer buffer = new StringBuffer(
				"select n.id,n.title,n.content,n.userId,n.typeId,"
						+ " u.userName author,t.typeName,n.publishTime,n.topper,"
						+ " n.bold,n.color"
						+ " from news n,userdetail u,newstype t"
						+ " where n.userId=u.id and n.typeId=t.id ");
		List<Object> params = new ArrayList<Object>();
		if (newsDetail != null) {
			if (newsDetail.getTitle() != null
					&& !"".equals(newsDetail.getTitle())) {
				buffer.append(" and title like ?");
				params.add("%" + newsDetail.getTitle() + "%");
			}
		}
		return findBySQL(new String(buffer), params.toArray());

	}
}
