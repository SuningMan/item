//确认提交  生成产品二维码
function approve() {
	if (checkData()) {
		$('#addProductForm').form('submit', {
			url : "/createProduct",
			onSubmit : function() {
				$.messager.progress({
					title : '确定',
					msg : '正在处理，请稍候。。。'
				});
				return true;
			},
			async : false,
			success : function(data) {
				$.messager.progress('close');
				var data = eval('(' + data + ')');
				if (data.info =="success") {
					$.messager.alert("提示","产品二维码成功生成！","info", function() {
						parent.$("#productList").datagrid('reload');
						parent.$('#msgDialog').dialog('close');
					});
				} else {
					$.messager.alert("提示", "提交失败，请重新提交", "info");
				}
			},
			error : function() {
				$.messager.progress('close');
				$.messager.alert("提示", "提交失败，请重新提交", "info");//提交审批失败，请重新提交!
			}
		});
	}
}
//校验栏位输入
function checkData() {
	debugger
	if ($("#description").val() == '' || $("#monthNum").val() == ''
		|| $("#num").val() == '') {
	$.messager.alert("提示", "请检查栏位是否填写完毕！", "info");
	return false;
	}
	if(!isPositiveInteger($("#monthNum").val())){
		$.messager.alert("提示", "保修月数请输入正整数！", "info");
		return false;
	}
	if(!isPositiveInteger($("#num").val())){
		$.messager.alert("提示", "生成个数请输入正整数！", "info");
		return false;
	}
	if($("#monthNum").val()>36){
		$.messager.alert("提示", "请输入1-36之间正整数！", "info");
		return false;
	}
	 return true;
}

function isPositiveInteger(s){//是否为正整数
    var re = /^[1-9]+$/ ;
    return re.test(s)
}   


