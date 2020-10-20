package com.itqf.demo01.vo;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/308:53
 * description:练习题的展示类
 */
public class VoExercises {
    private int id ;
    private String type ;
    private String eanswer ;
    private String equestion ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEanswer() {
        return eanswer;
    }

    public void setEanswer(String eanswer) {
        this.eanswer = eanswer;
    }

    public String getEquestion() {
        return equestion;
    }

    public void setEquestion(String equestion) {
        this.equestion = equestion;
    }
}
