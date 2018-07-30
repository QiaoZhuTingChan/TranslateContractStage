package com.jyd.bms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jyd.bms.bean.BaThirdpartCompany;
import com.jyd.bms.dao.BaThirdpartCompanyDAO;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-05-16 15:56:12 by GeneratedTool
 * @author mjy
 */
@Service("BaThirdpartCompanyService")
public class BaThirdpartCompanyService extends BaseService<BaThirdpartCompany> {
	@Autowired(required = true)
	private BaThirdpartCompanyDAO baThirdpartCompanyDAO;

	public int getBaThirdpartCompanyCount(String condition) throws DAOException {
		return baThirdpartCompanyDAO.getBaThirdpartCompanyCount(condition);
	}

	public List<BaThirdpartCompany> getPagingBaThirdpartCompany(int firstResult, int maxResults, String condition)
			throws DAOException {
		return baThirdpartCompanyDAO.getPagingBaThirdpartCompany(firstResult, maxResults, condition);
	}

	public List<BaThirdpartCompany> getAllBaThirdpartCompany() throws DAOException {
		return baThirdpartCompanyDAO.getAllBaThirdpartCompany();
	}

	@Override

	public void setDAO() {
		this.baseDAO = baThirdpartCompanyDAO;
	}
}
