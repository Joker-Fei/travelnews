package com.syf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.syf.entity.NewsType;
import com.syf.util.ArrayUtil;
import com.syf.util.DBUtil;

public class NewsTypeDao {

	DBUtil dbUtil = new DBUtil();

	// 保存新闻类型
	public int save(NewsType newsType) {
		String sql = "insert into newstype(typeName) values (?)";
		Object[] params = { newsType.getTypeName() };
		return dbUtil.executeUpdate(sql, params);
		// executeUpdate的返回值是一个整数，指示受影响的行数（即更新计数）
	}

	// Connection conn = null;
	// PreparedStatement ps = null;
	// ResultSet rs = null;
	//
	// try {
	// conn = dbUtil.getConnection();
	// ps = conn.prepareStatement("select * from newstype");
	// rs = ps.executeQuery();
	//
	// while (rs.next()) {
	// NewsType newsType = new NewsType();
	// newsType.setId(rs.getInt("id"));
	// newsType.setTypeName(rs.getString("typeName"));
	//
	// newsTypeList.add(newsType);// 将对象放入到集合
	//
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// return newsTypeList;
	// } finally {
	// dbUtil.closeAll();
	// }
	// return newsTypeList;
	// }
	public List<NewsType> findAll() {
		List<NewsType> newsTypeList = new ArrayList<NewsType>();

		String sql = "select * from newstype";
		ResultSet rs = dbUtil.executeQuery(sql, null);
		try {
			while (rs.next()) {
				NewsType newsType = new NewsType(rs.getInt("id"),
						rs.getString("typeName"));
				newsTypeList.add(newsType);// 将对象放入到集合

			}
		} catch (SQLException e) {
			e.printStackTrace();
			return newsTypeList;
		} finally {
			dbUtil.closeAll();
		}
		return newsTypeList;
	}

	/**
	 * 批量删除
	 * 
	 * @param ids
	 *            指定的ID集合
	 * @return
	 */
	public int batchDelete(String[] ids) {

		String sql = "delete from newsType where id in(?)";
		Object[] params = { ArrayUtil.array2String(ids, ",") };

		/*
		 * 打印id值的集合，其中含有“,”
		 * 
		 * for (int i = 0; i < params.length; i++) {
		 * System.out.println(params[i]); }
		 */

		return dbUtil.executeUpdate(sql, params);

	}

	/**
	 * 根据Id进行删除
	 * 
	 * @param id
	 * @return
	 */
	public int delete(int id) {
		String sql = "delete from newsType where id=?";
		Object[] params = { id };
		return dbUtil.executeUpdate(sql, params);
	}

}
