package com.example.dao;

import com.example.domain.FrequencyHis;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FrequencyHisDao {
    @Select("SELECT * FROM toma_frehis WHERE num = #{num}")
    public List<FrequencyHis> getByNum(String num);
    @Select("SELECT * FROM toma_frehis WHERE num = #{num} , date = #{date}}")
    public FrequencyHis have(FrequencyHis frequencyHis);
    @Select("SELECT * FROM toma_frehis")
    public List<FrequencyHis> getAll();
    @Insert("INSERT INTO toma_frehis (num,date,usernaame) VALUES (#{num},#{date},#{username})))")
    public void save(FrequencyHis frequencyHis);
}
