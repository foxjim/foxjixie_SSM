/**
 * 删除
 * @param collegeId
 * @returns
 */
function deleteCollege(collegeId){
	
	if(window.confirm('确定删除？')){
		$.ajax({
			url:'./deleteCollege.do',
			type:'POST',
			data:{
				collegeId:collegeId
			},
			success:function(result){
				if(result=='0'){
					window.confirm('删除成功！');
					location.reload();
				}else if(result=='1'){
					window.confirm('删除失败');
				}else if(result=='error'){
					window.confirm('删除错误')
				}
			},
			error:function(){
				window.confirm('后台服务连接错误')
			}
		})
	}
	
}

function editCollege(collegeId){
	
	document.getElementById('collegeId').value=collegeId;
	document.getElementById('edit_form').submit();
}

/**
 * 编辑的方法
 * @returns
 */
function editorCollege(){
	
	var collegeId=$("#edit_collegeId").val();
	var collegeNo=$("#edit_collegeNo").val();
	var collegeName=$("#edit_resourceName").val();
	
	if(collegeNo.length<=1 || collegeName.length<=1){
		window.confirm('请将专业编号及名称填写完整')
	}else{
		$.ajax({
			url:'./editorCollege.do',
			type:'POST',
			data:{
				collegeId:collegeId,
				collegeNo:collegeNo,
				collegeName:collegeName
			},
			success:function(result){
				if(result=='0'){
					window.confirm('更新成功');
					location.reload();
				}else if(result=='1'){
					window.confirm('更新失败，请稍后重试');
				}else{
					window.confirm('更新失败，服务连接失败');
				}
			},
			error:function(){
				window.confirm('后台服务连接错误')
			}
		})
	}
	
}

