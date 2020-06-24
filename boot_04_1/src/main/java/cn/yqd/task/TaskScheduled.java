package cn.yqd.task;

import jdk.nashorn.internal.ir.CallNode;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@EnableScheduling
public class TaskScheduled {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedDelayString = "${jobs.fixedDelay}")
    public void getTaskA() {
        System.out.println("任务A，当前时间：" + dateFormat.format(new Date()));
    }

    @Scheduled(cron = "${jobs.cron}")
    public void getTaskB() {
        System.out.println("任务B，当前时间：" + dateFormat.format(new Date()));
    }

}
