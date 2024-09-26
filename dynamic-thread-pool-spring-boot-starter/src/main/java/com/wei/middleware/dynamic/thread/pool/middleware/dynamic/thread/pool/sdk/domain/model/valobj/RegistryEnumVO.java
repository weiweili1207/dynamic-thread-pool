package com.wei.middleware.dynamic.thread.pool.middleware.dynamic.thread.pool.sdk.domain.model.valobj;

/*
 *@description  registry center enumerate key object
 *@author wei li
 *@create 9/20/2024
 * */

public enum RegistryEnumVO {
    THREAD_POOL_CONFIG_LIST_KEY("THREAD_POOL_CONFIG_LIST_KEY", "Pooling configuration list"),
    THREAD_POOL_CONFIG_PARAMETER_LIST_KEY("THREAD_POOL_CONFIG_PARAMETER_LIST_KEY", "Pooling configuration parameters"),
    DYNAMIC_THREAD_POOL_REDIS_TOPIC("DYNAMIC_THREAD_POOL_REDIS_TOPIC", "Dynamic thread pool listening topic configuration");

    private final String key;
    private final String desc;

    RegistryEnumVO(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public String getKey() {
        return key;
    }

    public String getDesc() {
        return desc;
    }
}
