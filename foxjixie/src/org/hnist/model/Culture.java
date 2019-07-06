package org.hnist.model;
/**
 * 	社团文化的实体
 * @author Liuyun 2019/06/20
 *
 */
public class Culture {
	
	private Integer cultureId;			//序号	
	private String cultureGrade;		//发布人任届
	private String cultureClass;		//类型
	private String cultureTime;			//时间
	private String cultureContent;		//内容
	
	private String cultureLink;			//链接
	
	
	public Integer getCultureId() {
		return cultureId;
	}
	public void setCultureId(Integer cultureId) {
		this.cultureId = cultureId;
	}
	public String getCultureGrade() {
		return cultureGrade;
	}
	public void setCultureGrade(String cultureGrade) {
		this.cultureGrade = cultureGrade;
	}
	public String getCultureClass() {
		return cultureClass;
	}
	public void setCultureClass(String cultureClass) {
		this.cultureClass = cultureClass;
	}
	public String getCultureTime() {
		return cultureTime;
	}
	public void setCultureTime(String cultureTime) {
		this.cultureTime = cultureTime;
	}
	public String getCultureContent() {
		return cultureContent;
	}
	public void setCultureContent(String cultureContent) {
		this.cultureContent = cultureContent;
	}
	public String getCultureLink() {
		return cultureLink;
	}
	public void setCultureLink(String cultureLink) {
		this.cultureLink = cultureLink;
	}
	
	

}
