package com.itqf.demo01.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/2516:58
 * description: 职员的实体类
 */
public class Staff implements Serializable {
        private int id ;
        private String uno ;
        private int did ;
        private String dname ;
        private String name ;
        private String sex ;
        private String email ;
        private String qq ;
        private String phone ;
        private String heading ;
        private Date entryTime ;  //登记时间
        private int flag ;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUno() {
        return uno;
    }

    public void setUno(String uno) {
        this.uno = uno;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", uno='" + uno + '\'' +
                ", did=" + did +
                ", dname='" + dname + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", qq='" + qq + '\'' +
                ", phone='" + phone + '\'' +
                ", heading='" + heading + '\'' +
                ", entryTime=" + entryTime +
                ", flag=" + flag +
                '}';
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
