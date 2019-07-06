package org.hnist.controller;

import javax.servlet.http.HttpSession;

import org.hnist.model.AdminUser;
import org.hnist.model.Culture;
import org.hnist.service.CultureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 	社团文化的controller层
 * @author Liuyun 2019/06/20
 *
 */
@Controller
public class CultureController {

	@Autowired
	private CultureService cultureService;
	
	/**
	 * 添加社团文化的方法
	 * @return
	 */
	@RequestMapping(value="/main/InsertCulture")
	@ResponseBody
	public String InsertCulture(
								@RequestParam("cultureClass")String cultureClass,
								@RequestParam("cultureTime")String cultureTime,
								@RequestParam("cultureContent")String cultureContent,
								@RequestParam(value="cultureLink",required=false)String cultureLink,HttpSession session) {
		 
		AdminUser adminUser=(AdminUser)session.getAttribute("admin");
		if(adminUser==null) {
				return "/main/login";
		}else {
			Culture culture=new Culture();
		
			culture.setCultureClass(cultureClass);
			culture.setCultureContent(cultureContent);
			culture.setCultureGrade(adminUser.getAdminGrades());
			culture.setCultureTime(cultureTime);
			culture.setCultureLink(cultureLink);
		
		
		
			return cultureService.InsertCulture(culture);
		}
	}
	
	/**
	 * 通过Id值删除社团文化
	 * @param cultureId
	 * @return
	 */
	@RequestMapping(value="/main/deleteCulture")
	@ResponseBody
	public String deleteCultureById(@RequestParam("cultureId")Integer cultureId) {
		System.out.println(cultureId);
		return cultureService.deleteCultureById(cultureId);
	}

	/**
	 * 	更改社团文化的方法
	 * @return
	 */
	@RequestMapping("/main/updateCulture")
	@ResponseBody
	public String editCulture(@RequestParam("cultureId")Integer cultureId,
							  @RequestParam("cultureClass")String cultureClass,
							  @RequestParam("cultureTime")String cultureTime,
							  @RequestParam("cultureContent")String cultureContent,
							  @RequestParam("cultureLink")String cultureLink,HttpSession session) {
		
		AdminUser adminUser=(AdminUser)session.getAttribute("admin");
		if(adminUser==null) {
			return "/main/login";
		}else {
			Culture culture=new Culture();
		
			culture.setCultureClass(cultureClass);
			culture.setCultureContent(cultureContent);
			culture.setCultureGrade(adminUser.getAdminGrades());
			culture.setCultureId(cultureId);
			culture.setCultureLink(cultureLink);
		
			culture.setCultureTime(cultureTime);
		
		return cultureService.updateCulture(culture);
		}
	}
	
	/**
	 * 	通过年级号（任届）查找社团文化的方法
	 * @param cultureGrade
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/main/Cultures")
	public String findByCultureGrade(Model model,HttpSession session) {
		AdminUser adminUser=(AdminUser)session.getAttribute("admin");
		if(adminUser==null) {
			return "/main/login";
		}else {
			
			return cultureService.findByGrade(adminUser.getAdminGrades(), model, session);
		}
		
	}
	
	/**
	 * 	通过Id号查找社团 文化-编辑前一步
	 * @param cultureId
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/main/editCulture")
	public String findByCultureId(@RequestParam("cultureId")Integer cultureId,Model model,HttpSession session) {
		return cultureService.findByCultureId(cultureId, model, session);
	}
	
	/**
	 * 	显示界面显示社团文化的方法
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/front/SocietyCulture")
	public String findAllSocietyCulture(Model model,HttpSession session) {
		return cultureService.findAllSocietyCultures(model, session);
	}
	
	
}
