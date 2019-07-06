package org.hnist.service;

import javax.servlet.http.HttpSession;

import org.hnist.model.SocietyHistory;
import org.springframework.ui.Model;

/**
 * 	社团历史的Service层
 * @author Liuyun 2019/06/21
 *
 */
public interface SocietyHistoryService {
	
	/**
	 * 	导入社团历史的方法
	 * @param societyHistory
	 * @return
	 */
	public String insertSocietyHistory(SocietyHistory societyHistory);

	/**
	 * 	删除社团历史的方法
	 * @param societyHistoryId
	 * @return
	 */
	public String deleteSocietyHistory(Integer societyHistoryId);
	
	/**
	 * 通过id号查找社团历史的方法
	 * @param societyHistoryId
	 * @param model		societyHistory
	 * @param session
	 * @return
	 */
	public String findSocietyHistoryById(Integer societyHistoryId,Model model,HttpSession session);
	
	/**
	 *	更新社团历史的方法
	 * @param societyHistory
	 * @return
	 */
	public String updateSocietyHistory(SocietyHistory societyHistory);
	
	/**
	 * 	查找所有的社团历史
	 * @param model	societyHistorys
	 * @param session
	 * @return
	 */
	public String findAllSocietyHistory(Model model,HttpSession session);
	
	
	
	
	
	
	
}
