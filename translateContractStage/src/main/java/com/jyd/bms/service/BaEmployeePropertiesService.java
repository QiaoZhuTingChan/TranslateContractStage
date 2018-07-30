package com.jyd.bms.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jyd.bms.bean.BaEmployeeProperties;
import com.jyd.bms.dao.BaEmployeePropertiesDAO;
import com.jyd.bms.tool.exception.DAOException;
/**
 * @category Generated 2018-05-09 17:15:16 by GeneratedTool
 * @author mjy
 */
@Service("BaEmployeePropertiesService")
public class BaEmployeePropertiesService extends BaseService<BaEmployeeProperties> {
	@Autowired(required = true)
	private BaEmployeePropertiesDAO baEmployeePropertiesDAO;
	
	 public int getBaEmployeePropertiesCount(String condition) throws DAOException {
		return baEmployeePropertiesDAO.getBaEmployeePropertiesCount(condition);
	 }
	
	 public List<BaEmployeeProperties> getPagingBaEmployeeProperties(int firstResult, int maxResults, String condition) throws DAOException {
		return baEmployeePropertiesDAO.getPagingBaEmployeeProperties(firstResult, maxResults, condition);
	 }
	
	 public List<BaEmployeeProperties> getAllBaEmployeeProperties() throws DAOException {
		return baEmployeePropertiesDAO.getAllBaEmployeeProperties();
	 }
	 @Override
	
	 public void setDAO() {
		this.baseDAO = baEmployeePropertiesDAO;
	 }
}
