package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.GooutHomevisit;
import com.jyd.bms.dao.GooutHomevisitDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("GooutHomevisitService")
public class GooutHomevisitService extends BaseService<GooutHomevisit> {
	@Autowired(required = true)
	private GooutHomevisitDAO gooutHomevisitDAO;

	public List<GooutHomevisit> getGooutHomevisitByContract(CustomerContract contract) throws DAOException {
		return gooutHomevisitDAO.getGooutHomevisitByContract(contract);
	}

	@Override
	public void setDAO() {
		this.baseDAO = gooutHomevisitDAO;
		;
	}

}
