/**
 * 判断第一个插入的图片是否符合规定
 * @author Liuyun 2019/05/30
 */
function insertImages01(){
	var insertImage=document.getElementById('insertImage01');
	
	//获取文件后缀
	var imghz=insertImage.value.substring(insertImage.value.lastIndexOf(".")+1);
	if(imghz !='jpg' && imghz !='png' && imghz !='gif'){
		insertImage.value='';
		window.confirm('请选择正确的文件（jpg、png、gif）');
	}
}

/**
 * 判断第二个插入的图片是否符合规定
 * @author Liuyun 2019/05/30
 */
function insertImages02(){
	var insertImage=document.getElementById('insertImage02');
	
	//获取文件后缀
	var imghz=insertImage.value.substring(insertImage.value.lastIndexOf(".")+1);
	if(imghz !='jpg' && imghz !='png' && imghz !='gif'){
		insertImage.value='';
		window.confirm('请选择正确的文件（jpg、png、gif）');
	}
}
/**
 * 判断第三个插入的图片是否符合规定
 * @author Liuyun 2019/05/30
 */
function insertImages03(){
	var insertImage=document.getElementById('insertImage03');
	
	//获取文件后缀
	var imghz=insertImage.value.substring(insertImage.value.lastIndexOf(".")+1);
	if(imghz !='jpg' && imghz !='png' && imghz !='gif'){
		insertImage.value='';
		window.confirm('请选择正确的文件（jpg、png、gif）');
	}
}
/**
 * 判断第四个插入的图片是否符合规定
 * @author Liuyun 2019/05/30
 */
function insertImages04(){
	var insertImage=document.getElementById('insertImage04');
	
	//获取文件后缀
	var imghz=insertImage.value.substring(insertImage.value.lastIndexOf(".")+1);
	if(imghz !='jpg' && imghz !='png' && imghz !='gif'){
		insertImage.value='';
		window.confirm('请选择正确的文件（jpg、png、gif）');
	}
}
/**
 * 判断第五个插入的图片是否符合规定
 * @author Liuyun 2019/05/30
 */
function insertImages05(){
	var insertImage=document.getElementById('insertImage05');
	
	//获取文件后缀
	var imghz=insertImage.value.substring(insertImage.value.lastIndexOf(".")+1);
	if(imghz !='jpg' && imghz !='png' && imghz !='gif'){
		insertImage.value='';
		window.confirm('请选择正确的文件（jpg、png、gif）');
	}
}
