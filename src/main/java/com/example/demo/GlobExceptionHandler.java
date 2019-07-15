/**
 * FileName: GlobExceptionHandler
 * Author:   xjh
 * Date:     2019-07-12 14:06
 * Description: 全局异常处理
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈全局异常处理〉
 *
 * @author xjh
 * @create 2019-07-12
 * @since 1.0.0
 */

@ControllerAdvice

public class GlobExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object> handlerException(Exception e){
        e.printStackTrace();
        Map<String, Object> map = new HashMap<>();
        map.put("errorCode","101");
        map.put("errorMsg","未知异常");
        return map;
    }
}