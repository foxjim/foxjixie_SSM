package org.hnist.service;

import javax.servlet.http.HttpSession;

import org.hnist.model.Images;
import org.springframework.ui.Model;

/**
 * 首页的Service层接口
 * @author Liuyun	2019/05/28
 *
 */
public interface IndexService {

	/**
	 * 导入图片的方法
	 * @param images
	 * @param model
	 * @param session
	 * @return
	 */
	public String InsertImages(Images images,Model model,HttpSession session);
	
	/**
	 * 更改图片的方法
	 * @param imageStatus
	 * @return
	 */
	public String changeImagesStatus(String imageStatus);
	
	/**
	 * 删除图片的方法
	 * @param imagesId	图片序号
	 * @return
	 */
	public String deleteImages(Integer imagesId);
	
	/**
	 * 显示所有的图片
	 * @param model
	 * @param session
	 * @return
	 */
	public String showAllImages(Model model,HttpSession session);
}
