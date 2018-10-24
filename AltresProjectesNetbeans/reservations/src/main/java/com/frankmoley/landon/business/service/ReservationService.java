/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frankmoley.landon.business.service;

import com.frankmoley.landon.business.domain.RoomReservation;
import com.frankmoley.landon.data.entity.Guest;
import com.frankmoley.landon.data.entity.Reservation;
import com.frankmoley.landon.data.entity.Room;
import com.frankmoley.landon.data.repository.GuestRepository;
import com.frankmoley.landon.data.repository.ReservationRepository;
import com.frankmoley.landon.data.repository.RoomRepository;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    
    private RoomRepository roomRepository;
    private GuestRepository guestRepository;
    private ReservationRepository reservationRepository;
    
    @Autowired
    public ReservationService(RoomRepository roomRep, GuestRepository gstRep, ReservationRepository resRep) {
        roomRepository = roomRep;
        guestRepository = gstRep;
        reservationRepository = resRep;
    }
    
    public List<RoomReservation> getRoomReservationsforDate(String dateString) {
        Date date = this.createDateFromDateString(dateString);
        Iterable<Room> rooms = this.roomRepository.findAll();
        Map<Long, RoomReservation> roomReservationMap = new HashMap<>();
        
        rooms.forEach(room->{
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomID(room.getId());
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomNumber(room.getNumber());
            roomReservationMap.put(room.getId(), roomReservation);
        });
        
        Iterable<Reservation> reservations = reservationRepository.findByDate(new java.sql.Date(date.getTime()));
        if(null != reservations) {
            reservations.forEach(reservation->{
                //findOne ya no sirve, lo "reemplaza" findById(foobar.getId()).orElse(null)
                //Guest guest = this.guestRepository.findOne(reservation.getGuestId());
                Guest guest = this.guestRepository.findById(reservation.getGuestId()).orElse(null);
                if (null != guest) {
                    RoomReservation roomReservation = roomReservationMap.get(reservation.getId());
                    roomReservation.setDate(date);
                    roomReservation.setFirstName(guest.getFirstName());
                    roomReservation.setLastName(guest.getLastName());
                    roomReservation.setGuestID(guest.getId());
                }
            });
        }
        List<RoomReservation> roomReservations = new ArrayList<>();
        for (long roomId:roomReservationMap.keySet()) {
            roomReservations.add(roomReservationMap.get(roomId));
        }
        return roomReservations;
    }

    private Date createDateFromDateString(String dateString) {
        Date date = null;
        if (null!=dateString) {
            try {
                date=DATE_FORMAT.parse(dateString);
            }catch(ParseException pe){date = new Date();}
        }
        else {date = new Date();}
        
        return date;
    }
}
