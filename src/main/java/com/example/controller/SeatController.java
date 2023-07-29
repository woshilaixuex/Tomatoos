package com.example.controller;

import com.example.common.R;
import com.example.config.AuthenticatedUserContainer;
import com.example.domain.Seat;
import com.example.service.impl.SeatServiceImpl;
import com.example.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/seat")
public class SeatController {
    @Autowired
    private SeatServiceImpl seatServiceImpl;
    @Autowired
    private UserServiceImpl userServiceImpl;
    @GetMapping()
    public ResponseEntity<R> getSeat(){
        List<Seat> lis = seatServiceImpl.getAll();
        return ResponseEntity.ok().body(new R().success("Successful").add("lis",lis));
    }
    @PostMapping()
    public ResponseEntity<R> saveSeat(HttpServletRequest request,Seat seat){
        String token = request.getHeader("Authorization");
        String num = AuthenticatedUserContainer.getAuthenticatedUser(token);
        int ac = userServiceImpl.getAccount(num);
        if(ac == 2){
            seatServiceImpl.save(seat);
            return ResponseEntity.ok().body(new R().success("Successful").add("seat",seat));
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new R().error("permissions are not sufficient"));
        }
    }
    @GetMapping("/acc")
    public ResponseEntity<R> getAccount(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        String num = AuthenticatedUserContainer.getAuthenticatedUser(token);
        int ac = userServiceImpl.getAccount(num);
        return ResponseEntity.ok().body(new R().success("Successful").add("account",ac));
    }
    @PutMapping()
    public ResponseEntity<R> upSeat(HttpServletRequest request,Seat seat){
        String token = request.getHeader("Authorization");
        String num = AuthenticatedUserContainer.getAuthenticatedUser(token);
        int ac = userServiceImpl.getAccount(num);
        if(ac == 2){
            seatServiceImpl.update(seat);
            return ResponseEntity.ok().body(new R().success("Successful").add("seat",seat));
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new R().error("permissions are not sufficient"));
        }
    }
}
