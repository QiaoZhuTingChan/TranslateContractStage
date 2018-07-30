package com.jyd.bms.tool.zk;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;

import com.jyd.bms.bean.Form;
import com.jyd.bms.bean.GroupUser;
import com.jyd.bms.bean.Menu;
import com.jyd.bms.bean.PageUseLog;
import com.jyd.bms.bean.User;
import com.jyd.bms.bean.Workflow;
import com.jyd.bms.bean.WorkflowStatus;
import com.jyd.bms.common.Environment;
import com.jyd.bms.service.FormService;
import com.jyd.bms.service.GroupMenuService;
import com.jyd.bms.service.GroupUserService;
import com.jyd.bms.service.PageUseLogService;
import com.jyd.bms.service.UserService;
import com.jyd.bms.service.WorkflowStatusService;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.tool.workflow.WorkflowDataInterface;

@SuppressWarnings("serial")
public abstract class BaseComposer extends GenericForwardComposer {
	private double randomKey = Math.random();
	// private ContractFileUploadV1Div contractFileUploadV1Div;
	// private List<ContractUploadfileV1DTO> cuList = new
	// ArrayList<ContractUploadfileV1DTO>();
	private Session session = Sessions.getCurrent();

	private PageUseLogService pageUseLogService = getBean("PageUseLogService");

	// public ContractFileUploadV1Div getContractFileUploadDiv() {
	// return contractFileUploadV1Div;
	// }
	//
	// public void setContractFileUploadDiv(ContractFileUploadV1Div
	// contractFileUploadDiv) {
	// this.contractFileUploadV1Div = contractFileUploadDiv;
	// }
	//
	// public List<ContractUploadfileV1DTO> getCuList() {
	// return cuList;
	// }
	//
	// public void setCuList(List<ContractUploadfileV1DTO> cuList) {
	// this.cuList = cuList;
	// }

	public abstract void initUI();

	public abstract void initData();

	public String menuId = "";
	// 提供基本增、删、改、刷新、合并

	@SuppressWarnings("unchecked")
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		// 下面处理测试环境下，用户Session
		if (session.getAttribute("User") == null) {
			String loginName = Environment.getDefaultLoginName();
			if (loginName != null) {
				if (loginName.equals("")) {
					return;
				} else {
					UserService userService = getBean("UserService");
					try {
						User user = userService.getUserByLoginName(loginName);
						session.setAttribute("User", user);
					} catch (DAOException e) {
						return;
					}
				}
			} else {
				return;
			}
		}
		menuVerification();
		Clients.evalJavaScript("InitEnter()");

