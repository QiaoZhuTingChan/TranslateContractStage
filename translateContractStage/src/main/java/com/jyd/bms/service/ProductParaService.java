package com.jyd.bms.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Product;
import com.jyd.bms.bean.ProductPara;
import com.jyd.bms.dao.ProductParaDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("ProductParaService")
public class ProductParaService extends BaseService<ProductPara> {
	@Autowired(required = true)
	private ProductParaDAO productParaDAO;

	public int getProductParaCount(String condition) throws DAOException {
		return productParaDAO.getProductParaCount(condition);
	}

	public List<ProductPara> getPagingProductPara(int firstResult, int maxResults, String condition)
			throws DAOException {
		return productParaDAO.getPagingProductPara(firstResult, maxResults, condition);
	}

	public List<ProductPara> getAllProductPara() throws DAOException {
		return productParaDAO.getAllProductPara();
	}

	@Override
	public void setDAO() {
		this.baseDAO = productParaDAO;
	}

	public List<ProductPara> getProductParasByProduct(Product product) throws DAOException{
		return productParaDAO.findProductParasByProduct(product);
	}
	

	/**
	 * 根据产品跟前置参数类型，查找前置值
	 * @param product
	 * @return
	 * @throws DAOException
	 */
	public ProductPara getProductParasByProductAndPrepose(Product product)  throws DAOException{
		return productParaDAO.getProductParasByProductAndPrepose(product);
		
	}

}
