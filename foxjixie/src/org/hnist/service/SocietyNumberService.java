package org.hnist.service;

import javax.servlet.http.HttpSession;

import org.hnist.model.SocietyNumber;
import org.springframework.ui.Model;

/**
 * 	社团成员的Service层接口
 * @author Liuyun 2019/06/24
 *
 */
public interface SocietyNumberService {

	/**
	 * 	添加社团成员的方法
	 * @param societyNumber
	 * @return
	 */
	public String InsertSocietyNumber(SocietyNumber societyNumber);
	
	/**
	 *	删除社团成员
	 * @param societyNumber
	 * @return
	 */
	public String deleteSocietyNumber(Integer societyNumberId);
	
	/**
	 * 通过序号查找社团成员
	 * @param societyNumberId
	 * @param model			societyNumber
	 * @param session
	 * @return
	 */
	public String findBySocietyId(Integer societyNumberId,Model model,HttpSession session);
	
	/**
	 * 	更新社团成员的方法
	 * @param societyNumber
	 * @return
	 */
	public String updateSocietyNumber(SocietyNumber societyNumber);
	
	/**
	 * 	通过任届查找社团成员的方法
	 * @param societyNumberTerm
	 * @param model			societyNumbers
	 * @param session
	 * @return
	 */
	public String findBySocietyNumberByTerm(String societyNumberTerm,Model model,HttpSession session);
	
	/**
	 * 	查找所有的社团成员
	 * @param model		societyNumberLists
	 * @param session
	 * @return
	 */
	public String findAllSocietyNumber(Model model,HttpSession session);
}
