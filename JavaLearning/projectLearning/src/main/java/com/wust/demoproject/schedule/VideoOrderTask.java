package com.wust.demoproject.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

//定时统计订单
@Component
public class VideoOrderTask {

    //每两秒执行一次
//    @Scheduled(fixedRate = 2000)//fixedRate:定时多久执行一次  fixedDelay:上一次执行结束时间点后xx秒再次执行
    @Scheduled(cron = "*/1 * * * * *")//
    public void sum(){
        System.out.println(LocalDateTime.now()+"当前交易额="+Math.random());

        try{
            Thread.sleep(4000L);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
