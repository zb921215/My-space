var roleId;
$(function(){
	//首先获取登录信息
	getLoginInfo();

	var menuPList;//一级(父级)菜单集合
	var menuCList;//二级(子级)菜单集合
    //首先，查出数据库中有权限的且启用的父级菜单。
	$.ajax({
		type : "GET",
		url : "Menu/findPMenuByRoleId",
        data:{"roleId":roleId},
		dataType : "json",
		async : false,
		success : function(result) {
			menuPList = eval(result.data);
		}
	});

	var strP = "<li>"
			 + "<a href='#'>"
			 + "<i class='fa fa-home'></i>"
			 + "<span class='nav-label'>系统首页</span>"
			 + "<span></span>"
			 + "</a>"
			 + "</li>";

	$.each(menuPList,function(index,data){
		var menuId = data.menuId;
		var menuName = data.menuName;//菜单名称
		var menuIcon = data.menuIcon;//菜单图标
		strP += "<li id='menu"+menuId+"'>"
			 + "<a href='#collapse"+menuId+"'>"
             + "<i class='"+ data.menuIcon +"'></i>"
             + "<span class='nav-label'>"+menuName+"</span>"
             + "<span class='fa arrow'></span>"
             + "</a>"
			 + "<\/li>";
	});
    $("#side-menu").append(strP);

	$.each(menuPList,function(index,data){
		//根据父级菜单查询启用的子菜单
		var menuPid = data.menuId;
		$.ajax({
			type : "GET",
			url : "Menu/findCMenuByRoleId",
			data:{roleId:roleId,menuPid:menuPid},
			dataType : "json",
			async : false,
			success : function(result) {
				menuCList = eval(result.data);
			}
		});

		if(menuCList.length>0){//如果该父菜单下有子菜单
			var strC ="<ul id='collapse"+menuPid+"' class='nav nav-second-level collapse'>";
			$.each(menuCList,function(indexC,dataC){
				strC += "<li>"
					 +  "<a class='J_menuItem' href='"+dataC.menuUrl+"'>"
					 +  "<i class='"+ dataC.menuIcon +"'></i>"
					 +  "<span>"+dataC.menuName+"</span>"
					 +  "</a>"
					 +  "<\/li>";
			});
            strC += "</ul>"
            $("#menu"+data.menuId).append(strC);
        }

	});

	//查找全部的有权限的菜单
	$.ajax({
		type : "GET",
		url : "Permission/findPermission",
		data:{"roleId":roleId},
		dataType : "json",
		async : false,
		success : function(result) {
			$.each(result.data,function(index,data){
				if(data.permission_value==undefined || data.permission_value.indexOf("1")==-1){
					$("#"+data.menu_id+"").remove();
				}
			})
		}
	});
	//$("#main-nav").show();
});


function getLoginInfo(){
	$.ajax({
		type : "GET",
		url : "checkSession",
		data : {},
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.status=="000"){
				/*$("#lgname").html(result.data.userAccount+"，欢迎您！");*/
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
}
	/*退出*/
	function logout(){
	$.ajax({
		type : "GET",
		url : "/logout",
		data : {},
		async : false,
		success : function() {
			window.location.href="/login.html";
		},
		error : function(){
			$.alert("系统故障，请联系管理员!");
		}
	});

}
