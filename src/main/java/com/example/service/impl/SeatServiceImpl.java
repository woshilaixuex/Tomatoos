package com.example.service.impl;

import com.example.dao.SeatDao;
import com.example.domain.Seat;
import com.example.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    private SeatDao seatDao;

    @Override
    public void save(Seat seat) {
        seatDao.save(seat);
    }

    @Override
    public List<Seat> getAll() {
        return seatDao.getAll();
    }

    @Override
    public void update(Seat seat) {
        seatDao.update(seat);
    }

    @Override
    public void delete(Integer id) {
        seatDao.delete(id);
    }
}
