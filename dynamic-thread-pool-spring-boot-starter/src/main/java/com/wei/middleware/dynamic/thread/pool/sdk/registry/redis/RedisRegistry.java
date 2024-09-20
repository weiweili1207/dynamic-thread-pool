package com.wei.middleware.dynamic.thread.pool.sdk.registry.redis;

import com.wei.middleware.dynamic.thread.pool.sdk.domain.model.entity.ThreadPoolConfigEntity;
import com.wei.middleware.dynamic.thread.pool.sdk.registry.IRegistry;
import org.redisson.api.RedissonClient;

import java.util.List;

/*
 *@description redis registry center
 *@author wei li
 *@create 9/19/2024
 * */
public class RedisRegistry implements IRegistry {
    private final RedissonClient redissonClient;

    public RedisRegistry(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @Override
    public void reportThreadPool(List<ThreadPoolConfigEntity> threadPoolConfigEntities) {

    }

    @Override
    public void reportThreadPoolConfigParameter(ThreadPoolConfigEntity threadPoolConfigEntity) {

    }
}
