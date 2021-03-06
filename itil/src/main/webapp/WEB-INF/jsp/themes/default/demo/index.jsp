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
body{
min-width:1200px
}

.search-hr{
    margin:3px 10px;
}

#search-form > div {
    height: 30px;
}
</style>

</head>

<body class="easyui-layout">
<div id="work-order" data-options="region:'center'"
    style="background: #eee;">
    <div id="tb">
    <form id="search-form">
        请求:
        <div>
        <input class="easyui-textbox search-box e-dg-tb-filter" id = "query_id" name="query.id" data-options="label:'ID',labelAlign:'right',labelWidth:'60px',width:'180px'"
        ><input class="easyui-textbox search-box e-dg-tb-filter" id = "query_title" name="query.title" data-options="label:'主题',labelAlign:'right',labelWidth:'60px',width:'210px'"
        ><input class="easyui-textbox search-box e-dg-tb-filter" id = "query_resource" name="query.resource" data-options="label:'机型Resource',labelAlign:'right',labelWidth:'90px',width:'210px'"
        ><input class="easyui-combobox search-box e-dg-tb-filter" name="query.queueId" data-options="
                    url:'${__CONTEXT_PATH}/findQueueDefinitions_ajax',
                    method:'get',
                    valueField: 'id',
                    textField: 'value',
                    panelHeight:'auto',
                    panelMaxHeight:'200px',
                    label:'工作组',
                    labelAlign:'right',
                    labelWidth:'60px',
                    width:'180px',
                    onChange:onSearch"
                id = "query_queue"
        ><input class="easyui-combobox search-box e-dg-tb-filter" name="query.statusId" data-options="
                    url:'${__CONTEXT_PATH}/findStatusDefinitions_ajax',
                    method:'get',
                    valueField: 'id',
                    textField: 'value',
                    panelHeight:'auto',
                    panelMaxHeight:'200px',
                    panelWidth:'300px',
                    label:'状态',
                    labelAlign:'right',
                    labelWidth:'60px',
                    width:'180px',
                    onChange:onSearch"
                id = "query_status"><input class="easyui-textbox search-box e-dg-tb-filter" id = "query_siteName" name="query.siteName" data-options="label:'地点/大厅',labelAlign:'right',labelWidth:'90px',width:'210px'"
        ></div>
        <div>
        <input class="easyui-datetimebox search-box e-dg-tb-filter" id = "filter_begin" name="filter.begin" data-options="label:'创建时间',labelAlign:'right',labelWidth:'60px',width:'210px'"
        ><input class="easyui-datetimebox search-box e-dg-tb-filter" id = "filter_end" name="filter.end" data-options="label:'到',labelAlign:'center',labelWidth:'30px',width:'180px'"
        ></div>
        <hr class="search-hr">
        日志: 
        <div>
        <input class="easyui-textbox search-box e-dg-tb-filter" id="filter_log_desc" name="filter.log_desc" data-options="label:'描述',labelAlign:'right',labelWidth:'60px',width:'390px'"
        ><input class="easyui-textbox search-box e-dg-tb-filter" id="filter_log_removedArtifactName" name="filter.log_removedArtifactName" data-options="label:'拆下部件名称',labelAlign:'right',labelWidth:'90px',width:'210px'"
        ><input class="easyui-combobox search-box e-dg-tb-filter" id="filter_log_owner" name="filter.log_owner" data-options="
                    url:'${__CONTEXT_PATH}/findTechnicians_ajax',
                    method:'get',
                    valueField: 'id',
                    textField: 'value',
                    panelHeight:'auto',
                    panelMaxHeight:'200px',
                    panelWidth:'160px',
                    label:'所有者',
                    labelAlign:'right',
                    labelWidth:'60px',
                    width:'180px',
                    onChange:onSearch"
        ><input class="easyui-datetimebox search-box e-dg-tb-filter" id="filter_log_begin" name="filter.log_begin" data-options="label:'创建时间',labelAlign:'right',labelWidth:'60px',width:'210px'"
        ><input class="easyui-datetimebox search-box e-dg-tb-filter" id="filter_log_end" name="filter.log_end" data-options="label:'到',labelAlign:'center',labelWidth:'30px',width:'180px'">
        </div>        
        <hr class="search-hr">       
        <a id="search-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="onSearch()">查找请求</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="onReset()">清空所有筛选条件</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="clearWorkerOrder()">清空请求筛选条件</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="clearWorkerLog()">清空日志筛选条件</a>
    </form>
    </div>
    <table class="easyui-datagrid" id="e-dg"
        data-options="
            toolbar:'#tb',
            fit:true,
            url:'${__CONTEXT_PATH}/queryWorkerOrderByPage_ajax',
            fitColumns:false,
            singleSelect:true,
            rownumbers:true,
            remoteSort:true,
            multiSort:false,
            sortName:'createdTime',
            sortOrder:'desc',
            pageSize:50,
            pageList:[10,20,30,40,50,100,150,200],
            pagination:true,
            onClickRow:selectWorkOrder">
        <thead>
            <tr>
                <th data-options="field:'siteName',align:'center',sortable:true,width:'80px'">地点/大厅</th>
                <th data-options="field:'resource',align:'center',sortable:true,width:'100px'">机型Resource</th>
                <th data-options="field:'id',align:'center',sortable:true,width:'60px',formatter:edit">ID</th>
                <th data-options="field:'priorityName',align:'center',sortable:true,width:'70px'">优先级</th>
                <th data-options="field:'title',align:'left',width:'300px',formatter:formatCellTooltip">主题</th>
                <th data-options="field:'statusName',align:'center',sortable:true,width:'120px'">状态</th>
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
<div id="charge" data-options="region:'south',title:'工作日志',minHeight:'260px'">
    <table id="charge-dg" class="easyui-datagrid" 
        data-options="
            fit:true,
            fitColumns:false,
            nowrap: false,
            singleSelect:true,
            rownumbers:true,
            remoteSort:false,
            pagination:false">
        <thead>
            <tr>
                <th data-options="field:'tsEndTime',align:'center',width:'130px',formatter:unixDatetimeFormatter">结束时间</th>
                <th data-options="field:'createbyName',align:'center',width:'130px'">创建人</th>
                <th data-options="field:'createdTime',align:'center',width:'130px',formatter:unixDatetimeFormatter">创建时间</th>
                <th data-options="field:'ownerName',align:'center',width:'130px'">所有者</th>
                <th data-options="field:'description',align:'left',width:'300px'">描述</th>
                <th data-options="field:'timeSpent',align:'center',width:'130px',formatter:timeFormatter">解决问题所用的时间</th>
                <th data-options="field:'downTime',align:'center',width:'120px'">停机时间-日志</th>
                <th data-options="field:'lostTime',align:'center',width:'120px'">丢失时间-日志</th>
                <th data-options="field:'workLogTypeName',align:'center',width:'120px'">工作日志类型</th>
                <th data-options="field:'removedArtifactName',align:'center',width:'120px'">拆下部件名称</th>
                <th data-options="field:'removedArtifactPn',align:'center',width:'120px'">拆下部件件号P/N</th>
                <th data-options="field:'removedArtifactSn',align:'center',width:'120px'">拆下部件序号S/N</th>
                <th data-options="field:'installedArtifactName',align:'center',width:'120px'">安装部件名称</th>
                <th data-options="field:'installedArtifactPn',align:'center',width:'120px'">安装部件件号P/N</th>
                <th data-options="field:'installedArtifactSn',align:'center',width:'120px'">安装部件序号S/N</th>
            </tr>
        </thead>
    </table> 
