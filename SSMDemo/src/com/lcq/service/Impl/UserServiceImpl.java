package com.lcq.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.lcq.dao.UserMapper;
import com.lcq.pojo.User;
import com.lcq.service.UserService;

@Service("user")
public class UserServiceImpl implements UserService{
   @Autowired
   private UserMapper userMapper;
	@Override
	public User queryUserByUsername(String userName,String psswd) {
		// TODO Auto-generated method stub
		
		
		System.out.println("userService");
		
		return userMapper.selectUserByUserName(userName,psswd);
	}
	@Override
	public List<User> selectAllUser(int pageNumber,int pageSize) {
		// TODO Auto-generated method stub
		List<User> result = null;
		result = userMapper.selectAllUser(pageNumber,pageSize);
		return null == result ? new ArrayList<User>() : result;
	}
	@Override
	public int selectUserCount() {
		// TODO Auto-generated method stub
		return userMapper.selectUserCount();
	}

}
