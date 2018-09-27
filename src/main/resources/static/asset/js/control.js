var roleId;
$(function(){
	$.ajax({
		type : "GET",
		url : "../../checkSession",
		data : {},
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.status=="000"){
				roleId = result.data.roleId;
			}else{
				$.confirm({
					title: '请登录',
					content: result.message+'3秒后自动跳转……',
					autoClose: '确定|3000',
					buttons: {
						'确定': function () {
							window.top.location.href="/login.html";
						},
					}
				});
			}
		}
	});

	//根据用户名id和菜单查询权限
	$.ajax({
		type : "get",
		url : "../../Permission/getPermissionByMenuName",
		data : {"roleId":roleId,"menuName":document.title},
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.status!="000"){
				$.alert("出现故障，请联系管理员");
			}else{
				if(result.data.permission_value.indexOf("1")==-1){
					$(".success").remove();
				}
				if(result.data.permission_value.indexOf("2")==-1){
                    $(".btn-success").remove();
				}
				if(result.data.permission_value.indexOf("3")==-1){
                    $(".btn-warning").remove();
				}
				if(result.data.permission_value.indexOf("4")==-1){
                    $(".btn-danger").remove();
				}
			}
		}
	});

});

Date.prototype.format = function(fmt) {
	var o = {
		"M+" : this.getMonth()+1,                 //月份
		"d+" : this.getDate(),                    //日
		"h+" : this.getHours(),                   //小时
		"m+" : this.getMinutes(),                 //分
		"s+" : this.getSeconds(),                 //秒
		"q+" : Math.floor((this.getMonth()+3)/3), //季度
		"S"  : this.getMilliseconds()             //毫秒
	};
	if(/(y+)/.test(fmt)) {
		fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
	}
	for(var k in o) {
		if(new RegExp("("+ k +")").test(fmt)){
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
		}
	}
	return fmt;
}
