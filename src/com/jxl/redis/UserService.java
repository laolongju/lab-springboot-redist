package com.jxl.redis;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private Log log = LogFactory.getLog(UserService.class);
    
    public String getString(String key) {
        if(redisTemplate.hasKey(key)){
            log.info("redis中查找的信息");
            return (String) redisTemplate.opsForValue().get(key);
        }else {
            String val ="RedisTemplate";
            log.info("mysql中查找的信息");
            redisTemplate.opsForValue().set(key,val);
            log.info("mysql中查询的信息存入Redis中");
            return val;
        }

    }
}
