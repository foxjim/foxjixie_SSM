package org.hnist.controller;

import javax.servlet.http.HttpSession;

import org.hnist.model.AdminUser;
import org.hnist.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 管理员的controller层
 * @author Liuyun 2019/06/14
 *
 */
@Controller
public class AdminController {

	@Autowired
	private AdminUserService adminUserService;
	
	/**
	 * 是否存在此电话号码
	 * @param telPhone
	 * @return
	 */
	@RequestMapping("/main/existByTelPhone")
	@ResponseBody
	public String findByTelPhone(@RequestParam("telPhone")String telPhone){
		return adminUserService.existTelPhone(telPhone);
	}
	
	/**
	 * 注册的方法
	 * @param adminUser
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/main/register")
	public String registerAdminUser(@ModelAttribute AdminUser adminUser,Model model,HttpSession session){
		return adminUserService.register(adminUser, model, session);
	}
	
	/**
	 * 	登录的方法
	 * @param adminPhoneNumber
	 * @param adminPassword
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/main/login")
	public String login(@RequestParam("adminPhoneNumber")String adminPhoneNumber,@RequestParam("adminPassword")String adminPassword,Model model ,HttpSession session){
		return adminUserService.login(adminPhoneNumber, adminPassword, model, session);
	}
	
	/**
	 *	 通过任届查找管理员
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/main/admin")
	public String findByGrades(Model model,HttpSession session) {
		AdminUser adminUser=(AdminUser)session.getAttribute("admin");
		if(adminUser==null) {
			return "redirect:/main/login.jsp";
		}else {
			String findString=adminUserService.findByGrades(adminUser.getAdminGrades(), model, session);
			if(findString.equals("error")) {
				model.addAttribute("message", "后台服务查找失败");
			}
			
			return "/main/AdminUserList";
		}
	}
	
	/**
	 * 找回密码-确定身份
	 * @param userName
	 * @param userTel
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/main/Answer")
	public String findAdminIdByAnswer(@RequestParam("userName")String userName,@RequestParam("userTel")String userTel,Model model,HttpSession session) {
		AdminUser adminUser=new AdminUser();
		adminUser.setAdminName(userName);
		adminUser.setAdminPhoneNumber(userTel);
		
		String faString=adminUserService.findIdByAnswer(adminUser, model, session);
		
		if(faString.equals("success")) {
			
			return "/main/resetAdminUser";
		}else {

			if (faString.equals("none")) {
				model.addAttribute("message", "账号信息不存在");
			} else {
				model.addAttribute("message", "账号信息不存在");

			}
			
			
			
			return "/main/resetlogin";
		}
		
		
	}
	
	/**
	 * 通过Id号更改密码
	 * @param userId
	 * @param userPassword
	 * @return
	 */
	@RequestMapping("/main/Password")
	public String updateAdminPassword(@RequestParam("userId")Integer userId,@RequestParam("userPassword")String userPassword,Model model ) {
		AdminUser adminUser=new AdminUser();
		adminUser.setAdminId(userId);
		adminUser.setAdminPassword(userPassword);
		
		String uaString=adminUserService.updatePwdById(adminUser);
		if(uaString.equals("0")) {
			model.addAttribute("message", "修改成功,您可以进行登录了");
			return "redirect:/main/login.jsp";
		}else {
			if(uaString.equals("1")) {
			model.addAttribute("message", "修改失败")	;
			}
			
			if(uaString.equals("error")) {
				model.addAttribute("message", "服务器错误")	;
			}
		}
		
		return "/main/resetAdminUser";
	}
}
