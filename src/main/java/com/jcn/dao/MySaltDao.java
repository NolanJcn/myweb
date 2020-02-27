package com.jcn.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
public interface MySaltDao {

    @Select("select*from t_salt")
    String getMySalt();
}
