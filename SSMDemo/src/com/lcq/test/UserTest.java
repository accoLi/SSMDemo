package com.lcq.test;




import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lcq.pojo.User;
import com.lcq.service.UserService;
import com.sun.istack.internal.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class UserTest {
  @Autowired
  private UserService userService;
 private static final Logger log=Logger.getLogger(UserTest.class);
  @Test
  public void Test(){
	  long start=System.nanoTime();
	  User user=userService.queryUserByUsername("test","123456");
	  long end=System.nanoTime();
	  /*System.out.println(user.getPassword());*/
	 //log.info(user.getAccount()+"用时："+(end-start));
	 String a="aa";
	
  }
}
