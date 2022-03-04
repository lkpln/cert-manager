//package com.wencheng.wencheng_web.service;
//
//import com.wencheng.wencheng_web.Mapper.UserMapper;
//import org.quartz.CronTrigger;
//import org.quartz.JobDetail;
//import org.quartz.Scheduler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//
//@Configuration
//@EnableScheduling
//@Component
//public class ScheduleRefreshService {
//    @Autowired
//   private  UserMapper  userMapper;
//    @Resource(name = "jobDetail")
//    private JobDetail jobDetail;
//
//    @Resource(name = "jobTrigger")
//    private CronTrigger cronTrigger;
//
//    @Resource(name = "scheduler")
//    private Scheduler scheduler;
////    @Scheduled(fixedRate = 10000)
////    public List<User>SelectUserInfo() throws SchedulerException {
////        List user = new ArrayList();
////       user =userMapper.findusers();
////       if (user!=null){
////           System.out.println("轮询数据库成功"+user);
////       }
////       else {
////           System.out.println("轮询数据库失败");
////       }
////       return  user;
////    }
//
//}
