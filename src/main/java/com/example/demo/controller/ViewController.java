/**
 * FileName: ViewController
 * Author:   xjh
 * Date:     2019-07-15 15:30
 * Description: 视图跳转控制器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.controller;

import com.example.demo.entity.Video;
import com.example.demo.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈视图跳转控制器〉
 *
 * @author xjh
 * @create 2019-07-15
 * @since 1.0.0
 */
@Controller
public class ViewController {


    @Autowired
    VideoMapper videoMapper;


    @RequestMapping("index")
    public String commonontroller() {
        System.out.println("---");

        return "index";

    }

    @RequestMapping("test")
    @ResponseBody
    public List<Video> test() {
        System.out.println("---");

        return videoMapper.selectList(null);

    }



}