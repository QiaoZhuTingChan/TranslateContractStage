package com.jyd.bms.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.Store;
import com.jyd.bms.dao.CustomerContractDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class CustomerContractDAOImpl extends HibernateBaseTemplate<CustomerContract> implements CustomerContractDAO {

	public int getCustomerContractCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from CustomerContract";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from CustomerContract where name like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}
	public int getCustomerContractByParaCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from CustomerContract";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from CustomerContract where name like :condition or store.shortName like :condition or contractNum like :condition order by createDate";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<CustomerContract> getPagingCustomerContract(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from CustomerContract order by id desc";
		} else {
			hql = "from CustomerContract where name like :condition or store.shortName like :condition or contractNum like :condition order by createDate";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<CustomerContract> getAllCustomerContract() throws DAOException {
		String hql = "";
		hql = "from CustomerContract";
		return super.getQueryResult(hql.toString());

	}

	@Override
	public CustomerContract getContractByNum(String contractNum) throws DAOException {
		Map map = new HashMap();
		map.put("contractNum", contractNum);
		String hql = "";
		hql = "from CustomerContract where contractNum=:contractNum";
		List<CustomerContract> list = super.getQueryResult(hql, map);
		if (!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public int getStoreCustomerContractCount(String condition, Store store) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from CustomerContract where store =:store";
			Map map = new HashMap();
			map.put("store", store);
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from CustomerContract where name like :condition and store =:store";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			map.put("store", store);
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	@Override
	public List<CustomerContract> getPagingStoreCustomerContract(int firstResult, int maxResults, String condition,
			Store store) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from CustomerContract where store=:store";
		} else {
			hql = "from CustomerContract where name like :condition and store=:store";
			map.put("condition", "%" + condition + "%");
		}
		map.put("store", store);
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<CustomerContract> findCustomerContractByEmp(Employee emp) throws DAOException {
		String hql = "";
		hql = "from CustomerContract where responsiblePerson = :emp";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("emp", emp);
		return super.getQueryResult(hql, map);
	}

	public List<CustomerContract> findPagingCustomerContractByEmp(List<Employee> emps, String condition,
			int firstResult, int maxResults) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "select distinct CustomerContract from CustomerContract where responsiblePerson in (:emps) order by startDate desc";
			map.put("emps", emps);
		} else {
			hql = "select distinct CustomerContract from CustomerContract where responsiblePerson in (:emps) and contractNum = condition order by startDate desc";
			map.put("emps", emps);
			map.put("condition", condition);
		}
		return super.getPagingQueryResult(hql, map, firstResult, maxResults);
	}

	public List<CustomerContract> findPagingCustomerContractByEmp(Employee emp, String condition, int firstResult,
			int maxResults) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from CustomerContract where responsiblePerson = :emp order by startDate desc";
			map.put("emp", emp);
		} else {
			hql = "from CustomerContract where responsiblePerson = :emp and contractNum = :condition order by startDate desc";

			map.put("emp", emp);
			map.put("condition", condition);
		}

		return super.getPagingQueryResult(hql, map, firstResult, maxResults);
	}

	public int findCustomerContractCountByEmp(Employee emp, String condition) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "select count(*) from CustomerContract where responsiblePerson = :emp";
			map.put("emp", emp);
		} else {
			hql = "select count(*) from CustomerContract where responsiblePerson = :emp and contractNum = :condition";

			map.put("emp", emp);
			map.put("condition", condition);
		}

		List<Long> lstCount = super.getQueryResult(hql, map);
		return lstCount.get(0).intValue();
	}

	public int findCustomerContractCountByEmp(List<Employee> emps, String condition) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from CustomerContract where responsiblePerson in (:emps) group by id";
			map.put("emps", emps);
		} else {
			hql = "from CustomerContract where responsiblePerson in (:emps) and contractNum = :condition group by id";

			map.put("emps", emps);
			map.put("condition", condition);
		}

		List<Long> lstCount = super.getQueryResult(hql, map);
		if (lstCount.isEmpty()) {
			return 0;
		}
		return lstCount.size();
	}

	public List<CustomerContract> findCustomerContractByStoreAndDate(Store store, Date begin, Date end)
			throws DAOException {
		String hql = "";
		hql = "from CustomerContract where store = :store and startDate >=:begin and startDate<=:end and state!=-1 and state!=1";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("store", store);
		map.put("begin", begin);
		map.put("end", end);
		return super.getQueryResult(hql, map);
	}

	public List<CustomerContract> findCustomerContractByDate(Date begin, Date end) throws DAOException {
		String hql = "";
		hql = "from CustomerContract where startDate >=:begin and startDate<=:end and state!=-1 and state!=1";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		// map.put("store", store);
		map.put("begin", begin);
		map.put("end", end);
		return super.getQueryResult(hql, map);
	}

	@Override
	public String getCustomerContractNum(String contractNum) throws DAOException {
		String hql = "";
		hql = "select max(contractNum) from CustomerContract where contractNum like :contractNum";
		Map map = new HashMap();
		map.put("contractNum", contractNum + "%");
		return (String) super.getUniqueResult(hql, map);
	}

	public List<CustomerContract> findCustomerContractByStoreAndDateAndSellerDefaultDate(Store store, Date begin,
			Date end) throws DAOException {
		String hql = "";
		hql = "from CustomerContract where store = :store and startDate between :begin and :end and sellerDefaultDate is not null";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("store", store);
		map.put("begin", begin);
		map.put("end", end);
		return super.getQueryResult(hql, map);
	}

	public List<CustomerContract> findCustomerContractByDateAndSellerDefaultDate(Date begin, Date end)
			throws DAOException {
		String hql = "";
		hql = "from CustomerContract where startDate between :begin and :end and sellerDefaultDate is not null";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		// map.put("store", store);
		map.put("begin", begin);
		map.put("end", end);
		return super.getQueryResult(hql, map);
	}

	public List<CustomerContract> getPagingCustomerByPerson(int firstResult, int maxResults, String condition,
			Employee responsiblePerson) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from CustomerContract where responsiblePerson=:responsiblePerson";
		} else {
			hql = "from CustomerContract where name like :condition and responsiblePerson=:responsiblePerson";
			map.put("condition", "%" + condition + "%");
		}
		map.put("responsiblePerson", responsiblePerson);
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	@Override
	public List<CustomerContract> getCustomerContractCountByPerson(String condition, Employee responsiblePerson)
			throws DAOException {
		String hql = "";
		Map map = new HashMap();
		if (condition.equals("")) {
			map.put("responsiblePerson", responsiblePerson);
			hql = "from CustomerContract where responsiblePerson=:responsiblePerson";
			List<CustomerContract> list = super.getQueryResult(hql, map);
			return list;
		} else {
			map.put("responsiblePerson", responsiblePerson);
			map.put("condition", "%" + condition + "%");
			hql = "from CustomerContract where name like :condition and responsiblePerson=:responsiblePerson";
			@SuppressWarnings("rawtypes")
			List<CustomerContract> list = super.getQueryResult(hql, map);
			return list;
		}
	}

	@Override
	public CustomerContract getContractByIdNum(String contractNum) throws DAOException {
		Map map = new HashMap();
		map.put("contractNum", contractNum);
		String hql = "";
		hql = "from CustomerContract where IDNo=:contractNum";
		List<CustomerContract> list = super.getQueryResult(hql, map);
		if (!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<CustomerContract> getPagingContractByEmployee(int firstResult, int maxResults, String condition,
			Employee emp) throws DAOException {
		String hql = "";
		Map map = new HashMap();
		map.put("emp", emp);
		if (!condition.equals("")) {
			map.put("condition", "%" + condition + "%");
			hql = "select c from Record r,CustomerContract c where r.customerContract=c.id and r.employee =:emp and c.name like :condition group by r.customerContract order by c.createDate desc";
		} else {
			hql = "select c from Record r,CustomerContract c where r.customerContract=c.id and r.employee =:emp group by r.customerContract order by c.createDate desc";

		}
		return super.getPagingQueryResult(hql, map, firstResult, maxResults);
	}

	@Override
	public int getCountContractByEmployee(String condition, Employee emp) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("emp", emp);
		if (condition.equals("")) {
			map.put("condition", "%" + condition + "%");
			hql = "select count(1) from Record r,CustomerContract c where r.customerContract=c.id and r.employee =:emp and c.name like :condition group by r.customerContract";
		} else {
			hql = "select count(1) from Record r,CustomerContract c where r.customerContract=c.id and r.employee =:emp group by r.customerContract";
		}
		List<Long> lstCount = super.getQueryResult(hql, map);
		return lstCount.isEmpty() ? 0 : lstCount.get(0).intValue();
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
		if (type == 0) {
			String hql = "select count(*) from CustomerContract where state in (0,2,3)";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			String hql = "select count(*) from CustomerContract where state in (0,2,3) and store =:store";
			Map map = new HashMap();
			map.put("store", store);
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	/**
	 * 获取未结清合同数量,按门店分组
	 * 
	 * @return
	 * @throws DAOException
	 */
//	public List<StoreQuantityDTO> getUnSquareContractQuantityGroupByStore() throws DAOException{
//		String hql = "select new com.jyd.bms.dto.report.StoreQuantityDTO(store.shortName,count(*)) from CustomerContract where state in (0,2,3) group by store_id";
//		return super.getQueryResult(hql);
//	}
	@Override
	public int excuteBatchInsertCustomerContract(Set<CustomerContract> customerContractList) {
		// TODO Auto-generated method stub
		return 0;
	}
}
