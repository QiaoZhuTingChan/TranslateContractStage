package com.jyd.bms.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.ContractRepayment;
import com.jyd.bms.bean.ContractStage;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.Store;
import com.jyd.bms.dao.ContractRepaymentDAO;
import com.jyd.bms.dao.ContractStageDAO;
import com.jyd.bms.dao.ContractStageFeeDAO;
import com.jyd.bms.dao.CusContractRepaymentOtherFeeDAO;
import com.jyd.bms.dao.DepartmentDAO;
import com.jyd.bms.dao.EmployeeDAO;
import com.jyd.bms.dao.StoreDAO;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.tool.exception.DataNotFoundException;

@Service("ContractStageService")
public class ContractStageService extends BaseService<ContractStage> {
	@Autowired(required = true)
	private DepartmentDAO departmentDAO;

	@Autowired(required = true)
	private StoreDAO storeDAO;

	@Autowired(required = true)
	private EmployeeDAO employeeDAO;

	@Autowired(required = true)
	private ContractStageDAO contractStageDAO;

	@Autowired(required = true)
	private ContractStageFeeDAO contractStageFeeDAO;

	@Autowired(required = true)
	private ContractRepaymentDAO contractRepaymentDAO;

	@Autowired(required = true)
	private CusContractRepaymentOtherFeeDAO cusContractRepaymentOtherFeeDAO;

	public int getContractStageCount(Integer para, String customer, Date startDate, Date endDate) throws DAOException {
		return contractStageDAO.getContractStageCount(para, customer, startDate, endDate);
	}

	public int getContractStageCountByStore(Integer para, String customer, Date startDate, Date endDate, Store store)
			throws DAOException, DataNotFoundException {
		return contractStageDAO.getContractStageCountByStore(para, customer, startDate, endDate, store);
	}

	public List<ContractStage> getPagingContractStage(int firstResult, int maxResults, String condition)
			throws DAOException {
		return contractStageDAO.getPagingContractStage(firstResult, maxResults, condition);
	}

	/**
	 * @category 门店分期分页
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 * @throws DataNotFoundException
	 */
	public List<ContractStage> getPagingContractStageByStore(int firstResult, int maxResults, String condition,
			Store store) throws DAOException, DataNotFoundException {
		return contractStageDAO.getPagingContractStageByStore(firstResult, maxResults, condition, store);
	}

	public List<ContractStage> getAllContractStage() throws DAOException {
		return contractStageDAO.getAllContractStage();
	}

	/**
	 * 查找合同分期
	 * 
	 * @param contract
	 * @return
	 * @throws DAOException
	 */
	public List<ContractStage> findContractStageByContract(CustomerContract contract) throws DAOException {
		return contractStageDAO.findContractStageByContract(contract);
	}

	/**
	 * 查找合同分期时间
	 * 
	 * @param repaymentDate
	 * @return
	 * @throws DAOException
	 */
	public List<ContractStage> findContractStageByDate(Date repaymentDate) throws DAOException {
		return contractStageDAO.findContractStageByDate(repaymentDate);
	}

	/**
	 * 通过分期查找合同的费用
	 * 
	 * @param repaymentDate
	 * @param store
	 * @return
	 * @throws DAOException
	 */
	public List<ContractStage> findContractStageByDateAndStore(Date repaymentDate, Store store) throws DAOException {
		return contractStageDAO.findContractStageByDateAndStore(repaymentDate, store);
	}

	/**
	 * 查找逾期费用
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ContractStage> findLateTimeContractStage() throws DAOException {
		return contractStageDAO.findLateTimeContractStage();
	}

	public ContractStage findContractStageByContractAndStage(CustomerContract contract, int stage) throws DAOException {
		return contractStageDAO.findContractStageByContractAndStage(contract, stage);
	}

	public ContractStage findContractStageByContractAndCurrentMonth(CustomerContract contract) throws DAOException {
		return contractStageDAO.findContractStageByContractAndCurrentMonth(contract);
	}

	public ContractStage findContractStageByContractAndLastMonth(CustomerContract contract) throws DAOException {
		return contractStageDAO.findContractStageByContractAndCurrentMonth(contract);
	}

	public ContractStage findContractStageByContractAndState(CustomerContract contract) throws DAOException {
		return contractStageDAO.findContractStageByContractAndState(contract);
	}

	/**
	 * @category 根据条件拿到分期数据
	 * @param firstResult
	 *            分页开始
	 * @param maxResults
	 *            分页结束
	 * @param condition
	 *            条件
	 * @param startDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @return 分期分页数据
	 * @throws DAOException
	 *             异常抛出
	 * @throws ParseException
	 */
	public List<ContractStage> getContractStageByPara(int firstResult, int maxResults, Integer para, String customer,
			String startDate, String endDate) throws DAOException, ParseException {
		return contractStageDAO.getContractStageByPara(firstResult, maxResults, para, customer, startDate, endDate);
	}

	/**
	 * @category 分期搜索分页通过门店
	 * @param firstResult
	 * @param maxResults
	 * @param para
	 * @param customer
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws DAOException
	 * @throws ParseException
	 * @throws DataNotFoundException
	 */
	public List<ContractStage> getContractStageByParaAndStore(int firstResult, int maxResults, Integer para,
			String customer, String startDate, String endDate, Store store)
			throws DAOException, ParseException, DataNotFoundException {
		return contractStageDAO.getContractStageByParaAndStore(firstResult, maxResults, para, customer, startDate,
				endDate, store);
	}

	public List<ContractStage> getContractStageByContract(CustomerContract contract) throws DAOException {
		return contractStageDAO.getContractStageByContract(contract);
	}

	public void deleteAll(CustomerContract contract) throws DAOException {
		List<ContractStage> stageList = new ArrayList<ContractStage>();
		stageList = contractStageDAO.getContractStageByContract(contract);
		for (ContractStage stage : stageList) {
			List<ContractRepayment> repList = contractRepaymentDAO.findContractRepaymentByStage(stage);
			for (ContractRepayment rep : repList) {
				cusContractRepaymentOtherFeeDAO.delAll(rep);
			}
			contractRepaymentDAO.delAll(stage);
			contractStageFeeDAO.deleteAll(stage);
		}
		contractStageDAO.deleteAll(contract);
	}

	public ContractStage getNextByContractStage(ContractStage stage, CustomerContract contract) throws DAOException {
		return contractStageDAO.getNextByContractStage(stage, contract);
	}

	public List<ContractStage> getPagingContractStageByStore(int firstResult, int maxResults, Store store)
			throws DAOException {
		return contractStageDAO.getPagingContractStageByStore(firstResult, maxResults, store);
	}

	@Override
	public void setDAO() {
		this.baseDAO = contractStageDAO;
	}

}
