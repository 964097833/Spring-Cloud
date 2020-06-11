package cn.yqd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class ExecutorConfig {
    @Bean
    public Executor myExecutor() {
        //新建ThreadPoolTaskExecutor作为异步线程池的指定线程池
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(5);
        //配置最大线程数
        executor.setMaxPoolSize(6);
        //配置队列大小
        executor.setQueueCapacity(99999);
        //配置线程池中的线程名称前缀
        executor.setThreadNamePrefix("async-service-");
        //指定线程策略为CallerRunsPolicy拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }

    public boolean asyncShutDown(ThreadPoolTaskExecutor executor) {
        try {
            int poolSize1 = executor.getPoolSize();
            System.out.println("当前异步线程池中的线程池最大线程数为："+poolSize1);
            executor.setAwaitTerminationSeconds(6);
            executor.setWaitForTasksToCompleteOnShutdown(true);
            int poolSize2 = executor.getPoolSize();
            executor.shutdown();
            System.out.println("当前异步线程池中的线程池最大线程数为："+poolSize2);
            return true;
        } catch (Exception e) {
            System.out.println("异步线程池关闭出错！");
            return false;
        }
    }
}
