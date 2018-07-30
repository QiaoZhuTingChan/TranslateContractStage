package com.jyd.bms.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jyd.bms.bean.BaContractManageType;
import com.jyd.bms.dao.BaContractManageTypeDAO;
import com.jyd.bms.tool.exception.DAOException;
/**
 * @category Generated 2018-03-19 09:50:17 by GeneratedTool
 * @author mjy
 */
@Service("BaContractManageTypeService")
public class BaContractManageTypeService extends BaseService<BaContractManageType> {
@Autowired(required = true)
private BaContractManageTypeDAO baContractManageTypeDAO;

 public int getBaContractManageTypeCount(String condition) throws DAOException {
	return baContractManageTypeDAO.getBaContractManageTypeCount(condition);
 }

 public List<BaContractManageType> getPagingBaContractManageType(int firstResult, int maxResults, String condition) throws DAOException {
	return baContractManageTypeDAO.getPagingBaContractManageType(firstResult, maxResults, condition);
 }

 public List<BaContractManageType> getAllBaContractManageType() throws DAOException {
	return baContractManageTypeDAO.getAllBaContractManageType();
 }
 @Override

 public void setDAO() {
	this.baseDAO = baContractManageTypeDAO;
 }
}
