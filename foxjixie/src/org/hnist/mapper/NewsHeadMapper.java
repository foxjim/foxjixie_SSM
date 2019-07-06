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
	
	/**
	 * 	通过年级号查找数目量
	 * @param nhClass
	 * @return
	 */
	public Integer findNumberByNhClass(@Param("nhClass")String nhClass);

	/**
	 * 通过年级号以及序号查找数据
	 * @param nhClass
	 * @param start
	 * @param end
	 * @return
	 */
	public List<NewsHead> findByNhClassAndlitmit(@Param("nhClass")String nhClass,@Param("start")Integer start,@Param("end")Integer end);
	
	/**
	 * 	更改使用内外部链接
	 * @param nhId
	 * @param userLink
	 * @return
	 */
	public boolean changeUserLink(@Param("nhId")Integer nhId,@Param("userLink")String userLink);
	
	/**
	 * 	通过序号查找新闻
	 * @param nhId
	 * @return
	 */
	public NewsHead findByNhId(@Param("nhId")Integer nhId);
	
	/**
	 *  查找所有的任届（年级）
	 * @return
	 */
	public List<String> findAllNhClass();
	
	/**
	 *	 通过任届（年级)查找新闻
	 * @param nhClass
	 * @return
	 */
	public List<NewsHead> findByNhClass(@Param("nhClass")String nhClass);
}
