package com.silhouette.egobuy.redis;


/**
 *
 * @ClassName: JedisClient
 * @Description: JedisClient接口
 */
public interface JedisClient {
    /**
     *
     * @Title: set
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param key
     * @param value
     * @return
     */
    String set(String key, String value);
    /**
     *
     * @Title: del
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param key
     * @return
     */
    Long del(String key);
    /**
     *
     * @Title: get
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param key
     * @return
     */
    String get(String key);
    /**
     *
     * @Title: exists
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param key
     * @return
     */
    Boolean exists(String key);
    /**
     *
     * @Title: expire
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param key
     * @param seconds
     * @return
     */
    Long expire(String key, int seconds);
    /**
     *
     * @Title: ttl
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param key
     * @return
     */
    Long ttl(String key);
    /**
     *
     * @Title: incr
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param key
     * @return
     */
    Long incr(String key);
    /**
     *
     * @Title: hset
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param key
     * @param field
     * @param value
     * @return
     */
    Long hset(String key, String field, String value);
    /**
     *
     * @Title: hget
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param key
     * @param field
     * @return
     */
    String hget(String key, String field);
    /**
     *
     * @Title: hdel
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param key
     * @param field
     * @return
     */
    Long hdel(String key, String... field);
}

