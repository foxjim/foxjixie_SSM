package org.hnist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.hnist.model.Images;
import org.springframework.stereotype.Repository;

/**
 * 首页图片的 Mapper层接口
 * @author Liuyun
 *
 */
@Repository("ImagesMapper")
@Mapper
public interface ImagesMapper {
		
	/**
	 * 查找最大的图片序号
	 * @return
	 */
	public Integer findMaxImageId();
	
	/**
	 * 将导入的图片路径插入数据库的方法
	 * @param imges
	 * @return
	 */
	public boolean insertImages(Images imges);
	
	/**
	 * 更改图片的显示状态
	 * @param imgStatus
	 * @return
	 */
	public boolean changeImageStatus(Integer imgStatus);
	
	/**
	 * 删除图片的方法
	 * @param imgesId
	 * @return
	 */
	public boolean deleteImages(Integer imgesId);
	
	/**
	 * 查找所有的图片
	 * @return
	 */
	public List<Images> findAllImage();
}
