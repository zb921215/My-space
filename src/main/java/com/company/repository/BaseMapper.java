package com.company.repository;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

@Mapper
public interface BaseMapper<T> {

    List<Map> queryByObject(Map map);

    void delete(Map map);

    void insertByEntity(Map map);

    void updateByEntity(Map map);



}