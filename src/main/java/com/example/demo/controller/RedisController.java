/**
 * FileName: RedisController
 * Author:   xjh
 * Date:     2019-08-01 16:09
 * Description: redis_test
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈redis_test〉
 *
 * @author xjh
 * @create 2019-08-01
 * @since 1.0.0
 */
@RestController
public class RedisController {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @RequestMapping("/redis/setString")
    public Object setString(){
        System.out.println(redisTemplate);
        redisTemplate.boundValueOps("name").set("xjh");
        return redisTemplate.boundValueOps("key").get();
    }

    @RequestMapping("/redis/set")
    public void set(){
        redisTemplate.boundSetOps("Set").add("java1");
        redisTemplate.boundSetOps("Set").add("java2");
        redisTemplate.boundSetOps("Set").add("java3");
        redisTemplate.boundSetOps("Set").add("java4");
        redisTemplate.boundSetOps("Set").add("java5");
    }

}