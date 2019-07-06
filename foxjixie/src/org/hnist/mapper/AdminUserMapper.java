package org.hnist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hnist.model.AdminUser;
import org.springframework.stereotype.Repository;

/**
 * adminuser类mapper接口
 * @author Liuyun 2019/06/14
 *
 */
@Repository("adminUserMapper")
@Mapper
public interface AdminUserMapper {
	
	/**
	 * 查找最大的序号
	 * @return
	 */
	public Integer findMaxAdminUser();
	
	/**
	 * 登录的方法
	 * @param loginCount
	 * @param adminPassword
	 * @return
	 */
	public AdminUser login(@Param("adminPhoneNumber")String adminPhoneNumber,@Param("adminPassword")String adminPassword);
	
	/**
	 * 导入数据的方法
	 * @param adminUser
	 * @return
	 */
	public boolean insertAdminUser(AdminUser adminUser);
	
	/**
	 * 删除数据的方法
	 * @param adminId
	 * @return
	 */
	public boolean deleteAdminUser(Integer adminId);
	
	/**
	 * 更新数据的方法
	 * @param adminUser
	 * @return
	 */
	public boolean updateAdminUser(AdminUser adminUser);
	
	/**
	 * 查找所有的管理员
	 * @return
	 */
	public List<AdminUser> findAllAdminUser();
	
	/**
	 * 通过任届查找
	 * @param adminGrades
	 * @return
	 */
	public List<AdminUser> findByAdminGrades(String adminGrades);
	
	/**
	 * 通过管理员的电话号码查找
	 * @return
	 */
	public List<AdminUser> findByAdminPhoneNumber(String adminPhoneNumber);
	
	/**
	 * 更改密码之查询用户
	 * @param adminUser
	 * @return
	 * 		用户的Id
	 * 
	 */
	public Integer findIdByAnswer(AdminUser adminUser);
	
	/**
	 * 通过id修改密码
	 * @param adminUser
	 * @return
	 */
	public boolean updateUserPwd(AdminUser adminUser);
}
