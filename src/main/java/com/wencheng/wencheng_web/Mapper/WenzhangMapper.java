package com.wencheng.wencheng_web.Mapper;


import com.wencheng.wencheng_web.pojo.Wenzhang;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WenzhangMapper {
    @Insert("insert into article (article,articleSign,status,username) values (#{article},#{articleSign},1,#{username})")
    int  AddWenZhang(Wenzhang wenzhang);
    @Select("select * from article  ORDER BY id DESC")
    List<Wenzhang> selectwenzhang () ;
    @Delete ( "delete  from  article where id=#{id}" )
    int delwenzhang(Wenzhang wenzhang);
    @Update("update article set articleSign=#{articleSign},status=1 where id=#{id}")
      int updateWenzhang(Wenzhang wenzhang);
    @Select("select * from wenzhang where name=#{name} ")
    List<Wenzhang>  selectwenzhangByname (String name);
    @Select("select * from wenzhang where id=#{id} ")
    List<Wenzhang>  selectwenzhangByid (String id);
    @Update("update article set articleSign=#{articleSign},status=#{status} where id=#{id}")
    int updateWenzhangs(Wenzhang wenzhang);
    @Select("select articleSign from article  where username=#{username}")
    String  getStatus(String username);
}
