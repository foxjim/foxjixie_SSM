package org.hnist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hnist.model.SocietyHistory;
import org.springframework.stereotype.Repository;
/**
 * 	社团历史的的mappe层接口
 * @author Liuyun
 *
 */
@Repository("societyHistory")
@Mapper
public interface SocietyHistoryMapper {

	/**
	 * 	查找最大的序号
	 * @return
	 */
	public Integer findMaxId();
	
	/**
	 *	插入社团历史的方法
	 * @param societyHistory
	 * @return
	 */
	public boolean insertSocietyHistory(SocietyHistory societyHistory);
	
	/**
	 * 	删除社团历史的方法
	 * @param societyHistoryId
	 * @return
	 */
	public boolean deleteSocietyHistory(@Param("societyHistoryId")Integer societyHistoryId);
	
	/**
	 *	 更新社团历史的方法
	 * @param societyHistory
	 * @return
	 */
	public boolean updateSocietyHistory(SocietyHistory societyHistory);
	
	/**
	 *	通过Id号查找社团历史的方法
	 * @param societyHistoryId
	 * @return
	 */
	public SocietyHistory findBySocietyHistoryId(@Param("societyHistoryId")Integer societyHistoryId);
	
	/**
	 * 	查找所有的社团历史
	 * @return
	 */
	public List<SocietyHistory> findAllSocietyHistory();
}
