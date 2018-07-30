//package com.jyd.bms.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.jyd.bms.dao.DtoLateFeeDAO;
//import com.jyd.bms.dto.report.DtoLateFee;
//import com.jyd.bms.tool.exception.DAOException;
//
//@Service("DtoLateFeeService")
//public class DtoLateFeeService extends BaseService<DtoLateFee> {
//	@Autowired(required = true)
//	private DtoLateFeeDAO dtoLateFeeDAO;
//
//	@Override
//	public void setDAO() {
//		this.baseDAO = dtoLateFeeDAO;
//
//	}
//
//	public List<DtoLateFee> findDtoLateFeeAll() throws DAOException {
//		// TODO Auto-generated method stub
//		return dtoLateFeeDAO.findDtoLateFeeAll();
//	}
//
//}
