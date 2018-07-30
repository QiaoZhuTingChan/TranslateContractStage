package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.AssetsType;
import com.jyd.bms.bean.PropertyType;
import com.jyd.bms.dao.PropertyTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("PropertyTypeService")
public class PropertyTypeService extends BaseService<AssetsType> {
	@Autowired(required = true)
	private PropertyTypeDAO propertyTypeDAO;

	@Override
	public void setDAO() {
		this.baseDAO = propertyTypeDAO;
	}
	
	public List<PropertyType> getAllPropertyType() throws DAOException{
		return propertyTypeDAO.getAllPropertyType();
	}

}
