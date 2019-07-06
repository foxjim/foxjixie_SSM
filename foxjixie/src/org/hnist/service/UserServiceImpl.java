package org.hnist.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hnist.mapper.CollegeMapper;
import org.hnist.mapper.UserMapper;
import org.hnist.model.AdminUser;
import org.hnist.model.College;
import org.hnist.model.User;
import org.hnist.model.UserList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.sun.org.apache.bcel.internal.generic.NEW;

import javafx.scene.control.Cell;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * 普通会员的Service实现类
 * @author Liuyun
 *
 */
@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	@Resource
	private CollegeMapper collegeMapper;

	// 普通账户登陆的login
	@Override
	public String login(User user, Model model, HttpSession session) {

		try {
			List<User> users = userMapper.login(user);
			if (users != null && users.size() > 0) {

				session.setAttribute("user", users.get(0));
				
				return "redirect:/front/Index.do";
			}
			model.addAttribute("msg", "账号或密码错误");
			return "/login";
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("msg", "服务器请求出错,请稍后重试");
		return "/login";
	}
	
	//ajax登录的方法
	@Override
	public String userlogin(User user,HttpSession session) {
		try {
			
			List<User> users = userMapper.login(user);
			if (users != null && users.size() > 0) {

				session.setAttribute("user", users.get(0));
				
				return "0";
			}
			
			return "1";
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "error";
	}


	// 注册账号的方法
	@Override
	public String register(User user, Model model, HttpSession session) {
		try {
			Integer maxUserId=userMapper.findMaxUserId();
			
			if(maxUserId==null){
				maxUserId=0;
			}
			user.setUserId(maxUserId+1);	
			
			// 注册成功 切换到登录界面
			if (userMapper.InsertUser(user)) {
				model.addAttribute("msg", "注册成功,可以登录了");
				return "redirect:/login.jsp";
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
			//System.out.println("userNo:"+userNo);
			// 当此账号 不存在-- 返回0    存在返回--1 否则返回error
			if (userMapper.findByUserNo(userNo).size() <= 0) {
				return "0";
			} else {
				//System.out.println("size:"+userMapper.findByUserNo(userNo).size());
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
			if (userMapper.findByUserCount(userCount).size() <= 0) {
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
			if (userMapper.findByTelPhone(telPhone).size() <= 0) {
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
			if (userMapper.findByEmail(email).size() <= 0) {
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

	//添加用户的方法
	@Override
	public String InsertUser(User user) {
		try {
			
			Integer maxUserId=userMapper.findMaxUserId();
			
			if(maxUserId==null){
				maxUserId=0;
			}
			user.setUserId(maxUserId+1);	
			
			// 注册成功 切换到登录界面
			if (userMapper.InsertUser(user)) {

				return "0";
			} else {
				
				return "1";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "error";
	}

	//通过年级查找所有社团成员
	@Override
	public String findUserByUserGrades(Integer currentPage,String userGrades, Model model, HttpSession session) {
		try {
			//总数
			Integer totalNumber=userMapper.findTotalNumberByGrade(userGrades);
			//每页数目
			Integer eachPageNumber=5;
			
			UserList userList=new UserList(totalNumber, eachPageNumber, currentPage);
			
			//开始数据
			Integer start=( userList.getCurrentPage()-1)*eachPageNumber;
			//结束数据
			Integer end=userList.getCurrentPage()*eachPageNumber;
			
			model.addAttribute("userss", new UserList(totalNumber, eachPageNumber, currentPage, userMapper.findAllByUserGrade(userGrades,start, end)));
			return "0";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "error";
	}

	//删除数据的方法
	@Override
	public String deleteUser(Integer userId) {
		try {
			if(userMapper.deleteUser(userId)) {
				return "0";
			}else {
				return "1";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "error";
	}

	//通过序号查找社团成员
	@Override
	public String findUserById(Integer userId,Model model,HttpSession session) {
		try {
			model.addAttribute("user", userMapper.findByUserId(userId));
			return "0";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "error";
	}

	//更新用户的方法
	@Override
	public String updateUser(User user) {
		try {
			if(userMapper.updateUser(user)) {
				return "0";
			}else {
				return "1";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "error";
	}

	@Override
	public String insertUserByExcel(String path, String fileType) {
		try {
			
			File file=new File(path);
			if(!file.exists()) {
				System.out.println("error:"+path+fileType);
				return "save_error";
			}else {
				
				//序号
				Integer MaxuserId=userMapper.findMaxUserId();
				if(MaxuserId==null) {
					MaxuserId=0;
				}
				
				//导入失败的数据
				Integer errorNum=0;
				
				
				Workbook wb = null;
				
				if(fileType.equals(".xls")) {
					 FileInputStream fis = new FileInputStream(file);   //文件流对象
	                 wb = new HSSFWorkbook(fis);
				}else if(fileType.equals(".xlsx")) {
					 wb = new XSSFWorkbook(new FileInputStream(file));
				}
				
				//开始解析
				Sheet sheet=wb.getSheetAt(0);
				
				int firstRowIndex = sheet.getFirstRowNum()+1;   //第一行是列名，所以不读
                int lastRowIndex = sheet.getLastRowNum();
                
                for(int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行
                	
                	  User user=new User();
                	  Row row = sheet.getRow(rIndex);
                      if (row != null) {
                          int firstCellIndex = row.getFirstCellNum();
                          int lastCellIndex = row.getLastCellNum();
                          for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {   //遍历列
                              org.apache.poi.ss.usermodel.Cell cell = row.getCell(cIndex);
                              cell.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
                              switch(cIndex) {
                            	  case 0:
                            		  user.setUserNo(cell.toString());
                            		  break;
                            	  case 1:
                            		  user.setUserCount(cell.toString());
                            		  break;
                            	  case 2:
                            		  user.setUserName(cell.toString());
                            		  break;
                            	  case 3:
                            		  user.setUserPassword(cell.toString());
                            		  break;
                            	  case 4:
                            		  user.setUserCollege(cell.toString());
                            		  break;
                            	  case 5:
                            		  user.setUserGrades(cell.toString());
                            		  break;
                            	  case 6:
                            		  user.setTelPhone(cell.toString());
                            		  break;
                            	  case 7:
                            		  user.setEmail(cell.toString());
                            		  break;
                              }
                             
                          }
                      }
                      user.setUserId(MaxuserId+rIndex);
                	
                	
                      try {
						if(!userMapper.InsertUser(user)) {
							errorNum++;
						}
                      } catch (Exception e) {
						errorNum++;
						e.printStackTrace();
                      }
                	
                	
                	
                	
                }
						
						
						System.out.println(errorNum+":errorNum");
						
						return errorNum.toString();
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
			
				}
				
				
				
				
				
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "error";
	}

	//模糊查询
	@Override
	public String queryUser(String querymessage, Model model, HttpSession session) {
		try {
			List<User> users=userMapper.queryUser(querymessage);
			UserList userList=new UserList(users.size(), 100, 1, users);
			
			model.addAttribute("userss",userList);
			return "0";
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "error";
	}

	//批量导出为excel
	@Override
	public String exportUser(HttpServletRequest request,HttpSession session) throws Exception{
		WritableWorkbook wwb =null;
		try {
			AdminUser adminUser=(AdminUser)session.getAttribute("admin");
			String userGrades=adminUser.getAdminGrades();
			
			List<User> users=userMapper.findExportUser(userGrades);
			
		    String filePath = request.getSession().getServletContext().getRealPath("upload/exportExcel")+"/userexcel.xls"; 
			 
		    
		    
		  
            try {
            	File file=new File(filePath);
            	if(!file.exists() ) {
            		file.mkdir();
            	}
                wwb = jxl.Workbook.createWorkbook(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
          //创建Excel表的"学生"区域的数据
            WritableSheet sheet = wwb.createSheet("计协会员信息表",0);//或者rwb.getSheet(0)获取第一个区域
            
            
            sheet.addCell(new Label(0,0,"学号"));
            sheet.addCell(new Label(1,0,"姓名"));
            sheet.addCell(new Label(2,0,"专业"));
            
            sheet.addCell(new Label(3,0,"班级"));
            
            sheet.addCell(new Label(4,0,"电话"));
            sheet.addCell(new Label(5,0,"QQ号"));
            
            for(int i = 0; i<users.size(); i++){
            	//Number对应数据库的int类型数据
            	sheet.addCell(new Label(0,i+1,users.get(i).getUserNo()));
            	sheet.addCell(new Label(1,i+1,users.get(i).getUserName()));
            	sheet.addCell(new Label(2,i+1,users.get(i).getUserCollege()));
            	
            	sheet.addCell(new Label(3,i+1,users.get(i).getEmail()));
            	
            	sheet.addCell(new Label(4,i+1,users.get(i).getTelPhone()));
            	sheet.addCell(new Label(5,i+1,users.get(i).getUserCount()));
            }
            wwb.write();
			
            return "../upload/exportExcel/userexcel.xls";
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			wwb.close();
		}
		
		return "error";
	}

	//更改密码之查询是否存在此用户
	@Override
	public String ensureEditPasswordAnswer(User user, Model model, HttpSession session) {
		try {
			return String.valueOf(userMapper.findToEditUserPassword(user));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	//更改密码的方法
	@Override
	public String updateUserPassword(User user, Model model, HttpSession session) {
		try {
			
			if(userMapper.updateUserPwd(user.getUserId(), user.getUserPassword())) {
				System.out.println(user.getUserId()+"0");
				return "0";
			}else {
				System.out.println(user.getUserId()+"0");
				return "1";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "error";
	}

	
	
}
