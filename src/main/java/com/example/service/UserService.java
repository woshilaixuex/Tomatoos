package com.example.service;

import com.example.domain.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {
    public boolean validateUser(String num,String password);

    public void toSave(User user);
    public boolean have(User user);
    public Integer getAccount(String num);
}
