package org.hnist.model;

import java.util.List;
/**
 * 社团资源list
 * @author Liuyun
 *
 */
public class ResourceList {
	private String resourceClass;		//资源类型
	private List<Resource> resources;	//资源
	
	public String getResourceClass() {
		return resourceClass;
	}
	public void setResourceClass(String resourceClass) {
		this.resourceClass = resourceClass;
	}
	public List<Resource> getResources() {
		return resources;
	}
	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
	
	
}
