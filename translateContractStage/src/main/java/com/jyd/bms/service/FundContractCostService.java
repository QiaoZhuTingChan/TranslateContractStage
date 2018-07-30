package com.jyd.bms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.FundContract;
import com.jyd.bms.bean.FundContractCost;
import com.jyd.bms.dao.FundContractCostDAO;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-05-25 14:19:55 by GeneratedTool
 * @author mjy
 */
@Service("FundContractCostService")
public class FundContractCostService extends BaseService<FundContractCost> {
	@Autowired(required = true)
	private FundContractCostDAO fundContractCostDAO;

	public int getFundContractCostCount(String condition) throws DAOException {
		return fundContractCostDAO.getFundContractCostCount(condition);
	}

	public List<FundContractCost> getPagingFundContractCost(int firstResult, int maxResults, String condition)
			throws DAOException {
		return fundContractCostDAO.getPagingFundContractCost(firstResult, maxResults, condition);
	}

	public List<FundContractCost> getAllFundContractCost() throws DAOException {
		return fundContractCostDAO.getAllFundContractCost();
	}

	/**
	 * 根据资金方合同查费用
	 * 
	 * @param fundProduct
	 * @return
	 * @throws DAOException
	 */
	public List<FundContractCost> getAllFundContractCostByfundContract(FundContract fundContract) throws DAOException {
		return fundContractCostDAO.getAllFundContractCostByfundContract(fundContract);
	}

	@Override
	public void setDAO() {
		this.baseDAO = fundContractCostDAO;
	}
}
