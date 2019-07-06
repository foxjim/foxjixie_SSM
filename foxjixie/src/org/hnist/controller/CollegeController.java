package org.hnist.controller;

import javax.servlet.http.HttpSession;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.hnist.model.College;
import org.hnist.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CollegeController {
	
	@Autowired
	private CollegeService collegeService;
	
	
	/**
	 * 	添加专业的方法
	 * @param collegeNo
	 * @param collegeName
	 * @return
	 */
	@RequestMapping("/main/InsertCollege")
	@ResponseBody
	public String InsertCollege(@RequestParam("collegeNo")String collegeNo,@RequestParam("collegeName")String collegeName) {
		
		College college=new College();
		
		college.setCollegeNo(collegeNo);
		college.setCollegeName(collegeName);
		
		return collegeService.InsertCollege(college);
	}
	
	/**
	 * 编辑专业-显示专业信息
	 * @param collegeId
	 * @param model
	 * @return
	 */
	@RequestMapping("/main/editCollege")
	public String findByCollegeId(@RequestParam("collegeId")Integer collegeId,Model model) {
		
		String cString=collegeService.findById(collegeId, model);
		
		if(!cString.equals("0")) {
			model.addAttribute("message", "数据查询失败");
		}
		
		return "/main/editCollege";
	}
	
	/**
	 * 更新的方法
	 * @return
	 */
	@RequestMapping("/main/editorCollege")
	@ResponseBody
	public String updateCollege(@RequestParam("collegeId")Integer collegeId,@RequestParam("collegeNo")String collegeNo,@RequestParam("collegeName")String collegeName) {
		
		College college=new College(collegeId,collegeNo,collegeName);
		
		
		return collegeService.updateCollege(college);
	}
	
	/**
	 * 	删除的方法
	 * @return
	 */
	@RequestMapping("/main/deleteCollege")
	@ResponseBody
	public String deleteCollege(@RequestParam("collegeId")Integer collegeId ) {
		return collegeService.deleteCollegeById(collegeId);
	}
	
	/**
	 * 查找所有的专业
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/main/findAll")
	public String findAllCollege(Model model) {
		
		if(!collegeService.findAllCollege(model).equals("0")) {
			model.addAttribute("message", "查询失败");
		}
		return "/main/CollegeList";
	}
	

}
