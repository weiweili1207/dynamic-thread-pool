package com.wei.middleware.dynamic.thread.pool.sdk.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
 *@description dynamic thread pool config
 *@author wei li
 *@create 9/19/2024
 * */
@Component
@ConfigurationProperties(prefix = "dynamic.thread.pool.config", ignoreInvalidFields = true)
public class DynamicThreadPoolAutoProperties {
    /*status: open , close*/
    private boolean enable;
    /*redis host*/
    private String host;
    /*redis port*/
    private int port;
    /*password*/
    private String password;
    /*set pool size default 64*/
    private int poolSize = 64;
    /*Set the minimum number of idle connections in the connection pool. The default value is 10.*/
    private int minIdleSize = 10;
    /*Set the maximum idle time of the connection (unit: milliseconds). Idle connections exceeding this time will be closed. The default value is 10000*/
    private int idleTimeout = 10000;
    /*Set the connection timeout (unit: milliseconds), the default is 10000*/
    private int connectTimeout = 10000;
    /*Set the number of connection retries, the default is 3*/
    private int retryAttempts = 3;
    /*Set the connection retry interval (unit: milliseconds), the default is 1000*/
    private int retryInterval = 1000;
    /*Set the time interval (in milliseconds) for periodically checking whether the connection is available. The default value is 0, which means no periodic check.*/
    private int pingInterval = 0;
    /*Set whether to maintain a long connection, the default is true*/
    private boolean keepAlive = true;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }

    public int getMinIdleSize() {
        return minIdleSize;
    }

    public void setMinIdleSize(int minIdleSize) {
        this.minIdleSize = minIdleSize;
    }

    public int getIdleTimeout() {
        return idleTimeout;
    }

    public void setIdleTimeout(int idleTimeout) {
        this.idleTimeout = idleTimeout;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getRetryAttempts() {
        return retryAttempts;
    }

    public void setRetryAttempts(int retryAttempts) {
        this.retryAttempts = retryAttempts;
    }

    public int getRetryInterval() {
        return retryInterval;
    }

    public void setRetryInterval(int retryInterval) {
        this.retryInterval = retryInterval;
    }

    public int getPingInterval() {
        return pingInterval;
    }

    public void setPingInterval(int pingInterval) {
        this.pingInterval = pingInterval;
    }

    public boolean isKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(boolean keepAlive) {
        this.keepAlive = keepAlive;
    }
}
