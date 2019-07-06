package org.hnist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hnist.model.Culture;
import org.springframework.stereotype.Repository;
/**
 * 社团文化的mapper层接口
 * @author Liuyun	2019/06/20
 *
 */
@Mapper
@Repository("CultureMapper")
public interface CultureMapper {
	
	/**
	 * 	查找最大的文化序号
	 * @return
	 */
	public Integer findMaxCultureId();

	/**
	 * 	插入社团文化的方法
	 * @param culture
	 * @return
	 */
	public boolean insertCulture(Culture culture);
	
	
	/**
	 * 	删除社团文化的方法
	 * @param cultureId	序号
	 * @return
	 */
	public boolean deleteCultureById(@Param("cultureId")Integer cultureId);
	
	/**
	 * 	通过文化序号查找社团文化
	 * @param cultureId
	 * @return
	 */
	public Culture findByCultureId(@Param("cultureId")Integer cultureId);
	
	/**
	 * 	编辑社团文化的方法
	 * @param culture
	 * @return
	 */
	public boolean editorCulture(Culture culture);
	
	/**
	 * 	通过任届（年级号）查找社团文化
	 * @param cultureGrade
	 * @return
	 */
	public List<Culture> findByCultureGrade(@Param("cultureGrade")String cultureGrade);
	
	/**
	 * 查找所有的社团文化类型
	 * @return
	 */
	public List<String> findAllCultureClass();
	
	/**
	 * 通过类型和任届查找社团文化的方法
	 * @param cultureClass
	 * @return
	 */
	public List<Culture> findByCultureClassGrade(@Param("cultureClass")String cultureClass,@Param("cultureGrade")String cultureGrade);
	
	/**
	 * 通过文化类型查找所有的社团文化
	 * @param cultureClass
	 * @return
	 */
	public List<Culture> findByCultureClass(@Param("cultureClass")String cultureClass);
}
