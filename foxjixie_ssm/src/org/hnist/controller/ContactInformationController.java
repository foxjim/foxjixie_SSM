package org.hnist.controller;

import javax.servlet.http.HttpSession;

import org.hnist.model.ContactInformation;
import org.hnist.service.ContactInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
/**
 * 	联系我们的controller层
 * @author Liuyun
 *
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.org.apache.xml.internal.serializer.ElemDesc;
@Controller
public class ContactInformationController {
	
	@Autowired
	private ContactInformationService contactInformationService;
	
	/**
	 *	 添加社团联系方式的方法
	 * @param contactInformationName
	 * @param contactInformationContant
	 * @return
	 */
	@RequestMapping("/main/insertContactInformation")
	@ResponseBody
	public String InsertContactInformation(@RequestParam("contactInformationName")String contactInformationName,
											@RequestParam("contactInformationContant")String contactInformationContant) {
		
		ContactInformation contactInformation=new ContactInformation();
		contactInformation.setContactInformationContant(contactInformationContant);
		contactInformation.setContactInformationName(contactInformationName);
		
		return  contactInformationService.InsertContactInformation(contactInformation);	
		
	
		
	}
	
	/**
	 * 	删除联系方式的方法
	 * @param contactInformationId
	 * @return
	 */
	@RequestMapping("/main/deleteContactInformation")
	@ResponseBody
	public String deleteContactInformation(@RequestParam("contactInformationId")Integer contactInformationId) {
		return contactInformationService.deleteContactInformation(contactInformationId);
	}
	
	/**
	 * 	编辑社团联系方式的方法-查找所有的社团联系方式的方法
	 * @param contactInformationId
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/main/editContactInformation")
	public String findByContactInformationId(@RequestParam("contactInformationId")Integer contactInformationId,Model model,HttpSession session) {
		
		String fbciString=contactInformationService.findByContactInformationId(contactInformationId, model, session);
		
		if(fbciString.equals("0")) {
			
			return "/main/editContactInformation";
		}else {
			model.addAttribute("message", "后台数据连接失败");
			return "/main/editContactInformation";
		}
		
	}	

	/**
	 * 	更新联系我们的方式
	 * @param contactInformationId
	 * @param contactInformationName
	 * @param contactInformationContant
	 * @return
	 */
	@RequestMapping("/main/updateContactInformation")
	@ResponseBody
	public String updateContactInformation(@RequestParam("contactInformationId")Integer contactInformationId,
											@RequestParam("contactInformationName")String contactInformationName,
											@RequestParam("contactInformationContant")String contactInformationContant) {
		
		ContactInformation contactInformation=new ContactInformation();
		contactInformation.setContactInformationContant(contactInformationContant);
		contactInformation.setContactInformationName(contactInformationName);
		contactInformation.setContactInformationId(contactInformationId);
		
		return contactInformationService.updateContactInformation(contactInformation);
	}
	
	/**
	 * 	查找所有的联系我们的方法
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/main/ContactInformation")
	public String findAllContactInformation(Model model,HttpSession session) {
		
		String famessageString=contactInformationService.findAllContactInformation(model, session);
		if(famessageString.equals("0")) {
			return "/main/ContactInformationList";
		}else {
			model.addAttribute("message", "数据获取失败");
			return "/main/ContactInformationList";
		}
		
	}

}
