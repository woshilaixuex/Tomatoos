package com.example.service.impl;

import com.example.dao.FrequencyDao;
import com.example.dao.FrequencyHisDao;
import com.example.domain.Frequency;
import com.example.domain.FrequencyHis;
import com.example.service.FrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FrequencyServiceImpl implements FrequencyService {
    @Autowired
    private FrequencyDao frequencyDao;
    @Autowired
    private FrequencyHisDao frequencyHisDao;

    @Override
    public void saveFrequency(Frequency frequency) {
        frequencyDao.save(frequency);
    }
    @Override
    public boolean saveFrequencyHis(FrequencyHis frequencyhis) {
        if(frequencyHisDao.have(frequencyhis) == null) {
            frequencyHisDao.save(frequencyhis);
            return true;
        }else{
            return false;
        }
    }
    @Override
    public Frequency getByNumFrequency(String num){
        return frequencyDao.getByNum(num);
    }
    @Override
    public void updateFrequency(Frequency frequency){
        frequencyDao.update(frequency);
    }

    @Override
    public void updateFrequencyHis(FrequencyHis frequencyHis) {
        frequencyHisDao.save(frequencyHis);
    }

    @Override
    public List<Frequency> getAllFrequency() {
        List<Frequency> lis = frequencyDao.getAll();
        return lis;
    }
    @Override
    public List<FrequencyHis> getByNumHis(String num) {
        List<FrequencyHis> lis = frequencyHisDao.getByNum(num);
        return lis;
    }
}
