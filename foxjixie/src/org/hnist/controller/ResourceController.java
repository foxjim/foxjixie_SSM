package org.hnist.controller;

import javax.servlet.http.HttpSession;

import org.hnist.model.Resource;
import org.hnist.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 社团资源的controller层
 * @author Liuyun 2019/06/21
 *
 */
@Controller
public class ResourceController {

	@Autowired
	private ResourceService resourceService;
	
	/**
	 * 添加社团资源的方法
	 * @param resourceClass
	 * @param resourceName
	 * @param resourceLink
	 * @param resourcePassword
	 * @return
	 */
	@RequestMapping(value="/main/InsertResource")
	@ResponseBody
	public String InsertResource(@RequestParam("resourceClass")String resourceClass,
								 @RequestParam("resourceName")String resourceName,
								 @RequestParam("resourceLink")String resourceLink,
								 @RequestParam(value = "resourcePassword",required = false)String resourcePassword) {
		
		Resource resource=new Resource();
		resource.setResourceClass(resourceClass);
		resource.setResourceLink(resourceLink);
		resource.setResourceName(resourceName);
		resource.setResourcePassword(resourcePassword);
		
		return resourceService.insertResource(resource);
	}
	
	/**
	 * 通过序号删除社团资源
	 * @param resourceId
	 * @return
	 */
	@RequestMapping(value="/main/deleteResource")
	@ResponseBody
	public String deleteResourceByresourceId(@RequestParam("resourceId")Integer resourceId) {
		return resourceService.deleteResourceById(resourceId);
	}
	
	/**
	 * 通过序号查找社团资源-编辑前夕准备
	 * @param resourceId
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/main/editResource")
	public String findByResourceId(@RequestParam("resourceId")Integer resourceId,Model model,HttpSession session) {
		return resourceService.findByResourceId(resourceId, model, session);
	}
	
	/**
	 * 更新社团资源的方法
	 * @param resourceId
	 * @param resourceClass
	 * @param resourceName
	 * @param resourceLink
	 * @param resourcePassword
	 * @return
	 */
	@RequestMapping("/main/updateResource")
	@ResponseBody
	public String updateResource(@RequestParam("resourceId")Integer resourceId,
								 @RequestParam("resourceClass")String resourceClass,
			 					 @RequestParam("resourceName")String resourceName,
			 					 @RequestParam("resourceLink")String resourceLink,
			 					 @RequestParam(value = "resourcePassword",required = false)String resourcePassword) {
		
		Resource resource=new Resource();
		resource.setResourceId(resourceId);
		resource.setResourceClass(resourceClass);
		resource.setResourceLink(resourceLink);
		resource.setResourceName(resourceName);
		resource.setResourcePassword(resourcePassword);
		
		return resourceService.updateResource(resource);
	}
	
	/**
	 * 查找所有的社团资源
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/main/findAllResource")
	public String findAllResource(Model model,HttpSession session) {
		return resourceService.findAllResource(model, session);
	}
	
	/**
	 * 前台显示所有的社团资源
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/front/Download")
	public String showAllResource(Model model,HttpSession session) {
		return resourceService.showAllResource(model, session);
	}
	
}
