package com.itqf.demo01.dao;

import com.itqf.demo01.vo.VoVip;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/299:41
 * description:会员的dao接口
 */
public interface VipDao {
    /**
     * 查询所有
     * @param status
     * @return
     */
    List<VoVip> findAll(int status);

    /**
     * 修改会员状态
     * @param vid
     * @param status
     * @return
     */
    int updateStatus(@Param("vid") int vid,@Param("status") int status);
}
