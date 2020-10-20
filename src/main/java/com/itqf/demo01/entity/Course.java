package com.itqf.demo01.entity;


public class Course {

  private long id;
  private String name;
  private java.sql.Timestamp createtime;
  private long week;
  private long type;
  private long flag;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }


  public long getWeek() {
    return week;
  }

  public void setWeek(long week) {
    this.week = week;
  }


  public long getType() {
    return type;
  }

  public void setType(long type) {
    this.type = type;
  }


  public long getFlag() {
    return flag;
  }

  public void setFlag(long flag) {
    this.flag = flag;
  }

}
