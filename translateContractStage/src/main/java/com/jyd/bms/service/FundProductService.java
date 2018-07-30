package com.jyd.bms.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jyd.bms.bean.FundProduct;
import com.jyd.bms.dao.FundProductDAO;
import com.jyd.bms.tool.exception.DAOException;
/**
 * @category Generated 2018-05-25 14:16:51 by GeneratedTool
 * @author mjy
 */
@Service("FundProductService")
public class FundProductService extends BaseService<FundProduct> {
@Autowired(required = true)
private FundProductDAO fundProductDAO;

 public int getFundProductCount(String condition) throws DAOException {
	return fundProductDAO.getFundProductCount(condition);
 }

 public List<FundProduct> getPagingFundProduct(int firstResult, int maxResults, String condition) throws DAOException {
	return fundProductDAO.getPagingFundProduct(firstResult, maxResults, condition);
 }

 public List<FundProduct> getAllFundProduct() throws DAOException {
	return fundProductDAO.getAllFundProduct();
 }
 @Override

 public void setDAO() {
	this.baseDAO = fundProductDAO;
 }
}
