package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.bean.CusThirdpartGpsVehicleBaseData;
import com.jyd.bms.dao.CusThirdpartGpsVehicleBaseDataDAO;

/**
 * @category Generated 2018-05-07 14:18:29 by GeneratedTool
 * @author mjy
 */
@Repository
public class CusThirdpartGpsVehicleBaseDataDAOImpl extends HibernateBaseTemplate<CusThirdpartGpsVehicleBaseData>
		implements CusThirdpartGpsVehicleBaseDataDAO {

	@SuppressWarnings("unchecked")
	public int getCusThirdpartGpsVehicleBaseDataCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from CusThirdpartGpsVehicleBaseData";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from CusThirdpartGpsVehicleBaseData where vehicleId like :condition";
			Map<String, Object> map = new HashMap<>();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	@SuppressWarnings("unchecked")
	public List<CusThirdpartGpsVehicleBaseData> getPagingCusThirdpartGpsVehicleBaseData(int firstResult, int maxResults,
			String condition) throws DAOException {
		String hql = "";
		Map<String, Object> map = new HashMap<>();
		if (condition.equals("")) {
			hql = "from CusThirdpartGpsVehicleBaseData";
		} else {
			hql = "from CusThirdpartGpsVehicleBaseData where vehicleId like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	@SuppressWarnings("unchecked")
	public List<CusThirdpartGpsVehicleBaseData> getAllCusThirdpartGpsVehicleBaseData() throws DAOException {
		String hql = "";
		hql = "from CusThirdpartGpsVehicleBaseData";
		return super.getQueryResult(hql.toString());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CusThirdpartGpsVehicleBaseData> getCusThirdpartGpsVehicleBaseDataByPlate(String plate) throws DAOException {
		StringBuilder hql = new StringBuilder("");
		Map<String, Object> map = new HashMap<>();
		
		hql.append(" from CusThirdpartGpsVehicleBaseData where plate like :plate and terminalType like :terminalType order by plate");
		map.put("plate", "%"+plate+"%");
		map.put("terminalType", "%"+"GPRS-部标"+"%");
		List<CusThirdpartGpsVehicleBaseData> list = super.getQueryResult(hql.toString(), map);
		return list.isEmpty() ? null : list;
	}
}
