

/*******************************************
 *
 * 
 * 导入新闻头部信息的方法
 *
 *
 ******************************************/

let nhTitlezz=2;
/**
 * 确定新闻标题的方法
 * @author Liuyun 2019/05/30
 * 
 */
function ensureNhTitle(){
	var nhTitle=document.getElementById('nhTitle');
	var nhTitle_show=document.getElementById('nhTitle_show');
	
	if(nhTitle.value.length<=4){
		nhTitle_show.innerHTML='&nbsp;&nbsp;&nbsp;&nbsp;（新闻标题也太短了吧)';
		nhTitlezz=1;
	}else if(nhTitle.value.length>=64){
		nhTitle_show.innerHTML='&nbsp;&nbsp;&nbsp;&nbsp;（新闻标题也太长了吧)';
		nhTitlezz=1;
	}else{
		nhTitle_show.innerHTML=''
		nhTitlezz=0;
	}
}


let nhPersonzz=2;
/**
 * 确认发布人信息格式
 * @author Liuyun 2019/05/30
 * 
 */
function ensureNhPerson(){
	var nhPerson=document.getElementById('nhPerson');
	var nhPerson_show=document.getElementById('nhPerson_show');
	
	var regNS=/\w+/;
	
	if(nhPerson.value.length<=1){
		nhPerson_show.innerHTML='&nbsp;&nbsp;&nbsp;&nbsp;（姓名也太短了吧)';
		nhPersonzz=1;
	}else if(nhPerson.value.length>8){
		nhPerson_show.innerHTML='&nbsp;&nbsp;&nbsp;&nbsp;（姓名也太长了吧)';
		nhPersonzz=1;
	}else if(regNS.test(nhPerson.value)){
		nhPerson_show.innerHTML='&nbsp;&nbsp;&nbsp;&nbsp;（姓名格式错误)';
		nhPersonzz=1;
	}else{
		nhPerson_show.innerHTML='';
		nhPersonzz=0;
	}
}

/**
 * 选用外部链接
 * @author Liuyun 2019/05/30
 * 
 */
function ensureUserOther(){
	var userOther=document.getElementById('userOther');
	var otherLink=document.getElementById('otherLink');
	var userLink=document.getElementById('userLink');
	
	if(userOther.checked){
		otherLink.readOnly=false;
		otherLink.placeholder='请输入外部链接';
		userLink.value='1';
	}else{
		otherLink.placeholder='若需使用外部链接请勾选上方选框';
		otherLink.readOnly=true;
		userLink.value='0';
	}
}

let ontherLinkzz=2;

/**
 * 
 * 确认外部链接
 * @author Liuyun 2019/05/30
 * 
 */
function ensureOtherLink(){
	var otherLink=document.getElementById('otherLink');
	var otherLink_show=document.getElementById('otherLink_show');

	//判断URL地址的正则表达式为:http(s)?://([\w-]+\.)+[\w-]+(/[\w- ./?%&=]*)?
	//下面的代码中应用了转义字符"\"输出一个字符"/"
	var Expression=/http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/;
	var objExp=new RegExp(Expression);
	
	if(otherLink.value.length>510){
		otherLink_show.innerHTML='&nbsp;&nbsp;&nbsp;&nbsp;（字符串太长)';
		ontherLinkzz=1;
	}else if(objExp.test(otherLink.value)==false){
		otherLink_show.innerHTML='&nbsp;&nbsp;&nbsp;&nbsp;（此字符串不是标准的url)';
		ontherLinkzz=1;
	}else{
		otherLink_show.innerHTML='';
		ontherLinkzz=0;
	}

}

/**
 *	新闻提交
 * @author Liuyun 2019/05/30
 * 
 */
function ensureNewsHead(){
	
	var userOther=document.getElementById('userOther');
	var otherLink=document.getElementById('otherLink');
	
	//初始化添加方法
	if(nhTitlezz==2){
		ensureNhTitle();
	}else if(nhPersonzz==2){
		ensureNhPerson();
	}else if(userOther.checked && ontherLinkzz==2 ){
		ensureOtherLink();
	}
	
	
	if(nhTitlezz==1){
		window.confirm('请输入合法的文章标题');
		return false;
	}else if(nhPersonzz==1){
		window.confirm('请输入合法的发布人');
		return false;
	}else if(userOther.checked){
		if(ontherLinkzz==1){
			window.confirm('请输入合法的外部链接');
			return false;
		}else{
			insertNewsHead();
		}
	}else{
		otherLink.value='0';
		insertNewsHead();
	}
	
}

/**
 * 提交新闻头部
 * @returns
 */
function insertNewsHead(){
	
	$.ajax({
		type:'POST',
		url:'./insertNews.do',
		data:{
			nhClass:document.getElementById('nhClass').value,
			nhTitle:document.getElementById('nhTitle').value,
			nhTime:document.getElementById('nhTime').value,
			nhPerson:document.getElementById('nhPerson').value,
			otherLink:document.getElementById('otherLink').value,
			userLink:document.getElementById('userLink').value
		},
		success:function(result){
			if(result==1){
				window.confirm('导入信息失败');
				
			}else if(result=='error'){
				window.confirm('后台服务程序错误');
			}else{
				
					if(document.getElementById('userLink').value==0){
						window.confirm('导入信息成功');
						document.getElementById('nhId').value=result;
						document.getElementById('insertNews_action').submit();
					}else if(document.getElementById('userLink').value==1){
						window.confirm('导入信息成功');
						
					}
					
				
			}
		},
		error:function(){
			window.confirm('后台数据连接错误');
		}
	})
}

/**
 * 去除所有表单的value值
 * @returns
 */
function clearInputValue(){
	var input=document.getElementsByTagName('input');
	for(let i=0;i<input.length;i++){
		input[i].removeAttribute("readonly")
	}
}


/************************************************************************
 *新闻内容
 ************************************************************************/

/**
 * 更新新闻内容
 * @returns
 */
function updateNewsContent(){
	console.log(ue.getContent()+';')
	$.ajax({
		url:'./updateNewsContent.do',
		type:'POST',
		data:{
			nhId:document.getElementById('nhId').value,
			ncContent:ue.getContent() 
		},
		success:function(result){
			if(result==0){
				window.confirm('更新成功');
			}else if(result==1){
				window.confirm('更新失败');
			}else if(result=='wrong'){
				window.confirm('未知错误233333');
			}
		},
		error:function(){
			window.confirm('后台数据连接错误');
		}
	})
}