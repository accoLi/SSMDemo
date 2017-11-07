package com.lcq.test;



import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lcq.pojo.User;



@SuppressWarnings("unused")
public class JSONTest {
	
			
 
  public static void main(String [] args){
	  JSONArray jsonArray=new JSONArray();
	  String jsonStr="{\"id\":2,\"title\":\"json title\",\"config\":{\"width\":34,\"height\":35},\"data\":[\"JAVA\",\"Javascript\",\"PHP\"]}";
	  JSONObject jsonObject=JSON.parseObject(jsonStr);
	  System.out.println(jsonObject.get("config").toString());
	  
	  String jsonStr1="{\"username\":\"json\",\"userage\":25,\"sex\":\"男\","+
	  "\"email\":\"1312571351@qq.com\",\"account\":\"20170807\",\"psswd\":\"000000\"}";
	  
	  User user=JSON.parseObject(jsonStr1, User.class);
	  User user1=new User();
	  //user1.setAccount("test.qq.com");
	  String jsonStr2=JSON.toJSONString(user1);
	  System.out.println("json->user:"+user.getEmail());
	  System.out.println(jsonStr2);
	  
	  
	  
	  String test="a,b,c,d,d,e,f,g,";
	  System.out.println(test.substring(0, test.length()));
	  
	  String resultStr="aa";
	  
	  if(null!=resultStr&&resultStr.trim().length()>0){
			resultStr=resultStr.substring(0,resultStr.length()-1);
			resultStr="["+resultStr+"]";
		}
	  
	  
	  System.out.println("resultStr:"+resultStr);
	  
	  
	  
	  
	  String jsonObject1="{\"code\":\"00001\",\"resultJson\":[{\"value\":1,\"DATA_TIME\":\"14\",\"OP_TIME\":\"20170809\",\"JUDGE_TIME\":\"0\"},{\"value\":2,\"DATA_TIME\":\"15\",\"OP_TIME\":\"20170810\",\"JUDGE_TIME\":\"0\"}]}";
	  JSONObject jo=JSON.parseObject(jsonObject1);
	  System.out.println("jo:"+jo.toString());
	  JSONArray jsonArray2=jo.getJSONArray("resultJson");
	  System.out.println("jsonArray2:"+jsonArray2);
	  System.out.println("jsonLength:"+jsonArray2.size());
	  JSONObject jo2=jsonArray2.getJSONObject(0);
	  System.out.println(jo2.get("OP_TIME"));
	  
	  
	  
	  
	  StringBuffer stringBuffer=new StringBuffer();
	  stringBuffer.append("abceefg,");
	  System.out.println("stringBuffer:"+stringBuffer);
	  stringBuffer.setLength(stringBuffer.length()-1);
	  System.out.println("afterStringBuffer:"+stringBuffer);
	  
	  
	  StringBuffer str1=new StringBuffer();
	  StringBuffer str2=new StringBuffer();
	  str1.append("a,b,c,d,");
	  str2.append("e,d,f,g");
	  str1.append(str2);
	  System.out.println("test:"+str1+str2);
  }
}
