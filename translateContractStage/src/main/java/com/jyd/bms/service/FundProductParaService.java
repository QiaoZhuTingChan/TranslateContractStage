package com.jyd.bms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.FundProduct;
import com.jyd.bms.bean.FundProductPara;
import com.jyd.bms.dao.FundProductParaDAO;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-05-25 14:19:07 by GeneratedTool
 * @author mjy
 */
@Service("FundProductParaService")
public class FundProductParaService extends BaseService<FundProductPara> {
	@Autowired(required = true)
	private FundProductParaDAO fundProductParaDAO;

	public int getFundProductParaCount(String condition) throws DAOException {
		return fundProductParaDAO.getFundProductParaCount(condition);
	}

	public List<FundProductPara> getPagingFundProductPara(int firstResult, int maxResults, String condition)
			throws DAOException {
		return fundProductParaDAO.getPagingFundProductPara(firstResult, maxResults, condition);
	}

	public List<FundProductPara> getAllFundProductPara() throws DAOException {
		return fundProductParaDAO.getAllFundProductPara();
	}

	@Override

	public void setDAO() {
		this.baseDAO = fundProductParaDAO;
	}

	public List<FundProductPara> getAllFundProductParaByFundProduct(FundProduct fundProduct) throws DAOException {
		return fundProductParaDAO.getAllFundProductParaByFundProduct(fundProduct);
	}
}
