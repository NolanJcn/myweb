package com.jcn.redis.service;

import com.jcn.redis.key.interfacekey.KeyPrefix;
import com.jcn.utils.MyWebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**
 * 封装jedis的增删改查
 */
@Configuration
@Service
public class RedisService extends CachingConfigurerSupport{

    Logger logger = LoggerFactory.getLogger(RedisService.class);

    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private int port;

    @Value("${redis.timeout}")
    private int timeout;

    @Bean
    public JedisPool redisPoolFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, null);
        return jedisPool;
    }

    @Autowired
    JedisPool jedisPool;

    private Jedis getJedis(){

        Jedis jedis = null;
        jedis = jedisPool.getResource();

        return jedis;
    }

    //生成真正的key，getPrefix先拿到类名再拼一个key
    private String getRealKey(KeyPrefix keyPrefix , String key){

        String realKey = keyPrefix.getPrefix() + key;

        return realKey;
    }

    /**
     * 获取单个对象
     * 通过jedisPool获取jedis对象,然后进行get,set操作
     * */
    public <T> T get(KeyPrefix keyPrefix , String key , Class<T> clazz){

        try{//连接池用完想要释放掉，所以使用try{}

            String str = getJedis().get(getRealKey(keyPrefix,key));

            //将string转化为bean输出出去
            T t = MyWebUtils.stringToBean(str,clazz);

            return t;
        }finally {
            returnToPool(getJedis());
        }
    }

    /**
     * 设置对象
     * */
    public <T> boolean set(KeyPrefix keyPrefix, String key, T value){
        try {
            //set操作需要将类型转化为string
            String str = MyWebUtils.beanToString(value);

            if(!MyWebUtils.strIfEffective(str)) {
                return false;
            }

            //过期时间
            int seconds =  keyPrefix.expireSeconds();

            //如果小于0，则是永不过期的，调用set，否则调用setex：先设置一个值，然后设置一个过期时间
            if(seconds <= 0) {
                getJedis().set(getRealKey(keyPrefix,key), str);
            }else {
                getJedis().setex(getRealKey(keyPrefix,key), seconds, str);
            }

            return true;
        }finally {
            returnToPool(getJedis());
        }
    }

    /**
     * 判断key是否存在
     * */
    public <T> boolean exists(KeyPrefix keyPrefix, String key) {
        try {
            return  getJedis().exists(getRealKey(keyPrefix,key));
        }finally {
            returnToPool(getJedis());
        }
    }

    /**
     * 删除
     * */
    public boolean delete(KeyPrefix keyPrefix, String key) {
        try {
            //返回long类型数据
            long ret =  getJedis().del(getRealKey(keyPrefix,key));

            return ret > 0;
        }finally {
            returnToPool(getJedis());
        }
    }


    //如果jedis不为空，则close掉，实际上并没有关闭，只是把他返回到连接池里面
    private void returnToPool(Jedis jedis){
        if (jedis != null){
            jedis.close();
        }
    }

}
