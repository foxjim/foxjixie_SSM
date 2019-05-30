
/**
 * 设置为图片组为首页展示图片
 * @param imgesId  图片的序号Id
 */
function setIndexUser(imagesId){
	//状态值
	var imgesStatus=document.getElementById(imagesId+'Status');
	
	//显示是否启用
	var imgesUser=document.getElementById(imagesId+'user');
	
	if(imgesStatus.value=='0'){
		$.ajax({
			url:'./setImageStatus.do',
			type:'POST',
			data:{
				imgesId:imagesId
			},
			success:function(result){
				if(result=='error'){
					window.confirm('程序错误，设置失败');
				}else if(result=='ok'){
					window.history.go(0);
					window.confirm('设置成功');
				}else if(result=='wrong'){
					window.confirm('未知服务器错误，设置失败');
				}else{
					window.confirm('未知错误，设置失败');
				}
			},
			error:function(){
				window.confirm('程序错误，设置失败');
			}
		})
	}else if(imgesStatus.value=='1'){
		window.confirm('已启用');
	}
}

/**
 * 删除图片组的方法
 * @param imagesId  图片的序号Id
 */
function deleteImages(imagesId){
	//整列tr
	var imagespic=document.getElementById(imagesId+'pic');
	
	if(window.confirm("确定删除此组图片")){
		$.ajax({
			url:'./deleteImages.do',
			type:'POST',
			data:{
				imgesId:imagesId
			},
			success:function(result){
				if(result=='error'){
					window.confirm('程序错误，删除失败');
				}else if(result=='ok'){
					imagespic.parentNode.removeChild(imagespic);
					window.confirm('删除成功');
				}else if(result=='wrong'){
					window.confirm('未知服务器错误，删除失败');
				}else{
					window.confirm('未知错误，删除失败');
				}
			},
			error:function(){
				window.confirm("删除失败，请稍后重试");
			}
		})
	}
}