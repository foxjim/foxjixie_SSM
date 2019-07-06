/**
 * 添加社团成员的方法
 * @returns
 */
function insertSocietyNumber(){
	var societyNumberDepartment=document.getElementById('societyNumberDepartment').value;
	var societyNumberOldMember=document.getElementById('societyNumberOldMember').value;
	var societyNumberYoungerMember=document.getElementById('societyNumberYoungerMember').value;
	
	if(societyNumberDepartment.length<=1 ){
		window.confirm('部门名称太短了');
	}else if(societyNumberOldMember.length<=1){
		window.confirm('部长太短了');
	}else{
		$.ajax({
			url:'./insertSocietyNumber.do',
			type:'POST',
			data:{
				societyNumberDepartment:societyNumberDepartment,
				societyNumberOldMember:societyNumberOldMember,
				societyNumberYoungerMember:societyNumberYoungerMember
			},
			success:function(result){
				if(result==0){
					window.confirm('导入成功');
					location.reload();
				}else if(result==1){
					window.confirm('请检查导入数据的合法性');
				}else{
					window.confirm('数据操作错误');
				}
			},
			error:function(){
				window.confirm('后台服务连接错误');
			}
			
			
		})
		
		
	}
}

/**
 * 删除社团成员的方法
 * @param societyNumberId
 * @returns
 */
function deleteSocietyNumber(societyNumberId){
	if(window.confirm('确定删除？')){
		$.ajax({
			url:'./deleteSocietyNumber.do',
			type:'POST',
			data:{
				societyNumberId:societyNumberId
			},
			success:function(result){
				if(result==0){
					window.confirm('删除成功');
					location.reload();
				}else if(result==1){
					window.confirm('删除失败，请刷新后重试');
				}else{
					window.confirm('数据操作错误');
				}
			},
			error:function(){
				window.confirm('后台服务连接错误');
			}
		})
	}
}

/**
 * 编辑社团成员界面
 * @param societyNumberId
 * @returns
 */
function editSocietyNumber(societyNumberIdzz){
	var edit_form=document.getElementById('edit_form');
	var societyNumberId=document.getElementById('societyNumberId');
	
	societyNumberId.value=societyNumberIdzz;
	edit_form.submit();
}

/**
 * 更新社团成员数据的方法
 * @returns
 */
function editorSoceityNumber(){
	var societyNumberId=document.getElementById('societyNumberId').value;
	var societyNumberDepartment=document.getElementById('societyNumberDepartment').value;
	var societyNumberOldMember=document.getElementById('societyNumberOldMember').value;
	var societyNumberYoungerMember=document.getElementById('societyNumberYoungerMember').value;
	
	if(societyNumberDepartment.length<=1){
		window.confirm('部门名称太短')
	}else if(societyNumberOldMember.length<=1){
		window.confirm('部长名称太短')
	}else{
		$.ajax({
			url:'./updateSocietyNumber.do',
			type:'POST',
			data:{
				societyNumberId:societyNumberId,
				societyNumberDepartment:societyNumberDepartment,
				societyNumberOldMember:societyNumberOldMember,
				societyNumberYoungerMember:societyNumberYoungerMember
			},
			success:function(result){
				if(result==0){
					window.confirm('更新成功');
					location.reload();
				}else if(result==1){
					window.confirm('更新失败，请刷新后重试');
				}else{
					window.confirm('数据操作错误');
				}
			},
			error:function(){
				window.confirm('后台服务连接错误');
			}
		})
	}
	
}
