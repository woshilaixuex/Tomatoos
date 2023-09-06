package com.example.service;

import com.example.domain.Frequency;
import com.example.domain.FrequencyHis;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface FrequencyService {
    public void saveFrequency(Frequency frequency);
    public void updateFrequencyHis(FrequencyHis frequencyhis);
    public List<Frequency> getAllFrequency();
    public List<FrequencyHis> getByNumHis(String num);
    public boolean saveFrequencyHis(FrequencyHis frequency);
    public Frequency getByNumFrequency(String num);
    public void updateFrequency(Frequency frequency);
}
