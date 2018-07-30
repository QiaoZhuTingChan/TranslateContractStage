package com.jyd.bms.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.ContractLateFee;
import com.jyd.bms.bean.ContractStage;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.Store;
import com.jyd.bms.dao.ContractLateFeeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class ContractLateFeeDAOImpl extends HibernateBaseTemplate<ContractLateFee> implements ContractLateFeeDAO {
	@Override
	public int getContractLateFeeCountByStore(String condition, Store store) throws DAOException {
		String hql = "";
		Map map = new HashMap();

		if (condition.equals("")) {
			map.put("store", store);
			hql = "select count(*) from ContractLateFee where state = 0 and contract.store =:store and contract.state!=-1 and contract.state!=1 order by overDueTime desc";
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from ContractLateFee where contract.name like :condition and state = 0 and contract.state!=-1 and contract.state!=1 and contract.store =:store order by overDueTime desc";
			map.put("store", store);
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public int getContractLateFeeCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from ContractLateFee where state = 0 and contract.state!=-1 and contract.state!=1 order by overDueTime desc";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from ContractLateFee where contract.name like :condition and contract.state!=-1 and contract.state!=1 and state = 0 order by overDueTime desc";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<ContractLateFee> getPagingContractLateFee(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from ContractLateFee where state = 0 and contract.state!=-1 and contract.state!=1 order by overDueTime desc";
		} else {
			hql = "from ContractLateFee where contract.name like :condition and state = 0 and contract.state!=-1 and contract.state!=1 order by overDueTime desc";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<ContractLateFee> getAllContractLateFee() throws DAOException {
		String hql = "";
		hql = "from ContractLateFee";
		return super.getQueryResult(hql.toString());

	}

	public List<ContractLateFee> findContractLateFeeByToday() throws DAOException {
		Date date = Calendar.getInstance().getTime();
		String hql = "";
		hql = "from ContractLateFee where overDueTime = :date";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("date", date);
		return super.getQueryResult(hql, map);
	}

	public List<ContractLateFee> findContractLateFeeByTodayAndStore(Store store) throws DAOException {
		Date date = Calendar.getInstance().getTime();
		String hql = "";
		hql = "from ContractLateFee where overDueTime = :date and contract.store = :store";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("date", date);
		map.put("store", store);
		return super.getQueryResult(hql, map);
	}

	public int getSameContractLateFeeCountByDay(CustomerContract contract) throws DAOException {
		Date date = Calendar.getInstance().getTime();
		String hql = "";
		hql = "select count(*) from ContractLateFee where contract = :contract and createDate= :date";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		map.put("date", date);
		List<Long> lstCount = super.getQueryResult(hql, map);
		return lstCount.get(0).intValue();
	}

	// 某时间前逾期记录
	public ContractLateFee findContractLateFeeByContractAndLast(CustomerContract contract, Date date)
			throws DAOException {
		String hql = "";
		hql = "from ContractLateFee where contract = :contract and overDueTime < :date group by contract having overDueTime = max(overDueTime)";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		map.put("date", date);
		return (ContractLateFee) super.getUniqueResult(hql, map);
	}

	// 某时间逾期记录
	public ContractLateFee findContractLateFeeByContractDate(CustomerContract contract, Date date) throws DAOException {
		String hql = "";
		hql = "from ContractLateFee where contract = :contract and overDueTime = :date";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		map.put("date", date);
		return (ContractLateFee) super.getUniqueResult(hql, map);
	}

	// 转催收逾期
	public ContractLateFee findContractLateFeeByContractAndDate(CustomerContract contract) throws DAOException {
		String hql = "";
		hql = "from ContractLateFee where contract = :contract and overDueTime = :date";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		map.put("date", contract.getSellerDefaultDate());
		return (ContractLateFee) super.getUniqueResult(hql, map);
	}

	// 获取分期的逾期记录
	public List<ContractLateFee> findContractLateFeeByContractStagesAndLast(List<ContractStage> contractStages)
			throws DAOException {
		String hql = "";
		hql = "from ContractLateFee where contractStage in (:contractStages) group by contractStage having overDueTime = max(overDueTime)";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contractStages", contractStages);
		return super.getQueryResult(hql, map);
	}

	/**
	 * 带多个参数查询 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @param state
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws DAOException
	 * @throws ParseException
	 */
	public List<ContractLateFee> getPagingContractLateFeeParam(int firstResult, int maxResults,
			Map<String, Object> mapPara) throws DAOException, ParseException {
		StringBuilder hql = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, Object> map = new HashMap<>();
		Store store = (Store) mapPara.get("store");

		if (store == null) {
			hql.append("from ContractLateFee where state = 0 and contract.state!=-1 and contract.state!=1");
		} else {
			map.put("store", store);
			hql.append(
					"from ContractLateFee where state = 0 and contract.store =:store and contract.state!=-1 and contract.state!=1");
		}
		String condition = mapPara.get("condition").toString();
		int type = (int) mapPara.get("type");
		String beginDate = mapPara.get("beginDate").toString();
		String endDate = mapPara.get("endDate").toString();
		// 搜索条件
		if (!condition.equals("")) {
			// 合同编号
			if (type == 0) {
				hql.append(" and contract.contractNum like :contractNum");
				map.put("contractNum", "%" + condition + "%");
			}
			// 姓名
			if (type == 1) {
				hql.append(" and contract.name like :name");
				map.put("name", "%" + condition + "%");
			}
			// 身份证
			if (type == 2) {
				hql.append(" and contract.IDNo like:IDNo");
				map.put("IDNo", "%" + condition + "%");
			}
			// 车牌号
			if (type == 3) {
				hql.append(" and contract.plate like :plate");
				map.put("plate", "%" + condition + "%");
			}
		}
		// 开始时间
		if (!beginDate.equals("")) {
			map.put("startDate", sdf.parse(beginDate));
			hql.append(" and overDueTime>=:startDate");
		}
		// 结束时间
		if (!endDate.equals("")) {
			map.put("endDate", sdf.parse(endDate));
			hql.append(" and overDueTime<=:endDate");
		}
		// 排序
		hql.append(" order by overDueTime desc");
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	@Override
	public List<ContractLateFee> getContractLateFeeByContract(CustomerContract contract) throws DAOException {
		String hql = "";
		hql = "from ContractLateFee where contract = :contract and state=0 order by id desc";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		return super.getQueryResult(hql, map);
	}

	@Override
	public List<ContractLateFee> findContractLateFeeByContractStage(ContractStage stage) throws DAOException {
		String hql = "";
		hql = "from ContractLateFee where contractStage = :stage";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("stage", stage);
		return super.getQueryResult(hql, map);
	}

	@Override
	public int getContractLateFeeParamCount(Map<String, Object> mapPara) throws DAOException, ParseException {
		StringBuilder hql = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, Object> map = new HashMap<>();
		Store store = (Store) mapPara.get("store");

		if (store == null) {
			hql.append(
					"select count(1) from ContractLateFee where state = 0 and contract.state!=-1 and contract.state!=1");
		} else {
			map.put("store", store);
			hql.append(
					"select count(1) from ContractLateFee where state = 0 and contract.state!=-1 and contract.state!=1 and contract.store =:store");
		}

		String condition = mapPara.get("condition").toString();
		int type = (int) mapPara.get("type");
		String beginDate = mapPara.get("beginDate").toString();
		String endDate = mapPara.get("endDate").toString();

		if (!condition.equals("")) {
			// 合同编号
			if (type == 0) {
				hql.append(" and contract.contractNum like :contractNum");
				map.put("contractNum", "%" + condition + "%");
			}
			// 姓名
			if (type == 1) {
				hql.append("　and contract.name like :name");
				map.put("name", "%" + condition + "%");
			}
			// 身份证
			if (type == 2) {
				hql.append(" and contract.IDNo like:IDNo");
				map.put("IDNo", "%" + condition + "%");
			}
			// 车牌号
			if (type == 3) {
				hql.append(" and contract.plate like :plate");
				map.put("plate", "%" + condition + "%");
			}
		}
		// 开始时间
		if (!beginDate.equals("")) {
			map.put("startDate", sdf.parse(beginDate));
			hql.append(" and overDueTime>=:startDate");
		}
		// 结束时间
		if (!endDate.equals("")) {
			map.put("endDate", sdf.parse(endDate));
			hql.append(" and overDueTime<=:endDate");
		}
		List<Long> lstCount = super.getQueryResult(hql.toString(), map);
		return lstCount.get(0).intValue();
	}

	@Override
	public List<ContractLateFee> getPagingContractLateFeeByStore(int firstResult, int maxResults, String condition,
			Store store) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("store", store);
		if (condition.equals("")) {
			hql = "from ContractLateFee where state = 0 and contract.store =:store and contract.state!=-1 and contract.state!=1 order by overDueTime desc";
		} else {
			hql = "from ContractLateFee where contract.name like :condition and state = 0 and contract.state!=-1 and contract.state!=1 and contract.store =:store order by overDueTime desc";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	@Override
	public List<ContractLateFee> getContractLateFeeByContractRepayDate(CustomerContract contract) throws DAOException {
		String hql = "";
		hql = "from ContractLateFee where contract = :contract and state=0 order by id desc";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		return super.getQueryResult(hql, map);
	}

}
