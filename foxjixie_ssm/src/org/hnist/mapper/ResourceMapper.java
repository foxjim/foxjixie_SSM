package org.hnist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hnist.model.Resource;
import org.springframework.stereotype.Repository;

/**
 * 社团资源的Mapper层接口
 * @author Liuyun
 *
 */
@Repository("ResourceMapper")
@Mapper
public interface ResourceMapper {
	
	/**
	 * 查找最大的序号
	 * @return
	 */
	public Integer findMaxResourceId();
	
	/**
	 * 添加社团资源的方法
	 * @param resource
	 * @return
	 */
	public boolean insertResource(Resource resource);
	
	/**
	 * 根据序号删除社团资源的方法
	 * @param resourceId
	 * @return
	 */
	public boolean deleteByResourceId(@Param("resourceId")Integer resourceId);

	/**
	 * 通过序号查找资源
	 * @param resourceId
	 * @return
	 */
	public Resource findByResourceId(Integer resourceId);
	
	/**
	 * 更新社团资源的方法
	 * @param resource
	 * @return
	 */
	public boolean updateResource(Resource resource);
	
	/**
	 * 查找所有的资源类型
	 * @return
	 */
	public List<String> findAllResourceClass();
	
	/**
	 * 根据资源类型查找所有的资源
	 * @param resourceClass
	 * @return
	 */
	public List<Resource> findByResourceClass(@Param("resourceClass")String resourceClass);
}
