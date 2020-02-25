//查询
function queryRegisterCodeList() {
	$("#registerCodeList").datagrid({
		width : '100%',
		height : 'auto',
		method : "post",
		url : "/findRegisterCode",
		queryParams : {
			"search" : $("#search").val()
		},
		columns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			field : 'orgId',
			title : "机构",
			width : '15%',
			tooltip : true,
			sortable : true
		}, {
			field : 'lastOrg',
			title : "上级机构",
			width : '10%',
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
			field : 'registerNumber',
			title : "注册码",
			width : '15%',
			tooltip : true,
			sortable : true
		}, {
			field : 'isuse',
			title : "是否使用",
			width : '10%',
			tooltip : true,
			sortable : true,
			formatter: function(value,row,index)
        	{
        		if(row.isuse == 1){
        			return "是";
        		}else if(row.isuse == 0){
        			return "否";
        		}
        	}
		},  {
			field : 'createTime',
			title : "创建时间",
			width : '15%',
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
				$('#registerCodeList').datagrid("insertRow", {
					index : 1,
					row : {
						lastOrg : tips
					}
				});
			}
		}

	});
}

// 添加
function add() {
	 var url = "/addRegisterCode.jsp";
	 showApproveDialog(url,"生成注册码",550,330,true,"确认");
}

