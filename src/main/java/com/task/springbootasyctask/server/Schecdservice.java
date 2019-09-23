package com.task.springbootasyctask.server;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author XAIOHU
 * @date 2019/9/23 --9:36
 **/
@Service
public class Schecdservice {

     //cron  秒.分.時.天.月.星期:
     //@EnaleScheduling @Scheduled
     //crom taskScheduled
      //taskScheduled
   //cron 表达式
    //second<秒> minute<分>.hour<时> day<天>  month<月>         week<周>
    //             1/4 --每隔4秒执行一次.在第一秒开始    ? *<任意>      L-最后一个 W工作日   0-7  SUM-SAT
    //  , --两个时间点:13:18 每天13点18点
    //0 * * * * MON-FRI 每一分钟都启动一次;
    //开启注解的定时任务: 整点打印;
  /*  @Scheduled(cron = "0 * * * * MON-FRI") //sum-
    public void hello() {
        System.out.println("hello ---定时任务");

    }*/
  //0,1,2,3,4 秒都会启动一次
    //cron = "0-4  * * * * MON-FRI" --0到4秒都会执行一次
    //cron=0/4 * * * * 0-7   --每四秒执行一次    --0-7到日-一
    //                  4#2  --第二个星期四 1#4 第四个星期一
    //                    ? --每个月 1-3 周一到周3

    @Scheduled(cron = "0-5 32 10 ? * 1") //sum- sat 0-7 sat -6 mon-1

    public void hello() {
        System.out.println("hello ---定时任务");

    }

}
