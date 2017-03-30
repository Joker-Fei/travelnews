package com.syf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.syf.entity.RoadType;
import com.syf.util.DBUtil;

public class RoadTypeDao {
	DBUtil dbUtil = new DBUtil();

	// 保存新闻类型
	public int save(RoadType roadType) {
		String sql = "insert into roadtype(typeName) values (?)";
		Object[] params = { roadType.getTypeName() };
		return dbUtil.executeUpdate(sql, params);
		// executeUpdate的返回值是一个整数，指示受影响的行数（即更新计数）
	}

	public List<RoadType> findAll() {
		List<RoadType> roadTypeList = new ArrayList<RoadType>();

		String sql = "select * from roadtype";
		ResultSet rs = dbUtil.executeQuery(sql, null);
		try {
			while (rs.next()) {
				RoadType roadType = new RoadType(rs.getInt("id"),
						rs.getString("typeName"));
				roadTypeList.add(roadType);// 将对象放入到集合

			}
		} catch (SQLException e) {
			e.printStackTrace();
			return roadTypeList;
		} finally {
			dbUtil.closeAll();
		}
		return roadTypeList;
	}

	/**
	 * 根据Id进行删除
	 * 
	 * @param id
	 * @return
	 */
	public int delete(int id) {
		String sql = "delete from roadType where id=?";
		Object[] params = { id };
		return dbUtil.executeUpdate(sql, params);
	}

}
