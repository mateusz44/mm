package com.clockworkjava.kursspring.services;

import com.clockworkjava.kursspring.domain.Hotel;
import com.clockworkjava.kursspring.domain.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;
    public List<Hotel> getAllHotels(){
        return hotelRepository.getAll();
    }
}
