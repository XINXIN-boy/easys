package com.itqf.demo01.entity;


public class Question {

  private int id;
  private String uNo;
  private String question;
  private String answer;
  private String qtype;
  private int star;
  private String flag;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getUNo() {
    return uNo;
  }

  public void setUNo(String uNo) {
    this.uNo = uNo;
  }


  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }


  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }


  public String getQtype() {
    return qtype;
  }

  public void setQtype(String qtype) {
    this.qtype = qtype;
  }


  public int getStar() {
    return star;
  }

  public void setStar(int star) {
    this.star = star;
  }


  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

}
