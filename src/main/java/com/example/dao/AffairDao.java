package com.example.dao;

import com.example.domain.Affair;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AffairDao {
    @Select("SELECT * FROM toma_affair WHERE num = #{num}")
    public List<Affair> getByNum(String num);
    @Update("UPDATE toma_affair SET A_name = #{A_name},num = #{num},open = #{open},o_time = #{o_time} WHERE id = #{id}")
    public void update(Affair affair);
    @Insert("INSERT INTO  toma_affair (A_name,num,open,o_time) VALUES (#{A_name},#{num},#{open},#{o_time})")
    public void save(Affair affair);
    @Delete("DELETE FROM toma_affair WHERE id = #{id}")
    public void delete(Integer id);
}
