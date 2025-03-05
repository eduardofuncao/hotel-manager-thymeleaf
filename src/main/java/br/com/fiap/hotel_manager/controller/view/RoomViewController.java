package br.com.fiap.hotel_manager.controller.view;

import br.com.fiap.hotel_manager.controller.dto.HotelDTO;
import br.com.fiap.hotel_manager.controller.dto.RoomDTO;
import br.com.fiap.hotel_manager.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rooms")
public class RoomViewController {


    private final RoomService roomService;

    public RoomViewController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/new")
    public String newRoom(Model model) {
        model.addAttribute("room", new RoomDTO());
        return "room/room-form";
    }

    @PostMapping("/new")
    public String submitForm(@ModelAttribute("room") RoomDTO roomDTO) {
        roomService.saveRoom(roomDTO);
        return "redirect:/hotels/" + roomDTO.getId() + "/details";
    }
}
