package org.hnist.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.hnist.mapper.ImagesMapper;
import org.hnist.model.Images;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

/**
 * 首页的Service层实现类
 * @author Liuyun 2019/05/28
 *
 */
@Service("IndexService")
@Transactional
public class IndexServiceImpl implements IndexService{

	@Resource
	private ImagesMapper imagesMapper;

	//导入图片的方法
	@Override
	public String InsertImages(Images images, Model model, HttpSession session) {
		// TODO Auto-generated method stub
		return null;
	}

	//更改图片的方法
	@Override
	public String changeImagesStatus(String imageStatus) {
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}

	//删除图片的方法
	@Override
	public String deleteImages(Integer imagesId) {
		try{
			if(imagesMapper.deleteImages(imagesId)){
				return "ok";
			}else{
				return "error";
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "wrong";
	}

	
	//显示所有的图片
	@Override
	public String showAllImages(Model model, HttpSession session) {
		try{
			model.addAttribute("imges",imagesMapper.findAllImage());
			return "/main/imagelist";
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("msg", "服务器请求出错");
		return "/main/imagelist";
	}
		
}
