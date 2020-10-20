package com.itqf.demo01.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/3014:08
 * description: 部门展示的实体类
 */
public class VoDepart implements Serializable {
    private int id ;
    private String name ;
    private Date createtime ;
    private  int  number ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
