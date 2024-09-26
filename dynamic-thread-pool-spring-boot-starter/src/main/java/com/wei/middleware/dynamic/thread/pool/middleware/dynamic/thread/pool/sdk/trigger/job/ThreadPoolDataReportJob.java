package com.wei.middleware.dynamic.thread.pool.middleware.dynamic.thread.pool.sdk.trigger.job;

import com.alibaba.fastjson.JSON;
import com.wei.middleware.dynamic.thread.pool.middleware.dynamic.thread.pool.sdk.domain.IDynamicThreadPoolService;
import com.wei.middleware.dynamic.thread.pool.middleware.dynamic.thread.pool.sdk.domain.model.entity.ThreadPoolConfigEntity;
import com.wei.middleware.dynamic.thread.pool.middleware.dynamic.thread.pool.sdk.registry.IRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

/*
 *@description thread pool report job
 *@author wei li
 *@create 9/20/2024
 * */
public class ThreadPoolDataReportJob {
    private final Logger logger = LoggerFactory.getLogger(ThreadPoolDataReportJob.class);
    //get thread pool service data
    private final IDynamicThreadPoolService dynamicThreadPoolService;
    //report
    private final IRegistry registry;

    public ThreadPoolDataReportJob(IDynamicThreadPoolService dynamicThreadPoolService, IRegistry registry) {
        this.dynamicThreadPoolService = dynamicThreadPoolService;
        this.registry = registry;
    }

    @Scheduled(cron = "0/20 * * * * ?")
    public void executeReportThreadPoolList() {
        List<ThreadPoolConfigEntity> threadPoolConfigEntities = dynamicThreadPoolService.queryThreadPoolList();
        registry.reportThreadPool(threadPoolConfigEntities);
        logger.info("dynamic thread pool, report thread pool info: {}", JSON.toJSONString(threadPoolConfigEntities));

        for (ThreadPoolConfigEntity threadPoolConfigEntity : threadPoolConfigEntities) {
            registry.reportThreadPoolConfigParameter(threadPoolConfigEntity);
            logger.info("dynamic thread pool, report thread pool config: {}", JSON.toJSONString(threadPoolConfigEntity));
        }
    }
}
