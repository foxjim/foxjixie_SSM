package org.hnist.model;
/**
 * 新闻内容的实体类
 * @author Liuyun 2019/05/31
 *
 */
public class NewsContent {
	
	private Integer ncId;				//序号
	private Integer nhid;				//所属新闻序号
	private String ncContent;			//内容
	
	
	public Integer getNcId() {
		return ncId;
	}
	public void setNcId(Integer ncId) {
		this.ncId = ncId;
	}
	public Integer getNhid() {
		return nhid;
	}
	public void setNhid(Integer nhid) {
		this.nhid = nhid;
	}
	public String getNcContent() {
		return ncContent;
	}
	public void setNcContent(String ncContent) {
		this.ncContent = ncContent;
	}
	
	

}
