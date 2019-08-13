/**
 * FileName: sender
 * Author:   xjh
 * Date:     2019-08-12 19:14
 * Description: Rabbit生产者测试类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.RabbitTest;

import org.springframework.stereotype.Controller;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Rabbit生产者测试类〉
 *
 * @author xjh
 * @create 2019-08-12
 * @since 1.0.0
 */
@Controller
public class sender {

   /* @Autowired
    private RabbitTemplate rabbitTemplate;

    @ResponseBody
    @RequestMapping("/send")
    public void send(){
        rabbitTemplate.convertAndSend("test","你好");
    }

    @RabbitListener(queues = "test")
    @RabbitHandler
    public void receive(String message){
        System.out.println("接收到的消息:" + message);
    }*/
}