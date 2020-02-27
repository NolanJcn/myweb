package com.jcn.dao;

import com.jcn.entity.MyAdmin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
public interface MyAdminDao {

    @Insert("insert into t_myadmin (id,login_acct,login_pass,username,email,createtime) " +
            "values(#{id,jdbcType=INTEGER},#{loginAcct,jdbcType=VARCHAR},#{loginPass,jdbcType=VARCHAR}," +
            "#{userName,jdbcType=VARCHAR},#{email,jdbcType=VARCHAR},#{createTime,jdbcType=TIMESTAMP}) ")
    boolean insertMyAdmin(MyAdmin myAdmin);

    @Select("select * from t_myadmin where login_acct=#{loginAcct}")
    MyAdmin getByAcct(@Param("loginAcct") String loginAcct);

}
