/**
 * 添加社团资源的方法
 * @returns
 */
function insertDownload(){
	if(document.getElementById('resourceClass').value.length<=0 || document.getElementById('resourceName').value.length<=0 || document.getElementById('resourceLink').value.length<=0){
		window.confirm('请填写将表单信息填写完整')
	}else{
		$.ajax({
			url:'InsertResource.do',
			type:'POST',
			data:{
				resourceClass:document.getElementById('resourceClass').value,
				resourceName:document.getElementById('resourceName').value,
				resourceLink:document.getElementById('resourceLink').value,
				resourcePassword:document.getElementById('resourcePassword').value
			},
			success:function(result){
				if(result==0){
					window.confirm('添加成功');
				}else if(result==1){
					window.confirm('插入失败，请检查数据格式的正确性');
				}else if(result=='error'){
					window.confirm('数据库连接失败');
				}
			},
			error:function(){
				window.confirm('后台服务连接失败');
			}
		})
	}
	
}

/**
 *	删除数据的方法
 * @param id
 * @returns
 */
function deleteDwonload(id){
	if(window.confirm('确定删除？')){
		$.ajax({
			url:'./deleteResource.do',
			type:'POST',
			data:{
				resourceId:id
			},
			success:function(result){
				if(result==0){
					window.confirm('删除成功');
					location.reload();
				}else if(result==1){
					window.confirm('删除失败，请刷新后重试');
				}else if(result=='error'){
					window.confirm('数据库连接错误');
				}
			},
			error:function(){
				window.confirm('后台服务连接错误');
			}
		})
	}
}

/**
 * 跳转到编辑界面-编辑的方法
 * @param id
 * @returns
 */
function editDownload(id){
	document.getElementById('resourceId_input').value=id;
	document.getElementById('editResource').submit();
}

/**
 * 更新数据的方法
 * @returns
 */
function updateDownload(){
	if(document.getElementById('resourceClass').value.length<=0 || document.getElementById('resourceName').value.length<=0 || document.getElementById('resourceLink').value.length<=0 ){
		window.confirm('请填写好表单项')
	}else{
		$.ajax({
			url:'./updateResource.do',
			type:'POST',
			data:{
				resourceId:document.getElementById('resourceId').value,
				resourceClass:document.getElementById('resourceClass').value,
				resourceName:document.getElementById('resourceName').value,
				resourceLink:document.getElementById('resourceLink').value,
				resourcePassword:document.getElementById('resourcePassword').value,
			},
			success:function(result){
				if(result==0){
					window.confirm('更新成功')
					location.reload();
				}else if(result==1){
					window.confirm('更新失败')
				}else if(result=='error'){
					window.confirm('数据库操作失误，请检查数据的正确性')
				}
			},
			error:function(){
				window.confirm('后台服务连接失败')
			}
		})
	}
}