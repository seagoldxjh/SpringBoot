/**
 * FileName: ScheduledSerivce
 * Author:   xjh
 * Date:     2019-08-14 13:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈定时任务〉
 * cron表达式
 * 0 0 10,14,16 * * ? 每天上午10点，下午2点，4点
 * 0 0/30 9-17 * * ? 朝九晚五工作时间内每半小时
 * 0 0 12 ? * WED 表示每个星期三中午12点
 * "0 0 12 * * ?" 每天中午12点触发
 * "0 15 10 ? * *" 每天上午10:15触发
 * "0 15 10 * * ?" 每天上午10:15触发
 * "0 15 10 * * ? *" 每天上午10:15触发
 * "0 15 10 * * ? 2005" 2005年的每天上午10:15触发
 * "0 * 14 * * ?" 在每天下午2点到下午2:59期间的每1分钟触发
 * "0 0/5 14 * * ?" 在每天下午2点到下午2:55期间的每5分钟触发
 * "0 0/5 14,18 * * ?" 在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发
 * "0 0-5 14 * * ?" 在每天下午2点到下午2:05期间的每1分钟触发
 * "0 10,44 14 ? 3 WED" 每年三月的星期三的下午2:10和2:44触发
 * "0 15 10 ? * MON-FRI" 周一至周五的上午10:15触发
 * "0 15 10 15 * ?" 每月15日上午10:15触发
 * "0 15 10 L * ?" 每月最后一日的上午10:15触发
 * "0 15 10 ? * 6L" 每月的最后一个星期五上午10:15触发
 * "0 15 10 ? * 6L 2002-2005" 2002年至2005年的每月的最后一个星期五上午10:15触发
 * "0 15 10 ? * 6#3" 每月的第三个星期五上午10:15触发
 */
@Service
public class ScheduledService {

    //表达式（秒 分 时 天 月 周几）
    @Scheduled(cron = "0 * * * * MON-SAT")
    public void Scheduled(){
        System.out.println("定时任务执行");
    }
}