package com.example.controller;

import com.example.common.JavaWebToken;
import com.example.common.R;
import com.example.domain.Frequency;
import com.example.domain.Introduction;
import com.example.domain.User;
import com.example.service.IntroductionService;
import com.example.service.UserService;
import com.example.service.impl.AffairServiceImpl;
import com.example.service.impl.FrequencyServiceImpl;
import com.example.service.impl.IntroductionServiceImpl;
import com.example.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 注册页面
 */
@RestController
@RequestMapping("/unuser")
public class unUserController {
    @Autowired
    private JavaWebToken javaWebToken;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private IntroductionServiceImpl introductionServiceImpl;
    @Autowired
    private FrequencyServiceImpl frequencyService;
    @PostMapping("/register")
    public ResponseEntity<R> register(@RequestBody User user){
        long time = 1000 * 60 * 60 * 24;
        if(userServiceImpl.have(user)){
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new R().error("This user already exists"));
        }else{
            userServiceImpl.toSave(user);
            Introduction introduction = new Introduction();
            Frequency frequency = new Frequency();
            frequency.setNum(user.getNum());
            frequency.setClock_f(0);
            introduction.setNum(user.getNum());
            introduction.setUsername(user.getNum());
            introductionServiceImpl.toSave(introduction);
            frequencyService.saveFrequency(frequency);
            String token = javaWebToken.makeToken(user,time);
            stringRedisTemplate.opsForValue().set(user.getNum(),token,time, TimeUnit.MILLISECONDS);
            return ResponseEntity.ok().body(new R().success("Successful token creation").add("token",token));
        }
    }
}
