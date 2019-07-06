package org.hnist.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.hnist.mapper.AdminUserMapper;
import org.hnist.model.AdminUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;


/**
 * 管理员的Service层实现类
 * @author Liuyun 2019/06/14
 *
 */
@Service("AdminUserService")
@Transactional
public class AdminUserServiceImpl implements AdminUserService{

	@Resource
	private AdminUserMapper adminUserMapper;

	
	//通过电话号码查找账号
	@Override
	public String existTelPhone(String telPhone) {
		try{
			if(adminUserMapper.findByAdminPhoneNumber(telPhone).size()<=0){ //不存在此电话号码
				return "0";
			}else{
				return "1";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "error";
	}

	//注册
	@Override
	public String register(AdminUser adminuser, Model model, HttpSession session) {
		try{
			//管理员Id
			Integer adminUserId=adminUserMapper.findMaxAdminUser();
			if(adminUserId==null || "".equals(adminUserId)){
				adminUserId=0;
			}
			
			adminuser.setAdminId(adminUserId+1);
			//注册成功
			if(adminUserMapper.insertAdminUser(adminuser)){
				model.addAttribute("message", "注册成功！您可以登陆了");
				return "redirect:/main/login.jsp";
			}else{
				model.addAttribute("message", "注册失败，请检查相关信息正确性");
				model.addAttribute("adminUser", adminuser);
				return "/main/regist.jsp";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("message", "注册失败,程序错误");
		return "/main/regist.jsp";
	}

	//登录的方法
	@Override
	public String login(String adminPhoneNumber, String adminPassword,
			Model model, HttpSession session) {
		try{
			//根据电话号码和密码查找账号
			AdminUser adminUser=adminUserMapper.login(adminPhoneNumber, adminPassword);
			if(adminUser!=null){
				session.setAttribute("admin", adminUser);
				session.setAttribute("grades", adminUser.getAdminGrades());
				return "redirect:/main/index.jsp";
			}else{
				session.setAttribute("message", "电话号码或密码错误");
				return "/main/login";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		session.setAttribute("message", "程序错误！请稍后重试");
		return "/main/login";
	}

	// 通过任届查找管理员
	@Override
	public String findByGrades(String adminGrades, Model model, HttpSession session) {
		try {
			
			model.addAttribute("adminUsers", adminUserMapper.findByAdminGrades(adminGrades));
			return "0";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	//修改密码之查找对应ID
	@Override
	public String findIdByAnswer(AdminUser adminUser, Model model, HttpSession session) {
		try {
			Integer adminId=adminUserMapper.findIdByAnswer(adminUser);
			
			if(adminId==null) {
				return "none";
			}else {
				model.addAttribute("userId", adminId);
				return "success";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "error";
	}

	//通过Id值修改密码
	@Override
	public String updatePwdById(AdminUser adminUser) {
		try {
			if(adminUserMapper.updateUserPwd(adminUser)) {
				return "0";
			}else {
				return "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "error";
	}
	
	
	
}
