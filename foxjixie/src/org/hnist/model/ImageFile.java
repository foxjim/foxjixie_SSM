package org.hnist.model;

import org.springframework.web.multipart.MultipartFile;
/**
 * 上传图片文件的实体类
 * @author Liuyun	2019/05/28
 *
 */
public class ImageFile {
	private  MultipartFile imge01;
	private  MultipartFile imge02;
	private  MultipartFile imge03;
	private  MultipartFile imge04;
	private  MultipartFile imge05;
	
	
	public MultipartFile getImge01() {
		return imge01;
	}
	public void setImge01(MultipartFile imge01) {
		this.imge01 = imge01;
	}
	public MultipartFile getImge02() {
		return imge02;
	}
	public void setImge02(MultipartFile imge02) {
		this.imge02 = imge02;
	}
	public MultipartFile getImge03() {
		return imge03;
	}
	public void setImge03(MultipartFile imge03) {
		this.imge03 = imge03;
	}
	public MultipartFile getImge04() {
		return imge04;
	}
	public void setImge04(MultipartFile imge04) {
		this.imge04 = imge04;
	}
	public MultipartFile getImge05() {
		return imge05;
	}
	public void setImge05(MultipartFile imge05) {
		this.imge05 = imge05;
	}
	
	
}
