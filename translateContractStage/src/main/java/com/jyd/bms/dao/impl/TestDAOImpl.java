package com.jyd.bms.dao.impl;


import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Test;
import com.jyd.bms.dao.TestDAO;

@Repository
public class TestDAOImpl extends HibernateBaseTemplate<Test> implements TestDAO {

	
}
