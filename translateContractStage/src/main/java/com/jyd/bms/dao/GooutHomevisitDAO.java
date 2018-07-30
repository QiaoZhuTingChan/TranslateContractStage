package com.jyd.bms.dao;


import java.util.List;

import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.GooutHomevisit;
import com.jyd.bms.tool.exception.DAOException;

public interface GooutHomevisitDAO extends HibernateBase<GooutHomevisit> {

	public List<GooutHomevisit> getGooutHomevisitByContract(CustomerContract contract) throws DAOException;
	/**
	 * 保存家访数据
	 */
	public void seva();

}
