package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Product;
import com.jyd.bms.bean.ProductUploadfile;
import com.jyd.bms.dao.ProductUploadfileDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("ProductUploadfileService")
public class ProductUploadfileService extends BaseService<ProductUploadfile> {
	@Autowired(required = true)
	private ProductUploadfileDAO productUploadfileDAO;

	public int getProductUploadfileCount(String condition) throws DAOException {
		return productUploadfileDAO.getProductUploadfileCount(condition);
	}

	public List<ProductUploadfile> getPagingProductUploadfile(int firstResult, int maxResults, String condition)
			throws DAOException {
		return productUploadfileDAO.getPagingProductUploadfile(firstResult, maxResults, condition);
	}

	public List<ProductUploadfile> getAllProductUploadfile() throws DAOException {
		return productUploadfileDAO.getAllProductUploadfile();
	}

	@Override
	public void setDAO() {
		this.baseDAO = productUploadfileDAO;
	}

	public List<ProductUploadfile> getProductUploadfilesByProduct(Product product) throws DAOException {
		return productUploadfileDAO.findProductUploadfilesByProduct(product);
	}

}
