package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.tb_student;

public interface testMapper extends BaseMapper<tb_student> {
    tb_student queryStudents();
}
