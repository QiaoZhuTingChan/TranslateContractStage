package com.jyd.bms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jyd.bms.bean.CusThirdpartGpsVehicleBaseData;
import com.jyd.bms.dao.CusThirdpartGpsVehicleBaseDataDAO;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-05-07 14:18:29 by GeneratedTool
 * @author mjy
 */
@Service("CusThirdpartGpsVehicleBaseDataService")
public class CusThirdpartGpsVehicleBaseDataService extends BaseService<CusThirdpartGpsVehicleBaseData> {
	@Autowired(required = true)
	private CusThirdpartGpsVehicleBaseDataDAO cusThirdpartGpsVehicleBaseDataDAO;

	public int getCusThirdpartGpsVehicleBaseDataCount(String condition) throws DAOException {
		return cusThirdpartGpsVehicleBaseDataDAO.getCusThirdpartGpsVehicleBaseDataCount(condition);
	}

	public List<CusThirdpartGpsVehicleBaseData> getPagingCusThirdpartGpsVehicleBaseData(int firstResult, int maxResults,
			String condition) throws DAOException {
		return cusThirdpartGpsVehicleBaseDataDAO.getPagingCusThirdpartGpsVehicleBaseData(firstResult, maxResults,
				condition);
	}

	public List<CusThirdpartGpsVehicleBaseData> getAllCusThirdpartGpsVehicleBaseData() throws DAOException {
		return cusThirdpartGpsVehicleBaseDataDAO.getAllCusThirdpartGpsVehicleBaseData();
	}

	@Override

	public void setDAO() {
		this.baseDAO = cusThirdpartGpsVehicleBaseDataDAO;
	}

	public CusThirdpartGpsVehicleBaseData getCusThirdpartGpsVehicleBaseDataByPlate(String plate) throws DAOException {
		List<CusThirdpartGpsVehicleBaseData> list= cusThirdpartGpsVehicleBaseDataDAO.getCusThirdpartGpsVehicleBaseDataByPlate(plate);
		if(list != null) {
			for (CusThirdpartGpsVehicleBaseData cusThirdpartGpsVehicleBaseData : list) {
				String plate2 = cusThirdpartGpsVehicleBaseData.getPlate();
				if(!plate2.contains("无线")) {
					return cusThirdpartGpsVehicleBaseData;
				}
			}
			return list.get(0);
		}
		
		return null;
	}

}
