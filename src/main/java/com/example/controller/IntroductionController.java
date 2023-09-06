package com.example.controller;

import com.example.common.R;
import com.example.config.AuthenticatedUserContainer;
import com.example.domain.Introduction;
import com.example.service.impl.IntroductionServiceImpl;
import com.example.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/Intro")
public class IntroductionController {
    @Autowired
    private IntroductionServiceImpl introductionServiceImpl;
    @GetMapping
    public ResponseEntity<R> getIntro(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        String num = AuthenticatedUserContainer.getAuthenticatedUser(token);
        AuthenticatedUserContainer.removeAuthenticatedUser(token);
        Introduction introduction = introductionServiceImpl.getByNum(num);
        return ResponseEntity.ok().body(new R().success("获取成功").add("introduction",introduction));
    }
    @PutMapping
    public ResponseEntity<R> upIntro(HttpServletRequest request,@RequestBody Introduction introduction){
        String token = request.getHeader("Authorization");
        String num = AuthenticatedUserContainer.getAuthenticatedUser(token);
        AuthenticatedUserContainer.removeAuthenticatedUser(token);
        introductionServiceImpl.update(introduction);
        return ResponseEntity.ok().body(new R().success("更改成功").add("introduction",introduction));
    }
    @PutMapping("/uploadava")
    public ResponseEntity<R> uploadAva(MultipartFile file,HttpServletRequest request) throws IOException {
        String token = request.getHeader("Authorization");
        String num = AuthenticatedUserContainer.getAuthenticatedUser(token);
        AuthenticatedUserContainer.removeAuthenticatedUser(token);
        if(file.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new R().error("上传失败"));
        }
        String filePath = UploadUtil.uploadImageAva(file);
        Introduction nintroduction = introductionServiceImpl.getByNum(num);
        nintroduction.setAva_image(filePath);
        introductionServiceImpl.update(nintroduction);
        return ResponseEntity.ok().body(new R().success("上传成功").add("filePath",filePath));
    }
    @PutMapping("/uploadback")
    public ResponseEntity<R> uploadBack(MultipartFile file,HttpServletRequest request) throws IOException {
        String token = request.getHeader("Authorization");
        String num = AuthenticatedUserContainer.getAuthenticatedUser(token);
        AuthenticatedUserContainer.removeAuthenticatedUser(token);
        if(file.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new R().error("上传失败"));
        }
        String filePath = UploadUtil.uploadImageBack(file);

        Introduction nintroduction = introductionServiceImpl.getByNum(num);
        System.out.println(nintroduction);
        nintroduction.setBack_image(filePath);
        introductionServiceImpl.update(nintroduction);
        return ResponseEntity.ok().body(new R().success("上传成功").add("filePath",filePath));
    }
}
