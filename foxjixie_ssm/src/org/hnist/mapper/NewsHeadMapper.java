package org.hnist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hnist.model.NewsHead;
import org.springframework.stereotype.Repository;

/**
 * 新闻内容的mapper层接口
 * @author Liuyun	2019/05/31
 *
 */
@Repository("newsHeadMapper")
@Mapper
public interface NewsHeadMapper {
	
	/**
	 * 查找最大的新闻序号
	 * @return
	 */
	public Integer findMaxNhId();
	
	/**
	 * 插入新闻
	 * @param newsHead
	 * @return
	 */
	public boolean insertNewsHead(NewsHead newsHead);
	
	/**
	 * 更新新闻的操作
	 * @param newsHead
	 * @return
	 */
	public boolean updateNewsHead(NewsHead newsHead);
	
	/**
	 * 插入内部新闻
	 * @return
	 */
	public boolean insertOwnLink(Integer nhId);
	
	/**
	 * 删除新闻的操作
	 * @param nhId
	 * @return
	 */
	public boolean deleteNewsHead(Integer nhId);
	
	/**
	 * 查找所有新闻的操作
	 * @return
	 */
	public List<NewsHead> findAllNewsHead();
	
	/**
	 * 通过限制条件查找新闻
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<NewsHead> findLimitNewsHead(@Param("begin")Integer begin,@Param("end")Integer end);
	
	/**
	 * 查询所有的数据量
	 * @return
	 */
	public Integer findTotalCount();

}
