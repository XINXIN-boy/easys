package com.itqf.demo01.entity;

import java.io.Serializable;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/299:04
 * description: 会员的实体类
 */
public class Vip implements Serializable {

    private int id ;
    private String content ;
    private String uno ;
    private int status ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUno() {
        return uno;
    }

    public void setUno(String uno) {
        this.uno = uno;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
