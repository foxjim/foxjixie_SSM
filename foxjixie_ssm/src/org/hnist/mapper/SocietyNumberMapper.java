package org.hnist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hnist.model.SocietyNumber;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("societyNumberMapper")
public interface SocietyNumberMapper {
	
	/**
	 * 	查找最大的序号Id
	 * @return
	 */
	public Integer findMaxId();
	
	/**
	 *	添加社团历史的方法
	 * @param societyHistory
	 * @return
	 */
	public boolean insertSocietyNumber(SocietyNumber societyNumber);
	
	/**
	 * 	删除社团成员的方法
	 * @param societyNumberId
	 * @return
	 */
	public boolean deleteSocietyNumber(@Param("societyNumberId")Integer societyNumberId);
	
	/**
	 * 	通过Id查找社团成员的方法
	 * @param societyHistoryId
	 * @return
	 */
	public SocietyNumber findSocietyNumberById(@Param("societyNumberId")Integer societyNumberId);
	
	/**
	 * 	更新社团成员的方法
	 * @param societyNumber
	 * @return
	 */
	public boolean updateSocietyNumber(SocietyNumber societyNumber);
	
	/**
	 * 	查找所有的数据
	 * @return
	 */
	public List<SocietyNumber> findAllSocietyNumber();
	
	/**
	 * 	查找所有的任届
	 * @return
	 */
	public List<String> findAllSocietyNumberTerm();
	
	/**
	 * 	通过任届查找社团成员的方法
	 * @param societyNumberTerm
	 * @return
	 */
	public List<SocietyNumber> findBySocietyNumberTerm(@Param("societyNumberTerm")String societyNumberTerm);
}
