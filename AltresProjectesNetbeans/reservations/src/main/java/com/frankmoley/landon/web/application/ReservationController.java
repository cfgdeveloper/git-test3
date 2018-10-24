
package com.frankmoley.landon.web.application;

import com.frankmoley.landon.business.domain.RoomReservation;
import com.frankmoley.landon.business.service.ReservationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    
    @RequestMapping(method=RequestMethod.GET)
    public String getReservations(@RequestParam(value="date", required=false) String dateString, Model model) {

        List<RoomReservation> roomReservationList = this.reservationService.getRoomReservationsforDate(dateString);
        model.addAttribute("roomReservations", roomReservationList);
        return "reservations";
    }
}
