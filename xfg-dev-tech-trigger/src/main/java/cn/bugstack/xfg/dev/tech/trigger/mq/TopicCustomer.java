package cn.bugstack.xfg.dev.tech.trigger.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 通配符模式
 */
@Slf4j
@Component
public class TopicCustomer {

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "topicQueue1"),
                    exchange = @Exchange(value = "topicExchange", type = ExchangeTypes.TOPIC),
                    key = "topic.*" // `*`：匹配一个单词，就只有一个单词
            )
    )
    public void listener01(String msg) {
        log.info("接收消息【通配符模式】listener01：{}", msg);
    }

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "topicQueue2"),
                    exchange = @Exchange(value = "topicExchange", type = ExchangeTypes.TOPIC),
                    key = "topic.#" // `#`：匹配一个或多个词
            )
    )
    public void listener02(String msg) {
        log.info("接收消息【通配符模式】listener02：{}", msg);
    }

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "topicQueue3"),
                    exchange = @Exchange(value = "topicExchange", type = ExchangeTypes.TOPIC),
                    key = "topic.y.#" // `#`：匹配一个或多个词
            )
    )
    public void listener03(String msg) {
        log.info("接收消息【通配符模式】listener03：{}", msg);
    }

}
