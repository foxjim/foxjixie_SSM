package org.hnist.service;

import javax.servlet.http.HttpSession;

import org.hnist.model.AdminUser;
import org.springframework.ui.Model;

/**
 * 管理员的Service层接口
 * @author Liuyun
 *
 */
public interface AdminUserService {

	/**
	 * 通过电话号码查找账号 2019/06/14
	 * @param telPhone 
	 * @return
	 */
	public String existTelPhone(String telPhone);
	
	/** 
	 * 注册的方法 2019/06/14
	 * @param adminuser
	 * @param model
	 * @param session
	 * @return
	 */
	public String register(AdminUser adminuser,Model model,HttpSession session);
	
	/**
	 * 登录的方法
	 * @param adminPhoneNumber 电话号码
	 * @param adminPassword	密码
	 * @param model
	 * @param session
	 * @return
	 */
	public String login(String adminPhoneNumber,String adminPassword,Model model,HttpSession session);
	
	/**
	 *	 通过任届查找管理员
	 * @param adminGrades
	 * @param model		adminUsers
	 * @param session
	 * @return
	 */
	public String findByGrades(String adminGrades,Model model,HttpSession session);
	
	/**
	 * 修改密码之查找对应ID
	 * @param adminUser
	 * @param model
	 * @param session
	 * @return
	 */
	public String findIdByAnswer(AdminUser adminUser,Model model,HttpSession session);
	
	/**
	 * 通过Id值修改密码
	 * @param adminUser
	 * @return
	 */
	public String updatePwdById(AdminUser adminUser);
}
