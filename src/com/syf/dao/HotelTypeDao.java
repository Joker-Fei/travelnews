package com.syf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.syf.entity.HotelType;
import com.syf.util.DBUtil;

public class HotelTypeDao {
	DBUtil dbUtil = new DBUtil();

	// 保存新闻类型
	public int save(HotelType hotelType) {
		String sql = "insert into Hoteltype(typeName) values (?)";
		Object[] params = { hotelType.getTypeName() };
		return dbUtil.executeUpdate(sql, params);
		// executeUpdate的返回值是一个整数，指示受影响的行数（即更新计数）
	}

	public List<HotelType> findAll() {
		List<HotelType> hotelTypeList = new ArrayList<HotelType>();

		String sql = "select * from hoteltype";
		ResultSet rs = dbUtil.executeQuery(sql, null);
		try {
			while (rs.next()) {
				HotelType hotelType = new HotelType(rs.getInt("id"),
						rs.getString("typeName"));
				hotelTypeList.add(hotelType);// 将对象放入到集合

			}
		} catch (SQLException e) {
			e.printStackTrace();
			return hotelTypeList;
		} finally {
			dbUtil.closeAll();
		}
		return hotelTypeList;
	}

	/**
	 * 根据Id进行删除
	 * 
	 * @param id
	 * @return
	 */
	public int delete(int id) {
		String sql = "delete from HotelType where id=?";
		Object[] params = { id };
		return dbUtil.executeUpdate(sql, params);
	}

}
