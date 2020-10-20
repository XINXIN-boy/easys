package com.itqf.demo01.entity;


import java.sql.Date;

public class Grade {

  private int id;
  private String uNo;
  private String name;
  private java.sql.Date createtime;
  private int week;
  private String location;
  private int flag;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getUNo() {
    return uNo;
  }

  public void setUNo(String uNo) {
    this.uNo = uNo;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getuNo() {
    return uNo;
  }

  public void setuNo(String uNo) {
    this.uNo = uNo;
  }

  public Date getCreatetime() {
    return createtime;
  }

  public void setCreatetime(Date createtime) {
    this.createtime = createtime;
  }

  public int getWeek() {
    return week;
  }

  public void setWeek(int week) {
    this.week = week;
  }


  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }


  public int getFlag() {
    return flag;
  }

  public void setFlag(int flag) {
    this.flag = flag;
  }

}
