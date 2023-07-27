package com.example.service;

import com.example.domain.Affair;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface AffairService {
    public List<Affair> getAffairs(String num);
    public void save(Affair affair);
    public void update(Affair affair);
    public void delete(Integer id);
}
