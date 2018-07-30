package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.ProductType;
import com.jyd.bms.dao.ProductTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("ProductTypeService")
public class ProductTypeService extends BaseService<ProductType> {
	@Autowired(required = true)
	private ProductTypeDAO productTypeDAO;

	public int getProductTypeCount(String condition) throws DAOException {
		return productTypeDAO.getProductTypeCount(condition);
	}

	public List<ProductType> getPagingProductType(int firstResult, int maxResults, String condition)
			throws DAOException {
		return productTypeDAO.getPagingProductType(firstResult, maxResults, condition);
	}

	public List<ProductType> getAllProductType() throws DAOException {
		return productTypeDAO.getAllProductType();
	}

	@Override
	public void setDAO() {
		this.baseDAO = productTypeDAO;
	}

}
