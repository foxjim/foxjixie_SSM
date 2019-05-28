package org.hnist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
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
	
}
