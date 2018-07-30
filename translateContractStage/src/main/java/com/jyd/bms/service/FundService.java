package com.jyd.bms.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jyd.bms.bean.Fund;
import com.jyd.bms.dao.FundDAO;
import com.jyd.bms.tool.exception.DAOException;
/**
 * @category Generated 2018-05-25 14:04:37 by GeneratedTool
 * @author mjy
 */
@Service("FundService")
public class FundService extends BaseService<Fund> {
@Autowired(required = true)
private FundDAO fundDAO;

 public int getFundCount(String condition) throws DAOException {
	return fundDAO.getFundCount(condition);
 }

 public List<Fund> getPagingFund(int firstResult, int maxResults, String condition) throws DAOException {
	return fundDAO.getPagingFund(firstResult, maxResults, condition);
 }

 public List<Fund> getAllFund() throws DAOException {
	return fundDAO.getAllFund();
 }
 @Override

 public void setDAO() {
	this.baseDAO = fundDAO;
 }
}
