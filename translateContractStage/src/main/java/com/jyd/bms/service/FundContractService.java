package com.jyd.bms.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.FundContract;
import com.jyd.bms.bean.FundContractStage;
import com.jyd.bms.bean.FundProductPara;
import com.jyd.bms.bean.RepaymentStage;
import com.jyd.bms.bean.User;
import com.jyd.bms.dao.FundContractDAO;
import com.jyd.bms.dao.FundContractStageDAO;
import com.jyd.bms.dao.FundProductParaDAO;
import com.jyd.bms.dao.RepaymentStageDAO;
import com.jyd.bms.tool.exception.CreateException;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.tool.exception.DataNotFoundException;
import com.jyd.bms.tool.zk.Messagebox;
import com.jyd.bms.tool.zk.UserSession;

/**
 * @category Generated 2018-05-25 14:05:15 by GeneratedTool
 * @author mjy
 */
@Service("FundContractService")
public class FundContractService extends BaseService<FundContract> {
	@Autowired(required = true)
	private FundContractDAO fundContractDAO;
	@Autowired(required = true)
	private RepaymentStageDAO repaymentStageDAO;
	@Autowired(required = true)
	private FundProductParaDAO fundProductParaDAO;
	@Autowired(required = true)
	private FundContractStageDAO fundContractStageDAO;

	public int getFundContractCount(String condition) throws DAOException {
		return fundContractDAO.getFundContractCount(condition);
	}

	public List<FundContract> getPagingFundContract(int firstResult, int maxResults, String condition)
			throws DAOException {
		return fundContractDAO.getPagingFundContract(firstResult, maxResults, condition);
	}

	public List<FundContract> getAllFundContract() throws DAOException {
		return fundContractDAO.getAllFundContract();
	}

	public Calendar getCalendar(Calendar cal, int stage) {
		cal.add(cal.MONTH, +stage);
		cal.add(cal.DATE, -1);
		return cal;
	}

	/**
	 * @category 增加资金方合同分期
	 * @param contract
	 * @throws DAOException
	 * @throws CreateException
	 * @throws DataNotFoundException
	 */
	public void addFundContractStage(FundContract contract)
			throws DAOException, CreateException, DataNotFoundException {
		User sessionUser = UserSession.getUser();
		if (sessionUser == null) {
			Messagebox.show("长时间未操作，出于安全考虑，请重新登陆！");
			return;
		}
		Timestamp date = new Timestamp(System.currentTimeMillis());
		String user = sessionUser.getLoginName();
		// 贷款方合同
		CustomerContract oldCustomerContract = contract.getCusContract();
		double amount = contract.getPrincipal();

		// 年化率
		double annualRate = 0;
		List<FundProductPara> paraList = fundProductParaDAO
				.getAllFundProductParaByFundProduct(contract.getFundProduct());
		for (FundProductPara para : paraList) {
			// 年化率
			if (para.getParameter().getId() == 3) {
				annualRate = para.getValue();
			}
		}
		// 总期数
		RepaymentStage repStage = repaymentStageDAO.getById(oldCustomerContract.getStage().getId());
		int stage = repStage.getRepaymentStage();
		// 已付利息期数
		// int returnInterestStage = contract.getReturnInterestStage();
		double capital = 0;
		double interest = 0;
		for (int i = 1; i <= stage; i++) {
			FundContractStage contractStage = new FundContractStage();
			// 等额
			if (contract.getFundProduct().getRepaymentTypeId().getId() == 6) {
				// 每期本金
				capital = ppmt(annualRate / 12, i, stage, amount, 0, 0);
				// 每期利息
				interest = ipmt(annualRate / 12, i, stage, amount, 0, 0);
			}
			// 先息
			if (contract.getFundProduct().getRepaymentTypeId().getId() == 7) {
				// 每期本金
				capital = contract.getBorrowingAmount() - ppmt(annualRate / 12, i, stage, amount, 0, 0);
				// 每期利息 待还投资本金*年化率/12
				interest = capital * annualRate / 12;
			}
			contractStage.setCapital(capital);
			contractStage.setInterest(interest);
			contractStage.setFundContractId(contract);
			contractStage.setStage(i);
			contractStage.setExtraCharges(0);
			Calendar cal = Calendar.getInstance();
			cal.setTime(contract.getRepaymentDate());
			contractStage.setRepaymentDate(getCalendar(cal, i).getTime());
			contractStage.setCreateDate(date);
			contractStage.setUpdateDate(date);
			contractStage.setCreateUser(user);
			contractStage.setUpdateUser(user);
			fundContractStageDAO.add(contractStage);
			// 月还总额
			double repaid = pmt(annualRate / 12, stage,amount, 0, 0);
		}
	}

	/**
	 * @category 利息
	 * @param r
	 *            利率
	 * @param per
	 *            已付期数
	 * @param nper
	 *            总期数
	 * @param pv
	 *            金额
	 * @param fv
	 * @param type
	 * @return
	 */
	double ipmt(double r, int per, int nper, double pv, double fv, int type) {
		double ipmt = fv(r, per - 1, pmt(r, nper, pv, fv, type), pv, type) * r;
		if (type == 1)
			ipmt /= (1 + r);
		return ipmt;
	}

	double fv(double r, int nper, double c, double pv, int type) {
		double fv = -(c * (Math.pow(1 + r, nper) - 1) / r + pv * Math.pow(1 + r, nper));
		return fv;
	}

	/**
	 * @category 月还总额
	 * @param r
	 *            利率
	 * @param nper
	 *            期限
	 * @param pv
	 *            金额
	 * @param fv
	 * @param type
	 * @return
	 */
	double pmt(double r, int nper, double pv, double fv, int type) {
		double pmt = r / (Math.pow(1 + r, nper) - 1) * -(pv * Math.pow(1 + r, nper) + fv);
		return pmt;
	}

	/**
	 * @category 本金
	 * @param r
	 *            利率
	 * @param per
	 *            已付期数
	 * @param nper
	 *            总期数
	 * @param pv
	 *            金额
	 * @param fv
	 * @param type
	 * @return
	 */
	double ppmt(double r, int per, int nper, double pv, double fv, int type) {
		return pmt(r, nper, pv, fv, type) - ipmt(r, per, nper, pv, fv, type);
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 24; i++) {
			System.err.println(i + "期 月还总额" + new FundContractService().pmt(0.17 / 12, 24, 24000, 0, 0) + "  \t本金"
					+ new FundContractService().ppmt(0.17 / 12, i, 24, 24000, 0, 0) + " 利息"
					+ new FundContractService().ipmt(0.17 / 12, i, 24, 24000, 0, 0));

		}

	}

	@Override

	public void setDAO() {
		this.baseDAO = fundContractDAO;
	}
}
