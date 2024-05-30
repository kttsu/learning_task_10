package com.tsuchiya.live;

import org.apache.ibatis.annotations.*;

import java.util.Optional;


@Mapper
public interface LiveMapper {


    @Insert("INSERT INTO live (schedule ,name ,location) VALUES (#{schedule}, #{name}, #{location})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Live live);

    @Select("SELECT * FROM live WHERE id = #{id}")
    Optional<Live> findById(Integer id);

    @Update("UPDATE live SET schedule = #{schedule}, name = #{name}, location = #{location} WHERE id = #{id}")
    void update(Live live);
}

