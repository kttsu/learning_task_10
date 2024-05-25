package com.tsuchiya.live;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;


@Mapper
public interface LiveMapper {


    @Insert("INSERT INTO live (schedule ,name ,location) VALUES (#{schedule}, #{name}, #{location})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Live live);

}

