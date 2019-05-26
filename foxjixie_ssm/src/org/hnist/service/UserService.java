package org.hnist.service;

import javax.servlet.http.HttpSession;

import org.hnist.model.User;
import org.springframework.ui.Model;

/**
 * 普通会员的Service接口
 * @author Liuyun	2019.05.25
 *
 */
public interface UserService {
	
	/**
	 * 	普通账户登陆的login
	 * @param user
	 * @param model
	 * @param session
	 * @return
	 */
	public String login(User user,Model model,HttpSession session);
	
	/**
	 * 	注册账号的方法
	 * @param user
	 * @param model
	 * @param session
	 * @return
	 */
	public String register(User user,Model model,HttpSession session);
	
	/**
	 * 是否存在此学号
	 * @param userNo
	 * @return
	 */
	public String existByUserNo(String userNo);
	 
	/**
	 * 是否存在此账号
	 * @param userCount
	 * @return
	 */
	public String existByUserCount(String userCount);

	/**
	 * 是否存在此电话号码
	 * @param telPhone
	 * @return
	 */
	public String existByTelPhone(String telPhone);
	
	/**
	 * 是否存在此邮箱
	 * @param email
	 * @return
	 */
	public String existByEmail(String email);
}
