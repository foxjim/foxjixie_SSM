package org.hnist.service;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
	 * ajax登录的方法
	 * @param user
	 * @return
	 */
	public String userlogin(User user,HttpSession session);
	
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
	
	/**
	 * 查找所有的学院-ajax给注册添加下拉框
	 * @return
	 */
	public String findAllCollege();
	
	/**
	 * 添加用户的方法
	 * @param user
	 * @return
	 */
	public String InsertUser(User user);
	
	/**
	 * 通过年级查找所有社团成员
	 * @param userGrades
	 * @param model
	 * @param session
	 * @return
	 */
	public String findUserByUserGrades(Integer currentPage,String userGrades,Model model,HttpSession session);
	
	/**
	 * 删除数据的方法
	 * @param userId
	 * @return
	 */
	public String deleteUser(Integer userId);
	
	/**
	 * 通过序号查找社团成员
	 * @param userId
	 * @return
	 */
	public String findUserById(Integer userId,Model model,HttpSession session);
	
	/**
	 * 更新用户的方法
	 * @param user
	 * @return
	 */
	public String updateUser(User user);
	
	/**
	 * 	通过excel导入文件
	 * @param path	//文件路径
	 * @param fileType	//文件名
	 * @return
	 */
	public String insertUserByExcel(String path,String fileType);
	
	/**
	 * 	模糊查询
	 * @param querymessage
	 * @param model
	 * @param session
	 * @return
	 */
	public String queryUser(String querymessage,Model model,HttpSession session);
	
	/**
	 * 	批量导出excel
	 * @param request
	 * @return
	 */
	public String exportUser(HttpServletRequest request,HttpSession session)throws Exception;
	
	/**
	 * 更改密码之查询是否存在此用户
	 * @param user
	 * @param model
	 * @param session
	 * @return
	 */
	public String ensureEditPasswordAnswer(User user,Model model,HttpSession session);
	
	/**
	 * 更改密码的方法
	 * @param user
	 * @param model
	 * @param session
	 * @return
	 */
	public String updateUserPassword(User user,Model model,HttpSession session);
}
