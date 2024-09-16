package com.wei.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "thread.pool.executor.config", ignoreInvalidFields = true)
public class ThreadPoolConfigProperties {
    /*The core number of threads that will always remain alive in the pool, even if they are idle*/
    private Integer corePoolSize = 20;
    /* The maximum number of threads allowed in the pool.*/
    private Integer maxPoolSize = 200;
    /*The time that excess idle threads (above the core pool size) will wait for new tasks before terminating*/
    private Long keepAliveTime = 10L;
    /*The queue used to store tasks before they are executed. The size of this queue is determined by the configuration.*/
    private Integer blockQueueSize = 5000;
    /*
    * AbortPolicy: Throws an exception when a task cannot be executed
    * DiscardPolicy: Silently discards the rejected task.
    * DiscardOldestPolicy: Discards the oldest task in the queue and attempts to retry the new task.
    * CallerRunsPolicy: Executes the task in the calling thread instead of using a thread from the pool.
    * */
    private  String policy = "AbortPolicy";
}