</div>
<script src="${__ASSETS_PATH}/lib/jquery/jquery-1.12.4.min.js"></script>
<script src="${__ASSETS_PATH}/lib/easyui/jquery.easyui.min.js"></script>
<script src="${__ASSETS_PATH}/lib/easyui/easyui-lang-zh_CN.js"></script>
<script>
$(function(){   
    $("#e-dg").datagrid("keyCtr");
    onReset();
});

function move() {
    moveRow($('#e-dg'));
}

function onSearch() {
    var jsonParam = $('#search-form').serializeJson();
    jsonParam['mode.title']='anywhere';
    jsonParam['mode.resource']='anywhere';
    $('#e-dg').datagrid('reload', jsonParam);
}

function onReset() {
    $('#search-form').form('clear');
    $('#query_queue').combobox('select', '1');
    $('#query_status').combobox('select', '1');
}

function clearWorkerOrder() {
    $('#query_id').textbox('clear');
    $('#query_resource').textbox('clear');
    $('#query_title').textbox('clear');
    $('#query_siteName').textbox('clear');
    $('#filter_begin').datetimebox('clear');
    $('#filter_end').datetimebox('clear');
    $('#query_queue').combobox('select', '1');
    $('#query_status').combobox('select', '1');
    onSearch();        
}

