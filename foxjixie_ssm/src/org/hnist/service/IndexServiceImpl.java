package org.hnist.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hnist.Common.FileOperation;
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
	public String InsertImages(String path,Images images, Model model, HttpSession session) {
		try{
			//设置图片的序号
			Integer maxImgesId=imagesMapper.findMaxImageId();
			if(maxImgesId==null){
				maxImgesId=1;
			}
			
			images.setImgesId(maxImgesId+1);
			
			if(imagesMapper.insertImages(images)){
				model.addAttribute("msg", "导入成功");
				return "redirect:/main/InsertImages.jsp";
			}else{
				
				//删除图片
				FileOperation fileOperation=new FileOperation();
				fileOperation.deleteImagesFile(path,images);
				
				
				model.addAttribute("msg", "导入失败 请稍后重试");
				return "redirect:/main/InsertImages.jsp";
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("msg", "导入失败 请稍后重试");
		return "redirect:/main/InsertImages.jsp";
	}

	//更改图片的方法
	@Override
	public String changeImagesStatus(Integer imgesId) {
		try{
			boolean flag=true;
			List<Images> imagess=imagesMapper.findAllShowImage();
			
			//将要首页显示的图片置为不启用显示
			for(int i=0;i<imagess.size();i++){
				if(imagesMapper.changeImageStatus(imagess.get(i).getImgesId(), 0)==false){
					flag=false;
					break;
				}
			}
			
			//假如导入失败
			if(flag==false){
				return "error";
			}else{
				if(imagesMapper.changeImageStatus(imgesId, 1)){
					return "ok";
				}else{
					return "error";
				}
			}			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "wrong";
	}

	//删除图片的方法
	@Override
	public String deleteImages(String path,Integer imagesId) {
		try{
			
			Images images=imagesMapper.findByImagesId(imagesId);
			
			if(imagesMapper.deleteImages(imagesId)){
				
				//删除文件
				FileOperation fileOperation=new FileOperation();
				fileOperation.deleteImagesFile(path,images);
				
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

	
	//首页显示图片
	@Override
	public String showIndexImages(Model model, HttpSession session) {
		
		//初始化images  当数据库查找失败时，返回系统默认路径的图片
		Images images=new Images();
		images.setImg01("./img/img1.jpg");
		images.setImg02("./img/img2.jpg");
		images.setImg03("./img/img3.jpg");
		images.setImg04("./img/img4.jpg");
		images.setImg05("./img/img5.jpg");
		
		try{
			List<Images> imagess=imagesMapper.findAllShowImage();
			if(imagess.size()<=0){
				model.addAttribute("images", images);
				return "/front/index";
			}else{
				model.addAttribute("images", imagess.get(0));
				return "/front/index";
			}
				
			
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("images", images);
		return "/front/index";
	}

}
