package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.ProBusinessSource;
import com.jyd.bms.bean.Product;
import com.jyd.bms.tool.exception.DAOException;

public interface ProBusinessSourceDAO extends HibernateBase<ProBusinessSource> {
	public List<ProBusinessSource> getProBusinessSourcesByProduct(Product product)throws DAOException;
}
