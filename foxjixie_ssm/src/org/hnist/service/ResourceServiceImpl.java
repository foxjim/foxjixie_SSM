package org.hnist.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.hnist.mapper.ResourceMapper;
import org.hnist.model.ResourceList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.sun.deploy.uitoolkit.impl.fx.ui.resources.ResourceManager;

/**
 * 社团资源的Service层实现类
 * @author Liuyun 2019/06/21
 *
 */
@Service("resourceService")
@Transactional
public class ResourceServiceImpl implements ResourceService{
	
	@Resource
	private ResourceMapper resourceMapper;

	//添加社团资源的方法
	@Override
	public String insertResource(org.hnist.model.Resource resource) {
		try {
			Integer resourceId=resourceMapper.findMaxResourceId();
			if(resourceId==null) {
				resourceId=0;
			}
			resource.setResourceId(resourceId+1);
			
			if(resourceMapper.insertResource(resource)) {
				return "0";
			}else {
				return "1";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	//通过序号删除社团资源
	@Override
	public String deleteResourceById(Integer resourceId) {
		try {
			if(resourceMapper.deleteByResourceId(resourceId)) {
				return "0";
			}else {
				return "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "error";
	}

	//通过序号查找社团资源-编辑前夕准备
	@Override
	public String findByResourceId(Integer resourceId, Model model, HttpSession session) {
		try {
			model.addAttribute("societyContent", resourceMapper.findByResourceId(resourceId));
			return "/main/editSocietyContent";
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("message", "数据库读取失败");
		return "/main/editSocietyContent";
	}

	//更新社团资源的方法
	@Override
	public String updateResource(org.hnist.model.Resource resource) {
		try {
			if(resourceMapper.updateResource(resource)) {
				return "0";
			}else {
				return "1";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "error";
	}

	//查找所有的社团资源的方法
	@Override
	public String findAllResource(Model model, HttpSession session) {
		try {
			List<ResourceList> resourceLists=new ArrayList<ResourceList>();
			
			//所有的资源类型
			List<String> resourceClasss=resourceMapper.findAllResourceClass();
			ResourceList resourceList;
			for(int i=0;i<resourceClasss.size();i++) {
				resourceList=new ResourceList();
				resourceList.setResourceClass(resourceClasss.get(i));
				resourceList.setResources(resourceMapper.findByResourceClass(resourceClasss.get(i)));
				
				resourceLists.add(resourceList);
			}
			
			model.addAttribute("sclists", resourceLists);
			return "/main/SocietyContentList";
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("message", "后台获取失败");
		return "/main/SocietyContentList";
	}

	//前台显示所有的社团资源
	@Override
	public String showAllResource(Model model, HttpSession session) {
		try {
			List<ResourceList> resourceLists=new ArrayList<ResourceList>();
			
			//所有的资源类型
			List<String> resourceClasss=resourceMapper.findAllResourceClass();
			ResourceList resourceList;
			for(int i=0;i<resourceClasss.size();i++) {
				resourceList=new ResourceList();
				resourceList.setResourceClass(resourceClasss.get(i));
				resourceList.setResources(resourceMapper.findByResourceClass(resourceClasss.get(i)));
				
				resourceLists.add(resourceList);
			}
			
			model.addAttribute("sclists", resourceLists);
			return "/front/content";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/front/content";
	}
}
