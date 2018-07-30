package com.jyd.bms.tool.zk;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zkplus.spring.SpringUtil;

import com.jyd.bms.bean.GroupUser;
import com.jyd.bms.bean.Menu;
import com.jyd.bms.bean.PageUseLog;
import com.jyd.bms.bean.User;
import com.jyd.bms.common.Environment;
import com.jyd.bms.service.GroupMenuService;
import com.jyd.bms.service.GroupUserService;
import com.jyd.bms.service.PageUseLogService;
import com.jyd.bms.service.UserService;
import com.jyd.bms.tool.exception.DAOException;

public abstract class BaseWindow extends GenericForwardWindow {
	private double randomKey = Math.random();
	private PageUseLogService pageUseLogService = getBean("PageUseLogService");
	public String menuId = "";

	// 提供基本增、删、改、刷新、合并
	private Session session = Sessions.getCurrent();

	public void onCreate() {
		// 下面处理测试环境下，用户Session
		if (session.getAttribute("User") == null) {
			String loginName = Environment.getDefaultLoginName();
			if (loginName == null || loginName.equals("")) {
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
			boolean flag = false;
			List<GroupUser> groupList = groupUserService.getGroupUserByUser(user);
			for (GroupUser groupUser : groupList) {
				// 判断用户所在组是否具有菜单的权限
				if (groupMenuService.findGroupMenu(groupUser.getGroup(), menu) != null) {
					flag = true;
				}
			}
			if (flag || menuId.equals("index")) {
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