package com.jyd.bms.dao;

import java.util.Map;

public interface ExcelBatchInsertDataDAO extends HibernateBase<Object> {

	public int excuteBatchInsertAll(Map<String, Object> map);


}
