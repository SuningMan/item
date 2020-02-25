//确认提交  生成注册码
function approve() {
	if (checkData()) {
		$('#addRegisterForm').form('submit', {
			url : "/insertRegisterCode",
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
				if (data.returnCode =="success") {
					$.messager.alert("注册码", data.verifyCode, "info", function() {
						parent.$("#registerCodeList").datagrid('reload');
						parent.$('#msgDialog').dialog('close');
					});
				}else if(data.returnCode == "exists"){
					$.messager.alert("提示", "该厂商已有注册码", "warning");
				}else {
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
	if ($("#supplierId").combobox('getValue') == '') {
		$.messager.alert("提示", "请选择厂商！", "info");
		return false;
	}
	 return true;
}


