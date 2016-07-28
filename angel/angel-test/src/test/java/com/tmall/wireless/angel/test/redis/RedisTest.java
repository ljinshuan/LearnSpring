package com.tmall.wireless.angel.test.redis;

import com.tmall.wireless.angel.MessageProvider;
import com.tmall.wireless.angel.test.BaseTest;
import org.junit.Test;
import org.reactivestreams.Publisher;
import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.RedissonClient;
import org.redisson.api.RAtomicLongReactive;
import org.redisson.api.RedissonReactiveClient;
import org.redisson.core.RAtomicLong;
import org.springframework.util.Assert.*;

import javax.annotation.Resource;

import static org.springframework.util.Assert.isTrue;

/**
 * Created by ljinshuan on 2016/7/29 0:00.
 */
public class RedisTest extends BaseTest {


    @Resource
    private MessageProvider messageProvider;

    @Test
    public void test1() {
        String message = messageProvider.getMessage();
        logger.debug(message);

    }

    @Test
    public void testConnect() {

        Config config = new Config();
        config.setUseLinuxNativeEpoll(false);
        config.useSingleServer().setAddress("192.168.109.131:6379");

        RedissonReactiveClient redisson = Redisson.createReactive(config);

        RAtomicLongReactive longObject = redisson.getAtomicLong("myLong");
        Publisher<Long> longPublisher = longObject.get();
        longObject.set(100L);

        isTrue(true);


    }
}
