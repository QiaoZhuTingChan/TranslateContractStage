package com.jyd.bms.dao;
import java.util.List;
import com.jyd.bms.bean.BaCalcStageVersion;
import com.jyd.bms.tool.exception.DAOException;
/**
 * @category Generated 2018-06-11 09:33:06 by GeneratedTool
 * @author mjy
 */
public interface BaCalcStageVersionDAO extends HibernateBase<BaCalcStageVersion> {
	public int getBaCalcStageVersionCount(String condition) throws DAOException;
	public List<BaCalcStageVersion> getPagingBaCalcStageVersion(int firstResult, int maxResults, String condition)throws DAOException;
	public List<BaCalcStageVersion> getAllBaCalcStageVersion() throws DAOException;
}