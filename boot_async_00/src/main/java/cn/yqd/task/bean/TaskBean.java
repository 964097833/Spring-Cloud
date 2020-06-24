package cn.yqd.task.bean;


import org.quartz.Job;
import org.quartz.JobKey;

import java.util.Map;

//@Entity
public class TaskBean {

    /**定时任务 的名字和分组名 JobKey*/
    private JobKey jobKey;

    /**定时任务 的描述(可以定时任务本身的描述,也可以是触发器的)*/
    private String description;

    /**定时任务 的执行cron*/
    private String cronExpression;

    /**定时任务 的元数据*/
    private Map<?, ?> jobDataMap;

    /**定时任务 的 具体执行逻辑类*/
    private Class<? extends Job> jobClass;

    public JobKey getJobKey() {
        return jobKey;
    }

    public void setJobKey(JobKey jobKey) {
        this.jobKey = jobKey;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public Map<?, ?> getJobDataMap() {
        return jobDataMap;
    }

    public void setJobDataMap(Map<?, ?> jobDataMap) {
        this.jobDataMap = jobDataMap;
    }

    public Class<? extends Job> getJobClass() {
        return jobClass;
    }

    public void setJobClass(Class<? extends Job> jobClass) {
        this.jobClass = jobClass;
    }
}