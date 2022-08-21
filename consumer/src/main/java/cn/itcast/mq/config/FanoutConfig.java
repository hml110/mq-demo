package cn.itcast.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hml
 * @version 1.0
 * @description: TODO 创建队列和交换机的绑定
 * @date 2022/8/21 10:58
 */

@Configuration
public class FanoutConfig {
    //hml.fanout
    //创建交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("hml.fanout");
    }

    //创建队列
    @Bean
    //fanout.queue1
    public Queue fanoutQueue1(){
        return new Queue("fanout.queue1");
    }

    //绑定队列1到交换机
    @Bean
    public Binding fanoutBinding1(Queue fanoutQueue1,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }


    @Bean
    //fanout.queue2
    public Queue fanoutQueue2(){
        return new Queue("fanout.queue2");
    }
    //绑定队列2到交换机
    @Bean
    public Binding fanoutBinding2(Queue fanoutQueue2,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }


    @Bean
    public Queue objectQueue(){
        return new Queue("object.queue");
    }


}
