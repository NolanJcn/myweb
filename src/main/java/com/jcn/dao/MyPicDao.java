package com.jcn.dao;

import com.jcn.entity.MyPic;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MyPicDao {

    @Insert("INSERT into pic_details (pic_id,pic_name,pic_url,type_id) " +
            "values(#{picId,jdbcType=INTEGER},#{picName,jdbcType=VARCHAR},#{picUrl,jdbcType=VARCHAR},#{typeId,jdbcType=INTEGER})")
    void savePic(MyPic myPic);

    @Select("select * from pic_details")
    List<MyPic> MyPicList();


    @Select("select * from pic_details where type_id =" +
            " (select type_id from pic_type where type_name = #{typeName})")
    List<MyPic> picTypeList(@Param("typeName") String typeName);

}
