package com.itqf.demo01.dao;

import com.itqf.demo01.vo.VoAnonymity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/2911:00
 * description:匿名投诉的数据
 */
public interface AnonymityDao {

    /**
     * 插所有
     * @return
     */
    List<VoAnonymity> findAll();

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteAnonymity(int id);

    /**
     * 修改状态
     * @param id
     * @param status
     * @return
     */
    int updateAnonymityStatus(@Param("id") int id, @Param("status") int status);
}
