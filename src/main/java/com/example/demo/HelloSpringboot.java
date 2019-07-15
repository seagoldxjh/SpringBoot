package com.example.demo;

import com.example.demo.entity.tb_student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringboot {


    @Autowired
    com.example.demo.mapper.testMapper testMapper;

    @RequestMapping("/hello")
    public String say() {
        System.out.println("Hello springboot");
        return "hello,this is a springboot demo";
    }

    @RequestMapping("/mp")
    public tb_student mybatis() {

        return testMapper.queryStudents();
    }

}