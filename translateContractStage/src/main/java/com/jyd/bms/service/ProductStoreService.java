package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Product;
import com.jyd.bms.bean.ProductStore;
import com.jyd.bms.bean.Store;
import com.jyd.bms.dao.ProductStoreDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("ProductStoreService")
public class ProductStoreService extends BaseService<ProductStore> {
	@Autowired(required = true)
	private ProductStoreDAO productStoreDAO;

	public int getProductStoreCount(String condition) throws DAOException {
		return productStoreDAO.getProductStoreCount(condition);
	}

	public List<ProductStore> getPagingProductStore(int firstResult, int maxResults, String condition)
			throws DAOException {
		return productStoreDAO.getPagingProductStore(firstResult, maxResults, condition);
	}

	public List<ProductStore> getAllProductStore() throws DAOException {
		return productStoreDAO.getAllProductStore();
	}
	
	public List<ProductStore> getProductByStore(Store store) throws DAOException{
		return productStoreDAO.getProductByStore(store);
	}

	@Override
	public void setDAO() {
		this.baseDAO = productStoreDAO;
	}

	public List<ProductStore> getProductStoresByProduct(Product product) throws DAOException {
		return productStoreDAO.findProductStoresByProduct(product);
	}

}
