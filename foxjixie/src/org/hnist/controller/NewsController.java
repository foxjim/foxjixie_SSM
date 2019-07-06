package org.hnist.controller;

import javax.servlet.http.HttpSession;

import org.hnist.model.NewsHead;
import org.hnist.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 新闻页面控制的controller层
 * @author Liuyun 2019/05/31
 *
 */
@Controller
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	

	/**
	 * 	通过年级号查找所有的数据-方便增删改查
	 * @param nhClass 
	 * @param nhPage	需要查找的页面
	 * @return
	 */
	@RequestMapping(value="/main/showAllNews")
	public String showAllNews(@RequestParam("nhClass")String nhClass,@RequestParam("nhPage")Integer nhPage,Model model,HttpSession session){
		try {
			if(nhPage==null) {//如果页面值为空
				nhPage=1;
			}
			
			return newsService.showAllNews(nhClass, nhPage,model,session);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "errorc";
	}
	
	/**
	 * 	添加新闻的方法
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/main/insertNews")
	@ResponseBody
	public String insertNews(@RequestParam("nhClass")String nhClass,
							 @RequestParam("nhTitle")String nhTitle,
							 @RequestParam("nhTime")String nhTime,
							 @RequestParam("nhPerson")String nhPerson,
							 @RequestParam("otherLink")String otherLink,
							 @RequestParam("userLink")String userLink) {
		NewsHead newsHead=new NewsHead();
		newsHead.setNhClass(nhClass);
		newsHead.setNhPerson(nhPerson);
		newsHead.setNhTime(nhTime);
		newsHead.setNhTitle(nhTitle);
		newsHead.setOtherLink(otherLink);
		newsHead.setUserLink(userLink);
		
		return newsService.insertNews(newsHead);
	}
	
	/**
	 * 	更新新闻头部数据的方法
	 * @param newsHead
	 * @param model
	 * @param sessio
	 * @return
	 */
	@RequestMapping("/main/updateNews")
	@ResponseBody
	public String updateNews(@RequestParam("nhId")Integer nhId,
							 @RequestParam("nhClass")String nhClass,
			 				 @RequestParam("nhTitle")String nhTitle,
			 				 @RequestParam("nhTime")String nhTime,
			 				 @RequestParam("nhPerson")String nhPerson,
			 				 @RequestParam("otherLink")String otherLink,
			 				 @RequestParam("userLink")String userLink) {
		
		NewsHead newsHead=new NewsHead();
		newsHead.setNhId(nhId);
		newsHead.setNhClass(nhClass);
		newsHead.setNhPerson(nhPerson);
		newsHead.setNhTime(nhTime);
		newsHead.setNhTitle(nhTitle);
		newsHead.setOtherLink(otherLink);
		newsHead.setUserLink(userLink);
		return newsService.updateNews(newsHead);
	}
	
	/**
	 * 更新新闻内容的方法
	 * @param nhId
	 * @param ncContent
	 * @return
	 */
	@RequestMapping("/main/updateNewsContent")
	@ResponseBody
	public String updateNewsContent(@RequestParam("nhId")Integer nhId,@RequestParam("ncContent")String ncContent) {
		return newsService.updateNewsContent(nhId, ncContent);
	}
	
	/**
	 * 	编辑的方法-通过序号查找新闻head信息
	 * @param nhId
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("main/editorNews")
	public String findByNHId(@RequestParam("nhId")Integer nhId,Model model,HttpSession session) {
		return newsService.findByNhId(nhId, model, session);
	}
	
	/**
	 * 	删除数据的方法
	 * @param nhId
	 * @return
	 */
	@RequestMapping("/main/deleteNews")
	@ResponseBody
	public String deleteNews(@RequestParam("nhId")Integer nhId) {
		
		
		return newsService.deleteNews(nhId);
	}
	
	/**
	 * 	更改连接属性的方法
	 * @param nhId
	 * @param userLink
	 * @return
	 */
	@RequestMapping("/main/updateUserLink")
	@ResponseBody
	public String updateUserLink(@RequestParam("nhId")Integer nhId,@RequestParam("userLink")String userLink) {
		return newsService.changeUserLink(nhId, userLink);
	}
	
	/**
	 * 	通过序号查找新闻
	 * @param nhId
	 * @return
	 */
	@RequestMapping("/main/editNewsContent")
	public String findAllNewsById(@RequestParam("nhId")Integer nhId,Model model,HttpSession session) {
		return newsService.findAllNewsByNhId(nhId, model, session);
	}
	
	/**
	 * 	首页显示所有新闻
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/front/SocietyNews")
	public String findAllNews(Model model,HttpSession session) {
		return newsService.ShowAllNews(model, session);
	}
	/**
	 * 	根据新闻序号查找新闻内容
	 * @param nhId
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/front/NewsIndex")
	public String findByNhId(@RequestParam("nhId")Integer nhId,Model model,HttpSession session) {
		return newsService.ShowNewsContentByNhId(nhId,model,session);
	}

}
