package com.syf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.syf.entity.HotelDetail;
import com.syf.util.DBUtil;

public class HotelDetailDao {
	DBUtil dbUtil = new DBUtil();

	public int save(HotelDetail hotelDetail) {
		String sql = "insert into hotel (name,imgUrl,userId,typeId,price,city,web,address,phone,publishTime) values(?,?,?,?,?,?,?,?,?,?)";
		Object[] params = { hotelDetail.getName(), hotelDetail.getImgUrl(),
				hotelDetail.getUserId(), hotelDetail.getTypeId(),
				hotelDetail.getPrice(), hotelDetail.getCity(),
				hotelDetail.getWeb(), hotelDetail.getAddress(),
				hotelDetail.getPhone(), hotelDetail.getPublishTime() };
		return dbUtil.executeUpdate(sql, params);
	}

	public List<HotelDetail> findAll() {
		// String sql = "select * from news";
		String sql = " select h.id,h.name,h.imgUrl,h.userId,h.typeId,h.price,h.city,h.web,h.address,h.phone,"// 此处的逗号不要忘记加
				+ " u.userName author,t.typeName,h.publishTime"
				+ " from hotel h,userdetail u,hoteltype t"
				+ " where h.userId=u.id and h.typeId=t.id "
				+ " order by h.publishTime desc";
		return findBySQL(sql, null);
	}

	public HotelDetail findById(String id) {
		String sql = " select h.id,h.name,h.imgUrl,h.userId,h.typeId,h.price,h.city,h.web,h.address,h.phone,"
				+ " u.userName author,t.typeName,h.publishTime"
				+ " from hotel h,userdetail u,hoteltype t"
				+ " where h.userId=u.id and h.typeId=t.id and h.id=?"
				+ " order by h.publishTime desc";
		Object[] params = { id };
		List<HotelDetail> hotelDetailList = findBySQL(sql, params);
		if (hotelDetailList != null && hotelDetailList.size() > 0) {
			return hotelDetailList.get(0);
		}
		return null;
	}

	public List<HotelDetail> findByTypeId(int typeId) {
		String sql = " select h.id,h.name,h.imgUrl,h.typeId,h.userId,"
				+ " u.userName author,t.typeName,h.price,h.city,h.web,h.address,h.phone,h.publishTime"
				+ " from hotel h,userdetail u,hoteltype t"
				+ " where h.userId=u.id and h.typeId=t.id  and h.typeId=?"
				+ " order by h.publishTime desc";
		Object[] params = { typeId };
		return findBySQL(sql, params);
	}

	public List<HotelDetail> findByCondition(HotelDetail hotelDetail) {
		StringBuffer buffer = new StringBuffer(
				"select n.id,n.name,n.imgUrl,n.userId,n.typeId,"
						+ " u.userName author,t.typeName,n.price,n.city,n.web,n.address,n.phone,n.publishTime"
						+ " from hotel n,userdetail u,hoteltype t"
						+ " where n.userId=u.id and n.typeId=t.id ");
		List<Object> params = new ArrayList<Object>();
		if (hotelDetail != null) {
			if (hotelDetail.getName() != null
					&& !"".equals(hotelDetail.getName())) {
				buffer.append(" and name like ?");
				params.add("%" + hotelDetail.getName() + "%");
			}
			if (hotelDetail.getCity() != null
					&& !"".equals(hotelDetail.getCity())) {
				buffer.append(" and city like ?");
				params.add("%" + hotelDetail.getCity() + "%");
			}
			if (hotelDetail.getAddress() != null
					&& !"".equals(hotelDetail.getAddress())) {
				buffer.append(" and address like ?");
				params.add("%" + hotelDetail.getAddress() + "%");
			}
			if (hotelDetail.getTypeId() != -1) {
				buffer.append(" and typeId= ?");
				params.add(hotelDetail.getTypeId());
			}
		}
		return findBySQL(new String(buffer), params.toArray());
	}

	// 查找的通用方法（返回一个集合）
	public List<HotelDetail> findBySQL(String sql, Object[] params) {
		List<HotelDetail> list = new ArrayList<HotelDetail>();
		ResultSet rs = dbUtil.executeQuery(sql, params);
		try {
			while (rs.next()) {
				HotelDetail hotelDetail = new HotelDetail(rs.getInt("id"),
						rs.getString("name"), rs.getString("imgUrl"),
						rs.getInt("typeId"), rs.getString("typeName"),
						rs.getInt("userId"), rs.getString("author"),
						rs.getString("price"), rs.getString("city"),
						rs.getString("web"), rs.getString("address"),
						rs.getString("phone"), rs.getDate("publishTime"));
				list.add(hotelDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeAll();
		}
		return list;
	}

	public int delete(String id) {
		String sql = "delete from hotel where id=?";
		Object[] params = { id };
		return dbUtil.executeUpdate(sql, params);
	}

	// public int batchDelete(String[] ids) {
	// String sql = "delete from news where id in(?)";
	// Object[] params = { ArrayUtil.array2String(ids, ",") };
	// return dbUtil.executeUpdate(sql, params);
	// }
	// 酒店信息更新
	// name,imgUrl,userId,typeId,price,city,address,phone,publishTime
	// public int update(HotelDetail hotelDetail) {
	// String sql = "update hotel set name=?,imgUrl=?,userId=?,"
	// + "typeId=?,price=?city=?,address=?phone=?publishTime=? where id=?";
	// Object[] params = { hotelDetail.getName(), hotelDetail.getImgUrl(),
	// hotelDetail.getUserId(), hotelDetail.getTypeId(),
	// hotelDetail.getPrice(), hotelDetail.getCity(),
	// hotelDetail.getAddress(), hotelDetail.getPhone(),
	// hotelDetail.getPublishTime() };
	// return dbUtil.executeUpdate(sql, params);
	// }
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
	public List<HotelDetail> findByPage(int pageNo, int pageSize) {
		String sql = " select h.id,h.name,h.imgUrl,h.userId,h.typeId,h.price,h.city,h.web,h.address,h.phone,"// 此处的逗号不要忘记加
				+ " u.userName author,t.typeName,h.publishTime"
				+ " from hotel h,userdetail u,hoteltype t"
				+ " where h.userId=u.id and h.typeId=t.id "
				+ " order by h.publishTime desc limit ?,?";
		Object[] params = { (pageNo - 1) * pageSize, pageSize };
		return findBySQL(sql, params);
	}

	// 统计表中的记录数
	public int count() {
		String sql = "select count(*) from hotel";
		return count(sql, null);
	}
}
