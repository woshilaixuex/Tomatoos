package com.example.dao;

import com.example.domain.Introduction;
import com.example.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface IntroductionDao {
    @Select("SELECT * FROM toma_intro WHERE id = #{id}")
    public User intro_getById(String id);
    @Insert("INSERT INTO toma_intro (id,email,massage,ava_image,back_image) VALUES (#{id},#{email},#{massage},#{ava_image},#{back_image}) ")
    public void intro_save(Introduction introduction);
    @Update("UPDATE toma_intro set id = #{id},email = #{email},massage = #{massage},ava_image = #{ava_image},back_image = = #{back_image}")
    public void intro_update(Introduction introduction);
}
