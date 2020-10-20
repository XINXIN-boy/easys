package com.itqf.demo01.dao;

import com.itqf.demo01.entity.Askforleave;
import com.itqf.demo01.vo.VoAsk;

import java.util.List;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/10/1316:41
 * description:
 */
public interface AskDao {
    int insertAsk(Askforleave askforleave);

    int deleteAsk(int id);

    int updateAsk(Askforleave askforleave);

    List<VoAsk> findAskByStatus(String status);

    List<VoAsk> findAll();
}
