package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.Store;
import com.jyd.bms.dao.StoreDAO;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.tool.zk.Messagebox;

@Repository
public class StoreDAOImpl extends HibernateBaseTemplate<Store> implements StoreDAO {

	public int getStoreCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from Store";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from Store where shortName like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<Store> getPagingStore(int firstResult, int maxResults, String condition) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from Store";
		} else {
			hql = "from Store where shortName like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<Store> getAllStore() throws DAOException {
		String hql = "";
		hql = "from Store";
		return super.getQueryResult(hql.toString());

	}

	@Override
	public List<Store> getStoresByIdNOs(String idNos) throws DAOException {
		if(idNos.length()<18) {
			return null;
		} else {
			String hql = "select s.id,s.shortName from Store s,Department d ,Employee e where e.department.id=d.id and d.store.id= s.id "
					+ " and e.IDNo in :idNos";
			Map map = new HashMap();
			map.put("idNos", idNos);
			return super.getQueryResult(hql.toString(),map);
		}
		
	}

	@Override
	public Store getStoreByName(String condition) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("condition", condition);
		hql="from Store where shortName=:condition";
		List<Store> lists=super.getQueryResult(hql,map);
		return lists.isEmpty()?null:lists.get(0);
	}


}