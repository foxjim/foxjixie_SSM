package org.hnist.model;

/**
 * 社团成员的实体
 * @author HELLO WORLD
 *		
 */

public class SocietyNumber {
	
	private Integer societyNumberId;				//序号
	private String 	societyNumberTerm;				//任届
	private String 	societyNumberDepartment;		//部门	
	private String 	societyNumberOldMember;			//部长
	private String 	societyNumberYoungerMember;		//副部长
	
	public Integer getSocietyNumberId() {
		return societyNumberId;
	}
	public void setSocietyNumberId(Integer societyNumberId) {
		this.societyNumberId = societyNumberId;
	}
	public String getSocietyNumberTerm() {
		return societyNumberTerm;
	}
	public void setSocietyNumberTerm(String societyNumberTerm) {
		this.societyNumberTerm = societyNumberTerm;
	}
	public String getSocietyNumberDepartment() {
		return societyNumberDepartment;
	}
	public void setSocietyNumberDepartment(String societyNumberDepartment) {
		this.societyNumberDepartment = societyNumberDepartment;
	}
	public String getSocietyNumberOldMember() {
		return societyNumberOldMember;
	}
	public void setSocietyNumberOldMember(String societyNumberOldMember) {
		this.societyNumberOldMember = societyNumberOldMember;
	}
	public String getSocietyNumberYoungerMember() {
		return societyNumberYoungerMember;
	}
	public void setSocietyNumberYoungerMember(String societyNumberYoungerMember) {
		this.societyNumberYoungerMember = societyNumberYoungerMember;
	}
	
	
	


}
