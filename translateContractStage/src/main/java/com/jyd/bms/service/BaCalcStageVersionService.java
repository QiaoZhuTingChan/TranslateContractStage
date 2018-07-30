package com.jyd.bms.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jyd.bms.bean.BaCalcStageVersion;
import com.jyd.bms.dao.BaCalcStageVersionDAO;
import com.jyd.bms.tool.exception.DAOException;
/**
 * @category Generated 2018-06-11 09:33:06 by GeneratedTool
 * @author mjy
 */
@Service("BaCalcStageVersionService")
public class BaCalcStageVersionService extends BaseService<BaCalcStageVersion> {
@Autowired(required = true)
private BaCalcStageVersionDAO baCalcStageVersionDAO;

 public int getBaCalcStageVersionCount(String condition) throws DAOException {
	return baCalcStageVersionDAO.getBaCalcStageVersionCount(condition);
 }

 public List<BaCalcStageVersion> getPagingBaCalcStageVersion(int firstResult, int maxResults, String condition) throws DAOException {
	return baCalcStageVersionDAO.getPagingBaCalcStageVersion(firstResult, maxResults, condition);
 }

 public List<BaCalcStageVersion> getAllBaCalcStageVersion() throws DAOException {
	return baCalcStageVersionDAO.getAllBaCalcStageVersion();
 }
 @Override

 public void setDAO() {
	this.baseDAO = baCalcStageVersionDAO;
 }
}
