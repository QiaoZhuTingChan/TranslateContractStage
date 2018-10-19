package com.jyd.bms.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.dao.DeleteDataDAO;

@Repository
public class DeleteDataDAOImpl extends HibernateBaseTemplate<Object> implements DeleteDataDAO {

	@Override
	public int deleteDateByStoreAndDate(int storeId, Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dateStr = sdf.format(date);

		HibernateTemplate template = this.getHibernateTemplate();
		SessionFactory factory = template.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		// transaction.begin();

		StringBuilder hql = new StringBuilder();
		// hql.append("set sql_safe_updates=0;");
		hql.append("delete stage,ment,fee \n"
				+ "	from cus_contract_stage stage \n"
				+ "	left join cus_contract_repayment ment \n"
				+ "		on stage.id=ment.cus_contract_stage_id\n"
				+ "	left join cus_contract_stage_fee fee \n"
				+ "		on stage.id=fee.cus_contract_stage_id \n"
				+ "	where stage.cus_contract_id in(\n"
				+ "			select id from cus_contract where store_id=")
				.append(":storeId").append(" and DATE_FORMAT(create_date,'%Y%m%d')<=").append(":dateStr").append(");");

		SQLQuery sqlQuery = session.createSQLQuery(hql.toString());
		sqlQuery.setInteger("storeId", storeId);
		sqlQuery.setString("dateStr", dateStr);

		int conut = sqlQuery.executeUpdate();

		transaction.commit();
		session.close();
		// factory.close();

		return conut;

	}

	@Override
	public int deleteDateByStoreAndDate1(int storeId, Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dateStr = sdf.format(date);

		HibernateTemplate template = this.getHibernateTemplate();
		SessionFactory factory = template.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		// transaction.begin();

		StringBuilder hql = new StringBuilder();
		// hql.append("set sql_safe_updates=0;");
		hql.append("delete c,cost,gpsfee,para,fee,lender,stage,ment,stagefee\n"
				+ "	FROM cus_contract c \n"
				+ "	left join cus_contract_cost cost \n" + ""
				+ "		on c.id=cost.cus_contract_id \n"
				+ "	left join cus_contract_gps_late_fee gpsfee \n"
				+ "		on c.id=gpsfee.cus_contract_id \n"
				+ "	left join  cus_contract_para para \n"
				+ "		on c.id=para.cus_contract_id \n"
				+ "	left join cus_contract_late_fee fee \n"
				+ "		on c.id=fee.cus_contract_id \n"
				+ "	left join cus_contract_lender lender \n"
				+ "		on c.id=lender.cus_contract_id \n"
				+ "	left join cus_contract_stage stage \n"
				+ "		on c.id=stage.cus_contract_id\n"
				+ "	left join cus_contract_stage_fee stagefee \n"
				+ "		on stage.id=stagefee.cus_contract_stage_id\n"
				+ "	left join cus_contract_repayment ment \n"
				+ "		on stage.id=ment.cus_contract_stage_id\n")
				.append(" where c.store_id=").append(":storeId").append(" and DATE_FORMAT(c.create_date,'%Y%m%d')<=")
				.append(":dateStr");

		SQLQuery sqlQuery = session.createSQLQuery(hql.toString());
		sqlQuery.setInteger("storeId", storeId);
		sqlQuery.setString("dateStr", dateStr);

		int conut = sqlQuery.executeUpdate();

		transaction.commit();
		session.close();
		// factory.close();

		return conut;
	}

	@Override
	public int deleteDateByStoreAndDate2(int storeId, Date date) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dateStr = sdf.format(date);

		HibernateTemplate template = this.getHibernateTemplate();
		SessionFactory factory = template.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		// transaction.begin();

