package com.jyd.bms.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.EmpExperience;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.Store;
import com.jyd.bms.dao.EmpExperienceDAO;
import com.jyd.bms.tool.exception.DAOException;


@Service("EmpExperienceService")
public class EmpExperienceService  extends BaseService<EmpExperience> {
	@Autowired(required = true)
	private EmpExperienceDAO empExperienceDAO;
	
	public List<EmpExperience> getEmpExperienceByEmp(Employee emp) throws DAOException{
		return empExperienceDAO.findEmpExperienceByEmp(emp);
	}

	/**
	 * 原生sql查询
	 * @return
	 * @throws DAOException
	 */
	public List<Object[]> fingEmpExperienceAllId() throws DAOException{
		return empExperienceDAO.fingEmpExperienceAllId();
	}
	/**
	 * 原生sqlupdate
	 * @param empExperienceList
	 * @param type
	 * @return
	 * @throws DAOException
	 */
	public int updateEmpExperiencBySQL(List<EmpExperience> empExperienceList, String type) throws DAOException{
		return empExperienceDAO.updateEmpExperiencBySQL(empExperienceList, type);
	}
	
	/**
	 * 根据指定部门跟年月查询“员工调动”的员工经历,从而得到员工集合
	 * @param type type=1,员工调入；type=-1, 员工调出
	 * @param department
	 * @param yearMonth
	 * @return
	 * @throws DAOException 
	 * @throws ParseException 
	 */
	public List<Employee> getEmployeeByTypeAndDepartmentAndEffectiveDate(int type, Department department, String yearMonth) throws ParseException, DAOException{
		List<EmpExperience> list = getEmpExperienceByTypeAndEffectiveDate(yearMonth);
		//存储员工
		Map<Integer,Employee> employeeMap = new HashMap<>();
		int departmentId = department.getId();
		int storeId = department.getStore().getId();
		String departmentIdJsonKey = "departmentId";
		String storeIdJsonKey = "storeId";
		
		List<Employee> employeeList = getEmployeeList(type, list, employeeMap, departmentId, storeId, departmentIdJsonKey, storeIdJsonKey);
		return employeeList;
	}
	
	private List<Employee> getEmployeeList(int type, List<EmpExperience> list, Map<Integer, Employee> employeeMap,
			int departmentId, int storeId, String departmentIdJsonKey, String storeIdJsonKey) {
		
		//找出同门店的员工经历，这时候可能同一个员工有多个经历
		for (EmpExperience empExperience : list) {
			JSONObject jsonObject = null;
			if(type == 1) {//员工调入
				if(empExperience.getNewData().startsWith("{")) {
					jsonObject = JSON.parseObject(empExperience.getNewData());
				}
			}
			if(type == -1) {//员工调出
				if(empExperience.getOldData().startsWith("{")) {
					jsonObject = JSON.parseObject(empExperience.getOldData());
				}
			}
			
			if(jsonObject != null) {
				String departmentIdJsonValue = jsonObject.getString(departmentIdJsonKey);
				String storeIdJsonValue = jsonObject.getString(storeIdJsonKey);
				if(String.valueOf(storeId).equals(storeIdJsonValue)) {
					if(String.valueOf(departmentId).equals(departmentIdJsonValue)) {
						if(!employeeMap.containsKey(empExperience.getEmployee().getId())) {//用map存储去除重复的员工
							employeeMap.put(empExperience.getEmployee().getId(), empExperience.getEmployee());
						}
					}
				}
			}
		}
		
		//将数据放进list中返回
		List<Employee> employeeList = new ArrayList<>();
		for (Integer key : employeeMap.keySet()) {
			employeeList.add(employeeMap.get(key));
		}
		return employeeList;
	}

	/**
	 * 根据门店跟年月查询“员工调动”的员工经历,从而得到员工集合
	 * @param type type=1,员工调入；type=-1, 员工调出
	 * @param store
	 * @param yearMonth
	 * @return
	 * @throws DAOException 
	 * @throws ParseException 
	 */
	public List<Employee> getEmployeeByTypeAndStoreAndEffectiveDate(int type, Store store, String yearMonth) throws ParseException, DAOException{
		List<EmpExperience> list = getEmpExperienceByTypeAndEffectiveDate(yearMonth);
		//存储员工
		Map<Integer,Employee> employeeMap = new HashMap<>();
		int storeId = store.getId();
		String jsonKey = "storeId";
		
		List<Employee> employeeList = getEmployeeList(type, list, employeeMap, storeId, jsonKey);
		return employeeList;
	}

	public List<Employee> getEmployeeList(int type, List<EmpExperience> list, Map<Integer, Employee> employeeMap, int storeId,
			String jsonKey) {
		//找出同门店的员工经历，这时候可能同一个员工有多个经历
		for (EmpExperience empExperience : list) {
			JSONObject jsonObject = null;
			if(type == 1) {//员工调入
				if(empExperience.getNewData().startsWith("{")) {
					jsonObject = JSON.parseObject(empExperience.getNewData());
				}
			}
			if(type == -1) {//员工调出
				if(empExperience.getOldData().startsWith("{")) {
					jsonObject = JSON.parseObject(empExperience.getOldData());
				}
			}
			
			if(jsonObject != null) {
				String jsonValue = jsonObject.getString(jsonKey);
				if(String.valueOf(storeId).equals(jsonValue)) {
					if(!employeeMap.containsKey(empExperience.getEmployee().getId())) {//用map存储去除重复的员工
						employeeMap.put(empExperience.getEmployee().getId(), empExperience.getEmployee());
					}
				}
			}
		}
		
		//将数据放进list中返回
		List<Employee> employeeList = new ArrayList<>();
		for (Integer key : employeeMap.keySet()) {
			employeeList.add(employeeMap.get(key));
		}
		return employeeList;
	}
	
	/**
	 * 根据年月查询员工调动的员工经历
	 * @param type
	 * @param yearMonth
	 * @return
	 * @throws DAOException 
	 * @throws ParseException 
	 */
	public List<EmpExperience> getEmpExperienceByTypeAndEffectiveDate(String yearMonth) throws ParseException, DAOException{
		return empExperienceDAO.getEmpExperienceByTypeAndEffectiveDate(yearMonth);
	}
	
	@Override
	public void setDAO() {
		this.baseDAO = empExperienceDAO;
	}
	
	

}
