package com.example.controller;

import com.example.common.JavaWebToken;
import com.example.common.R;
import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 登录界面
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private JavaWebToken javaWebToken;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private UserService userService;

    @PostMapping("/login")//生成token
    public ResponseEntity<R> login(@RequestBody User user){
        long time = 1000 * 60 * 60 * 24;
        if (user != null) {
                // 判断登录账号密码是否正确
            if (userService.validateUser(user.getNum(), user.getPassword())) {
                String token = javaWebToken.makeToken(user.getNum(), user.getAccount(), user.getPassword(),time);
//               stringRedisTemplate.opsForValue().set(token,user.getUsername(),time, TimeUnit.MILLISECONDS);
                return ResponseEntity.ok().body(new R().success("Successful token creation").add("token",token));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new R().error("Invalid username or password"));
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new R().error("Invalid username"));
        }
    }

}
