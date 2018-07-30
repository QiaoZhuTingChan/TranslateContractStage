package com.jyd.bms.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.Store;
import com.jyd.bms.bean.WorkflowAgent;
import com.jyd.bms.bean.WorkflowStatus;
import com.jyd.bms.bean.WorkflowType;
import com.jyd.bms.bean.WorkflowTypeFlow;
import com.jyd.bms.dao.DepartmentDAO;
import com.jyd.bms.dao.DutyTypeDAO;
import com.jyd.bms.dao.EmployeeDAO;
import com.jyd.bms.dao.PositionTypeDAO;
import com.jyd.bms.dao.StoreDAO;
import com.jyd.bms.dao.WorkflowAgentDAO;
import com.jyd.bms.dao.WorkflowTypeFlowDAO;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.tool.exception.DataNotFoundException;

@Service("WorkflowTypeFlowService")
public class WorkflowTypeFlowService extends BaseService<WorkflowTypeFlow> {
	@Autowired(required = true)
	private WorkflowTypeFlowDAO workFlowTypeFlowDAO;
	@Autowired(required = true)
	private EmployeeDAO employeeDAO;
	@Autowired(required = true)
	private PositionTypeDAO positionTypeDAO;
	@Autowired(required = true)
	private DutyTypeDAO dutyTypeDAO;
	@Autowired(required = true)
	private DepartmentDAO departmentDAO;
	@Autowired(required = true)
	private WorkflowAgentDAO workflowAgentDAO;
	@Autowired(required = true)
	private StoreDAO storeDAO;

	public List<WorkflowTypeFlow> getWorkflowTypeFlowByWorkflowType(WorkflowType workflowType) throws DAOException {
		return workFlowTypeFlowDAO.getWorkflowTypeFlowList(workflowType);
	}

	public Employee getNodeApproverInitiator(Employee emp) {
		return emp;
	}

	public List<Employee> getNodeApproverPosition(WorkflowTypeFlow workflowTypeFlow, Department dept)
			throws DAOException, DataNotFoundException {
		List<Employee> list = employeeDAO.getEmpByDeptAndPosition(dept,
				positionTypeDAO.getById(workflowTypeFlow.getValue()));
		if (list.isEmpty()) {
			if (dept.getParentDepartment() == null) {
				return list;
			} else {
				return getNodeApproverPosition(workflowTypeFlow, dept.getParentDepartment());
			}
		} else {
			return list;
		}
	}

	public List<Employee> getNodeApproverDuty(WorkflowTypeFlow workflowTypeFlow, Department dept)
			throws DAOException, DataNotFoundException {
		Store store = storeDAO.getById(dept.getStore().getId());
		List<Employee> list = employeeDAO.findEmpByStoreAndDuty(store,
				dutyTypeDAO.getById(workflowTypeFlow.getValue()));
		if (list.isEmpty()) {
			if (dept.getParentDepartment() == null) {
				return list;
			} else {
				Department parentDepartment = departmentDAO.getById(dept.getParentDepartment().getId());
				return getNodeApproverDuty(workflowTypeFlow, parentDepartment);
			}
		} else {
			return list;
		}
	}

	public Employee getNodeApproverDeptHead(Department dept) throws DAOException, DataNotFoundException {
		Employee deptHead = employeeDAO.getHeadByDept(dept);
		if (deptHead == null) {
			if (dept.getParentDepartment() == null) {
				return null;
			} else {
				Department parentDepartment = departmentDAO.getById(dept.getParentDepartment().getId());
				return getNodeApproverDeptHead(parentDepartment);
			}
		} else {
			return deptHead;
		}
	}

	public Employee getNodeApproverEmp(WorkflowTypeFlow workflowTypeFlow) throws DataNotFoundException, DAOException {
		Employee emp = employeeDAO.findEmpById(workflowTypeFlow.getValue());
		return emp;
	}

	public Department getHeadDept(Department dept) {
		if (dept.getParentDepartment() == null) {
			return dept;
		} else {
			return getHeadDept(dept.getParentDepartment());
		}
	}

