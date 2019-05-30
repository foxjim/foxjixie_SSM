package org.hnist.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hnist.model.ImageFile;
import org.hnist.model.Images;
import org.hnist.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 首页展示的controller层
 * @author Liuyun 2018/05/28
 *
 */
@Controller
public class IndexController {
	
	
	@Autowired
	private IndexService indexService;
	
	/**
	 * 显示所有的图片列表
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/main/queryAllPictures")
	public String queryAllImage(Model model,HttpSession session){
		return indexService.showAllImages(model, session);
	}
	
	/**
	 * 更改图片的使用状态
	 * @param imgStatus
	 * @param imgesId
	 * @return
	 */
	@RequestMapping("/main/changeImgStatus")
	@ResponseBody
	public String changeImgStatus(@RequestParam("imgStatus")String imgStatus,
								  @RequestParam("imgesId")Integer imgesId){
		return null;
	}
	
	/**
	 * 添加图片的方法
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/main/InsertPictures")
	public String insertImages(@ModelAttribute ImageFile imgeFile,Model model,HttpSession session,HttpServletRequest req)throws Exception{
		
		try{
			//获取系统路径
			String path=req.getSession().getServletContext().getRealPath("/");
			path=path.replace("foxjixie_ssm", "");
			path=path.substring(0, path.length()-1);
			//获取时间
			Date date=new Date();
			SimpleDateFormat sdf = new SimpleDateFormat ("HHmmss");
			sdf.format(date);
			
			//保存文件名-总
			String totalFileName=sdf.format(date);
			
			
			//保存的路径
			String filepath=path+
							"upload"+File.separator+
							(date.getYear()+1)+ File.separator+
							(date.getMonth()+1)+File.separator+
							(date.getDate())+File.separator;
			
			//图片在页面显示的相对路径
			String imageUrl=filepath.replace(path, "../../../");
			SimpleDateFormat sdfimage = new SimpleDateFormat ("yyyy-MM-dd HH:MM");
			//System.out.println("path:"+filepath);
			//初始化Images对象
			Images images=new Images();
			images.setImg01(imageUrl+"01"+totalFileName+imgeFile.getImge01().getOriginalFilename());
			images.setImg02(imageUrl+"02"+totalFileName+imgeFile.getImge02().getOriginalFilename());
			images.setImg03(imageUrl+"03"+totalFileName+imgeFile.getImge03().getOriginalFilename());
			images.setImg04(imageUrl+"04"+totalFileName+imgeFile.getImge04().getOriginalFilename());
			images.setImg05(imageUrl+"05"+totalFileName+imgeFile.getImge05().getOriginalFilename());
			images.setImgTime(sdfimage.format(date));
			//逐个保存文件
			File file01=new File(filepath,"01"+totalFileName+imgeFile.getImge01().getOriginalFilename());
			if(!file01.exists() ){
				file01.mkdirs();
			}
			imgeFile.getImge01().transferTo(file01);
			
			File file02=new File(filepath,"02"+totalFileName+imgeFile.getImge02().getOriginalFilename());
			if(!file02.exists()){
				imgeFile.getImge02().transferTo(file02);
			}
			
			File file03=new File(filepath,"03"+totalFileName+imgeFile.getImge03().getOriginalFilename());
			if(!file03.exists()){
				imgeFile.getImge03().transferTo(file03);
			}
			
			File file04=new File(filepath,"04"+totalFileName+imgeFile.getImge04().getOriginalFilename());
			if(!file04.exists()){
				imgeFile.getImge04().transferTo(file04);
			}
			
			File file05=new File(filepath,"05"+totalFileName+imgeFile.getImge05().getOriginalFilename());
			if(!file05.exists()){
				imgeFile.getImge05().transferTo(file05);
			}
			
			return indexService.InsertImages(path,images, model, session);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		model.addAttribute("msg", "文件保存失败 请稍后重试");
		return "redirect:/main/InsertImages.jsp";
	}
	
	/**
	 * 首页显示图片
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/front/Index")
	public String Index(Model model,HttpSession session){
		return indexService.showIndexImages(model, session);
	}
	
	/**
	 * 更改首页显示的图片
	 * @param imgesId
	 * @return
	 */
	@RequestMapping("/main/setImageStatus")
	@ResponseBody
	public String setImageStatus(@RequestParam("imgesId")Integer imgesId){
		return indexService.changeImagesStatus(imgesId);
	}
	
	/**
	 * 删除图片的方法
	 * @param imgesId
	 * @return
	 */
	@RequestMapping("/main/deleteImages")
	@ResponseBody
	public String deleteImages(@RequestParam("imgesId")Integer imgesId,HttpServletRequest request){
		//获取系统路径
		String path=request.getSession().getServletContext().getRealPath("/");
		path=path.replace("foxjixie_ssm", "");
		path=path.substring(0, path.length()-1);
		
		return indexService.deleteImages(path,imgesId);
	}
}
