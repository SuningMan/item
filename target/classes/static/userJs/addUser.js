//确认提交
function approve() {
	if (checkData()) {
		$('#addUserForm').form('submit', {
			url : "/insertUser",
			onSubmit : function() {
				$.messager.progress({
					title : '确定',
					msg : '正在处理，请稍候。。。'
				});
				return true;
			},
			async : false,
			success : function(data) {
				var data = eval('(' + data + ')');
				if (data.msg == "success") {
					$.messager.alert("提示", "提交成功", "info", function() {
						parent.$("#userList").datagrid('reload');
						parent.$('#msgDialog').dialog('close');
					});
				} else {
					$.messager.alert("提示", "提交失败，请重新提交", "info");
				}
			},
			error : function() {
				$.messager.alert("提示", "提交失败，请重新提交", "info");//提交审批失败，请重新提交!
			}
		});
	}
}
//校验栏位输入
function checkData() {
	if ($("#userName").val() == '' || $("#userPaw").val() == ''
			|| $("#userPaw1").val() == '' || $("#unionid").val() == '') {
		$.messager.alert("提示", "请检查栏位是否填写完毕！", "info");
		return false;
	}

	if ($("#userPaw").val() != $("#userPaw1").val()) {
		$.messager.alert("提示", "请确认密码是否一致！", "info");
		return false;
	}
	 return true;
}