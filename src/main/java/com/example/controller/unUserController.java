package com.example.controller;

import com.example.common.JavaWebToken;
import com.example.common.R;
import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注册页面
 */
@RestController
@RequestMapping("/user")
public class unUserController {
    @Autowired
    private JavaWebToken javaWebToken;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<R> register(@RequestBody User user){
        long time = 1000 * 60 * 60 * 24;
        if(userService.have(user)){
            return ResponseEntity.ok().body(new R().error("This user already exists"));
        }else{
            userService.toSave(user);
            String token = javaWebToken.makeToken(user.getUsername(), user.getAccount(),time);
//               stringRedisTemplate.opsForValue().set(token,user.getUsername(),time, TimeUnit.MILLISECONDS);
            return ResponseEntity.ok().body(new R().success("Successful token creation").add("token",token));
        }
    }
}
