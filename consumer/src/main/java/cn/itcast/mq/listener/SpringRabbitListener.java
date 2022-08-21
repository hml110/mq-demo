package cn.itcast.mq.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Map;

/**
 * @author hml
 * @version 1.0
 * @description: TODO
 * @date 2022/8/21 9:21
 */
@Component
public class SpringRabbitListener {
//    @RabbitListener(queues = "simple.queue")
//    public void ListenSimpleQueue1(String message){
//        System.out.println("消费者接收到simple.queue的消息："+message);
//    }

    //work
//    @RabbitListener(queues = "simple.queue")
//    public void ListenSimpleQueue1(String message) throws InterruptedException {
//        System.out.println("消费者1___接收到simple.queue2的消息：" + message + LocalTime.now());
//        Thread.sleep(20);
//    }
//
//    @RabbitListener(queues = "simple.queue")
//    public void ListenSimpleQueue2(String message) throws InterruptedException {
//        System.err.println("消费者2___接收到simple.queue2的消息：" + message + LocalTime.now());
//        Thread.sleep(200);
//    }

    //fanout
//    @RabbitListener(queues = "fanout.queue1")
//    public void ListenFanoutQueue1(String message) {
//        System.out.println("消费者接收到fanout.queue1的消息：" + message);
//    }
//
//    @RabbitListener(queues = "fanout.queue2")
//    public void ListenFanoutQueue2(String message) {
//        System.err.println("消费者接收到fanout.queue2的消息：" + message);
//    }

    //topic
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue1"),
            exchange = @Exchange(name = "hml.direct",type = ExchangeTypes.DIRECT),
            key = {"red","blue"}
    ))
    public void ListenDirectQueue1(String mes){
        System.out.println("消费者接收到direct.queue1的消息：" + mes);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue2"),
            exchange = @Exchange(name = "hml.direct",type = ExchangeTypes.DIRECT),
            key = {"red","yellow"}
    ))
    public void ListenDirectQueue2(String mes){
        System.err.println("消费者接收到direct.queue2的消息：" + mes);
    }


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("topic.queue1"),
            exchange = @Exchange(name = "hml.topic",type = ExchangeTypes.TOPIC),
            key = "china.#"
    ))
    public void ListenTopicQueue1(String mes){
        System.out.println("消费者接收到topic.queue1的消息：" + mes);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("topic.queue2"),
            exchange = @Exchange(name = "hml.topic",type = ExchangeTypes.TOPIC),
            key = "#.news"
    ))
    public void ListenTopicQueue2(String mes){
        System.err.println("消费者接收到topic.queue2的消息：" + mes);
    }



    @RabbitListener(queues = "object.queue")
    public void ListenObjectQueue(Map<String,Object> mes){
        System.err.println("消费者接收到object.queue的消息：" + mes);
    }





}
