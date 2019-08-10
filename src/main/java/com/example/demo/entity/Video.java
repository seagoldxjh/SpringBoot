package com.example.demo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * 视频表
 * @title: 视频标题
 * @summary: 视频概述
 * @coverImg: 视频封面图
 * @viewNum: 视频观看数
 * @price: 视频价格，单位分
 * @createTime: 创建时间
 * @online: 0表示未上线，1表示上线
 * @point: 默认评分8.7，最高10分
 * 必须实现Serializable，否则放入redis缓存时会报类型转换错误
 */

public class Video implements Serializable {

  @TableId(type= IdType.AUTO)
  private int id;
  private String title;
  private String summary;
  private String coverImg;
  private Integer viewNum;
  private Integer price;
  private java.util.Date createTime;
  private Integer online;
  private Double point;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }


  public String getCoverImg() {
    return coverImg;
  }

  public void setCoverImg(String coverImg) {
    this.coverImg = coverImg;
  }


  public Integer getViewNum() {
    return viewNum;
  }

  public void setViewNum(Integer viewNum) {
    this.viewNum = viewNum;
  }


  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }


  public java.util.Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.util.Date createTime) {
    this.createTime = createTime;
  }


  public Integer getOnline() {
    return online;
  }

  public void setOnline(Integer online) {
    this.online = online;
  }


  public Double getPoint() {
    return point;
  }

  public void setPoint(double point) {
    this.point = point;
  }

  @Override
  public String toString() {
    return "Video{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", summary='" + summary + '\'' +
            ", coverImg='" + coverImg + '\'' +
            ", viewNum=" + viewNum +
            ", price=" + price +
            ", createTime=" + createTime +
            ", online=" + online +
            ", point=" + point +
            '}';
  }
}
