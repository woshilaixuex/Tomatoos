package com.example.dao;

import com.example.domain.Frequency;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface FrequencyDao {
    @Select("SELECT * FROM toma_fre WHERE num = #{num}")
    public Frequency getByNum(String num);
    @Select("SELECT * FROM toma_fre")
    public List<Frequency> getAll();
    @Insert("INSERT INTO toma_fre (num,clock_f) VALUES (#{num},#{clock_f})")
    public void save(Frequency frequency);
    @Update("UPDATE toma_fre SET clock_f = #{clock_f} WHERE num = #{num}")
    public void update(Frequency frequency);
}
