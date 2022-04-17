package com.learning.web;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 * 秒杀操作-几种方式的对比
 *
 * @author 刘乾坤
 * @date 2022/4/17
 */
@RestController
//@RequestMapping()
public class RedisSecondKillController {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    private String key = "GOOD:001:GOOD";

    private int threadCount = 0;

    @GetMapping("/transaction")
    public String transactionSecondKill() throws InterruptedException {

        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        // 查库存
        int count = Integer.parseInt((String) opsForValue.get(key));
        // 模拟一些订单处理工作
        Thread.sleep(500);
        // 减库存
        if (count > 0) {
            threadCount++;
            count--;
            opsForValue.set(key, String.valueOf(count));
        }
        return "success";
    }

    @GetMapping("/thread-count")
    public String getThreadNumber() {
        return String.valueOf(threadCount);
    }

    @GetMapping("/reset-thread")
    public String resetThread() {
        threadCount = 0;
        return "success";
    }

}
