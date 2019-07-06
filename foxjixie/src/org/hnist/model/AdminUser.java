package org.hnist.model;
/**
 * 管理员的实体
 * @author Liuyun 2019/05/31
 *
 */
public class AdminUser {
	
	private Integer adminId;			//序号
	private String adminName;			//姓名
	private String adminPassword;		//密码
	private String adminDepartment;		//部门
	private String adminPosition;		//职位
	
	private String adminGrades;			//任届
	private String adminPhoneNumber;	//电话号码
	
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdminDepartment() {
		return adminDepartment;
	}
	public void setAdminDepartment(String adminDepartment) {
		this.adminDepartment = adminDepartment;
	}
	public String getAdminPosition() {
		return adminPosition;
	}
	public void setAdminPosition(String adminPosition) {
		this.adminPosition = adminPosition;
	}
	public String getAdminGrades() {
		return adminGrades;
	}
	public void setAdminGrades(String adminGrades) {
		this.adminGrades = adminGrades;
	}
	public String getAdminPhoneNumber() {
		return adminPhoneNumber;
	}
	public void setAdminPhoneNumber(String adminPhoneNumber) {
		this.adminPhoneNumber = adminPhoneNumber;
	}
	
	
	
	

}
