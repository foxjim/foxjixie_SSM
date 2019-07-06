package org.hnist.service;

import javax.servlet.http.HttpSession;

import org.hnist.model.ContactInformation;
import org.springframework.ui.Model;

/**
 *	 联系我们的Service层接口
 * @author Liuyun
 *
 */
public interface ContactInformationService {
	
	/**
	 * 	添加社团联系方式的方法
	 * @param contactInformation
	 * @return
	 */
	public String InsertContactInformation(ContactInformation contactInformation);
	
	/**
	 * 	删除社团联系方式的方法
	 * @param contactInformationId
	 * @return
	 */
	public String deleteContactInformation(Integer contactInformationId);
	
	/**
	 * 	通过序号查找联系方式
	 * @param contactInformationId
	 * @param model		contactInformation
	 * @param session
	 * @return
	 */
	public String findByContactInformationId(Integer contactInformationId,Model model,HttpSession session);
	
	/**
	 * 	更新社团联系方式的方法
	 * @param contactInformation
	 * @return
	 */
	public String updateContactInformation(ContactInformation contactInformation);
	
	/**
	 * 	查找所有的社团联系方式
	 * @param model	contactInformations
	 * @param session
	 * @return
	 */
	public String findAllContactInformation(Model model,HttpSession session);
}
