package com.itqf.demo01.dao;

import com.itqf.demo01.echarts.ExercisesEcharts;
import com.itqf.demo01.entity.Type;
import com.itqf.demo01.vo.VoExercises;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/2917:34
 * description:
 */
public interface ExerciesDao {

     List<Type> findType() ;

    int insertExercises(@Param("tid") int tid, @Param("equestion") String equestion,@Param("eanswer")  String eanswer);

    int updateExercises(VoExercises voExercises);

    int deleteExercises(int id);

    List<VoExercises> findAll();

    List<ExercisesEcharts> findEchartsEx();
}
