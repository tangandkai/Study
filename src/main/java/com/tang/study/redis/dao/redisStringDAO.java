package com.tang.study.redis.dao;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.Pipeline;

public class redisStringDAO {

    private Jedis jedis;
    private JedisPool jedisPool;
    public redisStringDAO(){
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        jedisPool = new JedisPool(poolConfig, "master", 6379);
    }

    /**
     * 往redis中插入数据
     * 格式为k-v
     * @param key
     * @param value
     * @return
     */
    public void put(String key,String value){
        try {
            jedis = jedisPool.getResource();
            String result = jedis.set(key, value);
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis!=null)
                jedis.close();
        }
    }

    /**
     * 删除指定的键
     * @param key
     */
    public void delete(String key){
        try {
            jedis = jedisPool.getResource();
            Long result = jedis.del(key);
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis!=null)
                jedis.close();
        }
    }

    /**
     * redis管道测试
     */
    public void pipeline(){
        try {
            jedis = jedisPool.getResource();
            Pipeline pipe = jedis.pipelined();
            for (int i=0;i<100;i++){
                pipe.set("mykey","value"+i);
            }
            pipe.syncAndReturnAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis!=null)
                jedis.close();
        }
    }

    public void sub(){
        jedis.save();
        jedis.bgsave();
        jedis.clusterSaveConfig();
//        try {
//            jedis = jedisPool.getResource();
//            jedis.sub;
//        }
    }
}
