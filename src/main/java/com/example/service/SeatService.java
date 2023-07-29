package com.example.service;

import com.example.domain.Seat;

import java.util.List;

public interface SeatService {
    public void save(Seat seat);
    public List<Seat> getAll();
    public void update(Seat seat);
    public void delete(Integer id);
}
