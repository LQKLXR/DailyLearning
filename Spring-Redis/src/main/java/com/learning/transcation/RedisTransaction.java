package com.learning.transcation;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * Redis事务练习
 *
 * @author 刘乾坤
 * @date 2022/4/17
 */
@Service
public class RedisTransaction {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    private static final String KEY = "GOOD:001:GOOD";

    /**
     * Session实现事务
     */
    public void sessionTransaction() {
        redisTemplate.execute(new SessionCallback<List>() {
            @Override
            public List execute(RedisOperations operations) throws DataAccessException {
                operations.multi();
                Object getValue = operations.opsForValue().get("GOOD:001:GOOD");
                int count = Integer.parseInt(getValue.toString());
                if (count > 0) {
                    operations.opsForValue().decrement("GOOD:001:GOOD");
                }
                return operations.exec();
            }
        });
    }

}
