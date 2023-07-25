package com.example.controller;

import com.example.common.JavaWebToken;
import com.example.common.R;
import com.example.domain.Introduction;
import com.example.service.impl.IntroductionServiceImpl;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<R> checkToken(@PathVariable String token){
        if(token != null){
            String storedToken = stringRedisTemplate.opsForValue().get("token");
            if(storedToken.equals(token)){
                Claims claims = javaWebToken.parseToken(token);
                String num = claims.get("num",String.class);
                Introduction introduction = introductionService.getByNum(num);
                return ResponseEntity.ok().body(new R().success("Success").add("introduction",introduction));
            }else{
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new R().error("Invalid member"));
            }
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new R().error("Invalid token"));
        }
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
