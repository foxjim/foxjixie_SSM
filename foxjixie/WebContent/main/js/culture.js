
/**
 * 插入社团的方法
 * @returns
 */
function insertCulture(){
	$.ajax({
		url:'./InsertCulture.do',
		type:'POST',
		data:{
			cultureClass:document.getElementById('cultureClass').value,
			cultureTime:document.getElementById('cultureTime').value,
			cultureContent:document.getElementById('cultureContent').value,
			cultureLink:document.getElementById('cultureLink').value
		},
		success:function(result){
			if(result==0){
				window.confirm('导入成功！');
			}else if(result==1){
				window.confirm('导入失败！');
			}else if(result=='error'){
				window.confirm('数据库操作失败！请检查相关项的正确性')
			}
		},
		error:function(){
			window.confirm('后台连接错误')
		}
	})
}

/**
 * 删除社团文化的方法
 * @param cultureId
 * @returns
 */
function deleteCulture(cultureId){
	if(window.confirm('确定删除？')){
		$.ajax({
			url:'deleteCulture.do',
			type:'POST',
			data:{
				cultureId:cultureId
			},
			success:function(result){
				if(result==0){
					window.confirm('删除成功')
					location.reload();
				}else if(result==1){
					window.confirm('删除失败')
				}else if(result=='error'){
					window.confirm('数据库连接错误')
				}
			},
			error:function(){
				window.confirm('服务器连接错误')
			}
		})
	}
}

/**
 * 显示编辑的方法
 * @param cultureId
 * @returns
 */
function editSocietyCulture(cultureId){
	var editCulture=document.getElementById('editCulture');
	document.getElementById('cultureId_input').value=cultureId;
	
	editCulture.submit();
}

/**
 * 更新社团文化的方法
 * @returns
 */
function updateSocietyCulture(){
	$.ajax({
		url:'updateCulture.do',
		type:'POST',
		data:{
			cultureId:document.getElementById('cultureId').value,
			cultureClass:document.getElementById('cultureClass').value,
			cultureTime:document.getElementById('cultureTime').value,
			cultureContent:document.getElementById('cultureContent').value,
			cultureLink:document.getElementById('cultureLink').value
			
		},
		success:function(result){
			if(result==0){
				window.confirm('更新成功')
				location.reload();
			}else if(result==1){
				window.confirm('更新失败，请检查数据的合法性或刷新后重试')
			}else if(result=='error'){
				window.confirm('数据库连接失败')
			}
		},
		error:function(){
			window.confirm('后台服务连接失败')
		}
	})
}


