package org.hnist.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.hnist.mapper.CultureMapper;
import org.hnist.model.Culture;
import org.hnist.model.SocietyCultureList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

@Transactional
@Service("CultureService")
public class CultureServiceImpl implements CultureService{
	
	@Resource
	private CultureMapper cultureMapper;

	//添加社团文化的方法
	@Override
	public String InsertCulture(Culture culture) {
		try {
			Integer cultureId=cultureMapper.findMaxCultureId();
			if(cultureId==null) {
				cultureId=0;
			}
			culture.setCultureId(cultureId+1);
			
			if(cultureMapper.insertCulture(culture)) {
				return "0";
			}else {
				return "1";
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "error";
	}

	
	//删除社团文化的方法
	@Override
	public String deleteCultureById(Integer cultureId) {
		try {
			
			if(cultureMapper.deleteCultureById(cultureId)) {//删除成功
				return "0";
			}else {			//删除失败
				return "1";
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "error";
	}

	//更改社团文化的方法
	@Override
	public String updateCulture(Culture culture) {
		try {
			
			if(cultureMapper.editorCulture(culture)) {
				return "0";
			}else {
				return "1";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	//通过年级号（任届）查找所有的社团文化
	@Override
	public String findByGrade(String cultureGrade,Model model,HttpSession session) {
		try {
			List<SocietyCultureList> cultureLists=new ArrayList<SocietyCultureList>();
			List<String> cultureClasss=cultureMapper.findAllCultureClass();
			SocietyCultureList societyCultureList;
			
			for(int i=0;i<cultureClasss.size();i++) {
				societyCultureList=new SocietyCultureList();
				societyCultureList.setCultureClass(cultureClasss.get(i));
				societyCultureList.setCultures(cultureMapper.findByCultureClassGrade(cultureClasss.get(i),cultureGrade));
				
				cultureLists.add(societyCultureList);
			}
			model.addAttribute("scllist", cultureLists);
			return "/main/SocietyCultureList";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("message", "数据库获取失败");
		return "/main/SocietyCultureList";
	}

	//通过序号查找所有的社团文化
	@Override
	public String findByCultureId(Integer cultureId, Model model, HttpSession session) {
		try {
			model.addAttribute("societyCulture", cultureMapper.findByCultureId(cultureId));
			return "/main/editSocietyCulture";
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("message", "数据库访问失败");
		return "/main/editSocietyCulture";
	}

	//查找所有的社团文化-页面显示
	@Override
	public String findAllSocietyCultures(Model model, HttpSession session) {
		try {
			List<SocietyCultureList> cultureLists=new ArrayList<SocietyCultureList>();
			List<String> cultureClasss=cultureMapper.findAllCultureClass();
			SocietyCultureList societyCultureList;
			
			for(int i=0;i<cultureClasss.size();i++) {
				societyCultureList=new SocietyCultureList();
				societyCultureList.setCultureClass(cultureClasss.get(i));
				societyCultureList.setCultures(cultureMapper.findByCultureClass(cultureClasss.get(i)));
				
				cultureLists.add(societyCultureList);
			}
			model.addAttribute("scllist", cultureLists);
			return "/front/culture";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("message", "数据库获取失败");
		return "/front/culture";
	}

}
