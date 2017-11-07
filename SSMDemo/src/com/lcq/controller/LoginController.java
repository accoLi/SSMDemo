package com.lcq.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Controller
public class LoginController {
  @RequestMapping("login")
	public String login(){
		return "home";
	}
 
  @RequestMapping("ajaxAction")
  public void doService(HttpServletRequest request,HttpServletResponse response){
	  response.setCharacterEncoding("utf-8");
	//  Cookie[] cookies=request.getCookies();
	 // String author=null;
	 /* System.out.println("获取cookie前");
	  if(null!=cookies||cookies.length>0){
		  System.out.println("获取cookie后");
		  for(Cookie c:cookies){
			  System.out.println("作者："+c.getValue());
			  if("author".equals(c.getName())){
				  author=c.getValue();
				  System.out.println("作者："+author);
			  }
		  }
	  }*/
	  String params="";
	  System.out.println(request.getParameter("jsonString"));
	  if(null!=request.getParameter("jsonString")||StringUtils.isNotBlank(request.getParameter("jsonString"))){
		  JSONObject jo=JSON.parseObject(request.getParameter("jsonString"));
		  
		 
		  params=StringUtils.isBlank(jo.getString("name"))?"没有获取到名字":jo.getString("name");
	  }else{
		  System.out.println("没有接收到数据");
		  
	  }
	  System.out.println("姓名"+params);
	  try {
		  response.setCharacterEncoding("UTF-8");
		  response.setContentType("application/json;charset=utf-8");
		  String resultJson="{\"description\":\"我收到了你的请求\",\"name\":\"lcq\"}";
		 
		  response.getWriter().write(resultJson);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
  }
}
