package org.hnist.model;

/**
 * 学院的实体类
 * @author Liuyun 2019.05.25
 *
 */
public class College {
	private Integer collegeId;		//序号
	private String collegeNo;		//学院编号
	private String collegeName;		//学院名
	private String collegeStutas;	//院校状态
	
	
	
	
	public College() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public College(Integer collegeId, String collegeNo, String collegeName) {
		super();
		this.collegeId = collegeId;
		this.collegeNo = collegeNo;
		this.collegeName = collegeName;
	}




	public Integer getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
	}
	public String getCollegeNo() {
		return collegeNo;
	}
	public void setCollegeNo(String collegeNo) {
		this.collegeNo = collegeNo;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getCollegeStutas() {
		return collegeStutas;
	}
	public void setCollegeStutas(String collegeStutas) {
		this.collegeStutas = collegeStutas;
	}
	
	
}
