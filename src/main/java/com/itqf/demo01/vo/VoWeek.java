package com.itqf.demo01.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/271:08
 * description:周报前端的展示实体
 */
public class VoWeek implements Serializable {
    private int wid ;
    private String title ;
    private String content ;
    private String name ;
    private Date createTime ;
    @Override
    public String toString() {
        return "VoWeek{" +
                "wid=" + wid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }
    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
