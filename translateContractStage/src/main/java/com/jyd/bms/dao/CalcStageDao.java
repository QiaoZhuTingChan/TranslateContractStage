package com.jyd.bms.dao;

import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.tool.exception.DataNotFoundException;

/**
 * @category 分期计算
 * @author mjy
 *
 */
public interface CalcStageDao {
	public boolean addContractStage(CustomerContract contract) throws DAOException, DataNotFoundException, Exception;
}
