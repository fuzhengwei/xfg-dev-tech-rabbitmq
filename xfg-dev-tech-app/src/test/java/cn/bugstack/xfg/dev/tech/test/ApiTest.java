package cn.bugstack.xfg.dev.tech.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test_product() throws InterruptedException {
        // 发送消息
        rabbitTemplate.convertAndSend("testQueue", "基本消息");
        // 等待
        new CountDownLatch(1).await();
    }

    @Test
    public void test_product_fanout() throws InterruptedException {
        rabbitTemplate.convertAndSend("fanoutExchange", "", "广播消息");
        // 等待
        new CountDownLatch(1).await();
    }

    @Test
    public void test_product_route() throws InterruptedException {
        rabbitTemplate.convertAndSend("routeExchange", "routeKey1", "路由模式，消息1");
        rabbitTemplate.convertAndSend("routeExchange", "routeKey2", "路由模式，消息2");
        // 等待
        new CountDownLatch(1).await();
    }

    @Test
    public void test_product_topic() throws InterruptedException {
        rabbitTemplate.convertAndSend("topicExchange", "topic.x", "通配符模式，消息1");
        rabbitTemplate.convertAndSend("topicExchange", "topic.y.z", "通配符模式，消息2");
        // 等待
        new CountDownLatch(1).await();
    }

}
