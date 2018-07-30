package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Product;
import com.jyd.bms.bean.ProductRepaymentStage;
import com.jyd.bms.bean.RepaymentStage;
import com.jyd.bms.dao.ProductRepaymentStageDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("ProductRepaymentStageService")
public class ProductRepaymentStageService extends BaseService<ProductRepaymentStage> {
	@Autowired(required = true)
	private ProductRepaymentStageDAO productRepaymentStageDAO;

	public int getProductRepaymentStageCount(String condition) throws DAOException {
		return productRepaymentStageDAO.getProductRepaymentStageCount(condition);
	}

	public List<ProductRepaymentStage> getPagingProductRepaymentStage(int firstResult, int maxResults, String condition)
			throws DAOException {
		return productRepaymentStageDAO.getPagingProductRepaymentStage(firstResult, maxResults, condition);
	}

	public List<ProductRepaymentStage> getAllProductRepaymentStage() throws DAOException {
		return productRepaymentStageDAO.getAllProductRepaymentStage();
	}

	@Override
	public void setDAO() {
		this.baseDAO = productRepaymentStageDAO;
	}

	public List<ProductRepaymentStage> getProductRepaymentStagesByProduct(Product product) throws DAOException {
		return productRepaymentStageDAO.findProductRepaymentStagesByProduct(product);
	}
	
	/**
	 * 根据产品跟期数，查找服务费期数
	 * @param product
	 * @param stage
	 * @return
	 * @throws DAOException 
	 */
	public ProductRepaymentStage getProductRepaymentStagesByProductAndStage(Product product, RepaymentStage stage) throws DAOException {
		return productRepaymentStageDAO.getProductRepaymentStagesByProductAndStage(product, stage);
	}

}
