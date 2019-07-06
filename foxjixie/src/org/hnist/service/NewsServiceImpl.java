package org.hnist.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.hnist.mapper.NewsContentMapper;
import org.hnist.mapper.NewsHeadMapper;
import org.hnist.model.NewsContent;
import org.hnist.model.NewsHead;
import org.hnist.model.NewsHeadList;
import org.hnist.model.NewsList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

/**
 * 新闻的Service实现类
 * @author Liuyun 2019/05/31
 *
 */
@Service("NewsService")
@Transactional
public class NewsServiceImpl implements NewsService{
	
	@Resource
	private NewsContentMapper newsContentMapper;
	@Resource
	private NewsHeadMapper newsHeadMapper;
	
	//显示所有的数据
	@Override
	public String showAllNews(String nhClass, Integer nhPage,Model model ,HttpSession session) {
		try {
			
			//获取总页数
			Integer totalNumber=newsHeadMapper.findNumberByNhClass(nhClass);
			
			//没有数据
			if(totalNumber==null) {
				model.addAttribute("message", "暂无数据");
				return "/main/newsHeadList";
			}else {
				//每页数据量
				Integer eachPageNumber=5;
				NewsList newsList=new NewsList(totalNumber,nhPage,eachPageNumber);
				
				Integer start=(newsList.getCurrentPage()-1)*eachPageNumber;
				Integer end=newsList.getCurrentPage()*eachPageNumber;
				
				//获取查找的新闻
				List<NewsHead> newsHeads=newsHeadMapper.findByNhClassAndlitmit(nhClass, start,end);
				newsList.setNewsHeads(newsHeads);
				
				model.addAttribute("newsList", newsList);
				return "/main/newsHeadList";
			
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("message", "数据库连接错误");
		return "/main/newsHeadList";
	}
	
	//插入新闻
	@Override
	public String insertNews(NewsHead newsHead) {
		try {
			
			//设置序号
			Integer nhId=newsHeadMapper.findMaxNhId();
			if(nhId==null) {
				nhId=0;
			}
			newsHead.setNhId(nhId+1);
			
			//插入操作
			if(newsHead.getUserLink().equals("0")) {
				
				//查找设置最大的新闻内容序号
				Integer ncId=newsContentMapper.findMaxNcId();
				if(ncId==null) {
					ncId=0;
				}
				
				//导入新闻序号
				NewsContent newsContent=new NewsContent();
				newsContent.setNcContent("暂无内容");
				newsContent.setNhId(newsHead.getNhId());
				newsContent.setNcId(ncId+1);
					
				//如果新闻内容创建成功	
				if(newsContentMapper.insertNewsCount(newsContent)) {
					if(newsHeadMapper.insertNewsHead(newsHead)) {
						return String.valueOf(nhId+1);
					}else {
						newsContentMapper.deleteNewsContent(newsContent.getNcId());
						return "error";
					}
				}
				
				
			}else if(newsHead.getUserLink().equals("1")){
				if(newsHeadMapper.insertNewsHead(newsHead)) {
					return String.valueOf(nhId+1);
				}else {
					return "1";
				}
			}else {
				return "1";
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return "error";
	}
	
	//更新新闻头部的方法
	@Override
	public String updateNews(NewsHead newsHead) {
		try {
			if(newsHeadMapper.updateNewsHead(newsHead)) { //更新成功，更新失败
				return "0";
			}else {
				return "1";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "error";
	}
	
	//删除新闻
	@Override
	public String deleteNews(Integer nhId) {
		try {
			System.out.println("nhId:"+nhId);
			if(newsContentMapper.deleteByNhId(nhId)){
				if(newsHeadMapper.deleteNewsHead(nhId)) {//删除成功
					
					return "0";
				}else {									//删除失败
					
					return "1";
				}
			}else {
				
				return "1";
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "error";
	}

	//更新新闻内容的方法
	@Override
	public String updateNewsContent(Integer nhId, String ncContent) {
		try {
			NewsContent newsContent=new NewsContent();
			newsContent.setNhId(nhId);
			newsContent.setNcContent(ncContent);
			
			if(newsContentMapper.updateNewsContent(newsContent)) {
				return "0";
			}else {
				return "1";
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "wrong";
	}

	//更新新闻使用链接的方法
	@Override
	public String changeUserLink(Integer nhId, String userLink) {
		try {
			
			if(newsHeadMapper.changeUserLink(nhId, userLink)) {
				return "0";
			}else {
				return "1";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "error";
	}

	//通过序号查找新闻
	@Override
	public String findByNhId(Integer nhId, Model model, HttpSession session) {
		try {
			model.addAttribute("newsHead", newsHeadMapper.findByNhId(nhId));
			return "/main/editNewsHead";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("message", "数据库连接失败");
		return "/main/editNewsHead";
	}

	//根据序号查找所有的新闻信息
	@Override
	public String findAllNewsByNhId(Integer nhId, Model model, HttpSession session) {
		try {
			List<NewsContent> newsContents= newsContentMapper.findByNhId(nhId);
			if(newsContents.size()<=0) {
				Integer ncId=newsContentMapper.findMaxNcId();
				if(ncId==null) {
					ncId=0;
				}
				NewsContent newsContent=new NewsContent();
				newsContent.setNcId(ncId+1);
				newsContent.setNhId(nhId);
				newsContent.setNcContent("暂无详情");
				
				newsContentMapper.insertNewsCount(newsContent);
				model.addAttribute("news", newsContent);
				
			}else {
				model.addAttribute("news",newsContents.get(0));
			}
			
			
			
			model.addAttribute("newsHead", newsHeadMapper.findByNhId(nhId));
			
			return "/main/editNewsContent";
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("message", "数据连接失败");
		return "/main/editNewsContent";
	}

	//新闻页显示所有新闻
	@Override
	public String ShowAllNews(Model model, HttpSession session) {
		try {
			
			List<NewsHeadList> newsHeadLists=new ArrayList<NewsHeadList>();
			NewsHeadList newsHeadList;
			//查找所有的年级
			List<String> nhClasss=newsHeadMapper.findAllNhClass();
			for(int i=0;i<nhClasss.size();i++) {
				newsHeadList=new NewsHeadList();
				newsHeadList.setNtTime(Integer.valueOf("20"+nhClasss.get(i)));
				newsHeadList.setNhlist(newsHeadMapper.findByNhClass(nhClasss.get(i)));
				
				newsHeadLists.add(newsHeadList);
			}
			Collections.reverse(newsHeadLists);
			model.addAttribute("newsHeadLists", newsHeadLists);
			return "/front/NewsTest";
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/front/NewsTest";
	}

	//根据序号显示新闻内容
	@Override
	public String ShowNewsContentByNhId(Integer nhId, Model model, HttpSession session) {
		try {
			List<NewsContent> newsContents= newsContentMapper.findByNhId(nhId);
			if(newsContents.size()<=0) {
				Integer ncId=newsContentMapper.findMaxNcId();
				if(ncId==null) {
					ncId=0;
				}
				NewsContent newsContent=new NewsContent();
				newsContent.setNcId(ncId+1);
				newsContent.setNhId(nhId);
				newsContent.setNcContent("暂无详情");
				
				newsContentMapper.insertNewsCount(newsContent);
				model.addAttribute("news", newsContent);
				
			}else {
				model.addAttribute("news",newsContents.get(0));
			}
			
			
			
			model.addAttribute("newsHead", newsHeadMapper.findByNhId(nhId));
			
			return "/front/NewContent";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/front/NewContent";
	}
	
	
}
