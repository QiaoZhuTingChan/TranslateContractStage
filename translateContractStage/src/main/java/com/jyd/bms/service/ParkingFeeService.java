package com.jyd.bms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.ParkingFee;
import com.jyd.bms.dao.ParkingFeeDAO;

@Service("ParkingFeeService")
public class ParkingFeeService extends BaseService<ParkingFee> {
	@Autowired(required = true)
	private ParkingFeeDAO parkingFeeDAO;

	
	@Override
	public void setDAO() {
		this.baseDAO = parkingFeeDAO;
	}

}
