package com.example.service.impl;

import com.example.dao.AffairDao;
import com.example.domain.Affair;
import com.example.service.AffairService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AffairServiceImpl implements AffairService {
    @Autowired
    private AffairDao affairDao;

    public List<Affair> getAffairs(String num) {
        return affairDao.getByNum(num);
    }

    public void save(Affair affair) {
        affairDao.save(affair);
    }

    public void update(Affair affair){
        affairDao.update(affair);
    }
    public void delete(Integer id){
        affairDao.delete(id);
    }
}