	/**
	 * 获取员工可参与的流程数目
	 * 
	 * @param workflowType
	 *            流程类型
	 * @param emp
	 *            发起员工
	 * @return 流程类型节点对应可处理的员工
	 */
	public Map<WorkflowTypeFlow, List<Employee>> getWorkflowTypeNodeApprover(WorkflowType workflowType, Employee emp)
			throws Exception {
		Map<WorkflowTypeFlow, List<Employee>> map = new HashMap<WorkflowTypeFlow, List<Employee>>();
		List<WorkflowTypeFlow> workflowTypeFlows = workFlowTypeFlowDAO.getWorkflowTypeFlowList(workflowType);
		for (WorkflowTypeFlow workFlowTypeFlow : workflowTypeFlows) {
			if (!workFlowTypeFlow.isDistinctStore() && !workFlowTypeFlow.isMajorDept()) {
				if (workFlowTypeFlow.getFlow().getName().equals("发起人")) {
					List<Employee> list = new ArrayList<Employee>();
					if (getNodeApproverInitiator(emp) == null) {
						map.put(workFlowTypeFlow, list);
					} else {
						list.add(getNodeApproverInitiator(emp));
						if (workflowAgentDAO.findWorkflowAgentByEmps(list).isEmpty()
								&& workflowAgentDAO.findWorkflowAgentByWorkflow(workflowType, list).isEmpty()) {

							map.put(workFlowTypeFlow, list);
						} else {
							List<Integer> indexs = new ArrayList<Integer>();
							for (WorkflowAgent workflowAgent : workflowAgentDAO.findWorkflowAgentByProcessEmp(list)) {
								for (int i = 0; i < list.size(); i++) {
									if (list.get(i).getId() == workflowAgent.getProcessEmployee().getId()) {
										// list.remove(employee);
										// indexs.add(Integer.valueOf(i));
										list.add(employeeDAO.getById(workflowAgent.getAgentEmployee().getId()));
									}
								}
							}
							// for(Integer index : indexs) {
							// list.remove(index.intValue());
							// }
							map.put(workFlowTypeFlow, list);
						}

					}
				} else if (workFlowTypeFlow.getFlow().getName().equals("职位")) {
					// if(getNodeApproverPosition(workFlowTypeFlow,emp.getDept()).isEmpty())
					// {
					// throw new Exception("There is nobody to approve!");
					// }
					List<Employee> list = getNodeApproverPosition(workFlowTypeFlow, emp.getDepartment());
					if (list.isEmpty()) {
						map.put(workFlowTypeFlow, list);
					} else {
						if (workflowAgentDAO.findWorkflowAgentByEmps(list).isEmpty()
								&& workflowAgentDAO.findWorkflowAgentByWorkflow(workflowType, list).isEmpty()) {

							map.put(workFlowTypeFlow, list);
						} else {
							List<Integer> indexs = new ArrayList<Integer>();
							for (WorkflowAgent workflowAgent : workflowAgentDAO.findWorkflowAgentByProcessEmp(list)) {
								for (int i = 0; i < list.size(); i++) {
									if (list.get(i).getId() == workflowAgent.getProcessEmployee().getId()) {
										// list.remove(employee);
										// indexs.add(Integer.valueOf(i));
										list.add(employeeDAO.getById(workflowAgent.getAgentEmployee().getId()));
									}
								}
							}
							// for(Integer index : indexs) {
							// list.remove(index.intValue());
							// }
							map.put(workFlowTypeFlow, list);
						}
					}

				} else if (workFlowTypeFlow.getFlow().getName().equals("职责")) {
					// if(getNodeApproverDuty(workFlowTypeFlow,emp.getDept()).isEmpty())
					// {
					// throw new Exception("There is nobody to approve!");
					// }
					Department department = departmentDAO.getById(emp.getDepartment().getId());
					List<Employee> list = getNodeApproverDuty(workFlowTypeFlow, department);
					if (list.isEmpty()) {
						map.put(workFlowTypeFlow, list);
					} else {
						if (workflowAgentDAO.findWorkflowAgentByEmps(list).isEmpty()
								&& workflowAgentDAO.findWorkflowAgentByWorkflow(workflowType, list).isEmpty()) {

							map.put(workFlowTypeFlow, list);
						} else {
							List<Integer> indexs = new ArrayList<Integer>();
							for (WorkflowAgent workflowAgent : workflowAgentDAO.findWorkflowAgentByProcessEmp(list)) {
								for (int i = 0; i < list.size(); i++) {
									if (list.get(i).getId() == workflowAgent.getProcessEmployee().getId()) {
										// list.remove(employee);
										// indexs.add(Integer.valueOf(i));
										list.add(employeeDAO.getById(workflowAgent.getAgentEmployee().getId()));
									}
								}
							}
							// for(Integer index : indexs) {
							// list.remove(index.intValue());
							// }
							map.put(workFlowTypeFlow, list);
						}
					}

				} else if (workFlowTypeFlow.getFlow().getName().equals("部门负责人")) {
					List<Employee> list = new ArrayList<Employee>();
					Department department = departmentDAO.getById(emp.getDepartment().getId());
					if (getNodeApproverDeptHead(department) == null) {
						map.put(workFlowTypeFlow, list);
					} else {
						list.add(getNodeApproverDeptHead(department));
						if (workflowAgentDAO.findWorkflowAgentByEmps(list).isEmpty()
								&& workflowAgentDAO.findWorkflowAgentByWorkflow(workflowType, list).isEmpty()) {

							map.put(workFlowTypeFlow, list);
						} else {
							List<Integer> indexs = new ArrayList<Integer>();
							for (WorkflowAgent workflowAgent : workflowAgentDAO.findWorkflowAgentByProcessEmp(list)) {
								for (int i = 0; i < list.size(); i++) {
									if (list.get(i).getId() == workflowAgent.getProcessEmployee().getId()) {
										// list.remove(employee);
										// indexs.add(Integer.valueOf(i));
										list.add(employeeDAO.getById(workflowAgent.getAgentEmployee().getId()));
									}
								}
							}
							// for(Integer index : indexs) {
							// list.remove(index.intValue());
							// }
							map.put(workFlowTypeFlow, list);
						}
					}
				} else if (workFlowTypeFlow.getFlow().getName().equals("员工")) {
					List<Employee> list = new ArrayList<Employee>();
					if (getNodeApproverEmp(workFlowTypeFlow) == null) {
						map.put(workFlowTypeFlow, list);
					} else {
						list.add(getNodeApproverEmp(workFlowTypeFlow));
						if (workflowAgentDAO.findWorkflowAgentByEmps(list).isEmpty()
								&& workflowAgentDAO.findWorkflowAgentByWorkflow(workflowType, list).isEmpty()) {

							map.put(workFlowTypeFlow, list);
						} else {
							List<Integer> indexs = new ArrayList<Integer>();
							for (WorkflowAgent workflowAgent : workflowAgentDAO.findWorkflowAgentByProcessEmp(list)) {
								for (int i = 0; i < list.size(); i++) {
									if (list.get(i).getId() == workflowAgent.getProcessEmployee().getId()) {
										// list.remove(employee);
										// indexs.add(Integer.valueOf(i));
										list.add(employeeDAO.getById(workflowAgent.getAgentEmployee().getId()));
									}
								}
							}
							// for(Integer index : indexs) {
							// list.remove(index.intValue());
							// }
							map.put(workFlowTypeFlow, list);
						}
					}
				}
			} else if (workFlowTypeFlow.isDistinctStore() || workFlowTypeFlow.isMajorDept()) {
				Department headDept = getHeadDept(emp.getDepartment());
				List<Department> sonDepts = departmentDAO.getDepartmentByParentDept(headDept);
				List<Department> headDepts = new ArrayList<Department>();
				// headDepts.add(headDept);
				for (Department dept : sonDepts) {
					if (dept.getDepartmentType().getId() == 1) {
						headDepts.add(dept);
					}
				}

				for (Department dept : headDepts) {
					if (dept.getDepartmentName().equals(emp.getDepartment().getDepartmentName())) {
						emp.setHeadDepartment(dept);
						employeeDAO.update(emp);
					}
				}

				if (workFlowTypeFlow.getFlow().getName().equals("发起人")) {
					List<Employee> list = new ArrayList<Employee>();
					list.add(emp);
					if (workflowAgentDAO.findWorkflowAgentByEmps(list).isEmpty()
							&& workflowAgentDAO.findWorkflowAgentByWorkflow(workflowType, list).isEmpty()) {

						map.put(workFlowTypeFlow, list);
					} else {
						List<Integer> indexs = new ArrayList<Integer>();
						for (WorkflowAgent workflowAgent : workflowAgentDAO.findWorkflowAgentByProcessEmp(list)) {
							for (int i = 0; i < list.size(); i++) {
								if (list.get(i).getId() == workflowAgent.getProcessEmployee().getId()) {
									// list.remove(employee);
									// indexs.add(Integer.valueOf(i));
									list.add(employeeDAO.getById(workflowAgent.getAgentEmployee().getId()));
								}
							}
						}
						// for(Integer index : indexs) {
						// list.remove(index.intValue());
						// }
						map.put(workFlowTypeFlow, list);
					}

				} else if (workFlowTypeFlow.getFlow().getName().equals("职位")) {
					List<Employee> list = employeeDAO.getEmpByDeptAndPosition(emp.getHeadDepartment(),
							positionTypeDAO.getById(workFlowTypeFlow.getValue()));
					if (list.isEmpty()) {
						map.put(workFlowTypeFlow, list);
					} else {
						if (workflowAgentDAO.findWorkflowAgentByEmps(list).isEmpty()
								&& workflowAgentDAO.findWorkflowAgentByWorkflow(workflowType, list).isEmpty()) {

							map.put(workFlowTypeFlow, list);
						} else {
							List<Integer> indexs = new ArrayList<Integer>();
							for (WorkflowAgent workflowAgent : workflowAgentDAO.findWorkflowAgentByProcessEmp(list)) {
								for (int i = 0; i < list.size(); i++) {
									if (list.get(i).getId() == workflowAgent.getProcessEmployee().getId()) {
										// list.remove(employee);
										// indexs.add(Integer.valueOf(i));
										list.add(employeeDAO.getById(workflowAgent.getAgentEmployee().getId()));
									}
								}
							}
							// for(Integer index : indexs) {
							// list.remove(index.intValue());
							// }
							map.put(workFlowTypeFlow, list);
						}
					}

				} else if (workFlowTypeFlow.getFlow().getName().equals("职责")) {
					List<Employee> list = employeeDAO.findEmpByStoreAndDuty(emp.getHeadDepartment().getStore(),
							dutyTypeDAO.getById(workFlowTypeFlow.getValue()));
					if (list.isEmpty()) {
						map.put(workFlowTypeFlow, list);
					} else {
						if (workflowAgentDAO.findWorkflowAgentByEmps(list).isEmpty()
								&& workflowAgentDAO.findWorkflowAgentByWorkflow(workflowType, list).isEmpty()) {

							map.put(workFlowTypeFlow, list);
						} else {
							List<Integer> indexs = new ArrayList<Integer>();
							for (WorkflowAgent workflowAgent : workflowAgentDAO.findWorkflowAgentByProcessEmp(list)) {
								for (int i = 0; i < list.size(); i++) {
									if (list.get(i).getId() == workflowAgent.getProcessEmployee().getId()) {
										// list.remove(employee);
										// indexs.add(Integer.valueOf(i));
										list.add(employeeDAO.getById(workflowAgent.getAgentEmployee().getId()));
									}
								}
							}
							// for(Integer index : indexs) {
							// list.remove(index.intValue());
							// }
							map.put(workFlowTypeFlow, list);
						}
					}

				} else if (workFlowTypeFlow.getFlow().getName().equals("部门负责人")) {
					Employee deptHead = employeeDAO.getHeadByDept(emp.getHeadDepartment());
					List<Employee> list = new ArrayList<Employee>();
					if (deptHead == null) {
						map.put(workFlowTypeFlow, list);
					} else {
						list.add(deptHead);
						if (workflowAgentDAO.findWorkflowAgentByEmps(list).isEmpty()
								&& workflowAgentDAO.findWorkflowAgentByWorkflow(workflowType, list).isEmpty()) {

							map.put(workFlowTypeFlow, list);
						} else {
							List<Integer> indexs = new ArrayList<Integer>();
							for (WorkflowAgent workflowAgent : workflowAgentDAO.findWorkflowAgentByProcessEmp(list)) {
								for (int i = 0; i < list.size(); i++) {
									if (list.get(i).getId() == workflowAgent.getProcessEmployee().getId()) {
										// list.remove(employee);
										// indexs.add(Integer.valueOf(i));
										list.add(employeeDAO.getById(workflowAgent.getAgentEmployee().getId()));
									}
								}
							}
							// for(Integer index : indexs) {
							// list.remove(index.intValue());
							// }
							map.put(workFlowTypeFlow, list);
						}
					}

				} else if (workFlowTypeFlow.getFlow().getName().equals("员工")) {
					List<Employee> list = new ArrayList<Employee>();
					Employee processEmp = employeeDAO.getById(workFlowTypeFlow.getValue());
					if (processEmp == null) {
						map.put(workFlowTypeFlow, list);
					} else {
						list.add(processEmp);
						if (workflowAgentDAO.findWorkflowAgentByEmps(list).isEmpty()
								&& workflowAgentDAO.findWorkflowAgentByWorkflow(workflowType, list).isEmpty()) {

							map.put(workFlowTypeFlow, list);
						} else {
							List<Integer> indexs = new ArrayList<Integer>();
							for (WorkflowAgent workflowAgent : workflowAgentDAO.findWorkflowAgentByProcessEmp(list)) {
								for (int i = 0; i < list.size(); i++) {
									if (list.get(i).getId() == workflowAgent.getProcessEmployee().getId()) {
										// list.remove(employee);
										// indexs.add(Integer.valueOf(i));
										list.add(employeeDAO.getById(workflowAgent.getAgentEmployee().getId()));
									}
								}
							}
							// for(Integer index : indexs) {
							// list.remove(index.intValue());
							// }
							map.put(workFlowTypeFlow, list);
						}
					}
				}
			}
		}
		return map;

	}

