package com.silhouette.egobuy.utils.redis;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisCluster;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 14:52
 * @description: Jedis集群版工具类
 */
public class JedisClientCluster implements JedisClient {

    @Autowired
    private JedisCluster jedisCluster ;

    /**
     * @return the jedisCluster
     */
    public JedisCluster getJedisCluster() {
        return jedisCluster;
    }

    /**
     * @param jedisCluster the jedisCluster to set
     */
    public void setJedisCluster(JedisCluster jedisCluster) {
        this.jedisCluster = jedisCluster;
    }

    @Override
    public String set(String key, String value) {
        return jedisCluster.set(key, value);
    }

    @Override
    public String get(String key) {
        return jedisCluster.get(key);
    }

    @Override
    public Boolean exists(String key) {
        return jedisCluster.exists(key);
    }

    @Override
    public Long expire(String key, int seconds) {
        return jedisCluster.expire(key, seconds);
    }

    @Override
    public Long ttl(String key) {
        return jedisCluster.ttl(key);
    }

    @Override
    public Long incr(String key) {
        return jedisCluster.incr(key);
    }

    @Override
    public Long hset(String key, String field, String value) {
        return jedisCluster.hset(key, field, value);
    }

    @Override
    public String hget(String key, String field) {
        return jedisCluster.hget(key, field);
    }

    @Override
    public Long hdel(String key, String... field) {
        return jedisCluster.hdel(key, field);
    }

    /**
     * @Title: del
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param key
     * @return
     */
    @Override
    public Long del(String key) {
        return jedisCluster.del(key);
    }

}

