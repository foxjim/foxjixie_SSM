
/**
 * 添加联系方式的方法
 * @returns
 */
function InsertContactInformation(){
	var contactInformationName=document.getElementById('contactInformationName').value;
	var contactInformationContant=document.getElementById('contactInformationContant').value;
	
	
	if(contactInformationName.length<=1){
		window.confirm('联系方式长度太短')
	}else if(contactInformationContant.length<=1){
		window.confirm('联系内容长度太短')
	}else{
		$.ajax({
			url:'./insertContactInformation.do',
			type:'POST',
			data:{
				contactInformationName:contactInformationName,
				contactInformationContant:contactInformationContant
			},
			success:function(result){
				if(result==0){
					window.confirm('导入成功');
					location.reload();
				}else if(result==1){
					window.confirm('导入失败，请检查表单正确性');
				}else{
					window.confirm('操作异常');
				}
			},
			error:function(){
				window.confirm('后台服务连接错误')
			}
		})
	}
}

/**
 * 删除社团联系方式的方法
 * @param contactInformationId
 * @returns
 */
function deleteContactInformation(contactInformationId){
	if(window.confirm('确定删除？')){
		$.ajax({
			url:'./deleteContactInformation.do',
			type:'POST',
			data:{
				contactInformationId:contactInformationId
			},
			success:function(result){
				if(result==0){
					window.confirm('删除成功');
					location.reload();
				}else if(result==1){
					window.confirm('删除失败');
				}else{
					window.confirm('操作异常');
				}
			},
			error:function(){
				window.confirm('后台服务连接错误')
			}
		})
	}
}

/**
 * 显示编辑界面的方法
 * @param contactInformationId
 * @returns
 */
function editContactInformation(contactInformationId){
	var edit_form=document.getElementById('edit_form');
	var contactInformationIdzz=document.getElementById('contactInformationId');
	
	contactInformationIdzz.value=contactInformationId;
	edit_form.submit();
	
}

/**
 * 提交修改
 * @returns
 */
function submiteditContactInformation(){
	var contactInformationId=document.getElementById('contactInformationId').value;
	var contactInformationName=document.getElementById('contactInformationName').value;
	var contactInformationContant=document.getElementById('contactInformationContant').value;
	
	if(contactInformationName.length<=1){
		window.confirm('联系方式长度太短')
	}else if(contactInformationContant.length<=1){
		window.confirm('联系内容长度太短')
	}else{
		$.ajax({
			url:'./updateContactInformation.do',
			type:'POST',
			data:{
				contactInformationId:contactInformationId,
				contactInformationName:contactInformationName,
				contactInformationContant:contactInformationContant
			},
			success:function(result){
				if(result==0){
					window.confirm('编辑成功');
					location.reload();
				}else if(result==1){
					window.confirm('编辑失败，请检查表单正确性');
				}else{
					window.confirm('操作异常');
				}
			},
			error:function(){
				window.confirm('后台服务连接错误')
			}
		})
	}
	
}