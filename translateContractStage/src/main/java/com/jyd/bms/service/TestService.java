package com.jyd.bms.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Test;
import com.jyd.bms.dao.TestDAO;
import com.jyd.bms.tool.exception.CreateException;

@Service("TestService")
public class TestService extends BaseService<Test> {
	@Autowired(required = true)
	private TestDAO testDAO;
	
	public boolean autoAddTest() throws CreateException {
		Calendar cal = Calendar.getInstance();
		Test test = new Test();
		test.setTest("test");
		test.setDate(cal.getTime());
		testDAO.add(test);
		return true;
	}

	

	@Override
	public void setDAO() {
		this.baseDAO = testDAO;
	}

}
