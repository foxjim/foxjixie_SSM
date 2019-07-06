package org.hnist.model;

import java.util.List;

/**
 * 分页显示用户的方法
 * 
 * @author Liuyun
 *
 */
public class UserList {

	private Integer totalNumber; // 总数
	private Integer eachPageNumber; // 每页的数目
	private Integer currentPage; // 当前页
	private Integer upPage; // 上一页
	private Integer nextPage; // 下一页

	private Integer totalPage; // 总页数-最后一页
	private List<User> users; // 当前页数的数据

	public UserList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 分页构造-页面
	 * 
	 * @param totalNumber    总数目
	 * @param eachPageNumber 每页数目
	 * @param currentPage    当前页
	 */
	public UserList(Integer totalNumber, Integer eachPageNumber, Integer currentPage) {
		super();
		this.totalNumber = totalNumber;
		this.eachPageNumber = eachPageNumber;
		this.currentPage = currentPage;

		// 设置上一页
		if (currentPage <= 1) {
			this.upPage = 1;
		} else {
			this.upPage = currentPage - 1;
		}

		// 设置总页数
		if (this.totalNumber % this.eachPageNumber == 0) {
			this.totalPage = this.totalNumber / this.eachPageNumber;
		} else {
			this.totalPage = this.totalNumber / this.eachPageNumber + 1;
		}

		// 设置下一页
		if (currentPage >= this.totalPage) {
			this.nextPage = this.totalPage;
		} else {
			this.nextPage = this.currentPage + 1;
		}
	}

	/**
	 * 分页显示
	 * 
	 * @param totalNumber
	 * @param eachPageNumber
	 * @param currentPage
	 * @param users
	 */
	public UserList(Integer totalNumber, Integer eachPageNumber, Integer currentPage, List<User> users) {
		super();
		this.totalNumber = totalNumber;
		this.eachPageNumber = eachPageNumber;
		this.currentPage = currentPage;
		this.users = users;

		// 设置上一页
		if (currentPage <= 1) {
			this.upPage = 1;
		} else {
			this.upPage = currentPage - 1;
		}

		// 设置总页数
		if (this.totalNumber % this.eachPageNumber == 0) {
			this.totalPage = this.totalNumber / this.eachPageNumber;
		} else {
			this.totalPage = this.totalNumber / this.eachPageNumber + 1;
		}

		// 设置下一页
		if (currentPage >= this.totalPage) {
			this.nextPage = this.totalPage;
		} else {
			this.nextPage = this.currentPage + 1;
		}
	}

	public Integer getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
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

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
