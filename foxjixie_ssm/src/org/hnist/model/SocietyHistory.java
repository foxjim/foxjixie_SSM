package org.hnist.model;

public class SocietyHistory {
		
	private Integer societyHistoryId;		//序号
	private String  societyHistoryTime;		//时间
	private String  societyHistoryContent;	//内容
	
	public Integer getSocietyHistoryId() {
		return societyHistoryId;
	}
	public void setSocietyHistoryId(Integer societyHistoryId) {
		this.societyHistoryId = societyHistoryId;
	}
	public String getSocietyHistoryTime() {
		return societyHistoryTime;
	}
	public void setSocietyHistoryTime(String societyHistoryTime) {
		this.societyHistoryTime = societyHistoryTime;
	}
	public String getSocietyHistoryContent() {
		return societyHistoryContent;
	}
	public void setSocietyHistoryContent(String societyHistoryContent) {
		this.societyHistoryContent = societyHistoryContent;
	}
	
	
}
