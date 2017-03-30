package com.syf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.syf.entity.RoadDetail;
import com.syf.util.ArrayUtil;
import com.syf.util.DBUtil;

public class RoadDetailDao {
	DBUtil dbUtil = new DBUtil();

	public int save(RoadDetail roadDetail) {
		String sql = "insert into road (roadName,typeId,userId,price,goRoad,backRoad,days,agency,phone,traffic,mainInfo,tag,publishTime) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = { roadDetail.getRoadName(), roadDetail.getTypeId(),
				roadDetail.getUserId(), roadDetail.getPrice(),
				roadDetail.getGoRoad(), roadDetail.getBackRoad(),
				roadDetail.getDays(), roadDetail.getAgency(),
				roadDetail.getPhone(), roadDetail.getTraffic(),
				roadDetail.getMainInfo(), roadDetail.getTag(),
				roadDetail.getPublishTime() };
		return dbUtil.executeUpdate(sql, params);
	}

	public List<RoadDetail> findAll() {

		String sql = " select r.id,r.roadName,r.userId,r.price,r.typeId,"
				+ " u.userName author,t.typeName,r.goRoad,r.backRoad,r.days,r.agency,r.phone,r.traffic,r.mainInfo,r.tag,r.publishTime"
				+ " from road r,userdetail u,roadtype t"
				+ " where r.userId=u.id and r.typeId=t.id "
				+ " order by r.publishTime desc";
		return findBySQL(sql, null);
	}

	public RoadDetail findById(String id) {
		String sql = " select r.id,r.roadName,r.userId,r.price,r.typeId,"
				+ " u.userName author,t.typeName,r.goRoad,r.backRoad,r.days,r.agency,r.phone,r.traffic,r.mainInfo,r.tag,r.publishTime"
				+ " from road r,userdetail u,roadtype t"
				+ " where r.userId=u.id and r.typeId=t.id and r.id=?"
				+ " order by r.publishTime desc";
		Object[] params = { id };
		List<RoadDetail> roadDetailList = findBySQL(sql, params);
		if (roadDetailList != null && roadDetailList.size() > 0) {
			return roadDetailList.get(0);
		}
		return null;
	}

	public List<RoadDetail> findByTypeId(int typeId) {
		String sql = " select r.id,r.roadName,r.userId,r.price,r.typeId,"
				+ " u.userName author,t.typeName,r.goRoad,r.backRoad,r.days,r.agency,r.phone,r.traffic,r.mainInfo,r.tag,r.publishTime"
				+ " from road r,userdetail u,roadtype t"
				+ " where r.userId=u.id and r.typeId=t.id  and r.typeId=?"
				+ " order by topper desc,n.publishTime desc";
		Object[] params = { typeId };
		return findBySQL(sql, params);
	}

	// 前端查询
	public List<RoadDetail> findByCondition(RoadDetail roadDetail) {
		StringBuffer buffer = new StringBuffer(
				"select r.id,r.roadName,r.typeId,r.userId,r.price,r.goRoad,r.backRoad,r.days,r.agency,r.phone,r.traffic,r.mainInfo,r.tag,"
						+ " t.typeName,u.userName author,r.publishTime"
						+ " from road r,userdetail u,roadtype t"
						+ " where r.userId=u.id and r.typeId=t.id ");
		List<Object> params = new ArrayList<Object>();
		if (roadDetail != null) {
			if (roadDetail.getRoadName() != null
					&& !"".equals(roadDetail.getRoadName())) {
				buffer.append(" and roadName like ?");
				params.add("%" + roadDetail.getRoadName() + "%");
			}
			if (roadDetail.getTypeId() != -1) {
				buffer.append(" and typeId= ?");
				params.add(roadDetail.getTypeId());
			}
			if (roadDetail.getGoRoad() != null
					&& !"".equals(roadDetail.getGoRoad())) {
				buffer.append(" and goRoad like ?");
				params.add("%" + roadDetail.getGoRoad() + "%");
			}
			if (roadDetail.getBackRoad() != null
					&& !"".equals(roadDetail.getBackRoad())) {
				buffer.append(" and backRoad like ?");
				params.add("%" + roadDetail.getBackRoad() + "%");
			}
			// if (roadDetail.getAgency() != null
			// && !"".equals(roadDetail.getAgency())) {
			// buffer.append(" and agency like ?");
			// params.add("%" + roadDetail.getAgency() + "%");
			// }
			if (roadDetail.getTraffic() != null
					&& !"".equals(roadDetail.getTraffic())) {
				buffer.append(" and traffic like ?");
				params.add("%" + roadDetail.getTraffic() + "%");
			}
			if (roadDetail.getTag() != null && !"".equals(roadDetail.getTag())) {
				buffer.append(" and tag like ?");
				params.add("%" + roadDetail.getTag() + "%");
			}

		}
		return findBySQL(new String(buffer), params.toArray());
	}

	// 查找的通用方法（返回一个集合）
	public List<RoadDetail> findBySQL(String sql, Object[] params) {
		List<RoadDetail> list = new ArrayList<RoadDetail>();
		ResultSet rs = dbUtil.executeQuery(sql, params);
		try {
			while (rs.next()) {
				RoadDetail roadDetail = new RoadDetail(rs.getInt("id"),
						rs.getString("roadName"), rs.getInt("typeId"),
						rs.getInt("userId"), rs.getString("author"),
						rs.getString("typeName"), rs.getString("price"),
						rs.getString("goRoad"), rs.getString("backRoad"),
						rs.getString("days"), rs.getString("agency"),
						rs.getString("phone"), rs.getString("traffic"),
						rs.getString("mainInfo"), rs.getString("tag"),
						rs.getDate("publishTime"));
				list.add(roadDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeAll();
		}
		return list;
	}

	public int delete(String id) {
		String sql = "delete from road where id=?";
		Object[] params = { id };
		return dbUtil.executeUpdate(sql, params);
	}

	public int batchDelete(String[] ids) {
		String sql = "delete from road where id in(?)";
		Object[] params = { ArrayUtil.array2String(ids, ",") };
		return dbUtil.executeUpdate(sql, params);
	}

	public int update(RoadDetail roadDetail) {
		String sql = "update road set roadName=?,typeId=?,userId=?,price=?,goRoad=?,backRoad=?,days=?,agency=?,phone=?,traffic=?,mainInfo=?,tag=?,publishTime=? where id=?";
		Object[] params = { roadDetail.getRoadName(), roadDetail.getTypeId(),
				roadDetail.getUserId(), roadDetail.getPrice(),
				roadDetail.getGoRoad(), roadDetail.getBackRoad(),
				roadDetail.getDays(), roadDetail.getAgency(),
				roadDetail.getPhone(), roadDetail.getTraffic(),
				roadDetail.getMainInfo(), roadDetail.getTag(),
				roadDetail.getPublishTime(), roadDetail.getId() };// 注意：此处后边一定不要忘了加上
																	// roadDetail.getId()
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
	public List<RoadDetail> findByPage(int pageNo, int pageSize) {
		String sql = " select r.id,r.roadName,r.userId,r.price,r.typeId,"
				+ " u.userName author,t.typeName,r.goRoad,r.backRoad,r.days,r.agency,r.phone,r.traffic,r.mainInfo,r.tag,r.publishTime"
				+ " from road r,userdetail u,roadtype t"
				+ " where r.userId=u.id and r.typeId=t.id "
				+ " order by r.publishTime desc limit ?,?";
		Object[] params = { (pageNo - 1) * pageSize, pageSize };
		return findBySQL(sql, params);
	}

	// 统计表中的记录数
	public int count() {
		String sql = "select count(*) from road";
		return count(sql, null);
	}
}
