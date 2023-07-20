package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    public boolean validateUser(String id,String Tpassword){
        User user = userDao.getById(id);
        String password = user.getPassword();
        if(password.equals(Tpassword)){
            return true;
        }else{
            return false;
        }
    }
}
