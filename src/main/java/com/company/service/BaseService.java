package com.company.service;

import com.github.pagehelper.PageInfo;

import java.util.Map;


public interface BaseService<T> {

    PageInfo<Map> query(Map map);

    void delete(Map map);

    void add(Map map);

    void update(Map map);

}
