package com.wei.middleware.dynamic.thread.pool.sdk.config;

import com.alibaba.fastjson.JSON;
import com.wei.middleware.dynamic.thread.pool.sdk.domain.DynamicThreadPoolService;
import com.wei.middleware.dynamic.thread.pool.sdk.registry.IRegistry;
import com.wei.middleware.dynamic.thread.pool.sdk.registry.redis.RedisRegistry;
import org.apache.commons.lang.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.codec.JsonJacksonCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;

/*
 *@description auto config entry
 *@author wei li
 *@create 9/12/2024
 * */
@Configuration
public class DynamicThreadPoolAutoConfig {
    private final Logger logger = LoggerFactory.getLogger(DynamicThreadPoolAutoConfig.class);

    @Bean("dynamicThreadRedissonClient")
    public RedissonClient redissonClient(DynamicThreadPoolAutoProperties properties) {
        Config config = new Config();
        /*Codec can be set as needed*/
        config.setCodec(JsonJacksonCodec.INSTANCE);
        config.useSingleServer()
                .setAddress("redis://" + properties.getHost() + ":" + properties.getPort())
                .setPassword(properties.getPassword())
                .setConnectionPoolSize(properties.getPoolSize())
                .setConnectionMinimumIdleSize(properties.getMinIdleSize())
                .setIdleConnectionTimeout(properties.getIdleTimeout())
                .setConnectTimeout(properties.getConnectTimeout())
                .setRetryAttempts(properties.getRetryAttempts())
                .setRetryAttempts(properties.getRetryAttempts())
                .setPingConnectionInterval(properties.getPingInterval())
                .setKeepAlive(properties.isKeepAlive())
        ;
        RedissonClient redissonClient = Redisson.create(config);

        logger.info("Dynamic thread pool, registrar (redis) connection initialization completed. {} {} {}", properties.getHost(), properties.getPoolSize(), !redissonClient.isShutdown());

        return redissonClient;
    }

    @Bean
    public IRegistry redisRegistry(RedissonClient redissonClient) {
        return  new RedisRegistry(redissonClient);
    }

    @Bean("dynamicThreadPoolService")
    public DynamicThreadPoolService dynamicThreadPoolService(ApplicationContext applicationContext, Map<String, ThreadPoolExecutor> threadPoolExecutorMap) {

        String applicationName = applicationContext.getEnvironment().getProperty("spring.application.name");
        if (StringUtils.isBlank(applicationName)) {
            applicationName = "Default";
            logger.warn("Dynamic Thread Pool, Start Message. SpringBoot Application not Configure, spring.application.name cannot get name");
        }

        return new DynamicThreadPoolService(applicationName, threadPoolExecutorMap);
    }
}
