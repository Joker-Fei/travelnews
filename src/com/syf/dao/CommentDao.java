package com.syf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.syf.entity.Comment;
import com.syf.util.DBUtil;

public class CommentDao {
	DBUtil dbUtil = new DBUtil();

	public int save(Comment comment) {
		String sql = "insert into comment (userId,newsId,content,writeTime,status) values(?,?,?,?,?)";
		Object[] params = { comment.getUserId(), comment.getNewsId(),
				comment.getContent(), comment.getWriteTime(),
				comment.getStatus() };
		return dbUtil.executeUpdate(sql, params);
	}

	public int updateState(String id) {
		String sql = "update comment set status=(status+1)%2 where id=?";
		Object[] params = { id };
		return dbUtil.executeUpdate(sql, params);
	}

	public int delete(String id) {
		String sql = "delete from comment where id=?";
		Object[] params = { id };
		return dbUtil.executeUpdate(sql, params);
	}

	public List<Comment> findByNewsId(int newsId) {
		String sql = "select * from comment where newsId=?";
		Object[] params = { newsId };
		return findBySQL(sql, params);
	}

	// 查找的通用方法（返回一个集合）
	public List<Comment> findBySQL(String sql, Object[] params) {
		List<Comment> list = new ArrayList<Comment>();
		ResultSet rs = dbUtil.executeQuery(sql, params);
		try {
			while (rs.next()) {
				Comment comment = new Comment(rs.getInt("id"),
						rs.getInt("userId"), rs.getInt("newsId"),
						rs.getString("content"), rs.getDate("writeTime"),
						rs.getInt("status"));
				list.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeAll();
		}
		return list;
	}
}
