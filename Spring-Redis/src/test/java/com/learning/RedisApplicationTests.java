package com.learning;

import com.learning.transcation.RedisTransaction;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = {RedisApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
@RunWith(SpringRunner.class)
class RedisApplicationTests {

    @Resource
    private RedisTransaction redisTransaction;

    @Test
    void test() {
        redisTransaction.sessionTransaction();
    }

}
