package org.hnist.model;
/**
 * 社团资源的实体类 -download
 * @author Liuyun 2019/06/21
 *
 */
public class Resource {
	private Integer resourceId;						//资源序号
	private String  resourceClass;					//资源类型
	private String  resourceName;					//资源名称
	private String  resourceLink;					//百度网盘链接
	private String  resourcePassword;				//链接密码
	
	
	public Integer getResourceId() {
		return resourceId;
	}
	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}
	public String getResourceClass() {
		return resourceClass;
	}
	public void setResourceClass(String resourceClass) {
		this.resourceClass = resourceClass;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getResourceLink() {
		return resourceLink;
	}
	public void setResourceLink(String resourceLink) {
		this.resourceLink = resourceLink;
	}
	public String getResourcePassword() {
		return resourcePassword;
	}
	public void setResourcePassword(String resourcePassword) {
		this.resourcePassword = resourcePassword;
	}
	
	
}
