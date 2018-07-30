package com.jyd.bms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.PropertyType;
import com.jyd.bms.dao.PropertyTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class PropertyTypeDAOImpl extends HibernateBaseTemplate<PropertyType> implements PropertyTypeDAO {

	@Override
	public List<PropertyType> getAllPropertyType() throws DAOException {
		String hql = "";
		hql = "from PropertyType";
		return super.getQueryResult(hql.toString());
	}
}
