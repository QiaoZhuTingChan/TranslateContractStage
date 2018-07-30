package com.jyd.bms.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.dao.BaParkingFeeDAO;
import com.jyd.bms.dao.GpsCostTypeDAO;

@Service("WorkflowTestService")
public class WorkflowTestService {
	@Autowired(required = true)
	private BaParkingFeeDAO baParkingFeeDAO;
	@Autowired(required = true)
	private GpsCostTypeDAO gpsCostTypeDAO;

	public void addWorkflowForm(Map<String, Object> map) {
		
	}
}
