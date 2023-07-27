package com.example.service;

import com.example.domain.AffairHis;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface AffairHisService {
    public List<AffairHis> getAll(String num);
    public void save(AffairHis affairHis);
}
