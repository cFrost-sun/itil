<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="${__ASSETS_PATH}/lib/easyui/themes/bootstrap/easyui.css">
<link rel="stylesheet" href="${__ASSETS_PATH}/lib/easyui/themes/icon.css">
<title></title>

<style>
#e-dg-tb{
    min-height: 400px;
}
</style>

</head>

<body class="easyui-layout">
    <div id="e-dg-tb" data-options="region:'north',split:true"
        style="background: #eee;">
        
    <table class="easyui-datagrid" 
        data-options="
            fit:true,
            url:'${__CONTEXT_PATH}/queryWorkerOrderByPage_ajax',
            fitColumns:false,
            singleSelect:false,
            rownumbers:true,
            remoteSort:true,
            multiSort:false,
            sortName:'createdTime',
            sortOrder:'desc',
            pagination:true">
        <thead>
            <tr>
                <th data-options="field:'siteName',align:'center',width:'80px'">地点/大厅</th>
                <th data-options="field:'resource',align:'center',width:'100px'">机型Resource</th>
                <th data-options="field:'id',align:'center',width:'60px'">ID</th>
                <th data-options="field:'priorityName',align:'center',sortable:true,width:'70px'">优先级</th>
                <th data-options="field:'title',align:'center',width:'300px'">主题</th>
                <th data-options="field:'statusName',align:'center',sortable:true,width:'80px'">状态</th>
                <th data-options="field:'linkedRequestId',align:'center',width:'60px'">关联请求</th>
                <th data-options="field:'queueName',align:'center',sortable:true,width:'60px'">工作组</th>
                <th data-options="field:'ownerName',align:'center',sortable:true,width:'130px'">指派给</th>
                <th data-options="field:'createdTime',align:'center',sortable:true,width:'130px',formatter:unixDatetimeFormatter">创建时间</th>
                <th data-options="field:'duebyTime',align:'center',sortable:true,width:'130px',formatter:unixDatetimeFormatter">逾期时间</th>
                <th data-options="field:'updateTime',align:'center',sortable:true,width:'130px',formatter:unixDatetimeFormatter">最后更新时间</th>
                <th data-options="field:'holdTime',align:'center',sortable:true,width:'70px'">中断次数</th>
                <th data-options="field:'downTime',align:'center',sortable:true,width:'70px'">停机时间</th>
                <th data-options="field:'actionType',align:'center',width:'80px'">动作类型</th>
                <th data-options="field:'type',align:'center',width:'70px'">需求类型</th>
                <th data-options="field:'mrStatus',align:'center',width:'100px'">航材处理状态</th>
                <th data-options="field:'returnMaterialStatus',align:'center',width:'100px'">退料处理状态</th>
                <th data-options="field:'meOrderCount',align:'center',width:'100px'">Me订件数量</th>
            </tr>
        </thead>
    </table> 
</div>
    <div data-options="region:'center'">456s</div>
<script src="${__ASSETS_PATH}/lib/jquery/jquery-1.12.4.min.js"></script>
<script src="${__ASSETS_PATH}/lib/easyui/jquery.easyui.min.js"></script>
<script src="${__ASSETS_PATH}/lib/easyui/easyui-lang-zh_CN.js"></script>
<script>
function unixDatetimeFormatter(value, row, index) {
    return new Date(value).Format('yyyy-MM-dd hh:mm:ss');
}

Date.prototype.Format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}
</script>
</body>

</html>