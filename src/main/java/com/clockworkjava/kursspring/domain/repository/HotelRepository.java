package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Hotel;
import com.clockworkjava.kursspring.utils.Ids;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
@Repository
public class HotelRepository {
    Random rand = new Random();

            Map<Integer,Hotel> hotels = new HashMap<>();


public void createHotel(String name) {
        int newId = Ids.generateNewId(hotels.keySet());
        Hotel newHotel = new Hotel(name);
        hotels.put(newId, newHotel);
        }

public List<Hotel> getAll() {
        return  new ArrayList<>(hotels.values());
        }

public void deleteHotel(Hotel hotel) {
        hotels.remove(hotel.getId());
        }

@PostConstruct
public void init() {
    createHotel("zalesie" );
    createHotel("Legionowo" );
    createHotel("Zaodrze" );
        }

@Override
public String toString() {
        return "QuestRepository{" +
        "quests=" + hotels +
        '}';
        }

public void update(Hotel hotel) {
        hotels.put(hotel.getId(),hotel);
        }

public Hotel getHotel(Integer id) {
        return hotels.get(id);
        }
        }