	public List<Employee> getEntryDeptApprover(Employee emp, WorkflowStatus workflowStatus, Department dept)
			throws DAOException, DataNotFoundException {
		if (workflowStatus.getFlow().getName().equals("发起人")) {
			List<Employee> list = new ArrayList<Employee>();
			list.add(emp);
			if (workflowAgentDAO.findWorkflowAgentByEmps(list).isEmpty() && workflowAgentDAO
					.findWorkflowAgentByWorkflow(workflowStatus.getWrokflowTypeFlow().getWorkflowType(), list)
					.isEmpty()) {

				return list;
			} else {
				List<Integer> indexs = new ArrayList<Integer>();
				for (WorkflowAgent workflowAgent : workflowAgentDAO.findWorkflowAgentByProcessEmp(list)) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getId() == workflowAgent.getProcessEmployee().getId()) {
							// list.remove(employee);
							// indexs.add(Integer.valueOf(i));
							list.add(employeeDAO.getById(workflowAgent.getAgentEmployee().getId()));
						}
					}
				}
				// for(Integer index : indexs) {
				// list.remove(index.intValue());
				// }
				return list;
			}

		} else if (workflowStatus.getFlow().getName().equals("职位")) {
			List<Employee> list = employeeDAO.getEmpByDeptAndPosition(dept,
					positionTypeDAO.getById(workflowStatus.getFlowData()));
			if (list.isEmpty()) {
				return list;
			} else {
				if (workflowAgentDAO.findWorkflowAgentByEmps(list).isEmpty() && workflowAgentDAO
						.findWorkflowAgentByWorkflow(workflowStatus.getWrokflowTypeFlow().getWorkflowType(), list)
						.isEmpty()) {

					return list;
				} else {
					List<Integer> indexs = new ArrayList<Integer>();
					for (WorkflowAgent workflowAgent : workflowAgentDAO.findWorkflowAgentByProcessEmp(list)) {
						for (int i = 0; i < list.size(); i++) {
							if (list.get(i).getId() == workflowAgent.getProcessEmployee().getId()) {
								// list.remove(employee);
								// indexs.add(Integer.valueOf(i));
								list.add(employeeDAO.getById(workflowAgent.getAgentEmployee().getId()));
							}
						}
					}
					// for(Integer index : indexs) {
					// list.remove(index.intValue());
					// }
					return list;
				}
			}

		} else if (workflowStatus.getFlow().getName().equals("职责")) {
			List<Employee> list = employeeDAO.getEmpByDeptAndDuty(dept,
					dutyTypeDAO.getById(workflowStatus.getFlowData()));
			if (list.isEmpty()) {
				return list;
			} else {
				if (workflowAgentDAO.findWorkflowAgentByEmps(list).isEmpty() && workflowAgentDAO
						.findWorkflowAgentByWorkflow(workflowStatus.getWrokflowTypeFlow().getWorkflowType(), list)
						.isEmpty()) {

					return list;
				} else {
					List<Integer> indexs = new ArrayList<Integer>();
					for (WorkflowAgent workflowAgent : workflowAgentDAO.findWorkflowAgentByProcessEmp(list)) {
						for (int i = 0; i < list.size(); i++) {
							if (list.get(i).getId() == workflowAgent.getProcessEmployee().getId()) {
								// list.remove(employee);
								// indexs.add(Integer.valueOf(i));
								list.add(employeeDAO.getById(workflowAgent.getAgentEmployee().getId()));
							}
						}
					}
					// for(Integer index : indexs) {
					// list.remove(index.intValue());
					// }
					return list;
				}
			}

		} else if (workflowStatus.getFlow().getName().equals("部门负责人")) {
			List<Employee> list = new ArrayList<Employee>();
			Employee deptHead = employeeDAO.getHeadByDept(dept);
			if (deptHead == null) {
				return list;
			} else {
				list.add(deptHead);
				if (workflowAgentDAO.findWorkflowAgentByEmps(list).isEmpty() && workflowAgentDAO
						.findWorkflowAgentByWorkflow(workflowStatus.getWrokflowTypeFlow().getWorkflowType(), list)
						.isEmpty()) {

					return list;
				} else {
					List<Integer> indexs = new ArrayList<Integer>();
					for (WorkflowAgent workflowAgent : workflowAgentDAO.findWorkflowAgentByProcessEmp(list)) {
						for (int i = 0; i < list.size(); i++) {
							if (list.get(i).getId() == workflowAgent.getProcessEmployee().getId()) {
								// list.remove(employee);
								// indexs.add(Integer.valueOf(i));
								list.add(employeeDAO.getById(workflowAgent.getAgentEmployee().getId()));
							}
						}
					}
					// for(Integer index : indexs) {
					// list.remove(index.intValue());
					// }
					return list;
				}
			}
		} else if (workflowStatus.getFlow().getName().equals("员工")) {
			List<Employee> list = new ArrayList<Employee>();
			Employee processEmp = employeeDAO.getById(workflowStatus.getFlowData());
			if (processEmp == null) {
				return list;
			} else {
				list.add(processEmp);
				if (workflowAgentDAO.findWorkflowAgentByEmps(list).isEmpty() && workflowAgentDAO
						.findWorkflowAgentByWorkflow(workflowStatus.getWrokflowTypeFlow().getWorkflowType(), list)
						.isEmpty()) {

					return list;
				} else {
					List<Integer> indexs = new ArrayList<Integer>();
					for (WorkflowAgent workflowAgent : workflowAgentDAO.findWorkflowAgentByProcessEmp(list)) {
						for (int i = 0; i < list.size(); i++) {
							if (list.get(i).getId() == workflowAgent.getProcessEmployee().getId()) {
								// list.remove(employee);
								// indexs.add(Integer.valueOf(i));
								list.add(employeeDAO.getById(workflowAgent.getAgentEmployee().getId()));
							}
						}
					}
					// for(Integer index : indexs) {
					// list.remove(index.intValue());
					// }
					return list;
				}
			}
		}
		List<Employee> list = new ArrayList<Employee>();
		return list;
	}

	@Override
	public void setDAO() {
		this.baseDAO = workFlowTypeFlowDAO;
	}

}
