package com.jyd.bms.dao.impl;

import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.dao.CalcStageDao;
import com.jyd.bms.service.CustomerContractService;
import com.jyd.bms.tool.SpringUtil;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.tool.exception.DataNotFoundException;

/**
 * @category 计算分期v1
 * @author mjy
 *
 */
public class CalcStageV2Impl implements CalcStageDao {

	@Override
	public boolean addContractStage(CustomerContract contract) throws DAOException, DataNotFoundException, Exception {
		CustomerContractService contractService = SpringUtil.getBean(CustomerContractService.class);
		return contractService.addContractStageV2(contract);
	}

}
