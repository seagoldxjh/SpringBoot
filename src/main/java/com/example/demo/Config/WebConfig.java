/**
 * FileName: WebConfig
 * Author:   xjh
 * Date:     2019-08-10 12:18
 * Description: 加入拦截器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.Config;

import com.example.demo.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 〈一句话功能简述〉<br> 
 * 〈加入拦截器〉
 *
 * @author xjh
 * @create 2019-08-10
 * @since 1.0.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    //拦截器必须手动示例bean，否则拦截器中无法自动注入其他类
    @Bean
    public LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }

    //需要拦截的路径，默认为全部
    String addPathPatterns[] = {

    };

    //排除不需要拦截的路径
    String excludePathPatterns[] = {
        "/redis/**"
    };

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor())
                .addPathPatterns(addPathPatterns)
                .excludePathPatterns(excludePathPatterns);
    }


}