package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Form;
import com.jyd.bms.dao.FormDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("FormService")
public class FormService extends BaseService<Form> {
	@Autowired(required = true)
	private FormDAO formDAO;

	/**
	 * 按查询条件获取记录条数
	 * 
	 * @param condition
	 * @return 记录条数
	 * @throws DAOException
	 */
	public int getFormCount(String condition) throws DAOException {
		return formDAO.getFormCount(condition);
	}

	/**
	 * 按查询条件获取分页记录
	 * 
	 * @param firstResult
	 *            开始行
	 * @param maxResults
	 *            结束行
	 * @param condition
	 *            查询条件
	 * @return 分页数据
	 * @throws DAOException
	 */
	public List<Form> getPagingForm(int firstResult, int maxResults, String condition) throws DAOException {
		return formDAO.getPagingForm(firstResult, maxResults, condition);
	}

	/**
	 * 获取所有记录
	 * 
	 * @return 所有记录
	 * @throws DAOException
	 */
	public List<Form> getAllForm() throws DAOException {
		return formDAO.getAllForm();
	}

	/**
	 * 按表单名称获取记录
	 * 
	 * @param name
	 *            表单名称
	 * @return 表单
	 * @throws DAOException
	 */
	public List<Form> getFormByName(String name) throws DAOException {
		return formDAO.getFormByName(name);
	}

	@Override
	public void setDAO() {
		this.baseDAO = formDAO;
	}
}
