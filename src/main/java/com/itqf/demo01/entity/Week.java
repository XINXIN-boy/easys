package com.itqf.demo01.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/2623:57
 * description:周报
 */
public class Week implements Serializable {

    private int id ;
    private String title ;
    private String content ;
    private int status ;
    private Date createTime ;
    private String uno ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUno() {
        return uno;
    }

    public void setUno(String uno) {
        this.uno = uno;
    }
}
