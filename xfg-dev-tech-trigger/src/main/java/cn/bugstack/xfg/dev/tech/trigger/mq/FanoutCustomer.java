package cn.bugstack.xfg.dev.tech.trigger.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 广播/扇出模式
 * 一个生产者发送一条消息，可以同时被多个消费者所收到。
 */
@Slf4j
@Component
public class FanoutCustomer {

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "fanoutCustomer"),
                    exchange = @Exchange(
                            value = "fanoutExchange",
                            type = ExchangeTypes.FANOUT
                    )
            )
    )
    public void listener(String msg) {
        log.info("接收消息【广播模式】：{}", msg);
    }

}
