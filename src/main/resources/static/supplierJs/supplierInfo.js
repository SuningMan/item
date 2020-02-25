//查询
function querySuppliersList() {
	$("#supplierList").datagrid({
		width : '100%',
		height : 'auto',
		method : "post",
		url : "/findSuppliers",
		queryParams : {
			"search" : $("#search").val()
		},
		columns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			field : 'suppliername',
			title : "厂商名",
			width : '10%',
			tooltip : true,
			sortable : true
		}, {
			field : 'contact',
			title : "联系人",
			width : '10%',
			tooltip : true,
			sortable : true
		}, {
			field : 'phonenumber',
			title : "电话",
			width : '10%',
			tooltip : true,
			sortable : true
		}, {
			field : 'address',
			title : "地址",
			width : '15%',
			tooltip : true,
			sortable : true
		}, {
			field : 'createtime',
			title : "创建时间",
			width : '12%',
			tooltip : true,
			sortable : true
		},  {
			field : 'updatetime',
			title : "更新时间",
			width : '12%',
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
				$('#supplierList').datagrid("insertRow", {
					index : 1,
					row : {
						suppliername : tips
					}
				});
			}
		}

	});
}

// 添加
function add() {
	 var url = "/addSupplier.jsp";
     showApproveDialog(url,"添加厂商",550,300,true,"确认");
}

//编辑用户信息
function update() {
	var supplier = $("#supplierList").datagrid('getSelected');
	
	if (supplier == null || supplier.id== null) {
		$.messager.alert("提示", "请选择一条记录！", "info");
		return false;
	}else {
		 var url = "/updateSupplierJsp?id="+supplier.id;
	     showApproveDialog(url,"编辑厂商",550,300,true,"确认");
	}
	 
}

//删除
function dele() {

	var supplier = $("#supplierList").datagrid('getSelected');

	if (supplier == null || supplier.id == null) {
		$.messager.alert("提示", "请选择一条记录！", "info");
		return false;
	} else {
		$.messager.confirm("提示", "确认要删除该记录吗？", function(r) {// 您确认要删除该记录吗？
			if (r) {
				var url = "/deleteSupplier?id=" + supplier.id ;
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
							$("#supplierList").datagrid('reload');
						}
					}
				});
			}
		});
	}
}
