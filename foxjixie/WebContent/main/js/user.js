
/**
 * 删除用户的方法
 * @param userId
 * @returns
 */
function deleteUser(userId){
	if(window.confirm('确定删除？')){
		$.ajax({
			url:'./deleteUser.do',
			type:'POST',
			data:{
				userId:userId
			},
			success:function(result){
				if(result==0){
					window.confirm('删除成功')
					location.reload()
				}else if(result==1){
					window.confirm('删除失败')
				}else{
					window.confirm('未知错误')
				}
			},
			error:function(){
				window.confirm('后台服务连接错误')
			}
		})
	}
}

/**
 * 显示需要更新的用户序号
 * @param userId
 * @returns
 */
function editUser(userId){
	var form_edit=$('#form_edit');
	
	document.getElementById('user_edit').value=userId,
	form_edit.submit();
}

/**
 * 更新会员信息的方法
 * @returns
 */
function updateUser(){
	var userId=$('#userId').val();
	var userNo=$('#userNo').val();
	var userCount=$('#userCount').val();
	var userName=$('#userName').val();
	var userCollege=$('#userCollege').val();
	
	var telPhone=$('#telPhone').val();
	var email=$('#email').val();
	
	if(userNo.length<=0){
		window.confirm('学号不为空')
	}else if(userCount.length<=0){
		indow.confirm('QQ号不为空')
	}else if(userName.length<=0){
		indow.confirm('姓名不为空')
	}else if(userCollege.length<=0){
		indow.confirm('专业不为空')
	}else if(telPhone.length<=0){
		indow.confirm('电话号码不为空')
	}else if(email.length<=0){
		indow.confirm('班级不为空')
	}else{
		$.ajax({
			url:'./editorUser.do',
			type:'POST',
			data:{
				userId:userId,
				userNo:userNo,
				userCount:userCount,
				userName:userName,
				userCollege:userCollege,
				telPhone:telPhone,
				email:email
			},
			success:function(result){
				if(result==0){
					window.confirm('更改成功')
					location.reload()
				}else if(result==1){
					window.confirm('更改失败 请检查相关属性正确性')
				}else{
					window.confirm('未知错误,请检查专业是否为已存在专业')
				}
			},
			error:function(){
				window.confirm('后台服务连接错误')
			}
		})
		
	}
}


function InsertUserByExcel(){
	var file=document.getElementById('file');
	var files = $('#file').prop('files');
	if (file.files[0] == undefined) {
        alert('未上传任何文件！');
    } else {
    	//获取上传文件的扩展名
        var filevalue = file.value;
        var index = filevalue.lastIndexOf('.');
        var filetype=filevalue.substring(index)
        
        
        var data = new FormData();
        data.append('file', files[0]);
        data.append('fileType',filetype);
        console.log(filetype)
        
        $.ajax({
            type: 'POST',
            url: './uploadExcel.do',
            data: data,
            cache: false,
            processData: false,
            contentType: false,
            success:function(result){
            	if(result=='notfound'){
            		window.confirm('文件保存失败')
            	}else if(result=='error'){
            		window.confirm('文件操作异常')
            	}else{
            		window.confirm('添加成功，总失败导入条数：'+result)
            		location.reload();
            	}
            },
            error:function(){
            	window.confirm('后台连接失败')
            }
        });
    }
    
}

function QueryUser(){
	var querymessage=document.getElementById('querymessage').value;
	if(querymessage.length<=0){
		location.href='findAllUser.do'
	}else{
		document.getElementById('queryMessage').value=querymessage;
		document.getElementById('query_form').submit();
	}
}

function exportExcel(){
	$.ajax({
		url:'./exportExcel.do',
		type:'POST',
		success:function(result){
			if(result=='error'){
				window.confirm('导出失败')
			}else{
				
				var a_exprot=document.getElementById('exprot_excel');
				a_exprot.href=result;
				a_exprot.innerHTML='点击下载excel文件';
			}
		}
	})
}