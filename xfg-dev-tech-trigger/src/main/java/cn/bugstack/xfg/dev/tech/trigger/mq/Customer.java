package cn.bugstack.xfg.dev.tech.trigger.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 基本模式
 */
@Slf4j
@Component
public class Customer {

    /**
     * queuesToDeclare：支持多个队列，将队列绑定到默认交换机上，routeKey为队列名称。
     *
     * @param msg 接收到的消息
     */
    @RabbitListener(queuesToDeclare = @Queue(value = "testQueue"))
    public void listener(String msg) {
        log.info("接收消息：{}", msg);
//        throw new RuntimeException("Err");
    }

}
