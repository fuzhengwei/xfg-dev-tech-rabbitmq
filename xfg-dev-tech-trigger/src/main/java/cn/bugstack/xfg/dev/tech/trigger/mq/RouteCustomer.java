package cn.bugstack.xfg.dev.tech.trigger.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 路由模式
 */
@Slf4j
@Component
public class RouteCustomer {

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "routeQueue1"),
                    exchange = @Exchange(value = "routeExchange", type = ExchangeTypes.DIRECT),
                    key = "routeKey1"
            )
    )
    public void listener01(String msg) {
        log.info("接收消息【路由模式】：{}", msg);
    }

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "routeQueue2"),
                    exchange = @Exchange(value = "routeExchange", type = ExchangeTypes.DIRECT),
                    key = "routeKey2"
            )
    )
    public void listener02(String msg) {
        log.info("接收消息【路由模式】：{}", msg);
    }

}
