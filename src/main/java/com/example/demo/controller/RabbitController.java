/**
 * FileName: RabbitController
 * Author:   xjh
 * Date:     2019-08-13 15:23
 * Description: RabbitMQ整合功能测试类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.controller;

import com.example.demo.entity.Student;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈RabbitMQ整合功能测试类〉
 *
 * @author xjh
 * @create 2019-08-13
 * @since 1.0.0
 */

@RestController
@RequestMapping("rabbit")
public class RabbitController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Autowired
    RabbitAdmin rabbitAdmin;
    /**
     * 单播方式，点对点发送
     * rabbitTemplate.send(exchange,routingKey,message)需要自定义消息体
     * rabbitTemplate.convertAndSend(exchange,routingKey,object)此时object需要序列化
     */
    @RequestMapping("/send")
    public void send(){
        /*Map<String,Object> map = new HashMap();
        map.put("msg","测试信息");
        map.put("name", "xjh");
        map.put("age", 21);*/
        Student student = new Student();
        student.setName("肖金海");
        student.setAge(21);
        //参数1：交换机的名字  参数2：交换机的绑定key  参数3：传输的消息对象，会被默认序列化
        rabbitTemplate.convertAndSend("exchange.direct", "test.news",student);
    }

    /**
     * 手动获取
     * @return 获取queueName为test.news中的一条消息并返回
     */
    @RequestMapping("/receive")
    public Object receive(){
        return rabbitTemplate.receiveAndConvert("test.news");
    }

    /**
     * 通过监听器自动获取queueName为test.news中的一条消息
     * 应用场景举例: 订单系统中订单创建成功将消息放入队列中，库存系统中就要监听获取队列中消息并完成相应操作
     */
    @RabbitListener(queues = "test.news")
    public void receive(Student student){
        System.out.println("接收到的消息:" + student);
    }

    /**
     * 广播方式发送
     * 参数1：交换机的名字  参数2：交换机的绑定key  参数3：传输的消息对象，会被默认序列化
     * 由于是广播模式，会讲消息发送至交换机绑定的所有队列中，所以routingKey可以不管
     */
    @RequestMapping("/sendFanout")
    public void sendMsg(){
        Student student = new Student();
        student.setName("肖金海");
        student.setAge(21);
        rabbitTemplate.convertAndSend("exchange.fanout", "",student);
    }

    /**
     *  Exchange 操作
     *  创建的交换器默认都为持久化，不自动删除
     */
    @RequestMapping("/createDirectExchange")
    public void createDirectExchange(){
        amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange"));
        System.out.println("创建一个点对点的交换器完成");
    }

    /**
     * Queue操作
     * 删除队列：rabbitAdmin.deleteQueue(queueName);
     * 将队列中的消息全部晴空：rabbitAdmin.purgeQueue(queueName,false);
     */
    @RequestMapping("/createQueue")
    public void createQueue(){
        amqpAdmin.declareQueue(new Queue("amqpAdmin.queue",true));
        System.out.println("创建一个持久化的队列完成");
    }

    /**
     * Binding，路由器与队列之间的绑定规则
     */
    @RequestMapping("/createBinding")
    public void createBinding(){
        amqpAdmin.declareBinding(new Binding("amqpAdmin.queue",Binding.DestinationType.QUEUE,
                "amqpAdmin.exchange","amqp.bind",null));
    }

}