package com.itqf.demo01.service;

import com.itqf.demo01.entity.Askforleave;
import com.itqf.demo01.utils.JsonMessage;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/10/1316:23
 * description:
 */
public interface AskService {

    void insertAsk(Askforleave askforleave);

    void deleteAsk(int id);

    void updateAsk(Askforleave askforleave);

    JsonMessage findAskByStatus(String status, int page, int limit);

    JsonMessage findAll(int page, int limit);
}
