package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Product;
import com.jyd.bms.bean.ProductCost;
import com.jyd.bms.dao.ProductCostDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("ProductCostService")
public class ProductCostService extends BaseService<ProductCost> {
	@Autowired(required = true)
	private ProductCostDAO productCostDAO;

	public int getProductCostCount(String condition) throws DAOException {
		return productCostDAO.getProductCostCount(condition);
	}

	public List<ProductCost> getPagingProductCost(int firstResult, int maxResults, String condition)
			throws DAOException {
		return productCostDAO.getPagingProductCost(firstResult, maxResults, condition);
	}

	public List<ProductCost> getAllProductCost() throws DAOException {
		return productCostDAO.getAllProductCost();
	}

	@Override
	public void setDAO() {
		this.baseDAO = productCostDAO;
	}

	public List<ProductCost> getProductCostsByProduct(Product product) throws DAOException {
		return productCostDAO.findProductCostsByProduct(product);
	}

}
