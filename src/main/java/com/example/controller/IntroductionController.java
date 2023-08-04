package com.example.controller;

import com.example.common.JavaWebToken;
import com.example.common.R;
import com.example.config.AuthenticatedUserContainer;
import com.example.domain.Introduction;
import com.example.service.impl.IntroductionServiceImpl;
import com.example.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

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
    @PostMapping("/upload")
    public ResponseEntity<R> upload(MultipartFile file) throws IOException {
        if(file.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new R().error("上传失败"));
        }
        String filePath = UploadUtil.uploadImage(file);
        return ResponseEntity.ok().body(new R().success("Successful token creation").add("filePath",filePath));
    }
}
