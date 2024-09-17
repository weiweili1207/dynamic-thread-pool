package com.wei.middleware.dynamic.thread.pool.sdk.domain;

import com.wei.middleware.dynamic.thread.pool.sdk.domain.model.entity.ThreadPoolConfigEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/*
 *@description dynamic thread pool service-get data
 *@author wei li
 *@create 9/16/2024
 * */
public class DynamicThreadPoolService implements IDynamicThreadPoolService{

    private final Logger logger = LoggerFactory.getLogger(DynamicThreadPoolService.class);

    @Override
    public List<ThreadPoolConfigEntity> queryThreadPoolList() {
        return List.of();
    }

    @Override
    public ThreadPoolConfigEntity queryThreadPoolListByName(String threadPoolName) {
        return null;
    }

    @Override
    public void updateThreadPoolConfig(ThreadPoolConfigEntity threadPoolConfigEntity) {

    }
}
