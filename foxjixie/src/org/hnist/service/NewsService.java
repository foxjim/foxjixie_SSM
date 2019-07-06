package org.hnist.service;

import javax.servlet.http.HttpSession;

import org.hnist.model.NewsHead;
import org.springframework.ui.Model;

/**
 * 新闻Service层接口
 * @author Liuyun
 *
 */
public interface NewsService {
	
	/**
	 * 	查找所有的新闻
	 * @param nhClass 年级
	 * @param nhPage  第几页
	 * @return
	 */
	public String showAllNews(String nhClass,Integer nhPage,Model model ,HttpSession session);
	
	/**
	 * 	导入新闻的方法
	 * @param newsHead
	 * @return
	 */
	public String insertNews(NewsHead newsHead);
	
	/**
	 * 	更新新闻头部的方法
	 * @param newsHead
	 * @return
	 */
	public String updateNews(NewsHead newsHead);
	
	/**
	 * 更新新闻内容的方法
	 * @param nhId			新闻头Id
	 * @param ncContent		新闻内容
	 * @return
	 */
	public String updateNewsContent(Integer nhId,String ncContent);
	
	/**
	 * 	删除新闻的方法
	 * @param nhId
	 * @return
	 */
	public String deleteNews(Integer nhId) ;
	
	/**
	 * 	更新新闻使用链接的方法
	 * @param nhId
	 * @param userLink
	 * @return
	 */
	public String changeUserLink(Integer nhId,String userLink);
	
	/**
	 * 	通过序号查找新闻
	 * @param nhId
	 * @param model
	 * @param session
	 * @return
	 */
	public String findByNhId(Integer nhId,Model model,HttpSession session);
	
	/**
	 * 	根据序号查找所有的新闻信息
	 * @param nhId
	 * @param model
	 * @param session
	 * @return
	 */
	public String findAllNewsByNhId(Integer nhId,Model model,HttpSession session);
	
	/**
	 * 	新闻页显示所有新闻
	 * @param model
	 * @param session
	 * @return
	 */
	public String ShowAllNews(Model model,HttpSession session);
	
	/**
	 * 	根据序号显示新闻内容
	 * @param nhId
	 * @param model
	 * @param session
	 * @return
	 */
	public String ShowNewsContentByNhId(Integer nhId,Model model,HttpSession session);
}
