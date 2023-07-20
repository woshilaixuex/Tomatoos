package com.example.controller;

import com.example.common.JavaWebToken;
import com.example.common.R;
import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private JavaWebToken javaWebToken;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<R> login(@RequestBody User user){
        long time = 1000 * 60 * 60 *24;
        if (user != null) {
            // 判断登录账号密码是否正确
            if (userService.validateUser(user.getUsername(), user.getPassword())) {
                String token = javaWebToken.makeToken(user.getUsername(), user.getAccount());
//                stringRedisTemplate.opsForValue().set(token,user.getUsername(),time, TimeUnit.MILLISECONDS);
                return ResponseEntity.ok().body(new R().add("token", token));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new R().error("Invalid username or password"));
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new R().error("Invalid username"));
        }
    }
}