function clearWorkerLog() {
    $('#filter_log_desc').textbox('clear');
    $('#filter_log_removedArtifactName').textbox('clear');
    $('#filter_log_owner').combobox('clear');
    $('#filter_log_begin').datetimebox('clear');
    $('#filter_log_end').datetimebox('clear');
    onSearch();    
}

function selectWorkOrder(index, row){
    var desc = $('#filter_log_desc').textbox('getValue');
    var removedArtifactName = $('#filter_log_removedArtifactName').textbox('getValue');
    var owner = $('#filter_log_owner').combobox('getValue');
    var begin = $('#filter_log_begin').datetimebox('getValue');
    var end = $('#filter_log_end').datetimebox('getValue');
    $.ajax({
        url:'loadChargesByWorkOrderId_ajax',
        type:'GET',
        async:true,
        data: 
            {
                workOrderId: row.id,
                desc: desc,
                removedArtifactName: removedArtifactName,
                owner: owner,
                begin: begin,
                end: end
            },
        error:function(XMLHttpRequest, textStatus, errorThrown) {
            euler.msg.response.error(XMLHttpRequest);
        },
        success:function(data, textStatus) {
            $('#charge-dg').datagrid('loadData', data.rows)
        }
    });
}

function edit(value, row, index) {
    return '<a target="_blank" href="${sdpurl}' + '/WorkOrder.do?woMode=viewWO&woID=' + row.id+'">'+row.id+'</a>';
}

function formatCellTooltip(value){  
    return "<span title='" + value + "'>" + value + "</span>";  
}

function unixDatetimeFormatter(value, row, index) {
    return new Date(value).Format('yyyy-MM-dd hh:mm:ss');
}

function timeFormatter(value, row, index) {
    var hours = parseInt(value / 1000 / 60 / 60);
    var min = parseInt(value / 1000 / 60 % 60);
    return hours + "小时" + min + "分";
}

//extends

$.fn.serializeJson=function(){ 
    var serializeObj={};
    var array=this.serializeArray();
    $(array).each(function(){
            if(serializeObj[this.name]){
                  if($.isArray(serializeObj[this.name])){ 
                      serializeObj[this.name].push(this.value); 
                  }else{
                      serializeObj[this.name]=[serializeObj[this.name],this.value]; 
                  } 
            }else{ 
                serializeObj[this.name]=this.value;
            } 
    }); 
    return serializeObj; 
};

$(function(){
    $("#search-form input,.search-table select").on('keyup',function(event){
        if(event.keyCode == "13"){
            $("#search-form #search-btn").click();
        }
    });
});

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

var euler = {        
        msg: {
            response: {
                error: function(XMLHttpRequest) {
                    var response = JSON.parse(XMLHttpRequest.responseText);
                    var msg = "<div style='color: #D8504D;font-size: 1.5em;margin-bottom: 5px;'>ERROR</div><div style='margin-bottom: 5px;'>${e:i18n('_ERROR_CODE')}:&nbsp;" + response.error + ' (' + response.error_code + ')'  + "</div><div>${e:i18n('_ERROR_DETAILS')}:&nbsp;" + response.error_description + "</div>";
                    $.messager.alert("${e:i18n('_ERROR')}", msg);
                }
            }
        }
}

$.extend($.fn.datagrid.methods, {
    keyCtr : function (jq) {
        return jq.each(function () {
            var grid = $(this);
            grid.datagrid('getPanel').panel('panel').attr('tabindex', 1).bind('keydown', function (e) {
                switch (e.keyCode) {
                case 38: // up
                    var selected = grid.datagrid('getSelected');
                    var i;
                    if (selected) {
                        var index = grid.datagrid('getRowIndex', selected);
                        i = index - 1;
                        grid.datagrid('selectRow', i);
                    } else {
                        var rows = grid.datagrid('getRows');
                        i = rows.length - 1;
                        grid.datagrid('selectRow', i);
                    }
                    var data = grid.datagrid('getSelected');
                    selectWorkOrder(i, data);
                    break;
                case 40: // down
                    var selected = grid.datagrid('getSelected');
                    var i;
                    if (selected) {
                        var index = grid.datagrid('getRowIndex', selected);
                        i = index + 1;
                        grid.datagrid('selectRow', i);
                    } else {
                        i = 0;
                        grid.datagrid('selectRow', i);
                    }
                    var data = grid.datagrid('getSelected');
                    selectWorkOrder(i, data);
                    break;
                }
            });
        });
    }
});
</script>
</body>

</html>