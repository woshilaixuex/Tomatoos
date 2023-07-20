package com.example.dao;

import com.example.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface UserDao {
    @Insert("insert into toma_users (id,username,password,account) values(#{id},#{username},#{pw},#{ac}})")
    public int save(User user);
    @Update("update toma_users set  username = #{username}, pasword = #{pw} where ac = #{ac}")
    public int update(User user);
    @Select("select * from toma_users where id = #{id}")
    public User getById(String id);
    @Select("select * from toma_users")
    public List<User> getAll();
}
