//确认提交
function approve() {
	if (checkData()) {
		$('#updateSupplierForm').form('submit', {
			url : "/updateSupplier",
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
						parent.$("#supplierList").datagrid('reload');
						parent.$('#msgDialog').dialog('close');
					});
				} else {
					$.messager.alert("提示", "提交失败，请重新提交", "info",function(){
						parent.$('#msgDialog').dialog('close');
					} );
				}
			},
			error : function() {
				$.messager.alert("提示", "提交失败，请重新提交", "info",function(){
					parent.$('#msgDialog').dialog('close');
				} );//提交审批失败，请重新提交!
			}
		});
	}
}
//校验栏位输入
function checkData() {
	if ($("#suppliername").val() == '' || $("#contact").val() == ''
			|| $("#phonenumber").val() == '' || $("#address").val() == '') {
		$.messager.alert("提示", "请检查栏位是否填写完毕！", "info");
		return false;
	}
	 return true;
}