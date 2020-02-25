//查询
function queryUserList() {
	$("#userList").datagrid({
		width : '100%',
		height : 'auto',
		method : "post",
		url : "/findAllUser",
		queryParams : {
			"search" : $("#search").val()
		},
		columns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			field : 'userId',
			title : "用户编号",
			width : '10%',
			tooltip : true,
			sortable : true
		}, {
			field : 'userName',
			title : "用户名",
			width : '10%',
			tooltip : true,
			sortable : true
		}, {
			field : 'userPaw',
			title : "密码",
			width : '10%',
			tooltip : true,
			sortable : true,
			hidden:true
		}, {
			field : 'unionid',
			title : "微信号",
			width : '10%',
			tooltip : true,
			sortable : true
		}, {
			field : 'org',
			title : "机构",
			width : '8%',
			tooltip : true,
			sortable : true
		}, {
			field : 'lastOrg',
			title : "上级机构",
			width : '8%',
			tooltip : true,
			sortable : true
		}, {
			field : 'ismanager',
			title : "是否管理员",
			width : '10%',
			tooltip : true,
			sortable : true,
			formatter: function(value,row,index)
        	{
        		if(row.ismanager == 1){
        			return "是";
        		}else if(row.ismanager == 0){
        			return "否";
        		}
        	}
		}, {
			field : 'isregister',
			title : "是否注册",
			width : '10%',
			tooltip : true,
			sortable : true,
			formatter: function(value,row,index)
        	{
        		if(row.isregister == 1){
        			return "是";
        		}else if(row.isregister == 0){
        			return "否";
        		}
        	}
		}, {
			field : 'registerNumber',
			title : "注册码",
			width : '10%',
			tooltip : true,
			sortable : true
		}, {
			field : 'registerTime',
			title : "注册时间",
			width : '10%',
			tooltip : true,
			sortable : true
		}, {
			field : 'updateTime',
			title : "更新时间",
			width : '10%',
			tooltip : true,
			sortable : true
		} ] ],
		pagination : true,
		remoteSort : false,
		rownumbers : true,
		singleSelect : true,
		enableHeaderClickMenu : true,
		enableHeaderContextMenu : true,
		enableRowContextMenu : true,
		rowTooltip : true,
		onLoadSuccess : function(data) {
			if (data.total == 0) {
				var tips = "<font color=red>没有数据....</font>";
				$('#userList').datagrid("insertRow", {
					index : 1,
					row : {
						userName : tips
					}
				});
			}
		}

	});
}

// 添加
function add() {
	 var url = "/addUser.html";
     showApproveDialog(url,"添加用户",550,400,true,"确认");
}

//编辑用户信息
function update() {
	var user = $("#userList").datagrid('getSelected');
	
	if (user == null || user.userId == null) {
		$.messager.alert("提示", "请选择一条记录！", "info");
		return false;
	}else {
		 var url = "/updateUserPage?userId=" + user.userId;
	     showApproveDialog(url,"编辑用户",550,400,true,"确认");
	}
	 
}

//删除
function dele() {

	var user = $("#userList").datagrid('getSelected');

	if (user == null || user.userId == null) {
		$.messager.alert("提示", "请选择一条记录！", "info");
		return false;
	} else {
		$.messager.confirm("提示", "确认要删除该记录吗？", function(r) {// 您确认要删除该记录吗？
			if (r) {
				var url = "/deleteUser?userId=" + user.userId;
				$.ajax({
					url : url,
					dataType : "JSON",
					beforeSend : function(XMLHttpRequest) {
						$.messager.progress({
							title : "删除",
							msg : "正在处理，请稍后。。。"
						});
					},
					type : "get",
					success : function(data) {
						$.messager.progress('close');
						if (data == 1) {
							$.messager.alert('提示信息', '已删除', 'info');
							$("#userList").datagrid('reload');
						}
					}
				});
			}
		});
	}
}
