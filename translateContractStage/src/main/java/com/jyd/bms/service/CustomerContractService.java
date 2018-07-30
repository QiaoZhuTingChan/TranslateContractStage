package com.jyd.bms.service;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Doublebox;

import com.jyd.bms.bean.ContractGpsLateFee;
import com.jyd.bms.bean.ContractLateFee;
import com.jyd.bms.bean.ContractManageType;
import com.jyd.bms.bean.ContractPara;
import com.jyd.bms.bean.ContractRepayment;
import com.jyd.bms.bean.ContractStage;
import com.jyd.bms.bean.ContractStageFee;
import com.jyd.bms.bean.CostType;
import com.jyd.bms.bean.CusContractCost;
import com.jyd.bms.bean.CusContractRenewal;
import com.jyd.bms.bean.CusContractRepaymentOtherFee;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.GpsCostType;
import com.jyd.bms.bean.ParkingFee;
import com.jyd.bms.bean.Product;
import com.jyd.bms.bean.ProductRepaymentStage;
import com.jyd.bms.bean.ProductType;
import com.jyd.bms.bean.RepaymentStage;
import com.jyd.bms.bean.Store;
import com.jyd.bms.bean.User;
import com.jyd.bms.dao.ContractGpsLateFeeDAO;
import com.jyd.bms.dao.ContractLateFeeDAO;
import com.jyd.bms.dao.ContractParaDAO;
import com.jyd.bms.dao.ContractRepaymentDAO;
import com.jyd.bms.dao.ContractStageDAO;
import com.jyd.bms.dao.ContractStageFeeDAO;
import com.jyd.bms.dao.CostTypeDAO;
import com.jyd.bms.dao.CusContractCostDAO;
import com.jyd.bms.dao.CusContractRenewalDAO;
import com.jyd.bms.dao.CusContractRepaymentOtherFeeDAO;
import com.jyd.bms.dao.CustomerContractDAO;
import com.jyd.bms.dao.ProductDAO;
import com.jyd.bms.dao.ProductParameterDAO;
import com.jyd.bms.dao.ProductRepaymentStageDAO;
import com.jyd.bms.dao.RepaymentTypeDAO;
import com.jyd.bms.tool.exception.CreateException;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.tool.exception.DataNotFoundException;
import com.jyd.bms.tool.exception.UpdateException;
import com.jyd.bms.tool.zk.UserSession;

@Service("CustomerContractService")
public class CustomerContractService extends BaseService<CustomerContract> {
	@Autowired(required = true)
	private CustomerContractDAO customerContractDAO;
	@Autowired(required = true)
	private ContractParaDAO contractParaDAO;
	@Autowired(required = true)
	private ProductParameterDAO productParameterDAO;
	@Autowired(required = true)
	private ContractStageDAO contractStageDAO;
	@Autowired(required = true)
	private ContractLateFeeDAO contractLateFeeDAO;
	@Autowired(required = true)
	private ContractGpsLateFeeDAO contractGpsLateFeeDAO;
	@Autowired(required = true)
	private ContractStageFeeDAO contractStageFeeDAO;
	@Autowired(required = true)
	private CostTypeDAO costTypeDAO;
	@Autowired(required = true)
	private ContractRepaymentDAO contractRepaymentDAO;
	@Autowired(required = true)
	private CusContractCostDAO cusContractCostDAO;
	@Autowired(required = true)
	private ProductDAO productDAO;
	@Autowired(required = true)
	private RepaymentTypeDAO repaymentTypeDAO;
	@Autowired(required = true)
	private ProductRepaymentStageDAO productRepaymentStageDAO;
	@Autowired(required = true)
	private CusContractRepaymentOtherFeeDAO cusContractRepaymentOtherFeeDAO;

	@Autowired
	private CusContractRenewalDAO cusContractRenewalDAO;

	public CustomerContract getID(String id) throws DAOException {
		return customerContractDAO.getContractByIdNum(id);
	}

	public int getCustomerContractCount(String condition) throws DAOException {
		return customerContractDAO.getCustomerContractCount(condition);
	}

	public int getCustomerContractByParaCount(String condition) throws DAOException {
		return customerContractDAO.getCustomerContractByParaCount(condition);
	}

	public List<CustomerContract> getCustomerContractCountByPerson(String condition, Employee responsiblePerson)
			throws DAOException {
		return customerContractDAO.getCustomerContractCountByPerson(condition, responsiblePerson);
	}

	public List<CustomerContract> getPagingCustomerContract(int firstResult, int maxResults, String condition)
			throws DAOException {
		return customerContractDAO.getPagingCustomerContract(firstResult, maxResults, condition);
	}

	public int getStoreCustomerContractCount(String condition, Store store) throws DAOException {
		return customerContractDAO.getStoreCustomerContractCount(condition, store);
	}

	public List<CustomerContract> getPagingStoreCustomerContract(int firstResult, int maxResults, String condition,
			Store store) throws DAOException {
		return customerContractDAO.getPagingStoreCustomerContract(firstResult, maxResults, condition, store);
	}

	public List<CustomerContract> getAllCustomerContract() throws DAOException {
		return customerContractDAO.getAllCustomerContract();
	}

	public String getCustomerContractNum(String contractNum) throws DAOException {
		return customerContractDAO.getCustomerContractNum(contractNum);
	}

	/**
	 * 获得额外费用
	 * 
	 * @param contract
	 *            合同
	 * @return 额外费用
	 * @throws DAOException
	 */
	public double getExtraFee(CustomerContract contract) throws DAOException {
		// DecimalFormat df = new DecimalFormat("#.00");
		// Set<CusContractCost> costs = contract.getCusContractCosts();
		List<CusContractCost> costs = cusContractCostDAO.getCusContractCostByContract(contract);
		double extraFee = 0;
		for (CusContractCost cost : costs) {
			extraFee += cost.getValue();
		}
		return extraFee;
	}

	/**
	 * 获得日期
	 * 
	 * @param cal
	 *            日历
	 * @param stage
	 *            分期期数
	 * @return 日历
	 */
	public Calendar getCalendar(Calendar cal, int stage) {
		cal.add(cal.MONTH, +stage);
		cal.add(cal.DATE, -1);
		return cal;
	}

