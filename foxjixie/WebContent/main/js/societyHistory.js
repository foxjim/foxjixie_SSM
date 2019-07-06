


/**
 * 更改显示状态的方法
 * @param societyHistoryId
 * @returns
 */
function editorHistory(societyHistoryId){
	var show_p=document.getElementById('show_p'+societyHistoryId);
	var editor_p=document.getElementById('edit_p'+societyHistoryId);


	show_p.style.display=(show_p.style.display=='none')?'inline':'none';
	editor_p.style.display=(editor_p.style.display=='none')?'inline':'none';

}

/**
 * 删除数据的方法
 * @param societyHistoryId
 * @returns
 */
function deleteHistory(societyHistoryId){
	if(window.confirm('确定删除？')){
		$.ajax({
			url:'./deleteSocietyHistory.do',
			type:'POST',
			data:{
				societyHistoryId:societyHistoryId
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
 * 更新社团历史的方法
 * @param societyHistoryId
 * @returns
 */
function editSocietyHistory(societyHistoryId){
	$.ajax({
		url:'./updateHistory.do',
		type:'POST',
		data:{
			societyHistoryId:societyHistoryId,
			societyHistoryTime:document.getElementById('societyHistoryTime'+societyHistoryId).value,
			societyHistoryContent:document.getElementById('societyHistoryContent'+societyHistoryId).value
		},
		success:function(result){
			if(result==0){
				window.confirm('更新成功');
				location.reload();
			}else if(result==1){
				window.confirm('更新失败');
			}else{
				window.confirm('操作异常');
			}
		},
		error:function(){
			window.confirm('后台服务连接错误')
		}
	})
}

/**
 *	添加社团发展历史的方法
 * @returns
 */
function insertSoceityHistory(){
	var societyHistoryTime=document.getElementById('societyHistoryTime').value
	var societyHistoryContent=document.getElementById('societyHistoryContent').value
	
	if(societyHistoryTime.length<=0 || societyHistoryContent.length<=0){
		window.confirm('请将表单输入完整')
	}else{
		$.ajax({
			url:'./insertSocietyHistory.do',
			type:'POST',
			data:{
				societyHistoryTime:societyHistoryTime,
				societyHistoryContent:societyHistoryContent
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