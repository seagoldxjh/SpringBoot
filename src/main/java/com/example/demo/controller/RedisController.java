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

import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *  Spring Data Redis操作redis缓存数据库
 *  常见5种数据类型对应的操作(String,Set,Zset,List,Hash)
 * @author xjh
 * @create 2019-08-01
 * @since 1.0.0
 */
@RestController
public class RedisController {

    @Autowired
    private final RedisTemplate<Object, Object> redisTemplate;

    public RedisController(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 删除key
     */
    @RequestMapping("redis/delete/{key}")
    public Boolean delete(@PathVariable("key") String key){
        return redisTemplate.delete(key);
    }

    /**
     *  向redis数据库存储String类型的<key,value>
     *  @return 返回所存key对应的value
     */
    @RequestMapping("/redis/setString")
    public Object setString(){
        System.out.println(redisTemplate);
        redisTemplate.boundValueOps("name").set("xjh");
        return redisTemplate.boundValueOps("key").get();
    }

    /**
     *  向redis数据库存储Set类型的<key,value>
     */
    @RequestMapping("/redis/set")
    public void set(){
        redisTemplate.boundSetOps("Set").add("java1");
        redisTemplate.boundSetOps("Set").add("java2");
        redisTemplate.boundSetOps("Set").add("java3");
        redisTemplate.boundSetOps("Set").add("java4");
        redisTemplate.boundSetOps("Set").add("java5");
    }

    /**
     *  @return 返回Set类型所存key对应的value
     */
    @RequestMapping("/redis/getSet")
    public Set<Object> getSet(){
        return redisTemplate.boundSetOps("Set").members();
    }

    /**
     *  @return 删除Set类型所存key对应的其中某一个或多个value
     *  redisTemplate.delete();删除整个key
     */
    @RequestMapping("/redis/removeSet")
    public Set<Object> removeSet(){
        redisTemplate.boundSetOps("Set").remove("java5");
        return redisTemplate.boundSetOps("Set").members();
    }

    /**
     * 操作List类型
     * 向右压入栈
     */
    @RequestMapping("/redis/rlist")
    public void rList(){
        redisTemplate.boundListOps("list").rightPush("1");
        redisTemplate.boundListOps("list").rightPush("2");
        redisTemplate.boundListOps("list").rightPush("3");
        //结果集为["1","2","3"]
    }

    /**
     * 操作List类型
     * 向左压入栈
     */
    @RequestMapping("/redis/llist")
    public void leftList(){
        redisTemplate.boundListOps("list").leftPush("4");
        redisTemplate.boundListOps("list").leftPush("5");
        redisTemplate.boundListOps("list").leftPush("6");
        //结果集为["6","5","4","1","2","3"]
    }

    /**
     * 操作List类型
     * 获取栈内所有元素
     * List<Object> list = (List<Object>)redisTemplate.opsForList().range("list",0,-1);
     * 也可以完成此操作
     */
    @RequestMapping("/redis/getList")
    public List<Object> getList(){
        //List<Object> list = (List<Object>)redisTemplate.opsForList().range("list",0,-1);
        return redisTemplate.boundListOps("list").range(0, -1);
    }

    /**
     * 操作List类型
     * 删除List类型中指定的value
     */
    @RequestMapping("/redis/removeList")
    public List<Object> removoList(){
        //List允许重复值，删除几个值元素
        redisTemplate.boundListOps("list").remove(1,"1");
        return redisTemplate.boundListOps("list").range(0, -1);
    }

    /**
     * 操作Hash类型
     * 向Hash存储数据,初始化Hash
     * 两种方式存储值
     */
    @RequestMapping("/redis/hash")
    public void hash(){
        redisTemplate.opsForHash().put("hash", "1", "zs");
        redisTemplate.opsForHash().put("hash", "2", "ls");
        redisTemplate.boundHashOps("hash").put("3", "w5");
    }

    /**
     * 操作Hash类型
     * 获取hash中所有value
     * redisTemplate.opsForHash().keys(k);获取所有的key
     * 两种方式取值
     */
    @RequestMapping("/redis/getHash")
    public List<Object> getHash(){
        List<Object> hash = redisTemplate.opsForHash().values("hash");
        List<Object> hash1 = redisTemplate.boundHashOps("hash").values();
        System.out.println(hash1);
        return hash;
    }

    /**
     * 操作Hash类型
     * 根据key获取value
     */
    @RequestMapping("/redis/getHashValue")
    public Object getHashValue(){
        Object value = redisTemplate.opsForHash().get("hash", "1");
        System.out.println(redisTemplate.boundHashOps("hash").get("1"));
        return value;
    }

    /**
     * 操作Hash类型
     * 根据key删除value
     * 可单个删除也可多个删除
     */
    @RequestMapping("/redis/removeHash")
    public void removeHash(){
        Long count = redisTemplate.boundHashOps("hash").delete("2", "3");
        getHash();
    }

    /**
     * 操作Zset类型
     * 初始化Zset
     */
    @RequestMapping("redis/zset")
    public void zset(){
        redisTemplate.boundZSetOps("zset").add("A", 2);
        redisTemplate.boundZSetOps("zset").add("B", 3);
        redisTemplate.boundZSetOps("zset").add("C", 4);
        redisTemplate.boundZSetOps("zset").add("D", 1);
        //集合按照分值从小到大排序，集合元素为["D","A","B","C"]
    }

    /**
     * 操作Zset类型
     * 新增一个有序集合
     */
    @RequestMapping("redis/zsets")
    public void zsets(){
        ZSetOperations.TypedTuple<Object> z1 = new DefaultTypedTuple<>("zset-1",1.5);
        ZSetOperations.TypedTuple<Object> z2 = new DefaultTypedTuple<>("zset-2",1.8);
        ZSetOperations.TypedTuple<Object> z3 = new DefaultTypedTuple<>("zset-3",3.1);
        ZSetOperations.TypedTuple<Object> z4 = new DefaultTypedTuple<>("zset-4",4.2);
        Set set = new HashSet();
        set.add(z1);
        set.add(z2);
        set.add(z3);
        set.add(z4);
        redisTemplate.boundZSetOps("zsets").add(set);
    }

    /**
     * 操作Zset类型
     * 获取区间内Zset所有值，-1代表最后一个元素,0代表第一个
     */
    @RequestMapping("redis/getZset")
    public Set<Object> getZset(){
        return redisTemplate.boundZSetOps("zset").range(0, -1);
    }

    @RequestMapping("redis/setListObject")
    public void setListObject(){
        List<Student> list = new ArrayList<>();
        Student student = new Student();
        student.setAge(18);
        list.add(student);
        list.add(student);
        list.add(student);
        redisTemplate.opsForValue().set("a", list);
    }

    @RequestMapping("redis/getListObject")
    public List<Student> getListObject(){
        return (List<Student>)redisTemplate.opsForValue().get("a");
    }

    @RequestMapping("redis/setMapObject")
    public void setMapObject(){
        Map<String,Object> map = new HashMap<>();
        map.put("name", "xjh");
        map.put("age", "21");
        redisTemplate.opsForHash().putAll("xjh", map);
    }

    /**
     * 模拟高并发查询redis or 数据库
     * 解决缓存穿透
     * @return 查询结果
     * Cacheable放入redis中与代码手动放入redis中数据不是同一个
     */
    @Cacheable(value = "students")
    @RequestMapping("redis/testRedis")
    public List<Student> testRedis(){
        List<Student> students = (List<Student>)redisTemplate.opsForValue().get("students");
        System.out.println("查询redis-1");

        if(null == students){
            synchronized (this){
                System.out.println("查询redis-2");
                //从redis再次获取数据
                students = (List<Student>)redisTemplate.opsForValue().get("students");

                if(null == students){
                    //模拟查询数据库，并将查询结果存入redis中
                    System.out.println("查询数据库");
                    students = new ArrayList<>();
                    Student student = new Student();
                    student.setName("xjh");
                    students.add(student);
                    students.add(student);
                    students.add(student);

                    redisTemplate.opsForValue().set("students", students);
                }
            }
        }
        return students;
    }

    @CachePut(value = "students")
    @RequestMapping("redis/updateStudents")
    public List<Student> updateStudents(){
        System.out.println("更新数据");
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setAge(21);
        students.add(student);
        students.add(student);
        students.add(student);
        return students;
    }


}