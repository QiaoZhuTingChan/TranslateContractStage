package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.SalaryItemType;
import com.jyd.bms.dao.SalaryItemTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("SalaryItemTypeService")
public class SalaryItemTypeService extends BaseService<SalaryItemType> {

	@Autowired(required = true)
	private SalaryItemTypeDAO salaryItemTypeDAO;

	// 获取记录条数
	public int getSalaryItemTypeCount(String condition) throws DAOException {
		return salaryItemTypeDAO.getSalaryItemTypeCount(condition);
	}

	// 分页
	public List<SalaryItemType> getPagingSalaryItemType(int firstResult, int maxResults, String condition)
			throws DAOException {
		return salaryItemTypeDAO.getPagingSalaryItemType(firstResult, maxResults, condition);
	}

	// 获取所有记录
	public List<SalaryItemType> getAllSalaryItemType() throws DAOException {
		return salaryItemTypeDAO.getAllSalaryItemType();
	}

	@Override
	public void setDAO() {
		this.baseDAO = salaryItemTypeDAO;
	}

}
