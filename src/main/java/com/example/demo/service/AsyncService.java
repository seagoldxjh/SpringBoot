/**
 * FileName: AsyncService
 * Author:   xjh
 * Date:     2019-08-14 12:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xjh
 * @create 2019-08-14
 * @since 1.0.0
 */
@Service
public class AsyncService {
    @Async
    public void async() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("数据处理结束");
    }
}