		try {
			User sessionUser = UserSession.getUser();
			Timestamp date = new Timestamp(new Date().getTime());
			if (sessionUser != null) {
				HttpServletRequest request = (HttpServletRequest) Executions.getCurrent().getNativeRequest();
				String requestUrl = request.getScheme() // 当前链接使用的协议
						+ "://" + request.getServerName()// 服务器地址
						+ ":" + request.getServerPort() // 端口号
						+ request.getContextPath() // 应用名称，如果应用名称为
						+ request.getServletPath() // 请求的相对url
						+ "?" + request.getQueryString(); // 请求参数

				PageUseLog pageUseLog = new PageUseLog();
				pageUseLog.setPageUrl(requestUrl);
				pageUseLog.setUser(sessionUser);
				pageUseLog.setIp(getClientIp(request));
				pageUseLog.setCreateDate(date);
				pageUseLogService.add(pageUseLog);
			}
		} catch (Exception e) {
		}
	}

	/**
	 * 判断用户有哪些表单的访问权限
	 * 
	 * @author mjy
	 * @param UserController
	 * 
	 */
	public void menuVerification() {
		try {
			User user = (User) session.getAttribute("User");
			if (user == null)
				return;
			if (menuId.equals(""))
				return;
			GroupUserService groupUserService = getBean("GroupUserService");
			GroupMenuService groupMenuService = getBean("GroupMenuService");
			Menu menu = new Menu();
			menu.setMenuId(menuId);
			// 根据用户查找用户组
			boolean isPermissins = false;
			List<GroupUser> groupList = groupUserService.getGroupUserByUser(user);
			for (GroupUser groupUser : groupList) {
				// 判断用户所在组是否具有菜单的权限
				if (groupMenuService.findGroupMenu(groupUser.getGroup(), menu) != null) {
					isPermissins = true;
				}
			}
			if (isPermissins || menuId.equals("index")) {
				firstLoad();
				return;
			} else {
				Executions.sendRedirect("/permissions.zul");
				return;
			}
		} catch (DAOException e) {
			return;
		}
	}

	public void firstLoad() {
		initUI();
		initData();
	}

	/**
	 * 获取Service类
	 * 
	 * @param s
	 * @return
	 */
	public <T> T getBean(String s) {
		return (T) SpringUtil.getBean(s);
	}

	/**
	 * @category 模板文件路径
	 * @return
	 */
	public String getTemplates() {
		return getProjectRootPath() + "templates/";
	}

	/**
	 * @category 静态页面路径以及打印文件路径
	 * @return
	 */
	public String getOutput() {
		return getProjectRootPath() + "output/";
	}

	/**
	 * @category 项目根目录的绝对路径
	 * @return
	 */
	public String getProjectRootPath() {
		HttpServletRequest request = (HttpServletRequest) Executions.getCurrent().getNativeRequest();
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		return rootPath;
	}

	/**
	 * @category 项目请求路径(配置文件)
	 * @return
	 */
	public String getWebPath() {
		return Environment.getWebPath();
	}

	public String getOutputWebPath() {
		return getWebPath() + "output/";
	}

	/**
	 * @category 文件服务器根目录的绝对路径
	 * @return
	 */
	public String getFileRootPath() {
		return Environment.getFilePath();
	}

	/**
	 * @category 文件服务器的请求根路径
	 * @return
	 */
	public String getFileWebPath() {
		return Environment.getWebFilePath();
	}

	/**
	 * 从工作流其他表单获取数据
	 * 
	 * @param content
	 * @param workflow
	 * @return
	 */
	public List<Object> getObjectFromWorkflowFormData(String content, Workflow workflow) {
		List<Object> list = new ArrayList<Object>();
		WorkflowStatusService workflowStatusService = getBean("WorkflowStatusService");
		if (workflow != null) {
			try {
				List<WorkflowStatus> workflowStatusList = workflowStatusService.getWorkflowStatusByWorkfow(workflow);
				for (WorkflowStatus value : workflowStatusList) {
					if (value.getForm() != null) {
						FormService formService = getBean("FormService");
						Form formValue = formService.getById(value.getForm().getId());
						Class<?> c = Class.forName(formValue.getClassFullName());
						WorkflowDataInterface form = (WorkflowDataInterface) c.newInstance();
						Object object = form.getData(content, value);
						list.add(object);
					}
				}
			} catch (DAOException e) {
				return null;
			} catch (Exception e) {
				return null;
			}
		}
		return list;
	}

	/**
	 * @category 设置文件通过序号
	 * @param contractFileUploadDiv
	 * @param status
	 *            状态新增还是修改
	 * @param index
	 *            1.业务员2.评估师3.家访4.抵押5.风控6.客服
	 * @throws DAOException
	 */
	// public void setContractUploadfileByIndex(boolean status, int processType)
	// throws DAOException {
	// if (cuList.isEmpty()) {2018-07-09 01:42:21
	// UploadFileTypeService fileService = getBean("UploadFileTypeService");
	// List<UploadFileType> uploadfileTypeList = fileService.getAllUploadFileType();
	// for (UploadFileType fileType : uploadfileTypeList) {
	// if (fileType.getForm().getId() == processType) {
	// ContractUploadfileV1DTO cUploadfile = new ContractUploadfileV1DTO();
	// cUploadfile.setUploadFileType(fileType);
	// cUploadfile.setUrl("");
	// cuList.add(cUploadfile);
	// }
	// }
	// }
	// contractFileUploadV1Div.setStatus(status);
	// contractFileUploadV1Div.setListUploadFile(cuList);
	// contractFileUploadV1Div.initComponent();
	// }
	
	private String getClientIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
