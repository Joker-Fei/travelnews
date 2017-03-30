package com.syf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.syf.entity.Letter;
import com.syf.util.DBUtil;

public class LetterDao {
	DBUtil dbUtil = new DBUtil();

	public int save(Letter letter) {
		String sql = "insert into letter (userId,messageId,content,writeTime) values(?,?,?,?)";
		Object[] params = { letter.getUserId(), letter.getMessageId(),
				letter.getContent(), letter.getWriteTime() };
		return dbUtil.executeUpdate(sql, params);
	}

	public int delete(String id) {
		String sql = "delete from letter where id=?";
		Object[] params = { id };
		return dbUtil.executeUpdate(sql, params);
	}

	public List<Letter> findByMessageId(int messageId) {
		String sql = "select * from letter where messageId=?";
		Object[] params = { messageId };
		return findBySQL(sql, params);
	}

	// 查找的通用方法（返回一个集合）
	public List<Letter> findBySQL(String sql, Object[] params) {
		List<Letter> list = new ArrayList<Letter>();
		ResultSet rs = dbUtil.executeQuery(sql, params);
		try {
			while (rs.next()) {
				Letter letter = new Letter(rs.getInt("id"),
						rs.getInt("userId"), rs.getInt("messageId"),
						rs.getString("content"), rs.getDate("writeTime"));
				list.add(letter);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeAll();
		}
		return list;
	}

}
