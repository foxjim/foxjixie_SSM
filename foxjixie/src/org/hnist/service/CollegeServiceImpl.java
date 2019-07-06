package org.hnist.service;

import javax.annotation.Resource;

import org.hnist.mapper.CollegeMapper;
import org.hnist.mapper.UserMapper;
import org.hnist.model.College;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

@Service("collegeService")
@Transactional
public class CollegeServiceImpl implements CollegeService {

	@Resource
	private CollegeMapper collegeMapper;
	
	@Resource
	private UserMapper userMapper;

	// 导入学院
	@Override
	public String InsertCollege(College college) {
		try {
			
			Integer collegeId=collegeMapper.findMaxCollegeId();
			if(collegeId == null) {
				collegeId=0;
			}
			
			college.setCollegeId(collegeId+1);
			
			if(collegeMapper.InsertCollege(college)) {
				return "success";
			}else {
				return "false";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "error";
	}

	// 通过Id删除专业
	@Override
	public String deleteCollegeById(Integer collegeId) {
		try {
			
			if(collegeMapper.deleteCollege(collegeId)) {
			
					return "0";
				
			}else {
				
				return "1";
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "error";
	}

	// 通过Id查找专业
	@Override
	public String findById(Integer collegeId, Model model) {
		try {
			
			model.addAttribute("college", collegeMapper.findById(collegeId));
			return "0";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "error";
	}

	// 更新专业的方法
	@Override
	public String updateCollege(College college) {
		try {
			
		
			if(collegeMapper.updateCollege(college)) {
				String userCollegeString=college.getCollegeName();
				userMapper.updateCollegeByCollege(collegeMapper.findNameById(college.getCollegeId()), userCollegeString);
				
				return "0";
			}else {
				return "1";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "error";
	}

	// 查找所有的专业
	@Override
	public String findAllCollege(Model model) {
		try {
			
			model.addAttribute("colleges", collegeMapper.findAllCollege());
			
			return "0";

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "error";
	}

}
