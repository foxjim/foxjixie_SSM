package org.hnist.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.hnist.mapper.SocietyNumberMapper;
import org.hnist.model.SocietyNumber;
import org.hnist.model.SocietyNumberList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.mysql.jdbc.Connection;
import com.sun.org.apache.xml.internal.security.Init;
/**
 * 	社团成员的Service层实现类
 * @author Liuyun
 *
 */
@Service("societyNumberService")
@Transactional
public class SocietyNumberServiceImpl implements SocietyNumberService{
	
		@Resource
		private SocietyNumberMapper societyNumberMapper;

		//添加社团成员的方法
		@Override
		public String InsertSocietyNumber(SocietyNumber societyNumber) {
			try {
				Integer societyNumberId=societyNumberMapper.findMaxId();
				if(societyNumberId==null) {
					societyNumberId=0;
				}
				societyNumber.setSocietyNumberId(societyNumberId+1);
				
				if(societyNumberMapper.insertSocietyNumber(societyNumber)) {
					return "0";
				}else {
					return "1";
				}
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return "error";
		}

		//删除社团成员
		@Override
		public String deleteSocietyNumber(Integer societyNumberId) {
			try {
				if(societyNumberMapper.deleteSocietyNumber(societyNumberId)) {
					return "0";
				}else {
					return "1";
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return "error";
		}

		//通过序号查找社团成员
		@Override
		public String findBySocietyId(Integer societyNumberId,Model model,HttpSession session) {
			try {
				model.addAttribute("societyNumber", societyNumberMapper.findSocietyNumberById(societyNumberId));
				return "0";
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return "error";
		}

		//更新社团成员的方法
		@Override
		public String updateSocietyNumber(SocietyNumber societyNumber) {
			try {
				
				if(societyNumberMapper.updateSocietyNumber(societyNumber)) {
					return "0";
				}else {
					return "1";
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return "error";
		}

		//通过任届查找社团成员的方法
		@Override
		public String findBySocietyNumberByTerm(String societyNumberTerm, Model model, HttpSession session) {
			try {
				
				model.addAttribute("societyNumbers", societyNumberMapper.findBySocietyNumberTerm(societyNumberTerm));
				return "0";
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return "error";
		}

		//查找所有的社团成员
		@Override
		public String findAllSocietyNumber(Model model,HttpSession session) {
			try {
				List<SocietyNumberList> societyNumberLists=new ArrayList<SocietyNumberList>();
				SocietyNumberList societyNumberList;
				
				List<String> societyNumberTerms=societyNumberMapper.findAllSocietyNumberTerm();
				
				for(int i=0;i<societyNumberTerms.size();i++) {
					societyNumberList=new SocietyNumberList();
					societyNumberList.setSocietyNumberTerm(societyNumberTerms.get(i));
					societyNumberList.setSocietyNumbers(societyNumberMapper.findBySocietyNumberTerm(societyNumberTerms.get(i)));
					
					societyNumberLists.add(societyNumberList);
				}
				Collections.reverse(societyNumberLists);
				model.addAttribute("societyNumberLists", societyNumberLists);
				
				return "0";
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return "error";
		}
		
		
		
}
