package org.hnist.model;
/**
 * 普通用户的实体类
 * @author Liuyun 2019.05.24
 *
 */
public class User {
	
	private Integer userId;			//序号
	private String userNo;			//学号
	private String userCount;		//QQ号
	private String userName;		//姓名
	private String userPassword;	//密码
	
	private String userCollege;		//学院-专业
	private String userGrades;		//年级
	private String telPhone;		//电话号码
	private String email;			//邮箱----------改为班级
	private String stutas;			//账号状态 0:未审核  1:审核通过
	

	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}




	public User(String userNo, String userCount, String userName, String userPassword, String userCollege,
			String userGrades, String telPhone, String email) {
		super();
		this.userNo = userNo;
		this.userCount = userCount;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userCollege = userCollege;
		this.userGrades = userGrades;
		this.telPhone = telPhone;
		this.email = email;
	}

	public User(String userCount, String userPassword) {
		super();
		this.userCount = userCount;
		this.userPassword = userPassword;
	}
	
	
	/**
	 * 	编辑社团成员信息的方法
	 * @param userId
	 * @param userNo
	 * @param userCount
	 * @param userName
	 * @param userCollege
	 * @param userGrades
	 * @param telPhone
	 * @param email
	 */
	public User(Integer userId, String userNo, String userCount, String userName, String userCollege,
			String telPhone, String email) {
		super();
		this.userId = userId;
		this.userNo = userNo;
		this.userCount = userCount;
		this.userName = userName;
		this.userCollege = userCollege;
		this.telPhone = telPhone;
		this.email = email;
	}




	@Override
	public String toString() {
		return "User [userId=" + userId + ", userNo=" + userNo + ", userCount=" + userCount + ", userName=" + userName
				+ ", userPassword=" + userPassword + ", userCollege=" + userCollege + ", userGrades=" + userGrades
				+ ", telPhone=" + telPhone + ", email=" + email + ", stutas=" + stutas + "]";
	}




	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getUserCount() {
		return userCount;
	}
	public void setUserCount(String userCount) {
		this.userCount = userCount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserCollege() {
		return userCollege;
	}
	public void setUserCollege(String userCollege) {
		this.userCollege = userCollege;
	}
	public String getUserGrades() {
		return userGrades;
	}
	public void setUserGrades(String userGrades) {
		this.userGrades = userGrades;
	}
	public String getTelPhone() {
		return telPhone;
	}
	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStutas() {
		return stutas;
	}
	public void setStutas(String stutas) {
		this.stutas = stutas;
	}
	

	
}
