package com.czj.modules.common;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author:caizhijian
 * @Date:2020-05-04
 */
@Service
public class RedisService {

    private RedisTemplate redisTemplate;

    private static Map<String,String> cardTypeMapping=new HashMap<String,String>();

    static{
        cardTypeMapping.put("10", "00");
        cardTypeMapping.put("11", "05");
        cardTypeMapping.put("12", "05");
        cardTypeMapping.put("13", "05");
        cardTypeMapping.put("14", "04");
        cardTypeMapping.put("15", "04");
        cardTypeMapping.put("16", "05");
        cardTypeMapping.put("17", "05");
        cardTypeMapping.put("18", "05");
        cardTypeMapping.put("20", "01");
        cardTypeMapping.put("21", "05");
        cardTypeMapping.put("40", "05");
        cardTypeMapping.put("49", "05");
        cardTypeMapping.put("50", "05");
        cardTypeMapping.put("51", "02");
        cardTypeMapping.put("52", "05");
        cardTypeMapping.put("53", "05");
        cardTypeMapping.put("54", "05");
        cardTypeMapping.put("55", "05");
        cardTypeMapping.put("60", "05");
        cardTypeMapping.put("80", "05");
    }


    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        this.redisTemplate = redisTemplate;
    }


    /**
     * 判断是否存在
     * @param key
     * @return
     */
    public Boolean isExist(String key){
        return redisTemplate.hasKey(key);
    }

    /**
     * 设置缓存
     * @param key 缓存key
     * @param value 缓存值
     * @param timeOut 有效分钟数
     */
    public void set(String key, String value, long timeOut){
        ValueOperations<String, String> vo = redisTemplate.opsForValue();
        vo.set(key, value, timeOut, TimeUnit.MINUTES);
    }

    /**
     * 根据key获取value
     * @param key
     * @return
     */
    public String get(String key){
        ValueOperations<String, String> vo = redisTemplate.opsForValue();
        return vo.get(key);
    }

    /**
     * 根据key删除
     * @param key
     * @return
     */
   public Boolean delete(String key){
        return redisTemplate.delete(key);
   }



}
