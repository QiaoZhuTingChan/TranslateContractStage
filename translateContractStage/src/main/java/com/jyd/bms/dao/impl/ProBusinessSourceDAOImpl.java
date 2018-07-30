package com.jyd.bms.dao.impl;


import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.ProBusinessSource;
import com.jyd.bms.bean.Product;
import com.jyd.bms.dao.ProBusinessSourceDAO;
import com.jyd.bms.tool.exception.DAOException;


@Repository
public class ProBusinessSourceDAOImpl extends HibernateBaseTemplate<ProBusinessSource> implements ProBusinessSourceDAO {

	@Override
	public List<ProBusinessSource> getProBusinessSourcesByProduct(Product product) throws DAOException {
		String hql = "from ProBusinessSource where product = :product";
		Map paramMap = new HashedMap();
		paramMap.put("product", product);
		return super.getQueryResult(hql, paramMap);
	}

}
