package com.example.controller;

import com.example.common.R;
import com.example.config.AuthenticatedUserContainer;
import com.example.domain.AffairHis;
import com.example.service.impl.AffairHisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/affairsHis")
public class AffairHisController {
    @Autowired
    private AffairHisServiceImpl affairHisServiceImpl;
    @GetMapping()
    public ResponseEntity<R> getAll(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        String num = AuthenticatedUserContainer.getAuthenticatedUser(token);
        List<AffairHis> lis = affairHisServiceImpl.getAll(num);
        return ResponseEntity.ok().body(new R().success("Successful").add("lis",lis));
    }
}
