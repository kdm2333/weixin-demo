package com.kdm.util.accessTokenUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author: 裴佳琦
 * @CreateDate: 2019/8/7 0:34
 * @Description:
 */
public final class RedisUtil {

    private static String ADDR = "127.0.0.1";

    private static int PORT = 6379;

    private static String AUTH = "";

    private static int MAX_ACTIVE = 1024;

    private static int MAX_IDLE = 200;

    private static int MAX_WAIT = 10000;

    private static int TIMEOUT = 10000;

    private static boolean TEST_ON_BORROW = true;

    private static JedisPool jedisPool = null;

    static {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(MAX_ACTIVE);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);

            jedisPool = new JedisPool(config,ADDR,PORT,TIMEOUT);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public synchronized static Jedis getJedis(){
        try {
            if (jedisPool != null){
                Jedis resuorce = jedisPool.getResource();
                return resuorce;
            }else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public static void returnResource(final Jedis jedis){
        if (jedis != null){
            jedis.close();
        }
    }

}

