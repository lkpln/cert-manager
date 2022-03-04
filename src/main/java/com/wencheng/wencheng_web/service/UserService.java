package com.wencheng.wencheng_web.service;

import com.wencheng.wencheng_web.pojo.Result;
import com.wencheng.wencheng_web.pojo.User;

import java.util.List;


public interface UserService {
    User finduser(User user);
    int userRegister(User user);
//    int userRegisterApp(User user);
         List<User> findusers();
    User findUserByappId(String appId);
    Result userRegisters(User user);
    Result xtqmuserRegister(User user);
    Result updateUser(User user);
    Result deleteUser(User user);
    Result loginUser(User user);

}
