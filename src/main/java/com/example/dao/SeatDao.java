package com.example.dao;

import com.example.domain.Seat;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SeatDao {
    @Insert("INSERT INTO toma_seat (state,attributes,a_name) VALUES (#{state},#{attributes},#{a_name})")
    public void save(Seat seat);
    @Select("SELECT * FROM  toma_seat")
    public List<Seat> getAll();
    @Delete("DELETE FROM toma_affair WHERE id = #{id}")
    public void delete(Integer id);
    @Update("UPDATE toma_seat SET state = #{state},attributes = #{attributes},a_name = #{a_name} WHERE id = #{id}")
    public void  update(Seat seat);
}
