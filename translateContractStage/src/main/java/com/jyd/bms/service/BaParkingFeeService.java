package com.jyd.bms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jyd.bms.bean.BaParkingFee;
import com.jyd.bms.dao.BaParkingFeeDAO;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-03-19 09:43:47 by GeneratedTool
 * @author mjy
 */
@Service("BaParkingFeeService")
public class BaParkingFeeService extends BaseService<BaParkingFee> {
	@Autowired(required = true)
	private BaParkingFeeDAO baParkingFeeDAO;

	public int getBaParkingFeeCount(String condition) throws DAOException {
		return baParkingFeeDAO.getBaParkingFeeCount(condition);
	}

	public List<BaParkingFee> getPagingBaParkingFee(int firstResult, int maxResults, String condition)
			throws DAOException {
		return baParkingFeeDAO.getPagingBaParkingFee(firstResult, maxResults, condition);
	}

	public List<BaParkingFee> getAllBaParkingFee() throws DAOException {
		return baParkingFeeDAO.getAllBaParkingFee();
	}

	@Override

	public void setDAO() {
		this.baseDAO = baParkingFeeDAO;
	}
}
