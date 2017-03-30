package com.syf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.syf.entity.MessageDetail;
import com.syf.util.DBUtil;

public class MessageDetailDao {
	DBUtil dbUtil = new DBUtil();

	public int save(MessageDetail messageDetail) {
		String sql = "insert into message (tag,content,userId,publishTime) values(?,?,?,?)";
		Object[] params = { messageDetail.getTag(), messageDetail.getContent(),
				messageDetail.getUserId(), messageDetail.getPublishTime() };
		return dbUtil.executeUpdate(sql, params);
	}

	public List<MessageDetail> findAll() {
		String sql = " select m.id,m.tag,m.content,m.userId,"
				+ " u.userName author,m.publishTime"
				+ " from message m,userdetail u" + " where m.userId=u.id"
				+ " order by m.publishTime desc";
		return findBySQL(sql, null);
	}

	// 查找的通用方法（返回一个集合）
	public List<MessageDetail> findBySQL(String sql, Object[] params) {
		List<MessageDetail> list = new ArrayList<MessageDetail>();
		ResultSet rs = dbUtil.executeQuery(sql, params);
		try {
			while (rs.next()) {
				MessageDetail messageDetail = new MessageDetail(
						rs.getInt("id"), rs.getString("tag"),
						rs.getString("content"), rs.getInt("userId"),
						rs.getString("author"), rs.getDate("publishTime"));
				list.add(messageDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeAll();
		}
		return list;
	}

	public int delete(String id) {
		String sql = "delete from message where id=?";
		Object[] params = { id };
		return dbUtil.executeUpdate(sql, params);
	}

	// 根据用户Id来查找用户的博客
	public List<MessageDetail> findAllByUserId(String id) {
		String sql = " select b.id,b.tag,b.content,b.userId,"
				+ " u.userName author,b.publishTime"
				+ " from message b,userdetail u"
				+ " where b.userId=u.id and u.id=?"
				+ " order by b.publishTime desc";
		Object[] params = { id };
		return findBySQL(sql, params);
	}

	// 根据结伴游信息id具体显详情
	public MessageDetail findById(String id) {

		String sql = " select n.id,n.tag,n.content,n.userId,"
				+ " u.userName author,n.publishTime"
				+ " from message n,userdetail u"
				+ " where n.userId=u.id and n.id=?"
				+ " order by n.publishTime desc";
		Object[] params = { id };
		List<MessageDetail> messageDetailList = findBySQL(sql, params);
		if (messageDetailList != null && messageDetailList.size() > 0) {
			return messageDetailList.get(0);
		}
		return null;

	}
}
