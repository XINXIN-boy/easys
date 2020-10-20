package com.itqf.demo01.service;

import com.itqf.demo01.utils.JsonMessage;
import com.itqf.demo01.vo.VoExercises;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/2917:35
 * description:
 */
public interface ExerciesService {
    /**
     * 查类型
     * @return
     */
    JsonMessage findType();

    /**
     * 添加练习题
     * @param tid
     * @param equestion
     * @param eanswer
     */
    void addExercises(int tid, String equestion, String eanswer);

    /**
     * 修改练习题
     * @param voExercises
     */
    void updateExercises(VoExercises voExercises);

    /**
     * 删除
     * @param id
     */
    void deleteExercises(int id);

    /**
     * 查所有练习题
     * @return
     */
    JsonMessage findAll(int page , int limit);

    /**
     * 饼图查数据
     * @return
     */
    JsonMessage findEchartsEx();

}
