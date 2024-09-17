package com.wei.middleware.dynamic.thread.pool.sdk.domain;

import com.wei.middleware.dynamic.thread.pool.sdk.domain.model.entity.ThreadPoolConfigEntity;
import java.util.List;
/*
 *@description dynamic thread pool service-get data
 *@author wei li
 *@create 9/15/2024
 * */
public interface IDynamicThreadPoolService {
    List<ThreadPoolConfigEntity> queryThreadPoolList();

    ThreadPoolConfigEntity queryThreadPoolListByName(String threadPoolName);

    void updateThreadPoolConfig(ThreadPoolConfigEntity threadPoolConfigEntity);
}
