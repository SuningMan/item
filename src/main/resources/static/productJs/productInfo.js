//查询
function queryUserList() {
	$("#productList").datagrid({
		width : '100%',
		height : 'auto',
		method : "post",
		url : "/findAllProduct",
		queryParams : {
			"search" : $("#search").val()
		},
		columns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			field : 'productId',
			title : "产品编号",
			width : '10%',
			tooltip : true,
			sortable : true
		}, {
			field : 'enterTime',
			title : "录入时间",
			width : '10%',
			tooltip : true,
			sortable : true,
			hidden:true
		}, {
			field : 'qrcodeUrl',
			title : "产品二维码",
			width : '12%',
			tooltip : true,
			sortable : true,
			formatter:function(value,row,index){
				if(value!=null){
					return "<img onclick='myfunciton(this.src)'  width='120px' height='80px' src="+row.qrcodeUrl+">";	
				}
			 }
		},{
			field : 'monthNum',
			title : "质保月数",
			width : '6%',
			tooltip : true,
			sortable : true
		},{
			field : 'activateTime',
			title : "激活时间",
			width : '13%',
			tooltip : true,
			sortable : true
		}, {
			field : 'isoverTime',
			title : "过期时间",
			width : '13%',
			tooltip : true,
			sortable : true
		}, {
			field : 'activateImageUrl',
			title : "激活时图片",
			width : '12%',
			tooltip : true,
			sortable : true,
			formatter:function(value,row,index){
				if(value!=null){
					return "<img  onclick='myfunciton(this.src)' width='120px' height='80px' src="+row.activateImageUrl+">";	
				}
			 }
		},{
			field : 'createTime',
			title : "创建时间",
			width : '13%',
			tooltip : true,
			sortable : true
		},{
			field : 'printStatus',
			title : "打印状态",
			width : '10%',
			tooltip : true,
			sortable : true,
			formatter: function(value,row,index)
        	{
        		if(row.printStatus == 1){
        			return "已打印";
        		}else if(row.printStatus == 0){
        			return "未打印";
        		}
        	}
		} ] ],
		pagination : true,
		remoteSort : false,
		rownumbers : true,
		singleSelect : true,
		enableHeaderClickMenu : true,
		enableHeaderContextMenu : true,
		enableRowContextMenu : true,
		rowTooltip : true,
		pageNumber:1,
		pageSize:5,
		pageList:[5,10,20,30,40,50],
		onLoadSuccess : function(data) {
			if (data.total == 0) {
				var tips = "<font color=red>没有数据....</font>";
				$('#productList').datagrid("insertRow", {
					index : 1,
					row : {
						productId : tips
					}
				});
			}
		}

	});
}

//添加
function add() {
	 var url = "/addProductJsp";
	 showApproveDialog(url,"生成产品二维码",550,300,true,"确认");
}

function myfunciton(e) {
    var large='<img width="450px" height="350px" src=' +e+ '></img>';
    $("#divlarge").html(large).animate({
        height:'30%',
        width:'30%'
    },1);
    $("#dlgdiv").dialog("open").dialog("setTitle", "图片展示");
}
