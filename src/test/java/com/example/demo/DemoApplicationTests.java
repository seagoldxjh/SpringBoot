package com.example.demo;

import com.example.demo.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    StringRedisTemplate redisTemplate;
    @Qualifier("redisTemplate")
    @Autowired
    RedisTemplate rt;

    @Test
    public void contextLoads() {
        List<Student> list = new ArrayList<>();
        Student student = new Student();
        student.setAge(18);
        list.add(student);
        list.add(student);
        list.add(student);
        rt.opsForValue().set("a", list);
    }

}
