package com.example.dao;

import com.example.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("SELECT * FROM toma_users WHERE num = #{num}")
    public User getByNum(String num);
    @Insert("INSERT INTO toma_users (num,account,password) VALUES (#{num},#{account},#{password}) ")
    public void User_save(User user);
    @Update("UPDATE toma_users set account = #{account},password = #{password} WHERE num = #{num}}")
    public void User_update(User user);
    @Select("SELECT * FROM toma_users")
    public List<User> User_getAll();
}
