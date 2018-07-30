package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.CusCarAssess;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.tool.exception.DAOException;

public interface CusCarAssessDAO extends HibernateBase<CusCarAssess> {

	/**
	 * 查询所有评估车辆
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<CusCarAssess> getAllCusCarAssess() throws DAOException;

	
	public CusCarAssess getCusCarAssessByContract(CustomerContract contract) throws DAOException;
}
