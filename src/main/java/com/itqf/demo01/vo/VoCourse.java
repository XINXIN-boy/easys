package com.itqf.demo01.vo;

import java.sql.Timestamp;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/10/1320:35
 * description:
 */
public class VoCourse {

    private long id;
    private String name;
    private java.sql.Timestamp createtime;
    private long week;
    private String typeName;
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

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public long getWeek() {
        return week;
    }

    public void setWeek(long week) {
        this.week = week;
    }

    public String getType() {
        return typeName;
    }

    public void setType(String typeName) {
        this.typeName = typeName;
    }

    public long getFlag() {
        return flag;
    }

    public void setFlag(long flag) {
        this.flag = flag;
    }
}
