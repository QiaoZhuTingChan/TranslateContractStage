package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Product;
import com.jyd.bms.bean.ProductStore;
import com.jyd.bms.bean.Store;
import com.jyd.bms.dao.ProductDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("ProductService")
public class ProductService extends BaseService<Product> {
	@Autowired(required = true)
	private ProductDAO productDAO;

	public int getProductCount(String condition) throws DAOException {
		return productDAO.getProductCount(condition);
	}

	public List<Product> getPagingProduct(int firstResult, int maxResults, String condition) throws DAOException {
		return productDAO.getPagingProduct(firstResult, maxResults, condition);
	}

	public List<Product> getAllProduct() throws DAOException {
		return productDAO.getAllProduct();
	}
	@Override
	public void setDAO() {
		this.baseDAO = productDAO;
	}
	
	public Product getProductByName(String condition) throws DAOException{
		return productDAO.getProductByName(condition);
	}
}
