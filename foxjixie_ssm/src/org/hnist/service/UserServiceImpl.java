package org.hnist.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.hnist.mapper.CollegeMapper;
import org.hnist.mapper.UserMapper;
import org.hnist.model.College;
import org.hnist.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

/**
 * 普通会员的Service实现类
 * @author Liuyun
 *
 */
@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	public UserMapper userMapper;
	@Resource
	public CollegeMapper collegeMapper;

	// 普通账户登陆的login
	@Override
	public String login(User user, Model model, HttpSession session) {

		try {
			List<User> users = userMapper.login(user);
			if (users != null && users.size() > 0) {

				session.setAttribute("user", users.get(0));
				// System.out.println("登陆成功");
				return "/index";
			}
			model.addAttribute("msg", "账号或密码错误");
			// System.out.println("账号或密码错误");
			return "/login";
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("msg", "服务器请求出错,请稍后重试");
		return "/login";
	}

	// 注册账号的方法
	@Override
	public String register(User user, Model model, HttpSession session) {
		try {
			// 注册成功 切换到主页面
			if (userMapper.InsertUser(user)) {
				session.setAttribute("user", user);
				return "/index";
			} else {
				model.addAttribute("msg", "数据出错,请稍后重试");
				return "/register";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("msg", "服务器请求出错,请稍后重试");
		return "/register";
	}

	// 是否存在此学号
	@Override
	public String existByUserNo(String userNo) {
		try {
			// 当此账号不存在时 返回0 存在则返回1 否则返回error
			if (userMapper.findByUserNo(userNo).size() < 0) {
				return "0";
			} else {
				return "1";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "error";
	}

	// 是否存在此账号
	@Override
	public String existByUserCount(String userCount) {
		try {

			// 当此账号不存在时 返回0 存在则返回1 否则返回error
			if (userMapper.findByUserCount(userCount).size() < 0) {
				return "0";
			} else {
				return "1";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "error";
	}

	// 是否存在此电话号码
	@Override
	public String existByTelPhone(String telPhone) {
		try {
			// 当此账号不存在时 返回0 存在则返回1 否则返回error
			if (userMapper.findByTelPhone(telPhone).size() < 0) {
				return "0";
			} else {
				return "1";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "error";
	}

	// 是否存在此邮箱
	@Override
	public String existByEmail(String email) {
		try {
			// 当此账号不存在时 返回0 存在则返回1 否则返回error
			if (userMapper.findByEmail(email).size() < 0) {
				return "0";
			} else {
				return "1";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "error";
	}

	//查找所有的学院-ajax给注册添加下拉框
	@Override
	public String findAllCollege() {
		try{
			List<College> colleges=collegeMapper.findAllCollege();
			if(colleges.size()<=0){
				return "0";
			}else{
				JSONArray jsonArray = JSONArray.fromObject(colleges);
				return jsonArray.toString();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "error";
	}

}
