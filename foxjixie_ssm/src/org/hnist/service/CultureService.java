package org.hnist.service;

import javax.servlet.http.HttpSession;

import org.hnist.model.Culture;
import org.springframework.ui.Model;

/**
 * 社团文化的Service层接口
 * @author Liuyun
 *
 */
public interface CultureService {
	
	/**
	 * 插入社团文化的方法
	 * @param culture
	 * @return
	 */
	public String InsertCulture(Culture culture); 
	
	/**
	 * 	删除社团文化的方法
	 * @param cultureId 序号
	 * @return
	 */
	public String deleteCultureById(Integer cultureId);
	
	/**
	 * 更改社团文化的方法
	 * @param culture
	 * @return
	 */
	public String updateCulture(Culture culture);
	
	/**
	 * 通过年级号（任届）查找所有的社团文化
	 * @param cultureGrade
	 * @return
	 */
	public String findByGrade(String cultureGrade,Model model,HttpSession session);
	
	/**
	 * 通过序号查找所有的社团文化
	 * @param cultureId
	 * @return
	 */
	public String findByCultureId(Integer cultureId,Model model,HttpSession session);
	
	/**
	 * 查找所有的社团文化-页面显示
	 * @param model
	 * @param session
	 * @return
	 */
	public String findAllSocietyCultures(Model model,HttpSession session);
	
}
