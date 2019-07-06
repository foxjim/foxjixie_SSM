package org.hnist.controller;

import java.io.File;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hnist.model.AdminUser;
import org.hnist.model.User;
import org.hnist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



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
	  * ajax登录的方法
	  * @param userCount
	  * @param userPassword
	  * @param session
	  * @return
	  */
	 @RequestMapping("/front/login")
	 @ResponseBody
	 public String alogin(@RequestParam("userCount")String userCount,@RequestParam("userPassword")String userPassword,HttpSession session) {
		 User user=new User(userCount, userPassword);
		 return userService.userlogin(user, session);
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
	  * 导入学生的方法
	  * @param userNo			学号
	  * @param userCount		qq号（原来是账号）
	  * @param userName			姓名
	  * @param userPassword		密码
	  * @param userCollege		专业（原来是学院）
	  * @param telPhone			电话号码
	  * @param email			班级（原来是邮箱）
	  * @param session
	  * @return
	  */
	 @RequestMapping("/main/InsertUser")
	 @ResponseBody
	 public String InsertUser(@RequestParam("userNo")String userNo,
			 			 	  @RequestParam("userCount")String userCount,
			 			 	  @RequestParam("userName")String userName,
			 			 	  @RequestParam("userPassword")String userPassword,
			 			 	  @RequestParam("userCollege")String userCollege,
			 			 	  @RequestParam("telPhone")String telPhone,
			 			 	  @RequestParam("email")String email,HttpSession session) {
		 
		 AdminUser adminUser=(AdminUser)session.getAttribute("admin");
		 if(adminUser==null) {
			 return "rt";
		 }else {
			 
			 User user=new User(userNo,userCount,userName,userPassword,userCollege,adminUser.getAdminGrades(),telPhone,email);
			 
			 return userService.InsertUser(user);
			 
		 }
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
	  * 通过账号查找-ajax-现在是qq号
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
	  * 通过邮箱查找账号-ajax-现在是班级
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
	 
	 /**
	  * 管理员列表显示所有的用户
	  * @param userGrades
	  * @param model
	  * @param session
	  * @return
	  */
	 @RequestMapping("/main/findAllUser")
	 public String findByUserGrades(@RequestParam(value="currentPage",required = false)Integer currentPage,Model model,HttpSession session) {
		 AdminUser adminUser=(AdminUser)session.getAttribute("admin");
		 if(adminUser==null) {
			 return "/main/login";
		 }else {
			 
			 if(currentPage==null) {
				 currentPage=1;
			 }
			 
			 
			 String usermessageString=userService.findUserByUserGrades(currentPage, adminUser.getAdminGrades(), model, session);
			 
			 if(usermessageString.equals("0")) {
				 return "forward:/main/userList.jsp";
			 }else {
				 model.addAttribute("message", "后台服务请求失败");
				 return "forward:/main/userList.jsp";
			 }
			 
			 
			
		 }
		
	 }
	 
	 /**
	  * 	通过Id删除序号
	  * @param userId
	  * @return
	  */
	 @RequestMapping("/main/deleteUser")
	 @ResponseBody
	 public String deleteUser(@RequestParam("userId")Integer userId) {
		 return userService.deleteUser(userId);
	 }
	 
	 /**
	  * 	确保密保问题
	  * @return
	  */

	@RequestMapping("/UserQuestion")
	 public String ensureEditPasswordAnswer(@ModelAttribute User user,Model model,HttpSession session) {
		 
		 String enInteger=userService.ensureEditPasswordAnswer(user, model, session);
		 if(enInteger==null) {
			 model.addAttribute("message", "账号不存在，请检查输入信息");
			 return "forgetPassword";
		 }else if(enInteger.equals("error")){
			 model.addAttribute("message", "后台服务连接失败");
			 return "forgetPassword";
		 }else {
			 model.addAttribute("userId", enInteger);
			 return "rePasword";
		 }
		
	 }
	 
	 /**
	  * 	更改用户密码的方法
	  * @return
	  */
	 @RequestMapping("/Password")
	 @ResponseBody
	 public String editUserPassword(@RequestParam("userId")Integer userId,
			 						@RequestParam("userPassword")String userPassword,Model model,HttpSession session) {
		 User user=new User();
		 
		 user.setUserId(userId);
		 user.setUserPassword(userPassword);
		 
		 
		 return userService.updateUserPassword(user, model, session);
		
		
		
	 }
	 
	 /**
	  * 	编辑社团成员的方法-显示社团成员的方法
	  * @param userId
	  * @param model
	  * @param session
	  * @return
	  */
	 @RequestMapping("/main/editUser")
	 public String findnByUserId(@RequestParam("userId")Integer userId,Model model,HttpSession session) {
		 String userString=userService.findUserById(userId, model, session);
		 if(userString.equals("0")) {
			 
			 return "/main/editUser";
		 }else {
			 model.addAttribute("message", "查询失败");
			 return "/main/editUser";
		 }
		 
		 
	 }
	 
	 /**
	  * 	更新社团成员的方法
	  * @return
	  */
	 @RequestMapping("/main/editorUser")
	 @ResponseBody
	 public String updateUser(@RequestParam("userId")Integer userId,
			 				  @RequestParam("userNo")String userNo,
			 				  @RequestParam("userCount")String userCount,
			 				  @RequestParam("userName")String userName,
			 				  @RequestParam("userCollege")String userCollege,
			 				  @RequestParam("telPhone")String telPhone,
			 				  @RequestParam("email")String email) {
		 
		 User user=new User(userId, userNo, userCount, userName, userCollege, telPhone, email); 
		 return userService.updateUser(user);
	 }
	 
	 /**
	  * 	excel文件上传的方法
	  * @return
	  */
	 @RequestMapping(value = "/main/uploadExcel",method=RequestMethod.POST)
	 @ResponseBody
	 public String uploadUserExcel(@RequestParam("file") MultipartFile file,@RequestParam("fileType")String fileType,HttpServletRequest request)throws Exception {
		 
		 if(fileType.equals(".xlsx") || fileType.equals(".xls")) {
			 String path = request.getSession().getServletContext().getRealPath("upload/excel"); 
			 
			 //获取当前时间
			 Date date=new Date();
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmm");
			 String currentTimeString=formatter.format(date);
			 
			 String fileName =currentTimeString+file.getOriginalFilename();
			 
		     File dir = new File(path,fileName);          
		     if(!dir.exists()){  
		           dir.mkdirs();  
		      }  
		       
		     file.transferTo(dir); 
//		     System.out.println(fileType);
//		     System.out.println(path);
		     
		     
		     return userService.insertUserByExcel(path+File.separator+fileName, fileType);
		 }else {
			 return "notfound";
		 }
		  
		 
		 
		 
	 }
	 
	 
	 /**
	  * 	通过关键字信息查找
	  * @param queryMessage
	  * @param model
	  * @param session
	  * @return
	  */
	 @RequestMapping("/main/queryUser")
	 public String findByQueryMessage(@RequestParam("queryMessage")String queryMessage,Model model,HttpSession session) {
		 String qString=userService.queryUser(queryMessage, model, session);
		 if(qString.equals("error")) {
			 model.addAttribute("message", "服务查询失败");
		 }
		 return "forward:/main/userList.jsp";
	 }
	 
	 /**
	  * 	批量导出为excel
	  * @param session
	  * @param request
	  * @param workbook
	  * @param out
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("/main/exportExcel")
	 @ResponseBody
	 public String exprotExcel(HttpServletRequest request,HttpSession session) throws Exception {
		 AdminUser adminUser=(AdminUser)session.getAttribute("admin");
		 
		 return userService.exportUser(request,session);
	 }
	 
	 
}
