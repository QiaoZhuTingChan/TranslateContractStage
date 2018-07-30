package com.jyd.bms.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jyd.bms.bean.CusContractMonthDetailed;
import com.jyd.bms.dao.CusContractMonthDetailedDAO;
import com.jyd.bms.tool.exception.DAOException;
/**
 * @category Generated 2018-05-16 16:29:37 by GeneratedTool
 * @author mjy
 */
@Service("CusContractMonthDetailedService")
public class CusContractMonthDetailedService extends BaseService<CusContractMonthDetailed> {
@Autowired(required = true)
private CusContractMonthDetailedDAO cusContractMonthDetailedDAO;

 public int getCusContractMonthDetailedCount(String condition) throws DAOException {
	return cusContractMonthDetailedDAO.getCusContractMonthDetailedCount(condition);
 }

 public List<CusContractMonthDetailed> getPagingCusContractMonthDetailed(int firstResult, int maxResults, String condition) throws DAOException {
	return cusContractMonthDetailedDAO.getPagingCusContractMonthDetailed(firstResult, maxResults, condition);
 }

 public List<CusContractMonthDetailed> getAllCusContractMonthDetailed() throws DAOException {
	return cusContractMonthDetailedDAO.getAllCusContractMonthDetailed();
 }
 @Override

 public void setDAO() {
	this.baseDAO = cusContractMonthDetailedDAO;
 }
}
