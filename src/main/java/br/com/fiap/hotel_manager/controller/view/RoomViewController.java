package br.com.fiap.hotel_manager.controller.view;

import br.com.fiap.hotel_manager.controller.dto.HotelDTO;
import br.com.fiap.hotel_manager.controller.dto.RoomDTO;
import br.com.fiap.hotel_manager.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rooms")
public class RoomViewController {


    private final RoomService roomService;

    public RoomViewController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/new/hotelid/{id}")
    public String newRoom(@PathVariable Long id, Model model) {
        RoomDTO roomDTOtoAdd = new RoomDTO();
        roomDTOtoAdd.setHotelId(id);
        model.addAttribute("room", roomDTOtoAdd);
        return "room/room-form";
    }

    @PostMapping("/new")
    public String submitForm(@ModelAttribute("room") @Valid RoomDTO roomDTO) {
        roomService.saveRoom(roomDTO);
        return "redirect:/hotels/" + roomDTO.getHotelId() + "/details";
    }
}
