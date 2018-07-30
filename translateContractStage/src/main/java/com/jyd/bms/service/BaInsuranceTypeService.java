package com.jyd.bms.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jyd.bms.bean.BaInsuranceType;
import com.jyd.bms.dao.BaInsuranceTypeDAO;
import com.jyd.bms.tool.exception.DAOException;
/**
 * @category Generated 2018-03-19 14:56:32 by GeneratedTool
 * @author mjy
 */
@Service("BaInsuranceTypeService")
public class BaInsuranceTypeService extends BaseService<BaInsuranceType> {
@Autowired(required = true)
private BaInsuranceTypeDAO baInsuranceTypeDAO;

 public int getBaInsuranceTypeCount(String condition) throws DAOException {
	return baInsuranceTypeDAO.getBaInsuranceTypeCount(condition);
 }

 public List<BaInsuranceType> getPagingBaInsuranceType(int firstResult, int maxResults, String condition) throws DAOException {
	return baInsuranceTypeDAO.getPagingBaInsuranceType(firstResult, maxResults, condition);
 }

 public List<BaInsuranceType> getAllBaInsuranceType() throws DAOException {
	return baInsuranceTypeDAO.getAllBaInsuranceType();
 }
 @Override

 public void setDAO() {
	this.baseDAO = baInsuranceTypeDAO;
 }
}
