/**
 * FileName: tb_student
 * Author:   xjh
 * Date:     2019-07-12 17:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xjh
 * @create 2019-07-12
 * @since 1.0.0
 */
@TableName(value="tb_student")
public class tb_student {

    //student 、Student、stUDEnt
    //tb_
//@KeySequence(value="seq_stu",clazz = Integer.class) //将本类的 自增字段 和oracle的序列绑定起来
        //IdType.AUTO :自增，依赖于数据库
//    @TableId(value="stu_no" ,type= IdType.AUTO)
        @TableId(value="stu_no" ,type= IdType.INPUT)//oracle没有自增，用序列
        private int stuNo ;//stuNo -> stu_no
        @TableField(exist = false)
        private String other ;


        //和数据库无关
        @TableField(exist = false)
        private boolean sex ;

        @TableField( fill = FieldFill.INSERT_UPDATE)
        private String stuName ; //stuName ->stu_name

        @TableField(exist = false)
        @Version//版本号
        private Integer version;

        //逻辑删除字段
        @TableField(exist = false)
        @TableLogic(value="logic_delete")
        private int logicDelete ;

        @TableField(value="stu_age")
        private int stuAge ; // int  :0    Integer：null

        public tb_student( ) {
        }
        //身份证   学号
        public tb_student( String stuName, int stuAge) {
            this.stuName = stuName;
            this.stuAge = stuAge;
        }

        public String getOther() {
            return other;
        }

        public void setOther(String other) {
            this.other = other;
        }

        public tb_student(int stuNo, String stuName, int stuAge) {
            this.stuNo = stuNo;
            this.stuName = stuName;
            this.stuAge = stuAge;
        }

        public int getLogicDelete() {
            return logicDelete;
        }

        public void setLogicDelete(int logicDelete) {
            this.logicDelete = logicDelete;
        }

        public boolean isSex() {
            return sex;
        }

        public Integer getVersion() {
            return version;
        }

        public void setVersion(Integer version) {
            this.version = version;
        }

        public void setSex(boolean sex) {
            this.sex = sex;
        }

        public int getStuNo() {
            return stuNo;
        }

        public void setStuNo(int stuNo) {
            this.stuNo = stuNo;
        }

        public String getStuName() {
            return stuName;
        }

        public void setStuName(String stuName) {
            this.stuName = stuName;
        }

        public int getStuAge() {
            return stuAge;
        }

        public void setStuAge(int stuAge) {
            this.stuAge = stuAge;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "stuNo=" + stuNo +
                    ", stuName='" + stuName + '\'' +
                    ", stuAge=" + stuAge +
                    '}';
        }
}