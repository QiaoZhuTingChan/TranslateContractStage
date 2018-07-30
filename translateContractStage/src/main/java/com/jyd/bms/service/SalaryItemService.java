package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.SalaryItem;
import com.jyd.bms.dao.SalaryItemDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("SalaryItemService")
public class SalaryItemService extends BaseService<SalaryItem> {

	@Autowired(required = true)
	private SalaryItemDAO salaryItemDAO;

	// 获取所有记录
	public List<SalaryItem> getAllSalaryItem() throws DAOException {
		return salaryItemDAO.getAllSalaryItem();
	}

	/**
	 * @category 统计条数
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getSalaryItemCount(String condition) throws DAOException {
		return salaryItemDAO.getSalaryItemCount(condition);
	}

	/**
	 * @category 查找薪资项目并且分页
	 * @param firstResult
	 *            开始页
	 * @param maxResults
	 *            条数
	 * @param condition
	 *            参数
	 * @return
	 * @throws DAOException
	 */
	public List<SalaryItem> getPagingSalaryItem(int firstResult, int maxResults, String condition) throws DAOException {
		return salaryItemDAO.getPagingSalaryItem(firstResult, maxResults, condition);
	}

	/**
	 * 根据type=8 来查找薪资项目 type=8即：手工录入项目
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<SalaryItem> getSalaryItemByEigthType() throws DAOException {
		return salaryItemDAO.getSalaryItemByEigthType();
	}

	/**
	 * @category 查询薪资项目通过编码
	 * @param code
	 * @return
	 * @throws DAOException
	 */
	public SalaryItem getSalaryItemByCode(String code) throws DAOException {
		return salaryItemDAO.getSalaryItemByCode(code);
	}

	@Override
	public void setDAO() {
		this.baseDAO = salaryItemDAO;
	}

}
