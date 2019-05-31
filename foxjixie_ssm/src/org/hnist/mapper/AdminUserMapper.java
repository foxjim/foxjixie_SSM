package org.hnist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.hnist.model.AdminUser;
import org.springframework.stereotype.Repository;

@Repository("adminUserMapper")
@Mapper
public interface AdminUserMapper {
	
	/**
	 * 查找最大的序号
	 * @return
	 */
	public Integer findMaxAdminUser();
	
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
	
}
