package com.jyd.bms.dao.impl;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.EmployeeSalaryHistory;
import com.jyd.bms.dao.EmployeeSalaryHistoryDAO;

@Repository
public class EmployeeSalaryHistoryDAOImpl extends HibernateBaseTemplate<EmployeeSalaryHistory> implements EmployeeSalaryHistoryDAO{

}
