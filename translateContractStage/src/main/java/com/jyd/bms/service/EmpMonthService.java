package com.jyd.bms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.EmpMonth;
import com.jyd.bms.dao.EmpMonthDAO;

@Service("EmpMonthService")
public class EmpMonthService extends BaseService<EmpMonth>{
		
	@Autowired(required=true)
	private EmpMonthDAO empMonthDAO;

	@Override
	public void setDAO() {
		this.baseDAO = empMonthDAO;
	}

}
