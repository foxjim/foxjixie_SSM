package org.hnist.service;

import org.hnist.model.College;
import org.springframework.ui.Model;

public interface CollegeService {
	
	/**
	 * 导入学院
	 * @param college
	 * @return
	 */
	public String InsertCollege(College college);
	
	/**
	 * 通过Id删除专业
	 * @param collegeId
	 * @return
	 */
	public String deleteCollegeById(Integer collegeId);
	
	/**
	 * 通过Id查找专业
	 * @param collegeId
	 * @param model
	 * @return
	 */
	public String findById(Integer collegeId,Model model);
	
	/**
	 * 更新专业的方法
	 * @param college
	 * @return
	 */
	public String updateCollege(College college);
	
	/**
	 * 查找所有的专业
	 * @param model
	 * @return
	 */
	public String findAllCollege(Model model);
}
