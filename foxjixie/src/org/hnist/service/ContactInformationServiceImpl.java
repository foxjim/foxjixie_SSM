package org.hnist.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.hnist.mapper.ContactInformationMapper;
import org.hnist.model.ContactInformation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

/**
 *	 联系我们Service层实现类
 * @author Liuyun
 *
 */
@Service("contactInformationService")
@Transactional
public class ContactInformationServiceImpl implements ContactInformationService{
		
	@Resource
	private ContactInformationMapper contactInformationMapper;

	//添加社团联系方式的方法
	@Override
	public String InsertContactInformation(ContactInformation contactInformation) {
		try {
			Integer contactInformationId=contactInformationMapper.findMaxId();
			if(contactInformationId==null) {
				contactInformationId=0;
			}
			
			contactInformation.setContactInformationId(contactInformationId+1);
			if(contactInformationMapper.InsertContactInformation(contactInformation)) {
				return "0";
			}else {
				return "1";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	//删除社团联系方式的方法
	@Override
	public String deleteContactInformation(Integer contactInformationId) {
		try {
			if(contactInformationMapper.deleteContactInformation(contactInformationId)) {
				return "0";
			}else {
				return "1";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	//通过序号查找联系方式
	@Override
	public String findByContactInformationId(Integer contactInformationId, Model model, HttpSession session) {
		try {
			model.addAttribute("contactInformation", contactInformationMapper.findBycontactInformationId(contactInformationId));
			return "0";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	//更新社团联系方式的方法
	@Override
	public String updateContactInformation(ContactInformation contactInformation) {
		try {
			if(contactInformationMapper.updateContactInformation(contactInformation)) {
				return "0";
			}else {
				return "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	//查找所有的社团联系方式
	@Override
	public String findAllContactInformation(Model model, HttpSession session) {
		try {
			model.addAttribute("contactInformations", contactInformationMapper.findAllContactInformation());
			return "0";
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
	
	
}
