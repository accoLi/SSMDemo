<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ajax_test1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
  <script type="text/javascript">
  $(document).ready(function(){
      /* if(window.XMLHttpRequest){
          var xmlhttp=new XMLHttpRequest();
      }else{
          var xmlhttp=new ActiveXObject("Miscrosoft.XMLHttp");
      }
      xmlhttp.open("GET","ajaxAction.action?",true);
      xmlhttp.setRequestHeader("COOKIE","author=lcq");
      xmlhttp.onreadystatechange=function(){
         if(xmlhttp.readyState==4&&xmlhttp.status==200){
           alert(xmlhttp.responseText);
         }
      }
      xmlhttp.send(); */
      $.ajax({
        url:"ajaxAction.action",
        type:'POST',
        data:"jsonString={'name':'li','age':'22'}&time="+new Date()+"",
        async:true,
        cache:false,
        dataType:'json',
        erro:function(){
          alert("请求失败");
        },
        beforeSend:function(){
          alert("马上发送ajax请求");
        },
        complete:function(){
           alert("请求处理后");
        },
        success:function(data){
           alert("尊敬的"+data.name+","+data.description);
        }
      });
  
  });
  
  </script>
  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
