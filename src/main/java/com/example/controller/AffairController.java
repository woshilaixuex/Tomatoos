package com.example.controller;


import com.example.common.R;
import com.example.config.AuthenticatedUserContainer;
import com.example.domain.Affair;
import com.example.domain.AffairHis;
import com.example.service.impl.AffairHisServiceImpl;
import com.example.service.impl.AffairServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/affairs")
public class AffairController {
    @Autowired
    private AffairServiceImpl affairServiceimpl;
    @Autowired
    private AffairHisServiceImpl affairHisServiceimpl;

    @GetMapping()
    public ResponseEntity<R> getAffair(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        String num = AuthenticatedUserContainer.getAuthenticatedUser(token);
        List<Affair> lis = affairServiceimpl.getAffairs(num);
        return ResponseEntity.ok().body(new R().success("Successful get").add("lis",lis));
    }
    @PostMapping()
    public ResponseEntity<R> saveAffair(HttpServletRequest request, Affair affair){
        String token = request.getHeader("Authorization");
        String num = AuthenticatedUserContainer.getAuthenticatedUser(token);
        affair.setNum(num);
        affairServiceimpl.save(affair);
        return  ResponseEntity.ok().body(new R().success("Successful create").add("affair",affair));
    }
    @PostMapping("/his")
    public ResponseEntity<R> saveAffairHis(HttpServletRequest request, AffairHis affairHis){
        String token = request.getHeader("Authorization");
        String num = AuthenticatedUserContainer.getAuthenticatedUser(token);
        affairHisServiceimpl.save(affairHis);
        return  ResponseEntity.ok().body(new R().success("Successful create").add("affairHis",affairHis));
    }
    @PutMapping()
    public ResponseEntity<R> update(HttpServletRequest request, Affair affair){
        String token = request.getHeader("Authorization");
        String num = AuthenticatedUserContainer.getAuthenticatedUser(token);
        affair.setNum(num);
//        int open = affair.getOpen();
        affairServiceimpl.update(affair);
        return  ResponseEntity.ok().body(new R().success("Successful update").add("affair",affair));
    }
    @DeleteMapping()
    public ResponseEntity<R> delete(HttpServletRequest request, Affair affair){
        String token = request.getHeader("Authorization");
        String num = AuthenticatedUserContainer.getAuthenticatedUser(token);
        affair.setNum(num);
        int id = affair.getId();
        affairServiceimpl.delete(id);
        return ResponseEntity.ok().body(new R().success("Successful delete"));
    }
}
