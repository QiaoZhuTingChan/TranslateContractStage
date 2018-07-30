package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.ProductParameter;
import com.jyd.bms.dao.ProductParameterDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("ProductParameterService")
public class ProductParameterService extends BaseService<ProductParameter> {
	@Autowired(required = true)
	private ProductParameterDAO productParameterDAO;

	public int getProductParameterCount(String condition) throws DAOException {
		return productParameterDAO.getProductParameterCount(condition);
	}

	public List<ProductParameter> getPagingProductParameter(int firstResult, int maxResults, String condition)
			throws DAOException {
		return productParameterDAO.getPagingProductParameter(firstResult, maxResults, condition);
	}

	public List<ProductParameter> getAllProductParameter() throws DAOException {
		return productParameterDAO.getAllProductParameter();
	}

	@Override
	public void setDAO() {
		this.baseDAO = productParameterDAO;
	}

}
