package com.itqf.demo01.service;

import com.itqf.demo01.entity.Question;
import com.itqf.demo01.utils.JsonMessage;

import javax.servlet.http.HttpSession;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/10/1616:46
 * description:
 */
public interface ResourcesService {
    void insertResources(Question question, HttpSession session);

    void updateResources(Question question);


    void deleteResources(int id);

    JsonMessage findAll(int page, int limit);

}
