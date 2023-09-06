package com.example.dao;


import com.example.domain.Introduction;
import com.example.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface IntroductionDao {
    @Select("SELECT * FROM toma_intro WHERE num = #{num}")
    public Introduction getByNum(String num);
    @Insert("INSERT INTO toma_intro (num,username,email,message,ava_image,back_image) VALUES (#{num},#{username},#{email},#{message},#{ava_image},#{back_image}) ")
    public void save(Introduction introduction);
    @Update("UPDATE toma_intro SET username = #{username}, email = #{email}, message = #{message}, ava_image = #{ava_image}, back_image = #{back_image} WHERE num = #{num}")
    public void update(Introduction introduction);

}
