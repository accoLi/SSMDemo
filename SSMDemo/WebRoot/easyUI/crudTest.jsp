<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'crudTest.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet"  type="text/css" href="css/easyui.css"/>
    <link rel="stylesheet"  type="text/css" href="css/demo.css" />
    <link rel="stylesheet"  type="text/css" href="css/color.css" />
    <link rel="stylesheet"  type="text/css" href="css/icon.css" />
    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
  </head>
  <body>
      <table id="dg" title="my users" class="easyui-datagrid" style="width:550px;height:250px"
                     url="easyUI/getAllUser.action" 
                     toolbar="#toolbar"
                     rownumbers="true" fitColumns="true" singleSelect="true">
            <thead>
                <tr>
                     <th field="firstname" width="50">First Name</th>
                     <th field="lastname" width="50">Last Name</th>
                     <th field="phone" width="50">Phone</th>
                     <th field="email" width="50">Email</th>
                </tr>
            </thead>
      </table>
      <div id="toolbar">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addUser()">添加用户</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑用户</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeUser()">删除用户</a>
      </div>
  </body>
</html>
