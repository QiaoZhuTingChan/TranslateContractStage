package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Form;
import com.jyd.bms.dao.FormDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class FormDAOImpl extends HibernateBaseTemplate<Form> implements FormDAO {
	/**
	 * 按查询条件获取记录条数
	 * 
	 * @param condition
	 * @return 记录条数
	 * @throws DAOException
	 */
	public int getFormCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from Form";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from Form where name like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	/**
	 * 按查询条件获取分页记录
	 * 
	 * @param firstResult
	 *            开始行
	 * @param maxResults
	 *            结束行
	 * @param condition
	 *            查询条件
	 * @return 分页数据
	 * @throws DAOException
	 */
	public List<Form> getPagingForm(int firstResult, int maxResults, String condition) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from Form";
		} else {
			hql = "from Form where name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	/**
	 * 获取所有记录
	 * 
	 * @return 所有记录
	 * @throws DAOException
	 */
	public List<Form> getAllForm() throws DAOException {
		String hql = "from Form";
		return super.getQueryResult(hql.toString());
	}

	/**
	 * 按表单名称获取记录
	 * 
	 * @param name
	 *            表单名称
	 * @return 表单
	 * @throws DAOException
	 */
	public List<Form> getFormByName(String name) throws DAOException {
		String hql = "from Form where name = :name";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("name", name);
		List<Form> list = super.getQueryResult(hql, map);
		return list;
	}
}
