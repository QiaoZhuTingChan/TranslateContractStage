package com.jyd.bms.dao.impl;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.ScheduleType;
import com.jyd.bms.dao.ScheduleTypeDAO;

@Repository
public class ScheduleTypeDAOImpl extends HibernateBaseTemplate<ScheduleType> implements ScheduleTypeDAO {

}
