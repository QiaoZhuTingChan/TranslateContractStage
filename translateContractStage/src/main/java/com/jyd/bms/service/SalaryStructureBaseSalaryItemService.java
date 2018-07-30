package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.SalaryStructure;
import com.jyd.bms.bean.SalaryStructureBaseSalaryItem;
import com.jyd.bms.dao.SalaryStructureBaseSalaryItemDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("SalaryStructureBaseSalaryItemService")
public class SalaryStructureBaseSalaryItemService extends BaseService<SalaryStructureBaseSalaryItem> {

	@Autowired(required = true)
	private SalaryStructureBaseSalaryItemDAO salaryStructureBaseSalaryItemDAO;

	// 获取记录条数
	public int getSalaryStructureBaseSalaryItemCountBySalaryStructure(String condition, SalaryStructure salaryStructure) throws DAOException {
		return salaryStructureBaseSalaryItemDAO.getSalaryStructureBaseSalaryItemCountBySalaryStructure(condition, salaryStructure);
	}

	// 分页
	public List<SalaryStructureBaseSalaryItem> getPagingSalaryStructureBaseSalaryItemBySalaryStructure(int firstResult, int maxResults, String condition, SalaryStructure salaryStructure)
			throws DAOException {
		return salaryStructureBaseSalaryItemDAO.getPagingSalaryStructureBaseSalaryItemBySalaryStructure(firstResult, maxResults, condition, salaryStructure);
	}

	// 获取所有记录
	public List<SalaryStructureBaseSalaryItem> getAllSalaryStructureBaseSalaryItem(SalaryStructure salaryStructure) throws DAOException {
		return salaryStructureBaseSalaryItemDAO.getAllSalaryStructureBaseSalaryItem(salaryStructure);
	}

	@Override
	public void setDAO() {
		this.baseDAO = salaryStructureBaseSalaryItemDAO;
	}

	public List<SalaryStructureBaseSalaryItem> getSalaryStructureBaseSalaryItemBySalaryStructure(SalaryStructure salaryStructure) throws DAOException {
		return salaryStructureBaseSalaryItemDAO.getSalaryStructureBaseSalaryItemBySalaryStructure(salaryStructure);
	}

}
