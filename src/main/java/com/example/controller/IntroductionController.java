package com.example.controller;

import com.example.common.JavaWebToken;
import com.example.common.R;
import com.example.config.AuthenticatedUserContainer;
import com.example.domain.Introduction;
import com.example.service.impl.IntroductionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/Intro")
public class IntroductionController {
    @Autowired
    private IntroductionServiceImpl introductionService;
    @Autowired
    private JavaWebToken javaWebToken;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @GetMapping
    public ResponseEntity<R> getIntro(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        String num = AuthenticatedUserContainer.getAuthenticatedUser(token);
        AuthenticatedUserContainer.removeAuthenticatedUser(token);
        return ResponseEntity.ok().body(new R().success("Successful").add("num",num));
    }
    @PutMapping("/update")
    public ResponseEntity<R> updateIntro(@RequestBody Introduction introduction){
        if(introduction != null){
            return null;
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new R().error("Invalid introduction"));
        }
    }
}
