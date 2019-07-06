package org.hnist.controller;

import javax.servlet.http.HttpSession;

import org.hnist.model.AdminUser;
import org.hnist.model.SocietyNumber;
import org.hnist.service.SocietyNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 	社团成员的Controller层实现类
 * @author Liuyun
 *
 */
@Controller
public class SocietyNumberController {

	@Autowired
	private SocietyNumberService societyNumberService;
		
	/**
	 * 	添加社团成员的方法
	 * @param societyNumberDepartment
	 * @param societyNumberOldMember
	 * @param societyNumberYoungerMember
	 * @param session
	 * @return
	 */
	@RequestMapping("/main/insertSocietyNumber")
	@ResponseBody
	public String insertSocietyNumber(@RequestParam("societyNumberDepartment")String societyNumberDepartment,
									  @RequestParam("societyNumberOldMember")String societyNumberOldMember,
									  @RequestParam(value="societyNumberYoungerMember",required = false)String societyNumberYoungerMember,
									  HttpSession  session) {
		AdminUser adminUser=(AdminUser)session.getAttribute("admin");
		if(adminUser==null) {
			return "redirect:/main/login.jsp";
		}else {
			SocietyNumber societyNumber=new SocietyNumber();
			societyNumber.setSocietyNumberDepartment(societyNumberDepartment);
			societyNumber.setSocietyNumberOldMember(societyNumberOldMember);
			societyNumber.setSocietyNumberYoungerMember(societyNumberYoungerMember);
			societyNumber.setSocietyNumberTerm(adminUser.getAdminGrades());
		
			return societyNumberService.InsertSocietyNumber(societyNumber);
		}
		
	}
	
	/**
	 * 	删除数据的方法
	 * @param societyNumberId
	 * @return
	 */
	@RequestMapping("/main/deleteSocietyNumber")
	@ResponseBody
	public String deleteSocietyNumber(@RequestParam("societyNumberId")Integer societyNumberId) {
		return societyNumberService.deleteSocietyNumber(societyNumberId);
	}
	
	/**
	 *	根据Id查找社团成员
	 * @param societyNumberId
	 * @return
	 */
	@RequestMapping("/main/editSocietyNumber")
	public String findBySocietyNumber(@RequestParam("societyNumberId")Integer societyNumberId,Model model,HttpSession session) {
		String societNumberMessage=societyNumberService.findBySocietyId(societyNumberId, model, session);
		if(societNumberMessage.equals("0")) {
			return "/main/editSocietyNumber";
		}else {
			model.addAttribute("message", "数据访问失败！请刷新后重试");
			return "/main/SocietyNumberList";
		}
		
	}
	
	/**
	 * 	更新社团成员的方法
	 * @param societyNumberId
	 * @param societyNumberDepartment
	 * @param societyNumberOldMember
	 * @param societyNumberYoungerMember
	 * @return
	 */
	@RequestMapping("/main/updateSocietyNumber")
	@ResponseBody
	public String updateSocietyNumber(@RequestParam("societyNumberId")Integer societyNumberId,
									  @RequestParam("societyNumberDepartment")String societyNumberDepartment,
									  @RequestParam("societyNumberOldMember")String societyNumberOldMember,
									  @RequestParam(value="societyNumberYoungerMember",required = false)String societyNumberYoungerMember) {
		
		SocietyNumber societyNumber=new SocietyNumber();
		societyNumber.setSocietyNumberId(societyNumberId);
		societyNumber.setSocietyNumberDepartment(societyNumberDepartment);
		societyNumber.setSocietyNumberOldMember(societyNumberOldMember);
		societyNumber.setSocietyNumberYoungerMember(societyNumberYoungerMember);
		return societyNumberService.updateSocietyNumber(societyNumber);
	}
	
	
	/**
	 * 	通过任届查找社团成员
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/main/findAllSocietyNumber")
	public String findSocietyNumberByTerm(Model model,HttpSession session) {
		AdminUser adminUser=(AdminUser)session.getAttribute("admin");
		if(adminUser==null) {
			return "redirect:/main/login.jsp";
		}else {
		
			String findMessage=societyNumberService.findBySocietyNumberByTerm(adminUser.getAdminGrades(), model, session);
			if(findMessage.equals("0")) {
				return "/main/SocietyNumberList";
			}else {
				model.addAttribute("message", "数据访问失败");
				return "/main/SocietyNumberList";
			}
			
		
		}
	}
	
	
		
		
}
