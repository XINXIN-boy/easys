package com.itqf.demo01.vo;

import java.io.Serializable;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/299:02
 * description: vip的页面展示
 */
public class VoVip implements Serializable {
    private int vid ;
    private String content ;
    private String name ;


    public VoVip() {
    }

    public VoVip(int vid, String content, String name, int status) {
        this.vid = vid;
        this.content = content;
        this.name = name;
        this.status = status;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private int status ;



}
