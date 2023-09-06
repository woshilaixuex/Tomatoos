package com.example.dao;

import com.example.domain.AffairHis;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AffairHisDao {
    @Select("SELECT * FROM toma_affairhis WHERE num = #{num}")
    public List<AffairHis> getByNum(String num);
    @Insert("INSERT INTO  toma_affairhis (num,a_name,DuTime,o_time) VALUES (#{num},#{a_name},#{DuTime},#{o_time})")
    public void save(AffairHis affairHis);
}
