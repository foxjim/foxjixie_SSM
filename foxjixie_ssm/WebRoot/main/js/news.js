

/*******************************************
 *
 * 
 * 导入新闻头部信息的方法
 *
 *
 ******************************************/

let nhTitlezz=1;
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


let nhPersonzz=1;
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
	
	if(userOther.checked){
		otherLink.readOnly=false;
		otherLink.placeholder='请输入外部链接';
	}else{
		otherLink.placeholder='若需使用外部链接请勾选上方选框';
		otherLink.readOnly=true;
	}
}

let ontherLinkzz=1;

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
 * 确保新闻头信息的提交
 * @author Liuyun 2019/05/30
 * 
 */
function ensureNewsHead(){
	
	var userOther=document.getElementById('userOther');
	var otherLink=document.getElementById('otherLink');
	
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
			return true;
		}
	}else{
		otherLink.value='0';
		return true;
	}
	
}

