package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.domain.User;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    public boolean validateUser(String id,String Tpassword){
        User user = userDao.User_getById(id);
        if(user == null){
            log.info("未存在该用户");
            return false;
        }else {
            String password = user.getPassword();
            if (password.equals(Tpassword)) {
                return true;
            } else {
                return false;
            }
        }
    }
    public void toSave(User user){
        userDao.User_save(user);
    }
    public boolean have(User Tuser){
        User user = userDao.User_getById(Tuser.getId());
        if(user == null){
            return false;
        }else{
            return true;
        }
    }
}
