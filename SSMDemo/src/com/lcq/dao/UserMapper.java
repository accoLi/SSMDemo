package com.lcq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lcq.pojo.User;
@Repository
public interface UserMapper {
   public User selectUserByUserName(@Param("username1")String userName,@Param("psswd1")String psswd);
   public List<User> selectAllUser(@Param("start")int pageNumber,@Param("pageSize")int pageSize);
   public int selectUserCount();
}
