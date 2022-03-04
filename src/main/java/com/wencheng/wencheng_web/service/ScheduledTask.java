//package com.wencheng.wencheng_web.service;
//
//import com.wencheng.wencheng_web.Mapper.UserMapper;
//import com.wencheng.wencheng_web.pojo.User;
//import org.quartz.SchedulerException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.stereotype.Component;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//
//@Configuration
//@Component
//@EnableScheduling
//public class ScheduledTask {
//    @Autowired
//    private UserMapper userMapper;
////    public User SelectUserInfos(){
////        User user=new User();
////        user.setUsername("刘凯");
////        user.setPassword("123456");
////       User user1= userMapper.finduser(user);
////       if (user1!=null){
////           System.out.println("定时查询数据库成功数据库为"+user1);
////       }
////       else {
////           System.out.println("定时查询数据库失败");
////       }
////       return  user1;
////    }
//    public List<User> SelectUserInfo() throws SchedulerException {
//        Date day=new Date();
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//
//            System.out.println("现在时间"+df.format(day)+"打贝贝...");
//        try {
//            Thread.sleep(75000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("现在时间"+df.format(day)+"过去了75秒...");
//
//        List user = new ArrayList();
//        user =userMapper.findusers();
////        long currentTimeMillis = System.currentTimeMillis();
//
//
//        if (user!=null){
//            System.out.println("轮询数据库成功"+df.format(day));
//
//
//        }
//        else {
//            System.out.println("轮询数据库失败");
//        }
//        return  user;
//    }
//
//}
