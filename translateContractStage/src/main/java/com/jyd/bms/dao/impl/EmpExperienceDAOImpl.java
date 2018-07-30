package com.jyd.bms.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.EmpExperience;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.dao.EmpExperienceDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class EmpExperienceDAOImpl extends HibernateBaseTemplate<EmpExperience> implements EmpExperienceDAO {
	public List<EmpExperience> findEmpExperienceByEmp(Employee emp) throws DAOException {
		String hql = "";
		hql = "from EmpExperience where employee = :emp";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("emp", emp);
		return super.getQueryResult(hql, map);
	}

	public int findEmpExperienceCountByTypeAndWeek(int type) throws DAOException {
		Date end = Calendar.getInstance().getTime();
		Calendar cal = Calendar.getInstance();
		cal.add(cal.DATE, -7);
		Date begin = cal.getTime();
		String hql = "";
		hql = "select count(*) from EmpExperience where type = :type and effectiveDate between :begin and :end";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("type", type);
		map.put("begin", begin);
		map.put("end", end);
		List<Long> lstCount = super.getQueryResult(hql, map);
		return lstCount.get(0).intValue();
	}

	public int findEmpExperienceCountByEntryDeptAndWeek(Department dept) throws DAOException {
		Date end = Calendar.getInstance().getTime();
		Calendar cal = Calendar.getInstance();
		cal.add(cal.DATE, -7);
		Date begin = cal.getTime();
		String hql = "";
		hql = "select count(*) from EmpExperience where type = 2 and newId = :newId and effectiveDate between :begin and :end";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("newId", dept.getId());
		map.put("begin", begin);
		map.put("end", end);
		List<Long> lstCount = super.getQueryResult(hql, map);
		return lstCount.get(0).intValue();
	}

	public int findEmpExperienceCountByOutDeptAndWeek(Department dept) throws DAOException {
		Date end = Calendar.getInstance().getTime();
		Calendar cal = Calendar.getInstance();
		cal.add(cal.DATE, -7);
		Date begin = cal.getTime();
		String hql = "";
		hql = "select count(*) from EmpExperience where type = 2 and oldId = :oldId and effectiveDate between :begin and :end";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("oldId", dept.getId());
		map.put("begin", begin);
		map.put("end", end);
		List<Long> lstCount = super.getQueryResult(hql, map);
		return lstCount.get(0).intValue();
	}

	public int findEmpExperienceCountByTypeAndMonth(int type) throws DAOException {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
		int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, firstDay);
		Date begin = cal.getTime();
		Calendar cal1 = Calendar.getInstance();
		cal1.set(Calendar.YEAR, cal1.get(Calendar.YEAR));
		cal1.set(Calendar.MONTH, cal1.get(Calendar.MONTH) - 1);
		int lastDay = cal1.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal1.set(Calendar.DAY_OF_MONTH, lastDay);
		Date end = cal1.getTime();
		String hql = "";
		hql = "select count(*) from EmpExperience where type = :type and effectiveDate between :begin and :end";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("type", type);
		map.put("begin", begin);
		map.put("end", end);
		List<Long> lstCount = super.getQueryResult(hql, map);
		return lstCount.get(0).intValue();

	}

	public int findEmpExperienceCountByEntryDeptAndMonth(Department dept) throws DAOException {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
		int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, firstDay);
		Date begin = cal.getTime();
		Calendar cal1 = Calendar.getInstance();
		cal1.set(Calendar.YEAR, cal1.get(Calendar.YEAR));
		cal1.set(Calendar.MONTH, cal1.get(Calendar.MONTH) - 1);
		int lastDay = cal1.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal1.set(Calendar.DAY_OF_MONTH, lastDay);
		Date end = cal1.getTime();
		String hql = "";
		hql = "select count(*) from EmpExperience where type = 2 and newId = :newId and effectiveDate between :begin and :end";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("newId", dept.getId());
		map.put("begin", begin);
		map.put("end", end);
		List<Long> lstCount = super.getQueryResult(hql, map);
		return lstCount.get(0).intValue();
	}

	public int findEmpExperienceCountByOutDeptAndMonth(Department dept) throws DAOException {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
		int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, firstDay);
		Date begin = cal.getTime();
		Calendar cal1 = Calendar.getInstance();
		cal1.set(Calendar.YEAR, cal1.get(Calendar.YEAR));
		cal1.set(Calendar.MONTH, cal1.get(Calendar.MONTH) - 1);
		int lastDay = cal1.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal1.set(Calendar.DAY_OF_MONTH, lastDay);
		Date end = cal1.getTime();
		String hql = "";
		hql = "select count(*) from EmpExperience where type = 2 and oldId = :oldId and effectiveDate between :begin and :end";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("oldId", dept.getId());
		map.put("begin", begin);
		map.put("end", end);
		List<Long> lstCount = super.getQueryResult(hql, map);
		return lstCount.get(0).intValue();
	}

	/**
	 * 原生sql查
	 */
	public List<Object[]> fingEmpExperienceAllId() throws DAOException {
		List<Object[]> list = new ArrayList<>();
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		SQLQuery sqlQuery = session
				.createSQLQuery("SELECT * FROM hr_emp_experience WHERE length(old_data)!=char_length(old_data);");
		list = sqlQuery.list();

		transaction.commit();
		session.close();

		return list.isEmpty() ? null : list;
	}

	/**
	 * 原生sqlupdate
	 */
	public int updateEmpExperiencBySQL(List<EmpExperience> empExperienceList, String type) throws DAOException {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		StringBuilder sql = new StringBuilder("update hr_emp_experience set");
		int count = 0;
		if (type.equals("old")) {
			sql.append(" old_data=:old_data where emp_experience_id=:emp_experience_id");
			for (EmpExperience empExperience : empExperienceList) {
				SQLQuery sqlQuery = session.createSQLQuery(sql.toString());
				sqlQuery.setParameter("old_data", empExperience.getOldData());
				sqlQuery.setParameter("emp_experience_id", empExperience.getId());
				int number = sqlQuery.executeUpdate();
				count += number;
			}

		}

		if (type.equals("new")) {
			count = 0;
			sql.append(" new_data=:new_data where emp_experience_id=:emp_experience_id");
			for (EmpExperience empExperience : empExperienceList) {
				SQLQuery sqlQuery = session.createSQLQuery(sql.toString());
				sqlQuery.setParameter("new_data", empExperience.getNewData());
				sqlQuery.setParameter("emp_experience_id", empExperience.getId());
				int number = sqlQuery.executeUpdate();
				count += number;
			}
		}
		transaction.commit();
		session.close();

		return count;
	}

	/**
	 * 根据生效日期范围查询员工调动的员工经历
	 * 
	 * @throws ParseException
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EmpExperience> getEmpExperienceByTypeAndEffectiveDate(String yearMonth)
			throws ParseException, DAOException {
		String yearStr = yearMonth.substring(0, 4);
		String monthStr = yearMonth.substring(4, 6);
		String beginDateStr = yearStr + "-" + monthStr + "-01";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate = sdf.parse(beginDateStr);

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(beginDate);
		calendar.add(calendar.MONTH, 1);
		calendar.add(calendar.DATE, -1);
		Date endDate = calendar.getTime();
		
		StringBuilder hql = new StringBuilder("");
		Map<String, Object> map = new HashMap<>();
		hql.append(
				"from EmpExperience where type = 2 and effectiveDate between :beginDate and :endDate");
		map.put("beginDate", beginDate);
		map.put("endDate", endDate);

		return super.getQueryResult(hql.toString(), map);
	}

}
