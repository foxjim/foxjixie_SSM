package org.hnist.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.hnist.mapper.SocietyHistoryMapper;
import org.hnist.model.SocietyHistory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
/**
 * 社团历史的Service层实现类
 * @author Liuyun 2019/06/21
 *
 */
@Service("societyHistoryService")
@Transactional
public class SocietyHistoryServiceImpl implements SocietyHistoryService{
	
	
	@Resource
	private SocietyHistoryMapper societyHistoryMapper;
	
	//导入社团历史的方法
	@Override
	public String insertSocietyHistory(SocietyHistory societyHistory) {
		try {
			Integer societyHistoryId=societyHistoryMapper.findMaxId();
			if(societyHistoryId==null) {
				societyHistoryId=0;
			}
			
			societyHistory.setSocietyHistoryId(societyHistoryId+1);
			
			if(societyHistoryMapper.insertSocietyHistory(societyHistory)) {
				return "0";
			}else {
				return "1";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "error";
	}

	//删除社团历史的方法
	@Override
	public String deleteSocietyHistory(Integer societyHistoryId) {
		try {
			if(societyHistoryMapper.deleteSocietyHistory(societyHistoryId)) {
				return "0";
			}else {
				return "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "error";
	}

	//通过id号查找社团历史的方法
	@Override
	public String findSocietyHistoryById(Integer societyHistoryId,Model model,HttpSession session) {
		try {
			model.addAttribute("societyHistory", societyHistoryMapper.findBySocietyHistoryId(societyHistoryId));
			return "0";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "error";
	}

	//更新社团历史的方法
	@Override
	public String updateSocietyHistory(SocietyHistory societyHistory) {
		try {
			if(societyHistoryMapper.updateSocietyHistory(societyHistory)) {
				return "0";
			}else {
				return "1";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "error";
	}

	//查找所有的社团历史
	@Override
	public String findAllSocietyHistory(Model model, HttpSession session) {
		try {
			model.addAttribute("societyHistorys", societyHistoryMapper.findAllSocietyHistory());
			return "0";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "error";
	}
}
