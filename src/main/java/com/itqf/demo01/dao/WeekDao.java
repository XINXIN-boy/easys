package com.itqf.demo01.dao;

import com.itqf.demo01.entity.User;
import com.itqf.demo01.entity.Week;
import com.itqf.demo01.vo.VoWeek;

import java.util.List;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/271:39
 * description:周报的数据层
 */
public interface WeekDao {
    /**
     * 插入周报
     * @param week
     * @return
     */
    int insertWeek(Week week);

    /**
     * 查询所有的周报
     * @param user
     * @return
     */
    List<VoWeek> findAll(User user);

    /**
     * 删除周报
     * @param id
     * @return
     */
    int deleteWeek(int id);

    /**
     * 修改周报
     * @param voWeek
     * @return
     */
    int updateWeek(VoWeek voWeek);
}
