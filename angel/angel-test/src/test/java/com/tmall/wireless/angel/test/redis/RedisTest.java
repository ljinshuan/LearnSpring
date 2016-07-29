package com.tmall.wireless.angel.test.redis;

import com.tmall.wireless.angel.MessageProvider;
import com.tmall.wireless.angel.test.BaseTest;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.RedissonClient;
import org.redisson.core.*;

import javax.annotation.Resource;

import static org.junit.Assert.*;


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

    public static RedissonClient redissonClient;
    @BeforeClass
    public static void init(){
        Config config = new Config();
        config.setUseLinuxNativeEpoll(false);
        config.useSingleServer().setAddress("192.168.109.131:6379");

        redissonClient = Redisson.create(config);
    }

    @Test
    public void testConnect() {

        RAtomicLong longObject = redissonClient.getAtomicLong("myLong");
        long longPublisher = longObject.get();
        longObject.set(100L);

    }

    @Test
    public void testObject(){
        RBucket<String> rBucket = redissonClient.getBucket("BucketKey");
       // rBucket.set("ljinshuan");
        String result = rBucket.get();

        assertEquals(result,"ljinshuan");
    }

    @Test
    public void testTopic() throws InterruptedException {
        RTopic<String> topic=redissonClient.getTopic("anyTopic");
        topic.addListener(new MessageListener<String>() {
            @Override
            public void onMessage(String channel, String msg) {
                logger.debug("{} {}",channel,msg);
            }
        });


        long publish = topic.publish("hehe hello");

        Thread.sleep(5000);
    }

    @Test
    public void testMap(){
        RMap<String, Object> mapTest = redissonClient.getMap("mapTest");


    }

    @Test
    public void testLock(){
        RLock lock=redissonClient.getLock("anyLock");


    }
}
