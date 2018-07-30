package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.BaseSalaryItem;
import com.jyd.bms.dao.BaseSalaryItemDAO;
import com.jyd.bms.dao.SalaryItemTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("BaseSalaryItemService")
public class BaseSalaryItemService extends BaseService<BaseSalaryItem> {

	@Autowired(required = true)
	private BaseSalaryItemDAO baseSalaryItemDAO;

	// 获取记录条数
	public int getBaseSalaryItemCount(String condition) throws DAOException {
		return baseSalaryItemDAO.getBaseSalaryItemCount(condition);
	}

	// 分页
	public List<BaseSalaryItem> getPagingBaseSalaryItem(int firstResult, int maxResults, String condition)
			throws DAOException {
		return baseSalaryItemDAO.getPagingBaseSalaryItem(firstResult, maxResults, condition);
	}

	// 获取所有记录
	public List<BaseSalaryItem> getAllBaseSalaryItem() throws DAOException {
		return baseSalaryItemDAO.getAllBaseSalaryItem();
	}

	@Override
	public void setDAO() {
		this.baseDAO = baseSalaryItemDAO;
	}

}
