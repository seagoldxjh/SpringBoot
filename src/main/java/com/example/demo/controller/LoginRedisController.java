/**
 * FileName: LoginRedisController
 * Author:   xjh
 * Date:     2019-08-10 11:32
 * Description: Redis+Session实现单点登录
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Redis+Session实现单点登录〉
 *
 * @author xjh
 * @create 2019-08-10
 * @since 1.0.0
 */
@RestController
public class LoginRedisController {

    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    @RequestMapping("/login/{id}")
    public void login(@PathVariable("id") int id, HttpSession session){
        /**
         * 数据库模拟查询用户密码正确，若不正确应当重新登录
         * 若正确
         */
        session.setAttribute("id", id);
        //redisTemplate.opsForValue().set("loginId"+id, session.getId());
        redisTemplate.opsForHash().put("loginHash", "loginUser:"+id,session.getId());
    }
}