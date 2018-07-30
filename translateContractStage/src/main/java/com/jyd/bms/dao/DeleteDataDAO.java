package com.jyd.bms.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.jyd.bms.bean.CustomerContract;

public interface DeleteDataDAO{

	public int deleteDateByStoreAndDate(int storeId, Date date);
	public int deleteDateByStoreAndDate1(int storeId, Date date);
	public int deleteDateByStoreAndDate2(int storeId, Date date);
	public int deleteDateByStoreAndDate2(int storeid, List<String> contractNumList);
	public int deleteDateByStoreAndDate1(int storeid, List<String> contractNumList);

}
