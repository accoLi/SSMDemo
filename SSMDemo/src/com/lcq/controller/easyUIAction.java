package com.lcq.controller;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lcq.pojo.User;
import com.lcq.service.UserService;

@Controller
@RequestMapping(("/easyUI"))
public class easyUIAction {
	@Autowired
	private UserService userService;
   @RequestMapping(value="/getAllUser",method={RequestMethod.GET,RequestMethod.POST})
   public @ResponseBody String getAllUser(HttpServletRequest request){
	   JSONObject result = new JSONObject();
	   String pageNumberStr = null==request.getParameter("page") ? "1" : request.getParameter("page");
	   String pageSizeStr = null==request.getParameter("rows") ? "10" : request.getParameter("rows");
	   int pageNumber = Integer.parseInt(pageNumberStr) <=0 ? 1 : Integer.parseInt(pageNumberStr);
	   int pageSize = Integer.parseInt(pageSizeStr) <=0 ? 10 : Integer.parseInt(pageSizeStr);
	   pageNumber= (pageNumber-1)*pageNumber;
	   int total = userService.selectUserCount();
	   List<User> list = userService.selectAllUser(pageNumber,pageSize);
	   JSONArray array = new JSONArray();
	   for(User u : list){
		   JSONObject jo = new JSONObject();
		   jo.put("firstname", u.getFirstName());
		   jo.put("lastname", u.getLastName());
		   jo.put("email", u.getEmail());
		   jo.put("phone", u.getPhone());
		   array.add(jo);
	   }
	   result.put("total", total);
	   result.put("resultString", array);
	   return array.toString();
   }
}
