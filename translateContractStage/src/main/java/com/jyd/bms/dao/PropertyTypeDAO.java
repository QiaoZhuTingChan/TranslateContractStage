package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.PropertyType;
import com.jyd.bms.tool.exception.DAOException;

public interface PropertyTypeDAO extends HibernateBase<PropertyType> {
	public List<PropertyType> getAllPropertyType() throws DAOException;
}
