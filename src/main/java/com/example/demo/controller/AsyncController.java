/**
 * FileName: AsyncController
 * Author:   xjh
 * Date:     2019-08-14 12:55
 * Description: 异步任务
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.controller;

import com.example.demo.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈异步任务〉
 *
 * @author xjh
 * @create 2019-08-14
 * @since 1.0.0
 */
@RestController
@RequestMapping("task")
public class AsyncController {
    @Autowired
    AsyncService asyncService;

    @RequestMapping("/async")
    public String async() throws InterruptedException {
        asyncService.async();
        return "async";
    }
}