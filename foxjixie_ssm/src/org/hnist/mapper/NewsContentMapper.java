package org.hnist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.hnist.model.NewsContent;
import org.springframework.stereotype.Repository;
/**
 * 新闻内容的Mapper层接口
 * @author Liuyun 2019/05/31
 *
 */
@Repository("newsContentMapper")
@Mapper
public interface NewsContentMapper {
	
	/**
	 * 查找最大的ncId
	 * @return
	 */
	public Integer findMaxNcId();
	
	/**
	 * 插入数据的方法
	 * @param newsContent
	 * @return
	 */
	public boolean insertNewsCount(NewsContent newsContent);
	
	/**
	 * 更新数据的方法
	 * @param newsContent
	 * @return
	 */
	public boolean updateNewsContent(NewsContent newsContent);
	
	/**
	 * 删除新闻的方法
	 * @param ncId
	 * @return
	 */
	public Boolean deleteNewsContent(Integer ncId);
	
	/**
	 * 通过序号查找新闻内容
	 * @param ncId
	 * @return
	 */
	public List<NewsContent> findByNcId(Integer ncId);
	
	/**
	 * 通过新闻标题查找序号
	 * @param nhId
	 * @return
	 */
	public List<NewsContent> findByNhId(Integer nhId);

}
