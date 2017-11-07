package com.lcq.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.lcq.pojo.User;

public interface UserService {
  public User queryUserByUsername(String userName,String psswd);
  public List<User> selectAllUser(int pageNumber,int pageSize);
  public int selectUserCount();
}
