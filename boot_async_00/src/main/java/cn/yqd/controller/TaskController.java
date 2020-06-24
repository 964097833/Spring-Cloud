package cn.yqd.controller;

import cn.yqd.task.TaskJob;
import cn.yqd.task.bean.TaskBean;
import cn.yqd.task.service.TaskService;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    //假如 这个定时任务的 名字叫做HelloWorld, 组名GroupOne
    private final JobKey jobKey = JobKey.jobKey("oneJob", "Group1");

    /**
     * 启动 hello world
     */
    @RequestMapping("/startJob")
    public String startHelloWorldJob() throws SchedulerException {
        //创建一个定时任务
        TaskBean task = new TaskBean();
        task.setJobKey(jobKey);;
        task.setCronExpression("0/2 * * * * ? ");
        task.setJobClass(TaskJob.class);   //定时任务 的具体执行逻辑
        task.setDescription("这是一个测试的 任务");    //定时任务 的描述
        taskService.scheduleJob(task);
        return "启动任务调度成功";
    }

    /**
     * 暂停 hello world
     */
    @GetMapping("/pauseJob")
    public String pauseHelloWorldJob() throws SchedulerException {
        taskService.pauseJob(jobKey);
        return "暂停任务调度成功";
    }

    /**
     * 恢复 hello world
     */
    @GetMapping("/resumeJob")
    public String resumeHelloWorldJob() throws SchedulerException {
        taskService.resumeJob(jobKey);
        return "恢复任务调度成功";
    }

    /**
     * 删除 hello world
     */
    @GetMapping("/deleteJob")
    public String deleteHelloWorldJob() throws SchedulerException {
        taskService.deleteJob(jobKey);
        return "删除任务调度成功";
    }

    /**
     * 修改 hello world 的cron表达式
     */
    @GetMapping("/modifyJobCron")
    public String modifyHelloWorldJobCron() {
        TaskBean task = new TaskBean();
        task.setJobKey(jobKey);;
        task.setCronExpression("0/5 * * * * ? ");
        task.setJobClass(TaskJob.class);   //定时任务 的具体执行逻辑
        task.setDescription("这是一个测试的 任务");    //定时任务 的描述
        try {
            taskService.scheduleJob(task);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        if (taskService.modifyJobCron(task))
            return "任务调度修改成功";
        else
            return "任务调度修改失败";
    }
}
