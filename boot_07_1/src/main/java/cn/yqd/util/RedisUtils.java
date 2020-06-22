package cn.yqd.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {

    @Resource(name="redisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 判断是否存在该key
     */
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 将查询结果放入缓存
     * 超期时间默认单位为分钟
     * @param key key
     * @param obj value
     * @param time 超期时间
     */
    public void setValue(String key, Object obj, int time) {
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        opsForValue.set(key, obj, time, TimeUnit.MINUTES);
    }

    /**
     * 将查询结果放入缓存
     * 超期时间默认1小时（60分钟）
     * @param key key
     * @param obj value
     */
    public void setValue(String key, Object obj) {
        setValue(key, obj, 60);
    }

    /**
     * 删除key
     * @param key
     */
    public void deleteKey(String key) {
        redisTemplate.delete(key);
    }
}
