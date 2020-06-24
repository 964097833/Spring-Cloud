package cn.yqd.task;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

@DisallowConcurrentExecution
public class TaskJob implements Job {

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println("TaskService,执行："+new SimpleDateFormat().format(new Date()));
    }
}
