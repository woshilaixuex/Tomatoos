package com.example.controller;

import com.example.common.R;
import com.example.config.AuthenticatedUserContainer;
import com.example.domain.Frequency;
import com.example.domain.FrequencyHis;
import com.example.service.impl.FrequencyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/freHis")
public class FrequencyController {
    @Autowired
    private FrequencyServiceImpl frequencyService;
    @GetMapping()
    public ResponseEntity<R> getByNumFreHis(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        String num = AuthenticatedUserContainer.getAuthenticatedUser(token);
        AuthenticatedUserContainer.removeAuthenticatedUser(token);
        List<FrequencyHis> lis = frequencyService.getByNumHis(num);
        return ResponseEntity.ok().body(new R().success("获取成功").add("lis",lis));
    }
    @PostMapping()
    public ResponseEntity<R> saveFrequencyHis(HttpServletRequest request,@RequestBody FrequencyHis frequencyHis){
        String token = request.getHeader("Authorization");
        String num = AuthenticatedUserContainer.getAuthenticatedUser(token);
        AuthenticatedUserContainer.removeAuthenticatedUser(token);
        if(frequencyService.saveFrequencyHis(frequencyHis)){
            Frequency frequency = frequencyService.getByNumFrequency(num);
            int clock = frequency.getClock_f();
            clock++;
            frequency.setClock_f(clock);
            frequencyService.updateFrequency(frequency);
            return  ResponseEntity.ok().body(new R().success("打卡成功"));
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new R().error("今日已打卡"));
        }
    }
    @GetMapping("/all")
    public ResponseEntity<R> getFrequency(){
        List<Frequency> lis = frequencyService.getAllFrequency();
        return  ResponseEntity.ok().body(new R().success("获取成功").add("lis",lis));
    }
}
