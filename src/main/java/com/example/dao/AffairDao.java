package com.example.dao;

import com.example.domain.Affair;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AffairDao {
    @Select("SELECT * FROM toma_affair WHERE num = #{num}")
    public List<Affair> getByNum(String num);
    @Update("UPDATE toma_affair SET a_name = #{a_name},num = #{num},ReTime = #{ReTime},o_time = #{o_time},open = #{open} WHERE id = #{id}")
    public void update(Affair affair);
    @Insert("INSERT INTO  toma_affair (a_name,num,ReTime,o_time,open) VALUES (#{a_name},#{num},#{ReTime},#{o_time},#{open})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void save(Affair affair);
    @Delete("DELETE FROM toma_affair WHERE id = #{id}")
    public void delete(Integer id);
}
