package com.jyd.bms.tool.workflow;

import com.jyd.bms.bean.WorkflowStatus;

public interface WorkflowDataInterface {
	/**
	 * 保存表单数据到实体表
	 * 
	 * @param workflowStatus
	 * @return
	 */
	public boolean saveFormData(WorkflowStatus workflowStatus);
	/**
	 * 取消工作流数据
	 * @param workflowStatus
	 * @return
	 */
	public boolean cancelFormData(WorkflowStatus workflowStatus);

	/**
	 * 获取表单内容
	 * @param content
	 * @param workflowStatus
	 * @return
	 */
	public Object getData(String content, WorkflowStatus workflowStatus);
	
	/**
	 * 退回
	 * @param workflowStatus
	 * @param index
	 */
	public void sendBack(WorkflowStatus workflowStatus,int index);
}