		StringBuilder hql = new StringBuilder();
		// hql.append("set sql_safe_updates=0;");
		hql.append("delete otherfee \n" + 
				"	from cus_contract_stage stage \n" + 
				"	left join cus_contract_repayment ment \n" + 
				"		on stage.id=ment.cus_contract_stage_id\n" + 
				"	left join cus_contract_repayment_other_fee otherfee \n" + 
				"		on otherfee.cus_contract_repayment_id = ment.id\n" + 
				"	where stage.stage = 0 and stage.cus_contract_id in(\n" + 
				"			select id from cus_contract where store_id=")
				.append(":storeId").append(" and DATE_FORMAT(create_date,'%Y%m%d')<=").append(":dateStr").append(");");

		SQLQuery sqlQuery = session.createSQLQuery(hql.toString());
		sqlQuery.setInteger("storeId", storeId);
		sqlQuery.setString("dateStr", dateStr);

		int conut = sqlQuery.executeUpdate();

		transaction.commit();
		session.close();
		// factory.close();

		return conut;

	
	}

	@Override
	public int deleteDateByStoreAndDate2(int storeId, List<String> contractNumList) {

		int conut = 0;

		HibernateTemplate template = this.getHibernateTemplate();
		SessionFactory factory = template.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		// transaction.begin();

		try {
			StringBuilder hql = new StringBuilder();
			// hql.append("set sql_safe_updates=0;");
			hql.append("delete otherfee \n" + 
					"	from cus_contract_stage stage \n" + 
					"	left join cus_contract_repayment ment \n" + 
					"		on stage.id=ment.cus_contract_stage_id\n" + 
					"	left join cus_contract_repayment_other_fee otherfee\n" + 
					"		on otherfee.cus_contract_repayment_id = ment.id\n" +
					"   left join cus_contract cus on cus.id = stage.cus_contract_id\n" +
					"	where cus.state != 5 and stage.stage = 0 and stage.cus_contract_id in(\n" + 
					"			select id from cus_contract where store_id = :storeId and  cus_contract_no in (:contractNumList)\n" + 
					"				);\n" + 
					"");

			SQLQuery sqlQuery = session.createSQLQuery(hql.toString());
			sqlQuery.setInteger("storeId", storeId);
			sqlQuery.setParameterList("contractNumList", contractNumList);

			conut = sqlQuery.executeUpdate();

			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		session.close();
		// factory.close();

		return conut;

	
	
	}

	@Override
	public int deleteDateByStoreAndDate1(int storeId, List<String> contractNumList) {
		int conut = 0;
		

		HibernateTemplate template = this.getHibernateTemplate();
		SessionFactory factory = template.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		// transaction.begin();

		try {
			StringBuilder hql = new StringBuilder();
			// hql.append("set sql_safe_updates=0;");
			hql.append("delete c,cost,gpsfee,para,lender,stage,ment,stagefee\n" + 
					"	FROM cus_contract c \n" + 
					"	left join cus_contract_cost cost \n" + 
					"		on c.id=cost.cus_contract_id \n" + 
					"	left join cus_contract_gps_late_fee gpsfee \n" + 
					"		on c.id=gpsfee.cus_contract_id \n" + 
					"	left join  cus_contract_para para \n" + 
					"		on c.id=para.cus_contract_id \n" + 
					"	left join cus_contract_lender lender \n" + 
					"		on c.id=lender.cus_contract_id \n" + 
					"	left join cus_contract_stage stage \n" + 
					"		on c.id=stage.cus_contract_id\n" + 
					"	left join cus_contract_stage_fee stagefee \n" + 
					"		on stage.id=stagefee.cus_contract_stage_id\n" + 
					"	left join cus_contract_repayment ment \n" + 
					"		on stage.id=ment.cus_contract_stage_id\n" + 
					"	where c.state != 5 and c.id in(select a.id from (\n" + 
					"			select id from cus_contract where store_id = :storeId and  cus_contract_no in (:contractNumList)\n" + 
					"			)a);");

			SQLQuery sqlQuery = session.createSQLQuery(hql.toString());
			sqlQuery.setInteger("storeId", storeId);
			sqlQuery.setParameterList("contractNumList", contractNumList);


			conut = sqlQuery.executeUpdate();

			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		session.close();
		// factory.close();

		return conut;
	
	}

}
