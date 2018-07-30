package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.CusCarAssess;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.dao.CusCarAssessDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("CusCarAssessService")
public class CusCarAssessService extends BaseService<CusCarAssess> {
	@Autowired(required = true)
	private CusCarAssessDAO cusCarAssessDAO;

	// 获取所有记录
	public List<CusCarAssess> getAllCusCarAssess() throws DAOException {
		return cusCarAssessDAO.getAllCusCarAssess();
	}

	/**
	 * @category 通过合同拿车辆评价信息
	 * @param contract
	 * @return
	 * @throws DAOException
	 */
	public CusCarAssess getCusCarAssessByContract(CustomerContract contract) throws DAOException {
		return cusCarAssessDAO.getCusCarAssessByContract(contract);
	}
	@Override
	public void setDAO() {
		this.baseDAO = cusCarAssessDAO;
	}

}
