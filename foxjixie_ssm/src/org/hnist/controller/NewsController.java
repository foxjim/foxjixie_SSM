package org.hnist.controller;

import javax.servlet.http.HttpSession;

import org.hnist.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 新闻页面控制的controller层
 * @author Liuyun 2019/05/31
 *
 */
@Controller
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	

	@RequestMapping("/main/showAllNews")
	public String showAllNews(Model model,HttpSession session){
		return null;
	}

}
