package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.CustomerInfo;
import com.jyd.bms.bean.VehicleInfo;
import com.jyd.bms.dao.VehicleInfoDAO;
import com.jyd.bms.tool.exception.DAOException;
@Repository
public class VehicleInfoDAOImpl extends HibernateBaseTemplate<VehicleInfo> implements VehicleInfoDAO {

	public int getVehicleInfoCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from VehicleInfo";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from VehicleInfo,CustomerInfo where VehicleInfo.customerId=CustomerInfo.id and CustomerInfo.name like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<VehicleInfo> getPagingVehicleInfo(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from VehicleInfo";
		} else {
			hql = "from VehicleInfo,CustomerInfo where VehicleInfo.customerId=CustomerInfo.id and CustomerInfo.name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}
	
	public List<VehicleInfo> getAllVehicleInfo() throws DAOException {
		String hql = "";
			hql = "from VehicleInfo";
		return super.getQueryResult(hql.toString());
	
	}

	@Override
	public VehicleInfo getVehicleInfoByPlate(String plate) throws DAOException {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("plate",plate);
		String hql = "";
		hql = "from VehicleInfo where plate=:plate";
		List<VehicleInfo> list=super.getQueryResult(hql.toString(),map);
		if(!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<VehicleInfo> getVehicleInfoByCustomerInfo(CustomerInfo customer) throws DAOException {
		String hql = "";
		hql = "from VehicleInfo where customer = :customer";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("customer", customer);
		return super.getQueryResult(hql, map);
	}

}
