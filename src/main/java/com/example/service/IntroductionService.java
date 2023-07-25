package com.example.service;

import com.example.domain.Introduction;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IntroductionService {
    public void toSave(Introduction introduction);
    public Introduction getByNum(String num);
}