	public int daysBetween(Date smdate, Date bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	// public double getGpsCostByStageAndYear(CustomerContract contract,int stage)

	/**
	 * 获得分期还款
	 * 
	 * @param contract
	 *            合同
	 * @return 日期对应的还款金额
	 */
	public Map<String, Double> getRepaymentByStage(CustomerContract contract)
			throws DAOException, DataNotFoundException {
		Map<String, Double> map = new HashMap<String, Double>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(contract.getStartDate());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Set<ContractPara> paras = contract.getContractParas();

		for (ContractPara para : paras) {
			if (para.getPara().getId() == 1) {
				double preValue = contractParaDAO.findValueByContractAndPara(contract, productParameterDAO.getById(1));
				int stage = contract.getStage().getRepaymentStage();
				double principal = contract.getAmount() + contract.getAmount() * (preValue / 100) * stage;
				double perPrincipal = principal / stage;
				double interest = contractParaDAO.findValueByContractAndPara(contract, productParameterDAO.getById(2));
				double interestAmount = contract.getAmount() * interest / 100;
				map.put(sdf.format(cal.getTime()), interestAmount + getExtraFee(contract));
				for (int i = 1; i < stage; i++) {
					cal.setTime(contract.getStartDate());
					map.put(sdf.format(getCalendar(cal, i).getTime()), perPrincipal + interestAmount);
				}
				cal.setTime(contract.getStartDate());
				map.put(sdf.format(getCalendar(cal, stage).getTime()), perPrincipal);
				return map;
			}
		}
		int stage = contract.getStage().getRepaymentStage();
		double interest = contractParaDAO.findValueByContractAndPara(contract, productParameterDAO.getById(2));
		double interestAmount = contract.getAmount() * interest / 100;
		map.put(sdf.format(cal.getTime()), interestAmount + getExtraFee(contract));
		for (int i = 1; i < stage; i++) {
			cal.setTime(contract.getStartDate());
			map.put(sdf.format(getCalendar(cal, i).getTime()), interestAmount);
		}
		cal.setTime(contract.getStartDate());
		map.put(sdf.format(getCalendar(cal, stage).getTime()), contract.getAmount());
		return map;
	}

	public void addStageByCostType(CustomerContract contract) throws DAOException, DataNotFoundException, Exception {
		// 用户
		User sessionUser = UserSession.getUser();
		Timestamp date = new Timestamp(System.currentTimeMillis());
		String user = sessionUser.getLoginName();

		// 分期期数
		RepaymentStageService repaymentStageService = (RepaymentStageService) SpringUtil
				.getBean("RepaymentStageService");
		RepaymentStage repaymentStage = repaymentStageService.getById(contract.getStage().getId());
		int stage = repaymentStage.getRepaymentStage();

		// 日期
		Calendar cal = Calendar.getInstance();
		cal.setTime(contract.getStartDate());
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(contract.getStartDate());

		DecimalFormat df = new DecimalFormat("#.00");

		double preValue = contractParaDAO.findValueByContractAndPara(contract, productParameterDAO.getById(1));
		// v2版本需求by20180611 拆分服务费 每期本金=借款金额/期数 每期服务费=服务费/期数
		double principal = contract.getAmount() + contract.getAmount() * (preValue / 100) * stage;// 本金
		double perPrincipal = Double.valueOf(df.format(contract.getAmount() / stage));// 每期本金
		double interest = contractParaDAO.findValueByContractAndPara(contract, productParameterDAO.getById(2));// 利息率
		double interestAmount = Double.valueOf(df.format(contract.getAmount() * interest / 100));// 每期利息
		CustomerContract customerContract = customerContractDAO.getById(contract.getId());
		customerContract.setPrincipal(principal);
		customerContract.setUpdateDate(date);
		customerContract.setUpdateUser(user);
		customerContractDAO.update(customerContract);

		ContractStage contractStage0 = new ContractStage();
		contractStage0.setStage(0);
		contractStage0.setContract(contract);
		contractStage0.setCapital(0);
		contractStage0.setInterest(interestAmount);
		contractStage0.setState(1);
		contractStage0
				.setExtraCharges(contractGpsLateFeeDAO.findContractGpsLateFeeByCustomerContract(contract).getCostValue()
						* daysBetween(getCalendar(cal, 0).getTime(), getCalendar(cal1, 1).getTime())
						+ contract.getContractManageValue());

		cal.setTime(contract.getStartDate());
		contractStage0.setRepaymentDate(cal.getTime());
		contractStage0.setUpdateDate(date);
		contractStage0.setUpdateUser(user);
		contractStage0.setCreateDate(date);
		contractStage0.setCreateUser(user);
		contractStageDAO.add(contractStage0);

		// 0期还款
		ContractRepayment contractRepayment0 = new ContractRepayment();
		contractRepayment0.setCapital(contractStage0.getCapital());
		contractRepayment0.setInterest(contractStage0.getInterest());
		contractRepayment0.setPayment(contract.getName());
		contractRepayment0.setRepaymentDate(contractStage0.getRepaymentDate());
		contractRepayment0.setExtraCharges(contractStage0.getExtraCharges());
		contractRepayment0.setRepaymentFee(
				contractStage0.getCapital() + contractStage0.getInterest() + contractStage0.getExtraCharges());
		contractRepayment0.setStage(contractStage0);
		contractRepayment0.setCreateDate(date);
		contractRepayment0.setCreateUser(user);
		contractRepayment0.setUpdateDate(date);
		contractRepayment0.setUpdateUser(user);
		contractRepaymentDAO.add(contractRepayment0);

		// 0期其他费用
		List<CusContractCost> costs = cusContractCostDAO.getCusContractCostByContract(contract);
		for (CusContractCost cost : costs) {
			ContractStageFee contractStageFee = new ContractStageFee();
			contractStageFee.setCostType(cost.getCostType());
			contractStageFee.setFee(cost.getValue());
			contractStageFee.setStage(contractStage0);
			contractStageFee.setUpdateDate(date);
			contractStageFee.setUpdateUser(user);
			contractStageFee.setCreateDate(date);
			contractStageFee.setCreateUser(user);
			contractStageFeeDAO.add(contractStageFee);

			CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
			otherFee.setCostType(contractStageFee.getCostType());
			otherFee.setCreateDate(date);
			otherFee.setCreateUser(user);
			otherFee.setDefaultValue(contractStageFee.getFee());
			otherFee.setRepayment(contractRepayment0);
			otherFee.setUpdateDate(date);
			otherFee.setUpdateUser(user);
			otherFee.setValue(contractStageFee.getFee());
			cusContractRepaymentOtherFeeDAO.add(otherFee);
		}

		// 0期停车费
		ContractStageFee contractStageFee = new ContractStageFee();
		contractStageFee.setCostType(costTypeDAO.getById(3));
		contractStageFee.setFee(contractGpsLateFeeDAO.findContractGpsLateFeeByCustomerContract(contract).getCostValue()
				* daysBetween(getCalendar(cal, 0).getTime(), getCalendar(cal1, 1).getTime()));
		contractStageFee.setStage(contractStage0);
		contractStageFee.setUpdateDate(date);
		contractStageFee.setUpdateUser(user);
		contractStageFeeDAO.add(contractStageFee);

		CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
		otherFee.setCostType(contractStageFee.getCostType());
		otherFee.setDefaultValue(contractStageFee.getFee());
		otherFee.setValue(contractStageFee.getFee());
		otherFee.setRepayment(contractRepayment0);
		otherFee.setCreateDate(date);
		otherFee.setCreateUser(user);
		otherFee.setUpdateDate(date);
		otherFee.setUpdateUser(user);
		cusContractRepaymentOtherFeeDAO.add(otherFee);

		// 0期合同管理费
		if (contract.getContractManageValue() != 0) {
			ContractStageFee contractStageFee1 = new ContractStageFee();
			contractStageFee1.setCostType(costTypeDAO.getById(15));
			contractStageFee1.setFee(contract.getContractManageValue());
			contractStageFee1.setStage(contractStage0);
			contractStageFee1.setUpdateDate(date);
			contractStageFee1.setUpdateUser(user);
			contractStageFee1.setCreateDate(date);
			contractStageFee1.setCreateUser(user);
			contractStageFeeDAO.add(contractStageFee1);

			CusContractRepaymentOtherFee otherFee1 = new CusContractRepaymentOtherFee();
			otherFee1.setCostType(contractStageFee1.getCostType());
			otherFee1.setDefaultValue(contractStageFee1.getFee());
			otherFee1.setValue(contractStageFee1.getFee());
			otherFee1.setRepayment(contractRepayment0);
			otherFee1.setCreateDate(date);
			otherFee1.setCreateUser(user);
			otherFee1.setUpdateDate(date);
			otherFee1.setUpdateUser(user);
			cusContractRepaymentOtherFeeDAO.add(otherFee1);
		}

		if (stage > 1) {
			for (int i = 1; i < stage; i++) {
				cal.setTime(contract.getStartDate());
				cal1.setTime(contract.getStartDate());
				ContractStage contractStagei = new ContractStage();
				contractStagei.setStage(i);
				contractStagei.setContract(contract);
				contractStagei.setCapital(perPrincipal);
				contractStagei.setInterest(interestAmount);
				contractStagei.setUpdateDate(date);
				contractStagei.setUpdateUser(user);
				contractStagei.setCreateDate(date);
				contractStagei.setCreateUser(user);
				contractStagei.setExtraCharges(
						(contractGpsLateFeeDAO.findContractGpsLateFeeByCustomerContract(contract)).getCostValue()
								* daysBetween(getCalendar(cal, i).getTime(), getCalendar(cal1, i + 1).getTime())
								+ contract.getContractManageValue());

				cal.setTime(contract.getStartDate());
				contractStagei.setRepaymentDate(getCalendar(cal, i).getTime());
				contractStageDAO.add(contractStagei);
				ContractStageFee contractStageFeei = new ContractStageFee();
				contractStageFeei.setCostType(costTypeDAO.getById(3));
				contractStageFeei.setFee(
						(contractGpsLateFeeDAO.findContractGpsLateFeeByCustomerContract(contract)).getCostValue()
								* daysBetween(getCalendar(cal, i).getTime(), getCalendar(cal1, i + 1).getTime()));
				contractStageFeei.setStage(contractStagei);
				contractStageFeei.setUpdateDate(date);
				contractStageFeei.setUpdateUser(user);
				contractStageFeei.setCreateDate(date);
				contractStageFeei.setCreateUser(user);
				contractStageFeeDAO.add(contractStageFeei);

				if (contract.getContractManageValue() != 0) {
					ContractStageFee contractStageFee1 = new ContractStageFee();
					contractStageFee1.setCostType(costTypeDAO.getById(15));
					contractStageFee1.setFee(contract.getContractManageValue());
					contractStageFee1.setStage(contractStagei);
					contractStageFee1.setUpdateDate(date);
					contractStageFee1.setUpdateUser(user);
					contractStageFee1.setCreateDate(date);
					contractStageFee1.setCreateUser(user);
					contractStageFeeDAO.add(contractStageFee1);
				}
			}
		}
		cal.setTime(contract.getStartDate());
		ContractStage contractStage = new ContractStage();
		// v2版本需求by20180611 拆分服务费 每期本金=借款金额/期数 每期服务费=服务费/期数
		double lastPrincipal = contract.getAmount() - perPrincipal * (stage - 1);
		contractStage.setStage(stage);
		contractStage.setContract(contract);
		contractStage.setCapital(lastPrincipal);
		contractStage.setInterest(0);
		contractStage.setExtraCharges(0);
		contractStage.setRepaymentDate(getCalendar(cal, stage).getTime());
		contractStage.setUpdateDate(date);
		contractStage.setUpdateUser(user);
		contractStage.setCreateDate(date);
		contractStage.setCreateUser(user);

		contractStageDAO.add(contractStage);
	}

	/**
	 * @category 重构分期计算算法
	 * @param contract
	 * @see v3
	 * @return
	 */
	public boolean addContractStageV3(CustomerContract contract) throws DAOException, DataNotFoundException, Exception {
		// 等额
		if (contract.getRepaymentType().getId() == 6) {
			// 没GPS费
			if (contractGpsLateFeeDAO.getCountByCustomerContract(contract) == 0) {
				for (ContractGpsLateFee gpsinstall : contractGpsLateFeeDAO
						.findContractGpsLateFeeListByCustomerContract(contract)) {
					ParkingFeeService parkingFeeService = (ParkingFeeService) SpringUtil.getBean("ParkingFeeService");
					ParkingFee parkingFee = parkingFeeService.getById(gpsinstall.getParkingFee().getId());
					if (parkingFee.getParkingType().equals("日租")) {
						addStageByCostType(contract);
						return true;
					} else if (parkingFee.getParkingType().equals("月租")) {
						addStageByCostType(contract);
						return true;
					} else if (parkingFee.getParkingType().equals("年租")) {
						addStageByCostType(contract);
						return true;
					}
				}
			} else {
				for (ContractGpsLateFee gpsinstall : contractGpsLateFeeDAO
						.findContractGpsLateFeeListByCustomerContract(contract)) {
					GpsCostTypeService gpsCostTypeService = (GpsCostTypeService) SpringUtil
							.getBean("GpsCostTypeService");
					GpsCostType gpsCostType = gpsCostTypeService.getById(gpsinstall.getType().getId());
					if (gpsCostType.getGpsCostType().equals("年租")) {
						addStageByCostType(contract);
						return true;
					} else if (gpsCostType.getGpsCostType().equals("月租")) {
						addStageByCostType(contract);
						return true;
					}
				}
			}

		}

		// 先息
		if (contract.getRepaymentType().getId() == 7) {
			ProductRepaymentStage proRepayStage = productRepaymentStageDAO
					.getProductRepaymentStagesByProductAndStage(contract.getProduct(), contract.getStage());
			double preValue = contractParaDAO.findValueByContractAndPara(contract, productParameterDAO.getById(1));

			if (contractGpsLateFeeDAO.getCountByCustomerContract(contract) == 0) {
				for (ContractGpsLateFee gpsinstall : contractGpsLateFeeDAO
						.findContractGpsLateFeeListByCustomerContract(contract)) {
					ParkingFeeService parkingFeeService = (ParkingFeeService) SpringUtil.getBean("ParkingFeeService");
					ParkingFee parkingFee = parkingFeeService.getById(gpsinstall.getParkingFee().getId());
					if (parkingFee.getParkingType().equals("日租")) {
						addStageByCostType(contract);
						return true;
					} else if (parkingFee.getParkingType().equals("月租")) {
						addStageByCostType(contract);
						return true;
					} else if (parkingFee.getParkingType().equals("年租")) {
						addStageByCostType(contract);
						return true;
					}
				}
			} else {
				for (ContractGpsLateFee gpsinstall : contractGpsLateFeeDAO
						.findContractGpsLateFeeListByCustomerContract(contract)) {
					GpsCostTypeService gpsCostTypeService = (GpsCostTypeService) SpringUtil
							.getBean("GpsCostTypeService");
					GpsCostType gpsCostType = gpsCostTypeService.getById(gpsinstall.getType().getId());
					if (gpsCostType.getGpsCostType().equals("年租")) {
						addStageByCostType(contract);
						return true;
					} else if (gpsCostType.getGpsCostType().equals("月租")) {
						addStageByCostType(contract);
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * @category 新产品v2版本
	 * @param contract
	 * @return
	 * @throws DAOException
	 * @throws DataNotFoundException
	 * @throws Exception
	 */
	public boolean addContractStageV2(CustomerContract contract) throws DAOException, DataNotFoundException, Exception {
		// 用户
		User sessionUser = UserSession.getUser();
		if (sessionUser == null) {
			return false;
		}
		Timestamp date = new Timestamp(System.currentTimeMillis());
		String user = sessionUser.getLoginName();

		// 分期期数
		RepaymentStageService repaymentStageService = (RepaymentStageService) SpringUtil
				.getBean("RepaymentStageService");
		RepaymentStage repaymentStage = repaymentStageService.getById(contract.getStage().getId());
		int stage = repaymentStage.getRepaymentStage();

		// 日期
		Calendar cal = Calendar.getInstance();
		cal.setTime(contract.getStartDate());
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(contract.getStartDate());

		DecimalFormat df = new DecimalFormat("#.00");
		Product product = productDAO.getById(contract.getProduct().getId());
		// 等额
		if (product.getRepaymentType().getId() == 6) {
			// 没GPS费
			if (contractGpsLateFeeDAO.getCountByCustomerContract(contract) == 0) {
				for (ContractGpsLateFee gpsinstall : contractGpsLateFeeDAO
						.findContractGpsLateFeeListByCustomerContract(contract)) {
					ParkingFeeService parkingFeeService = (ParkingFeeService) SpringUtil.getBean("ParkingFeeService");
					ParkingFee parkingFee = parkingFeeService.getById(gpsinstall.getParkingFee().getId());
					if (parkingFee.getParkingType().equals("日租")) {
						double preValue = contractParaDAO.findValueByContractAndPara(contract,
								productParameterDAO.getById(1));
						// v2版本需求by20180611 拆分服务费 每期本金=借款金额/期数 每期服务费=服务费/期数
						double principal = contract.getAmount() + contract.getAmount() * (preValue / 100) * stage;// 本金
						double perPrincipal = Double.valueOf(df.format(contract.getAmount() / stage));// 每期本金
						double interest = contractParaDAO.findValueByContractAndPara(contract,
								productParameterDAO.getById(2));// 利息率
						double interestAmount = Double.valueOf(df.format(contract.getAmount() * interest / 100));// 每期利息
						CustomerContract customerContract = customerContractDAO.getById(contract.getId());
						customerContract.setPrincipal(principal);
						customerContract.setUpdateDate(date);
						customerContract.setUpdateUser(user);
						customerContractDAO.update(customerContract);

						ContractStage contractStage0 = new ContractStage();
						contractStage0.setStage(0);
						contractStage0.setContract(contract);
						contractStage0.setCapital(0);
						contractStage0.setInterest(interestAmount);
						contractStage0.setState(1);
						contractStage0.setExtraCharges(
								contractGpsLateFeeDAO.findContractGpsLateFeeByCustomerContract(contract).getCostValue()
										* daysBetween(getCalendar(cal, 0).getTime(), getCalendar(cal1, 1).getTime())
										+ contract.getContractManageValue());

						cal.setTime(contract.getStartDate());
						contractStage0.setRepaymentDate(cal.getTime());
						contractStage0.setRealrepaymentDate(contractStage0.getRepaymentDate());
						contractStage0.setUpdateDate(date);
						contractStage0.setUpdateUser(user);
						contractStage0.setCreateDate(date);
						contractStage0.setCreateUser(user);
						contractStageDAO.add(contractStage0);

						// 0期还款
						ContractRepayment contractRepayment0 = new ContractRepayment();
						contractRepayment0.setCapital(contractStage0.getCapital());
						contractRepayment0.setInterest(contractStage0.getInterest());
						contractRepayment0.setPayment(contract.getName());
						contractRepayment0.setRepaymentDate(contractStage0.getRepaymentDate());
						contractRepayment0.setExtraCharges(contractStage0.getExtraCharges());
						contractRepayment0.setRepaymentFee(contractStage0.getCapital() + contractStage0.getInterest()
								+ contractStage0.getExtraCharges());
						contractRepayment0.setStage(contractStage0);
						contractRepayment0.setCreateDate(date);
						contractRepayment0.setCreateUser(user);
						contractRepayment0.setUpdateDate(date);
						contractRepayment0.setUpdateUser(user);
						contractRepayment0.setState(1);
						contractRepaymentDAO.add(contractRepayment0);

						// 0期其他费用
						List<CusContractCost> costs = cusContractCostDAO.getCusContractCostByContract(contract);
						for (CusContractCost cost : costs) {
							ContractStageFee contractStageFee = new ContractStageFee();
							contractStageFee.setCostType(cost.getCostType());
							contractStageFee.setFee(cost.getValue());
							contractStageFee.setStage(contractStage0);
							contractStageFee.setUpdateDate(date);
							contractStageFee.setUpdateUser(user);
							contractStageFee.setCreateDate(date);
							contractStageFee.setCreateUser(user);
							contractStageFeeDAO.add(contractStageFee);

							CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
							otherFee.setCostType(contractStageFee.getCostType());
							otherFee.setCreateDate(date);
							otherFee.setCreateUser(user);
							otherFee.setDefaultValue(contractStageFee.getFee());
							otherFee.setRepayment(contractRepayment0);
							otherFee.setUpdateDate(date);
							otherFee.setUpdateUser(user);
							otherFee.setValue(contractStageFee.getFee());
							cusContractRepaymentOtherFeeDAO.add(otherFee);
						}

						// 0期停车费
						ContractStageFee contractStageFee = new ContractStageFee();
						contractStageFee.setCostType(costTypeDAO.getById(3));
						contractStageFee.setFee(
								contractGpsLateFeeDAO.findContractGpsLateFeeByCustomerContract(contract).getCostValue()
										* daysBetween(getCalendar(cal, 0).getTime(), getCalendar(cal1, 1).getTime()));
						contractStageFee.setStage(contractStage0);
						contractStageFee.setUpdateDate(date);
						contractStageFee.setUpdateUser(user);
						contractStageFeeDAO.add(contractStageFee);

						CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
						otherFee.setCostType(contractStageFee.getCostType());
						otherFee.setDefaultValue(contractStageFee.getFee());
						otherFee.setValue(contractStageFee.getFee());
						otherFee.setRepayment(contractRepayment0);
						otherFee.setCreateDate(date);
						otherFee.setCreateUser(user);
						otherFee.setUpdateDate(date);
						otherFee.setUpdateUser(user);
						cusContractRepaymentOtherFeeDAO.add(otherFee);

						// 0期合同管理费
						if (contract.getContractManageValue() != 0) {
							ContractStageFee contractStageFee1 = new ContractStageFee();
							contractStageFee1.setCostType(costTypeDAO.getById(15));
							contractStageFee1.setFee(contract.getContractManageValue());
							contractStageFee1.setStage(contractStage0);
							contractStageFee1.setUpdateDate(date);
							contractStageFee1.setUpdateUser(user);
							contractStageFee1.setCreateDate(date);
							contractStageFee1.setCreateUser(user);
							contractStageFeeDAO.add(contractStageFee1);

							CusContractRepaymentOtherFee otherFee1 = new CusContractRepaymentOtherFee();
							otherFee1.setCostType(contractStageFee1.getCostType());
							otherFee1.setDefaultValue(contractStageFee1.getFee());
							otherFee1.setValue(contractStageFee1.getFee());
							otherFee1.setRepayment(contractRepayment0);
							otherFee1.setCreateDate(date);
							otherFee1.setCreateUser(user);
							otherFee1.setUpdateDate(date);
							otherFee1.setUpdateUser(user);
							cusContractRepaymentOtherFeeDAO.add(otherFee1);
						}

						if (stage > 1) {
							for (int i = 1; i < stage; i++) {
								cal.setTime(contract.getStartDate());
								cal1.setTime(contract.getStartDate());
								ContractStage contractStagei = new ContractStage();
								contractStagei.setStage(i);
								contractStagei.setContract(contract);
								contractStagei.setCapital(perPrincipal);
								contractStagei.setInterest(interestAmount);
								contractStagei.setUpdateDate(date);
								contractStagei.setUpdateUser(user);
								contractStagei.setCreateDate(date);
								contractStagei.setCreateUser(user);
								contractStagei.setExtraCharges(
										(contractGpsLateFeeDAO.findContractGpsLateFeeByCustomerContract(contract))
												.getCostValue()
												* daysBetween(getCalendar(cal, i).getTime(),
														getCalendar(cal1, i + 1).getTime())
												+ contract.getContractManageValue());

								cal.setTime(contract.getStartDate());
								contractStagei.setRepaymentDate(getCalendar(cal, i).getTime());
								contractStagei.setRealrepaymentDate(contractStagei.getRepaymentDate());
								contractStageDAO.add(contractStagei);
								ContractStageFee contractStageFeei = new ContractStageFee();
								contractStageFeei.setCostType(costTypeDAO.getById(3));
								contractStageFeei.setFee(
										(contractGpsLateFeeDAO.findContractGpsLateFeeByCustomerContract(contract))
												.getCostValue()
												* daysBetween(getCalendar(cal, i).getTime(),
														getCalendar(cal1, i + 1).getTime()));
								contractStageFeei.setStage(contractStagei);
								contractStageFeei.setUpdateDate(date);
								contractStageFeei.setUpdateUser(user);
								contractStageFeei.setCreateDate(date);
								contractStageFeei.setCreateUser(user);
								contractStageFeeDAO.add(contractStageFeei);

								if (contract.getContractManageValue() != 0) {
									ContractStageFee contractStageFee1 = new ContractStageFee();
									contractStageFee1.setCostType(costTypeDAO.getById(15));
									contractStageFee1.setFee(contract.getContractManageValue());
									contractStageFee1.setStage(contractStagei);
									contractStageFee1.setUpdateDate(date);
									contractStageFee1.setUpdateUser(user);
									contractStageFee1.setCreateDate(date);
									contractStageFee1.setCreateUser(user);
									contractStageFeeDAO.add(contractStageFee1);
								}
							}
						}
						cal.setTime(contract.getStartDate());
						ContractStage contractStage = new ContractStage();
						// v2版本需求by20180611 拆分服务费 每期本金=借款金额/期数 每期服务费=服务费/期数
						double lastPrincipal = contract.getAmount() - perPrincipal * (stage - 1);
						contractStage.setStage(stage);
						contractStage.setContract(contract);
						contractStage.setCapital(lastPrincipal);
						contractStage.setInterest(0);
						contractStage.setExtraCharges(0);
						contractStage.setRepaymentDate(getCalendar(cal, stage).getTime());
						contractStage.setRealrepaymentDate(contractStage.getRepaymentDate());
						contractStage.setUpdateDate(date);
						contractStage.setUpdateUser(user);
						contractStage.setCreateDate(date);
						contractStage.setCreateUser(user);

						contractStageDAO.add(contractStage);
						return true;
					} else if (parkingFee.getParkingType().equals("月租")) {
						double preValue = contractParaDAO.findValueByContractAndPara(contract,
								productParameterDAO.getById(1));
						// v2版本需求by20180611 拆分服务费 每期本金=借款金额/期数 每期服务费=服务费/期数
						double principal = contract.getAmount() + contract.getAmount() * (preValue / 100) * stage;
						double perPrincipal = Double.valueOf(df.format(contract.getAmount() / stage));
						double interest = contractParaDAO.findValueByContractAndPara(contract,
								productParameterDAO.getById(2));
						double interestAmount = Double.valueOf(df.format(contract.getAmount() * interest / 100));
						CustomerContract customerContract = customerContractDAO.getById(contract.getId());
						customerContract.setPrincipal(principal);
						customerContract.setUpdateDate(date);
						customerContract.setUpdateUser(user);
						customerContractDAO.update(customerContract);
						ContractStage contractStage0 = new ContractStage();

						contractStage0.setStage(0);
						contractStage0.setContract(contract);
						contractStage0.setCapital(0);
						contractStage0.setState(1);
						contractStage0.setInterest(interestAmount);
						contractStage0.setExtraCharges(gpsinstall.getCostValue() + contract.getContractManageValue());
						contractStage0.setRepaymentDate(cal.getTime());
						contractStage0.setRealrepaymentDate(contractStage0.getRepaymentDate());
						contractStage0.setUpdateDate(date);
						contractStage0.setUpdateUser(user);
						contractStage0.setCreateDate(date);
						contractStage0.setCreateUser(user);
						contractStageDAO.add(contractStage0);

						ContractRepayment contractRepayment0 = new ContractRepayment();
						contractRepayment0.setCapital(contractStage0.getCapital());
						contractRepayment0.setInterest(contractStage0.getInterest());
						contractRepayment0.setPayment(contract.getName());
						contractRepayment0.setExtraCharges(contractStage0.getExtraCharges());
						contractRepayment0.setRepaymentDate(contractStage0.getRepaymentDate());
						contractRepayment0.setRepaymentFee(contractStage0.getCapital() + contractStage0.getInterest()
								+ contractStage0.getExtraCharges());
						contractRepayment0.setStage(contractStage0);
						contractRepayment0.setCreateDate(date);
						contractRepayment0.setCreateUser(user);
						contractRepayment0.setUpdateDate(date);
						contractRepayment0.setUpdateUser(user);
						contractRepayment0.setState(1);
						contractRepaymentDAO.add(contractRepayment0);

						List<CusContractCost> costs = cusContractCostDAO.getCusContractCostByContract(contract);
						for (CusContractCost cost : costs) {
							ContractStageFee contractStageFee = new ContractStageFee();
							contractStageFee.setCostType(cost.getCostType());
							contractStageFee.setFee(cost.getValue());
							contractStageFee.setStage(contractStage0);
							contractStageFee.setUpdateDate(date);
							contractStageFee.setUpdateUser(user);
							contractStageFee.setCreateDate(date);
							contractStageFee.setCreateUser(user);
							contractStageFeeDAO.add(contractStageFee);

							CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
							otherFee.setCostType(contractStageFee.getCostType());
							otherFee.setCreateDate(date);
							otherFee.setCreateUser(user);
							otherFee.setDefaultValue(contractStageFee.getFee());
							otherFee.setRepayment(contractRepayment0);
							otherFee.setUpdateDate(date);
							otherFee.setUpdateUser(user);
							otherFee.setValue(contractStageFee.getFee());
							cusContractRepaymentOtherFeeDAO.add(otherFee);
						}
						ContractStageFee contractStageFee = new ContractStageFee();
						contractStageFee.setCostType(costTypeDAO.getById(3));
						contractStageFee.setFee(gpsinstall.getCostValue());
						contractStageFee.setStage(contractStage0);
						contractStageFee.setUpdateDate(date);
						contractStageFee.setUpdateUser(user);
						contractStageFee.setCreateDate(date);
						contractStageFee.setCreateUser(user);
						contractStageFeeDAO.add(contractStageFee);

						CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
						otherFee.setCostType(contractStageFee.getCostType());
						otherFee.setDefaultValue(contractStageFee.getFee());
						otherFee.setValue(contractStageFee.getFee());
						otherFee.setRepayment(contractRepayment0);
						otherFee.setCreateDate(date);
						otherFee.setCreateUser(user);
						otherFee.setUpdateDate(date);
						otherFee.setUpdateUser(user);
						cusContractRepaymentOtherFeeDAO.add(otherFee);

						if (contract.getContractManageValue() != 0) {
							ContractStageFee contractStageFee1 = new ContractStageFee();
							contractStageFee1.setCostType(costTypeDAO.getById(15));
							contractStageFee1.setFee(contract.getContractManageValue());
							contractStageFee1.setStage(contractStage0);
							contractStageFee1.setUpdateDate(date);
							contractStageFee1.setUpdateUser(user);
							contractStageFee1.setCreateDate(date);
							contractStageFee1.setCreateUser(user);
							contractStageFeeDAO.add(contractStageFee1);

							CusContractRepaymentOtherFee otherFee1 = new CusContractRepaymentOtherFee();
							otherFee1.setCostType(contractStageFee1.getCostType());
							otherFee1.setDefaultValue(contractStageFee1.getFee());
							otherFee1.setValue(contractStageFee1.getFee());
							otherFee1.setRepayment(contractRepayment0);
							otherFee1.setCreateDate(date);
							otherFee1.setCreateUser(user);
							otherFee1.setUpdateDate(date);
							otherFee1.setUpdateUser(user);
							cusContractRepaymentOtherFeeDAO.add(otherFee1);
						}

						if (stage > 1) {
							for (int i = 1; i < stage; i++) {
								cal.setTime(contract.getStartDate());
								ContractStage contractStagei = new ContractStage();
								contractStagei.setStage(i);
								contractStagei.setContract(contract);
								contractStagei.setCapital(perPrincipal);
								contractStagei.setInterest(interestAmount);
								contractStagei.setExtraCharges(gpsinstall.getCostValue());
								contractStagei.setRepaymentDate(getCalendar(cal, i).getTime());
								contractStagei.setRealrepaymentDate(contractStagei.getRepaymentDate());
								contractStagei.setUpdateDate(date);
								contractStagei.setUpdateUser(user);
								contractStagei.setCreateDate(date);
								contractStagei.setCreateUser(user);
								contractStageDAO.add(contractStagei);
								ContractStageFee contractStageFeei = new ContractStageFee();
								contractStageFeei.setCostType(costTypeDAO.getById(3));
								contractStageFeei.setFee(gpsinstall.getCostValue());
								contractStageFeei.setStage(contractStagei);
								contractStageFeei.setUpdateDate(date);
								contractStageFeei.setUpdateUser(user);
								contractStageFeei.setCreateDate(date);
								contractStageFeei.setCreateUser(user);
								contractStageFeeDAO.add(contractStageFeei);

								if (contract.getContractManageValue() != 0) {
									ContractStageFee contractStageFee1 = new ContractStageFee();
									contractStageFee1.setCostType(costTypeDAO.getById(15));
									contractStageFee1.setFee(contract.getContractManageValue());
									contractStageFee1.setStage(contractStagei);
									contractStageFee1.setUpdateDate(date);
									contractStageFee1.setUpdateUser(user);
									contractStageFee1.setCreateDate(date);
									contractStageFee1.setCreateUser(user);
									contractStageFeeDAO.add(contractStageFee1);
								}
							}
						}
						cal.setTime(contract.getStartDate());
						ContractStage contractStage = new ContractStage();
						// v2版本需求by20180611 拆分服务费 每期本金=借款金额/期数 每期服务费=服务费/期数
						double lastPrincipal = contract.getAmount() - perPrincipal * (stage - 1);
						contractStage.setStage(stage);
						contractStage.setContract(contract);
						contractStage.setCapital(lastPrincipal);
						contractStage.setInterest(0);
						contractStage.setExtraCharges(0);
						contractStage.setRepaymentDate(getCalendar(cal, stage).getTime());
						contractStage.setRealrepaymentDate(contractStage.getRepaymentDate());
						contractStage.setUpdateDate(date);
						contractStage.setUpdateUser(user);
						contractStage.setCreateDate(date);
						contractStage.setCreateUser(user);
						contractStageDAO.add(contractStage);
						return true;
					} else if (parkingFee.getParkingType().equals("年租")) {
						double preValue = contractParaDAO.findValueByContractAndPara(contract,
								productParameterDAO.getById(1));
						// v2版本需求by20180611 拆分服务费 每期本金=借款金额/期数 每期服务费=服务费/期数
						double principal = contract.getAmount() + contract.getAmount() * (preValue / 100) * stage;
						double perPrincipal = Double.valueOf(df.format(contract.getAmount() / stage));
						double interest = contractParaDAO.findValueByContractAndPara(contract,
								productParameterDAO.getById(2));
						double interestAmount = Double.valueOf(df.format(contract.getAmount() * interest / 100));
						CustomerContract customerContract = customerContractDAO.getById(contract.getId());
						customerContract.setPrincipal(principal);
						customerContract.setUpdateDate(date);
						customerContract.setUpdateUser(user);
						customerContractDAO.update(customerContract);
						ContractStage contractStage0 = new ContractStage();

						contractStage0.setStage(0);
						contractStage0.setContract(contract);
						contractStage0.setCapital(0);
						contractStage0.setState(1);
						contractStage0.setInterest(interestAmount);
						contractStage0.setExtraCharges(gpsinstall.getCostValue() + contract.getContractManageValue());
						contractStage0.setRepaymentDate(cal.getTime());
						contractStage0.setRealrepaymentDate(contractStage0.getRepaymentDate());
						contractStage0.setUpdateDate(date);
						contractStage0.setUpdateUser(user);
						contractStage0.setCreateDate(date);
						contractStage0.setCreateUser(user);
						contractStageDAO.add(contractStage0);

						ContractRepayment contractRepayment0 = new ContractRepayment();
						contractRepayment0.setCapital(contractStage0.getCapital());
						contractRepayment0.setInterest(contractStage0.getInterest());
						contractRepayment0.setPayment(contract.getName());
						contractRepayment0.setRepaymentDate(contractStage0.getRepaymentDate());
						contractRepayment0.setExtraCharges(contractStage0.getExtraCharges());
						contractRepayment0.setRepaymentFee(contractStage0.getCapital() + contractStage0.getInterest()
								+ contractStage0.getExtraCharges());
						contractRepayment0.setStage(contractStage0);
						contractRepayment0.setCreateDate(date);
						contractRepayment0.setCreateUser(user);
						contractRepayment0.setUpdateDate(date);
						contractRepayment0.setUpdateUser(user);
						contractRepayment0.setState(1);
						contractRepaymentDAO.add(contractRepayment0);

						List<CusContractCost> costs = cusContractCostDAO.getCusContractCostByContract(contract);
						for (CusContractCost cost : costs) {
							ContractStageFee contractStageFee = new ContractStageFee();
							contractStageFee.setCostType(cost.getCostType());
							contractStageFee.setFee(cost.getValue());
							contractStageFee.setStage(contractStage0);
							contractStageFee.setUpdateDate(date);
							contractStageFee.setUpdateUser(user);
							contractStageFee.setCreateDate(date);
							contractStageFee.setCreateUser(user);
							contractStageFeeDAO.add(contractStageFee);

							CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
							otherFee.setCostType(contractStageFee.getCostType());
							otherFee.setCreateDate(date);
							otherFee.setCreateUser(user);
							otherFee.setDefaultValue(contractStageFee.getFee());
							otherFee.setRepayment(contractRepayment0);
							otherFee.setUpdateDate(date);
							otherFee.setUpdateUser(user);
							otherFee.setValue(contractStageFee.getFee());
							cusContractRepaymentOtherFeeDAO.add(otherFee);

						}
						ContractStageFee contractStageFee = new ContractStageFee();
						contractStageFee.setCostType(costTypeDAO.getById(3));
						contractStageFee.setFee(gpsinstall.getCostValue());
						contractStageFee.setStage(contractStage0);
						contractStageFee.setUpdateDate(date);
						contractStageFee.setUpdateUser(user);
						contractStageFee.setCreateDate(date);
						contractStageFee.setCreateUser(user);
						contractStageFeeDAO.add(contractStageFee);

						CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
						otherFee.setCostType(contractStageFee.getCostType());
						otherFee.setDefaultValue(contractStageFee.getFee());
						otherFee.setValue(contractStageFee.getFee());
						otherFee.setRepayment(contractRepayment0);
						otherFee.setCreateDate(date);
						otherFee.setCreateUser(user);
						otherFee.setUpdateDate(date);
						otherFee.setUpdateUser(user);
						cusContractRepaymentOtherFeeDAO.add(otherFee);

						if (contract.getContractManageValue() != 0) {
							ContractStageFee contractStageFee1 = new ContractStageFee();
							contractStageFee1.setCostType(costTypeDAO.getById(15));
							contractStageFee1.setFee(contract.getContractManageValue());
							contractStageFee1.setStage(contractStage0);
							contractStageFee1.setUpdateDate(date);
							contractStageFee1.setUpdateUser(user);
							contractStageFee1.setCreateDate(date);
							contractStageFee1.setCreateUser(user);
							contractStageFeeDAO.add(contractStageFee1);

							CusContractRepaymentOtherFee otherFee1 = new CusContractRepaymentOtherFee();
							otherFee1.setCostType(contractStageFee1.getCostType());
							otherFee1.setDefaultValue(contractStageFee1.getFee());
							otherFee1.setValue(contractStageFee1.getFee());
							otherFee1.setRepayment(contractRepayment0);
							otherFee1.setCreateDate(date);
							otherFee1.setCreateUser(user);
							otherFee1.setUpdateDate(date);
							otherFee1.setUpdateUser(user);
							cusContractRepaymentOtherFeeDAO.add(otherFee1);
						}
						if (stage > 1) {
							for (int i = 1; i < stage; i++) {
								cal.setTime(contract.getStartDate());
								ContractStage contractStagei = new ContractStage();
								contractStagei.setStage(i);
								contractStagei.setContract(contract);
								contractStagei.setCapital(perPrincipal);
								contractStagei.setInterest(interestAmount);

								if (i % 12 == 11 && stage > i + 1) {
									contractStagei.setExtraCharges(
											gpsinstall.getCostValue() + contract.getContractManageValue());

								} else {
									contractStagei.setExtraCharges(0 + contract.getContractManageValue());
								}
								contractStagei.setRepaymentDate(getCalendar(cal, i).getTime());
								contractStagei.setRealrepaymentDate(contractStagei.getRepaymentDate());
								contractStagei.setUpdateDate(date);
								contractStagei.setUpdateUser(user);
								contractStagei.setCreateDate(date);
								contractStagei.setCreateUser(user);

								contractStageDAO.add(contractStagei);
								if (i % 12 == 11 && stage > i + 1) {
									ContractStageFee contractStageFeei = new ContractStageFee();
									contractStageFeei.setCostType(costTypeDAO.getById(3));
									contractStageFeei.setFee(gpsinstall.getCostValue());
									contractStageFeei.setStage(contractStagei);
									contractStageFeei.setUpdateDate(date);
									contractStageFeei.setUpdateUser(user);
									contractStageFeei.setCreateDate(date);
									contractStageFeei.setCreateUser(user);
									contractStageFeeDAO.add(contractStageFeei);
								}

								if (contract.getContractManageValue() != 0) {
									ContractStageFee contractStageFeei = new ContractStageFee();
									contractStageFeei.setCostType(costTypeDAO.getById(15));
									contractStageFeei.setFee(contract.getContractManageValue());
									contractStageFeei.setStage(contractStagei);
									contractStageFeei.setUpdateDate(date);
									contractStageFeei.setUpdateUser(user);
									contractStageFeei.setCreateDate(date);
									contractStageFeei.setCreateUser(user);
									contractStageFeeDAO.add(contractStageFeei);
								}
							}
						}
						cal.setTime(contract.getStartDate());
						ContractStage contractStage = new ContractStage();
						// v2版本需求by20180611 拆分服务费 每期本金=借款金额/期数 每期服务费=服务费/期数
						double lastPrincipal = contract.getAmount() - perPrincipal * (stage - 1);
						contractStage.setStage(stage);
						contractStage.setContract(contract);
						contractStage.setCapital(lastPrincipal);
						contractStage.setInterest(0);
						contractStage.setExtraCharges(0);
						contractStage.setRepaymentDate(getCalendar(cal, stage).getTime());
						contractStage.setRealrepaymentDate(contractStage.getRepaymentDate());
						contractStage.setUpdateDate(date);
						contractStage.setUpdateUser(user);
						contractStage.setCreateDate(date);
						contractStage.setCreateUser(user);
						contractStageDAO.add(contractStage);
						return true;
					}
				}

			} else {
				for (ContractGpsLateFee gpsinstall : contractGpsLateFeeDAO
						.findContractGpsLateFeeListByCustomerContract(contract)) {
					GpsCostTypeService gpsCostTypeService = (GpsCostTypeService) SpringUtil
							.getBean("GpsCostTypeService");
					GpsCostType gpsCostType = gpsCostTypeService.getById(gpsinstall.getType().getId());
					if (gpsCostType.getGpsCostType().equals("年租")) {
						double preValue = contractParaDAO.findValueByContractAndPara(contract,
								productParameterDAO.getById(1));
						// v2版本需求by20180611 拆分服务费 每期本金=借款金额/期数 每期服务费=服务费/期数
						double principal = contract.getAmount() + contract.getAmount() * (preValue / 100) * stage;
						double perPrincipal = Double.valueOf(df.format(contract.getAmount() / stage));
						double interest = contractParaDAO.findValueByContractAndPara(contract,
								productParameterDAO.getById(2));
						double interestAmount = Double.valueOf(df.format(contract.getAmount() * interest / 100));
						CustomerContract customerContract = customerContractDAO.getById(contract.getId());
						customerContract.setPrincipal(principal);
						customerContract.setUpdateDate(date);
						customerContract.setUpdateUser(user);
						customerContractDAO.update(customerContract);
						ContractStage contractStage0 = new ContractStage();

						contractStage0.setStage(0);
						contractStage0.setContract(contract);
						contractStage0.setCapital(0);
						contractStage0.setState(1);
						contractStage0.setInterest(interestAmount);
						contractStage0.setExtraCharges(gpsinstall.getCostValue() + contract.getContractManageValue());
						contractStage0.setRepaymentDate(cal.getTime());
						contractStage0.setRealrepaymentDate(contractStage0.getRepaymentDate());
						contractStage0.setUpdateDate(date);
						contractStage0.setUpdateUser(user);
						contractStage0.setCreateDate(date);
						contractStage0.setCreateUser(user);
						contractStageDAO.add(contractStage0);

						ContractRepayment contractRepayment0 = new ContractRepayment();
						contractRepayment0.setCapital(contractStage0.getCapital());
						contractRepayment0.setInterest(contractStage0.getInterest());
						contractRepayment0.setPayment(contract.getName());
						contractRepayment0.setRepaymentDate(contractStage0.getRepaymentDate());
						contractRepayment0.setExtraCharges(contractStage0.getExtraCharges());
						contractRepayment0.setRepaymentFee(contractStage0.getCapital() + contractStage0.getInterest()
								+ contractStage0.getExtraCharges());
						contractRepayment0.setStage(contractStage0);
						contractRepayment0.setCreateDate(date);
						contractRepayment0.setCreateUser(user);
						contractRepayment0.setUpdateDate(date);
						contractRepayment0.setUpdateUser(user);
						contractRepayment0.setState(1);
						contractRepaymentDAO.add(contractRepayment0);

						List<CusContractCost> costs = cusContractCostDAO.getCusContractCostByContract(contract);
						for (CusContractCost cost : costs) {
							ContractStageFee contractStageFee = new ContractStageFee();
							contractStageFee.setCostType(cost.getCostType());
							contractStageFee.setFee(cost.getValue());
							contractStageFee.setStage(contractStage0);
							contractStageFee.setUpdateDate(date);
							contractStageFee.setUpdateUser(user);
							contractStageFee.setCreateDate(date);
							contractStageFee.setCreateUser(user);
							contractStageFeeDAO.add(contractStageFee);

							CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
							otherFee.setCostType(contractStageFee.getCostType());
							otherFee.setCreateDate(date);
							otherFee.setCreateUser(user);
							otherFee.setDefaultValue(contractStageFee.getFee());
							otherFee.setRepayment(contractRepayment0);
							otherFee.setUpdateDate(date);
							otherFee.setUpdateUser(user);
							otherFee.setValue(contractStageFee.getFee());
							cusContractRepaymentOtherFeeDAO.add(otherFee);
						}
						ContractStageFee contractStageFee = new ContractStageFee();
						contractStageFee.setCostType(costTypeDAO.getById(9));
						contractStageFee.setFee(gpsinstall.getCostValue());
						contractStageFee.setStage(contractStage0);
						contractStageFee.setUpdateDate(date);
						contractStageFee.setUpdateUser(user);
						contractStageFee.setCreateDate(date);
						contractStageFee.setCreateUser(user);
						contractStageFeeDAO.add(contractStageFee);

						CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
						otherFee.setCostType(contractStageFee.getCostType());
						otherFee.setDefaultValue(contractStageFee.getFee());
						otherFee.setValue(contractStageFee.getFee());
						otherFee.setRepayment(contractRepayment0);
						otherFee.setCreateDate(date);
						otherFee.setCreateUser(user);
						otherFee.setUpdateDate(date);
						otherFee.setUpdateUser(user);
						cusContractRepaymentOtherFeeDAO.add(otherFee);

						if (contract.getContractManageValue() != 0) {
							ContractStageFee contractStageFee1 = new ContractStageFee();
							contractStageFee1.setCostType(costTypeDAO.getById(15));
							contractStageFee1.setFee(contract.getContractManageValue());
							contractStageFee1.setStage(contractStage0);
							contractStageFee1.setUpdateDate(date);
							contractStageFee1.setUpdateUser(user);
							contractStageFee1.setCreateDate(date);
							contractStageFee1.setCreateUser(user);
							contractStageFeeDAO.add(contractStageFee1);

							CusContractRepaymentOtherFee otherFee1 = new CusContractRepaymentOtherFee();
							otherFee1.setCostType(contractStageFee1.getCostType());
							otherFee1.setDefaultValue(contractStageFee1.getFee());
							otherFee1.setValue(contractStageFee1.getFee());
							otherFee1.setRepayment(contractRepayment0);
							otherFee1.setCreateDate(date);
							otherFee1.setCreateUser(user);
							otherFee1.setUpdateDate(date);
							otherFee1.setUpdateUser(user);
							cusContractRepaymentOtherFeeDAO.add(otherFee1);
						}
						if (stage > 1) {
							for (int i = 1; i < stage; i++) {
								cal.setTime(contract.getStartDate());
								ContractStage contractStagei = new ContractStage();
								contractStagei.setStage(i);
								contractStagei.setContract(contract);
								contractStagei.setCapital(perPrincipal);
								contractStagei.setInterest(interestAmount);

								if (i % 12 == 11 && stage > i + 1) {
									contractStagei.setExtraCharges(
											gpsinstall.getCostValue() + contract.getContractManageValue());

								} else {
									contractStagei.setExtraCharges(0 + contract.getContractManageValue());
								}
								contractStagei.setRepaymentDate(getCalendar(cal, i).getTime());
								contractStagei.setRealrepaymentDate(contractStagei.getRepaymentDate());
								contractStagei.setUpdateDate(date);
								contractStagei.setUpdateUser(user);
								contractStagei.setCreateDate(date);
								contractStagei.setCreateUser(user);
								contractStageDAO.add(contractStagei);
								if (i % 12 == 11 && stage > i + 1) {
									ContractStageFee contractStageFeei = new ContractStageFee();
									contractStageFeei.setCostType(costTypeDAO.getById(9));
									contractStageFeei.setFee(gpsinstall.getCostValue());
									contractStageFeei.setStage(contractStagei);
									contractStageFeei.setUpdateDate(date);
									contractStageFeei.setUpdateUser(user);
									contractStageFeei.setCreateDate(date);
									contractStageFeei.setCreateUser(user);
									contractStageFeeDAO.add(contractStageFeei);
								}

								if (contract.getContractManageValue() != 0) {
									ContractStageFee contractStageFeei = new ContractStageFee();
									contractStageFeei.setCostType(costTypeDAO.getById(15));
									contractStageFeei.setFee(contract.getContractManageValue());
									contractStageFeei.setStage(contractStagei);
									contractStageFeei.setUpdateDate(date);
									contractStageFeei.setUpdateUser(user);
									contractStageFeei.setCreateDate(date);
									contractStageFeei.setCreateUser(user);
									contractStageFeeDAO.add(contractStageFeei);
								}
							}
						}
						cal.setTime(contract.getStartDate());
						ContractStage contractStage = new ContractStage();
						// v2版本需求by20180611 拆分服务费 每期本金=借款金额/期数 每期服务费=服务费/期数
						double lastPrincipal = contract.getAmount() - perPrincipal * (stage - 1);
						contractStage.setStage(stage);
						contractStage.setContract(contract);
						contractStage.setCapital(lastPrincipal);
						contractStage.setInterest(0);
						contractStage.setExtraCharges(0);
						contractStage.setRepaymentDate(getCalendar(cal, stage).getTime());
						contractStage.setRealrepaymentDate(contractStage.getRepaymentDate());
						contractStage.setUpdateDate(date);
						contractStage.setUpdateUser(user);
						contractStage.setCreateDate(date);
						contractStage.setCreateUser(user);
						contractStageDAO.add(contractStage);
						return true;
					} else if (gpsCostType.getGpsCostType().equals("月租")) {
						double preValue = contractParaDAO.findValueByContractAndPara(contract,
								productParameterDAO.getById(1));
						// v2版本需求by20180611 拆分服务费 每期本金=借款金额/期数 每期服务费=服务费/期数
						double principal = contract.getAmount() + contract.getAmount() * (preValue / 100) * stage;
						double perPrincipal = Double.valueOf(df.format(contract.getAmount() / stage));
						double interest = contractParaDAO.findValueByContractAndPara(contract,
								productParameterDAO.getById(2));
						double interestAmount = Double.valueOf(df.format(contract.getAmount() * interest / 100));
						CustomerContract customerContract = customerContractDAO.getById(contract.getId());
						customerContract.setPrincipal(principal);
						customerContract.setUpdateDate(date);
						customerContract.setUpdateUser(user);
						customerContractDAO.update(customerContract);
						ContractStage contractStage0 = new ContractStage();

						contractStage0.setStage(0);
						contractStage0.setContract(contract);
						contractStage0.setCapital(0);
						contractStage0.setInterest(interestAmount);
						contractStage0.setState(1);
						contractStage0.setExtraCharges(gpsinstall.getCostValue() + contract.getContractManageValue());
						contractStage0.setRepaymentDate(cal.getTime());
						contractStage0.setRealrepaymentDate(contractStage0.getRepaymentDate());
						contractStage0.setUpdateDate(date);
						contractStage0.setUpdateUser(user);
						contractStage0.setCreateDate(date);
						contractStage0.setCreateUser(user);
						contractStageDAO.add(contractStage0);

						ContractRepayment contractRepayment0 = new ContractRepayment();
						contractRepayment0.setCapital(contractStage0.getCapital());
						contractRepayment0.setInterest(contractStage0.getInterest());
						contractRepayment0.setPayment(contract.getName());
						contractRepayment0.setRepaymentDate(contractStage0.getRepaymentDate());
						contractRepayment0.setExtraCharges(contractStage0.getExtraCharges());
						contractRepayment0.setRepaymentFee(contractStage0.getCapital() + contractStage0.getInterest()
								+ contractStage0.getExtraCharges());
						contractRepayment0.setStage(contractStage0);
						contractRepayment0.setCreateDate(date);
						contractRepayment0.setCreateUser(user);
						contractRepayment0.setUpdateDate(date);
						contractRepayment0.setUpdateUser(user);
						contractRepayment0.setState(1);
						contractRepaymentDAO.add(contractRepayment0);

						List<CusContractCost> costs = cusContractCostDAO.getCusContractCostByContract(contract);
						for (CusContractCost cost : costs) {
							ContractStageFee contractStageFee = new ContractStageFee();
							contractStageFee.setCostType(cost.getCostType());
							contractStageFee.setFee(cost.getValue());
							contractStageFee.setStage(contractStage0);
							contractStageFee.setUpdateDate(date);
							contractStageFee.setUpdateUser(user);
							contractStageFee.setCreateDate(date);
							contractStageFee.setCreateUser(user);
							contractStageFeeDAO.add(contractStageFee);

							CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
							otherFee.setCostType(contractStageFee.getCostType());
							otherFee.setCreateDate(date);
							otherFee.setCreateUser(user);
							otherFee.setDefaultValue(contractStageFee.getFee());
							otherFee.setRepayment(contractRepayment0);
							otherFee.setUpdateDate(date);
							otherFee.setUpdateUser(user);
							otherFee.setValue(contractStageFee.getFee());
							cusContractRepaymentOtherFeeDAO.add(otherFee);
						}
						ContractStageFee contractStageFee = new ContractStageFee();
						contractStageFee.setCostType(costTypeDAO.getById(9));
						contractStageFee.setFee(gpsinstall.getCostValue());
						contractStageFee.setStage(contractStage0);
						contractStageFee.setUpdateDate(date);
						contractStageFee.setUpdateUser(user);
						contractStageFee.setCreateDate(date);
						contractStageFee.setCreateUser(user);
						contractStageFeeDAO.add(contractStageFee);

						CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
						otherFee.setCostType(contractStageFee.getCostType());
						otherFee.setDefaultValue(contractStageFee.getFee());
						otherFee.setValue(contractStageFee.getFee());
						otherFee.setRepayment(contractRepayment0);
						otherFee.setCreateDate(date);
						otherFee.setCreateUser(user);
						otherFee.setUpdateDate(date);
						otherFee.setUpdateUser(user);
						cusContractRepaymentOtherFeeDAO.add(otherFee);

						if (contract.getContractManageValue() != 0) {
							ContractStageFee contractStageFee1 = new ContractStageFee();
							contractStageFee1.setCostType(costTypeDAO.getById(15));
							contractStageFee1.setFee(contract.getContractManageValue());
							contractStageFee1.setStage(contractStage0);
							contractStageFee1.setUpdateDate(date);
							contractStageFee1.setUpdateUser(user);
							contractStageFee1.setCreateDate(date);
							contractStageFee1.setCreateUser(user);
							contractStageFeeDAO.add(contractStageFee1);

							CusContractRepaymentOtherFee otherFee1 = new CusContractRepaymentOtherFee();
							otherFee1.setCostType(contractStageFee1.getCostType());
							otherFee1.setDefaultValue(contractStageFee1.getFee());
							otherFee1.setValue(contractStageFee1.getFee());
							otherFee1.setRepayment(contractRepayment0);
							otherFee1.setCreateDate(date);
							otherFee1.setCreateUser(user);
							otherFee1.setUpdateDate(date);
							otherFee1.setUpdateUser(user);
							cusContractRepaymentOtherFeeDAO.add(otherFee1);
						}
						if (stage > 1) {
							for (int i = 1; i < stage; i++) {
								cal.setTime(contract.getStartDate());
								ContractStage contractStagei = new ContractStage();
								contractStagei.setStage(i);
								contractStagei.setContract(contract);
								contractStagei.setCapital(perPrincipal);
								contractStagei.setInterest(interestAmount);
								contractStagei
										.setExtraCharges(gpsinstall.getCostValue() + contract.getContractManageValue());
								contractStagei.setRepaymentDate(getCalendar(cal, i).getTime());
								contractStagei.setRealrepaymentDate(contractStagei.getRepaymentDate());
								contractStagei.setUpdateDate(date);
								contractStagei.setUpdateUser(user);
								contractStagei.setCreateDate(date);
								contractStagei.setCreateUser(user);
								contractStageDAO.add(contractStagei);
								ContractStageFee contractStageFeei = new ContractStageFee();
								contractStageFeei.setCostType(costTypeDAO.getById(9));
								contractStageFeei.setFee(gpsinstall.getCostValue());
								contractStageFeei.setStage(contractStagei);
								contractStageFeei.setUpdateDate(date);
								contractStageFeei.setUpdateUser(user);
								contractStageFeei.setCreateDate(date);
								contractStageFeei.setCreateUser(user);
								contractStageFeeDAO.add(contractStageFeei);

								if (contract.getContractManageValue() != 0) {
									ContractStageFee contractStageFee1 = new ContractStageFee();
									contractStageFee1.setCostType(costTypeDAO.getById(15));
									contractStageFee1.setFee(contract.getContractManageValue());
									contractStageFee1.setStage(contractStagei);
									contractStageFee1.setUpdateDate(date);
									contractStageFee1.setUpdateUser(user);
									contractStageFee1.setCreateDate(date);
									contractStageFee1.setCreateUser(user);
									contractStageFeeDAO.add(contractStageFee1);
								}
							}
						}
						cal.setTime(contract.getStartDate());
						ContractStage contractStage = new ContractStage();
						// v2版本需求by20180611 拆分服务费 每期本金=借款金额/期数 每期服务费=服务费/期数
						double lastPrincipal = contract.getAmount() - perPrincipal * (stage - 1);
						contractStage.setStage(stage);
						contractStage.setContract(contract);
						contractStage.setCapital(lastPrincipal);
						contractStage.setInterest(0);
						contractStage.setExtraCharges(0);
						contractStage.setRepaymentDate(getCalendar(cal, stage).getTime());
						contractStage.setRealrepaymentDate(contractStage.getRepaymentDate());
						contractStage.setUpdateDate(date);
						contractStage.setUpdateUser(user);
						contractStage.setCreateDate(date);
						contractStage.setCreateUser(user);
						contractStageDAO.add(contractStage);

						return true;
					}
				}
			}

		}

		// 先息
		if (product.getRepaymentType().getId() == 7) {
			ProductRepaymentStage proRepayStage = productRepaymentStageDAO
					.getProductRepaymentStagesByProductAndStage(contract.getProduct(), contract.getStage());
			double preValue = contractParaDAO.findValueByContractAndPara(contract, productParameterDAO.getById(1));

			if (contractGpsLateFeeDAO.getCountByCustomerContract(contract) == 0) {
				for (ContractGpsLateFee gpsinstall : contractGpsLateFeeDAO
						.findContractGpsLateFeeListByCustomerContract(contract)) {
					ParkingFeeService parkingFeeService = (ParkingFeeService) SpringUtil.getBean("ParkingFeeService");
					ParkingFee parkingFee = parkingFeeService.getById(gpsinstall.getParkingFee().getId());
					if (parkingFee.getParkingType().equals("日租")) {
						double principal = contract.getAmount();// 0期还就本金
						if (proRepayStage.getServiceFeeStage() != 0) {
							principal = contract.getAmount() + contract.getAmount() * (preValue / 100) * stage;
						}
						double interest = contractParaDAO.findValueByContractAndPara(contract,
								productParameterDAO.getById(2));
						double interestAmount = Double.valueOf(df.format(contract.getAmount() * interest / 100));
						CustomerContract customerContract = customerContractDAO.getById(contract.getId());
						customerContract.setPrincipal(principal);
						customerContract.setUpdateDate(date);
						customerContract.setUpdateUser(user);
						customerContractDAO.update(customerContract);

						ContractStage contractStage0 = new ContractStage();
						contractStage0.setStage(0);
						contractStage0.setContract(contract);
						contractStage0.setCapital(0);
						contractStage0.setState(1);
						contractStage0.setInterest(interestAmount);
						contractStage0.setExtraCharges(
								contractGpsLateFeeDAO.findContractGpsLateFeeByCustomerContract(contract).getCostValue()
										* daysBetween(getCalendar(cal, 0).getTime(), getCalendar(cal1, 1).getTime())
										+ contract.getContractManageValue());
						cal.setTime(contract.getStartDate());
						contractStage0.setRepaymentDate(cal.getTime());
						contractStage0.setRealrepaymentDate(contractStage0.getRepaymentDate());
						contractStage0.setUpdateDate(date);
						contractStage0.setUpdateUser(user);
						contractStage0.setCreateDate(date);
						contractStage0.setCreateUser(user);
						contractStageDAO.add(contractStage0);

						ContractRepayment contractRepayment0 = new ContractRepayment();
						contractRepayment0.setCapital(contractStage0.getCapital());
						contractRepayment0.setInterest(contractStage0.getInterest());
						contractRepayment0.setPayment(contract.getName());
						contractRepayment0.setRepaymentDate(contractStage0.getRepaymentDate());
						contractRepayment0.setExtraCharges(contractStage0.getExtraCharges());
						contractRepayment0.setRepaymentFee(contractStage0.getCapital() + contractStage0.getInterest()
								+ contractStage0.getExtraCharges());
						contractRepayment0.setStage(contractStage0);
						contractRepayment0.setCreateDate(date);
						contractRepayment0.setCreateUser(user);
						contractRepayment0.setUpdateDate(date);
						contractRepayment0.setUpdateUser(user);
						contractRepayment0.setState(1);
						contractRepaymentDAO.add(contractRepayment0);

						List<CusContractCost> costs = cusContractCostDAO.getCusContractCostByContract(contract);
						for (CusContractCost cost : costs) {
							ContractStageFee contractStageFee = new ContractStageFee();
							contractStageFee.setCostType(cost.getCostType());
							contractStageFee.setFee(cost.getValue());
							contractStageFee.setStage(contractStage0);
							contractStageFee.setUpdateDate(date);
							contractStageFee.setUpdateUser(user);
							contractStageFee.setCreateDate(date);
							contractStageFee.setCreateUser(user);
							contractStageFeeDAO.add(contractStageFee);

							CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
							otherFee.setCostType(contractStageFee.getCostType());
							otherFee.setCreateDate(date);
							otherFee.setCreateUser(user);
							otherFee.setDefaultValue(contractStageFee.getFee());
							otherFee.setRepayment(contractRepayment0);
							otherFee.setUpdateDate(date);
							otherFee.setUpdateUser(user);
							otherFee.setValue(contractStageFee.getFee());
							cusContractRepaymentOtherFeeDAO.add(otherFee);
						}
						ContractStageFee contractStageFee = new ContractStageFee();
						contractStageFee.setCostType(costTypeDAO.getById(3));
						contractStageFee.setFee(
								contractGpsLateFeeDAO.findContractGpsLateFeeByCustomerContract(contract).getCostValue()
										* daysBetween(getCalendar(cal, 0).getTime(), getCalendar(cal1, 1).getTime()));
						contractStageFee.setStage(contractStage0);
						contractStageFee.setUpdateDate(date);
						contractStageFee.setUpdateUser(user);
						contractStageFee.setCreateDate(date);
						contractStageFee.setCreateUser(user);
						contractStageFeeDAO.add(contractStageFee);

						CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
						otherFee.setCostType(contractStageFee.getCostType());
						otherFee.setDefaultValue(contractStageFee.getFee());
						otherFee.setValue(contractStageFee.getFee());
						otherFee.setRepayment(contractRepayment0);
						otherFee.setCreateDate(date);
						otherFee.setCreateUser(user);
						otherFee.setUpdateDate(date);
						otherFee.setUpdateUser(user);
						cusContractRepaymentOtherFeeDAO.add(otherFee);

						if (contract.getContractManageValue() != 0) {
							ContractStageFee contractStageFee1 = new ContractStageFee();
							contractStageFee1.setCostType(costTypeDAO.getById(15));
							contractStageFee1.setFee(contract.getContractManageValue());
							contractStageFee1.setStage(contractStage0);
							contractStageFee1.setUpdateDate(date);
							contractStageFee1.setUpdateUser(user);
							contractStageFee1.setCreateDate(date);
							contractStageFee1.setCreateUser(user);
							contractStageFeeDAO.add(contractStageFee1);

							CusContractRepaymentOtherFee otherFee1 = new CusContractRepaymentOtherFee();
							otherFee1.setCostType(contractStageFee1.getCostType());
							otherFee1.setDefaultValue(contractStageFee1.getFee());
							otherFee1.setValue(contractStageFee1.getFee());
							otherFee1.setRepayment(contractRepayment0);
							otherFee1.setCreateDate(date);
							otherFee1.setCreateUser(user);
							otherFee1.setUpdateDate(date);
							otherFee1.setUpdateUser(user);
							cusContractRepaymentOtherFeeDAO.add(otherFee1);
						}

						if (stage > 1) {
							for (int i = 1; i < stage; i++) {
								cal.setTime(contract.getStartDate());
								cal1.setTime(contract.getStartDate());
								ContractStage contractStagei = new ContractStage();
								contractStagei.setStage(i);
								contractStagei.setContract(contract);
								contractStagei.setCapital(0);
								contractStagei.setInterest(interestAmount);

								contractStagei.setExtraCharges(contractGpsLateFeeDAO
										.findContractGpsLateFeeByCustomerContract(contract).getCostValue()
										* daysBetween(getCalendar(cal, i).getTime(), getCalendar(cal1, i + 1).getTime())
										+ contract.getContractManageValue());

								cal.setTime(contract.getStartDate());
								contractStagei.setRepaymentDate(getCalendar(cal, i).getTime());
								contractStagei.setRealrepaymentDate(contractStagei.getRepaymentDate());
								contractStagei.setUpdateDate(date);
								contractStagei.setUpdateUser(user);
								contractStagei.setCreateDate(date);
								contractStagei.setCreateUser(user);
								contractStageDAO.add(contractStagei);
								ContractStageFee contractStageFeei = new ContractStageFee();
								contractStageFeei.setCostType(costTypeDAO.getById(3));
								contractStageFeei.setFee(contractGpsLateFeeDAO
										.findContractGpsLateFeeByCustomerContract(contract).getCostValue()
										* daysBetween(getCalendar(cal, i).getTime(),
												getCalendar(cal1, i + 1).getTime()));
								contractStageFeei.setStage(contractStagei);
								contractStageFeei.setUpdateDate(date);
								contractStageFeei.setUpdateUser(user);
								contractStageFeei.setCreateDate(date);
								contractStageFeei.setCreateUser(user);
								contractStageFeeDAO.add(contractStageFeei);

								if (contract.getContractManageValue() != 0) {
									ContractStageFee contractStageFee1 = new ContractStageFee();
									contractStageFee1.setCostType(costTypeDAO.getById(15));
									contractStageFee1.setFee(contract.getContractManageValue());
									contractStageFee1.setStage(contractStagei);
									contractStageFee1.setUpdateDate(date);
									contractStageFee1.setUpdateUser(user);
									contractStageFee1.setCreateDate(date);
									contractStageFee1.setCreateUser(user);
									contractStageFeeDAO.add(contractStageFee1);
								}
							}
						}
						cal.setTime(contract.getStartDate());
						ContractStage contractStage = new ContractStage();
						contractStage.setStage(stage);
						contractStage.setContract(contract);
						contractStage.setCapital(principal);
						if (proRepayStage.getServiceFeeStage() != 0) {
							contractStage.setCapital(contract.getAmount());
						}
						contractStage.setInterest(0);
						contractStage.setExtraCharges(0);
						contractStage.setRepaymentDate(getCalendar(cal, stage).getTime());
						contractStage.setRealrepaymentDate(contractStage.getRepaymentDate());
						contractStage.setUpdateDate(date);
						contractStage.setUpdateUser(user);
						contractStage.setCreateDate(date);
						contractStage.setCreateUser(user);
						contractStageDAO.add(contractStage);
						return true;
					} else if (parkingFee.getParkingType().equals("月租")) {
						double principal = contract.getAmount();
						if (proRepayStage.getServiceFeeStage() != 0) {
							principal = contract.getAmount() + contract.getAmount() * (preValue / 100) * stage;
						}
						double interest = contractParaDAO.findValueByContractAndPara(contract,
								productParameterDAO.getById(2));
						double interestAmount = Double.valueOf(df.format(contract.getAmount() * interest / 100));
						CustomerContract customerContract = customerContractDAO.getById(contract.getId());
						customerContract.setPrincipal(principal);
						customerContract.setUpdateDate(date);
						customerContract.setUpdateUser(user);
						customerContractDAO.update(customerContract);
						ContractStage contractStage0 = new ContractStage();

						contractStage0.setStage(0);
						contractStage0.setContract(contract);
						contractStage0.setCapital(0);
						contractStage0.setState(1);
						contractStage0.setInterest(interestAmount);
						contractStage0.setExtraCharges(gpsinstall.getCostValue() + contract.getContractManageValue());
						contractStage0.setRepaymentDate(cal.getTime());
						contractStage0.setRealrepaymentDate(contractStage0.getRepaymentDate());
						contractStage0.setUpdateDate(date);
						contractStage0.setUpdateUser(user);
						contractStage0.setCreateDate(date);
						contractStage0.setCreateUser(user);
						contractStageDAO.add(contractStage0);

						ContractRepayment contractRepayment0 = new ContractRepayment();
						contractRepayment0.setCapital(contractStage0.getCapital());
						contractRepayment0.setInterest(contractStage0.getInterest());
						contractRepayment0.setPayment(contract.getName());
						contractRepayment0.setRepaymentDate(contractStage0.getRepaymentDate());
						contractRepayment0.setExtraCharges(contractStage0.getExtraCharges());
						contractRepayment0.setRepaymentFee(contractStage0.getCapital() + contractStage0.getInterest()
								+ contractStage0.getExtraCharges());
						contractRepayment0.setStage(contractStage0);
						contractRepayment0.setCreateDate(date);
						contractRepayment0.setCreateUser(user);
						contractRepayment0.setUpdateDate(date);
						contractRepayment0.setUpdateUser(user);
						contractRepayment0.setState(1);
						contractRepaymentDAO.add(contractRepayment0);

						List<CusContractCost> costs = cusContractCostDAO.getCusContractCostByContract(contract);
						for (CusContractCost cost : costs) {
							ContractStageFee contractStageFee = new ContractStageFee();
							contractStageFee.setCostType(cost.getCostType());
							contractStageFee.setFee(cost.getValue());
							contractStageFee.setStage(contractStage0);
							contractStageFee.setUpdateDate(date);
							contractStageFee.setUpdateUser(user);
							contractStageFee.setCreateDate(date);
							contractStageFee.setCreateUser(user);
							contractStageFeeDAO.add(contractStageFee);

							CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
							otherFee.setCostType(contractStageFee.getCostType());
							otherFee.setCreateDate(date);
							otherFee.setCreateUser(user);
							otherFee.setDefaultValue(contractStageFee.getFee());
							otherFee.setRepayment(contractRepayment0);
							otherFee.setUpdateDate(date);
							otherFee.setUpdateUser(user);
							otherFee.setValue(contractStageFee.getFee());
							cusContractRepaymentOtherFeeDAO.add(otherFee);
						}
						ContractStageFee contractStageFee = new ContractStageFee();
						contractStageFee.setCostType(costTypeDAO.getById(3));
						contractStageFee.setFee(gpsinstall.getCostValue());
						contractStageFee.setStage(contractStage0);
						contractStageFee.setUpdateDate(date);
						contractStageFee.setUpdateUser(user);
						contractStageFee.setCreateDate(date);
						contractStageFee.setCreateUser(user);
						contractStageFeeDAO.add(contractStageFee);

						CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
						otherFee.setCostType(contractStageFee.getCostType());
						otherFee.setDefaultValue(contractStageFee.getFee());
						otherFee.setValue(contractStageFee.getFee());
						otherFee.setRepayment(contractRepayment0);
						otherFee.setCreateDate(date);
						otherFee.setCreateUser(user);
						otherFee.setUpdateDate(date);
						otherFee.setUpdateUser(user);
						cusContractRepaymentOtherFeeDAO.add(otherFee);

						if (contract.getContractManageValue() != 0) {
							ContractStageFee contractStageFee1 = new ContractStageFee();
							contractStageFee1.setCostType(costTypeDAO.getById(15));
							contractStageFee1.setFee(contract.getContractManageValue());
							contractStageFee1.setStage(contractStage0);
							contractStageFee1.setUpdateDate(date);
							contractStageFee1.setUpdateUser(user);
							contractStageFee1.setCreateDate(date);
							contractStageFee1.setCreateUser(user);
							contractStageFeeDAO.add(contractStageFee1);

							CusContractRepaymentOtherFee otherFee1 = new CusContractRepaymentOtherFee();
							otherFee1.setCostType(contractStageFee1.getCostType());
							otherFee1.setDefaultValue(contractStageFee1.getFee());
							otherFee1.setValue(contractStageFee1.getFee());
							otherFee1.setRepayment(contractRepayment0);
							otherFee1.setCreateDate(date);
							otherFee1.setCreateUser(user);
							otherFee1.setUpdateDate(date);
							otherFee1.setUpdateUser(user);
							cusContractRepaymentOtherFeeDAO.add(otherFee1);
						}
						if (stage > 1) {
							for (int i = 1; i < stage; i++) {
								cal.setTime(contract.getStartDate());
								ContractStage contractStagei = new ContractStage();
								contractStagei.setStage(i);
								contractStagei.setContract(contract);
								contractStagei.setCapital(0);
								contractStagei.setInterest(interestAmount);
								contractStagei
										.setExtraCharges(gpsinstall.getCostValue() + contract.getContractManageValue());
								contractStagei.setRepaymentDate(getCalendar(cal, i).getTime());
								contractStagei.setRealrepaymentDate(contractStagei.getRepaymentDate());
								contractStagei.setUpdateDate(date);
								contractStagei.setUpdateUser(user);
								contractStagei.setCreateDate(date);
								contractStagei.setCreateUser(user);
								contractStageDAO.add(contractStagei);
								ContractStageFee contractStageFeei = new ContractStageFee();
								contractStageFeei.setCostType(costTypeDAO.getById(3));
								contractStageFeei.setFee(gpsinstall.getCostValue());
								contractStageFeei.setStage(contractStagei);
								contractStageFeei.setUpdateDate(date);
								contractStageFeei.setUpdateUser(user);
								contractStageFeei.setCreateDate(date);
								contractStageFeei.setCreateUser(user);
								contractStageFeeDAO.add(contractStageFeei);

								if (contract.getContractManageValue() != 0) {
									ContractStageFee contractStageFee1 = new ContractStageFee();
									contractStageFee1.setCostType(costTypeDAO.getById(15));
									contractStageFee1.setFee(contract.getContractManageValue());
									contractStageFee1.setStage(contractStagei);
									contractStageFee1.setUpdateDate(date);
									contractStageFee1.setUpdateUser(user);
									contractStageFee1.setCreateDate(date);
									contractStageFee1.setCreateUser(user);
									contractStageFeeDAO.add(contractStageFee1);
								}
							}
						}
						cal.setTime(contract.getStartDate());
						ContractStage contractStage = new ContractStage();
						contractStage.setStage(stage);
						contractStage.setContract(contract);
						contractStage.setCapital(principal);
						if (proRepayStage.getServiceFeeStage() != 0) {
							contractStage.setCapital(contract.getAmount());
						}
						contractStage.setInterest(0);
						contractStage.setExtraCharges(0);
						contractStage.setRepaymentDate(getCalendar(cal, stage).getTime());
						contractStage.setRealrepaymentDate(contractStage.getRepaymentDate());
						contractStage.setUpdateDate(date);
						contractStage.setUpdateUser(user);
						contractStage.setCreateDate(date);
						contractStage.setCreateUser(user);
						contractStageDAO.add(contractStage);
						return true;
					} else if (parkingFee.getParkingType().equals("年租")) {
						double principal = contract.getAmount();
						if (proRepayStage.getServiceFeeStage() != 0) {
							principal = contract.getAmount() + contract.getAmount() * (preValue / 100) * stage;
						}
						double interest = contractParaDAO.findValueByContractAndPara(contract,
								productParameterDAO.getById(2));
						double interestAmount = Double.valueOf(df.format(contract.getAmount() * interest / 100));
						CustomerContract customerContract = customerContractDAO.getById(contract.getId());
						customerContract.setPrincipal(principal);
						customerContract.setUpdateDate(date);
						customerContract.setUpdateUser(user);
						customerContractDAO.update(customerContract);
						ContractStage contractStage0 = new ContractStage();
						contractStage0.setStage(0);
						contractStage0.setContract(contract);
						contractStage0.setCapital(0);
						contractStage0.setState(1);
						contractStage0.setInterest(interestAmount);
						contractStage0.setExtraCharges(gpsinstall.getCostValue() + contract.getContractManageValue());
						contractStage0.setRepaymentDate(cal.getTime());
						contractStage0.setRealrepaymentDate(contractStage0.getRepaymentDate());
						contractStage0.setUpdateDate(date);
						contractStage0.setUpdateUser(user);
						contractStage0.setCreateDate(date);
						contractStage0.setCreateUser(user);
						contractStageDAO.add(contractStage0);

						ContractRepayment contractRepayment0 = new ContractRepayment();
						contractRepayment0.setCapital(contractStage0.getCapital());
						contractRepayment0.setInterest(contractStage0.getInterest());
						contractRepayment0.setPayment(contract.getName());
						contractRepayment0.setRepaymentDate(contractStage0.getRepaymentDate());
						contractRepayment0.setExtraCharges(contractStage0.getExtraCharges());
						contractRepayment0.setRepaymentFee(contractStage0.getCapital() + contractStage0.getInterest()
								+ contractStage0.getExtraCharges());
						contractRepayment0.setStage(contractStage0);
						contractRepayment0.setCreateDate(date);
						contractRepayment0.setCreateUser(user);
						contractRepayment0.setUpdateDate(date);
						contractRepayment0.setUpdateUser(user);
						contractRepayment0.setState(1);
						contractRepaymentDAO.add(contractRepayment0);

						List<CusContractCost> costs = cusContractCostDAO.getCusContractCostByContract(contract);
						for (CusContractCost cost : costs) {
							ContractStageFee contractStageFee = new ContractStageFee();
							contractStageFee.setCostType(cost.getCostType());
							contractStageFee.setFee(cost.getValue());
							contractStageFee.setStage(contractStage0);
							contractStageFee.setUpdateDate(date);
							contractStageFee.setUpdateUser(user);
							contractStageFee.setCreateDate(date);
							contractStageFee.setCreateUser(user);
							contractStageFeeDAO.add(contractStageFee);

							CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
							otherFee.setCostType(contractStageFee.getCostType());
							otherFee.setCreateDate(date);
							otherFee.setCreateUser(user);
							otherFee.setDefaultValue(contractStageFee.getFee());
							otherFee.setRepayment(contractRepayment0);
							otherFee.setUpdateDate(date);
							otherFee.setUpdateUser(user);
							otherFee.setValue(contractStageFee.getFee());
							cusContractRepaymentOtherFeeDAO.add(otherFee);
						}
						ContractStageFee contractStageFee = new ContractStageFee();
						contractStageFee.setCostType(costTypeDAO.getById(3));
						contractStageFee.setFee(gpsinstall.getCostValue());
						contractStageFee.setStage(contractStage0);
						contractStageFee.setUpdateDate(date);
						contractStageFee.setUpdateUser(user);
						contractStageFee.setCreateDate(date);
						contractStageFee.setCreateUser(user);
						contractStageFeeDAO.add(contractStageFee);

						CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
						otherFee.setCostType(contractStageFee.getCostType());
						otherFee.setDefaultValue(contractStageFee.getFee());
						otherFee.setValue(contractStageFee.getFee());
						otherFee.setRepayment(contractRepayment0);
						otherFee.setCreateDate(date);
						otherFee.setCreateUser(user);
						otherFee.setUpdateDate(date);
						otherFee.setUpdateUser(user);
						cusContractRepaymentOtherFeeDAO.add(otherFee);

						if (contract.getContractManageValue() != 0) {
							ContractStageFee contractStageFee1 = new ContractStageFee();
							contractStageFee1.setCostType(costTypeDAO.getById(15));
							contractStageFee1.setFee(contract.getContractManageValue());
							contractStageFee1.setStage(contractStage0);
							contractStageFee1.setUpdateDate(date);
							contractStageFee1.setUpdateUser(user);
							contractStageFee1.setCreateDate(date);
							contractStageFee1.setCreateUser(user);
							contractStageFeeDAO.add(contractStageFee1);

							CusContractRepaymentOtherFee otherFee1 = new CusContractRepaymentOtherFee();
							otherFee1.setCostType(contractStageFee1.getCostType());
							otherFee1.setDefaultValue(contractStageFee1.getFee());
							otherFee1.setValue(contractStageFee1.getFee());
							otherFee1.setRepayment(contractRepayment0);
							otherFee1.setCreateDate(date);
							otherFee1.setCreateUser(user);
							otherFee1.setUpdateDate(date);
							otherFee1.setUpdateUser(user);
							cusContractRepaymentOtherFeeDAO.add(otherFee1);
						}
						if (stage > 1) {
							for (int i = 1; i < stage; i++) {
								cal.setTime(contract.getStartDate());
								ContractStage contractStagei = new ContractStage();
								contractStagei.setStage(i);
								contractStagei.setContract(contract);
								contractStagei.setCapital(0);
								contractStagei.setInterest(interestAmount);

								if (i % 12 == 11 && stage > i + 1) {
									contractStagei.setExtraCharges(
											gpsinstall.getCostValue() + contract.getContractManageValue());

								} else {
									contractStagei.setExtraCharges(0 + contract.getContractManageValue());
								}
								contractStagei.setRepaymentDate(getCalendar(cal, i).getTime());
								contractStagei.setRealrepaymentDate(contractStagei.getRepaymentDate());
								contractStagei.setUpdateDate(date);
								contractStagei.setUpdateUser(user);
								contractStagei.setCreateDate(date);
								contractStagei.setCreateUser(user);
								contractStageDAO.add(contractStagei);
								if (i % 12 == 11 && stage > i + 1) {
									ContractStageFee contractStageFeei = new ContractStageFee();
									contractStageFeei.setCostType(costTypeDAO.getById(3));
									contractStageFeei.setFee(gpsinstall.getCostValue());
									contractStageFeei.setStage(contractStagei);
									contractStageFeei.setUpdateDate(date);
									contractStageFeei.setUpdateUser(user);
									contractStageFeei.setCreateDate(date);
									contractStageFeei.setCreateUser(user);
									contractStageFeeDAO.add(contractStageFeei);
								}

								if (contract.getContractManageValue() != 0) {
									ContractStageFee contractStageFee1 = new ContractStageFee();
									contractStageFee1.setCostType(costTypeDAO.getById(15));
									contractStageFee1.setFee(contract.getContractManageValue());
									contractStageFee1.setStage(contractStagei);
									contractStageFee1.setUpdateDate(date);
									contractStageFee1.setUpdateUser(user);
									contractStageFee1.setCreateDate(date);
									contractStageFee1.setCreateUser(user);
									contractStageFeeDAO.add(contractStageFee1);
								}
							}
						}
						cal.setTime(contract.getStartDate());
						ContractStage contractStage = new ContractStage();
						contractStage.setStage(stage);
						contractStage.setContract(contract);
						contractStage.setCapital(principal);
						if (proRepayStage.getServiceFeeStage() != 0) {
							contractStage.setCapital(contract.getAmount());
						}
						contractStage.setInterest(0);
						contractStage.setExtraCharges(0);
						contractStage.setRepaymentDate(getCalendar(cal, stage).getTime());
						contractStage.setRealrepaymentDate(contractStage.getRepaymentDate());
						contractStage.setUpdateDate(date);
						contractStage.setUpdateUser(user);
						contractStage.setCreateDate(date);
						contractStage.setCreateUser(user);
						contractStageDAO.add(contractStage);
						return true;
					}
				}
			} else {
				for (ContractGpsLateFee gpsinstall : contractGpsLateFeeDAO
						.findContractGpsLateFeeListByCustomerContract(contract)) {
					GpsCostTypeService gpsCostTypeService = (GpsCostTypeService) SpringUtil
							.getBean("GpsCostTypeService");
					GpsCostType gpsCostType = gpsCostTypeService.getById(gpsinstall.getType().getId());
					if (gpsCostType.getGpsCostType().equals("年租")) {
						double principal = contract.getAmount();
						if (proRepayStage.getServiceFeeStage() != 0) {
							principal = contract.getAmount() + contract.getAmount() * (preValue / 100) * stage;
						}
						double interest = contractParaDAO.findValueByContractAndPara(contract,
								productParameterDAO.getById(2));
						double interestAmount = Double.valueOf(df.format(contract.getAmount() * interest / 100));
						CustomerContract customerContract = customerContractDAO.getById(contract.getId());
						customerContract.setPrincipal(principal);
						customerContract.setUpdateDate(date);
						customerContract.setUpdateUser(user);
						customerContractDAO.update(customerContract);
						ContractStage contractStage0 = new ContractStage();

						contractStage0.setStage(0);
						contractStage0.setContract(contract);
						contractStage0.setCapital(0);
						contractStage0.setState(1);
						contractStage0.setInterest(interestAmount);
						contractStage0.setExtraCharges(gpsinstall.getCostValue() + contract.getContractManageValue());
						contractStage0.setRepaymentDate(cal.getTime());
						contractStage0.setRealrepaymentDate(contractStage0.getRepaymentDate());
						contractStage0.setUpdateDate(date);
						contractStage0.setUpdateUser(user);
						contractStage0.setCreateDate(date);
						contractStage0.setCreateUser(user);
						contractStageDAO.add(contractStage0);

						ContractRepayment contractRepayment0 = new ContractRepayment();
						contractRepayment0.setCapital(contractStage0.getCapital());
						contractRepayment0.setInterest(contractStage0.getInterest());
						contractRepayment0.setPayment(contract.getName());
						contractRepayment0.setRepaymentDate(contractStage0.getRepaymentDate());
						contractRepayment0.setExtraCharges(contractStage0.getExtraCharges());
						contractRepayment0.setRepaymentFee(contractStage0.getCapital() + contractStage0.getInterest()
								+ contractStage0.getExtraCharges());
						contractRepayment0.setStage(contractStage0);
						contractRepayment0.setCreateDate(date);
						contractRepayment0.setCreateUser(user);
						contractRepayment0.setUpdateDate(date);
						contractRepayment0.setUpdateUser(user);
						contractRepayment0.setState(1);
						contractRepaymentDAO.add(contractRepayment0);

						List<CusContractCost> costs = cusContractCostDAO.getCusContractCostByContract(contract);
						for (CusContractCost cost : costs) {
							ContractStageFee contractStageFee = new ContractStageFee();
							contractStageFee.setCostType(cost.getCostType());
							contractStageFee.setFee(cost.getValue());
							contractStageFee.setStage(contractStage0);
							contractStageFee.setUpdateDate(date);
							contractStageFee.setUpdateUser(user);
							contractStageFee.setCreateDate(date);
							contractStageFee.setCreateUser(user);
							contractStageFeeDAO.add(contractStageFee);

							CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
							otherFee.setCostType(contractStageFee.getCostType());
							otherFee.setCreateDate(date);
							otherFee.setCreateUser(user);
							otherFee.setDefaultValue(contractStageFee.getFee());
							otherFee.setRepayment(contractRepayment0);
							otherFee.setUpdateDate(date);
							otherFee.setUpdateUser(user);
							otherFee.setValue(contractStageFee.getFee());
							cusContractRepaymentOtherFeeDAO.add(otherFee);
						}
						ContractStageFee contractStageFee = new ContractStageFee();
						contractStageFee.setCostType(costTypeDAO.getById(9));
						contractStageFee.setFee(gpsinstall.getCostValue());
						contractStageFee.setStage(contractStage0);
						contractStageFee.setUpdateDate(date);
						contractStageFee.setUpdateUser(user);
						contractStageFee.setCreateDate(date);
						contractStageFee.setCreateUser(user);
						contractStageFeeDAO.add(contractStageFee);

						CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
						otherFee.setCostType(contractStageFee.getCostType());
						otherFee.setDefaultValue(contractStageFee.getFee());
						otherFee.setValue(contractStageFee.getFee());
						otherFee.setRepayment(contractRepayment0);
						otherFee.setCreateDate(date);
						otherFee.setCreateUser(user);
						otherFee.setUpdateDate(date);
						otherFee.setUpdateUser(user);
						cusContractRepaymentOtherFeeDAO.add(otherFee);

						if (contract.getContractManageValue() != 0) {
							ContractStageFee contractStageFee1 = new ContractStageFee();
							contractStageFee1.setCostType(costTypeDAO.getById(15));
							contractStageFee1.setFee(contract.getContractManageValue());
							contractStageFee1.setStage(contractStage0);
							contractStageFee1.setUpdateDate(date);
							contractStageFee1.setUpdateUser(user);
							contractStageFee1.setCreateDate(date);
							contractStageFee1.setCreateUser(user);
							contractStageFeeDAO.add(contractStageFee1);

							CusContractRepaymentOtherFee otherFee1 = new CusContractRepaymentOtherFee();
							otherFee1.setCostType(contractStageFee1.getCostType());
							otherFee1.setDefaultValue(contractStageFee1.getFee());
							otherFee1.setValue(contractStageFee1.getFee());
							otherFee1.setRepayment(contractRepayment0);
							otherFee1.setCreateDate(date);
							otherFee1.setCreateUser(user);
							otherFee1.setUpdateDate(date);
							otherFee1.setUpdateUser(user);
							cusContractRepaymentOtherFeeDAO.add(otherFee1);
						}
						if (stage > 1) {
							for (int i = 1; i < stage; i++) {
								cal.setTime(contract.getStartDate());
								ContractStage contractStagei = new ContractStage();
								contractStagei.setStage(i);
								contractStagei.setContract(contract);
								contractStagei.setCapital(0);
								contractStagei.setInterest(interestAmount);
								if (i % 12 == 11 && stage > i + 1) {
									contractStagei.setExtraCharges(gpsinstall.getCostValue());

								} else {
									contractStagei.setExtraCharges(0);
								}
								contractStagei.setRepaymentDate(getCalendar(cal, i).getTime());
								contractStagei.setRealrepaymentDate(contractStagei.getRepaymentDate());
								contractStagei.setUpdateDate(date);
								contractStagei.setUpdateUser(user);
								contractStagei.setCreateDate(date);
								contractStagei.setCreateUser(user);
								contractStageDAO.add(contractStagei);
								if (i % 12 == 11 && stage > i + 1) {
									ContractStageFee contractStageFeei = new ContractStageFee();
									contractStageFeei.setCostType(costTypeDAO.getById(9));
									contractStageFeei.setFee(gpsinstall.getCostValue());
									contractStageFeei.setStage(contractStagei);
									contractStageFeei.setUpdateDate(date);
									contractStageFeei.setUpdateUser(user);
									contractStageFeei.setCreateDate(date);
									contractStageFeei.setCreateUser(user);
									contractStageFeeDAO.add(contractStageFeei);
								}
								if (contract.getContractManageValue() != 0) {
									ContractStageFee contractStageFeei = new ContractStageFee();
									contractStageFeei.setCostType(costTypeDAO.getById(15));
									contractStageFeei.setFee(contract.getContractManageValue());
									contractStageFeei.setStage(contractStagei);
									contractStageFeei.setUpdateDate(date);
									contractStageFeei.setUpdateUser(user);
									contractStageFeei.setCreateDate(date);
									contractStageFeei.setCreateUser(user);
									contractStageFeeDAO.add(contractStageFeei);
								}
							}
						}
						cal.setTime(contract.getStartDate());
						ContractStage contractStage = new ContractStage();
						contractStage.setStage(stage);
						contractStage.setContract(contract);
						contractStage.setCapital(principal);
						if (proRepayStage.getServiceFeeStage() != 0) {
							contractStage.setCapital(contract.getAmount());
						}
						contractStage.setInterest(0);
						contractStage.setExtraCharges(0);
						contractStage.setRepaymentDate(getCalendar(cal, stage).getTime());
						contractStage.setRealrepaymentDate(contractStage.getRepaymentDate());
						contractStage.setUpdateDate(date);
						contractStage.setUpdateUser(user);
						contractStage.setCreateDate(date);
						contractStage.setCreateUser(user);
						contractStageDAO.add(contractStage);
						return true;
					} else if (gpsCostType.getGpsCostType().equals("月租")) {
						double principal = contract.getAmount();
						if (proRepayStage.getServiceFeeStage() != 0) {
							principal = contract.getAmount() + contract.getAmount() * (preValue / 100) * stage;
						}
						double interest = contractParaDAO.findValueByContractAndPara(contract,
								productParameterDAO.getById(2));
						double interestAmount = Double.valueOf(df.format(contract.getAmount() * interest / 100));
						CustomerContract customerContract = customerContractDAO.getById(contract.getId());
						customerContract.setPrincipal(principal);
						customerContract.setUpdateDate(date);
						customerContract.setUpdateUser(user);
						customerContractDAO.update(customerContract);
						ContractStage contractStage0 = new ContractStage();

						contractStage0.setStage(0);
						contractStage0.setContract(contract);
						contractStage0.setCapital(0);
						contractStage0.setState(1);
						contractStage0.setInterest(interestAmount);
						contractStage0.setExtraCharges(gpsinstall.getCostValue() + contract.getContractManageValue());
						contractStage0.setRepaymentDate(cal.getTime());
						contractStage0.setRealrepaymentDate(contractStage0.getRepaymentDate());
						contractStage0.setUpdateDate(date);
						contractStage0.setUpdateUser(user);
						contractStage0.setCreateDate(date);
						contractStage0.setCreateUser(user);
						contractStageDAO.add(contractStage0);

						ContractRepayment contractRepayment0 = new ContractRepayment();
						contractRepayment0.setCapital(contractStage0.getCapital());
						contractRepayment0.setInterest(contractStage0.getInterest());
						contractRepayment0.setPayment(contract.getName());
						contractRepayment0.setRepaymentDate(contractStage0.getRepaymentDate());
						contractRepayment0.setExtraCharges(contractStage0.getExtraCharges());
						contractRepayment0.setRepaymentFee(contractStage0.getCapital() + contractStage0.getInterest()
								+ contractStage0.getExtraCharges());
						contractRepayment0.setStage(contractStage0);
						contractRepayment0.setCreateDate(date);
						contractRepayment0.setCreateUser(user);
						contractRepayment0.setUpdateDate(date);
						contractRepayment0.setUpdateUser(user);
						contractRepayment0.setState(1);
						contractRepaymentDAO.add(contractRepayment0);

						List<CusContractCost> costs = cusContractCostDAO.getCusContractCostByContract(contract);
						for (CusContractCost cost : costs) {
							ContractStageFee contractStageFee = new ContractStageFee();
							contractStageFee.setCostType(cost.getCostType());
							contractStageFee.setFee(cost.getValue());
							contractStageFee.setStage(contractStage0);
							contractStageFee.setUpdateDate(date);
							contractStageFee.setUpdateUser(user);
							contractStageFee.setCreateDate(date);
							contractStageFee.setCreateUser(user);
							contractStageFeeDAO.add(contractStageFee);

							CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
							otherFee.setCostType(contractStageFee.getCostType());
							otherFee.setCreateDate(date);
							otherFee.setCreateUser(user);
							otherFee.setDefaultValue(contractStageFee.getFee());
							otherFee.setRepayment(contractRepayment0);
							otherFee.setUpdateDate(date);
							otherFee.setUpdateUser(user);
							otherFee.setValue(contractStageFee.getFee());
							cusContractRepaymentOtherFeeDAO.add(otherFee);
						}
						ContractStageFee contractStageFee = new ContractStageFee();
						contractStageFee.setCostType(costTypeDAO.getById(9));
						contractStageFee.setFee(gpsinstall.getCostValue());
						contractStageFee.setStage(contractStage0);
						contractStageFee.setUpdateDate(date);
						contractStageFee.setUpdateUser(user);
						contractStageFee.setCreateDate(date);
						contractStageFee.setCreateUser(user);
						contractStageFeeDAO.add(contractStageFee);

						CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
						otherFee.setCostType(contractStageFee.getCostType());
						otherFee.setDefaultValue(contractStageFee.getFee());
						otherFee.setValue(contractStageFee.getFee());
						otherFee.setRepayment(contractRepayment0);
						otherFee.setCreateDate(date);
						otherFee.setCreateUser(user);
						otherFee.setUpdateDate(date);
						otherFee.setUpdateUser(user);
						cusContractRepaymentOtherFeeDAO.add(otherFee);

						if (contract.getContractManageValue() != 0) {
							ContractStageFee contractStageFee1 = new ContractStageFee();
							contractStageFee1.setCostType(costTypeDAO.getById(15));
							contractStageFee1.setFee(contract.getContractManageValue());
							contractStageFee1.setStage(contractStage0);
							contractStageFee1.setUpdateDate(date);
							contractStageFee1.setUpdateUser(user);
							contractStageFee1.setCreateDate(date);
							contractStageFee1.setCreateUser(user);
							contractStageFeeDAO.add(contractStageFee1);

							CusContractRepaymentOtherFee otherFee1 = new CusContractRepaymentOtherFee();
							otherFee1.setCostType(contractStageFee1.getCostType());
							otherFee1.setDefaultValue(contractStageFee1.getFee());
							otherFee1.setValue(contractStageFee1.getFee());
							otherFee1.setRepayment(contractRepayment0);
							otherFee1.setCreateDate(date);
							otherFee1.setCreateUser(user);
							otherFee1.setUpdateDate(date);
							otherFee1.setUpdateUser(user);
							cusContractRepaymentOtherFeeDAO.add(otherFee1);
						}
						if (stage > 1) {
							for (int i = 1; i < stage; i++) {
								cal.setTime(contract.getStartDate());
								ContractStage contractStagei = new ContractStage();
								contractStagei.setStage(i);
								contractStagei.setContract(contract);
								contractStagei.setCapital(0);
								contractStagei.setInterest(interestAmount);
								contractStagei.setExtraCharges(gpsinstall.getCostValue());
								contractStagei.setRepaymentDate(getCalendar(cal, i).getTime());
								contractStagei.setRealrepaymentDate(contractStagei.getRepaymentDate());
								contractStagei.setUpdateDate(date);
								contractStagei.setUpdateUser(user);
								contractStagei.setCreateDate(date);
								contractStagei.setCreateUser(user);
								contractStageDAO.add(contractStagei);
								ContractStageFee contractStageFeei = new ContractStageFee();
								contractStageFeei.setCostType(costTypeDAO.getById(9));
								contractStageFeei.setFee(gpsinstall.getCostValue());
								contractStageFeei.setStage(contractStagei);
								contractStageFeei.setUpdateDate(date);
								contractStageFeei.setUpdateUser(user);
								contractStageFeei.setCreateDate(date);
								contractStageFeei.setCreateUser(user);
								contractStageFeeDAO.add(contractStageFeei);
								if (contract.getContractManageValue() != 0) {
									ContractStageFee contractStageFee1 = new ContractStageFee();
									contractStageFee1.setCostType(costTypeDAO.getById(15));
									contractStageFee1.setFee(contract.getContractManageValue());
									contractStageFee1.setStage(contractStagei);
									contractStageFee1.setUpdateDate(date);
									contractStageFee1.setUpdateUser(user);
									contractStageFee1.setCreateDate(date);
									contractStageFee1.setCreateUser(user);
									contractStageFeeDAO.add(contractStageFee1);
								}
							}
						}
						cal.setTime(contract.getStartDate());
						ContractStage contractStage = new ContractStage();
						contractStage.setStage(stage);
						contractStage.setContract(contract);
						contractStage.setCapital(principal);
						if (proRepayStage.getServiceFeeStage() != 0) {
							contractStage.setCapital(contract.getAmount());
						}
						contractStage.setInterest(0);
						contractStage.setExtraCharges(0);
						contractStage.setRepaymentDate(getCalendar(cal, stage).getTime());
						contractStage.setRealrepaymentDate(contractStage.getRepaymentDate());
						contractStage.setUpdateDate(date);
						contractStage.setUpdateUser(user);
						contractStage.setCreateDate(date);
						contractStage.setCreateUser(user);
						contractStageDAO.add(contractStage);
						return true;
					}
				}
			}
		}
		return true;
	}

	/**
	 * @category 计算分期
	 * @deprecated 计算分期方法抽离成接口,不推荐使用
	 * @param contract
	 * @return
	 * @throws DAOException
	 * @throws DataNotFoundException
	 * @throws Exception
	 */
	public boolean addContractStage(CustomerContract contract) throws DAOException, DataNotFoundException, Exception {
		User sessionUser = UserSession.getUser();
		if (sessionUser == null) {
			return false;
		}
		Timestamp date = new Timestamp(System.currentTimeMillis());
		String user = sessionUser.getLoginName();

		/* 分期期数 */
		RepaymentStageService repaymentStageService = (RepaymentStageService) SpringUtil
				.getBean("RepaymentStageService");
		RepaymentStage repaymentStage = repaymentStageService.getById(contract.getStage().getId());
		int stage = repaymentStage.getRepaymentStage();

		Calendar cal = Calendar.getInstance();
		cal.setTime(contract.getStartDate());
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(contract.getStartDate());

		List<ContractPara> paras = contractParaDAO.getContractParaByContract(contract);
		DecimalFormat df = new DecimalFormat("#.00");
		for (ContractPara para : paras) {
			if (para.getPara().getId() == 1) {
				// 没GPS费
				if (contractGpsLateFeeDAO.getCountByCustomerContract(contract) == 0) {
					for (ContractGpsLateFee gpsinstall : contractGpsLateFeeDAO
							.findContractGpsLateFeeListByCustomerContract(contract)) {
						ParkingFeeService parkingFeeService = (ParkingFeeService) SpringUtil
								.getBean("ParkingFeeService");
						ParkingFee parkingFee = parkingFeeService.getById(gpsinstall.getParkingFee().getId());
						if (parkingFee.getParkingType().equals("日租")) {
							double preValue = contractParaDAO.findValueByContractAndPara(contract,
									productParameterDAO.getById(1));
							double principal = contract.getAmount() + contract.getAmount() * (preValue / 100) * stage;// 本金
							double perPrincipal = Double.valueOf(df.format(principal / stage));// 每期本金
							double interest = contractParaDAO.findValueByContractAndPara(contract,
									productParameterDAO.getById(2));// 利息率
							double interestAmount = Double.valueOf(df.format(contract.getAmount() * interest / 100));// 每期利息
							CustomerContract customerContract = customerContractDAO.getById(contract.getId());
							customerContract.setPrincipal(principal);
							customerContract.setUpdateDate(date);
							customerContract.setUpdateUser(user);
							customerContractDAO.update(customerContract);
							ContractStage contractStage0 = new ContractStage();
							contractStage0.setStage(0);
							contractStage0.setContract(contract);
							contractStage0.setCapital(0);
							contractStage0.setInterest(interestAmount);
							contractStage0.setState(1);
							contractStage0.setExtraCharges(contractGpsLateFeeDAO
									.findContractGpsLateFeeByCustomerContract(contract).getCostValue()
									* daysBetween(getCalendar(cal, 0).getTime(), getCalendar(cal1, 1).getTime())
									+ contract.getContractManageValue());

							cal.setTime(contract.getStartDate());
							contractStage0.setRepaymentDate(cal.getTime());
							contractStage0.setRealrepaymentDate(contractStage0.getRepaymentDate());
							contractStage0.setUpdateDate(date);
							contractStage0.setUpdateUser(user);
							contractStage0.setCreateDate(date);
							contractStage0.setCreateUser(user);
							contractStageDAO.add(contractStage0);

							ContractRepayment contractRepayment0 = new ContractRepayment();
							contractRepayment0.setCapital(contractStage0.getCapital());
							contractRepayment0.setInterest(contractStage0.getInterest());
							contractRepayment0.setPayment(contract.getName());
							contractRepayment0.setRepaymentDate(contractStage0.getRepaymentDate());
							contractRepayment0.setExtraCharges(contractStage0.getExtraCharges());
							contractRepayment0
									.setRepaymentFee(contractStage0.getCapital() + contractStage0.getInterest());
							contractRepayment0.setStage(contractStage0);
							contractRepayment0.setCreateDate(date);
							contractRepayment0.setCreateUser(user);
							contractRepayment0.setUpdateDate(date);
							contractRepayment0.setUpdateUser(user);
							contractRepayment0.setState(1);
							contractRepaymentDAO.add(contractRepayment0);

							List<CusContractCost> costs = cusContractCostDAO.getCusContractCostByContract(contract);
							for (CusContractCost cost : costs) {
								ContractStageFee contractStageFee = new ContractStageFee();
								contractStageFee.setCostType(cost.getCostType());
								contractStageFee.setFee(cost.getValue());
								contractStageFee.setStage(contractStage0);
								contractStageFee.setUpdateDate(date);
								contractStageFee.setUpdateUser(user);
								contractStageFee.setCreateDate(date);
								contractStageFee.setCreateUser(user);
								contractStageFeeDAO.add(contractStageFee);

								CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
								otherFee.setCostType(contractStageFee.getCostType());
								otherFee.setCreateDate(date);
								otherFee.setCreateUser(user);
								otherFee.setDefaultValue(contractStageFee.getFee());
								otherFee.setRepayment(contractRepayment0);
								otherFee.setUpdateDate(date);
								otherFee.setUpdateUser(user);
								otherFee.setValue(contractStageFee.getFee());
								cusContractRepaymentOtherFeeDAO.add(otherFee);
							}
							ContractStageFee contractStageFee = new ContractStageFee();
							contractStageFee.setCostType(costTypeDAO.getById(3));
							contractStageFee.setFee(contractGpsLateFeeDAO
									.findContractGpsLateFeeByCustomerContract(contract).getCostValue()
									* daysBetween(getCalendar(cal, 0).getTime(), getCalendar(cal1, 1).getTime()));
							contractStageFee.setStage(contractStage0);
							contractStageFee.setUpdateDate(date);
							contractStageFee.setUpdateUser(user);
							contractStageFeeDAO.add(contractStageFee);

							CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
							otherFee.setCostType(contractStageFee.getCostType());
							otherFee.setDefaultValue(contractStageFee.getFee());
							otherFee.setValue(contractStageFee.getFee());
							otherFee.setRepayment(contractRepayment0);
							otherFee.setCreateDate(date);
							otherFee.setCreateUser(user);
							otherFee.setUpdateDate(date);
							otherFee.setUpdateUser(user);
							cusContractRepaymentOtherFeeDAO.add(otherFee);

							if (contract.getContractManageValue() != 0) {
								ContractStageFee contractStageFee1 = new ContractStageFee();
								contractStageFee1.setCostType(costTypeDAO.getById(15));
								contractStageFee1.setFee(contract.getContractManageValue());
								contractStageFee1.setStage(contractStage0);
								contractStageFee1.setUpdateDate(date);
								contractStageFee1.setUpdateUser(user);
								contractStageFee1.setCreateDate(date);
								contractStageFee1.setCreateUser(user);
								contractStageFeeDAO.add(contractStageFee1);

								CusContractRepaymentOtherFee otherFee1 = new CusContractRepaymentOtherFee();
								otherFee1.setCostType(contractStageFee1.getCostType());
								otherFee1.setDefaultValue(contractStageFee1.getFee());
								otherFee1.setValue(contractStageFee1.getFee());
								otherFee1.setRepayment(contractRepayment0);
								otherFee1.setCreateDate(date);
								otherFee1.setCreateUser(user);
								otherFee1.setUpdateDate(date);
								otherFee1.setUpdateUser(user);
								cusContractRepaymentOtherFeeDAO.add(otherFee1);
							}

							if (stage > 1) {
								for (int i = 1; i < stage; i++) {
									cal.setTime(contract.getStartDate());
									cal1.setTime(contract.getStartDate());
									ContractStage contractStagei = new ContractStage();
									contractStagei.setStage(i);
									contractStagei.setContract(contract);
									contractStagei.setCapital(perPrincipal);
									contractStagei.setInterest(interestAmount);
									contractStagei.setUpdateDate(date);
									contractStagei.setUpdateUser(user);
									contractStagei.setCreateDate(date);
									contractStagei.setCreateUser(user);
									contractStagei.setExtraCharges(
											(contractGpsLateFeeDAO.findContractGpsLateFeeByCustomerContract(contract))
													.getCostValue()
													* daysBetween(getCalendar(cal, i).getTime(),
															getCalendar(cal1, i + 1).getTime())
													+ contract.getContractManageValue());

									cal.setTime(contract.getStartDate());
									contractStagei.setRepaymentDate(getCalendar(cal, i).getTime());
									contractStagei.setRealrepaymentDate(contractStagei.getRepaymentDate());
									contractStageDAO.add(contractStagei);
									ContractStageFee contractStageFeei = new ContractStageFee();
									contractStageFeei.setCostType(costTypeDAO.getById(3));
									contractStageFeei.setFee(
											(contractGpsLateFeeDAO.findContractGpsLateFeeByCustomerContract(contract))
													.getCostValue()
													* daysBetween(getCalendar(cal, i).getTime(),
															getCalendar(cal1, i + 1).getTime()));
									contractStageFeei.setStage(contractStagei);
									contractStageFeei.setUpdateDate(date);
									contractStageFeei.setUpdateUser(user);
									contractStageFeei.setCreateDate(date);
									contractStageFeei.setCreateUser(user);
									contractStageFeeDAO.add(contractStageFeei);

									if (contract.getContractManageValue() != 0) {
										ContractStageFee contractStageFee1 = new ContractStageFee();
										contractStageFee1.setCostType(costTypeDAO.getById(15));
										contractStageFee1.setFee(contract.getContractManageValue());
										contractStageFee1.setStage(contractStagei);
										contractStageFee1.setUpdateDate(date);
										contractStageFee1.setUpdateUser(user);
										contractStageFee1.setCreateDate(date);
										contractStageFee1.setCreateUser(user);
										contractStageFeeDAO.add(contractStageFee1);
									}
								}
							}
							cal.setTime(contract.getStartDate());
							ContractStage contractStage = new ContractStage();
							double lastPrincipal = principal - perPrincipal * (stage - 1);
							contractStage.setStage(stage);
							contractStage.setContract(contract);
							contractStage.setCapital(lastPrincipal);
							contractStage.setInterest(0);
							contractStage.setExtraCharges(0);
							contractStage.setRepaymentDate(getCalendar(cal, stage).getTime());
							contractStage.setRealrepaymentDate(contractStage.getRepaymentDate());
							contractStage.setUpdateDate(date);
							contractStage.setUpdateUser(user);
							contractStage.setCreateDate(date);
							contractStage.setCreateUser(user);
							contractStageDAO.add(contractStage);
							return true;
						} else if (parkingFee.getParkingType().equals("月租")) {
							double preValue = contractParaDAO.findValueByContractAndPara(contract,
									productParameterDAO.getById(1));
							double principal = contract.getAmount() + contract.getAmount() * (preValue / 100) * stage;
							double perPrincipal = Double.valueOf(df.format(principal / stage));
							double interest = contractParaDAO.findValueByContractAndPara(contract,
									productParameterDAO.getById(2));
							double interestAmount = Double.valueOf(df.format(contract.getAmount() * interest / 100));
							CustomerContract customerContract = customerContractDAO.getById(contract.getId());
							customerContract.setPrincipal(principal);
							customerContract.setUpdateDate(date);
							customerContract.setUpdateUser(user);
							customerContractDAO.update(customerContract);
							ContractStage contractStage0 = new ContractStage();

							contractStage0.setStage(0);
							contractStage0.setContract(contract);
							contractStage0.setCapital(0);
							contractStage0.setState(1);
							contractStage0.setInterest(interestAmount);
							contractStage0
									.setExtraCharges(gpsinstall.getCostValue() + contract.getContractManageValue());
							contractStage0.setRepaymentDate(cal.getTime());
							contractStage0.setRealrepaymentDate(contractStage0.getRepaymentDate());
							contractStage0.setUpdateDate(date);
							contractStage0.setUpdateUser(user);
							contractStage0.setCreateDate(date);
							contractStage0.setCreateUser(user);
							contractStageDAO.add(contractStage0);

							ContractRepayment contractRepayment0 = new ContractRepayment();
							contractRepayment0.setCapital(contractStage0.getCapital());
							contractRepayment0.setInterest(contractStage0.getInterest());
							contractRepayment0.setPayment(contract.getName());
							contractRepayment0.setRepaymentDate(contractStage0.getRepaymentDate());
							contractRepayment0.setExtraCharges(contractStage0.getExtraCharges());
							contractRepayment0
									.setRepaymentFee(contractStage0.getCapital() + contractStage0.getInterest());
							contractRepayment0.setStage(contractStage0);
							contractRepayment0.setCreateDate(date);
							contractRepayment0.setCreateUser(user);
							contractRepayment0.setUpdateDate(date);
							contractRepayment0.setUpdateUser(user);
							contractRepayment0.setState(1);
							contractRepaymentDAO.add(contractRepayment0);

							List<CusContractCost> costs = cusContractCostDAO.getCusContractCostByContract(contract);
							for (CusContractCost cost : costs) {
								ContractStageFee contractStageFee = new ContractStageFee();
								contractStageFee.setCostType(cost.getCostType());
								contractStageFee.setFee(cost.getValue());
								contractStageFee.setStage(contractStage0);
								contractStageFee.setUpdateDate(date);
								contractStageFee.setUpdateUser(user);
								contractStageFee.setCreateDate(date);
								contractStageFee.setCreateUser(user);
								contractStageFeeDAO.add(contractStageFee);

								CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
								otherFee.setCostType(contractStageFee.getCostType());
								otherFee.setCreateDate(date);
								otherFee.setCreateUser(user);
								otherFee.setDefaultValue(contractStageFee.getFee());
								otherFee.setRepayment(contractRepayment0);
								otherFee.setUpdateDate(date);
								otherFee.setUpdateUser(user);
								otherFee.setValue(contractStageFee.getFee());
								cusContractRepaymentOtherFeeDAO.add(otherFee);
							}
							ContractStageFee contractStageFee = new ContractStageFee();
							contractStageFee.setCostType(costTypeDAO.getById(3));
							contractStageFee.setFee(gpsinstall.getCostValue());
							contractStageFee.setStage(contractStage0);
							contractStageFee.setUpdateDate(date);
							contractStageFee.setUpdateUser(user);
							contractStageFee.setCreateDate(date);
							contractStageFee.setCreateUser(user);
							contractStageFeeDAO.add(contractStageFee);

							CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
							otherFee.setCostType(contractStageFee.getCostType());
							otherFee.setDefaultValue(contractStageFee.getFee());
							otherFee.setValue(contractStageFee.getFee());
							otherFee.setRepayment(contractRepayment0);
							otherFee.setCreateDate(date);
							otherFee.setCreateUser(user);
							otherFee.setUpdateDate(date);
							otherFee.setUpdateUser(user);
							cusContractRepaymentOtherFeeDAO.add(otherFee);

							if (contract.getContractManageValue() != 0) {
								ContractStageFee contractStageFee1 = new ContractStageFee();
								contractStageFee1.setCostType(costTypeDAO.getById(15));
								contractStageFee1.setFee(contract.getContractManageValue());
								contractStageFee1.setStage(contractStage0);
								contractStageFee1.setUpdateDate(date);
								contractStageFee1.setUpdateUser(user);
								contractStageFee1.setCreateDate(date);
								contractStageFee1.setCreateUser(user);
								contractStageFeeDAO.add(contractStageFee1);

								CusContractRepaymentOtherFee otherFee1 = new CusContractRepaymentOtherFee();
								otherFee1.setCostType(contractStageFee1.getCostType());
								otherFee1.setDefaultValue(contractStageFee1.getFee());
								otherFee1.setValue(contractStageFee1.getFee());
								otherFee1.setRepayment(contractRepayment0);
								otherFee1.setCreateDate(date);
								otherFee1.setCreateUser(user);
								otherFee1.setUpdateDate(date);
								otherFee1.setUpdateUser(user);
								cusContractRepaymentOtherFeeDAO.add(otherFee1);
							}

							if (stage > 1) {
								for (int i = 1; i < stage; i++) {
									cal.setTime(contract.getStartDate());
									ContractStage contractStagei = new ContractStage();
									contractStagei.setStage(i);
									contractStagei.setContract(contract);
									contractStagei.setCapital(perPrincipal);
									contractStagei.setInterest(interestAmount);
									contractStagei.setExtraCharges(gpsinstall.getCostValue());
									contractStagei.setRepaymentDate(getCalendar(cal, i).getTime());
									contractStagei.setRealrepaymentDate(contractStagei.getRepaymentDate());
									contractStagei.setUpdateDate(date);
									contractStagei.setUpdateUser(user);
									contractStagei.setCreateDate(date);
									contractStagei.setCreateUser(user);
									contractStageDAO.add(contractStagei);
									ContractStageFee contractStageFeei = new ContractStageFee();
									contractStageFeei.setCostType(costTypeDAO.getById(3));
									contractStageFeei.setFee(gpsinstall.getCostValue());
									contractStageFeei.setStage(contractStagei);
									contractStageFeei.setUpdateDate(date);
									contractStageFeei.setUpdateUser(user);
									contractStageFeei.setCreateDate(date);
									contractStageFeei.setCreateUser(user);
									contractStageFeeDAO.add(contractStageFeei);

									if (contract.getContractManageValue() != 0) {
										ContractStageFee contractStageFee1 = new ContractStageFee();
										contractStageFee1.setCostType(costTypeDAO.getById(15));
										contractStageFee1.setFee(contract.getContractManageValue());
										contractStageFee1.setStage(contractStagei);
										contractStageFee1.setUpdateDate(date);
										contractStageFee1.setUpdateUser(user);
										contractStageFee1.setCreateDate(date);
										contractStageFee1.setCreateUser(user);
										contractStageFeeDAO.add(contractStageFee1);
									}
								}
							}
							cal.setTime(contract.getStartDate());
							ContractStage contractStage = new ContractStage();
							double lastPrincipal = principal - perPrincipal * (stage - 1);
							contractStage.setStage(stage);
							contractStage.setContract(contract);
							contractStage.setCapital(lastPrincipal);
							contractStage.setInterest(0);
							contractStage.setExtraCharges(0);
							contractStage.setRepaymentDate(getCalendar(cal, stage).getTime());
							contractStage.setRealrepaymentDate(contractStage.getRepaymentDate());
							contractStage.setUpdateDate(date);
							contractStage.setUpdateUser(user);
							contractStage.setCreateDate(date);
							contractStage.setCreateUser(user);
							contractStageDAO.add(contractStage);
							return true;
						} else if (parkingFee.getParkingType().equals("年租")) {
							double preValue = contractParaDAO.findValueByContractAndPara(contract,
									productParameterDAO.getById(1));
							double principal = contract.getAmount() + contract.getAmount() * (preValue / 100) * stage;
							double perPrincipal = Double.valueOf(df.format(principal / stage));
							double interest = contractParaDAO.findValueByContractAndPara(contract,
									productParameterDAO.getById(2));
							double interestAmount = Double.valueOf(df.format(contract.getAmount() * interest / 100));
							CustomerContract customerContract = customerContractDAO.getById(contract.getId());
							customerContract.setPrincipal(principal);
							customerContract.setUpdateDate(date);
							customerContract.setUpdateUser(user);
							customerContractDAO.update(customerContract);
							ContractStage contractStage0 = new ContractStage();

							contractStage0.setStage(0);
							contractStage0.setContract(contract);
							contractStage0.setCapital(0);
							contractStage0.setState(1);
							contractStage0.setInterest(interestAmount);
							contractStage0
									.setExtraCharges(gpsinstall.getCostValue() + contract.getContractManageValue());
							contractStage0.setRepaymentDate(cal.getTime());
							contractStage0.setRealrepaymentDate(contractStage0.getRepaymentDate());
							contractStage0.setUpdateDate(date);
							contractStage0.setUpdateUser(user);
							contractStage0.setCreateDate(date);
							contractStage0.setCreateUser(user);
							contractStageDAO.add(contractStage0);

							ContractRepayment contractRepayment0 = new ContractRepayment();
							contractRepayment0.setCapital(contractStage0.getCapital());
							contractRepayment0.setInterest(contractStage0.getInterest());
							contractRepayment0.setPayment(contract.getName());
							contractRepayment0.setRepaymentDate(contractStage0.getRepaymentDate());
							contractRepayment0.setExtraCharges(contractStage0.getExtraCharges());
							contractRepayment0
									.setRepaymentFee(contractStage0.getCapital() + contractStage0.getInterest());
							contractRepayment0.setStage(contractStage0);
							contractRepayment0.setCreateDate(date);
							contractRepayment0.setCreateUser(user);
							contractRepayment0.setUpdateDate(date);
							contractRepayment0.setUpdateUser(user);
							contractRepayment0.setState(1);
							contractRepaymentDAO.add(contractRepayment0);

							List<CusContractCost> costs = cusContractCostDAO.getCusContractCostByContract(contract);
							for (CusContractCost cost : costs) {
								ContractStageFee contractStageFee = new ContractStageFee();
								contractStageFee.setCostType(cost.getCostType());
								contractStageFee.setFee(cost.getValue());
								contractStageFee.setStage(contractStage0);
								contractStageFee.setUpdateDate(date);
								contractStageFee.setUpdateUser(user);
								contractStageFee.setCreateDate(date);
								contractStageFee.setCreateUser(user);
								contractStageFeeDAO.add(contractStageFee);

								CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
								otherFee.setCostType(contractStageFee.getCostType());
								otherFee.setCreateDate(date);
								otherFee.setCreateUser(user);
								otherFee.setDefaultValue(contractStageFee.getFee());
								otherFee.setRepayment(contractRepayment0);
								otherFee.setUpdateDate(date);
								otherFee.setUpdateUser(user);
								otherFee.setValue(contractStageFee.getFee());
								cusContractRepaymentOtherFeeDAO.add(otherFee);
							}
							ContractStageFee contractStageFee = new ContractStageFee();
							contractStageFee.setCostType(costTypeDAO.getById(3));
							contractStageFee.setFee(gpsinstall.getCostValue());
							contractStageFee.setStage(contractStage0);
							contractStageFee.setUpdateDate(date);
							contractStageFee.setUpdateUser(user);
							contractStageFee.setCreateDate(date);
							contractStageFee.setCreateUser(user);
							contractStageFeeDAO.add(contractStageFee);

							CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
							otherFee.setCostType(contractStageFee.getCostType());
							otherFee.setDefaultValue(contractStageFee.getFee());
							otherFee.setValue(contractStageFee.getFee());
							otherFee.setRepayment(contractRepayment0);
							otherFee.setCreateDate(date);
							otherFee.setCreateUser(user);
							otherFee.setUpdateDate(date);
							otherFee.setUpdateUser(user);
							cusContractRepaymentOtherFeeDAO.add(otherFee);

							if (contract.getContractManageValue() != 0) {
								ContractStageFee contractStageFee1 = new ContractStageFee();
								contractStageFee1.setCostType(costTypeDAO.getById(15));
								contractStageFee1.setFee(contract.getContractManageValue());
								contractStageFee1.setStage(contractStage0);
								contractStageFee1.setUpdateDate(date);
								contractStageFee1.setUpdateUser(user);
								contractStageFee1.setCreateDate(date);
								contractStageFee1.setCreateUser(user);
								contractStageFeeDAO.add(contractStageFee1);

								CusContractRepaymentOtherFee otherFee1 = new CusContractRepaymentOtherFee();
								otherFee1.setCostType(contractStageFee1.getCostType());
								otherFee1.setDefaultValue(contractStageFee1.getFee());
								otherFee1.setValue(contractStageFee1.getFee());
								otherFee1.setRepayment(contractRepayment0);
								otherFee1.setCreateDate(date);
								otherFee1.setCreateUser(user);
								otherFee1.setUpdateDate(date);
								otherFee1.setUpdateUser(user);
								cusContractRepaymentOtherFeeDAO.add(otherFee1);
							}
							if (stage > 1) {
								for (int i = 1; i < stage; i++) {
									cal.setTime(contract.getStartDate());
									ContractStage contractStagei = new ContractStage();
									contractStagei.setStage(i);
									contractStagei.setContract(contract);
									contractStagei.setCapital(perPrincipal);
									contractStagei.setInterest(interestAmount);

									if (i % 12 == 11 && stage > i + 1) {
										contractStagei.setExtraCharges(
												gpsinstall.getCostValue() + contract.getContractManageValue());

									} else {
										contractStagei.setExtraCharges(0 + contract.getContractManageValue());
									}
									contractStagei.setRepaymentDate(getCalendar(cal, i).getTime());
									contractStagei.setRealrepaymentDate(contractStagei.getRepaymentDate());
									contractStagei.setUpdateDate(date);
									contractStagei.setUpdateUser(user);
									contractStagei.setCreateDate(date);
									contractStagei.setCreateUser(user);

									contractStageDAO.add(contractStagei);
									if (i % 12 == 11 && stage > i + 1) {
										ContractStageFee contractStageFeei = new ContractStageFee();
										contractStageFeei.setCostType(costTypeDAO.getById(3));
										contractStageFeei.setFee(gpsinstall.getCostValue());
										contractStageFeei.setStage(contractStagei);
										contractStageFeei.setUpdateDate(date);
										contractStageFeei.setUpdateUser(user);
										contractStageFeei.setCreateDate(date);
										contractStageFeei.setCreateUser(user);
										contractStageFeeDAO.add(contractStageFeei);
									}

									if (contract.getContractManageValue() != 0) {
										ContractStageFee contractStageFeei = new ContractStageFee();
										contractStageFeei.setCostType(costTypeDAO.getById(15));
										contractStageFeei.setFee(contract.getContractManageValue());
										contractStageFeei.setStage(contractStagei);
										contractStageFeei.setUpdateDate(date);
										contractStageFeei.setUpdateUser(user);
										contractStageFeei.setCreateDate(date);
										contractStageFeei.setCreateUser(user);
										contractStageFeeDAO.add(contractStageFeei);
									}
								}
							}
							cal.setTime(contract.getStartDate());
							ContractStage contractStage = new ContractStage();
							double lastPrincipal = principal - perPrincipal * (stage - 1);
							contractStage.setStage(stage);
							contractStage.setContract(contract);
							contractStage.setCapital(lastPrincipal);
							contractStage.setInterest(0);
							// if (stage % 12 == 11 ) {
							// contractStage.setExtraCharges(gpsinstall.getCostValue());

							// } else {
							contractStage.setExtraCharges(0);
							// }
							contractStage.setRepaymentDate(getCalendar(cal, stage).getTime());
							contractStage.setRealrepaymentDate(contractStage.getRepaymentDate());
							contractStage.setUpdateDate(date);
							contractStage.setUpdateUser(user);
							contractStage.setCreateDate(date);
							contractStage.setCreateUser(user);
							// contractStage.setRemark(getContractStageRemark(contractStage));
							contractStageDAO.add(contractStage);
							// if (stage % 12 == 11) {
							// ContractStageFee contractStageFeei = new ContractStageFee();
							// contractStageFeei.setCostType(costTypeDAO.getById(3));
							// contractStageFeei.setFee(gpsinstall.getCostValue());
							// contractStageFeei.setStage(contractStage);
							// contractStageFeeDAO.add(contractStageFeei);
							// }
							return true;
						}
					}

				} else {
					for (ContractGpsLateFee gpsinstall : contractGpsLateFeeDAO
							.findContractGpsLateFeeListByCustomerContract(contract)) {
						GpsCostTypeService gpsCostTypeService = (GpsCostTypeService) SpringUtil
								.getBean("GpsCostTypeService");
						GpsCostType gpsCostType = gpsCostTypeService.getById(gpsinstall.getType().getId());
						if (gpsCostType.getGpsCostType().equals("年租")) {
							double preValue = contractParaDAO.findValueByContractAndPara(contract,
									productParameterDAO.getById(1));
							double principal = contract.getAmount() + contract.getAmount() * (preValue / 100) * stage;
							double perPrincipal = Double.valueOf(df.format(principal / stage));
							double interest = contractParaDAO.findValueByContractAndPara(contract,
									productParameterDAO.getById(2));
							double interestAmount = Double.valueOf(df.format(contract.getAmount() * interest / 100));
							CustomerContract customerContract = customerContractDAO.getById(contract.getId());
							customerContract.setPrincipal(principal);
							customerContract.setUpdateDate(date);
							customerContract.setUpdateUser(user);
							customerContractDAO.update(customerContract);
							ContractStage contractStage0 = new ContractStage();

							contractStage0.setStage(0);
							contractStage0.setContract(contract);
							contractStage0.setCapital(0);
							contractStage0.setState(1);
							contractStage0.setInterest(interestAmount);
							contractStage0
									.setExtraCharges(gpsinstall.getCostValue() + contract.getContractManageValue());
							contractStage0.setRepaymentDate(cal.getTime());
							contractStage0.setRealrepaymentDate(contractStage0.getRepaymentDate());
							contractStage0.setUpdateDate(date);
							contractStage0.setUpdateUser(user);
							contractStage0.setCreateDate(date);
							contractStage0.setCreateUser(user);
							contractStageDAO.add(contractStage0);

							ContractRepayment contractRepayment0 = new ContractRepayment();
							contractRepayment0.setCapital(contractStage0.getCapital());
							contractRepayment0.setInterest(contractStage0.getInterest());
							contractRepayment0.setPayment(contract.getName());
							contractRepayment0.setRepaymentDate(contractStage0.getRepaymentDate());
							contractRepayment0.setExtraCharges(contractStage0.getExtraCharges());
							contractRepayment0
									.setRepaymentFee(contractStage0.getCapital() + contractStage0.getInterest());
							contractRepayment0.setStage(contractStage0);
							contractRepayment0.setCreateDate(date);
							contractRepayment0.setCreateUser(user);
							contractRepayment0.setUpdateDate(date);
							contractRepayment0.setUpdateUser(user);
							contractRepayment0.setState(1);
							contractRepaymentDAO.add(contractRepayment0);

							List<CusContractCost> costs = cusContractCostDAO.getCusContractCostByContract(contract);
							for (CusContractCost cost : costs) {
								ContractStageFee contractStageFee = new ContractStageFee();
								contractStageFee.setCostType(cost.getCostType());
								contractStageFee.setFee(cost.getValue());
								contractStageFee.setStage(contractStage0);
								contractStageFee.setUpdateDate(date);
								contractStageFee.setUpdateUser(user);
								contractStageFee.setCreateDate(date);
								contractStageFee.setCreateUser(user);
								contractStageFeeDAO.add(contractStageFee);

								CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
								otherFee.setCostType(contractStageFee.getCostType());
								otherFee.setCreateDate(date);
								otherFee.setCreateUser(user);
								otherFee.setDefaultValue(contractStageFee.getFee());
								otherFee.setRepayment(contractRepayment0);
								otherFee.setUpdateDate(date);
								otherFee.setUpdateUser(user);
								otherFee.setValue(contractStageFee.getFee());
								cusContractRepaymentOtherFeeDAO.add(otherFee);
							}
							ContractStageFee contractStageFee = new ContractStageFee();
							contractStageFee.setCostType(costTypeDAO.getById(9));
							contractStageFee.setFee(gpsinstall.getCostValue());
							contractStageFee.setStage(contractStage0);
							contractStageFee.setUpdateDate(date);
							contractStageFee.setUpdateUser(user);
							contractStageFee.setCreateDate(date);
							contractStageFee.setCreateUser(user);
							contractStageFeeDAO.add(contractStageFee);

							CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
							otherFee.setCostType(contractStageFee.getCostType());
							otherFee.setDefaultValue(contractStageFee.getFee());
							otherFee.setValue(contractStageFee.getFee());
							otherFee.setRepayment(contractRepayment0);
							otherFee.setCreateDate(date);
							otherFee.setCreateUser(user);
							otherFee.setUpdateDate(date);
							otherFee.setUpdateUser(user);
							cusContractRepaymentOtherFeeDAO.add(otherFee);

							if (contract.getContractManageValue() != 0) {
								ContractStageFee contractStageFee1 = new ContractStageFee();
								contractStageFee1.setCostType(costTypeDAO.getById(15));
								contractStageFee1.setFee(contract.getContractManageValue());
								contractStageFee1.setStage(contractStage0);
								contractStageFee1.setUpdateDate(date);
								contractStageFee1.setUpdateUser(user);
								contractStageFee1.setCreateDate(date);
								contractStageFee1.setCreateUser(user);
								contractStageFeeDAO.add(contractStageFee1);

								CusContractRepaymentOtherFee otherFee1 = new CusContractRepaymentOtherFee();
								otherFee1.setCostType(contractStageFee1.getCostType());
								otherFee1.setDefaultValue(contractStageFee1.getFee());
								otherFee1.setValue(contractStageFee1.getFee());
								otherFee1.setRepayment(contractRepayment0);
								otherFee1.setCreateDate(date);
								otherFee1.setCreateUser(user);
								otherFee1.setUpdateDate(date);
								otherFee1.setUpdateUser(user);
								cusContractRepaymentOtherFeeDAO.add(otherFee1);
							}
							if (stage > 1) {
								for (int i = 1; i < stage; i++) {
									cal.setTime(contract.getStartDate());
									ContractStage contractStagei = new ContractStage();
									contractStagei.setStage(i);
									contractStagei.setContract(contract);
									contractStagei.setCapital(perPrincipal);
									contractStagei.setInterest(interestAmount);

									if (i % 12 == 11 && stage > i + 1) {
										contractStagei.setExtraCharges(
												gpsinstall.getCostValue() + contract.getContractManageValue());

									} else {
										contractStagei.setExtraCharges(0 + contract.getContractManageValue());
									}
									contractStagei.setRepaymentDate(getCalendar(cal, i).getTime());
									contractStagei.setRealrepaymentDate(contractStagei.getRepaymentDate());
									contractStagei.setUpdateDate(date);
									contractStagei.setUpdateUser(user);
									contractStagei.setCreateDate(date);
									contractStagei.setCreateUser(user);
									contractStageDAO.add(contractStagei);
									if (i % 12 == 11 && stage > i + 1) {
										ContractStageFee contractStageFeei = new ContractStageFee();
										contractStageFeei.setCostType(costTypeDAO.getById(9));
										contractStageFeei.setFee(gpsinstall.getCostValue());
										contractStageFeei.setStage(contractStagei);
										contractStageFeei.setUpdateDate(date);
										contractStageFeei.setUpdateUser(user);
										contractStageFeei.setCreateDate(date);
										contractStageFeei.setCreateUser(user);
										contractStageFeeDAO.add(contractStageFeei);
									}

									if (contract.getContractManageValue() != 0) {
										ContractStageFee contractStageFeei = new ContractStageFee();
										contractStageFeei.setCostType(costTypeDAO.getById(15));
										contractStageFeei.setFee(contract.getContractManageValue());
										contractStageFeei.setStage(contractStagei);
										contractStageFeei.setUpdateDate(date);
										contractStageFeei.setUpdateUser(user);
										contractStageFeei.setCreateDate(date);
										contractStageFeei.setCreateUser(user);
										contractStageFeeDAO.add(contractStageFeei);
									}
								}
							}
							cal.setTime(contract.getStartDate());
							ContractStage contractStage = new ContractStage();
							double lastPrincipal = principal - perPrincipal * (stage - 1);
							contractStage.setStage(stage);
							contractStage.setContract(contract);
							contractStage.setCapital(lastPrincipal);
							contractStage.setInterest(0);
							// if (stage % 12 == 11) {
							// contractStage.setExtraCharges(gpsinstall.getCostValue());

							// } else {
							contractStage.setExtraCharges(0);
							// }
							contractStage.setRepaymentDate(getCalendar(cal, stage).getTime());
							contractStage.setRealrepaymentDate(contractStage.getRepaymentDate());
							contractStage.setUpdateDate(date);
							contractStage.setUpdateUser(user);
							contractStage.setCreateDate(date);
							contractStage.setCreateUser(user);
							contractStageDAO.add(contractStage);
							// if (stage % 12 == 11) {
							// ContractStageFee contractStageFeei = new ContractStageFee();
							// contractStageFeei.setCostType(costTypeDAO.getById(9));
							// contractStageFeei.setFee(gpsinstall.getCostValue());
							// contractStageFeei.setStage(contractStage);
							// contractStageFeeDAO.add(contractStageFeei);
							// }
							return true;
						} else if (gpsCostType.getGpsCostType().equals("月租")) {
							double preValue = contractParaDAO.findValueByContractAndPara(contract,
									productParameterDAO.getById(1));
							double principal = contract.getAmount() + contract.getAmount() * (preValue / 100) * stage;
							double perPrincipal = Double.valueOf(df.format(principal / stage));
							double interest = contractParaDAO.findValueByContractAndPara(contract,
									productParameterDAO.getById(2));
							double interestAmount = Double.valueOf(df.format(contract.getAmount() * interest / 100));
							CustomerContract customerContract = customerContractDAO.getById(contract.getId());
							customerContract.setPrincipal(principal);
							customerContract.setUpdateDate(date);
							customerContract.setUpdateUser(user);
							customerContractDAO.update(customerContract);
							ContractStage contractStage0 = new ContractStage();

							contractStage0.setStage(0);
							contractStage0.setContract(contract);
							contractStage0.setCapital(0);
							contractStage0.setInterest(interestAmount);
							contractStage0.setState(1);
							contractStage0
									.setExtraCharges(gpsinstall.getCostValue() + contract.getContractManageValue());
							contractStage0.setRepaymentDate(cal.getTime());
							contractStage0.setRealrepaymentDate(contractStage0.getRepaymentDate());
							contractStage0.setUpdateDate(date);
							contractStage0.setUpdateUser(user);
							contractStage0.setCreateDate(date);
							contractStage0.setCreateUser(user);
							contractStageDAO.add(contractStage0);

							ContractRepayment contractRepayment0 = new ContractRepayment();
							contractRepayment0.setCapital(contractStage0.getCapital());
							contractRepayment0.setInterest(contractStage0.getInterest());
							contractRepayment0.setPayment(contract.getName());
							contractRepayment0.setRepaymentDate(contractStage0.getRepaymentDate());
							contractRepayment0.setExtraCharges(contractStage0.getExtraCharges());
							contractRepayment0
									.setRepaymentFee(contractStage0.getCapital() + contractStage0.getInterest());
							contractRepayment0.setStage(contractStage0);
							contractRepayment0.setCreateDate(date);
							contractRepayment0.setCreateUser(user);
							contractRepayment0.setUpdateDate(date);
							contractRepayment0.setUpdateUser(user);
							contractRepayment0.setState(1);
							contractRepaymentDAO.add(contractRepayment0);

							List<CusContractCost> costs = cusContractCostDAO.getCusContractCostByContract(contract);
							for (CusContractCost cost : costs) {
								ContractStageFee contractStageFee = new ContractStageFee();
								contractStageFee.setCostType(cost.getCostType());
								contractStageFee.setFee(cost.getValue());
								contractStageFee.setStage(contractStage0);
								contractStageFee.setUpdateDate(date);
								contractStageFee.setUpdateUser(user);
								contractStageFee.setCreateDate(date);
								contractStageFee.setCreateUser(user);
								contractStageFeeDAO.add(contractStageFee);

								CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
								otherFee.setCostType(contractStageFee.getCostType());
								otherFee.setCreateDate(date);
								otherFee.setCreateUser(user);
								otherFee.setDefaultValue(contractStageFee.getFee());
								otherFee.setRepayment(contractRepayment0);
								otherFee.setUpdateDate(date);
								otherFee.setUpdateUser(user);
								otherFee.setValue(contractStageFee.getFee());
								cusContractRepaymentOtherFeeDAO.add(otherFee);
							}
							ContractStageFee contractStageFee = new ContractStageFee();
							contractStageFee.setCostType(costTypeDAO.getById(9));
							contractStageFee.setFee(gpsinstall.getCostValue());
							contractStageFee.setStage(contractStage0);
							contractStageFee.setUpdateDate(date);
							contractStageFee.setUpdateUser(user);
							contractStageFee.setCreateDate(date);
							contractStageFee.setCreateUser(user);
							contractStageFeeDAO.add(contractStageFee);

							CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
							otherFee.setCostType(contractStageFee.getCostType());
							otherFee.setDefaultValue(contractStageFee.getFee());
							otherFee.setValue(contractStageFee.getFee());
							otherFee.setRepayment(contractRepayment0);
							otherFee.setCreateDate(date);
							otherFee.setCreateUser(user);
							otherFee.setUpdateDate(date);
							otherFee.setUpdateUser(user);
							cusContractRepaymentOtherFeeDAO.add(otherFee);

							if (contract.getContractManageValue() != 0) {
								ContractStageFee contractStageFee1 = new ContractStageFee();
								contractStageFee1.setCostType(costTypeDAO.getById(15));
								contractStageFee1.setFee(contract.getContractManageValue());
								contractStageFee1.setStage(contractStage0);
								contractStageFee1.setUpdateDate(date);
								contractStageFee1.setUpdateUser(user);
								contractStageFee1.setCreateDate(date);
								contractStageFee1.setCreateUser(user);
								contractStageFeeDAO.add(contractStageFee1);

								CusContractRepaymentOtherFee otherFee1 = new CusContractRepaymentOtherFee();
								otherFee1.setCostType(contractStageFee1.getCostType());
								otherFee1.setDefaultValue(contractStageFee1.getFee());
								otherFee1.setValue(contractStageFee1.getFee());
								otherFee1.setRepayment(contractRepayment0);
								otherFee1.setCreateDate(date);
								otherFee1.setCreateUser(user);
								otherFee1.setUpdateDate(date);
								otherFee1.setUpdateUser(user);
								cusContractRepaymentOtherFeeDAO.add(otherFee1);
							}
							if (stage > 1) {
								for (int i = 1; i < stage; i++) {
									cal.setTime(contract.getStartDate());
									ContractStage contractStagei = new ContractStage();
									contractStagei.setStage(i);
									contractStagei.setContract(contract);
									contractStagei.setCapital(perPrincipal);
									contractStagei.setInterest(interestAmount);
									contractStagei.setExtraCharges(
											gpsinstall.getCostValue() + contract.getContractManageValue());
									contractStagei.setRepaymentDate(getCalendar(cal, i).getTime());
									contractStagei.setRealrepaymentDate(contractStagei.getRepaymentDate());
									contractStagei.setUpdateDate(date);
									contractStagei.setUpdateUser(user);
									contractStagei.setCreateDate(date);
									contractStagei.setCreateUser(user);
									contractStageDAO.add(contractStagei);
									ContractStageFee contractStageFeei = new ContractStageFee();
									contractStageFeei.setCostType(costTypeDAO.getById(9));
									contractStageFeei.setFee(gpsinstall.getCostValue());
									contractStageFeei.setStage(contractStagei);
									contractStageFeei.setUpdateDate(date);
									contractStageFeei.setUpdateUser(user);
									contractStageFeei.setCreateDate(date);
									contractStageFeei.setCreateUser(user);
									contractStageFeeDAO.add(contractStageFeei);

									if (contract.getContractManageValue() != 0) {
										ContractStageFee contractStageFee1 = new ContractStageFee();
										contractStageFee1.setCostType(costTypeDAO.getById(15));
										contractStageFee1.setFee(contract.getContractManageValue());
										contractStageFee1.setStage(contractStagei);
										contractStageFee1.setUpdateDate(date);
										contractStageFee1.setUpdateUser(user);
										contractStageFee1.setCreateDate(date);
										contractStageFee1.setCreateUser(user);
										contractStageFeeDAO.add(contractStageFee1);
									}
								}
							}
							cal.setTime(contract.getStartDate());
							ContractStage contractStage = new ContractStage();
							double lastPrincipal = principal - perPrincipal * (stage - 1);
							contractStage.setStage(stage);
							contractStage.setContract(contract);
							contractStage.setCapital(lastPrincipal);
							contractStage.setInterest(0);
							contractStage.setExtraCharges(0);
							contractStage.setRepaymentDate(getCalendar(cal, stage).getTime());
							contractStage.setRealrepaymentDate(contractStage.getRepaymentDate());
							contractStage.setUpdateDate(date);
							contractStage.setUpdateUser(user);
							contractStage.setCreateDate(date);
							contractStage.setCreateUser(user);
							contractStageDAO.add(contractStage);

							return true;
						}
					}
				}

			}
		}
		if (contractGpsLateFeeDAO.getCountByCustomerContract(contract) == 0) {
			for (ContractGpsLateFee gpsinstall : contractGpsLateFeeDAO
					.findContractGpsLateFeeListByCustomerContract(contract)) {
				ParkingFeeService parkingFeeService = (ParkingFeeService) SpringUtil.getBean("ParkingFeeService");
				ParkingFee parkingFee = parkingFeeService.getById(gpsinstall.getParkingFee().getId());
				if (parkingFee.getParkingType().equals("日租")) {
					double principal = contract.getAmount();
					double interest = contractParaDAO.findValueByContractAndPara(contract,
							productParameterDAO.getById(2));
					double interestAmount = Double.valueOf(df.format(contract.getAmount() * interest / 100));
					CustomerContract customerContract = customerContractDAO.getById(contract.getId());
					customerContract.setPrincipal(principal);
					customerContract.setUpdateDate(date);
					customerContract.setUpdateUser(user);
					customerContractDAO.update(customerContract);
					ContractStage contractStage0 = new ContractStage();
					contractStage0.setStage(0);
					contractStage0.setContract(contract);
					contractStage0.setCapital(0);
					contractStage0.setState(1);
					contractStage0.setInterest(interestAmount);
					contractStage0.setExtraCharges(
							contractGpsLateFeeDAO.findContractGpsLateFeeByCustomerContract(contract).getCostValue()
									* daysBetween(getCalendar(cal, 0).getTime(), getCalendar(cal1, 1).getTime())
									+ contract.getContractManageValue());

					cal.setTime(contract.getStartDate());
					contractStage0.setRepaymentDate(cal.getTime());
					contractStage0.setRealrepaymentDate(contractStage0.getRepaymentDate());
					contractStage0.setUpdateDate(date);
					contractStage0.setUpdateUser(user);
					contractStage0.setCreateDate(date);
					contractStage0.setCreateUser(user);
					contractStageDAO.add(contractStage0);

					ContractRepayment contractRepayment0 = new ContractRepayment();
					contractRepayment0.setCapital(contractStage0.getCapital());
					contractRepayment0.setInterest(contractStage0.getInterest());
					contractRepayment0.setPayment(contract.getName());
					contractRepayment0.setRepaymentDate(contractStage0.getRepaymentDate());
					contractRepayment0.setExtraCharges(contractStage0.getExtraCharges());
					contractRepayment0.setRepaymentFee(contractStage0.getCapital() + contractStage0.getInterest()
							+ contractStage0.getExtraCharges());
					contractRepayment0.setStage(contractStage0);
					contractRepayment0.setCreateDate(date);
					contractRepayment0.setCreateUser(user);
					contractRepayment0.setUpdateDate(date);
					contractRepayment0.setUpdateUser(user);
					contractRepayment0.setState(1);
					contractRepaymentDAO.add(contractRepayment0);

					List<CusContractCost> costs = cusContractCostDAO.getCusContractCostByContract(contract);
					for (CusContractCost cost : costs) {
						ContractStageFee contractStageFee = new ContractStageFee();
						contractStageFee.setCostType(cost.getCostType());
						contractStageFee.setFee(cost.getValue());
						contractStageFee.setStage(contractStage0);
						contractStageFee.setUpdateDate(date);
						contractStageFee.setUpdateUser(user);
						contractStageFee.setCreateDate(date);
						contractStageFee.setCreateUser(user);
						contractStageFeeDAO.add(contractStageFee);

						CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
						otherFee.setCostType(contractStageFee.getCostType());
						otherFee.setCreateDate(date);
						otherFee.setCreateUser(user);
						otherFee.setDefaultValue(contractStageFee.getFee());
						otherFee.setRepayment(contractRepayment0);
						otherFee.setUpdateDate(date);
						otherFee.setUpdateUser(user);
						otherFee.setValue(contractStageFee.getFee());
						cusContractRepaymentOtherFeeDAO.add(otherFee);
					}
					ContractStageFee contractStageFee = new ContractStageFee();
					contractStageFee.setCostType(costTypeDAO.getById(3));
					contractStageFee.setFee(
							contractGpsLateFeeDAO.findContractGpsLateFeeByCustomerContract(contract).getCostValue()
									* daysBetween(getCalendar(cal, 0).getTime(), getCalendar(cal1, 1).getTime()));
					contractStageFee.setStage(contractStage0);
					contractStageFee.setUpdateDate(date);
					contractStageFee.setUpdateUser(user);
					contractStageFee.setCreateDate(date);
					contractStageFee.setCreateUser(user);
					contractStageFeeDAO.add(contractStageFee);

					CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
					otherFee.setCostType(contractStageFee.getCostType());
					otherFee.setDefaultValue(contractStageFee.getFee());
					otherFee.setValue(contractStageFee.getFee());
					otherFee.setRepayment(contractRepayment0);
					otherFee.setCreateDate(date);
					otherFee.setCreateUser(user);
					otherFee.setUpdateDate(date);
					otherFee.setUpdateUser(user);
					cusContractRepaymentOtherFeeDAO.add(otherFee);

					if (contract.getContractManageValue() != 0) {
						ContractStageFee contractStageFee1 = new ContractStageFee();
						contractStageFee1.setCostType(costTypeDAO.getById(15));
						contractStageFee1.setFee(contract.getContractManageValue());
						contractStageFee1.setStage(contractStage0);
						contractStageFee1.setUpdateDate(date);
						contractStageFee1.setUpdateUser(user);
						contractStageFee1.setCreateDate(date);
						contractStageFee1.setCreateUser(user);
						contractStageFeeDAO.add(contractStageFee1);

						CusContractRepaymentOtherFee otherFee1 = new CusContractRepaymentOtherFee();
						otherFee1.setCostType(contractStageFee1.getCostType());
						otherFee1.setDefaultValue(contractStageFee1.getFee());
						otherFee1.setValue(contractStageFee1.getFee());
						otherFee1.setRepayment(contractRepayment0);
						otherFee1.setCreateDate(date);
						otherFee1.setCreateUser(user);
						otherFee1.setUpdateDate(date);
						otherFee1.setUpdateUser(user);
						cusContractRepaymentOtherFeeDAO.add(otherFee1);
					}

					if (stage > 1) {
						for (int i = 1; i < stage; i++) {
							cal.setTime(contract.getStartDate());
							cal1.setTime(contract.getStartDate());
							ContractStage contractStagei = new ContractStage();
							contractStagei.setStage(i);
							contractStagei.setContract(contract);
							contractStagei.setCapital(0);
							contractStagei.setInterest(interestAmount);

							contractStagei.setExtraCharges(contractGpsLateFeeDAO
									.findContractGpsLateFeeByCustomerContract(contract).getCostValue()
									* daysBetween(getCalendar(cal, i).getTime(), getCalendar(cal1, i + 1).getTime())
									+ contract.getContractManageValue());

							cal.setTime(contract.getStartDate());
							contractStagei.setRepaymentDate(getCalendar(cal, i).getTime());
							contractStagei.setRealrepaymentDate(contractStagei.getRepaymentDate());
							contractStagei.setUpdateDate(date);
							contractStagei.setUpdateUser(user);
							contractStagei.setCreateDate(date);
							contractStagei.setCreateUser(user);
							contractStageDAO.add(contractStagei);
							ContractStageFee contractStageFeei = new ContractStageFee();
							contractStageFeei.setCostType(costTypeDAO.getById(3));
							contractStageFeei.setFee(contractGpsLateFeeDAO
									.findContractGpsLateFeeByCustomerContract(contract).getCostValue()
									* daysBetween(getCalendar(cal, i).getTime(), getCalendar(cal1, i + 1).getTime()));
							contractStageFeei.setStage(contractStagei);
							contractStageFeei.setUpdateDate(date);
							contractStageFeei.setUpdateUser(user);
							contractStageFeei.setCreateDate(date);
							contractStageFeei.setCreateUser(user);
							contractStageFeeDAO.add(contractStageFeei);

							if (contract.getContractManageValue() != 0) {
								ContractStageFee contractStageFee1 = new ContractStageFee();
								contractStageFee1.setCostType(costTypeDAO.getById(15));
								contractStageFee1.setFee(contract.getContractManageValue());
								contractStageFee1.setStage(contractStagei);
								contractStageFee1.setUpdateDate(date);
								contractStageFee1.setUpdateUser(user);
								contractStageFee1.setCreateDate(date);
								contractStageFee1.setCreateUser(user);
								contractStageFeeDAO.add(contractStageFee1);
							}
						}
					}
					cal.setTime(contract.getStartDate());
					ContractStage contractStage = new ContractStage();
					contractStage.setStage(stage);
					contractStage.setContract(contract);
					contractStage.setCapital(principal);
					contractStage.setInterest(0);
					contractStage.setExtraCharges(0);
					contractStage.setRepaymentDate(getCalendar(cal, stage).getTime());
					contractStage.setRealrepaymentDate(contractStage.getRepaymentDate());
					contractStage.setUpdateDate(date);
					contractStage.setUpdateUser(user);
					contractStage.setCreateDate(date);
					contractStage.setCreateUser(user);
					contractStageDAO.add(contractStage);
					return true;
				} else if (parkingFee.getParkingType().equals("月租")) {
					double principal = contract.getAmount();
					double interest = contractParaDAO.findValueByContractAndPara(contract,
							productParameterDAO.getById(2));
					double interestAmount = Double.valueOf(df.format(contract.getAmount() * interest / 100));
					CustomerContract customerContract = customerContractDAO.getById(contract.getId());
					customerContract.setPrincipal(principal);
					customerContract.setUpdateDate(date);
					customerContract.setUpdateUser(user);
					customerContractDAO.update(customerContract);
					ContractStage contractStage0 = new ContractStage();

					contractStage0.setStage(0);
					contractStage0.setContract(contract);
					contractStage0.setCapital(0);
					contractStage0.setState(1);
					contractStage0.setInterest(interestAmount);
					contractStage0.setExtraCharges(gpsinstall.getCostValue() + contract.getContractManageValue());
					contractStage0.setRepaymentDate(cal.getTime());
					contractStage0.setRealrepaymentDate(contractStage0.getRepaymentDate());
					contractStage0.setUpdateDate(date);
					contractStage0.setUpdateUser(user);
					contractStage0.setCreateDate(date);
					contractStage0.setCreateUser(user);
					contractStageDAO.add(contractStage0);

					ContractRepayment contractRepayment0 = new ContractRepayment();
					contractRepayment0.setCapital(contractStage0.getCapital());
					contractRepayment0.setInterest(contractStage0.getInterest());
					contractRepayment0.setPayment(contract.getName());
					contractRepayment0.setRepaymentDate(contractStage0.getRepaymentDate());
					contractRepayment0.setExtraCharges(contractStage0.getExtraCharges());
					contractRepayment0.setRepaymentFee(contractStage0.getCapital() + contractStage0.getInterest()
							+ contractStage0.getExtraCharges());
					contractRepayment0.setStage(contractStage0);
					contractRepayment0.setCreateDate(date);
					contractRepayment0.setCreateUser(user);
					contractRepayment0.setUpdateDate(date);
					contractRepayment0.setUpdateUser(user);
					contractRepayment0.setState(1);
					contractRepaymentDAO.add(contractRepayment0);

					List<CusContractCost> costs = cusContractCostDAO.getCusContractCostByContract(contract);
					for (CusContractCost cost : costs) {
						ContractStageFee contractStageFee = new ContractStageFee();
						contractStageFee.setCostType(cost.getCostType());
						contractStageFee.setFee(cost.getValue());
						contractStageFee.setStage(contractStage0);
						contractStageFee.setUpdateDate(date);
						contractStageFee.setUpdateUser(user);
						contractStageFee.setCreateDate(date);
						contractStageFee.setCreateUser(user);
						contractStageFeeDAO.add(contractStageFee);

						CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
						otherFee.setCostType(contractStageFee.getCostType());
						otherFee.setCreateDate(date);
						otherFee.setCreateUser(user);
						otherFee.setDefaultValue(contractStageFee.getFee());
						otherFee.setRepayment(contractRepayment0);
						otherFee.setUpdateDate(date);
						otherFee.setUpdateUser(user);
						otherFee.setValue(contractStageFee.getFee());
						cusContractRepaymentOtherFeeDAO.add(otherFee);
					}
					ContractStageFee contractStageFee = new ContractStageFee();
					contractStageFee.setCostType(costTypeDAO.getById(3));
					contractStageFee.setFee(gpsinstall.getCostValue());
					contractStageFee.setStage(contractStage0);
					contractStageFee.setUpdateDate(date);
					contractStageFee.setUpdateUser(user);
					contractStageFee.setCreateDate(date);
					contractStageFee.setCreateUser(user);
					contractStageFeeDAO.add(contractStageFee);

					CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
					otherFee.setCostType(contractStageFee.getCostType());
					otherFee.setDefaultValue(contractStageFee.getFee());
					otherFee.setValue(contractStageFee.getFee());
					otherFee.setRepayment(contractRepayment0);
					otherFee.setCreateDate(date);
					otherFee.setCreateUser(user);
					otherFee.setUpdateDate(date);
					otherFee.setUpdateUser(user);
					cusContractRepaymentOtherFeeDAO.add(otherFee);

					if (contract.getContractManageValue() != 0) {
						ContractStageFee contractStageFee1 = new ContractStageFee();
						contractStageFee1.setCostType(costTypeDAO.getById(15));
						contractStageFee1.setFee(contract.getContractManageValue());
						contractStageFee1.setStage(contractStage0);
						contractStageFee1.setUpdateDate(date);
						contractStageFee1.setUpdateUser(user);
						contractStageFee1.setCreateDate(date);
						contractStageFee1.setCreateUser(user);
						contractStageFeeDAO.add(contractStageFee1);

						CusContractRepaymentOtherFee otherFee1 = new CusContractRepaymentOtherFee();
						otherFee1.setCostType(contractStageFee1.getCostType());
						otherFee1.setDefaultValue(contractStageFee1.getFee());
						otherFee1.setValue(contractStageFee1.getFee());
						otherFee1.setRepayment(contractRepayment0);
						otherFee1.setCreateDate(date);
						otherFee1.setCreateUser(user);
						otherFee1.setUpdateDate(date);
						otherFee1.setUpdateUser(user);
						cusContractRepaymentOtherFeeDAO.add(otherFee1);
					}
					if (stage > 1) {
						for (int i = 1; i < stage; i++) {
							cal.setTime(contract.getStartDate());
							ContractStage contractStagei = new ContractStage();
							contractStagei.setStage(i);
							contractStagei.setContract(contract);
							contractStagei.setCapital(0);
							contractStagei.setInterest(interestAmount);
							contractStagei
									.setExtraCharges(gpsinstall.getCostValue() + contract.getContractManageValue());
							contractStagei.setRepaymentDate(getCalendar(cal, i).getTime());
							contractStagei.setRealrepaymentDate(contractStagei.getRepaymentDate());
							contractStagei.setUpdateDate(date);
							contractStagei.setUpdateUser(user);
							contractStagei.setCreateDate(date);
							contractStagei.setCreateUser(user);
							contractStageDAO.add(contractStagei);
							ContractStageFee contractStageFeei = new ContractStageFee();
							contractStageFeei.setCostType(costTypeDAO.getById(3));
							contractStageFeei.setFee(gpsinstall.getCostValue());
							contractStageFeei.setStage(contractStagei);
							contractStageFeei.setUpdateDate(date);
							contractStageFeei.setUpdateUser(user);
							contractStageFeei.setCreateDate(date);
							contractStageFeei.setCreateUser(user);
							contractStageFeeDAO.add(contractStageFeei);

							if (contract.getContractManageValue() != 0) {
								ContractStageFee contractStageFee1 = new ContractStageFee();
								contractStageFee1.setCostType(costTypeDAO.getById(15));
								contractStageFee1.setFee(contract.getContractManageValue());
								contractStageFee1.setStage(contractStagei);
								contractStageFee1.setUpdateDate(date);
								contractStageFee1.setUpdateUser(user);
								contractStageFee1.setCreateDate(date);
								contractStageFee1.setCreateUser(user);
								contractStageFeeDAO.add(contractStageFee1);
							}
						}
					}
					cal.setTime(contract.getStartDate());
					ContractStage contractStage = new ContractStage();
					contractStage.setStage(stage);
					contractStage.setContract(contract);
					contractStage.setCapital(principal);
					contractStage.setInterest(0);
					contractStage.setExtraCharges(0);
					contractStage.setRepaymentDate(getCalendar(cal, stage).getTime());
					contractStage.setRealrepaymentDate(contractStage.getRepaymentDate());
					contractStage.setUpdateDate(date);
					contractStage.setUpdateUser(user);
					contractStage.setCreateDate(date);
					contractStage.setCreateUser(user);
					contractStageDAO.add(contractStage);
					return true;
				} else if (parkingFee.getParkingType().equals("年租")) {
					double principal = contract.getAmount();
					double interest = contractParaDAO.findValueByContractAndPara(contract,
							productParameterDAO.getById(2));
					double interestAmount = Double.valueOf(df.format(contract.getAmount() * interest / 100));
					CustomerContract customerContract = customerContractDAO.getById(contract.getId());
					customerContract.setPrincipal(principal);
					customerContract.setUpdateDate(date);
					customerContract.setUpdateUser(user);
					customerContractDAO.update(customerContract);
					ContractStage contractStage0 = new ContractStage();

					contractStage0.setStage(0);
					contractStage0.setContract(contract);
					contractStage0.setCapital(0);
					contractStage0.setState(1);
					contractStage0.setInterest(interestAmount);
					contractStage0.setExtraCharges(gpsinstall.getCostValue() + contract.getContractManageValue());
					contractStage0.setRepaymentDate(cal.getTime());
					contractStage0.setRealrepaymentDate(contractStage0.getRepaymentDate());
					contractStage0.setUpdateDate(date);
					contractStage0.setUpdateUser(user);
					contractStage0.setCreateDate(date);
					contractStage0.setCreateUser(user);
					contractStageDAO.add(contractStage0);

					ContractRepayment contractRepayment0 = new ContractRepayment();
					contractRepayment0.setCapital(contractStage0.getCapital());
					contractRepayment0.setInterest(contractStage0.getInterest());
					contractRepayment0.setPayment(contract.getName());
					contractRepayment0.setRepaymentDate(contractStage0.getRepaymentDate());
					contractRepayment0.setExtraCharges(contractStage0.getExtraCharges());
					contractRepayment0.setRepaymentFee(contractStage0.getCapital() + contractStage0.getInterest()
							+ contractStage0.getExtraCharges());
					contractRepayment0.setStage(contractStage0);
					contractRepayment0.setCreateDate(date);
					contractRepayment0.setCreateUser(user);
					contractRepayment0.setUpdateDate(date);
					contractRepayment0.setUpdateUser(user);
					contractRepayment0.setState(1);
					contractRepaymentDAO.add(contractRepayment0);

					List<CusContractCost> costs = cusContractCostDAO.getCusContractCostByContract(contract);
					for (CusContractCost cost : costs) {
						ContractStageFee contractStageFee = new ContractStageFee();
						contractStageFee.setCostType(cost.getCostType());
						contractStageFee.setFee(cost.getValue());
						contractStageFee.setStage(contractStage0);
						contractStageFee.setUpdateDate(date);
						contractStageFee.setUpdateUser(user);
						contractStageFee.setCreateDate(date);
						contractStageFee.setCreateUser(user);
						contractStageFeeDAO.add(contractStageFee);

						CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
						otherFee.setCostType(contractStageFee.getCostType());
						otherFee.setCreateDate(date);
						otherFee.setCreateUser(user);
						otherFee.setDefaultValue(contractStageFee.getFee());
						otherFee.setRepayment(contractRepayment0);
						otherFee.setUpdateDate(date);
						otherFee.setUpdateUser(user);
						otherFee.setValue(contractStageFee.getFee());
						cusContractRepaymentOtherFeeDAO.add(otherFee);

					}
					ContractStageFee contractStageFee = new ContractStageFee();
					contractStageFee.setCostType(costTypeDAO.getById(3));
					contractStageFee.setFee(gpsinstall.getCostValue());
					contractStageFee.setStage(contractStage0);
					contractStageFee.setUpdateDate(date);
					contractStageFee.setUpdateUser(user);
					contractStageFee.setCreateDate(date);
					contractStageFee.setCreateUser(user);
					contractStageFeeDAO.add(contractStageFee);

					CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
					otherFee.setCostType(contractStageFee.getCostType());
					otherFee.setDefaultValue(contractStageFee.getFee());
					otherFee.setValue(contractStageFee.getFee());
					otherFee.setRepayment(contractRepayment0);
					otherFee.setCreateDate(date);
					otherFee.setCreateUser(user);
					otherFee.setUpdateDate(date);
					otherFee.setUpdateUser(user);
					cusContractRepaymentOtherFeeDAO.add(otherFee);

					if (contract.getContractManageValue() != 0) {
						ContractStageFee contractStageFee1 = new ContractStageFee();
						contractStageFee1.setCostType(costTypeDAO.getById(15));
						contractStageFee1.setFee(contract.getContractManageValue());
						contractStageFee1.setStage(contractStage0);
						contractStageFee1.setUpdateDate(date);
						contractStageFee1.setUpdateUser(user);
						contractStageFee1.setCreateDate(date);
						contractStageFee1.setCreateUser(user);
						contractStageFeeDAO.add(contractStageFee1);

						CusContractRepaymentOtherFee otherFee1 = new CusContractRepaymentOtherFee();
						otherFee1.setCostType(contractStageFee1.getCostType());
						otherFee1.setDefaultValue(contractStageFee1.getFee());
						otherFee1.setValue(contractStageFee1.getFee());
						otherFee1.setRepayment(contractRepayment0);
						otherFee1.setCreateDate(date);
						otherFee1.setCreateUser(user);
						otherFee1.setUpdateDate(date);
						otherFee1.setUpdateUser(user);
						cusContractRepaymentOtherFeeDAO.add(otherFee1);
					}
					if (stage > 1) {
						for (int i = 1; i < stage; i++) {
							cal.setTime(contract.getStartDate());
							ContractStage contractStagei = new ContractStage();
							contractStagei.setStage(i);
							contractStagei.setContract(contract);
							contractStagei.setCapital(0);
							contractStagei.setInterest(interestAmount);

							if (i % 12 == 11 && stage > i + 1) {
								contractStagei
										.setExtraCharges(gpsinstall.getCostValue() + contract.getContractManageValue());

							} else {
								contractStagei.setExtraCharges(0 + contract.getContractManageValue());
							}
							contractStagei.setRepaymentDate(getCalendar(cal, i).getTime());
							contractStagei.setRealrepaymentDate(contractStagei.getRepaymentDate());
							contractStagei.setUpdateDate(date);
							contractStagei.setUpdateUser(user);
							contractStagei.setCreateDate(date);
							contractStagei.setCreateUser(user);
							contractStageDAO.add(contractStagei);
							if (i % 12 == 11 && stage > i + 1) {
								ContractStageFee contractStageFeei = new ContractStageFee();
								contractStageFeei.setCostType(costTypeDAO.getById(3));
								contractStageFeei.setFee(gpsinstall.getCostValue());
								contractStageFeei.setStage(contractStagei);
								contractStageFeei.setUpdateDate(date);
								contractStageFeei.setUpdateUser(user);
								contractStageFeei.setCreateDate(date);
								contractStageFeei.setCreateUser(user);
								contractStageFeeDAO.add(contractStageFeei);
							}

							if (contract.getContractManageValue() != 0) {
								ContractStageFee contractStageFee1 = new ContractStageFee();
								contractStageFee1.setCostType(costTypeDAO.getById(15));
								contractStageFee1.setFee(contract.getContractManageValue());
								contractStageFee1.setStage(contractStagei);
								contractStageFee1.setUpdateDate(date);
								contractStageFee1.setUpdateUser(user);
								contractStageFee1.setCreateDate(date);
								contractStageFee1.setCreateUser(user);
								contractStageFeeDAO.add(contractStageFee1);
							}
						}
					}
					cal.setTime(contract.getStartDate());
					ContractStage contractStage = new ContractStage();
					contractStage.setStage(stage);
					contractStage.setContract(contract);
					contractStage.setCapital(principal);
					contractStage.setInterest(0);
					// if (stage % 12 == 11) {
					// contractStage.setExtraCharges(gpsinstall.getCostValue());

					// } else {
					contractStage.setExtraCharges(0);
					// }
					contractStage.setRepaymentDate(getCalendar(cal, stage).getTime());
					contractStage.setRealrepaymentDate(contractStage.getRepaymentDate());
					contractStage.setUpdateDate(date);
					contractStage.setUpdateUser(user);
					contractStage.setCreateDate(date);
					contractStage.setCreateUser(user);
					contractStageDAO.add(contractStage);
					// if (stage % 12 == 11) {
					// ContractStageFee contractStageFeei = new ContractStageFee();
					// contractStageFeei.setCostType(costTypeDAO.getById(3));
					// contractStageFeei.setFee(gpsinstall.getCostValue());
					// contractStageFeei.setStage(contractStage);
					// contractStageFeeDAO.add(contractStageFeei);
					// }
					return true;
				}
			}
		} else {
			for (ContractGpsLateFee gpsinstall : contractGpsLateFeeDAO
					.findContractGpsLateFeeListByCustomerContract(contract)) {
				GpsCostTypeService gpsCostTypeService = (GpsCostTypeService) SpringUtil.getBean("GpsCostTypeService");
				GpsCostType gpsCostType = gpsCostTypeService.getById(gpsinstall.getType().getId());
				if (gpsCostType.getGpsCostType().equals("年租")) {
					double principal = contract.getAmount();
					double interest = contractParaDAO.findValueByContractAndPara(contract,
							productParameterDAO.getById(2));
					double interestAmount = Double.valueOf(df.format(contract.getAmount() * interest / 100));
					CustomerContract customerContract = customerContractDAO.getById(contract.getId());
					customerContract.setPrincipal(principal);
					customerContract.setUpdateDate(date);
					customerContract.setUpdateUser(user);
					customerContractDAO.update(customerContract);
					ContractStage contractStage0 = new ContractStage();

					contractStage0.setStage(0);
					contractStage0.setContract(contract);
					contractStage0.setCapital(0);
					contractStage0.setState(1);
					contractStage0.setInterest(interestAmount);
					contractStage0.setExtraCharges(gpsinstall.getCostValue() + contract.getContractManageValue());
					contractStage0.setRepaymentDate(cal.getTime());
					contractStage0.setRealrepaymentDate(contractStage0.getRepaymentDate());
					contractStage0.setUpdateDate(date);
					contractStage0.setUpdateUser(user);
					contractStage0.setCreateDate(date);
					contractStage0.setCreateUser(user);
					contractStageDAO.add(contractStage0);

					ContractRepayment contractRepayment0 = new ContractRepayment();
					contractRepayment0.setCapital(contractStage0.getCapital());
					contractRepayment0.setInterest(contractStage0.getInterest());
					contractRepayment0.setPayment(contract.getName());
					contractRepayment0.setRepaymentDate(contractStage0.getRepaymentDate());
					contractRepayment0.setExtraCharges(contractStage0.getExtraCharges());
					contractRepayment0.setRepaymentFee(contractStage0.getCapital() + contractStage0.getInterest()
							+ contractStage0.getExtraCharges());
					contractRepayment0.setStage(contractStage0);
					contractRepayment0.setCreateDate(date);
					contractRepayment0.setCreateUser(user);
					contractRepayment0.setUpdateDate(date);
					contractRepayment0.setUpdateUser(user);
					contractRepayment0.setState(1);
					contractRepaymentDAO.add(contractRepayment0);

					List<CusContractCost> costs = cusContractCostDAO.getCusContractCostByContract(contract);
					for (CusContractCost cost : costs) {
						ContractStageFee contractStageFee = new ContractStageFee();
						contractStageFee.setCostType(cost.getCostType());
						contractStageFee.setFee(cost.getValue());
						contractStageFee.setStage(contractStage0);
						contractStageFee.setUpdateDate(date);
						contractStageFee.setUpdateUser(user);
						contractStageFee.setCreateDate(date);
						contractStageFee.setCreateUser(user);
						contractStageFeeDAO.add(contractStageFee);

						CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
						otherFee.setCostType(contractStageFee.getCostType());
						otherFee.setCreateDate(date);
						otherFee.setCreateUser(user);
						otherFee.setDefaultValue(contractStageFee.getFee());
						otherFee.setRepayment(contractRepayment0);
						otherFee.setUpdateDate(date);
						otherFee.setUpdateUser(user);
						otherFee.setValue(contractStageFee.getFee());
						cusContractRepaymentOtherFeeDAO.add(otherFee);
					}
					ContractStageFee contractStageFee = new ContractStageFee();
					contractStageFee.setCostType(costTypeDAO.getById(9));
					contractStageFee.setFee(gpsinstall.getCostValue());
					contractStageFee.setStage(contractStage0);
					contractStageFee.setUpdateDate(date);
					contractStageFee.setUpdateUser(user);
					contractStageFee.setCreateDate(date);
					contractStageFee.setCreateUser(user);
					contractStageFeeDAO.add(contractStageFee);

					CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
					otherFee.setCostType(contractStageFee.getCostType());
					otherFee.setDefaultValue(contractStageFee.getFee());
					otherFee.setValue(contractStageFee.getFee());
					otherFee.setRepayment(contractRepayment0);
					otherFee.setCreateDate(date);
					otherFee.setCreateUser(user);
					otherFee.setUpdateDate(date);
					otherFee.setUpdateUser(user);
					cusContractRepaymentOtherFeeDAO.add(otherFee);

					if (contract.getContractManageValue() != 0) {
						ContractStageFee contractStageFee1 = new ContractStageFee();
						contractStageFee1.setCostType(costTypeDAO.getById(15));
						contractStageFee1.setFee(contract.getContractManageValue());
						contractStageFee1.setStage(contractStage0);
						contractStageFee1.setUpdateDate(date);
						contractStageFee1.setUpdateUser(user);
						contractStageFee1.setCreateDate(date);
						contractStageFee1.setCreateUser(user);
						contractStageFeeDAO.add(contractStageFee1);

						CusContractRepaymentOtherFee otherFee1 = new CusContractRepaymentOtherFee();
						otherFee1.setCostType(contractStageFee1.getCostType());
						otherFee1.setDefaultValue(contractStageFee1.getFee());
						otherFee1.setValue(contractStageFee1.getFee());
						otherFee1.setRepayment(contractRepayment0);
						otherFee1.setCreateDate(date);
						otherFee1.setCreateUser(user);
						otherFee1.setUpdateDate(date);
						otherFee1.setUpdateUser(user);
						cusContractRepaymentOtherFeeDAO.add(otherFee1);
					}
					if (stage > 1) {
						for (int i = 1; i < stage; i++) {
							cal.setTime(contract.getStartDate());
							ContractStage contractStagei = new ContractStage();
							contractStagei.setStage(i);
							contractStagei.setContract(contract);
							contractStagei.setCapital(0);
							contractStagei.setInterest(interestAmount);
							if (i % 12 == 11 && stage > i + 1) {
								contractStagei.setExtraCharges(gpsinstall.getCostValue());

							} else {
								contractStagei.setExtraCharges(0);
							}
							contractStagei.setRepaymentDate(getCalendar(cal, i).getTime());
							contractStagei.setRealrepaymentDate(contractStagei.getRepaymentDate());
							contractStagei.setUpdateDate(date);
							contractStagei.setUpdateUser(user);
							contractStagei.setCreateDate(date);
							contractStagei.setCreateUser(user);
							contractStageDAO.add(contractStagei);
							if (i % 12 == 11 && stage > i + 1) {
								ContractStageFee contractStageFeei = new ContractStageFee();
								contractStageFeei.setCostType(costTypeDAO.getById(9));
								contractStageFeei.setFee(gpsinstall.getCostValue());
								contractStageFeei.setStage(contractStagei);
								contractStageFeei.setUpdateDate(date);
								contractStageFeei.setUpdateUser(user);
								contractStageFeei.setCreateDate(date);
								contractStageFeei.setCreateUser(user);
								contractStageFeeDAO.add(contractStageFeei);
							}
							if (contract.getContractManageValue() != 0) {
								ContractStageFee contractStageFeei = new ContractStageFee();
								contractStageFeei.setCostType(costTypeDAO.getById(15));
								contractStageFeei.setFee(contract.getContractManageValue());
								contractStageFeei.setStage(contractStagei);
								contractStageFeei.setUpdateDate(date);
								contractStageFeei.setUpdateUser(user);
								contractStageFeei.setCreateDate(date);
								contractStageFeei.setCreateUser(user);
								contractStageFeeDAO.add(contractStageFeei);
							}
						}
					}
					cal.setTime(contract.getStartDate());
					ContractStage contractStage = new ContractStage();
					contractStage.setStage(stage);
					contractStage.setContract(contract);
					contractStage.setCapital(principal);
					contractStage.setInterest(0);
					// if (stage % 12 == 11) {
					// contractStage.setExtraCharges(gpsinstall.getCostValue());

					// } else {
					contractStage.setExtraCharges(0);
					// }
					contractStage.setRepaymentDate(getCalendar(cal, stage).getTime());
					contractStage.setRealrepaymentDate(contractStage.getRepaymentDate());
					contractStage.setUpdateDate(date);
					contractStage.setUpdateUser(user);
					contractStage.setCreateDate(date);
					contractStage.setCreateUser(user);
					contractStageDAO.add(contractStage);
					// if (stage % 12 == 11) {
					// ContractStageFee contractStageFeei = new ContractStageFee();
					// contractStageFeei.setCostType(costTypeDAO.getById(9));
					// contractStageFeei.setFee(gpsinstall.getCostValue());
					// contractStageFeei.setStage(contractStage);
					// contractStageFeeDAO.add(contractStageFeei);
					// }
					return true;
				} else if (gpsCostType.getGpsCostType().equals("月租")) {
					double principal = contract.getAmount();
					double interest = contractParaDAO.findValueByContractAndPara(contract,
							productParameterDAO.getById(2));
					double interestAmount = Double.valueOf(df.format(contract.getAmount() * interest / 100));
					CustomerContract customerContract = customerContractDAO.getById(contract.getId());
					customerContract.setPrincipal(principal);
					customerContract.setUpdateDate(date);
					customerContract.setUpdateUser(user);
					customerContractDAO.update(customerContract);
					ContractStage contractStage0 = new ContractStage();

					contractStage0.setStage(0);
					contractStage0.setContract(contract);
					contractStage0.setCapital(0);
					contractStage0.setState(1);
					contractStage0.setInterest(interestAmount);
					contractStage0.setExtraCharges(gpsinstall.getCostValue() + contract.getContractManageValue());
					contractStage0.setRepaymentDate(cal.getTime());
					contractStage0.setRealrepaymentDate(contractStage0.getRepaymentDate());
					contractStage0.setUpdateDate(date);
					contractStage0.setUpdateUser(user);
					contractStage0.setCreateDate(date);
					contractStage0.setCreateUser(user);
					contractStageDAO.add(contractStage0);

					ContractRepayment contractRepayment0 = new ContractRepayment();
					contractRepayment0.setCapital(contractStage0.getCapital());
					contractRepayment0.setInterest(contractStage0.getInterest());
					contractRepayment0.setPayment(contract.getName());
					contractRepayment0.setExtraCharges(contractStage0.getExtraCharges());
					contractRepayment0.setRepaymentDate(contractStage0.getRepaymentDate());
					contractRepayment0.setRepaymentFee(contractStage0.getCapital() + contractStage0.getInterest()
							+ contractStage0.getExtraCharges());
					contractRepayment0.setStage(contractStage0);
					contractRepayment0.setCreateDate(date);
					contractRepayment0.setCreateUser(user);
					contractRepayment0.setUpdateDate(date);
					contractRepayment0.setUpdateUser(user);
					contractRepayment0.setState(1);
					contractRepaymentDAO.add(contractRepayment0);

					List<CusContractCost> costs = cusContractCostDAO.getCusContractCostByContract(contract);
					for (CusContractCost cost : costs) {
						ContractStageFee contractStageFee = new ContractStageFee();
						contractStageFee.setCostType(cost.getCostType());
						contractStageFee.setFee(cost.getValue());
						contractStageFee.setStage(contractStage0);
						contractStageFee.setUpdateDate(date);
						contractStageFee.setUpdateUser(user);
						contractStageFee.setCreateDate(date);
						contractStageFee.setCreateUser(user);
						contractStageFeeDAO.add(contractStageFee);

						CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
						otherFee.setCostType(contractStageFee.getCostType());
						otherFee.setCreateDate(date);
						otherFee.setCreateUser(user);
						otherFee.setDefaultValue(contractStageFee.getFee());
						otherFee.setRepayment(contractRepayment0);
						otherFee.setUpdateDate(date);
						otherFee.setUpdateUser(user);
						otherFee.setValue(contractStageFee.getFee());
						cusContractRepaymentOtherFeeDAO.add(otherFee);
					}
					ContractStageFee contractStageFee = new ContractStageFee();
					contractStageFee.setCostType(costTypeDAO.getById(9));
					contractStageFee.setFee(gpsinstall.getCostValue());
					contractStageFee.setStage(contractStage0);
					contractStageFee.setUpdateDate(date);
					contractStageFee.setUpdateUser(user);
					contractStageFee.setCreateDate(date);
					contractStageFee.setCreateUser(user);
					contractStageFeeDAO.add(contractStageFee);

					CusContractRepaymentOtherFee otherFee = new CusContractRepaymentOtherFee();
					otherFee.setCostType(contractStageFee.getCostType());
					otherFee.setDefaultValue(contractStageFee.getFee());
					otherFee.setValue(contractStageFee.getFee());
					otherFee.setRepayment(contractRepayment0);
					otherFee.setCreateDate(date);
					otherFee.setCreateUser(user);
					otherFee.setUpdateDate(date);
					otherFee.setUpdateUser(user);
					cusContractRepaymentOtherFeeDAO.add(otherFee);

					if (contract.getContractManageValue() != 0) {
						ContractStageFee contractStageFee1 = new ContractStageFee();
						contractStageFee1.setCostType(costTypeDAO.getById(15));
						contractStageFee1.setFee(contract.getContractManageValue());
						contractStageFee1.setStage(contractStage0);
						contractStageFee1.setUpdateDate(date);
						contractStageFee1.setUpdateUser(user);
						contractStageFee1.setCreateDate(date);
						contractStageFee1.setCreateUser(user);
						contractStageFeeDAO.add(contractStageFee1);

						CusContractRepaymentOtherFee otherFee1 = new CusContractRepaymentOtherFee();
						otherFee1.setCostType(contractStageFee1.getCostType());
						otherFee1.setDefaultValue(contractStageFee1.getFee());
						otherFee1.setValue(contractStageFee1.getFee());
						otherFee1.setRepayment(contractRepayment0);
						otherFee1.setCreateDate(date);
						otherFee1.setCreateUser(user);
						otherFee1.setUpdateDate(date);
						otherFee1.setUpdateUser(user);
						cusContractRepaymentOtherFeeDAO.add(otherFee1);
					}
					if (stage > 1) {
						for (int i = 1; i < stage; i++) {
							cal.setTime(contract.getStartDate());
							ContractStage contractStagei = new ContractStage();
							contractStagei.setStage(i);
							contractStagei.setContract(contract);
							contractStagei.setCapital(0);
							contractStagei.setInterest(interestAmount);
							contractStagei.setExtraCharges(gpsinstall.getCostValue());
							contractStagei.setRepaymentDate(getCalendar(cal, i).getTime());
							contractStagei.setRealrepaymentDate(contractStagei.getRepaymentDate());
							contractStagei.setUpdateDate(date);
							contractStagei.setUpdateUser(user);
							contractStagei.setCreateDate(date);
							contractStagei.setCreateUser(user);
							contractStageDAO.add(contractStagei);
							ContractStageFee contractStageFeei = new ContractStageFee();
							contractStageFeei.setCostType(costTypeDAO.getById(9));
							contractStageFeei.setFee(gpsinstall.getCostValue());
							contractStageFeei.setStage(contractStagei);
							contractStageFeei.setUpdateDate(date);
							contractStageFeei.setUpdateUser(user);
							contractStageFeei.setCreateDate(date);
							contractStageFeei.setCreateUser(user);
							contractStageFeeDAO.add(contractStageFeei);
							if (contract.getContractManageValue() != 0) {
								ContractStageFee contractStageFee1 = new ContractStageFee();
								contractStageFee1.setCostType(costTypeDAO.getById(15));
								contractStageFee1.setFee(contract.getContractManageValue());
								contractStageFee1.setStage(contractStagei);
								contractStageFee1.setUpdateDate(date);
								contractStageFee1.setUpdateUser(user);
								contractStageFee1.setCreateDate(date);
								contractStageFee1.setCreateUser(user);
								contractStageFeeDAO.add(contractStageFee1);
							}
						}
					}
					cal.setTime(contract.getStartDate());
					ContractStage contractStage = new ContractStage();
					contractStage.setStage(stage);
					contractStage.setContract(contract);
					contractStage.setCapital(principal);
					contractStage.setInterest(0);
					contractStage.setExtraCharges(0);
					contractStage.setRepaymentDate(getCalendar(cal, stage).getTime());
					contractStage.setRealrepaymentDate(contractStage.getRepaymentDate());
					contractStage.setUpdateDate(date);
					contractStage.setUpdateUser(user);
					contractStage.setCreateDate(date);
					contractStage.setCreateUser(user);
					contractStageDAO.add(contractStage);
					return true;
				}
			}
		}
		return true;
	}

	/**
	 * 获得合同分期
	 * 
	 * @param contract
	 *            合同
	 * @return 合同分期列表
	 * @throws UpdateException
	 */
	public List<ContractStage> getContractStageByContract(CustomerContract contract)
			throws DAOException, UpdateException {
		// setContractStageRemark(contract);
		return contractStageDAO.findContractStageByContract(contract);
	}

	/**
	 * 获得分期还款
	 * 
	 * @param type
	 *            类型
	 * @param amount
	 *            借款金额
	 * @param startDate
	 *            开始日期
	 * @param stage
	 *            分期期数
	 * @param extraFee
	 *            额外费用
	 * @param preValue
	 *            前置值
	 * @param interest
	 *            利息
	 * @return 日期对应的还款金额
	 */
	public Map<String, Double> getRepaymentStage(int type, double amount, Date startDate, int stage, double extraFee,
			double preValue, double interest) {
		Map<String, Double> map = new HashMap<String, Double>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (type == 1) {
			double principal = amount + amount * (preValue / 100) * stage;
			double perPrincipal = principal / stage;
			double interestAmount = amount * interest / 100;
			map.put(sdf.format(cal.getTime()), interestAmount + extraFee);
			for (int i = 1; i < stage; i++) {
				cal.setTime(startDate);
				map.put(sdf.format(getCalendar(cal, i).getTime()), perPrincipal + interestAmount);
			}
			cal.setTime(startDate);
			map.put(sdf.format(getCalendar(cal, stage).getTime()), perPrincipal);
			return map;
		}
		double interestAmount = amount * interest / 100;
		map.put(sdf.format(cal.getTime()), interestAmount + extraFee);
		for (int i = 1; i < stage; i++) {
			cal.setTime(startDate);
			map.put(sdf.format(getCalendar(cal, i).getTime()), interestAmount);
		}
		cal.setTime(startDate);
		map.put(sdf.format(getCalendar(cal, stage).getTime()), amount);
		return map;
	}

	/**
	 * 通过日期和门店获得合同分期
	 * 
	 * @param date
	 *            日期
	 * @param store
	 *            门店 null表示所有门店
	 * @return 合同分期列表
	 */
	public List<ContractStage> getContractStageByDateAndStore(Date date, Store store) throws DAOException {
		if (store == null) {
			return contractStageDAO.findContractStageByDate(date);
		} else {
			return contractStageDAO.findContractStageByDateAndStore(date, store);
		}
	}

	/**
	 * 通过门店获得当天合同逾期
	 * 
	 * @param store
	 *            门店 null表示所有门店
	 * @return 合同逾期列表
	 */
	public List<ContractLateFee> getContractLateFeeByDateAndStore(Store store) throws DAOException {
		if (store == null) {
			return contractLateFeeDAO.findContractLateFeeByToday();
		} else {
			return contractLateFeeDAO.findContractLateFeeByTodayAndStore(store);
		}
	}

	/**
	 * 通过门店获得当天合同逾期 CusContractCost
	 * 
	 * @param store
	 *            门店 null表示所有门店
	 * @return 合同对应的逾期费用
	 */
	public Map<CustomerContract, Double> getContractLateFeeOnMapByTodayAndStore(Store store) throws DAOException {
		Map<CustomerContract, Double> map = new HashMap<CustomerContract, Double>();
		if (store == null) {
			if (!contractLateFeeDAO.findContractLateFeeByToday().isEmpty()) {
				for (ContractLateFee contractLateFee : contractLateFeeDAO.findContractLateFeeByToday()) {
					map.put(contractLateFee.getContract(), contractLateFee.getTotalLateFee());
				}
				// return map;
			}
			return map;
		}
		if (!contractLateFeeDAO.findContractLateFeeByTodayAndStore(store).isEmpty()) {
			for (ContractLateFee contractLateFee : contractLateFeeDAO.findContractLateFeeByTodayAndStore(store)) {
				map.put(contractLateFee.getContract(), contractLateFee.getTotalLateFee());
			}
			// return map;
		}
		return map;
	}

	// 过期天数
	public int getOverdueDays(Date repaymentDate) {
		Date nowDate = Calendar.getInstance().getTime();
		int days = (int) ((nowDate.getTime() - repaymentDate.getTime()) / (1000 * 3600 * 24));
		return days + 1;
	}

	/**
	 * 自动获取当天逾期合同和其逾期费用
	 * 
	 * @throws DataNotFoundException
	 * @throws UpdateException
	 */
	public void autoTotalLateFee() throws DAOException, CreateException, DataNotFoundException, UpdateException {
		System.out.println("自动获取当天逾期合同和其逾期费用");
		List<ContractStage> contractStages = contractStageDAO.findLateTimeContractStage();
		if (!contractStages.isEmpty()) {
			// List<CustomerContract> customerContracts = new ArrayList<CustomerContract>();
			for (ContractStage contractStage : contractStages) {
				ContractLateFee contractLateFee = new ContractLateFee();
				contractLateFee.setContract(contractStage.getContract());
				contractLateFee.setContractStage(contractStage);
				contractLateFee.setOverDueTime(Calendar.getInstance().getTime());
				contractLateFee.setUnitTimeLateFee(contractStage.getContract().getAmount() * 0.3 / 100);
				contractLateFee.setCreateDate(Calendar.getInstance().getTime());
				int overdueDays = getOverdueDays(contractStage.getRepaymentDate());
				double totalLateFee = contractLateFee.getUnitTimeLateFee() * overdueDays;
				contractLateFee.setTotalLateFee(totalLateFee);
				if (contractLateFeeDAO.getSameContractLateFeeCountByDay(contractStage.getContract()) == 0) {
					contractLateFeeDAO.add(contractLateFee);
				}
				CustomerContract contract = customerContractDAO.getById(contractLateFee.getContract().getId());
				contract.setState(2);
				contract.setOverdueDays(overdueDays);
				contract.setLateFee(totalLateFee);
				customerContractDAO.update(contract);
			}
		}
	}

	/**
	 * @category 根据合同编号查找合同
	 * @param contractNum
	 * @return
	 * @throws DAOException
	 */
	public CustomerContract getContractByNum(String contractNum) throws DAOException {
		return customerContractDAO.getContractByNum(contractNum);
	}

	public List<CustomerContract> getCustomerContractByStoreAndDate(Store store, Date begin, Date end)
			throws DAOException {
		return customerContractDAO.findCustomerContractByStoreAndDate(store, begin, end);
	}

	// 放款类型
	public String getLoadType(CustomerContract contract) throws DAOException {
		String loadType = "";
		if (contract.getProduct() != null) {
			loadType = contract.getProduct().getRepaymentType() == null ? ""
					: contract.getProduct().getRepaymentType().getRepaymentType();
		}
		// List<ContractPara> paras =
		// contractParaDAO.getContractParaByContract(contract);
		// for (ContractPara para : paras) {
		// if (para.getPara().getId() == 1) {
		// loadType = loadType + "等额";
		// return loadType;
		// }
		// }
		// loadType = loadType + "先息";
		return loadType;
	}

	// 到期日期
	public Date getDueDate(CustomerContract contract) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(contract.getStartDate());
		int stage = contract.getStage().getRepaymentStage();
		// SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date dueDate = getCalendar(cal, stage).getTime();
		return dueDate;
	}

	// 合同日期即放款日期
	public Date getBeginDate(CustomerContract contract) {
		// SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		return contract.getStartDate();
	}

	// 结清日期
	public Date getSettlementDate(CustomerContract contract) {
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (contract.getSettlementDate() != null) {
			return contract.getSettlementDate();
		} else {
			return null;
		}
	}

	// 还款情况
	public String getPaymentCondition(CustomerContract contract) throws DAOException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(contract.getStartDate());
		int stage = contract.getStage().getRepaymentStage();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		if (contract.getSettlementDate() == null) {
			if (contract.getState() != 2) {
				return "正常还款";
			} else {
				return "逾期";
			}
		} else if (contract.getSettlementDate().before(getCalendar(cal, stage).getTime())) {
			return "提前结清";
		} else if (sdf.format(contract.getSettlementDate()).equals(sdf.format(getCalendar(cal, stage).getTime()))) {
			return "正常结清";
		} else if (contract.getAssetsType().getAssetsType().equals("催收资产")) {
			return "催收结清";
		}
		return "";
	}

	// 标的统计表
//	public List<CustomerContractDTO> getCustomerContractDTOByStoreAndDate(Store store, Date begin, Date end)
//			throws DAOException {
//		List<CustomerContract> contracts;
//		if (store != null) {
//			contracts = customerContractDAO.findCustomerContractByStoreAndDate(store, begin, end);
//		} else {
//			contracts = customerContractDAO.findCustomerContractByDate(begin, end);
//		}
//		List<CustomerContractDTO> contractDTOs = new ArrayList<CustomerContractDTO>();
//		for (CustomerContract contract : contracts) {
//			if (contract == null) {
//				continue;
//			}
//			CustomerContractDTO contractDTO = new CustomerContractDTO();
//			contractDTO.setContract(contract);
//			contractDTO.setName(contract.getStore().getShortName());
//			contractDTO.setLoadType(getLoadType(contract));
//			contractDTO.setBeginDate(getBeginDate(contract));
//			contractDTO.setDueDate(getDueDate(contract));
//			contractDTO.setSettlementDate(getSettlementDate(contract));
//			contractDTO.setPaymentCondition(getPaymentCondition(contract));
//			contractDTO.setBusinessSource(getBusinessSource(contract));// 业务来源
//			contractDTO.setAssetsType(getAssetsType(contract));// 资产类型
//			contractDTOs.add(contractDTO);
//		}
//		return contractDTOs;
//	}

	// 还款日
	public int getRepaymentDay(CustomerContract contract) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(contract.getStartDate());
		return getCalendar(cal, 1).get(Calendar.DAY_OF_MONTH);
	}

	// 每期利息
	public double getPerInterestAmount(CustomerContract contract) throws DAOException {
		Double cishu = 0.00;

		List<ContractPara> listPara = contractParaDAO.getContractParaByContract(contract);
		for (ContractPara para : listPara) {
			if (para != null) {
				cishu += para.getValue();
				if (para.getPara().getId() == 2) {
					if (contract.getProduct().getRepaymentType().getId() == 6) {

						return contract.getAmount() * para.getValue() * 0.01;
					}
				}

			}
		}
		return contract.getAmount() * cishu * 0.01;
	}

	// 每期本金
	public double getPerPrincipal(CustomerContract contract) throws DAOException {
		if (contract != null && contract.getProduct() != null) {
			if (contract.getProduct().getRepaymentType().getId() == 7) {
				if (getSurplusInterestStage(contract) == 0) {
					return contract.getPrincipal();
				}
				return contractStageDAO.findContractStageByContractAndStage(contract, 1) == null ? '0'
						: contractStageDAO.findContractStageByContractAndStage(contract, 1).getCapital();
			}
			return contractStageDAO.findContractStageByContractAndStage(contract, 1) == null ? '0'
					: contractStageDAO.findContractStageByContractAndStage(contract, 1).getCapital();
		}
		return 0;
	}

	// 剩余利息期数
	public int getSurplusInterestStage(CustomerContract contract) throws DAOException {
		return contractStageDAO.getSurplusInterestStage(contract);
	}

	// 剩余本金期数
	public int getSurplusPrincipalStage(CustomerContract contract) throws DAOException {
		return contractStageDAO.getSurplusPrincipalStage(contract);
	}

	// 本金存金量
	public double getPrincipalDeposit(CustomerContract contract) throws DAOException {
		List<ContractStage> stageList = new ArrayList<ContractStage>();
		// 当前合同的所有分期
		stageList = contractStageDAO.getContractStageByContract(contract);
		double repMoney = 0.0;// 还款金额
		for (ContractStage stage : stageList) {
			// 不是第一期并且已经还款
			if (stage.getState() == 1 && stage.getStage() != 0) {
				// 拿到已经还款的分期
				List<ContractRepayment> contractRepayments = contractRepaymentDAO.findContractRepaymentByStage(stage);

				for (ContractRepayment rep : contractRepayments) {
					repMoney += rep.getRepaymentFee();
				}
			}
		}
		return contract.getAmount() - repMoney;

		/*
		 * // 未还本金总额 double suplusPrincipal =
		 * contractStageDAO.getPrincipalDeposit(contract); // 等额本金 if
		 * (contract.getProduct() == null) { return 0; } if
		 * (contract.getProduct().getRepaymentType().getId() == 6) { List<ContractStage>
		 * stageList = new ArrayList<ContractStage>(); //当前合同的所有分期 stageList =
		 * contractStageDAO.getContractStageByContract(contract); double capitalSum =
		 * 0.0; for (ContractStage stage : stageList) { // 不是第一期并且已经还款 if
		 * (stage.getState() == 1 && stage.getStage() != 0) { // 拿到已经还款的分期
		 * List<ContractRepayment> contractRepayments = contractRepaymentDAO
		 * .findContractRepaymentByStage(stage); double repMoney = 0.0;// 还款金额 for
		 * (ContractRepayment rep : contractRepayments) { repMoney +=
		 * rep.getRepaymentFee(); } // 每期分期的总费用 double extraCharge =
		 * contractStageFeeDAO.getExtraCharges(stage); double interest =
		 * stage.getInterest();// 利息 double capital = repMoney - (interest + extraCharge
		 * + stage.getCapital()); if (capital > 0) { capitalSum += capital; } } }
		 * suplusPrincipal -= capitalSum; } return suplusPrincipal;
		 */
	}

	// 本期已还部分本金
	public double getHavePaid(CustomerContract contract) throws DAOException {
		// 获取当期还款记录
		int maxStage = contractStageDAO.getRepaidMax(contract);
		if (maxStage == -1) {
			return 0;
		}
		// 最近的还款记录
		ContractStage stage = contractStageDAO.findContractStageByContractAndStage(contract, maxStage);
		List<ContractRepayment> contractRepayments = contractRepaymentDAO.findContractRepaymentByStage(stage);
		// double extraCharge = contractStageFeeDAO.getExtraCharges(stage);
		double repMoney = 0.0;// 还款金额
		for (ContractRepayment rep : contractRepayments) {
			repMoney += rep.getRepaymentFee();
		}
		/*
		 * double capital = 0.0;// 本金 double interest = stage.getInterest();// 利息 // 本金=
		 * 还款金额-(利息+额外费用) capital = repMoney - (interest + extraCharge);
		 */
		return repMoney;

	}

	// 到账金额
	public double getToAccount(CustomerContract contract) throws DAOException {
		return contract.getAmount() - getExtraFee(contract);
	}

	// 每项额外费用
	public double getPerExtraFee(CustomerContract contract, String costType) throws DAOException {

		List<CusContractCost> costs = cusContractCostDAO.getCusContractCostByContract(contract);
		for (CusContractCost cost : costs) {
			if (cost.getCostType().getCostType().equals(costType)) {
				return cost.getValue();
			}
		}
		return 0;
	}

	// 业务员
	@SuppressWarnings("unlikely-arg-type")
	public String getSalesman(CustomerContract contract) {
		if (contract.getResponsiblePerson() != null && !contract.getResponsiblePerson().equals("")) {
			return contract.getResponsiblePerson().getName();
		}
		return "";
	}

	// 主管
	@SuppressWarnings("unlikely-arg-type")
	public String getDirector(CustomerContract contract) {
		if (contract.getResponsiblePerson() != null && !contract.getResponsiblePerson().equals("")) {
			if (contract.getResponsiblePerson().getDepartment() != null
					&& !contract.getResponsiblePerson().getDepartment().equals("")) {
				if (contract.getResponsiblePerson().getDepartment().getDeparmentSupervisor() != null
						&& contract.getResponsiblePerson().getDepartment().getDeparmentSupervisor().equals("")) {
					return contract.getResponsiblePerson().getDepartment().getDeparmentSupervisor().getName();// 主管
				}
			}
		}
		return "";
	}

	// 总监
	@SuppressWarnings("unlikely-arg-type")
	public String getMajordomo(CustomerContract contract) {
		if (contract.getResponsiblePerson() != null && !contract.getResponsiblePerson().equals("")) {
			if (contract.getResponsiblePerson().getDirector() != null
					&& !contract.getResponsiblePerson().getDirector().equals("")) {
				return contract.getResponsiblePerson().getDirector().getName();// 总监
			}

		}
		return "";
	}

	// 资产类型
	@SuppressWarnings("unlikely-arg-type")
	public String getAssetsType(CustomerContract contract) {
		if (contract.getAssetsType() != null && !contract.getAssetsType().equals("")) {
			if (contract.getAssetsType().getAssetsType() != null) {
				return contract.getAssetsType().getAssetsType();// 资产类型
			}

		}
		return "";
	}

	// 购买日期
	@SuppressWarnings("unlikely-arg-type")
	public Date getInitialDateOfRegistration(CustomerContract contract) {
		if (contract.getVehicleInfo() != null && !contract.getVehicleInfo().equals("")) {
			return contract.getVehicleInfo().getInitialDateOfRegistration();
		}
		return null;

	}

	// 保险到期日期
	@SuppressWarnings("unlikely-arg-type")
	public Date getInsuranceExpirationDate(CustomerContract contract) {
		if (contract.getVehicleInfo() != null && !contract.getVehicleInfo().equals("")) {
			return contract.getVehicleInfo().getInsuranceExpirationDate();
		}
		return null;

	}

	// 年检到期日期
	@SuppressWarnings("unlikely-arg-type")
	public Date getAnnualRiskDueDate(CustomerContract contract) {
		if (contract.getVehicleInfo() != null && !contract.getVehicleInfo().equals("")) {
			return contract.getVehicleInfo().getAnnualRiskDueDate();
		}
		return null;

	}

	// 按揭还款日
	@SuppressWarnings("unlikely-arg-type")
	public Date getMortgageRepaymentDate(CustomerContract contract) {
		if (contract.getVehicleInfo() != null && !contract.getVehicleInfo().equals("")) {
			return contract.getVehicleInfo().getMortgageRepaymentDate();
		}
		return null;

	}

	// 按揭到期日
	@SuppressWarnings("unlikely-arg-type")
	public Date getMortgageDueDate(CustomerContract contract) {
		if (contract.getVehicleInfo() != null && !contract.getVehicleInfo().equals("")) {
			return contract.getVehicleInfo().getMortgageDueDate();
		}
		return null;
	}

	// 总表
	@SuppressWarnings("unlikely-arg-type")
//	public List<TotalDto> getTotalDtoByStoreAndDate(Store store, Date begin, Date end) throws DAOException {
//		List<CustomerContract> contracts;
//		if (store != null) {
//			contracts = customerContractDAO.findCustomerContractByStoreAndDate(store, begin, end);
//		} else {
//			contracts = customerContractDAO.findCustomerContractByDate(begin, end);
//		}
//		List<TotalDto> totalDtos = new ArrayList<TotalDto>();
//		for (CustomerContract contract : contracts) {
//			if (contract == null) {
//
//				continue;
//			}
//			TotalDto totalDto = new TotalDto();
//			totalDto.setStore(store);
//			totalDto.setContract(contract);
//			totalDto.setContractNo(contract.getContractNum());
//			totalDto.setSalesman(getSalesman(contract));// 业务员
//			totalDto.setDirector(getDirector(contract));// 主管
//			totalDto.setMajordomo(getMajordomo(contract));// 总监
//			totalDto.setBusinessSource(getBusinessSource(contract));// 业务来源
//			totalDto.setAssetsType(getAssetsType(contract));// 资产类型
//			totalDto.setInitialDateOfRegistration(getInitialDateOfRegistration(contract));// 购买日期
//			totalDto.setInsuranceExpirationDate(getInsuranceExpirationDate(contract));// 保险到期日期
//			totalDto.setAnnualRiskDueDate(getAnnualRiskDueDate(contract));// 年检到期日期
//			totalDto.setMortgageRepaymentDate(getMortgageRepaymentDate(contract));// 按揭还款日
//			totalDto.setMortgageDueDate(getMortgageDueDate(contract));// 按揭到期日
//			totalDto.setDay(getRepaymentDay(contract));// 还款日 合同开始日期天数-1
//			totalDto.setLoadType(getLoadType(contract));// 放款类型
//			totalDto.setPerInterestAmount(getPerInterestAmount(contract));// 每期利息
//			totalDto.setPerPrincipal(getPerPrincipal(contract));// 每期本金
//			totalDto.setPrincipalDeposit(getPrincipalDeposit(contract));// 本金存金量
//			totalDto.setSurplusInterestStage(getSurplusInterestStage(contract));// 剩余利息期数
//			totalDto.setSurplusPrincipalStage(getSurplusPrincipalStage(contract));// 剩余本金期数
//			totalDto.setHavePaid(getHavePaid(contract));// 本期已还部分本金
//
//			totalDto.setPaymentCondition(getPaymentCondition(contract));// 还款情况
//			totalDto.setCheckFileFee(getPerExtraFee(contract, "查档费"));
//			totalDto.setFormlityFee(getPerExtraFee(contract, "放款手续费"));
//			totalDto.setGpsFee(getPerExtraFee(contract, "GPS费用"));
//			totalDto.setGpsTeardownFee(getPerExtraFee(contract, "GPS安装费"));
//			totalDto.setHomeVisitFee(getPerExtraFee(contract, "家访费"));
//			totalDto.setInsuranceDeposit(getPerExtraFee(contract, "保险押金"));
//			totalDto.setMortgageRegistrationFee(getPerExtraFee(contract, "抵押登记费"));
//			totalDto.setNotarialFee(getPerExtraFee(contract, "律师公证费"));
//			totalDto.setOtherDeposit(getPerExtraFee(contract, "其它押金"));
//			totalDto.setViolationDeposit(getPerExtraFee(contract, "违章押金"));
//			totalDto.setOtherFee(getPerExtraFee(contract, "其它费用"));
//			totalDto.setParkingFee(getPerExtraFee(contract, "停车费"));
//			double summ = totalDto.getCheckFileFee() + totalDto.getFormlityFee() + totalDto.getGpsFee()
//					+ totalDto.getGpsTeardownFee() + totalDto.getHomeVisitFee() + totalDto.getInsuranceDeposit()
//					+ totalDto.getMortgageRegistrationFee() + totalDto.getNotarialFee() + totalDto.getOtherFee()
//					+ totalDto.getOtherDeposit() + totalDto.getViolationDeposit() + totalDto.getParkingFee();
//			totalDto.setToAccount(contract.getAmount() - summ - totalDto.getPerInterestAmount());// 到账金额
//			totalDtos.add(totalDto);
//		}
//		return totalDtos;
//	}

	// GPS费
	public double getGpsCost(ContractStage contractStage) throws DAOException {
		List<ContractStageFee> contractStageFee = contractStageFeeDAO
				.findContractStageFeeByContractStage(contractStage);
		for (ContractStageFee stageFee : contractStageFee) {
			if (stageFee != null) {
				if (stageFee.getCostType().getId() == 9) {
					return stageFee.getFee();
				}
			}
		}
		return 0;
	}

	// 停车费
	public double getParkingFee(ContractStage contractStage) throws DAOException {
		List<ContractStageFee> contractStageFee = contractStageFeeDAO
				.findContractStageFeeByContractStage(contractStage);
		for (ContractStageFee stageFee : contractStageFee) {
			if (stageFee != null) {
				if (stageFee.getCostType().getId() == 3) {
					return stageFee.getFee();
				}
			}
		}
		return 0;
	}

	// 服务费
	public double getServiceCost(ContractStage contractStage) throws DAOException {
		if (contractStage.getContract().getStage().getRepaymentStage() == contractStage.getStage()) {
			return 0;
		}
		CustomerContract contract = contractStage.getContract();
		List<ContractPara> listPara = contractParaDAO.getContractParaByContract(contract);
		if (listPara != null) {
			for (ContractPara para : listPara) {
				if (para != null) {
					if (para.getPara().getId() == 2) {
						if (para.getContract().getProduct().getRepaymentType().getId() == 7) {
							if (para.getValue() > 1.5) {
								return para.getContract().getAmount() * (para.getValue() - 1.5) * 0.01;
							}
						}
					}
				}
			}
		}
		return 0;
	}

	// 月还利息
	public double getInterestAmount(ContractStage stage) throws DAOException {
		if (stage.getContract().getStage().getRepaymentStage() == stage.getStage()) {
			return 0;
		}
		List<ContractPara> listPara = contractParaDAO.getContractParaByContract(stage.getContract());
		if (listPara != null) {
			for (ContractPara para : listPara) {
				if (para != null) {
					if (para.getPara().getId() == 2) {

						if (para.getValue() > 1.5) {
							if (stage.getContract().getProduct().getRepaymentType().getId() == 7) {
								return stage.getContract().getAmount() * 1.5 * 0.01;
							}
							return stage.getContract().getAmount() * para.getValue() * 0.01;
						}
						return stage.getContract().getAmount() * para.getValue() * 0.01;
					}
				}
			}
		}
		return 0;
	}

	// 月还本金
	public double getPerPrincipal(CustomerContract contract, int stage) throws DAOException {
		return contractStageDAO.findContractStageByContractAndStage(contract, stage).getCapital();
	}

	// 月还总金额
	public double getTotalAmount(ContractStage contractStage) throws DAOException {
		return getGpsCost(contractStage) + getParkingFee(contractStage) + contractStage.getInterest()
				+ contractStage.getCapital();
	}

	// 月还款总金额
	public double getTotalAmounts(CustomerContract contract) throws DAOException {
		int maxStage = contractStageDAO.getRepaidMax(contract);
		ContractStage stage = contractStageDAO.findContractStageByContractAndStage(contract, maxStage);
		if (stage != null) {
			return stage.getExtraCharges();
		}
		return 0;
	}

	// 剩余本金
	public double getSurplusPrincipal(ContractStage contractStage) throws DAOException {
		if (contractStage.getStage() == 0) {
			return Double.valueOf(contractStage.getContract().getPrincipal());
		} else {
			if (contractStage.getCapital() == 0) {
				return Double.valueOf(contractStage.getContract().getPrincipal());
			} else if (contractStage.getCapital() == contractStage.getContract().getPrincipal()) {
				return Double.valueOf(contractStage.getContract().getPrincipal() - contractStage.getCapital());
			}
			if (contractStage.getContract().getStage().getRepaymentStage() == contractStage.getStage()) {
				return 0;
			}
			return Double.valueOf(
					contractStage.getContract().getPrincipal() - contractStage.getCapital() * contractStage.getStage());
		}

	}

	// 提前还款总额
	public double getTotalRepayment(ContractStage contractStage) throws DAOException {
		if (contractStage.getStage() == 0 || contractStage.getStage() == 1) {
			return Double.valueOf(contractStage.getContract().getPrincipal());
		} else {
			if (contractStage.getCapital() == 0) {
				return Double.valueOf(contractStage.getContract().getPrincipal());
			} else if (contractStage.getCapital() == contractStage.getContract().getPrincipal()) {
				return Double.valueOf(contractStage.getContract().getPrincipal());
			}

			if (contractStage.getContract().getStage().getRepaymentStage() == contractStage.getStage()) {
				return Double.valueOf(contractStage.getCapital());
			}
			return Double.valueOf(contractStage.getContract().getPrincipal()
					- contractStage.getCapital() * (contractStage.getStage() - 1));
		}
	}

	//
	public String getRepaymentDate(ContractStage contractStage) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(sdf.format(contractStage.getRepaymentDate()));
	}

//	public List<ScheduleDto> getScheduleDtoByContract(CustomerContract contract) throws DAOException {
//		List<ScheduleDto> scheduleDtos = new ArrayList<ScheduleDto>();
//		// 每个合同的所有分期
//		List<ContractStage> contractStages = contractStageDAO.findContractStageByContract(contract);
//		for (ContractStage contractStage : contractStages) {
//			ScheduleDto scheduleDto = new ScheduleDto();
//			scheduleDto.setContractStage(contractStage);
//			scheduleDto.setGpsCost(getGpsCost(contractStage));
//			scheduleDto.setParkingFee(getParkingFee(contractStage));
//			scheduleDto.setServiceFee(getServiceCost(contractStage));
//			scheduleDto.setSurplusPrincipal(getSurplusPrincipal(contractStage));
//			scheduleDto.setTotalAmount(getTotalAmount(contractStage));
//			scheduleDto.setTotalRepayment(getTotalRepayment(contractStage));
//			scheduleDto.setInterestAmount(getInterestAmount(contractStage));
//			scheduleDtos.add(scheduleDto);
//		}
//		return scheduleDtos;
//	}

	// 还款总金额
	public double getContractTotalRepayment(CustomerContract contract) throws DAOException {
		List<ContractStage> contractStages = contractStageDAO.findContractStageByContract(contract);
		double sumMent = 0;
		for (ContractStage stage : contractStages) {
			if (stage.getState() == 1) {
				List<ContractRepayment> ment = contractRepaymentDAO.findContractRepaymentByStageAll(stage);
				if (!ment.isEmpty()) {
					for (ContractRepayment listMent : ment) {
						sumMent += listMent.getRepaymentFee();
					}
				}

			}
		}
		return sumMent;

	}

	// 明细表
//	public List<ContractScheduleDto> getContractScheduleDtoByStoreAndDate(Store store, Date begin, Date end)
//			throws DAOException {
//		List<CustomerContract> contracts;
//		if (store != null) {
//			contracts = customerContractDAO.findCustomerContractByStoreAndDate(store, begin, end);
//		} else {
//			contracts = customerContractDAO.findCustomerContractByDate(begin, end);
//		}
//		List<ContractScheduleDto> contractScheduleDtos = new ArrayList<ContractScheduleDto>();
//		for (CustomerContract contract : contracts) {
//			if (contract == null) {
//				continue;
//			}
//			ContractScheduleDto contractScheduleDto = new ContractScheduleDto();
//			contractScheduleDto.setContract(contract);
//			contractScheduleDto.setDay(getRepaymentDay(contract));
//			contractScheduleDto.setDueDate(getDueDate(contract));
//			contractScheduleDto.setPerInterestAmount(getPerInterestAmount(contract));
//			contractScheduleDto.setPerPrincipal(getPerPrincipal(contract));
//			contractScheduleDto.setTotalRepayment(
//					getPerPrincipal(contract) + getPerInterestAmount(contract) + getTotalAmounts(contract));
//			contractScheduleDto.setScheduleDtos(getScheduleDtoByContract(contract));
//			contractScheduleDto.setInsuranceExpirationDate(getInsuranceExpirationDate(contract));// 保险到期日期
//			contractScheduleDto.setAnnualRiskDueDate(getAnnualRiskDueDate(contract));// 年检到期日期
//
//			// contractScheduleDto.setPrincipal(getPerPrincipal(contract,1));
//			contractScheduleDtos.add(contractScheduleDto);
//		}
//		return contractScheduleDtos;
//	}

	// 前置本金
	public double getFrontPerPrincipal(ContractRepayment contractRepayment) throws DAOException {
		CustomerContract contract = contractRepayment.getStage().getContract();
		return contract.getPrincipal() - contract.getAmount();
	}

	/*
	 * // 其他应付款 public double getOtherPay(ContractRepayment contractRepayment) {
	 * return contractRepayment.getRepaymentFee() -
	 * contractRepayment.getStage().getCapital() -
	 * contractRepayment.getStage().getInterest() -
	 * contractRepayment.getStage().getExtraCharges(); }
	 */
	// 本金
	public Double getPrincipal(ContractRepayment contractRepayment) {
		return contractRepayment.getStage().getCapital();

	}

	// 逾期费
	public Double getLateFee(ContractRepayment contractRepayment) {
		return contractRepayment.getStage().getContract().getLateFee();
	}

	// 还款明细
//	public List<ContractRepaymentDto> getContractRepaymentDtoByStoreAndDate(Store store, Date begin, Date end)
//			throws DAOException {
//		List<ContractRepayment> contractRepayments;
//		if (store != null) {
//			contractRepayments = contractRepaymentDAO.findContractRepaymentByStoreAndDate(store, begin, end);
//		} else {
//			contractRepayments = contractRepaymentDAO.findContractRepaymentByDate(begin, end);
//		}
//		List<ContractRepaymentDto> contractRepaymentDtos = new ArrayList<ContractRepaymentDto>();
//		for (ContractRepayment contractRepayment : contractRepayments) {
//			if (contractRepayment == null) {
//				continue;
//			}
//			ContractRepaymentDto contractRepaymentDto = new ContractRepaymentDto();
//			contractRepaymentDto.setSalesman(getSalesman(contractRepayment.getStage().getContract()));
//			contractRepaymentDto.setDirector(getDirector(contractRepayment.getStage().getContract()));
//			contractRepaymentDto.setChiefInspector(getMajordomo(contractRepayment.getStage().getContract()));
//			contractRepaymentDto.setContractRepayment(contractRepayment);
//			contractRepaymentDto.setFrontPerPrincipal(getFrontPerPrincipal(contractRepayment));// 前置本金
//			contractRepaymentDto.setPrincipal(getPrincipal(contractRepayment));// 本金
//			contractRepaymentDto.setOtherPay(null);
//			contractRepaymentDto.setLateFee(getLateFee(contractRepayment));// 逾期费用
//			contractRepaymentDto.setGpsFee(getGpsCost(contractRepayment.getStage()));// GPS费
//			contractRepaymentDto.setParkingFee(getParkingFee(contractRepayment.getStage()));// 停车费
//			contractRepaymentDto.setPullFee(getPerExtraFee(contractRepayment.getStage().getContract(), "拖车费"));
//			contractRepaymentDto.setDoorFee(getPerExtraFee(contractRepayment.getStage().getContract(), "上门费"));
//			contractRepaymentDto.setSecBetFee(getPerExtraFee(contractRepayment.getStage().getContract(), "二押费"));
//			contractRepaymentDtos.add(contractRepaymentDto);
//		}
//		return contractRepaymentDtos;
//	}

	// 催收前应收回本金
	public double getShouldPrincipal(CustomerContract contract) throws DAOException {
		ContractStage contractStage = contractStageDAO.findContractStageByContractAndLast(contract);
		if (contractStage == null) {
			return 0;
		} else {

			List<ContractPara> paras = contractParaDAO.getContractParaByContract(contract);
			for (ContractPara para : paras) {
				if (para.getPara().getId() == 1) {
					if (contractStage.getStage() == 0) {
						return 0;
					} else {
						int stage = contractStage.getStage();
						double amount = 0;
						for (int i = 0; i <= stage; i++) {
							amount += contractStageDAO.findContractStageByContractAndStage(contract, i).getCapital();
						}
						return amount;
					}
				}
			}
			if (contractStage.getStage() != contract.getStage().getRepaymentStage()) {
				return 0;
			} else {
				return contract.getPrincipal();
			}
		}
	}

	// 催收前应收回利息
	public double getShouldInterest(CustomerContract contract) throws DAOException {

		ContractStage contractStage = contractStageDAO.findContractStageByContractAndLast(contract);
		if (contractStage == null) {
			return 0;
		} else {
			return contractStageDAO.findContractStageByContractAndStage(contract, 0).getInterest()
					* (contractStage.getStage() + 1);
		}
	}

	// 催收前逾期费
	public double getBeforeLateFee(CustomerContract contract) throws DAOException {
		ContractLateFee contractLateFee = contractLateFeeDAO.findContractLateFeeByContractAndLast(contract,
				contract.getSellerDefaultDate());
		if (contractLateFee == null) {
			return 0;
		} else {
			return contractLateFee.getTotalLateFee();
		}
	}

	// 转催收之后逾期费
	public double getAfterLateFee(CustomerContract contract) throws DAOException, ParseException {
		Calendar cal = Calendar.getInstance();
		ContractLateFee contractLateFee = contractLateFeeDAO.findContractLateFeeByContractDate(contract, cal.getTime());// 某时间逾期记录
		ContractLateFee contractLateFee1 = contractLateFeeDAO.findContractLateFeeByContractAndLast(contract,
				contract.getSellerDefaultDate());// 某时间前逾期记录
		if (contractLateFee == null) {
			return 0;
		} else if (contractLateFee1 != null
				&& contractLateFee.getContractStage().getId() == contractLateFee1.getContractStage().getId()) {
			return contractLateFee.getTotalLateFee() - contractLateFee1.getTotalLateFee();
		} else if (contractLateFee1 != null
				&& contractLateFee.getContractStage().getId() != contractLateFee1.getContractStage().getId()) {
			return contractLateFee.getTotalLateFee();
		} else if (contractLateFee1 == null) {
			return contractLateFee.getTotalLateFee();
		}
		return 0;
	}

	// 转催收已收回本金
	public double getHasPrincipal(CustomerContract contract) throws DAOException {
		return contract.getCollectPincipal();
	}

	// 转催收已收回利息
	public double getHasInterest(CustomerContract contract) throws DAOException {
		return contract.getCollectInterest();
	}

	// 转催收已收回逾期费
	public double getHasLateFee(CustomerContract contract) throws DAOException {
		return contract.getCollectLateFee();
	}

	// 剩余未收回本金
	public double getSurplusPrincipal(CustomerContract contract) throws DAOException {
		Calendar cal = Calendar.getInstance();
		int nowYear = cal.get(Calendar.YEAR);
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(contract.getSellerDefaultDate());
		if (nowYear == cal1.get(Calendar.YEAR)) {
			return getShouldPrincipal(contract) - getHasPrincipal(contract);
		} else {
			return 0;
		}
	}

	// 已平账本金金额
	public double getHasFlagPrincipal(CustomerContract contract) throws DAOException {
		return contract.getHasFlagPincipal();
		// Calendar cal = Calendar.getInstance();
		// int nowYear = cal.get(Calendar.YEAR);
		// Calendar cal1 = Calendar.getInstance();
		// cal1.setTime(contract.getSellerDefaultDate());
		// if (nowYear == cal1.get(Calendar.YEAR)) {
		// return 0;
		// } else {
		// return getShouldPrincipal(contract) - getHasPrincipal(contract);
		// }
	}

	// 已平账利息
	public double getHasFlagInterest(CustomerContract contract) throws DAOException {
		return contract.getHasFlagInterest();
		// Calendar cal = Calendar.getInstance();
		// int nowYear = cal.get(Calendar.YEAR);
		// Calendar cal1 = Calendar.getInstance();
		// cal1.setTime(contract.getSellerDefaultDate());
		// if (nowYear == cal1.get(Calendar.YEAR)) {
		// return 0;
		// } else {
		// return getShouldInterest(contract) - getHasInterest(contract);
		// }
	}

	// 已平账逾期费
	public double getHasFlagLateFee(CustomerContract contract) throws DAOException, ParseException {
		return contract.getHasFlagLateFee();
		// Calendar cal = Calendar.getInstance();
		// int nowYear = cal.get(Calendar.YEAR);
		// Calendar cal1 = Calendar.getInstance();
		// cal1.setTime(contract.getSellerDefaultDate());
		// if (nowYear == cal1.get(Calendar.YEAR)) {
		// return 0;
		// } else {
		// return getBeforeLateFee(contract) + getAfterLateFee(contract) -
		// getHasLateFee(contract);
		// }
	}

	// 已平账收回本金金额
	public double getHasFlagHasPrincipal(CustomerContract contract) {
		Calendar cal = Calendar.getInstance();
		int nowYear = cal.get(Calendar.YEAR);
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(contract.getSellerDefaultDate());
		if (nowYear == cal1.get(Calendar.YEAR)) {
			return 0;
		} else {
			return contract.getHasFlagPincipal();
		}
	}

	// 已平账收回利息
	public double getHasFlagHasInterest(CustomerContract contract) {
		Calendar cal = Calendar.getInstance();
		int nowYear = cal.get(Calendar.YEAR);
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(contract.getSellerDefaultDate());
		if (nowYear == cal1.get(Calendar.YEAR)) {
			return 0;
		} else {
			return contract.getHasFlagInterest();
		}
	}

	// 已平账收回逾期费
	public double getHasFlagHasLateFee(CustomerContract contract) {
		Calendar cal = Calendar.getInstance();
		int nowYear = cal.get(Calendar.YEAR);
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(contract.getSellerDefaultDate());
		if (nowYear == cal1.get(Calendar.YEAR)) {
			return 0;
		} else {
			return contract.getHasFlagLateFee();
		}
	}

	// 是否结清
	public String getSettlement(CustomerContract contract) {
		if (contract.getSettlementDate() == null) {
			return "未结清";
		} else {
			return "已结清";
		}
	}

	// 门店
	public String getShortName(CustomerContract contract) {
		String shortName = contract.getStore().getShortName();
		return shortName;
	}

	// 业务来源
	public String getBusinessSource(CustomerContract contract) {
		String businessSource = contract.getBusinessSource() == null ? ""
				: contract.getBusinessSource().getBusinessSource();
		return businessSource;
	}

	// 客户姓名
	public String getName(CustomerContract contract) {
		String name = contract.getName();
		return name;
	}

	// 手机
	public String getPhone(CustomerContract contract) {
		String phone = contract.getPhone();
		return phone;
	}

	// 放款日期
	public Date getLoanDate(CustomerContract contract) {
		if (contract.getStartDate() != null) {
			return contract.getStartDate();
		} else {
			return null;
		}

	}

	// 放款金额
	public double getLoanFee(CustomerContract contract) {
		return contract.getAmount();
	}

	// 转催收时间
	public Date getSellerDefaultDate(CustomerContract contract) {
		if (contract.getSellerDefaultDate() != null) {
			return contract.getSellerDefaultDate();
		} else {
			return null;
		}
	}

	// 拖车日期
	public Date getTrailCarDate(CustomerContract contract) {
		if (contract.getTrailCarDate() != null) {
			return contract.getTrailCarDate();
		} else {
			return null;
		}
	}

	// 卖车金额
	public double getSellCarAmount(CustomerContract contract) {
		return contract.getSellCarAmount();
	}

	// 卖车日期
	public Date getSellCarDate(CustomerContract contract) {
		return contract.getSellCarDate();
	}

	// 备注
	public String getRemark(CustomerContract contract) {
		return contract.getRemark();
	}

	// 催收统计表
//	public List<ContractOverdueAmountDto> getContractOverdueAmountDtoByStoreAndDate(Store store, Date begin, Date end)
//			throws DAOException, ParseException {
//		List<CustomerContract> customerContracts;
//		if (store != null) {
//			customerContracts = customerContractDAO.findCustomerContractByStoreAndDateAndSellerDefaultDate(store, begin,
//					end);
//		} else {
//			customerContracts = customerContractDAO.findCustomerContractByDateAndSellerDefaultDate(begin, end);
//		}
//		List<ContractOverdueAmountDto> contractOverdueAmountDtos = new ArrayList<ContractOverdueAmountDto>();
//
//		for (CustomerContract contract : customerContracts) {
//			ContractOverdueAmountDto contractOverdueAmountDto = new ContractOverdueAmountDto();
//			contractOverdueAmountDto.setContract(contract);// 合同
//			contractOverdueAmountDto.setLoadType(getLoadType(contract));// 放款类型
//			contractOverdueAmountDto.setDueDate(getDueDate(contract));// 到期日期
//			contractOverdueAmountDto.setShouldPrincipal(getShouldPrincipal(contract));// 催收前应收回本金
//			contractOverdueAmountDto.setShouldInterest(getShouldInterest(contract));// 催收前应收回利息
//			contractOverdueAmountDto.setBeforeLateFee(getBeforeLateFee(contract));// 催收前逾期费
//			contractOverdueAmountDto.setAfterLateFee(getAfterLateFee(contract));// 转催收之后逾期费
//			contractOverdueAmountDto.setHasPrincipal(getHasPrincipal(contract));// 转催收已收回本金
//			contractOverdueAmountDto.setHasInterest(getHasInterest(contract));// 转催收已收回利息
//			contractOverdueAmountDto.setHasLateFee(getHasLateFee(contract));// 转催收已收回逾期费
//			contractOverdueAmountDto.setSurplusPrincipal(getSurplusPrincipal(contract));// 剩余未收回本金
//			contractOverdueAmountDto.setHasFlagPrincipal(getHasFlagPrincipal(contract));// 已平账本金
//			contractOverdueAmountDto.setHasFlagInterest(getHasFlagInterest(contract));// 已平账利息
//			contractOverdueAmountDto.setHasFlagLateFee(getHasFlagLateFee(contract));// 已平账逾期费
//			contractOverdueAmountDto.setHasFlagHasPrincipal(getHasFlagHasPrincipal(contract));// 已平账收回本金
//			contractOverdueAmountDto.setHasFlagHasInterest(getHasFlagHasInterest(contract));// 已平账收回利息
//			contractOverdueAmountDto.setHasFlagHasLateFee(getHasFlagHasLateFee(contract));// 已平账收回逾期费
//			contractOverdueAmountDto.setSettlement(getSettlement(contract));// 是否结清
//			contractOverdueAmountDto.setShortName(getShortName(contract));// 门店
//			contractOverdueAmountDto.setBusinessSource(getBusinessSource(contract));// 业务来源
//			contractOverdueAmountDto.setName(getName(contract));// 客户姓名
//			contractOverdueAmountDto.setPhone(getPhone(contract));// 手机
//			contractOverdueAmountDto.setLoanDate(getLoanDate(contract));// 放款日期
//			contractOverdueAmountDto.setLoanFee(getLoanFee(contract));// 放款金额
//			contractOverdueAmountDto.setSellerDefaultDate(getSellerDefaultDate(contract));// 转催收时间
//			contractOverdueAmountDto.setTrailCarDate(getTrailCarDate(contract));// 拖车日期
//			contractOverdueAmountDto.setSettlementDate(getSettlementDate(contract));// 结清日期
//			contractOverdueAmountDto.setSellCarAmount(getSellCarAmount(contract));// 卖车金额
//			contractOverdueAmountDto.setSellCarDate(getSellCarDate(contract));// 卖车日期
//			contractOverdueAmountDto.setRemark(getRemark(contract));// 备注
//			contractOverdueAmountDtos.add(contractOverdueAmountDto);
//		}
//		return contractOverdueAmountDtos;
//	}

	public List<CustomerContract> getPagingContractByEmployee(int firstResult, int maxResults, String condition,
			Employee emp) throws DAOException {
		return customerContractDAO.getPagingContractByEmployee(firstResult, maxResults, condition, emp);
	}

	/**
	 * @category 查询合同客户数据通过负责人
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<CustomerContract> getPagingCustomerByPerson(int firstResult, int maxResults, String condition,
			Employee responsiblePerson) throws DAOException {
		return customerContractDAO.getPagingCustomerByPerson(firstResult, maxResults, condition, responsiblePerson);
	}

	/**
	 * @category 统计
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getCountContractByEmployee(String condition, Employee emp) throws DAOException {
		return customerContractDAO.getCountContractByEmployee(condition, emp);
	}

	/**
	 * 获取未结清合同数量
	 * 
	 * @param type
	 *            类型，0 全部，1 门店
	 * @param store
	 *            门店
	 * @return
	 * @throws DAOException
	 */
	public int getUnSquareContractQuantity(int type, Store store) throws DAOException {
		return customerContractDAO.getUnSquareContractQuantity(type, store);
	}

	/**
	 * 获取未结清合同数量,按门店分组
	 * 
	 * @return
	 * @throws DAOException
	 */
//	public List<StoreQuantityDTO> getUnSquareContractQuantityGroupByStore() throws DAOException {
//		return customerContractDAO.getUnSquareContractQuantityGroupByStore();
//	}

	@Override
	public void setDAO() {
		this.baseDAO = customerContractDAO;
	}

	/**
	 * 修改续期合同的相应数据，涉及多个表
	 * 
	 * @param customerContract
	 * @param preStage
	 *            原来分期值
	 * @param stage
	 *            选择续期值
	 * @param costTypeList
	 *            装有costType的id,跟相应的值
	 * @throws DAOException
	 * @throws UpdateException
	 * @throws ParseException
	 * @throws CreateException
	 * @throws ParseException
	 * @throws DataNotFoundException
	 */
	public boolean updateContractOfRemewalData(CusContractRenewal contractRenewal, CustomerContract customerContract,
			int preStage, int stage, List<Doublebox> costTypeList)
			throws DAOException, UpdateException, ParseException, CreateException, DataNotFoundException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		boolean flag = false;

		Product product = customerContract.getProduct();
		if (product != null) {
			product = productDAO.getById(product.getId());
		}

		/*
		 * 0.合同续期表插入数据
		 */
		cusContractRenewalDAO.add(contractRenewal);
		/*
		 * 1.对合同表进行数据更新： 修改时间，修改者,借款期限,合同结束日期
		 */
		customerContractDAO.update(customerContract);

		/*
		 * 2.对合同分期表进行数据更新跟插入(注意还款时间跟期数)： a.取原数据的最后一期的数据，将还款时间更新成相应的日期
		 * b.取原的倒数第二期相应的数据，插入相应的增加的期数数据 c.先改后插
		 */
		List<ContractStage> contractStageList = contractStageDAO.getContractStageByContract(customerContract);
		ContractStage lastInstallment = null;// 最后一期
		ContractStage penultimate = null;// 倒数第二期

		Date lastInstallmentRepaymentDate = null;
		for (ContractStage contractStage : contractStageList) {
			if (contractStage.getStage() == (preStage - 1)) {
				penultimate = contractStage;
				continue;
			}
			if (contractStage.getStage() == preStage) {
				lastInstallment = contractStage;
				continue;
			}
		}

		if (lastInstallment != null) {
			lastInstallmentRepaymentDate = lastInstallment.getRepaymentDate();

			lastInstallment.setStage(preStage + stage);
			lastInstallment.setRepaymentDate(customerContract.getEndDate());
			lastInstallment.setRealrepaymentDate(customerContract.getEndDate());
			lastInstallment.setUpdateDate(customerContract.getUpdateDate());
			lastInstallment.setUpdateUser(customerContract.getUpdateUser());
			contractStageDAO.update(lastInstallment);
		}
		if (penultimate != null) {
			DecimalFormat df = new DecimalFormat("#.00");
			double interest = contractParaDAO.findValueByContractAndPara(customerContract,
					productParameterDAO.getById(2));// 利息率
			double interestAmount = Double.valueOf(df.format(customerContract.getAmount() * interest / 100));// 每期利息

			// 手续费
			double poundage = 0.00;
			if (!costTypeList.isEmpty()) {
				for (Doublebox doublebox : costTypeList) {
					poundage += doublebox.getValue();
				}
			}
			// 额外费用=手续费+（gps费/停车费/合同管理费）
			double extraCharges = poundage;
			ContractManageType contractManageType = customerContract.getContractManageType();
			if (contractManageType.getId() == 1) {// 月租 合同管理费
				extraCharges += customerContract.getContractManageValue();
			}
			ContractGpsLateFee contractGpsLateFee = contractGpsLateFeeDAO
					.findContractGpsLateFeeByCustomerContract(customerContract);
			ParkingFee parkingFee = null;
			if (contractGpsLateFee != null) {

				parkingFee = contractGpsLateFee.getParkingFee();
				if (parkingFee == null) {// gps费
					GpsCostType type = contractGpsLateFee.getType();
					if (type != null) {
						if (type.getId() == 9) {// 月租
							extraCharges += contractGpsLateFee.getCostValue();// gps费
						}
					}

				} else {// 停车费
					if (parkingFee.getId() == 2) {// 月租
						extraCharges += contractGpsLateFee.getCostValue();
					}
				}
			}

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(lastInstallmentRepaymentDate);
			calendar.add(Calendar.MONTH, -1);

			Date lastTime = penultimate.getRepaymentDate();
			Date penultimateTime = calendar.getTime();

			for (int i = 1; i <= stage; i++) {
				ContractStage contractStage = new ContractStage();
				// Calendar calendar = Calendar.getInstance();
				// calendar.setTime(penultimate.getRepaymentDate());
				calendar.setTime(penultimateTime);
				calendar.add(Calendar.MONTH, i);
				if (i != 1) {
					calendar.add(Calendar.DAY_OF_MONTH, -1);
				}

				contractStage.setStage(penultimate.getStage() + i);
				contractStage.setContract(penultimate.getContract());
				contractStage.setCapital(0.00);
				contractStage.setInterest(interestAmount);
				// 额外费用
				int days = 0;
				if (parkingFee != null && parkingFee.getId() == 1) {// 停车费 日租
					days = daysBetween(lastTime, calendar.getTime());
					contractStage.setExtraCharges(extraCharges + days * contractGpsLateFee.getCostValue());
					lastTime = calendar.getTime();
				} else {
					contractStage.setExtraCharges(extraCharges);
				}
				contractStage.setRepaymentDate(sdf.parse(sdf.format(calendar.getTime())));
				contractStage.setRealrepaymentDate(sdf.parse(sdf.format(calendar.getTime())));
				contractStage.setState(0);
				contractStage.setCreateDate(customerContract.getUpdateDate());
				contractStage.setCreateUser(customerContract.getUpdateUser());
				contractStage.setUpdateDate(customerContract.getUpdateDate());
				contractStage.setUpdateUser(customerContract.getUpdateUser());

				contractStageDAO.add(contractStage);

				/*
				 * 3.续期第一期对合同分期费用表插入相应手续费数据：
				 */
				if (i == 1) {
					if (!costTypeList.isEmpty()) {

						for (Doublebox Doublebox : costTypeList) {

							ContractStageFee stageFee = new ContractStageFee();
							stageFee.setFee(Doublebox.getValue());
							CostType costType = new CostType();
							costType.setId(Integer.parseInt(Doublebox.getId()));
							stageFee.setCostType(costType);
							stageFee.setStage(contractStage);
							stageFee.setCreateDate(customerContract.getUpdateDate());
							stageFee.setCreateUser(customerContract.getUpdateUser());
							stageFee.setUpdateDate(customerContract.getUpdateDate());
							stageFee.setUpdateUser(customerContract.getUpdateUser());

							contractStageFeeDAO.add(stageFee);
						}
					}
				}

				// TODO 插数据
				ProductType productType = product.getProductType();
				if (productType.getId() >= 4 && productType.getId() <= 5) {// 不押车 月租 gps费用
					ContractStageFee stageFee = new ContractStageFee();
					stageFee.setFee(contractGpsLateFee.getCostValue());
					CostType costType = new CostType();
					costType.setId(9);
					stageFee.setCostType(costType);
					stageFee.setStage(contractStage);
					stageFee.setCreateDate(customerContract.getUpdateDate());
					stageFee.setCreateUser(customerContract.getUpdateUser());
					stageFee.setUpdateDate(customerContract.getUpdateDate());
					stageFee.setUpdateUser(customerContract.getUpdateUser());

					contractStageFeeDAO.add(stageFee);
				}
				if (productType.getId() >= 6 && productType.getId() <= 8) {// 押车 月租 停车费
					ContractStageFee stageFee = new ContractStageFee();
					if (parkingFee != null && parkingFee.getId() == 1) {// 停车费 日租
						stageFee.setFee(contractGpsLateFee.getCostValue() * days);
					} else {
						stageFee.setFee(contractGpsLateFee.getCostValue());
					}
					stageFee.setFee(contractGpsLateFee.getCostValue());
					CostType costType = new CostType();
					costType.setId(3);
					stageFee.setCostType(costType);
					stageFee.setStage(contractStage);
					stageFee.setCreateDate(customerContract.getUpdateDate());
					stageFee.setCreateUser(customerContract.getUpdateUser());
					stageFee.setUpdateDate(customerContract.getUpdateDate());
					stageFee.setUpdateUser(customerContract.getUpdateUser());

					contractStageFeeDAO.add(stageFee);
				}
				// 合同管理费
				if (customerContract.getContractManageValue() != null
						&& customerContract.getContractManageValue() > 0) {
					ContractStageFee stageFee = new ContractStageFee();
					stageFee.setFee(customerContract.getContractManageValue());
					CostType costType = new CostType();
					costType.setId(15);
					stageFee.setCostType(costType);
					stageFee.setStage(contractStage);
					stageFee.setCreateDate(customerContract.getUpdateDate());
					stageFee.setCreateUser(customerContract.getUpdateUser());
					stageFee.setUpdateDate(customerContract.getUpdateDate());
					stageFee.setUpdateUser(customerContract.getUpdateUser());

					contractStageFeeDAO.add(stageFee);
				}

			}
			flag = true;
		}

		return flag;
	}
}
