package com.example.dao;

import com.example.domain.Affair;
import com.example.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AffairDao {
    @Select("SELECT * FROM toma_affairs WHERE id = #{id}")
    public List<User> Affair_getById(String id);
    @Insert("INSERT INTO toma_affairs (id,A_name,A_time) VALUES (#{id},#{A_name},#{A_time}) ")
    public void save(Affair affair);

}
