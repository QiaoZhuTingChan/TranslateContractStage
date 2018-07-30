package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.ProBusinessSource;
import com.jyd.bms.bean.Product;
import com.jyd.bms.dao.ProBusinessSourceDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("ProBusinessSourceService")
public class ProBusinessSourceService extends BaseService<ProBusinessSource> {
	@Autowired(required = true)
	private ProBusinessSourceDAO proBusinessSourceDAO;

	public List<ProBusinessSource> getProBusinessSourcesByProduct(Product product) throws DAOException {
		return proBusinessSourceDAO.getProBusinessSourcesByProduct(product);
	}
	
	@Override
	public void setDAO() {
		this.baseDAO = proBusinessSourceDAO;
	}

}
