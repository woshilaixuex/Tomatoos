package com.example.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {
    public boolean validateUser(String id,String password);
}
