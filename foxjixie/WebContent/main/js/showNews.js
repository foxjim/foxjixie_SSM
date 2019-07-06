 

/**
 * 删除新闻的方法
 * @param newsId
 * @returns
 */
function deleteNews(newsId){
	var newsTr=document.getElementById(newsId+'z');
	var td01=document.getElementById(newsId+'zz');
	console.log(newsId)
	
	if(window.confirm('确定删除序号为：'+td01.value+' 的新闻吗？')){
		$.ajax({
			url:'deleteNews.do',
			type:'POST',
			data:{
				nhId:newsId
			},
			success:function(result){
				if(result==0){
					
					if(window.confirm('删除成功')){
						location.reload();
					}			 
				}else if(result==1){
					window.confirm('删除失败');
				          
				}else if(result=="error"){
					window.confirm('数据库连接失败');
				}
			},
			error:function(){
				window.confirm('后台服务连接错误！删除失败');
			}
		})
	}
	
}

/**
 * 编辑新闻的方法
 * @returns
 */
function editorNews(){
	
}

/**
 * 设置使用链接的方法
 * @param userlink
 * @returns
 */
function setUserLink(setuserlink,nhId){
	var userLink=document.getElementById('userLink_id'+nhId).value;
	if(setuserlink==userLink){
		window.confirm('重复设置');
	}else{
		$.ajax({
			url:'updateUserLink.do',
			type:'POST',
			data:{
				nhId:nhId,
				userLink:setuserlink
			},
			success:function(result){
				if(result=='error'){
					window.confirm('数据库连接错误')
				}else if(result='0'){
					window.confirm('更改成功')
					location.reload();
				}else if(result='1'){
					window.confirm('更改失败')
				}
			},
			error:function(){
				window.confirm('后台服务连接失败');
			}
		})
		
	}
}

/**
 * 更新新闻的方法
 * @returns
 */
function updateNewsHead(){
	$.ajax({
		url:'updateNews.do',
		type:'POST',
		data:{
			nhId:document.getElementById('nhId').value,	
			nhClass:document.getElementById('nhClass').value,	
			nhTitle:document.getElementById('nhTitle').value,	
			nhTime:document.getElementById('nhTime').value,	
			nhPerson:document.getElementById('nhPerson').value,	
			otherLink:document.getElementById('otherLink').value,	
			userLink:document.getElementById('userLink').value,	
		},
		success:function(result){
			if(result==0){
				window.confirm('更新成功！');
				location.reload();
			}else if(result==1){
				window.confirm('更新失败！');
			}else if(result=='error'){
				window.confirm('数据库异常');
			}
		},
		error:function(){
			window.confirm('后台数据连接失败')
		}
	})
}