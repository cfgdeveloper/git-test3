
package com.landonhotel.demo.business.service;

import com.landonhotel.demo.business.domain.RoomReservation;
import com.landonhotel.demo.data.entity.Guest;
import com.landonhotel.demo.data.entity.Reservation;
import com.landonhotel.demo.data.entity.Room;
import com.landonhotel.demo.data.repository.GuestRepository;
import com.landonhotel.demo.data.repository.ReservationRepository;
import com.landonhotel.demo.data.repository.RoomRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    private RoomRepository roomRepository;
    private GuestRepository guestRepository;
    private ReservationRepository reservationRepository;
    
    @Autowired
    public ReservationService(RoomRepository roomRep, GuestRepository gstRep, ReservationRepository resRep) {
        roomRepository = roomRep;
        guestRepository = gstRep;
        reservationRepository = resRep;
    }
    
    public List<RoomReservation> getRoomReservationsforDate(Date date) {
        Iterable<Room> rooms = this.roomRepository.findAll();
        Map<Long, RoomReservation> roomReservationMap = new HashMap<>();
        
        rooms.forEach(room->{
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomID(room.getId());
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
}
