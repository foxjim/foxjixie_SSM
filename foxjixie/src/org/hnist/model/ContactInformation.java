package org.hnist.model;
/**
 * 联系我们的实体
 * @author HELLO WORLD
 *		用于管理社团简介中联系我们的实体
 *
 */

public class ContactInformation {
	
	private Integer contactInformationId;			//序号
	private String  contactInformationName;			//联系名称
	private String  contactInformationContant;		//联系内容
	
	public Integer getContactInformationId() {
		return contactInformationId;
	}
	public void setContactInformationId(Integer contactInformationId) {
		this.contactInformationId = contactInformationId;
	}
	public String getContactInformationName() {
		return contactInformationName;
	}
	public void setContactInformationName(String contactInformationName) {
		this.contactInformationName = contactInformationName;
	}
	public String getContactInformationContant() {
		return contactInformationContant;
	}
	public void setContactInformationContant(String contactInformationContant) {
		this.contactInformationContant = contactInformationContant;
	}
	
	
	
	
}