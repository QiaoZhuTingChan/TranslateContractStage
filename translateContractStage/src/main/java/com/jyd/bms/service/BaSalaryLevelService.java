package com.jyd.bms.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jyd.bms.bean.BaSalaryLevel;
import com.jyd.bms.dao.BaSalaryLevelDAO;
import com.jyd.bms.tool.exception.DAOException;
/**
 * @category Generated 2018-05-09 17:33:57 by GeneratedTool
 * @author mjy
 */
@Service("BaSalaryLevelService")
public class BaSalaryLevelService extends BaseService<BaSalaryLevel> {
@Autowired(required = true)
private BaSalaryLevelDAO baSalaryLevelDAO;

 public int getBaSalaryLevelCount(String condition) throws DAOException {
	return baSalaryLevelDAO.getBaSalaryLevelCount(condition);
 }

 public List<BaSalaryLevel> getPagingBaSalaryLevel(int firstResult, int maxResults, String condition) throws DAOException {
	return baSalaryLevelDAO.getPagingBaSalaryLevel(firstResult, maxResults, condition);
 }

 public List<BaSalaryLevel> getAllBaSalaryLevel() throws DAOException {
	return baSalaryLevelDAO.getAllBaSalaryLevel();
 }
 @Override

 public void setDAO() {
	this.baseDAO = baSalaryLevelDAO;
 }
}
