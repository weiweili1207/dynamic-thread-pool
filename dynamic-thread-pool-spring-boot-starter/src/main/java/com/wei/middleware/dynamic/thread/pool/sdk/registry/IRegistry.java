package com.wei.middleware.dynamic.thread.pool.sdk.registry;

import com.wei.middleware.dynamic.thread.pool.sdk.domain.model.entity.ThreadPoolConfigEntity;

import java.util.List;

/*
 *@description registry center
 *@author wei li
 *@create 9/19/2024
 * */
public interface IRegistry {
    void reportThreadPool(List<ThreadPoolConfigEntity> threadPoolConfigEntities);

    void reportThreadPoolConfigParameter(ThreadPoolConfigEntity threadPoolConfigEntity);
}
