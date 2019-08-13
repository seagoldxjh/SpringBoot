/**
 * FileName: RabbitConfig
 * Author:   xjh
 * Date:     2019-08-13 15:57
 * Description: Rabbitmq配置类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Rabbitmq配置类〉
 *
 * @author xjh
 * @create 2019-08-13
 * @since 1.0.0
 */
@Configuration
public class RabbitConfig {

    //使用Jackson2JsonMessageConverter替换默认序列化转换
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}