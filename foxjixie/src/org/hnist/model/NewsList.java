package org.hnist.model;

import java.util.List;

public class NewsList {
	
	private Integer totalNumber;			//总数据量
	private Integer totalPage;				//总页数
	private Integer eachPageNumber;			//每页的数目
	private Integer currentPage;			//当前页
	private Integer upPage;					//上一页
	
	private Integer nextPage;				//下一页	
	private List<NewsHead> newsHeads;		//要显示的新闻
	
	
	public NewsList() {
		
	}
	
	public NewsList(Integer totalNumber,Integer currentPage,Integer eachPageNumber) {
		//总数目
				this.totalNumber=totalNumber;	
				//当前页
				this.currentPage=currentPage;
				//每一页的数据量
				this.eachPageNumber=eachPageNumber;
				
				//设置总页数
				if(totalNumber%eachPageNumber==0) {
					this.totalPage=totalNumber/eachPageNumber;
				}else {
					this.totalPage=1+totalNumber/eachPageNumber;
				}
				
				
				//设置上一页
				if(currentPage<=1 || currentPage==null) {
					this.upPage=1;
				}else {
					this.upPage=currentPage-1;
				}
				
				
				//设置下一页
				if(currentPage>=this.totalPage) {
					this.nextPage=this.totalPage;
				}else {
					this.nextPage=this.currentPage+1;
				}
	}
	
	public NewsList(Integer totalNumber,Integer currentPage,Integer eachPageNumber,List<NewsHead> newsHeads){ 
		//总数目
		this.totalNumber=totalNumber;	
		//当前页
		this.currentPage=currentPage;
		//每一页的数据量
		this.eachPageNumber=eachPageNumber;
		//要显示的新闻
		this.newsHeads=newsHeads;
		
		//设置总页数
		if(totalNumber%eachPageNumber==0) {
			this.totalPage=totalNumber/eachPageNumber;
		}else {
			this.totalPage=1+totalNumber/eachPageNumber;
		}
		
		
		//设置上一页
		if(currentPage<=1 || currentPage==null) {
			this.upPage=1;
		}else {
			this.upPage=currentPage-1;
		}
		
		
		//设置下一页
		if(currentPage>=this.totalPage) {
			this.nextPage=this.totalPage;
		}else {
			this.nextPage=this.currentPage+1;
		}
		
		
	}

	public Integer getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getEachPageNumber() {
		return eachPageNumber;
	}

	public void setEachPageNumber(Integer eachPageNumber) {
		this.eachPageNumber = eachPageNumber;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getUpPage() {
		return upPage;
	}

	public void setUpPage(Integer upPage) {
		this.upPage = upPage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public List<NewsHead> getNewsHeads() {
		return newsHeads;
	}

	public void setNewsHeads(List<NewsHead> newsHeads) {
		this.newsHeads = newsHeads;
	}
	
	
	

}
