package com.jyd.bms.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.ContractStage;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.Store;
import com.jyd.bms.dao.ContractStageDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class ContractStageDAOImpl extends HibernateBaseTemplate<ContractStage> implements ContractStageDAO {

	public int getContractStageCount(Integer para, String customer, Date startDate, Date endDate) throws DAOException {
		StringBuilder hql = new StringBuilder();
		Map parameterMap = new HashMap();
		hql.append("select count(*) from ContractStage where 1=1");
		if (para != -1) {
			parameterMap.put("para", para);
			hql.append(" and state = :para");
		}

		if (!customer.equals("")) {
			parameterMap.put("customer", "%" + customer + "%");
			hql.append(" and contract.contractNum like :customer or contract.name like :customer");
		}
		if (startDate != null) {
			parameterMap.put("startDate", startDate);
			hql.append(" and repaymentDate>=:startDate");
		}
		if (endDate != null) {
			parameterMap.put("endDate", endDate);
			hql.append(" and repaymentDate<=:endDate");
		}

		List<Long> lstCount = super.getQueryResult(hql.toString(), parameterMap);
		return lstCount.get(0).intValue();
	}

	public List<ContractStage> getPagingContractStage(int firstResult, int maxResults, String condition)
			throws DAOException {
		try {
			String hql = "";
			@SuppressWarnings("rawtypes")
			Map parameterMap = new HashMap();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			date = sdf.parse(sdf.format(new Date()));
			if (firstResult == 0) {
				date = sdf.parse(sdf.format(new Date()));
				parameterMap.put("date", date);
			} else {
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(date);
				calendar.add(calendar.DATE, firstResult);
				// 把日期往后增加一天.整数往后推,负数往前移动
				date = calendar.getTime();
				// 这个时间就是日期往后推一天的结果
				parameterMap.put("date", date);
			}
			hql = "from ContractStage where repaymentDate =:date";
			return super.getQueryResult(hql, parameterMap);
		} catch (ParseException e) {
			return null;
		}
	}

	public List<ContractStage> getAllContractStage() throws DAOException {
		String hql = "";
		hql = "from ContractStage";
		return super.getQueryResult(hql.toString());

	}

	public List<ContractStage> findContractStageByContract(CustomerContract contract) throws DAOException {
		String hql = "";
		hql = "from ContractStage where contract = :contract order by stage";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		return super.getQueryResult(hql, map);
	}

	public List<ContractStage> findContractStageByContractAndStages(CustomerContract contract, int stage)
			throws DAOException {
		String hql = "";
		hql = "from ContractStage where contract = :contract and stage <= :stage";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		map.put("stage", stage);
		return super.getQueryResult(hql, map);
	}

	public List<ContractStage> findContractStageByDate(Date repaymentDate) throws DAOException {

		String hql = "";
		hql = "from ContractStage where state=0 and repaymentDate = :repaymentDate";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("repaymentDate", repaymentDate);
		return super.getQueryResult(hql, map);
	}

	public List<ContractStage> findContractStageByDateAndStore(Date repaymentDate, Store store) throws DAOException {

		String hql = "";
		hql = "from ContractStage where state=0 and repaymentDate = :repaymentDate and contract.store = :store";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("repaymentDate", repaymentDate);
		map.put("store", store);
		return super.getQueryResult(hql, map);
	}

	public List<ContractStage> findLateTimeContractStage() throws DAOException {
		Date date = Calendar.getInstance().getTime();
		String hql = "";
		hql = "from ContractStage where state=0 and contract.state!=-1 and repaymentDate< :date group by contract having repaymentDate = min(repaymentDate)";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("date", date);
		return super.getQueryResult(hql, map);
	}

	// 最近已还分期
	public ContractStage findContractStageByContractAndState(CustomerContract contract) throws DAOException {
		String hql = "";
		hql = "from ContractStage where contract = :contract and state = 1 group by contract having repaymentDate = max(repaymentDate)";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		// map.put("stage", stage);
		return (ContractStage) super.getUniqueResult(hql, map);
	}

	// 催收前最近分期
	public ContractStage findContractStageByContractAndLast(CustomerContract contract) throws DAOException {
		// if(contract.getSellerDefaultDate()==null) {
		// return null;
		// }
		// if(contract.getSellerDefaultDate()==null){
		// throw new DAOException("没有催收的合同记录");
		// }
		String hql = "";
		hql = "from ContractStage where contract = :contract and repaymentDate < :date group by contract having repaymentDate = max(repaymentDate)";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		if (contract.getSellerDefaultDate() != null) {
			map.put("date", contract.getSellerDefaultDate());
		} else {
			return null;
		}

		// Object obj = super.getUniqueResult(hql, map);
		// return obj == null ? null : (ContractStage) obj;
		return (ContractStage) super.getUniqueResult(hql, map);
	}

	public ContractStage findContractStageByContractAndStage(CustomerContract contract, int stage) throws DAOException {
		String hql = "";
		hql = "from ContractStage where contract = :contract and stage = :stage";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		map.put("stage", stage);
		return (ContractStage) super.getUniqueResult(hql, map);
	}

	// 某合同当月分期
	public ContractStage findContractStageByContractAndCurrentMonth(CustomerContract contract) throws DAOException {
		Calendar cal = Calendar.getInstance();
		// cal.set(Calendar.YEAR,cal.get(Calendar.YEAR));
		// cal.set(Calendar.MONTH, cal.get(Calendar.MONTH));
		int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, firstDay);
		Date begin = cal.getTime();
		Calendar cal1 = Calendar.getInstance();
		// cal1.set(Calendar.YEAR,cal1.get(Calendar.YEAR));
		// cal1.set(Calendar.MONTH, cal1.get(Calendar.MONTH));
		int lastDay = cal1.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal1.set(Calendar.DAY_OF_MONTH, lastDay);
		Date end = cal1.getTime();
		String hql = "";
		hql = "from ContractStage where contract = :contract and repaymentDate between :begin and :end";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		map.put("begin", begin);
		map.put("end", end);
		return (ContractStage) super.getUniqueResult(hql, map);
	}

	// 某合同上月分期
	public ContractStage findContractStageByContractAndLastMonth(CustomerContract contract) throws DAOException {
		Calendar cal = Calendar.getInstance();
		// cal.set(Calendar.YEAR,cal.get(Calendar.YEAR));
		// cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)-1);
		int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, firstDay);
		Date begin = cal.getTime();
		Calendar cal1 = Calendar.getInstance();
		// cal1.set(Calendar.YEAR,cal1.get(Calendar.YEAR));
		// cal1.set(Calendar.MONTH, cal1.get(Calendar.MONTH)-1);
		int lastDay = cal1.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal1.set(Calendar.DAY_OF_MONTH, lastDay);
		Date end = cal1.getTime();
		String hql = "";
		hql = "from ContractStage where contract = :contract and repaymentDate between :begin and :end";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		map.put("begin", begin);
		map.put("end", end);
		return (ContractStage) super.getUniqueResult(hql, map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ContractStage> getContractStageByPara(int firstResult, int maxResults, Integer para, String customer,
			String startDate, String endDate) throws DAOException, ParseException {
		StringBuilder hql = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		@SuppressWarnings("rawtypes")
		Map parameterMap = new HashMap();
		hql.append("from ContractStage where 1=1");

		if (para != -1) {
			parameterMap.put("para", para);
			hql.append(" and state = :para");
		}

		if (!customer.equals("")) {
			parameterMap.put("customer", "%" + customer + "%");
			hql.append(" and contract.contractNum like :customer or contract.name like :customer");
		}
		if (!startDate.equals("")) {
			parameterMap.put("startDate", sdf.parse(startDate));
			hql.append(" and repaymentDate>=:startDate");
		}
		if (!endDate.equals("")) {
			parameterMap.put("endDate", sdf.parse(endDate));
			hql.append(" and repaymentDate<=:endDate");
		}
		return super.getPagingQueryResult(hql.toString(), parameterMap, firstResult, maxResults);
	}

	@Override
	public List<ContractStage> getContractStageByContract(CustomerContract contract) throws DAOException {
		String hql = "";
		hql = "from ContractStage where contract = :contract";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		return super.getQueryResult(hql, map);
	}

	@Override
	public void deleteAll(CustomerContract contract) throws DAOException {
		String hql = "delete from ContractStage where contract =:contract";
		Map<String, Object> map = new HashMap<>();
		map.put("contract", contract);
		super.executeUpdate(hql, map);
	}

	@Override
	public ContractStage getNextByContractStage(ContractStage stage, CustomerContract contract) throws DAOException {
		String hql = "from ContractStage where contract =:contract and stage =:stage";
		Map<String, Object> map = new HashMap<>();
		map.put("contract", contract);
		map.put("stage", stage.getStage() + 1);
		return (ContractStage) super.getUniqueResult(hql, map);
	}

	@Override
	public int getSurplusInterestStage(CustomerContract contract) throws DAOException {
		String hql = "";
		hql = "select count(1) from ContractStage where contract = :contract and interest > 0 and state = 0";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		List<Long> lstCount = super.getQueryResult(hql, map);
		return lstCount.get(0).intValue();
	}

	@Override
	public int getSurplusPrincipalStage(CustomerContract contract) throws DAOException {
		String hql = "";
		hql = "select count(1) from ContractStage where contract = :contract and capital > 0 and state = 0";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		List<Long> lstCount = super.getQueryResult(hql, map);
		return lstCount.get(0).intValue();
	}

	@Override
	public double getPrincipalDeposit(CustomerContract contract) throws DAOException {
		String hql = "";
		hql = "select sum(capital) from ContractStage where contract = :contract and state = 0";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		List<Double> lstCount = super.getQueryResult(hql, map);
		double temp = 0;
		if (lstCount.get(0) != null) {
			temp = lstCount.get(0).intValue();
		}
		return temp;
	}

	@Override
	public int getRepaidMax(CustomerContract contract) throws DAOException {
		String hql = "";
		hql = "select max(stage) from ContractStage where contract = :contract and state = 1";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		List<Integer> lstCount = super.getQueryResult(hql, map);
		return lstCount.get(0) == null ? -1 : lstCount.get(0).intValue();
	}

	@Override
	public List<ContractStage> getPagingContractStageByStore(int firstResult, int maxResults, Store store)
			throws DAOException {
		try {
			String hql = "";
			@SuppressWarnings("rawtypes")
			Map parameterMap = new HashMap();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			date = sdf.parse(sdf.format(new Date()));
			if (firstResult == 0) {
				date = sdf.parse(sdf.format(new Date()));
			} else {
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(date);
				calendar.add(calendar.DATE, firstResult);
				// 把日期往后增加一天.整数往后推,负数往前移动
				date = calendar.getTime();
				// 这个时间就是日期往后推一天的结果
			}
			parameterMap.put("store", store);
			parameterMap.put("date", date);
			hql = "from ContractStage where repaymentDate =:date and contract.store =:store";
			return super.getQueryResult(hql, parameterMap);
		} catch (ParseException e) {
			return null;
		}
	}

	@Override
	public int getContractStageCountByStore(Map map) throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getContractStageCountByStore(Integer para, String customer, Date startDate, Date endDate, Store store)
			throws DAOException {
		StringBuilder hql = new StringBuilder();
		Map parameterMap = new HashMap();
		parameterMap.put("store", store);
		hql.append("select count(*) from ContractStage where contract.store =:store");
		if (para != -1) {
			parameterMap.put("para", para);
			hql.append(" and state = :para");
		}

		if (!customer.equals("")) {
			parameterMap.put("customer", "%" + customer + "%");
			hql.append(" and contract.name like :customer");
		}
		if (startDate != null) {
			parameterMap.put("startDate", startDate);
			hql.append(" and repaymentDate>=:startDate");
		}
		if (endDate != null) {
			parameterMap.put("endDate", endDate);
			hql.append(" and repaymentDate<=:endDate");
		}

		List<Long> lstCount = super.getQueryResult(hql.toString(), parameterMap);
		return lstCount.get(0).intValue();
	}

	@Override
	public List<ContractStage> getPagingContractStageByStore(int firstResult, int maxResults, String condition,
			Store store) throws DAOException {
		try {
			String hql = "";
			@SuppressWarnings("rawtypes")
			Map parameterMap = new HashMap();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			date = sdf.parse(sdf.format(new Date()));
			parameterMap.put("store", store);

			if (firstResult == 0) {
				date = sdf.parse(sdf.format(new Date()));
				parameterMap.put("date", date);
			} else {
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(date);
				calendar.add(calendar.DATE, firstResult);
				// 把日期往后增加一天.整数往后推,负数往前移动
				date = calendar.getTime();
				// 这个时间就是日期往后推一天的结果
				parameterMap.put("date", date);
			}
			hql = "from ContractStage where repaymentDate =:date and contract.store =:store";
			return super.getQueryResult(hql, parameterMap);
		} catch (ParseException e) {
			return null;
		}
	}

	@Override
	public List<ContractStage> getContractStageByParaAndStore(int firstResult, int maxResults, Integer para,
			String customer, String startDate, String endDate, Store store) throws DAOException, ParseException {
		StringBuilder hql = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		@SuppressWarnings("rawtypes")
		Map parameterMap = new HashMap();
		parameterMap.put("store", store);
		hql.append("from ContractStage where contract.store =:store");

		if (para != -1) {
			parameterMap.put("para", para);
			hql.append(" and state = :para");
		}

		if (!customer.equals("")) {
			parameterMap.put("customer", "%" + customer + "%");
			hql.append(" and contract.name like :customer");
		}
		if (!startDate.equals("")) {
			parameterMap.put("startDate", sdf.parse(startDate));
			hql.append(" and repaymentDate>=:startDate");
		}
		if (!endDate.equals("")) {
			parameterMap.put("endDate", sdf.parse(endDate));
			hql.append(" and repaymentDate<=:endDate");
		}
		return super.getPagingQueryResult(hql.toString(), parameterMap, firstResult, maxResults);
	}

	@Override
	public int getContractStageByCus(CustomerContract contract) throws DAOException {
		String hql="";
		hql="select count(*) from ContractStage where stage!=0 and contract=:contract and capital=0";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		List<Long> lstCount = super.getQueryResult(hql, map);
		return lstCount.get(0).intValue();
	}

	@Override
	public int excuteBatchInsertContractStage(Set<ContractStage> contractStageList) {
		// TODO Auto-generated method stub
		return 0;
	}

}
