package org.hnist.controller;

import javax.servlet.http.HttpSession;

import org.hnist.model.User;
import org.hnist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 普通会员的controller层
 * @author Liuyun
 *
 */
@Controller
public class UserController {
	 @Autowired
	private UserService userService;
	 
	 /**
	  * 用户登录的方法
	  * @param user
	  * @param model
	  * @param session
	  * @return
	  */
	 @RequestMapping("/login")
	 public String login(@ModelAttribute User user,Model model,HttpSession session){
		 return userService.login(user, model, session);
	 }

	 /**
	  * 注册的方法
	  * @param user
	  * @param model
	  * @param session
	  * @return
	  */
	 @RequestMapping("/register")
	 public String register(@ModelAttribute User user,Model model,HttpSession session){
		 return userService.register(user, model, session);
	 }
	 
	 /**
	  * 通过学号查找-ajax
	  * @param userNo
	  * @return
	  */
	 @RequestMapping(value="/existByUserNo")
	 @ResponseBody
	 public String existByUserNo(@RequestParam("userNo")String userNo){
		 return userService.existByUserNo(userNo);
	 }
	 
	 /**
	  * 通过账号查找-ajax
	  * @param userCount
	  * @return
	  */
	 @RequestMapping(value="/existByUserCount",produces = "text/plain;charset=utf-8")
	 @ResponseBody
	 public String existByUserCount(@RequestParam("userCount")String userCount){
		 return userService.existByUserCount(userCount);
	 }
	 
	 /**
	  * 通过电话号码查找账号-ajax
	  * @param telPhone
	  * @return
	  */
	 @RequestMapping(value="/existByTelPhone",produces = "text/plain;charset=utf-8")
	 @ResponseBody
	 public String existByTelPhone(@RequestParam("telPhone")String telPhone){
		 return userService.existByTelPhone(telPhone);
	 }
	 
	 /**
	  * 通过邮箱查找账号-ajax
	  * @param email
	  * @return
	  */
	 @RequestMapping(value="/existByEmail",produces = "text/plain;charset=utf-8")
	 @ResponseBody
	 public String existByEmail(@RequestParam("email")String email){
		 return userService.existByEmail(email);
	 }
	 
	 /**
	  * 查找所有的学院-ajax(注册账号用)
	  * @return
	  */
	 @RequestMapping(value="/findAllCollege",produces = "text/plain;charset=utf-8")
	 @ResponseBody
	 public String findAllCollege(){
		 return userService.findAllCollege();
	 }
	 
}
