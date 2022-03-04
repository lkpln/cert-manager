package com.wencheng.wencheng_web.service;

import com.wencheng.wencheng_web.Mapper.UserMapper;
import com.wencheng.wencheng_web.pojo.CommonUser;
import com.wencheng.wencheng_web.pojo.Enum;
import com.wencheng.wencheng_web.pojo.Result;
import com.wencheng.wencheng_web.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xtqm.code.server.service.XTQMJarService;

import java.util.List;

@Service
@Transactional
public class UserServiceimpl implements  UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private  UserService userService;


    @Override
    public User finduser(User user) {
        return userMapper.finduser(user);
    }

    @Override
    public int userRegister(User user) {
        return userMapper.userRegister(user);
    }

    @Override
    public List<User> findusers() {
        return userMapper.findusers();
    }

    @Override
    public User findUserByappId(String appId) {
        return userMapper.findUserByappId(appId);
    }

    @Override
    @Transactional
    public Result userRegisters(User user) {
        User i = userMapper.finduser(user);
        if (i != null) {
            System.out.println("用户已经存在！");
            return new Result(Enum.FAIL.getCode(), Enum.FAIL.getMessage(), "用户已经存在！");
        } else {
            try {
                int result1 = userService.userRegister(user);
                if (result1 > 0) {
                    System.out.println("用户注册成功！");
                    return new Result(Enum.OK.getCode(), Enum.OK.getMessage(), "普通用户注册成功！");
                } else {
                    return new Result(Enum.FAIL.getCode(), Enum.FAIL.getMessage(), "普通用户注册失败！");
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException();
            }

        }
    }

    @Override
    @Transactional
    public Result xtqmuserRegister(User user) {
        User i = userMapper.finduser(user);
        if (i != null) {
            System.out.println("用户名已经存在！");
            return new Result(Enum.FAIL.getCode(), Enum.FAIL.getMessage(), "用户名已经存在！");
        } else {
            try {
                CommonUser commonUser = new CommonUser();
                String userType = "5";
                String businessType = "1";
                commonUser.setUsername(user.getUsername());
                commonUser.setMobilePhoneNumber(user.getMobilePhoneNumber());
                commonUser.setIdentifyCard(user.getIdentifyCard());
                commonUser.setEmail(user.getEmail());
                commonUser.setUnitCode(user.getUnitCode());
                commonUser.setUnitName(user.getUnitName());
                commonUser.setUserType(userType);
                commonUser.setBusinessType(businessType);
                XTQMJarService xtqmJarService = new XTQMJarService();
                xtqmJarService.setConfig("/root/xtqmtest/xtqm-jar.properties");
//                xtqmJarService.setConfig("D:\\byzk\\xtqm-jar\\xtqm-jar.properties");
                xtqm.code.server.vo.Result result1 = xtqmJarService.userRegister(commonUser);
                if (result1.getCode() == 0 || result1.getCode()==20003) {
                    int result = userService.userRegister(user);
                    if (result>0){
                        return new Result(Enum.OK.getCode(), Enum.OK.getMessage(), "用户注册成功并同步为协签用户！");
                    }
                    return new Result(Enum.FAIL.getCode(), Enum.FAIL.getMessage(), "用户注册失败！");
                }
                else {
                    return new Result(Enum.FAIL.getCode(), Enum.FAIL.getMessage(), "用户注册失败！");
                }

            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
    }

    @Override
    public Result updateUser(User user) {
        int i=userMapper.updateUser(user);
        if (i>0){
            return new Result(Enum.OK.getCode(), Enum.OK.getMessage(), "更新用户成功！");
        }
        else {
            return new Result(Enum.FAIL.getCode(), Enum.FAIL.getMessage(), "更新用户失败！");
        }

    }

    @Override
    public Result deleteUser(User user) {
       int i= userMapper.deleteUser(user);
        if (i>0){
            return new Result(Enum.OK.getCode(), Enum.OK.getMessage(), "注销用户成功！");
        }
        else {
            return new Result(Enum.FAIL.getCode(), Enum.FAIL.getMessage(), "注销用户失败！");
        }
    }

    @Override
    public Result loginUser(User user) {
        User u=userMapper.loginUser(user);
        if (u!=null){
            return new Result(Enum.OK.getCode(), Enum.OK.getMessage(), u.getMobilePhoneNumber());
        }
        else {
            return new Result(Enum.FAIL.getCode(), Enum.FAIL.getMessage(), "用户登录失败！");
        }

    }
}
