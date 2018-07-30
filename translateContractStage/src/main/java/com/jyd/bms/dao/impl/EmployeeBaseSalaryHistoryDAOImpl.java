package com.jyd.bms.dao.impl;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.EmployeeBaseSalaryHistory;
import com.jyd.bms.dao.EmployeeBaseSalaryHistoryDAO;

@Repository
public class EmployeeBaseSalaryHistoryDAOImpl extends HibernateBaseTemplate<EmployeeBaseSalaryHistory> implements EmployeeBaseSalaryHistoryDAO{

}
