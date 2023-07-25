package com.example.service.impl;

import com.example.dao.IntroductionDao;
import com.example.domain.Introduction;
import com.example.service.IntroductionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class IntroductionServiceImpl implements IntroductionService {
    @Autowired
    IntroductionDao introductionDao;
    public void toSave(Introduction introduction){

    }
    public Introduction getByNum(String num){
        return introductionDao.getByNum(num);
    }
}
