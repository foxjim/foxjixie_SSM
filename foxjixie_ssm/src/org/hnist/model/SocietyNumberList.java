package org.hnist.model;

import java.util.List;

/**
 *	 社团成员的list列表
 * @author Liuyun
 *
 */
public class SocietyNumberList {
	
	private String societyNumberTerm;
	private List<SocietyNumber> societyNumbers;
	
	public String getSocietyNumberTerm() {
		return societyNumberTerm;
	}
	public void setSocietyNumberTerm(String societyNumberTerm) {
		this.societyNumberTerm = societyNumberTerm;
	}
	public List<SocietyNumber> getSocietyNumbers() {
		return societyNumbers;
	}
	public void setSocietyNumbers(List<SocietyNumber> societyNumbers) {
		this.societyNumbers = societyNumbers;
	}

	
}
