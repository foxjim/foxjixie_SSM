package org.hnist.service;

import javax.servlet.http.HttpSession;

import org.hnist.model.Resource;
import org.springframework.ui.Model;


/**
 * 社团资源的Service层接口
 * @author Liuyun	2019/06/21
 *
 */
public interface ResourceService {

	/**
	 * 添加社团资源的方法
	 * @param resource
	 * @return
	 */
	public String insertResource(Resource resource);
	
	/**
	 * 通过序号删除社团资源
	 * @param resourceId
	 * @return
	 */
	public String deleteResourceById(Integer resourceId);
	
	/**
	 * 通过序号查找社团资源-编辑前夕准备
	 * @param resourceId
	 * @param model
	 * @param session
	 * @return
	 */
	public String findByResourceId(Integer resourceId,Model model,HttpSession session);
	
	/**
	 * 更新社团资源的方法
	 * @param resource
	 * @return
	 */
	public String updateResource(Resource resource);
	
	/**
	 * 查找所有的社团资源的方法
	 * @param model
	 * @param session
	 * @return
	 */
	public String findAllResource(Model model,HttpSession session);
	
	/**
	 * 前台显示所有的社团资源
	 * @param model
	 * @param session
	 * @return
	 */
	public String showAllResource(Model model,HttpSession session);
}
