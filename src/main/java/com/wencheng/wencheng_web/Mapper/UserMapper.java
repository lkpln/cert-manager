package com.wencheng.wencheng_web.Mapper;

import com.wencheng.wencheng_web.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("  select * from user where username=#{username}")
    User finduser(User user);
    @Select("  select * from user where username=#{username} and password=#{password}")
    User loginUser(User user);
//    @Insert("insert into USER_INFO_COMMON (username,mobilePhoneNumber,identifyCard,email,unitCode,unitName,taxServiceCode,taxServiceName)values(#{username},#{mobilePhoneNumber},#{identifyCard},#{email},#{unitCode},#{unitName},#{taxServiceCode},#{taxServiceName})")
////    int userRegisterApp(User user);
     @Insert("insert into user (username,password,mobilePhoneNumber,identifyCard,email,appId)values(#{username},#{password},#{mobilePhoneNumber},#{identifyCard},#{email},#{appId})")
     int userRegister(User user);
    @Select("  select * from user")
    List<User> findusers();
    @Select("select * from user where appId=#{appId}")
    User findUserByappId(String appId);

    @Update("update user set password=#{password} where id=#{id}")
    int updateUser(User user);
    @Delete("delete from  user  where id=#{id}")
    int deleteUser(User user);
}
