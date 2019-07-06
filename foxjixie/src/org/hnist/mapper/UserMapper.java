package org.hnist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hnist.model.User;
import org.springframework.stereotype.Repository;

/**
 * 普通账号(学生)的 mapper接口
 * @author Liuyun	2019.05.25
 *
 */
@Repository("userMapper")
@Mapper
public interface UserMapper {

	/**
	 * 通过UserCount和Userpasswrod查找账号
	 * @param user
	 * @return
	 */
	public List<User> login(User user);
	
	/**
	 * 查找最大的学生序号 - Max(userId)
	 * @return
	 */
	public Integer findMaxUserId();
	
	/**
	 * 插入数据的方法
	 * @param user
	 * @return
	 */
	public boolean InsertUser(User user);
	
	/**
	 * 通过学号查找
	 * @param userNo
	 * @return
	 */
	public List<User> findByUserNo(String userNo);
	
	/**
	 * 通过学生账号查找
	 * @param userCount
	 * @return
	 */
	public List<User> findByUserCount(String userCount);
	
	/**
	 * 通过电话号码查找
	 * @param telPhone
	 * @return
	 */
	public List<User> findByTelPhone(String telPhone);
	
	/**
	 * 通过邮箱查找账号
	 * @param email
	 * @return
	 */
	public List<User> findByEmail(String email);
	
	/**
	 * 通过年级查找学生总数
	 * @param userGrades
	 * @return
	 */
	public Integer findTotalNumberByGrade(@Param("userGrades")String userGrades);
	
	/**
	 * 通过年级号 进行分页查找数据
	 * @param userGrades
	 * @param start
	 * @param end
	 * @return
	 */
	public List<User> findAllByUserGrade(@Param("userGrades")String userGrades,@Param("start")Integer start,@Param("end")Integer end);
	
	/**
	 * 删除社团成员的方法
	 * @param userId
	 * @return
	 */
	public boolean deleteUser(@Param("userId")Integer userId);
	
	/**
	 * 通过序号查找成员
	 * @param userId
	 * @return
	 */
	public User findByUserId(@Param("userId")Integer userId);
	
	/**
	 * 更新社团成员的方法
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user);
	
	/**
	 * 找回密码之查询数据的方法 
	 * @param user
	 * @return
	 */
	public Integer findToEditUserPassword(User user);
	
	/**
	 * 更新成员密码的方法
	 * @param userId
	 * @param userPassword
	 * @return
	 */
	public boolean updateUserPwd(@Param("userId")Integer userId,@Param("userPassword")String userPassword);
	
	
	
	/**
	 * 	模糊查询
	 * @param querymessage
	 * @return
	 */
	public List<User> queryUser(@Param("querymessage")String querymessage);
	
	/**
	 * Excel导出User
	 * @return
	 */
	public List<User> findExportUser(@Param("userGrades")String userGrades);
	
	/**
	 * 	更改专业的方法
	 * @param userCollege
	 * @return
	 */
	public boolean updateCollegeByCollege(@Param("userCollege")String userCollege,@Param("collegeName")String collegeName);
}
