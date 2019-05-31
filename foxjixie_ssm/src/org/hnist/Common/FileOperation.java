package org.hnist.Common;

import java.io.File;

import org.hnist.model.Images;
/**
 * 文件操作的方法
 * @author Liuyun
 *
 */
public class FileOperation {

	/**
	 * 单个删除文件的方法
	 * @param path	fileUrl+fileName
	 * @return
	 */
	public boolean deleteFile(String path){
		File file=new File(path);
		
		if(file.exists() && file.isFile()){
			file.delete();
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 通过Images对象删除图片的方法
	 * 		主要用在首页图片显示的操作处理上面
	 * @param path		图片路径
	 * @param images	images对象
	 */
	public void deleteImagesFile(String oldString,String NewString,Images images){
		
		//字符串转换
		this.deleteFile(images.getImg01().replace(oldString, NewString));
		this.deleteFile(images.getImg02().replace(oldString, NewString));
		this.deleteFile(images.getImg03().replace(oldString, NewString));
		this.deleteFile(images.getImg04().replace(oldString, NewString));
		this.deleteFile(images.getImg05().replace(oldString, NewString));
	}
	
	/** 
	 * 删除目录（文件夹）以及目录下的文件 
	 * @param   sPath 被删除目录的文件路径 
	 * @return  目录删除成功返回true，否则返回false 
	 */  
	public boolean deleteDirectory(String sPath) {  
	    //如果sPath不以文件分隔符结尾，自动添加文件分隔符  
	    if (!sPath.endsWith(File.separator)) {  
	        sPath = sPath + File.separator;  
	    }  
	    File dirFile = new File(sPath);  
	    //如果dir对应的文件不存在，或者不是一个目录，则退出  
	    if (!dirFile.exists() || !dirFile.isDirectory()) {  
	        return false;  
	    }  
	    boolean flag = true;  
	    //删除文件夹下的所有文件(包括子目录)  
	    File[] files = dirFile.listFiles();  
	    for (int i = 0; i < files.length; i++) {  
	        //删除子文件  
	        if (files[i].isFile()) {  
	            flag = deleteFile(files[i].getAbsolutePath());  
	            
	            //倘若删除失败
	            if (!flag){
	            	break;  
	            }
	        } 
	        //删除子目录  
	        else {  
	            flag = deleteDirectory(files[i].getAbsolutePath()); 
	          //倘若删除失败
	            if (!flag) {
	            	break;  
	            }
	        }  
	    }  
	    if (!flag){
	    	return false;  
	    }
	    //删除当前目录  
	    if (dirFile.delete()) {  
	        return true;  
	    } else {  
	        return false;  
	    }  
	}
	
	
	
	
}
