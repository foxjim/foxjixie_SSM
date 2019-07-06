package org.hnist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hnist.model.ContactInformation;
import org.springframework.stereotype.Repository;

/**
 *	 联系我们的mapper层接口
 * @author Liuyun
 *
 */
@Repository("contactInformationMapper")
@Mapper
public interface ContactInformationMapper {
	
	/**
	 *	 查找最大的序号
	 * @return
	 */
	public Integer findMaxId();

	/**
	 * 	添加社团联系方式的方法
	 * @param contactInformation
	 * @return
	 */
	public boolean InsertContactInformation(ContactInformation contactInformation);
	
	/**
	 * 	删除社团联系方式的方法
	 * @param contactInformationId
	 * @return
	 */
	public boolean deleteContactInformation(@Param("contactInformationId")Integer contactInformationId);
	
	/**
	 * 	根据序号查找contactInformation
	 * @param contactInformationId
	 * @return
	 */
	public ContactInformation findBycontactInformationId(@Param("contactInformationId")Integer contactInformationId);
	
	/**
	 *	 更新社团联系方式的方法
	 * @param contactInformation
	 * @return
	 */
	public boolean updateContactInformation(ContactInformation contactInformation);
	
	/**
	 * 	查找所有的社团联系方式的方法
	 * @return
	 */
	public List<ContactInformation> findAllContactInformation();
}
