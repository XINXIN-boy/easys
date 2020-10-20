package com.itqf.demo01.entity;

import java.io.Serializable;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/2917:33
 * description:
 */
public class Type implements Serializable {

    private int id ;
    private String name ;


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
}
