package com.itqf.demo01.vo;

import java.io.Serializable;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/2910:43
 * description:匿名投诉的展示类
 */
public class VoAnonymity implements Serializable {
    private int id ;
    private String content ;
    private String solve ;
    private String unsolved ;
    private String refuse ;

    public String getRefuse() {
        return refuse;
    }

    public void setRefuse(String refuse) {
        this.refuse = refuse;
    }

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

    public String getSolve() {
        return solve;
    }

    public void setSolve(String solve) {
        this.solve = solve;
    }

    public String getUnsolved() {
        return unsolved;
    }

    public void setUnsolved(String unsolved) {
        this.unsolved = unsolved;
    }
}
