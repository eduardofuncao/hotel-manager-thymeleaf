package br.com.fiap.hotel_manager.controller.view;

import br.com.fiap.hotel_manager.controller.dto.ReservationDTO;
import br.com.fiap.hotel_manager.controller.dto.RoomDTO;
import br.com.fiap.hotel_manager.service.ReservationService;
import br.com.fiap.hotel_manager.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservations")
public class ReservationViewController {

    private final ReservationService reservationService;
    private final RoomService roomService;

    public ReservationViewController(ReservationService reservationService, RoomService roomService) {
        this.reservationService = reservationService;
        this.roomService = roomService;
    }

    //TODO create reservationService.getAllReservationsDetails which returns a dto specifically to fill the reservations table
    @GetMapping
    public String reservations(Model model) {
        model.addAttribute("reservations", reservationService.getAllReservations());
        return "reservation/index";
    }

    @GetMapping("/new/roomid/{id}")
    public String newReservations(@PathVariable Long id, Model model) {
        ReservationDTO reservationDTOtoAdd = new ReservationDTO();
        reservationDTOtoAdd.setRoomId(id);
        model.addAttribute("reservation", reservationDTOtoAdd);
        return "reservation/reservation-form";
    }

    @PostMapping("/new")
    public String submitForm(@ModelAttribute("reservation") ReservationDTO reservationDTO) {
        reservationService.saveReservation(reservationDTO);
        RoomDTO roomDTO = roomService.getRoomById(reservationDTO.getRoomId());
        return "redirect:/hotels/" + roomDTO.getHotelId() + "/details";
    }


    @GetMapping("/{id}/cancel")
    public String cancelReservation(@PathVariable Long id) {
        reservationService.deleteReservationById(id);
        return "redirect:/reservations";
    }
}
