package com.jyd.bms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.ScheduleType;
import com.jyd.bms.dao.ScheduleTypeDAO;

@Service("ScheduleTypeService")
public class ScheduleTypeService extends BaseService<ScheduleType>{

	@Autowired(required = true)
	private ScheduleTypeDAO scheduleTypeDAO;
	
	@Override
	public void setDAO() {
		this.baseDAO = scheduleTypeDAO;
	}
	
}
