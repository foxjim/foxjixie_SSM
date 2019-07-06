package org.hnist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hnist.model.College;
import org.springframework.stereotype.Repository;

/**
 * 学院信息的mapper接口
 * @author Liuyun	2019/05/26
 *
 */
@Repository("collegeMapper")
@Mapper
public interface CollegeMapper {

	/**
	 * 查找最大的学院序号
	 * @return
	 */
	public Integer findMaxCollegeId();
	
	/**
	 * 添加学院的方法
	 * @param college
	 * @return
	 */
	public boolean InsertCollege(College college);
	
	/**
	 * 更新学院数据的方法
	 * @param college
	 * @return
	 */
	public boolean updateCollege(College college);
	
	/**
	 * 删除学院的方法
	 * @param collegeId
	 * @return
	 */
	public boolean deleteCollege(Integer collegeId);
	
	/**
	 * 查找所有的学院
	 * @return
	 */
	public List<College> findAllCollege();
	
	/**
	 * 通过Id查找学院
	 * @param collegeId
	 * @return
	 */
	public College findById(@Param("collegeId")Integer collegeId);
	
	/**
	 * 	通过序号查找名字
	 * @param collegeId
	 * @return
	 */
	public String findNameById(@Param("collegeId")Integer collegeId);
}
