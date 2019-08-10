/**
 * FileName: Student
 * Author:   xjh
 * Date:     2019-04-28 16:45
 * Description: 学生实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈学生实体类〉
 *
 * @author xjh
 * @create 2019-04-28
 * @since 1.0.0
 */

@Component
@ConfigurationProperties(prefix = "student")
public class Student implements Serializable {

    private String name;
    private int age;
    private boolean sex;
    private Date birthday;
    private String[] location;
    private Map<String,Object> hobbies;
    private List<String> skills;
    private Pet pet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String[] getLocation() {
        return location;
    }

    public void setLocation(String[] location) {
        this.location = location;
    }

    public Map<String, Object> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Map<String, Object> hobbies) {
        this.hobbies = hobbies;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", location=" + Arrays.toString(location) +
                ", hobbies=" + hobbies +
                ", skills=" + skills +
                ", pet=" + pet +
                '}';
    }
}