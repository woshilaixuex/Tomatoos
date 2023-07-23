package com.example.controller;

import com.example.domain.Introduction;
import com.example.service.impl.IntroductionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Intro")
public class IntroductionController {
    @Autowired
    private IntroductionServiceImpl introductionService;
    @PostMapping("/update")
    public Introduction updateIntro(Introduction introduction){

    }
}
