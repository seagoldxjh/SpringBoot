/**
 * FileName: LoginInterceptor
 * Author:   xjh
 * Date:     2019-08-10 12:00
 * Description: 登陆拦截器，实现单点登录
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈登陆拦截器，实现单点登录〉
 *
 * @author xjh
 * @create 2019-08-10
 * @since 1.0.0
 */
//@component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入登陆拦截");
        Object id = request.getSession().getAttribute("id");
        System.out.println(id);
        //id为空，说明还没有进行过登陆
        if (id == null) {
            System.out.println("首次登陆");
        }
        Object OldSessionId = redisTemplate.opsForHash().get("loginHash", "loginUser:"+id);
        if(OldSessionId!=null && OldSessionId.equals(request.getSession().getId())){
            System.out.println("同一个Session登陆");
        }else {
            System.out.println(OldSessionId);
            System.out.println(request.getSession().getId());
            System.out.println("不同Session登陆");
        }


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}