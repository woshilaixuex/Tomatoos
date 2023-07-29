package com.example.service.impl;

import com.example.dao.AffairHisDao;
import com.example.domain.AffairHis;
import com.example.service.AffairHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AffairHisServiceImpl implements AffairHisService {
    @Autowired
    AffairHisDao affairHisDao;
    public List<AffairHis> getAll(String num){
        return affairHisDao.getByNum(num);
    }
    public void save(AffairHis affairHis){
        affairHisDao.save(affairHis);
    }
}
