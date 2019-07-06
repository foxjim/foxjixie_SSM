package org.hnist.controller;

import javax.servlet.http.HttpSession;

import org.hnist.model.SocietyHistory;
import org.hnist.service.SocietyHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *	社团历史的Controller层
 * @author Liuyun
 *
 */
@Controller
public class SocietyHistoryController {
	
	@Autowired
	private SocietyHistoryService societyHistoryService;
	
	/**
	 * 插入社团历史的方法
	 * @param societyHistoryTime
	 * @param societyHistoryContent
	 * @return
	 */
	@RequestMapping("/main/insertSocietyHistory")
	@ResponseBody
	public String InsertSoceityHistory(@RequestParam("societyHistoryTime")String societyHistoryTime,@RequestParam("societyHistoryContent")String societyHistoryContent) {
		SocietyHistory societyHistory=new SocietyHistory();
		societyHistory.setSocietyHistoryContent(societyHistoryContent);
		societyHistory.setSocietyHistoryTime(societyHistoryTime);
		
		return societyHistoryService.insertSocietyHistory(societyHistory);
	}
	
	/**
	 * 删除数据的方法
	 * @param societyHistoryId
	 * @return
	 */
	@RequestMapping("/main/deleteSocietyHistory")
	@ResponseBody
	public String deleteSocietyHistory(@RequestParam("societyHistoryId")Integer societyHistoryId) {
		return societyHistoryService.deleteSocietyHistory(societyHistoryId);
	}
	
	/**
	 * 编辑数据的方法-显示要编辑的数据
	 * @param societyHistoryId
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/main/editSocietyHistory")
	public String findBySocietyHistoryId(@RequestParam("societyHistoryId")Integer societyHistoryId,Model model,HttpSession session) {
		return null;
	}
	
	/**
	 * 更新社团历史的方法
	 * @param societyHistoryId
	 * @param societyHistoryTime
	 * @param societyHistoryContent
	 * @return
	 */
	@RequestMapping("/main/updateHistory")
	@ResponseBody
	public String updateSocietyHistory(@RequestParam("societyHistoryId")Integer societyHistoryId,
									   @RequestParam("societyHistoryTime")String societyHistoryTime,
									   @RequestParam("societyHistoryContent")String societyHistoryContent) {
		SocietyHistory societyHistory=new SocietyHistory();
		societyHistory.setSocietyHistoryId(societyHistoryId);
		societyHistory.setSocietyHistoryContent(societyHistoryContent);
		societyHistory.setSocietyHistoryTime(societyHistoryTime);
		
		return societyHistoryService.updateSocietyHistory(societyHistory);
	}
	
	/**
	 * 显示所有的社团发展历史
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/main/findAllHistory")
	public String findAllSocietyHistory(Model model,HttpSession session) {
		String societyHistoryString=societyHistoryService.findAllSocietyHistory(model, session);
		if(societyHistoryString=="0") {
			return "/main/SocietyHistoryList";
		}else if(societyHistoryString=="error") {
			model.addAttribute("message", "数据连接失败");
			return "/main/SocietyHistoryList";
		}else {
			model.addAttribute("message", "数据访问失败");
			return "/main/SocietyHistoryList";
		}
		
		
	}
}
